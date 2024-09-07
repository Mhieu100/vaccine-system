<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<aside id="sidebar" class="sidebar">
    <ul class="sidebar-nav" id="sidebar-nav">
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/dashboard">
                <i class="bi bi-people"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/users/">
                <i class="bi bi-people"></i>
                <span>Người dùng</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/patients/">
                <i class="bi bi-people"></i>
                <span>Bệnh nhân</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/doctors/">
                <i class="bi bi-people"></i>
                <span>Bác sĩ</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/receptionists/">
                <i class="bi bi-people"></i>
                <span>Thu ngân</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/vaccines/">
                <i class="bi bi-people"></i>
                <span>Vắc xin</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/schedules/">
                <i class="bi bi-people"></i>
                <span>Lịch tiêm</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/statistics/">
                <i class="bi bi-people"></i>
                <span>Thống kê</span>
            </a>
        </li>
    </ul>
</aside>