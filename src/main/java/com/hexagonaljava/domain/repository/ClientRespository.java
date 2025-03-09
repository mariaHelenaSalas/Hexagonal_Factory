package com.hexagonaljava.domain.repository;

import java.util.List;

import com.hexagonaljava.domain.entity.Client;

public interface ClientRespository {
    void guardar(Client cliente);
    Client buscarPorId(int id);
    List<Client> listarTodos();
    void actualizar(Client cliente);
    void eliminar(int id);
}
