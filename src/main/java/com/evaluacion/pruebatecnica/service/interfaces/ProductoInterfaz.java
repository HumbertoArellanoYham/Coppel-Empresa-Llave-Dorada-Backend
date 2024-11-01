package com.evaluacion.pruebatecnica.service.interfaces;

import java.util.List;

public interface ProductoInterfaz<T> {
    List<T> findAllProducts();
}
