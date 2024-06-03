package com.bookez.repository;

import com.bookez.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoRepository {
    private List<Evento> eventos = new ArrayList<>();

    public void save(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> findAll() {
        return new ArrayList<>(eventos);
    }
}
