package com.evaluacion.pruebatecnica.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface ClienteInterfaz<T> {
    List<T> findAllClients();

    Optional<T> findById(Integer id);

    T saveCliente(T t);

    void deleteClienteById(Integer id);

    void deleteCliente(T t);

    boolean existeCliente(Integer id);

    T updateClient(T t);
}
