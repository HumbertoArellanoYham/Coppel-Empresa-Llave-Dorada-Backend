package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.Venta;
import com.evaluacion.pruebatecnica.repositories.VentaRepositorio;
import com.evaluacion.pruebatecnica.service.interfaces.VentaInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements VentaInterfaz<Venta> {

    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Override
    public List<Venta> findAllVentas() {
        return ventaRepositorio.findAll();
    }

    @Override
    public Optional<Venta> findVentaById(Integer id) {
        return ventaRepositorio.findById(id);
    }

    @Transactional
    @Override
    public Venta saveVentaReady(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    // Not implement
    @Override
    public Venta updateVenta(Venta venta) {
        return null;
    }

    @Transactional
    @Override
    public void deleteVenta(Integer id) {
        ventaRepositorio.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Venta> getByFecha(LocalDate fecha){
        return ventaRepositorio.findByFechaVenta(fecha);
    }
}
