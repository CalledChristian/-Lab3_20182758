package com.example.demo.paciente;

import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorRepository;
import com.example.demo.hospital.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller

public class PacienteController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    public PacienteController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping(value={"/pacientes"})
    public String listaPacientes (Model model){
        List<Paciente> lista_p = pacienteRepository.findAll();
        model.addAttribute("listaPacientes",lista_p);
        model.addAttribute("doctor",doctorRepository);
        model.addAttribute("hospital",hospitalRepository);
        return "paciente/lista";
    }

    @GetMapping("/pacientes/editarpaciente")
    public String editarPaciente (Model model, @RequestParam("id") int idPaciente) {
        Optional<Paciente> optPaciente = pacienteRepository.findById(idPaciente);

        if (optPaciente.isPresent()) {
            Paciente paciente1 = optPaciente.get();
            model.addAttribute("paciente", paciente1);
            return "paciente/editarpaciente";
        } else {
            return "redirect:/pacientes";
        }
    }


    @PostMapping("/pacientes/guardar")
    public String guardarPaciente(Paciente paciente , @RequestParam("idPaciente") int idP ,@RequestParam("numHabitacion") int nroabitacion){
            pacienteRepository.actualizarHabitacion(nroabitacion,idP);
            return "redirect:/pacientes";
        }

    }



