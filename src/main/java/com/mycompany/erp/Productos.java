/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class Productos {

    private int idproducto;
    private String nombre;
    private String descripcion;
    private String marca;
    private double precio;
    private double costo;
    private int minimo;
    private int stok;
    private int idproveedorpro;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getIdproveedorpro() {
        return idproveedorpro;
    }

    public void setIdproveedorpro(int idproveedorpro) {
        this.idproveedorpro = idproveedorpro;
    }

    public Productos(int idproducto, String nombre, String descripcion, String marca, double precio, double costo, int minimo, int stok, int idproveedorpro) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.costo = costo;
        this.minimo = minimo;
        this.stok = stok;
        this.idproveedorpro = idproveedorpro;
    }

    public Productos() {
        super();
    }
}
