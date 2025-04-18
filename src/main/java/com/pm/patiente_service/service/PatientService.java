package com.pm.patiente_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pm.patiente_service.dto.PatientRequestDTO;
import com.pm.patiente_service.dto.PatientResponseDTO;
import com.pm.patiente_service.exception.EmailAlreadyExistsException;
import com.pm.patiente_service.exception.PatientNotFoundException;
import com.pm.patiente_service.mapper.PatientMapper;
import com.pm.patiente_service.model.Patient;
import com.pm.patiente_service.repository.PatientRepository;

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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){

        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with email "+ patientRequestDTO.getEmail() + " Already Exists" );
        }

        Patient newPatient = patientRepository.save(
            PatientMapper.toModel(patientRequestDTO)
        );
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient not found with id : "+id));

        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)){
            throw new EmailAlreadyExistsException("A patient with email "+ patientRequestDTO.getEmail() + " Already Exists" );
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updPatient);    
    }

    public void deletePatient (UUID id){
        patientRepository.deleteById(id);
    }

}
