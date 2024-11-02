package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.TipoCliente;
import com.evaluacion.pruebatecnica.service.TipoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tipocliente")
public class TipoClienteController {

    @Autowired
    private TipoClienteService tipoClienteService;

    @GetMapping("/{id}")
    public ResponseEntity<TipoCliente> searchById(@PathVariable(name = "id") Integer id){
        Optional<TipoCliente> foundTipoCliente = tipoClienteService.getById(id);

        return foundTipoCliente.map(tipoCliente -> new ResponseEntity<>(tipoCliente, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TipoCliente>> findAllTipoCliente(){
        List<TipoCliente> foundAllTipoCliente = tipoClienteService.findAll();

        return foundAllTipoCliente.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(foundAllTipoCliente, HttpStatus.OK);
    }
}
