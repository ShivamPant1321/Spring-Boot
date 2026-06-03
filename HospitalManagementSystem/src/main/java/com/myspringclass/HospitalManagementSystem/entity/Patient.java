package com.myspringclass.HospitalManagementSystem.entity;


import com.myspringclass.HospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birthdate", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;
    private String email;
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType blood_group;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}) // owning side
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)  // when we want to remove the child from the db while keeping the parent then we use orphanRemoval = true
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

//    @ToString.Exclude
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER) // this will cause N+1 problem as for every Patient the Hibernate will use select statement multiple times to fetch all the appointments associated to that patient.
    private List<Appointment> appointments = new ArrayList<>();

}
