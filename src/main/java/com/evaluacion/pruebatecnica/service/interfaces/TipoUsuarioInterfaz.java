package com.evaluacion.pruebatecnica.service.interfaces;

import com.evaluacion.pruebatecnica.entities.TipoUsuario;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioInterfaz<T> {
    List<TipoUsuario> findAllUsersType();

    Optional<T> getUserTypeById(Integer id);
}
