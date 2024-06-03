package com.bookez.service;

import com.bookez.model.Evento;
import com.bookez.model.Reserva;
import com.bookez.repository.ReservaRepository;

import java.util.List;

public class ReservaService {
    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void registrarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public List<Reserva> obtenerReservasPorCliente(String nifCliente) {
        return reservaRepository.findByClienteNIF(nifCliente);
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public void registrarAsistenciaEvento(String nifCliente, Evento evento) {
        Reserva reserva = reservaRepository.findByClienteNIF(nifCliente).stream()
                                .filter(r -> r.getEstado().equals("Confirmada"))
                                .findFirst()
                                .orElse(null);
        if (reserva != null) {
            evento.registrarAsistencia(reserva.getCliente());
        }
    }

    public void solicitarReembolso(int idReserva, String motivo) {
        Reserva reserva = reservaRepository.findById(idReserva);
        if (reserva != null) {
            reserva.setEstado("Solicitado reembolso");
            reserva.setMotivoReembolso(motivo);
            reservaRepository.save(reserva);
            System.out.println("Solicitud de reembolso enviada con éxito.");
        } else {
            System.out.println("La reserva no existe.");
        }
    }
}