package com.pm.patience_serive.mapper;

import com.pm.patience_serive.dto.PatientResponseDTO;
import com.pm.patience_serive.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patiendDTO = new PatientResponseDTO(patient.getId().toString(),patient.getName(),patient.getEmail(),patient.getAddress(),patient.getDateOfBirth().toString());
        return patiendDTO;
    }
}
