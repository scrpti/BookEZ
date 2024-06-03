package com.bookez.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private int id;
    private String nombre;
    private LocalDateTime fechaHora;
    private String descripcion;
    private List<Cliente> asistentes;

    public Evento(int id, String nombre, LocalDateTime fechaHora, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.asistentes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void registrarAsistencia(Cliente cliente) {
        asistentes.add(cliente);
    }
}
