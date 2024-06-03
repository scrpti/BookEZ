package com.bookez.service;

import com.bookez.model.Evento;
import com.bookez.repository.EventoRepository;

import java.util.List;

public class EventoService {
    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public void registrarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    public List<Evento> obtenerTodosLosEventos() {
        return eventoRepository.findAll();
    }
}
