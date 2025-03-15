package org.example.tp2_patient.repository;

import org.example.tp2_patient.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
