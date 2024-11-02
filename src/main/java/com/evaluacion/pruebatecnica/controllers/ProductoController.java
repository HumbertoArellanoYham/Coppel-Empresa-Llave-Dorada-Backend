package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.Producto;
import com.evaluacion.pruebatecnica.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable(name = "id") Integer id){
        Optional<Producto> findProduct = productoService.findById(id);

       return findProduct.map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody(required = true) Producto producto){
        System.out.println(producto.toString());
        Producto savedProduct = productoService.saveProduct(producto);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/")
    public void removeByIdProduct(@RequestBody(required = true) Producto producto) {
        productoService.remove(producto);
    }


    @PatchMapping("/update")
    public ResponseEntity<Producto> updateCliente(@RequestBody Producto producto) {
        Producto isUpdate = productoService.updateProduct(producto);

        return new ResponseEntity<>(isUpdate, HttpStatus.ACCEPTED);
    }


}
