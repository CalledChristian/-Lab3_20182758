package com.example.demo.doctor;

import com.example.demo.hospital.Hospital;
import com.example.demo.hospital.HospitalRepository;
import com.example.demo.paciente.Paciente;
import com.example.demo.paciente.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DoctorController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    public DoctorController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping(value={"/doctores"})
    public String listaDoctores (Model model){
        List<Doctor> lista = doctorRepository.findAll();
        model.addAttribute("listaDoctores",lista);
        model.addAttribute("hospital",hospitalRepository);
        return "doctor/lista";
    }

    @GetMapping("/doctores/mostrarpacientes")
    public String listaDoctoresPacientes (Model model, @RequestParam("id") int idDoctor){
        List<Paciente> lista_p = pacienteRepository.buscarPacientePorDoctor(idDoctor);
        model.addAttribute("listaDoctoresPacientes",lista_p);
        return "doctor/listapacientes";
    }

    @GetMapping("/doctores/proximascitas")
    public String listaProximasCitas (Model model, @RequestParam("id") int idDoctor){
        List<Paciente> lista_c = pacienteRepository.buscarProximasCitas(idDoctor);
        model.addAttribute("listaProximasCitas",lista_c);
        return "doctor/listaproximascitas";
    }
}
