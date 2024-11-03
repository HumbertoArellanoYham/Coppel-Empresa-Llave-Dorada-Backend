package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.TipoUsuario;
import com.evaluacion.pruebatecnica.repositories.TipoUsuarioRepository;
import com.evaluacion.pruebatecnica.service.interfaces.TipoUsuarioInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioInterfaz<TipoUsuario> {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TipoUsuario> findAllUsersType() {
        return tipoUsuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoUsuario> getUserTypeById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }
}
