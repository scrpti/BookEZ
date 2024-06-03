package com.bookez.test.integration;

import com.bookez.model.Cliente;
import com.bookez.model.Reserva;
import com.bookez.repository.ReservaRepository;
import com.bookez.service.ReservaService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ReservaIntegrationTest {
    private ReservaService reservaService;
    private ReservaRepository reservaRepository;
    private Reserva reserva;
    private Cliente cliente;

    @Before
    public void setup() {
        reservaRepository = mock(ReservaRepository.class);
        reservaService = new ReservaService(reservaRepository);
        cliente = new Cliente("12345678", "Juan Pérez", "Calle 123", "1234567890", "juan.perez@example.com");
        reserva = new Reserva(1, cliente, LocalDateTime.now(), "pendiente");
    }

    @Test
    public void obtenerReservasPorCliente() {
        when(reservaRepository.findByClienteNIF(cliente.getNif())).thenReturn(Arrays.asList(reserva));

        List<Reserva> reservasObtenidas = reservaService.obtenerReservasPorCliente(cliente.getNif());

        verify(reservaRepository, times(1)).findByClienteNIF(cliente.getNif());
        assertEquals(1, reservasObtenidas.size());
        assertEquals(reserva, reservasObtenidas.get(0));
    }

    @Test
    public void obtenerTodasLasReservas() {
        when(reservaRepository.findAll()).thenReturn(Arrays.asList(reserva));

        List<Reserva> reservasObtenidas = reservaService.obtenerTodasLasReservas();

        verify(reservaRepository, times(1)).findAll();
        assertEquals(1, reservasObtenidas.size());
        assertEquals(reserva, reservasObtenidas.get(0));
    }
}
