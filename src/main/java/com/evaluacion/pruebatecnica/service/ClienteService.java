package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.Cliente;
import com.evaluacion.pruebatecnica.repositories.ClienteRepository;
import com.evaluacion.pruebatecnica.service.interfaces.ClienteInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ClienteInterfaz<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAllClients() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    @Override
    public void deleteClienteById(Integer id) {
        if(existeCliente(id)){
            clienteRepository.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existeCliente(Integer id) {
        return clienteRepository.existsById(id);
    }

    @Transactional
    @Override
    public Cliente updateClient(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
