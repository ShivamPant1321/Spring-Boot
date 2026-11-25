package com.SpringBootProject.MyHospitalManagementSystem.services.serviceImplementation;

import com.SpringBootProject.MyHospitalManagementSystem.dto.NurseDto;
import com.SpringBootProject.MyHospitalManagementSystem.entity.Nurse;
import com.SpringBootProject.MyHospitalManagementSystem.repository.NurseRepository;
import com.SpringBootProject.MyHospitalManagementSystem.services.NurseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {
    private final NurseRepository nurseRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<NurseDto> getAllNurses() {
        List<Nurse> nurses = nurseRepository.findAll();
        List<NurseDto> nurseDtoList = new ArrayList<>();

        for (Nurse nurse : nurses){
            nurseDtoList.add(modelMapper.map(nurse, NurseDto.class));
        }

        return nurseDtoList;
    }

    @Override
    public NurseDto getNurseById(Long id) {
        Nurse nurse = nurseRepository.findById(id).orElseThrow();
        return modelMapper.map(nurse, NurseDto.class);
    }
}
