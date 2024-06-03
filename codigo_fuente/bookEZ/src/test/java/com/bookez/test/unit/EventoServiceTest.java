package com.bookez.test.unit;

import com.bookez.model.Evento;
import com.bookez.repository.EventoRepository;
import com.bookez.service.EventoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventoServiceTest {
    private EventoService eventoService;
    private EventoRepository eventoRepository;

    @BeforeEach
    public void setUp() {
        eventoRepository = new EventoRepository();
        eventoService = new EventoService(eventoRepository);
    }

    @Test
    public void testRegistrarEvento() {
        Evento evento = new Evento(1, "Fiesta", LocalDateTime.now(), "Fiesta universitaria");
        eventoService.registrarEvento(evento);

        List<Evento> eventos = eventoService.obtenerTodosLosEventos();
        assertEquals(1, eventos.size());
        assertEquals("Fiesta universitaria", eventos.get(0).getDescripcion());
    }

    @Test
    public void testObtenerTodosLosEventos() {
        Evento evento1 = new Evento(1, "Fiesta", LocalDateTime.now(), "Fiesta universitaria");
        Evento evento2 = new Evento(2, "Evento", LocalDateTime.now().plusDays(1), "Evento social");
        eventoService.registrarEvento(evento1);
        eventoService.registrarEvento(evento2);

        assertEquals(2, eventoService.obtenerTodosLosEventos().size());
    }
}
