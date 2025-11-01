package com.ElectronicsService.Electronic.Service.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private Double totalAmount;
    private LocalDateTime generatedDate = LocalDateTime.now();
    private String paymentStatus = "Pending"; // Paid / Pending
}
