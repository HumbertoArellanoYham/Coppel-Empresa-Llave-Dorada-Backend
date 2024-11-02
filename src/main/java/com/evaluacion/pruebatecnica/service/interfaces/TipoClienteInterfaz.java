package com.evaluacion.pruebatecnica.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface TipoClienteInterfaz<T> {
    Optional<T> getById(Integer id);

    List<T> findAll();


}
