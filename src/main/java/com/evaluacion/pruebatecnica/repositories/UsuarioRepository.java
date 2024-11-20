package com.evaluacion.pruebatecnica.repositories;

import com.evaluacion.pruebatecnica.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Repository
@CrossOrigin(value = "http://localhost:4200")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "Select * from sistema_usuarios su where su.nombre = :name", nativeQuery = true)
    Optional<Usuario> findByName(String name);
}
