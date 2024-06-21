/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class Ventas {

    private int idventa;
    private String fecha;
    private int cantidadto;
    private double total;
    private int idcliente;
    private int idempleadoven;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadto() {
        return cantidadto;
    }

    public void setCantidadto(int cantidadto) {
        this.cantidadto = cantidadto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleadoven() {
        return idempleadoven;
    }

    public void setIdempleadoven(int idempleadoven) {
        this.idempleadoven = idempleadoven;
    }

    public Ventas(int idventa, String fecha, int cantidadto, double total, int idcliente, int idempleadoven) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.cantidadto = cantidadto;
        this.total = total;
        this.idcliente = idcliente;
        this.idempleadoven = idempleadoven;
    }
    
    

    public Ventas() {
        super();
    }
}
