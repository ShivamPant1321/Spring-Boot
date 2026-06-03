package com.myspringclass.HospitalManagementSystem.repository;

import com.myspringclass.HospitalManagementSystem.dto.GenderResponseEntity;
import com.myspringclass.HospitalManagementSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);  // this is the JPQL method it has a sintax like -> "findBy{your_entity_column_in_camelcase}({dataType} xxx);"
    Patient findByBirthDate(LocalDate birthDate); // returns the first row that matches the parameter

    // we can also use multiple columns as well like:-
    Patient findByNameOrEmail(String name, String email);
//    List<Patient> findByNameOrEmail(String name, String email); // JPQ automatically returns the data according to the return type we specify and it will find all the rows where the name and email matches

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String name);


//    this is the JPQL. it is similar to sql
    @Query("select p from Patient p where p.gender = ?1")
    List<Patient> findByGender(@Param("gender") String gender);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfter(@Param("birthDate") LocalDate date);

    @Query("select p.gender, count(p) from Patient p group by p.gender")
    List<Object[]> countEachGenderType();

//    This is Projection and it cannot be used with native query as it will only work for JPQL
    @Query("select new com.myspringclass.HospitalManagementSystem.dto.GenderResponseEntity(p.gender, count(p)) from Patient p group by p.gender")
    List<GenderResponseEntity> countGenderType();

    // this is the native query where we can write the normal sql
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatient();

    // We have to use @Modifying annotation as it will tell that this query will be modifying database
    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//    Pagination
    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatientPagination(Pageable pageable);


//    @Query("select p from Patient p left join fetch p.appointments a left join fetch a.doctor") // to solve the N+1 query problem
    @Query("select p from Patient p left join fetch p.appointments") // to solve the N+1 query problem
    List<Patient> findAllPatientWithAppointment();

}
