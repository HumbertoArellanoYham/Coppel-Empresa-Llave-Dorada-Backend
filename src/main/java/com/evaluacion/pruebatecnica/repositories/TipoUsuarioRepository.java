package com.evaluacion.pruebatecnica.repositories;

import com.evaluacion.pruebatecnica.entities.TipoCliente;
import com.evaluacion.pruebatecnica.entities.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(value = "http://localhost:4200")
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}