/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tecweb11
 */
@WebServlet(name = "ProveedorServlet", urlPatterns = {"/ProveedorServlet"})
public class ProveedorServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResultSet rs = null;

        int id = Integer.parseInt(request.getParameter("idProveedor"));
        int editar = Integer.parseInt(request.getParameter("tipo"));

        String namepro = request.getParameter("nombre");
        String dir = request.getParameter("direccion");
        String rfc1 = request.getParameter("rfc");
        String telefono1 = request.getParameter("telefono");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ERP", "root", "kira?123");
            Statement s = conexion.createStatement();
            if (editar != 0) {
                if (editar == 1) {
                    s.execute("call updateProveedor (" + id + ",'" + namepro + "'  ,'" + dir + "'  ,'" + rfc1 + "'  ," + telefono1 + "  )");
                    sendResponse(request, response, "Proveedor actualizado con exito.", "Información");
                } else {
                    s.execute("call deleteProveedor (" + id + " )");
                    sendResponse(request, response, "Proveedor eliminado con exito.", "Información");
                }
            } else {
                s.execute("call insertProveedor (0,'" + namepro + "','" + dir + "','" + rfc1 + "'," + telefono1 + ")");
                sendResponse(request, response, "Proveedor creado con exito.", "Información");
            }

            conexion.close();

        } catch (ClassNotFoundException e1) {
//Error si no puedo leer el driver
            out.println("ERROR:No encuentro el driver de la BD: "
                    + e1.getMessage());
            sendResponse(request, response, "Ocurrio un error:" + e1.getMessage(), "Error");
        } catch (SQLException e2) {
//Error SQL: login/passwd mal
            out.println("ERROR:Fallo en SQL: " + e2.getMessage());
            sendResponse(request, response, "Ocurrio un error:" + e2.getMessage(), "Error");
        } finally {
            out.close();
        }

    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response, String respuesta, String tipo) throws IOException, ServletException {
        request.setAttribute("idResult", respuesta);
        request.setAttribute("tipoResult", tipo);
        request.setAttribute("showModal", true);
        request.getRequestDispatcher("Proveedores.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
