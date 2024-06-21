package com.mycompany.erp;

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empleadosbusqueda")
public class empleadosbusqueda extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP", "root", "JAME060503");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("byId".equals(action)) {
            getEmpleadoById(request, response);
        } else if ("byName".equals(action)) {
            getEmpleadoByName(request, response);
        }
    }

    private void getEmpleadoById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idEmpleado = Integer.parseInt(request.getParameter("idempleado"));
        StringBuilder result = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement("CALL v_empleados_id(?)");
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();

            result.append("<table border='1'>")
                    .append("<tr>")
                    .append("<th>ID</th>")
                    .append("<th>Nombre</th>")
                    .append("<th>Direccion</th>")
                    .append("<th>Telefono</th>")
                    .append("<th>Usuario</th>")
                    .append("<th>Sexo</th>")
                    .append("<th>Fecha de nacimiento</th>")
                    .append("<th>cargo</th>")
                    .append("<th>Nombre del usuario</th>")
                    .append("<th>Email del usuario</th>")
                    .append("<th>Nivel del usuario</th>")
                    .append("</tr>");
                    
            while (rs.next()) {
                result.append("<tr>")
                      .append("<td>").append(rs.getInt("idempleado"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("nombre"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("direccion"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("telefono"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("usuario"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("sexo"))
                      .append("</td>")
                      .append("<td>").append(rs.getDate("fecha_nacimiento"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("cargo"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("user_nombre"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("users_email"))
                      .append("</td>")
                      .append("<td>").append(rs.getString("user_level"))
                      .append("</tr>");
            }
                        result.append("</table>");
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("result", result.toString());
        request.getRequestDispatcher("/RESULTADOS.jsp").forward(request, response);
    }

    private void getEmpleadoByName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cadena = request.getParameter("cadena");
        StringBuilder result = new StringBuilder();
        try {
            PreparedStatement ps = connection.prepareStatement("CALL v_empleados_contiene(?)");
            ps.setString(1, cadena);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result.append(rs.getInt("idempleado"))
                      .append(" ")
                      .append(rs.getString("nombre"))
                      .append(" ")
                      .append(rs.getString("direccion"))
                      .append(" ")
                      .append(rs.getString("telefono"))
                      .append(" ")
                      .append(rs.getString("usuario"))
                      .append(" ")
                      .append(rs.getString("sexo"))
                      .append(" ")
                      .append(rs.getDate("fecha_nacimiento"))
                      .append(" ")
                      .append(rs.getString("cargo"))
                      .append(" ")
                      .append(rs.getString("user_nombre"))
                      .append(" ")
                      .append(rs.getString("users_email"))
                      .append(" ")
                      .append(rs.getString("user_level"))
                      .append("<br>");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("result", result.toString());
        request.getRequestDispatcher("/RESULTADOS.jsp").forward(request, response);
    }

    public void destroy() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}