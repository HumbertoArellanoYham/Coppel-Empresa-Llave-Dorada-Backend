package com.evaluacion.pruebatecnica.controllers;

import com.evaluacion.pruebatecnica.entities.Usuario;
import com.evaluacion.pruebatecnica.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("findAll")
    public ResponseEntity<List<Usuario>> findAllUsers(){
        List<Usuario> userList = usuarioService.findAllUsuarios();

        return userList.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findAllUsers(@PathVariable(name = "id") Integer id){
        Optional<Usuario> user = usuarioService.findById(id);

        return user.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario){
        Usuario user = usuarioService.saveUsers(usuario);

        if(usuarioService.existeUser(user.getIdUsuario())){
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
        usuarioService.deleteUserById(id);

        if(!usuarioService.existeUser(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> deleteUserById(@RequestBody Usuario usuario){
        usuarioService.deleteUser(usuario);

        if(!usuarioService.existeUser(usuario.getIdUsuario())){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/update")
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario){
        Usuario update = usuarioService.updateUser(usuario);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
