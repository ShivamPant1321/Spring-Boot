package com.SpringBootProject.MyHospitalManagementSystem.services.serviceImplementation;

import com.SpringBootProject.MyHospitalManagementSystem.dto.PatientDto;
import com.SpringBootProject.MyHospitalManagementSystem.entity.Patient;
import com.SpringBootProject.MyHospitalManagementSystem.repository.PatientRepository;
import com.SpringBootProject.MyHospitalManagementSystem.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDto>  patientDtoList = new ArrayList<>();
        for (Patient patient : patientList) {
            PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
            patientDtoList.add(patientDto);
        }
        return patientDtoList;
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        return modelMapper.map(patient, PatientDto.class);
    }
}
