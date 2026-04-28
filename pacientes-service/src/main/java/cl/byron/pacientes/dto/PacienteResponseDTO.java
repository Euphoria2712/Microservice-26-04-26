package cl.byron.pacientes.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PacienteResponseDTO {

    private Long id;
    private String name;
    private String documento;
    private LocalDate fechaNacimiento;

}
