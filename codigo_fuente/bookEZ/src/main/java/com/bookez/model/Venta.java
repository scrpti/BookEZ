package com.bookez.model;

public class Venta {
    private int id;
    private Producto producto;
    private int cantidad;
    private double total;

    // Constructor, getters y setters
    public Venta(int id, Producto producto, int cantidad, double total) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
