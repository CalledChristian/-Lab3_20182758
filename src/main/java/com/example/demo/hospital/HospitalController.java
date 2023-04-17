package com.example.demo.hospital;


import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorRepository;
import com.example.demo.paciente.Paciente;
import com.example.demo.paciente.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value={"/"},method = RequestMethod.GET)
public class HospitalController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    public HospitalController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping(value = {"/", "/hospitales"})
    public String listaHospitales(Model model) {
        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("listaHospitales", lista);
        return "hospital/lista";
    }

    @GetMapping("/hospitales/mostrardoctores")
    public String listaHospitalesDoctores(Model model, @RequestParam("id") int idHospital) {
        Optional<Hospital> optHospital = hospitalRepository.findById(idHospital);
        if (optHospital.isPresent()) {
            Hospital hospital1 = optHospital.get();
            //enviamos el hospital para mostrar su nombre en la vista del doctor
            model.addAttribute("hospital", hospital1);
            //Enviamos la lista de doctores para la vista de esta forma.
            List<Doctor> doctorList = doctorRepository.buscarDoctorPorHospital(idHospital);
            model.addAttribute("doctores", doctorList);
            return "hospital/listadoctores";
        } else {
            return "redirect:/hospitales";
        }

    }


    @GetMapping("/hospitales/mostrarpacientes")
    public String listaHospitalesPacientes(Model model, @RequestParam("id") int idHospital) {

        //si podemos repetir nombres de las variables , pero por orden es mejor cmabiarlos.
        Optional<Hospital> optHospital = hospitalRepository.findById(idHospital);
        if (optHospital.isPresent()) {
            Hospital hospital2 = optHospital.get();
            //enviamos el hospital para mostrar su nombre en la vista de pacientes
            model.addAttribute("hospital", hospital2);
            //Enviamos la lista de pacientes para la vista de esta forma.
            List<Paciente> pacientesList = pacienteRepository.buscarPacientePorHospital(idHospital);
            model.addAttribute("pacientes", pacientesList);
            //enviamos el elemento doctor , con ayuda de su repositorio
            model.addAttribute("doctor",doctorRepository);
            return "hospital/listapacientes";
        } else {
            return "redirect:/hospitales";
        }

    }


}