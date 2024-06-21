/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

/**
 *
 * @author tecweb08
 */
public class Proveedor {
         private int idproveedor;
    private String nombrrpro;
    private String direccion;
    private String rfc;
        private String telefono;

    public int getIdProveedor() {
        return idproveedor;
    }

    public void setIdProveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombrrpro() {
        return nombrrpro;
    }

    public void setNombrrpro(String nombrrpro) {
        this.nombrrpro = nombrrpro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Proveedor(int idproveedor, String nombrrpro, String direccion, String rfc, String telefono) {
        this.idproveedor = idproveedor;
        this.nombrrpro = nombrrpro;
        this.direccion = direccion;
        this.rfc = rfc;
        this.telefono = telefono;
    }

  

    public Proveedor() {
        super();
    }
}
