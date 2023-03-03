package com.eamapp.springweb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eamapp.springweb.models.Estudiante;
import com.eamapp.springweb.models.Profesores;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {
    @GetMapping({ "/", "" })
    public String indexEstudiante(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("titulo", "Perfil");
        model.addAttribute("estudiante", estudiante);
        estudiante.setNombre("Maria Camila");
        estudiante.setApellido("Hincapie");
        estudiante.setEmail("hincapie.maria.6064@eam.edu.co");
        model.addAttribute("cuerpo", "perfil del estudiante: ".concat(estudiante.getNombre()));
        return "estudiante/index";
    }

    @ModelAttribute("profesores")
    public List<Profesores> poblarProfesores(){
        List<Profesores> profesores = Arrays.asList(new Profesores("Alvaro Antonio","Rodriguez","alvaro.rodriguez@eam.edu.co"), new Profesores("Julian Dario","Velez","julian.daria@eam.edu.co"));
        return profesores;
    }
}
