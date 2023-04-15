package com.example.demo.doctor;

import com.example.demo.hospital.HospitalRepository;
import org.springframework.stereotype.Controller;

@Controller
public class DoctorController {

    final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository= doctorRepository;
    }

}
