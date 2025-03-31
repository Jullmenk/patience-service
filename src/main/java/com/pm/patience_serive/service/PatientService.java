package com.pm.patience_serive.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patience_serive.dto.PatientResponseDTO;
import com.pm.patience_serive.mapper.PatientMapper;
import com.pm.patience_serive.model.Patient;
import com.pm.patience_serive.repository.PatientRepository;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService (PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

}
