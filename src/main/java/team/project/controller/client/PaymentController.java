package team.project.controller.client;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class PaymentController {

    @RequestMapping("/payment")
    public String payment(@RequestParam(value = "totalPrice") int totalPrice,
                          @RequestParam(value = "vaccineID") int vaccineID) throws UnsupportedEncodingException {

        // Thông tin thanh toán
        String vnp_TmnCode = "W4YV410E";
        String vnp_HashSecret = "I54A2HLE6VI0BDRNR34IAKTJG9VORIMB";
        String vnp_Url = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"; // URL VNPay (sandbox)

        // URL callback trả về sau khi thanh toán
        String vnp_ReturnUrl = "http://localhost:8080/thank-you?vaccineID=" + vaccineID;

        // Tạo tham số cho request đến VNPay
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", "2.1.0");
        vnp_Params.put("vnp_Command", "pay");
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(totalPrice * 100)); // Số tiền (VNĐ)
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_TxnRef", String.valueOf(System.currentTimeMillis())); // Mã giao dịch (unique)
        vnp_Params.put("vnp_OrderInfo", "Thanh toan hoa don");
        vnp_Params.put("vnp_OrderType", "other");
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl); // Gửi vaccineID cùng với URL
        vnp_Params.put("vnp_IpAddr", "127.0.0.1");

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        // Tạo URL query string
        List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        for (String fieldName : fieldNames) {
            String fieldValue = vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                // Build hashData
                if (hashData.length() > 0) {
                    hashData.append("&");
                }
                hashData.append(fieldName);
                hashData.append("=");
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));

                // Build query
                if (query.length() > 0) {
                    query.append("&");
                }
                query.append(fieldName);
                query.append("=");
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
            }
        }

        // Tạo chữ ký bảo mật (hashData)
        String vnp_SecureHash = hmacSHA512(vnp_HashSecret, hashData.toString());
        query.append("&vnp_SecureHash=").append(vnp_SecureHash);

        // Chuyển hướng đến URL thanh toán của VNPay
        String paymentUrl = vnp_Url + "?" + query.toString();
        return "redirect:" + paymentUrl;
    }


    @RequestMapping("/thank-you")
    public String vnpayReturn(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        Map<String, String> vnp_Params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            vnp_Params.put(entry.getKey(), entry.getValue()[0]);
        }

        // Nhận vaccineID từ request
        String vaccineID = request.getParameter("vaccineID");
        System.out.println("Vaccine ID: " + vaccineID);

        // Kiểm tra chữ ký bảo mật
        String vnp_SecureHash = request.getParameter("vnp_SecureHash");
        vnp_Params.remove("vnp_SecureHash");

        String hashData = vnp_Params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.US_ASCII))
                .collect(Collectors.joining("&"));

        String secureHash = hmacSHA512("I54A2HLE6VI0BDRNR34IAKTJG9VORIMB", hashData);

            String responseCode = vnp_Params.get("vnp_ResponseCode");
            if ("00".equals(responseCode)) {
                model.addAttribute("message", "Giao dịch thành công!");
            } else {
                model.addAttribute("message", "Giao dịch không thành công. Mã lỗi: " + responseCode);
            }

        // Trả vaccineID về trang kết quả
        model.addAttribute("vaccineID", vaccineID);

        return "client/thank-you"; // Trang JSP hiển thị kết quả
    }

    private String hmacSHA512(String key, String data) throws UnsupportedEncodingException {
        try {
            Mac hmac512 = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA512");
            hmac512.init(secretKey);
            byte[] hashBytes = hmac512.doFinal(data.getBytes("UTF-8"));
            return Hex.encodeHexString(hashBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error generating HMAC SHA-512", e);
        }
    }
}
