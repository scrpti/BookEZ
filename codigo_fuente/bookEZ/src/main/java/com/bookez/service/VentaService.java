package com.bookez.service;

import com.bookez.model.Venta;
import com.bookez.repository.VentaRepository;

import java.util.List;

public class VentaService {
    private VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public void registrarVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    public double generarInformeDeVentas() {
        List<Venta> ventas = obtenerTodasLasVentas();
        double totalVentas = 0;
        for (Venta venta : ventas) {
            totalVentas += venta.getTotal();
        }
        return totalVentas;
    }
}
