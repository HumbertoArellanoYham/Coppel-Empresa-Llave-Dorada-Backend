package com.evaluacion.pruebatecnica.repositories;

import com.evaluacion.pruebatecnica.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@Repository
@CrossOrigin(value = "http://localhost:4200")
public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
    @Query("SELECT v FROM Venta v WHERE v.fecha_venta = :fechaVenta")
    List<Venta> findByFechaVenta(LocalDate fechaVenta);
}
