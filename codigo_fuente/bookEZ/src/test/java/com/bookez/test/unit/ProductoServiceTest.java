package com.bookez.test.unit;

import com.bookez.model.Producto;
import com.bookez.repository.ProductoRepository;
import com.bookez.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {
    private ProductoService productoService;
    private ProductoRepository productoRepository;

    @BeforeEach
    public void setUp() {
        productoRepository = new ProductoRepository();
        productoService = new ProductoService(productoRepository);
    }

    @Test
    public void testAgregarProducto() {
        Producto producto = new Producto(1, "Bebida A", "Descripción de Bebida A", 10.0, 100);
        productoService.agregarProducto(producto);

        Producto productoRegistrado = productoService.obtenerProductoPorId(1);
        assertNotNull(productoRegistrado);
        assertEquals("Bebida A", productoRegistrado.getNombre());
    }

    @Test
    public void testObtenerProductoPorId() {
        Producto producto = new Producto(1, "Bebida A", "Descripción de Bebida A", 10.0, 100);
        productoService.agregarProducto(producto);

        Producto productoRegistrado = productoService.obtenerProductoPorId(1);
        assertEquals("Bebida A", productoRegistrado.getNombre());
    }

    @Test
    public void testObtenerTodosLosProductos() {
        Producto producto1 = new Producto(1, "Bebida A", "Descripción de Bebida A", 10.0, 100);
        Producto producto2 = new Producto(2, "Bebida B", "Descripción de Bebida B", 15.0, 50);
        productoService.agregarProducto(producto1);
        productoService.agregarProducto(producto2);

        assertEquals(2, productoService.obtenerTodosLosProductos().size());
    }

    @Test
    public void testActualizarStockProducto() {
        Producto producto = new Producto(1, "Bebida A", "Descripción de Bebida A", 10.0, 100);
        productoService.agregarProducto(producto);

        productoService.actualizarStockProducto(1, 150);
        Producto productoActualizado = productoService.obtenerProductoPorId(1);
        assertEquals(150, productoActualizado.getStock());
    }
}
