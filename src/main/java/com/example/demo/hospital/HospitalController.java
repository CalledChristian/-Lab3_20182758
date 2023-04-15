package com.example.demo.hospital;

import com.example.demo.doctor.Doctor;
import com.example.demo.doctor.DoctorController;
import com.example.demo.paciente.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value={"/"},method = RequestMethod.GET)
public class HospitalController {

    final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository){
        this.hospitalRepository= hospitalRepository;
    }




    @GetMapping(value={"/","/hospitales"})
    public String listaHospitales (Model model){
        List<Hospital> lista = hospitalRepository.findAll();
        model.addAttribute("listaHospitales",lista);
        return "hospital/lista";
    }

    @GetMapping("/hospitales/mostrardoctores")
    public String listaHospitalesDoctores (Model model, @RequestParam("id") int idHospital){
        List<Doctor> lista_d = hospitalRepository.buscarDoctorPorHospital(idHospital);
        System.out.println(lista_d.get(1));
        model.addAttribute("listaHospitalesDoctores",lista_d);
        //model.addAttribute("nameHospital", nombreHospital);
        return "hospital/listadoctores";
    }

    @GetMapping("/hospitales/mostrarpacientes")
    public String listaHospitalesPacientes (Model model, @RequestParam("id") int idHospital){
        List<Paciente> lista_p = hospitalRepository.buscarPacientePorHospital(idHospital);
        model.addAttribute("listaHospitalesPacientes",lista_p);
        return "hospital/listapacientes";
    }


    /*@GetMapping("/distribuidoras/editar")
    public String editarDistribuidoras(Model model, @RequestParam("id") int id){
        Optional<Distributors> optDistributor = distributorsRepository.findById(id);

        if (optDistributor.isPresent()) {
            Distributors distributor = optDistributor.get();
            model.addAttribute("distribuidor", distributor);
            return "distribuidoras/editar";
        } else {
            return "distribuidoras/lista";
        }

    }

    @GetMapping("/distribuidoras/nuevo")
    public String nuevaDistribuidora(){
        return "distribuidoras/nuevo";
    }

    @PostMapping("/distribuidoras/guardar")
    public String guardarDistribuidora(Distributors distributors){
        distributorsRepository.save(distributors);
        return "redirect:/distribuidoras/lista";
    };

    public String borrarDistribuidora(){
        return "";
    };*/
}
