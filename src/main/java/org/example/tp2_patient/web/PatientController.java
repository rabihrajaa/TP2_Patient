package org.example.tp2_patient.web;

import lombok.AllArgsConstructor;
import org.example.tp2_patient.entites.Patient;
import org.example.tp2_patient.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> listpatients=patientRepository.findAll();
        model.addAttribute("ListPatients",listpatients);
        return "patients";
    }

}
