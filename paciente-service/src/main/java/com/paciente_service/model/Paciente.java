package com.paciente_service.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 2, max = 100, message = "El nombre debe tener minimo 2 caracter y maximo 100")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El documento no puede estar vacio")
    @Pattern(regexp = "\\d{8,12}", message = "El documento debe tener entre 8 y 12 digitos")
    @Column(unique = false)
    private String documento;

    @Past(message = "La fecha de nacimiento debe ser pasada")
    @NotNull(message = "La fecha de nacimiento no debe estar vacia")
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

}
