package cl.byron.pacientes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.byron.pacientes.dto.PacienteRequestDTO;
import cl.byron.pacientes.dto.PacienteResponseDTO;
import cl.byron.pacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/api/v1/pacientes")
@RestController
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping("/{id}")
    public PacienteResponseDTO obtenerPaciente(@PathVariable Long id){
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteResponseDTO guardarPaciente(@RequestBody PacienteRequestDTO pacienteResponseDTO){
        return pacienteService.guardar(pacienteResponseDTO);
    }



}   
