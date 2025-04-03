package com.pm.patiente_service.mapper;

import java.time.LocalDate;

import com.pm.patiente_service.dto.PatientRequestDTO;
import com.pm.patiente_service.dto.PatientResponseDTO;
import com.pm.patiente_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patiendDTO = new PatientResponseDTO(patient.getId().toString(),patient.getName(),patient.getEmail(),patient.getAddress(),patient.getDateOfBirth().toString());
        return patiendDTO;
    }

    public static Patient toModel (PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;
    }
}
