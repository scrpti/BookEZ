package com.bookez.test.integration;

import com.bookez.model.Evento;
import com.bookez.repository.EventoRepository;
import com.bookez.service.EventoService;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EventoIntegrationTest {
    private EventoService eventoService;
    private EventoRepository eventoRepository;
    private Evento evento;

    @Before
    public void setup() {
        eventoRepository = mock(EventoRepository.class);
        eventoService = new EventoService(eventoRepository);
        evento = new Evento(1, "Evento 1", LocalDateTime.now(), "Descripción del evento 1");
    }

    @Test
    public void obtenerTodosLosEventos() {
        when(eventoRepository.findAll()).thenReturn(Arrays.asList(evento));

        List<Evento> eventosObtenidos = eventoService.obtenerTodosLosEventos();

        verify(eventoRepository, times(1)).findAll();
        assertEquals(1, eventosObtenidos.size());
        assertEquals(evento, eventosObtenidos.get(0));
    }    
}
