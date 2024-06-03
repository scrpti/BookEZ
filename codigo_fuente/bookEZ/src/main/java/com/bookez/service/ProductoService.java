package com.bookez.service;

import com.bookez.model.Producto;
import com.bookez.repository.ProductoRepository;

import java.util.List;

public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void agregarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto obtenerProductoPorId(int id) {
        return productoRepository.findById(id);
    }

    public void actualizarStockProducto(int id, int nuevoStock) {
        Producto producto = productoRepository.findById(id);
        if (producto != null) {
            producto.setStock(nuevoStock);
        }
    }
}
