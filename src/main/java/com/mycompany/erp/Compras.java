/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class Compras {

    private int idcompra;
    private String fecha;
    private int cantidad_pro;
    private double total;
    private int idproductocom;
    private int iddetcomprascom;

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad_pro() {
        return cantidad_pro;
    }

    public void setCantidad_pro(int cantidad_pro) {
        this.cantidad_pro = cantidad_pro;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdproductocom() {
        return idproductocom;
    }

    public void setIdproductocom(int idproductocom) {
        this.idproductocom = idproductocom;
    }

    public int getIddetcomprascom() {
        return iddetcomprascom;
    }

    public void setIddetcomprascom(int iddetcomprascom) {
        this.iddetcomprascom = iddetcomprascom;
    }

    public Compras(int idcompra, String fecha, int cantidad_pro, double total, int idproductocom, int iddetcomprascom) {
        this.idcompra = idcompra;
        this.fecha = fecha;
        this.cantidad_pro = cantidad_pro;
        this.total = total;
        this.idproductocom = idproductocom;
        this.iddetcomprascom = iddetcomprascom;
    }

    public Compras() {
        super();
    }
}
