package org.example.tp2_patient;

import org.example.tp2_patient.entites.Patient;
import org.example.tp2_patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

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


//    @Bean
//    CommandLineRunner start(PatientRepository patientRepository){
//        return args -> {
//            patientRepository.save(new Patient(null, "Mohamed",new Date(),false,42));
//            patientRepository.save(new Patient(null, "Imane",new Date(),true,98));
//            patientRepository.save(new Patient(null, "Yassine", new Date(),true,342));
//            patientRepository.save(new Patient(null,"Laila",new Date(),false,123));
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        PasswordEncoder passwordEncoder=passwordEncoder();
        return args ->{
            UserDetails u1=jdbcUserDetailsManager.loadUserByUsername("user11");
            UserDetails u2=jdbcUserDetailsManager.loadUserByUsername("user22");
            UserDetails ad=jdbcUserDetailsManager.loadUserByUsername("admin2");

            if(u1==null)
            jdbcUserDetailsManager.createUser(
                    User.withUsername("user11").password(passwordEncoder.encode("1234")).roles("USER").build()
            );
            if(u2==null)
            jdbcUserDetailsManager.createUser(
                    User.withUsername("user22").password(passwordEncoder.encode("1234")).roles("USER").build()
            );
            if(ad==null)
            jdbcUserDetailsManager.createUser(
                    User.withUsername("admin2").password(passwordEncoder.encode("1234")).roles("ADMIN","USER").build()
            );

        };
    }

    @Override
    public void run(String... args) throws Exception {


       // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

//        System.out.println("****************** Ajouter des patients ******************");
//        patientRepository.save(new Patient(null,"Rajaa",sdf.parse("12-12-2002") ,false,100));
//        patientRepository.save(new Patient(null,"Kenza",sdf.parse("19-07-1999") ,true,200));
//        patientRepository.save(new Patient(null,"Rekia",sdf.parse("02-08-2004") ,true,300));
//
//        System.out.println("****************** Ajouter des patients (utilisant pattern Builder) ******************");
//        Patient patient3=Patient.builder()
//                .id(null)
//                .nom("Iman")
//                .dateNaissane(new Date())
//                .malade(false)
//                .score(120)
//                .build();
//        patientRepository.save(patient3);
//        System.out.println("****************** Consulter tous les patients ******************");
//        List<Patient> patients=patientRepository.findAll();
//        patients.forEach(p->{
//            System.out.println(p.toString());
//        });
//        System.out.println("****************** Consulter un patient ******************");
//        Patient patient=patientRepository.findById(Long.valueOf(1)).get();
//        System.out.println(patient.getId());
//        System.out.println(patient.getNom());
//        System.out.println(patient.getDateNaissane());
//        System.out.println(patient.getMalade());
//        System.out.println(patient.getScore());
//
//        System.out.println("****************** Mettre à jour un patient ******************");
//        Patient newPatient=new Patient(null,"RABIH",sdf.parse("12-12-2002") ,false,1);
//        Patient patientOld= patientRepository.findById(Long.valueOf(1)).map(p -> {
//            p.setNom(newPatient.getNom());
//            p.setDateNaissane(newPatient.getDateNaissane());
//            p.setMalade(newPatient.getMalade());
//            p.setScore(newPatient.getScore());
//             return patientRepository.save(p);
//        }).orElse(null);
//
//        System.out.println("Nouveau Patient "+patientOld);
//
//        System.out.println("****************** Supprimer un patient ******************");
//        patientRepository.deleteById(Long.valueOf(2));
//
//        System.out.println("******************Chercher des patients leurs nom fini par IH ******************");
//        List<Patient> patients2=patientRepository.findPatientByNomEndingWith(String.valueOf("IH"));
//        System.out.println(patients2);
//
//        System.out.println("******************Chercher des patients leurs nom contient ek ******************");
//        List<Patient> patients3=patientRepository.findByNomContaining(String.valueOf("ek"));
//        System.out.println(patients3);
//        System.out.println("******************Chercher des patients par leurs nom utilisant requete ******************");
//        patients3=patientRepository.findByNomContaining(String.valueOf("%ek%"));
//        System.out.println(patients3);



    }



}
