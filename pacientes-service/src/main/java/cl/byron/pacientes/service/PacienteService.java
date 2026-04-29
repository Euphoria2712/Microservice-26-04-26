package cl.byron.pacientes.service;

import org.springframework.stereotype.Service;

import cl.byron.pacientes.dto.PacienteRequestDTO;
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
        pacienteResponseDTO.setNombre(paciente.getNombre());
        pacienteResponseDTO.setDocumento(paciente.getDocumento());
        pacienteResponseDTO.setFechaNacimiento(paciente.getFechaNacimiento());

        return pacienteResponseDTO;    
    }


    public PacienteResponseDTO guardar(PacienteRequestDTO pacienteRequestDTO){
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteRequestDTO.getNombre());
        paciente.setDocumento(pacienteRequestDTO.getDocumento());
        paciente.setFechaNacimiento(paciente.getFechaNacimiento());

        Paciente pacienteGuardado = pacienteRepository.save(paciente);

        return mapToResponseDTO(pacienteGuardado);

    
    }
    
   private PacienteResponseDTO mapToResponseDTO(Paciente paciente){
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId());
        dto.setNombre(paciente.getNombre());
        dto.setDocumento(paciente.getDocumento());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());

        return dto;
   }


}
