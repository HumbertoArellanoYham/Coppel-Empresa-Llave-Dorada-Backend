package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.TipoCliente;
import com.evaluacion.pruebatecnica.repositories.TipoClienteRepository;
import com.evaluacion.pruebatecnica.service.interfaces.TipoClienteInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoClienteService implements TipoClienteInterfaz<TipoCliente> {

    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoCliente> getById(Integer id) {
        return tipoClienteRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TipoCliente> findAll() {
        return tipoClienteRepository.findAll();
    }
}
