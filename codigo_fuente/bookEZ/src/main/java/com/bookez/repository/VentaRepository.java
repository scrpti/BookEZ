package com.bookez.repository;

import com.bookez.model.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaRepository {
    private List<Venta> ventas = new ArrayList<>();

    public void save(Venta venta) {
        ventas.add(venta);
    }

    public List<Venta> findAll() {
        return new ArrayList<>(ventas);
    }
}
