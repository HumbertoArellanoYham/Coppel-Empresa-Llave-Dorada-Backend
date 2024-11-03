package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.Usuario;
import com.evaluacion.pruebatecnica.repositories.UsuarioRepository;
import com.evaluacion.pruebatecnica.service.interfaces.UsuarioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioInterfaz<Usuario> {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario saveUsers(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Validacion si usuario no se encuentra registrado
    @Override
    public void deleteUserById(Integer id) {
        if(existeUser(id)){
            usuarioRepository.deleteById(id);
        }
    }

    @Override
    public void deleteUser(Usuario usuario) {
        if(existeUser(usuario.getIdUsuario())){
            usuarioRepository.delete(usuario);
        }
    }

    @Override
    public boolean existeUser(Integer id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Usuario updateUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
