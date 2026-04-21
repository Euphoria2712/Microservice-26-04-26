package com.paciente_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.paciente_service.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    Optional<Paciente> findByDocumento(String documento);
    boolean exiexistsByDocumento(String documento);
    int councountByDocumento(String documento);
}
