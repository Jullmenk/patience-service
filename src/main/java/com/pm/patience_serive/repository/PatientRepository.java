package com.pm.patience_serive.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.patience_serive.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,UUID> {

}
