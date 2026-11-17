package com.SpringBootProject.MyHospitalManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department Name is required")
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String departmentName;

    @ToString.Exclude
    @JoinTable(
            name = "department_doctors",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    List<Doctor> doctors = new ArrayList<>();

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Doctor headDoctor;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<Nurse> nurses = new ArrayList<>();
}
