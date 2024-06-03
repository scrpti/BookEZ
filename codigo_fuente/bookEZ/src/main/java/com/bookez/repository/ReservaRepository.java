package com.bookez.repository;

import com.bookez.model.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaRepository {
    private List<Reserva> reservas = new ArrayList<>();

    public void save(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> findByClienteNIF(String nifCliente) {
        return reservas.stream().filter(reserva -> reserva.getCliente().getNif().equals(nifCliente)).collect(Collectors.toList());
    }

    public List<Reserva> findAll() {
        return new ArrayList<>(reservas);
    }
    
    public Reserva findById(int idReserva) {
        return reservas.stream()
                .filter(reserva -> reserva.getId() == idReserva)
                .findFirst()
                .orElse(null);
    }
}
