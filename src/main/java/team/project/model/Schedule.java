package team.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")

    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")

    Patient patient;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date vaccinationDate;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    Date vaccinationTime;

    @ManyToOne
    @JoinColumn(name = "location_id")

    Location location;

    @ManyToOne
    @JoinColumn(name = "vaccine_id")
    Vaccine vaccine;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;

    public enum Status {
        COMPLETED, NOT_DUE, CANCELLED, LATE;

        @Override
        public String toString() {
            switch (this) {
                case COMPLETED:
                    return "Đã tiêm";
                case NOT_DUE:
                    return "Chưa tới lịch hẹn";
                case CANCELLED:
                    return "Hủy tiêm";
                case LATE:
                    return "Trễ hẹn";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}

