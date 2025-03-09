package com.hexagonaljava.domain.repository;

import java.util.List;

import com.hexagonaljava.domain.entity.Product;


public interface ProductRepository {
    void guardar(Product product);
    Product buscarPorId(int id);
    List<Product> listarTodos();
    void actualizar(Product product);
    void eliminar(int id);
}
