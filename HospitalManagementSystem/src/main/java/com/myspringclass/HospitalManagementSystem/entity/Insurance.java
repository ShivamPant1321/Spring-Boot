package com.myspringclass.HospitalManagementSystem.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String policyNumber;

    @Column(nullable = false, length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate createdAt;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate validUntil;

    @OneToOne(mappedBy = "insurance")  //inverse side
    private Patient patient;
}
