/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class DetalleVentas {

    private int iddetventas;
    private int cantidad;
    private String nombre;
    private double precio;
    private double subtotal;
    private int iddetventasven;

    public int getIddetventas() {
        return iddetventas;
    }

    public void setIddetventas(int iddetventas) {
        this.iddetventas = iddetventas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getIddetventasven() {
        return iddetventasven;
    }

    public void setIddetventasven(int iddetventasven) {
        this.iddetventasven = iddetventasven;
    }

    public DetalleVentas(int iddetventas, int cantidad, String nombre, double precio, double subtotal, int iddetventasven) {
        this.iddetventas = iddetventas;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
        this.subtotal = subtotal;
        this.iddetventasven = iddetventasven;
    }

    public DetalleVentas() {
        super();
    }
}
