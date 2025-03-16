package org.example.tp2_patient;

import org.example.tp2_patient.entites.Patient;
import org.example.tp2_patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2PatientApplication implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("****************** Ajouter des patients ******************");
        patientRepository.save(new Patient(null,"Rajaa",sdf.parse("12-12-2002") ,false,1));
        patientRepository.save(new Patient(null,"Kenza",sdf.parse("19-07-1999") ,true,4));
        patientRepository.save(new Patient(null,"Rekia",sdf.parse("02-08-2004") ,true,4));
        System.out.println("****************** Consulter tous les patients ******************");
        List<Patient> patients=patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("****************** Consulter un patient ******************");
        Patient patient=patientRepository.findById(Long.valueOf(1)).get();
        System.out.println(patient.getId());
        System.out.println(patient.getNom());
        System.out.println(patient.getDateNaissane());
        System.out.println(patient.getMalade());
        System.out.println(patient.getScore());

        System.out.println("****************** Mettre à jour un patient ******************");
        Patient newPatient=new Patient(null,"RABIH",sdf.parse("12-12-2002") ,false,1);
        Patient patientOld= patientRepository.findById(Long.valueOf(1)).map(p -> {
            p.setNom(newPatient.getNom());
            p.setDateNaissane(newPatient.getDateNaissane());
            p.setMalade(newPatient.getMalade());
            p.setScore(newPatient.getScore());
             return patientRepository.save(p);
        }).orElse(null);

        System.out.println("Nouveau Patient "+patientOld);

        System.out.println("****************** Supprimer un patient ******************");
        patientRepository.deleteById(Long.valueOf(2));

        System.out.println("******************Chercher des patients par nom ******************");


    }



}
