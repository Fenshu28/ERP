/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.erp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tecweb08
 */
@WebServlet(name = "GeneraSession", urlPatterns = {"/GeneraSession"})
public class GeneraSession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            try {
                Conexion con = new Conexion();
//buscará una coincidencia (count usuario), si es correcto
//podrá loguearse
                con.setRs("select count(usuario),nombres from usuarios"
                        + " where usuario='" + usuario + "' and "
                        + "password='" + password + " group by nombres'");
                ResultSet rs = con.getRs();
                rs.next();
                if (rs.getInt(1) == 1) { //solo una coincidencia es permitida
                    HttpSession session_actual = request.getSession(true);
                    session_actual.setAttribute("USER", usuario);
                    session_actual.setAttribute("NAME", rs.getString(2));
                    response.sendRedirect("principal.jsp");
                } else {
                    response.sendRedirect("login.html");
                }
                rs.close();
                con.cerrarConexion();
            } catch (SQLException e) {
                out.print(e.getMessage());
            }
        } finally {
            out.close();
        }
    }
    }
