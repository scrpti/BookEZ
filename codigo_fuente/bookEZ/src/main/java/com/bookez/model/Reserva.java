package com.bookez.model;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private Cliente cliente;
    private LocalDateTime fechaHora;
    private String estado;
    private String motivoReembolso;
    private boolean grupo;

    // Constructor, getters y setters
    public Reserva(int id, Cliente cliente, LocalDateTime fechaHora, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.grupo = false;
    }
    
    public Reserva(int id, Cliente cliente, LocalDateTime fechaHora, String estado, boolean grupo) {
        this.id = id;
        this.cliente = cliente;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoReembolso() {
        return motivoReembolso;
    }

    public void setMotivoReembolso(String motivoReembolso) {
        this.motivoReembolso = motivoReembolso;
    }
}