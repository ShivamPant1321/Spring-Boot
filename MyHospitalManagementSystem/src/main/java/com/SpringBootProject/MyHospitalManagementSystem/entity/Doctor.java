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
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "First name is required")
    @Size(max = 20, message = "First name cannot exceed 20 characters")
    @Column(nullable = false, length = 20)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 20, message = "Last name cannot exceed 20 characters")
    @Column(nullable = false, length = 20)
    private String lastName;

    @Email
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Speciality is required")
    @Column(nullable = false)
    private String specialty;

    @NotNull(message = "Birth date is required")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
    @Column(nullable = false, length = 10, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Appointments> appointmentsList = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(mappedBy = "doctors", fetch = FetchType.LAZY)
    private List<Department>  departmentList = new ArrayList<>();
}
