package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.DetalleVenta;
import com.evaluacion.pruebatecnica.repositories.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Transactional
    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    public List<DetalleVenta> findDetallesByVentaId(Integer idventa) {
        return detalleVentaRepository.findDetallesByVentaId(idventa);
    }
}
