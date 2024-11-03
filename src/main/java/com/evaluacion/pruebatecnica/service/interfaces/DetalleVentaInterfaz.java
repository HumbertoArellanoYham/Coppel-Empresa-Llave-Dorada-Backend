package com.evaluacion.pruebatecnica.service.interfaces;

import com.evaluacion.pruebatecnica.entities.DetalleVenta;

import java.util.List;
import java.util.Optional;

public interface DetalleVentaInterfaz<T> {
    List<T> findAll();

    Optional<T> findById(Integer id);

    T saveDetalleVenta(DetalleVenta detalleVenta);

    void removeDetalleVenta(Integer id);

    void remove(DetalleVenta detalleVenta);

    T update(DetalleVenta detalleVenta);
}
