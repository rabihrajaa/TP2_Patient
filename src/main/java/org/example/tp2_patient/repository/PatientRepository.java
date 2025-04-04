package org.example.tp2_patient.repository;

import org.example.tp2_patient.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
        //nom commence par..
        List<Patient> findByNomStartingWith(String prefixe);
        //nom contient la chaine de caractere..
        List<Patient> findByNomContaining(String nom);
        //nom fini par suffixe..
        List<Patient> findPatientByNomEndingWith(String suffixe);
        //Trouve exactement un patient avec ce nom:
        Patient findPatientByNom(String nom);
        //Recherche insensible à la casse
        Patient findPatientByNomIgnoreCase(String nom);
        //insensible à la casse avec contient
        List<Patient> findPatientByNomContainingIgnoreCase(String nom);
}
