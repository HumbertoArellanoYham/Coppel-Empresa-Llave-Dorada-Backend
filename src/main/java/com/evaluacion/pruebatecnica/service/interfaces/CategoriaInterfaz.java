package com.evaluacion.pruebatecnica.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface CategoriaInterfaz<T> {
    List<T> findAllCategories();

    Optional<T> getById(Integer id);

}
