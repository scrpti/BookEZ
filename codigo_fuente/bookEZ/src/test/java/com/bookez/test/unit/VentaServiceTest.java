package com.bookez.test.unit;

import com.bookez.model.Producto;
import com.bookez.model.Venta;
import com.bookez.repository.ProductoRepository;
import com.bookez.repository.VentaRepository;
import com.bookez.service.ProductoService;
import com.bookez.service.VentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VentaServiceTest {
    private VentaService ventaService;
    private VentaRepository ventaRepository;
    private ProductoService productoService;
    private ProductoRepository productoRepository;

    @BeforeEach
    public void setUp() {
        ventaRepository = new VentaRepository();
        ventaService = new VentaService(ventaRepository);
        productoRepository = new ProductoRepository();
        productoService = new ProductoService(productoRepository);
    }

    @Test
    public void testRegistrarVenta() {
        Producto producto = new Producto(1, "Bebida A", "Descripción del Bebida A", 10.0, 100);
        productoService.agregarProducto(producto);
        Venta venta = new Venta(1, producto, 2, 20.0);
        ventaService.registrarVenta(venta);

        assertEquals(1, ventaService.obtenerTodasLasVentas().size());
    }

    @Test
    public void testGenerarInformeDeVentas() {
        Producto producto1 = new Producto(1, "Bebida A", "Descripción del Bebida A", 10.0, 100);
        Producto producto2 = new Producto(2, "Bebida B", "Descripción del Bebida B", 15.0, 50);
        productoService.agregarProducto(producto1);
        productoService.agregarProducto(producto2);

        Venta venta1 = new Venta(1, producto1, 2, 20.0);
        Venta venta2 = new Venta(2, producto2, 3, 45.0);
        ventaService.registrarVenta(venta1);
        ventaService.registrarVenta(venta2);

        double totalVentas = ventaService.generarInformeDeVentas();
        assertEquals(65.0, totalVentas);
    }
}
