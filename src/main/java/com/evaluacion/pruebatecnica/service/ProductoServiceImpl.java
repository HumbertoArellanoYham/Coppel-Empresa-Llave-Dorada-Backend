package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.Producto;
import com.evaluacion.pruebatecnica.repositories.ProductoRepository;
import com.evaluacion.pruebatecnica.service.interfaces.ProductoInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoInterfaz<Producto> {
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAllProducts() {
        return productoRepository.findAll();
    }
}
