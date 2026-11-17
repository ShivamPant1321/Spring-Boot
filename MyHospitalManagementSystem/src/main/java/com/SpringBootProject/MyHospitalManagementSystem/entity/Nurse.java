package com.SpringBootProject.MyHospitalManagementSystem.entity;

import com.SpringBootProject.MyHospitalManagementSystem.entity.type.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(max = 20, message = "First name cannot exceed 20 characters")
    @Column(nullable = false, length = 20)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 20, message = "Last name cannot exceed 20 characters")
    @Column(nullable = false, length = 20)
    private String lastName;

    @NotNull(message = "Birth date is required")
    @Column(nullable = false)
    @Past(message = "Birth date must be in the past")
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
    @Column(nullable = false, length = 10, unique = true)
    private String phoneNumber;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    @JoinColumn(name = "nurse_id", nullable = false)
    private List<Patient> patientList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @ToString.Exclude
    private Department department;
}
