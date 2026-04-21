package com.paciente_service.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String documento;
    private LocalDate fechaNacimiento; 

    public PacienteDTO(String nombre, String documento, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
    }

}
