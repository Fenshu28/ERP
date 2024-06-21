/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class Almacen {

    private int idalmacen;
    private int cantidad;
    private int idproductoalm;

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdproductoalm() {
        return idproductoalm;
    }

    public void setIdproductoalm(int idproductoalm) {
        this.idproductoalm = idproductoalm;
    }

    public Almacen(int idalmacen, int cantidad, int idproductoalm) {
        this.idalmacen = idalmacen;
        this.cantidad = cantidad;
        this.idproductoalm = idproductoalm;
    }

    public Almacen() {
        super();
    }
}
