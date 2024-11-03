package com.evaluacion.pruebatecnica.repositories;

import com.evaluacion.pruebatecnica.entities.Cliente;
import com.evaluacion.pruebatecnica.entities.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(value = "http://localhost:4200")
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    @Query("SELECT dv FROM DetalleVenta dv WHERE dv.id_venta = :idVenta")
    List<DetalleVenta> findDetallesByVentaId(Integer idVenta);
}
