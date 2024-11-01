package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.Producto;
import com.evaluacion.pruebatecnica.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Producto>> getAllProducts(){
        List<Producto> listProducts = productoService.findAllProducts();

        return listProducts.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(listProducts, HttpStatus.OK);
    }
}
