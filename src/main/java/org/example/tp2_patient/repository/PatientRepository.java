package org.example.tp2_patient.repository;

import org.example.tp2_patient.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
        List<Patient> findByNomStartingWith(String nom);
}
