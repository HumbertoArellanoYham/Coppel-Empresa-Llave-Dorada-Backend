package com.evaluacion.pruebatecnica.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface ProductoInterfaz<T> {
    List<T> findAllProducts();

    void remove(T t);

    T saveProduct(T t);

    Optional<T> findById(Integer id);

    T updateProduct(T t);

}
