package com.bookez.test.integration;

import com.bookez.model.Producto;
import com.bookez.model.Venta;
import com.bookez.repository.VentaRepository;
import com.bookez.service.VentaService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class VentaIntegrationTest {
    private VentaService ventaService;
    private VentaRepository ventaRepository;
    private Venta venta;
    private Producto producto;

    @Before
    public void setup() {
        ventaRepository = mock(VentaRepository.class);
        ventaService = new VentaService(ventaRepository);
        producto = new Producto(1, "Producto 1", "Descripción del producto 1", 10.0, 100);
        venta = new Venta(1, producto, 1, 10.0);
    }

    @Test
    public void registrarVenta() {
        // Aquí configuramos el mock para devolver una lista con la venta cuando se llame a findAll()
        when(ventaRepository.findAll()).thenReturn(Arrays.asList(venta));
        
        ventaService.registrarVenta(venta);

        verify(ventaRepository, times(1)).save(venta);
        
        // Llamamos a obtenerTodasLasVentas y verificamos el contenido de la lista devuelta
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();
        assertEquals(1, ventas.size());
        assertEquals(venta, ventas.get(0));
    }

    @Test
    public void obtenerTodasLasVentas() {
        when(ventaRepository.findAll()).thenReturn(Arrays.asList(venta));

        List<Venta> ventasObtenidas = ventaService.obtenerTodasLasVentas();

        verify(ventaRepository, times(1)).findAll();
        assertEquals(1, ventasObtenidas.size());
        assertEquals(venta, ventasObtenidas.get(0));
    }

    @Test
    public void generarInformeDeVentas() {
        when(ventaRepository.findAll()).thenReturn(Arrays.asList(venta));

        double totalVentas = ventaService.generarInformeDeVentas();

        verify(ventaRepository, times(1)).findAll();
        assertEquals(10.0, totalVentas, 0.01);
    }
}