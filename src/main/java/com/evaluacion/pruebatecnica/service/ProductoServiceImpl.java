package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.Producto;
import com.evaluacion.pruebatecnica.repositories.ProductoRepository;
import com.evaluacion.pruebatecnica.service.interfaces.ProductoInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoInterfaz<Producto> {
    @Autowired
    private ProductoRepository productoRepository;

    /*
    * Encuentra todos los productos de la base de datos
    * @return una lista de productos
    */
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAllProducts() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Transactional
    @Override
    public Producto updateProduct(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    @Override
    public void remove(Producto producto) {
        productoRepository.deleteById(producto.getIdProducto());
    }

    @Transactional
    @Override
    public Producto saveProduct(Producto producto) {
        return productoRepository.save(producto);
    }
}
