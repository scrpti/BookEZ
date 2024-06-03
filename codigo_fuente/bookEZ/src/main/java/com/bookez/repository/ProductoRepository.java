package com.bookez.repository;

import com.bookez.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();

    public void save(Producto producto) {
        productos.add(producto);
    }

    public Producto findById(int id) {
        return productos.stream().filter(producto -> producto.getId() == id).findFirst().orElse(null);
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }
}
