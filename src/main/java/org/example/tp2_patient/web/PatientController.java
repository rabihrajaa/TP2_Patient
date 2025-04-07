package org.example.tp2_patient.web;

import lombok.AllArgsConstructor;
import org.example.tp2_patient.entites.Patient;
import org.example.tp2_patient.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,@RequestParam(name="page",defaultValue = "0") int page,
                                    @RequestParam(name="size",defaultValue = "4") int size){
        Page<Patient> pagepatients=patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("ListPatients",pagepatients.getContent());
        return "patients";
    }

}
