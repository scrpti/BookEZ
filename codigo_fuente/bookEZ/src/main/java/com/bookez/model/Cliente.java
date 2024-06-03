package com.bookez.model;

public class Cliente {
	private String nif;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private int puntos;

    // Constructor, getters y setters
    public Cliente(String nif, String nombre, String direccion, String telefono, String email) {
    	this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.puntos = 0;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void acumularPuntos(int puntos) {
        this.puntos += puntos;
    }
}
