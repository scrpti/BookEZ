package com.bookez.test.unit;

import com.bookez.model.Cliente;
import com.bookez.model.Reserva;
import com.bookez.repository.ReservaRepository;
import com.bookez.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaServiceTest {
    private ReservaService reservaService;
    private ReservaRepository reservaRepository;

    @BeforeEach
    public void setUp() {
        reservaRepository = new ReservaRepository();
        reservaService = new ReservaService(reservaRepository);
    }

    @Test
    public void testRegistrarReserva() {
        Cliente cliente = new Cliente("12345678A", "Juan Pérez", "Calle Falsa 123", "123456789", "juan@example.com");
        Reserva reserva = new Reserva(1, cliente, LocalDateTime.now(), "confirmada");
        reservaService.registrarReserva(reserva);

        List<Reserva> reservas = reservaService.obtenerReservasPorCliente("12345678A");
        assertEquals(1, reservas.size());
        assertEquals("confirmada", reservas.get(0).getEstado());
    }

    @Test
    public void testObtenerReservasPorCliente() {
        Cliente cliente = new Cliente("12345678A", "Juan Pérez", "Calle Falsa 123", "123456789", "juan@example.com");
        Reserva reserva1 = new Reserva(1, cliente, LocalDateTime.now(), "confirmada");
        Reserva reserva2 = new Reserva(2, cliente, LocalDateTime.now().plusDays(1), "pendiente");
        reservaService.registrarReserva(reserva1);
        reservaService.registrarReserva(reserva2);

        List<Reserva> reservas = reservaService.obtenerReservasPorCliente("12345678A");
        assertEquals(2, reservas.size());
    }

    @Test
    public void testObtenerTodasLasReservas() {
        Cliente cliente = new Cliente("12345678A", "Juan Pérez", "Calle Falsa 123", "123456789", "juan@example.com");
        Reserva reserva1 = new Reserva(1, cliente, LocalDateTime.now(), "confirmada");
        Reserva reserva2 = new Reserva(2, cliente, LocalDateTime.now().plusDays(1), "pendiente");
        reservaService.registrarReserva(reserva1);
        reservaService.registrarReserva(reserva2);

        assertEquals(2, reservaService.obtenerTodasLasReservas().size());
    }
}
