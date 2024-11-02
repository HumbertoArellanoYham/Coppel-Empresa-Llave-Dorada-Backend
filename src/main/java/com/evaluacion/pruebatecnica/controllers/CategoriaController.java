package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.Categoria;
import com.evaluacion.pruebatecnica.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Categoria>> findAllCategories(){
        List<Categoria> allCategories = categoriaService.findAllCategories();

        if(allCategories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable(name = "id") Integer id){
        Optional<Categoria> categoriaById = categoriaService.getById(id);

        return categoriaById.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
