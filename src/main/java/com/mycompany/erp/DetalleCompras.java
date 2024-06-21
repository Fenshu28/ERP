/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class DetalleCompras {
         private int iddecompras;
    private int cantidad_ind;
    private double precio;
        private double subtotal;

    public int getIddecompras() {
        return iddecompras;
    }

    public void setIddecompras(int iddecompras) {
        this.iddecompras = iddecompras;
    }

    public int getCantidad_ind() {
        return cantidad_ind;
    }

    public void setCantidad_ind(int cantidad_ind) {
        this.cantidad_ind = cantidad_ind;
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

    public DetalleCompras(int iddecompras, int cantidad_ind, double precio, double subtotal) {
        this.iddecompras = iddecompras;
        this.cantidad_ind = cantidad_ind;
        this.precio = precio;
        this.subtotal = subtotal;
    }

        

    public DetalleCompras() {
        super();
    }
}
