package org.example.tp2_patient.web;

import lombok.AllArgsConstructor;
import org.example.tp2_patient.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(){
        System.out.println("page index");
        return "patients";
    }

}
