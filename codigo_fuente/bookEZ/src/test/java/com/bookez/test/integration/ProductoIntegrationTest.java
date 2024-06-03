package com.bookez.test.integration;

import com.bookez.model.Producto;
import com.bookez.repository.ProductoRepository;
import com.bookez.service.ProductoService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductoIntegrationTest {
    private ProductoService productoService;
    private ProductoRepository productoRepository;
    private Producto producto;

    @Before
    public void setup() {
        productoRepository = mock(ProductoRepository.class);
        productoService = new ProductoService(productoRepository);
        producto = new Producto(1, "Producto 1", "Descripción del producto 1", 10.0, 100);
    }

    @Test
    public void obtenerTodosLosProductos() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto));

        List<Producto> productosObtenidos = productoService.obtenerTodosLosProductos();

        verify(productoRepository, times(1)).findAll();
        assertEquals(1, productosObtenidos.size());
        assertEquals(producto, productosObtenidos.get(0));
    }
}
