package com.pm.patiente_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.patiente_service.model.Patient;

@Repository
public interface            PatientRepository extends JpaRepository<Patient,UUID> {
    Boolean existsByEmail(String Email);
    Boolean existsByEmailAndIdNot(String Email,UUID id);
}
