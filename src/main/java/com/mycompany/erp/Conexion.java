/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.erp;

import java.sql.*;

public class Conexion {

    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String query = "";
//Contructor

    public Conexion() throws SQLException {
        try {
//obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
// Se obtiene una conexión con la base de datos. 2
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ERP", "root", "JAME060503");
// Permite ejecutar sentencias SQL sin parámetros
            s = conexion.createStatement();
        } catch (ClassNotFoundException e1) {
//Error si no puedo leer el driver de MySQL
            System.out.println("ERROR:No encuentro el driver de la BD: " + e1.getMessage());
        }
    }
//Metodo que permite obtener los valores del resulset

    public ResultSet getRs() {
        return rs;
    }
//Metodo que permite fijar la tabla resultado de la pregunta
//SQL realizada

    public void setRs(String consulta) {
        try {
            this.rs = s.executeQuery(consulta);
        } catch (SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: " + e2.getMessage());
        }
    }
//Metodo que recibe un sql como parametro que sea un update,insert.delete

    public void setQuery(String query) throws SQLException {
        this.s.executeUpdate(query);
    }
//Metodo que cierra la conexion

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }
}
