<%@ page import="java.sql.*" %>
<%    
    int idProveedor = Integer.parseInt(request.getParameter("id"));
    int tipo = 0;
    if (request.getParameter("tipo") != null) {
        tipo = Integer.parseInt(request.getParameter("tipo"));
    }

    String nombre = "";
    String direccion = "";
    String rfc = "";
    String telefono = "";

    if (idProveedor != 0) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ERP", "root", "kira?123");
            CallableStatement cs = conexion.prepareCall("call readByIdProveedor(?)");
            cs.setInt(1, idProveedor);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                nombre = rs.getString("nombrepro");
                direccion = rs.getString("direccion");
                rfc = rs.getString("rfc");
                telefono = rs.getString("telefono");
            }

            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
%><%= e.getMessage() %> <%
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Resultados de Empleados</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Proveedor </h1>
            <!-- Formulario de edición -->
            <form action="ProveedorServlet" method="post">
                <input type="hidden" name="tipo" value="<%= tipo %>">
                <input type="hidden" name="idProveedor" value="<%= idProveedor %>">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="<%= nombre %>" required>
                </div>
                <div class="form-group">
                    <label for="direccion">Dirección:</label>
                    <input type="text" class="form-control" id="direccion" name="direccion" value="<%= direccion %>" required>
                </div>
                <div class="form-group">
                    <label for="rfc">RFC:</label>
                    <input type="text" class="form-control" id="rfc" name="rfc" value="<%= rfc %>" required>
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" value="<%= telefono %>" required>
                </div>
                <button type="submit" class="btn btn-primary" name="Guardar">Guardar</button>
            </form>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
