package cl.byron.pacientes.service;

import org.springframework.stereotype.Service;

import cl.byron.pacientes.dto.PacienteResponseDTO;
import cl.byron.pacientes.model.Paciente;
import cl.byron.pacientes.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteResponseDTO obtenerPorId(Long id){

        Paciente paciente = pacienteRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Paciente no encontrado"));

        PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO();

        pacienteResponseDTO.setId(paciente.getId());
        pacienteResponseDTO.setName(paciente.getName());
        pacienteResponseDTO.setDocumento(paciente.getDocumento());
        pacienteResponseDTO.setFechaNacimiento(paciente.getFechaNacimiento());

        return pacienteResponseDTO;    
    }

    public Paciente guardar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

}
