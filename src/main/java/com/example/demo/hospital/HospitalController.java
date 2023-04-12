package com.example.demo.hospital;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
