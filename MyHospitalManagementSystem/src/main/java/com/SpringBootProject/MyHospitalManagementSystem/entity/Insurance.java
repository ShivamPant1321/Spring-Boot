package com.SpringBootProject.MyHospitalManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insurance name is required")
    @Size(max = 20, message = "Insurance name cannot exceed 20 characters")
    @Column(nullable = false)
    private String insuranceName;

    @NotNull(message = "Validity is required")
    @Future(message = "Insurance validity date must be in the future")
    @Column(nullable = false)
    private LocalDate validUpto;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "insurance")
    @ToString.Exclude
    private Patient patient;
}
