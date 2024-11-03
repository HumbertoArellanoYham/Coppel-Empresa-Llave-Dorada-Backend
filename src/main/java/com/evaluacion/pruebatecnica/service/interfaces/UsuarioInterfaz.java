package com.evaluacion.pruebatecnica.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface UsuarioInterfaz<T> {
    List<T> findAllUsuarios();

    Optional<T> findById(Integer id);

    T saveUsers(T t);

    void deleteUserById(Integer id);

    void deleteUser(T t);

    boolean existeUser(Integer id);

    T updateUser(T t);
}
