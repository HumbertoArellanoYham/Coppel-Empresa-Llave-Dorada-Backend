package com.evaluacion.pruebatecnica.service.interfaces;


import com.evaluacion.pruebatecnica.entities.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaInterfaz<T> {
    List<Venta> findAllVentas();

    Optional<T> findVentaById(Integer id);

    T saveVentaReady (T t);

    T updateVenta(T t);

    void deleteVenta(Integer id);
}
