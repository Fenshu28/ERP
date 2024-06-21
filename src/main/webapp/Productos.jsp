
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="com.mycompany.erp.Conexion" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <h1>Productos</h1>
        
        <form action="ProductosServlet">
            <table cellpadding="4">
                <tbody>
                    <tr>
                        <td><label for="nombre">Nombre:</label></td>
                        <td><input type="text" name="nombre" id="nombre" required></td>
                    </tr>


                    <tr>
                        <td><label for="desc">Descripción:</label></td>
                        <td><input type="text" name="desc" id="desc" required></td>
                    </tr>
                    <tr>
                        <td><label for="marca">Marca:</label></td>
                        <td><input type="text" name="marca" id="marca" required></td>
                    </tr>
                    <tr>
                        <td><label for="costo">Precio:</label></td>
                        <td><input type="number" name="precio" id="precio" required></td>
                    </tr>
                    <tr>
                        <td><label for="costo">Costo:</label></td>
                        <td><input type="number" name="costo" id="costo" required></td>
                    </tr>
                    <tr>
                        <td><label for="min">Mínimo:</label></td>
                        <td><input type="number" name="min" id="min" required></td>
                    </tr>
                    <tr>
                        <td><label for="stock">Stock</label></td>
                        <td><input type="text" name="stock" id="stock" required></td>
                    </tr>
                    <tr>
                        <td><label for="prov">Proveedor</label></td>
                        <td><select name="prov"> 
                                <% 
                                Connection con = null;
                                Statement st = null;
                                ResultSet rs = null;
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    con = DriverManager.getConnection("jdbc:mysql://localhost/ERP?user=root&password=kira?123");
                                    st = con.createStatement();
                                    rs = st.executeQuery("select idproveedor,nombrepro from proveedor");                
                                    while (rs.next()) {                    
                                %>               
                                <option value="<%= rs.getString(1)%>"><%= rs.getString(2)%></option>
                                <%
                
                                    }
                
                                    con.close();
                                } catch (ClassNotFoundException e1) {
                                    out.println("ERROR:No encuentro el driver de la BD: "
                                            + e1.getMessage());
                                }
                                %>
                            </select> <br></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Guardar"></td>
                    </tr>
                </tbody>
            </table>

        </form>


    </body>
</html>
