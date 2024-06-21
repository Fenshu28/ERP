/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tecweb11
 */
@WebServlet(name = "ProductosServlet", urlPatterns = {"/ProductosServlet"})
public class ProductosServlet extends HttpServlet {

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
        ResultSet rs = null;
        Connection conexion = null;
        String name = request.getParameter("nombre");
        String desc = request.getParameter("desc");
        String marca = request.getParameter("marca");
        double precio = Double.parseDouble(request.getParameter("precio"));
        double costo = Double.parseDouble(request.getParameter("costo"));
        int min = Integer.parseInt(request.getParameter("min"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int prov = Integer.parseInt(request.getParameter("prov"));

        try {
//Leemos el driver de Mysql
            Class.forName("com.mysql.jdbc.Driver");
// Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ERP", "root", "kira?123");
// Permite ejecutar sentencias SQL sin parámetros
            Statement s = conexion.createStatement();
//            s.executeUpdate("Insert into productos "
//                    + "values(0,'" + name + "','" + desc + "','" + marca + "',"
//                    + precio + "," + costo + "," + min + "," + stock + ","+prov+")");
            s.execute("call insProducto('" + name + "','" + desc + "','" + marca + "',"
                    + precio + "," + costo + "," + min + "," + stock + "," + prov + ")");
            rs = s.executeQuery("select * from productos");
//Decimos que nos hemos conectado
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Datos Ingresados Exitosamente</h1>");
            out.println("<table align='center' with='75%' border=1>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("nombre") + "</td><td>"
                        + rs.getString("descripcion") + "</td><td>" + rs.getString("marca") + "</td><td>"
                        + rs.getString("precio") + "</td><td>" + rs.getInt("costo") + "</td><td>" + rs.getString("minimo") + "</td>"
                        + "                 <td>" + rs.getInt("stok") + "</td> </tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            conexion.close();
        } catch (ClassNotFoundException e1) {
//Error si no puedo leer el driver
            out.println("ERROR:No encuentro el driver de la BD: "
                    + e1.getMessage());
        } catch (SQLException e2) {
//Error SQL: login/passwd mal
            out.println("ERROR:Fallo en SQL: " + e2.getMessage());
        } finally {
            out.close();
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
