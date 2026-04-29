package cl.byron.pacientes.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PacienteRequestDTO {

    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento;

    
}
