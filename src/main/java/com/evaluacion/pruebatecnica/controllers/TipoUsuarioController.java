package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.TipoCliente;
import com.evaluacion.pruebatecnica.entities.TipoUsuario;
import com.evaluacion.pruebatecnica.service.TipoUsuarioServiceImpl;
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
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> searchById(@PathVariable(name = "id") Integer id){
        Optional<TipoUsuario> foundTipoUsuario = tipoUsuarioService.getUserTypeById(id);

        return foundTipoUsuario.map(tipoUsuario -> new ResponseEntity<>(tipoUsuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TipoUsuario>> findAllTipoCliente(){
        List<TipoUsuario> foundAllTipoUsuario = tipoUsuarioService.findAllUsersType();

        return foundAllTipoUsuario.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT):
                new ResponseEntity<>(foundAllTipoUsuario, HttpStatus.OK);
    }
}
