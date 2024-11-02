package com.evaluacion.pruebatecnica.service;

import com.evaluacion.pruebatecnica.entities.Categoria;
import com.evaluacion.pruebatecnica.repositories.CategoriaRepository;
import com.evaluacion.pruebatecnica.service.interfaces.CategoriaInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaInterfaz<Categoria> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> findAllCategories() {
        return categoriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria> getById(Integer id){
        return categoriaRepository.findById(id);
    }
}
