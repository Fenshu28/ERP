<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.mycompany.erp.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Proveedores</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@320&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
        <!-- Agregar los enlaces a Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Font Awesome for icons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <style>
            *{
                font-family: "Roboto Condensed", sans-serif;
                font-optical-sizing: auto;
                font-weight: 400;
                font-style: normal;
            }
            .table {
                font-size: 18px;
            }
            .table th, .table td {
                text-align: center; /* Centrar el texto en las celdas */
                vertical-align: middle; /* Centrar verticalmente el contenido */

            }
            .acciones-col {
                width: 150px; /* Ajusta este valor según sea necesario */
                white-space: nowrap; /* Evita que el contenido de las celdas se divida en varias líneas */
            }
            .acciones-col .btn {
                margin-right: 5px; /* Ajuste para espacio entre botones si es necesario */
            }
        </style>
    </head>
    <body>
        <%!int indexProveedor = -1;%>
        <div class="container">
            <div class="row m-5">
                <h2 class="col-9">Lista de Proveedores</h2>
                <!-- Button to add a new provider -->
                <button type="button" class="col-3 btn btn-success" data-toggle="modal" data-target="#agregarProveedorModal" onclick="newProveedor()">
                    <i class="fas fa-plus"></i> Agregar
                </button>
            </div>
            <table class="table table-striped table-bordered w-100">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th class="m-5">Nombre</th>
                        <th>Teléfono</th>
                        <th class="acciones-col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Proveedor> proveedores = new ArrayList<>();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            // Establecer conexión con la base de datos
                            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ERP", "root", "kira?123");
                            // Llamar al procedimiento almacenado
                            CallableStatement cs = conexion.prepareCall("call readProveedor()");
                            ResultSet rs = cs.executeQuery();
                            int i = 1;
                        
                            while (rs.next()) {
                                // Recuperar los datos de cada proveedor
                                Proveedor proveedor = new Proveedor();
                                proveedor.setIdProveedor(rs.getInt("idproveedor"));
                                proveedor.setNombrrpro(rs.getString("nombrepro"));
                                proveedor.setDireccion(rs.getString("direccion"));
                                proveedor.setRfc(rs.getString("rfc"));
                                proveedor.setTelefono(rs.getString("telefono"));
                                proveedores.add(proveedor);
                    %>
                    <tr>
                        <td><%= i %></td>
                        <td><%= proveedor.getNombrrpro() %></td>
                        <td><%= proveedor.getTelefono() %></td>
                        <td class="acciones-col">
                            <!-- Edit button -->
                            <button type="button" class="btn btn-primary btn-sm edit-btn" 
                                    data-edit-id="<%= proveedor.getIdProveedor() %>"><i class="fas fa-edit"></i> Editar</button>
                            <!-- Delete button -->
                            <button type="button" class="btn btn-danger btn-sm del-btn" 
                                    data-del-id="<%= proveedor.getIdProveedor() %>"><i class="fas fa-trash-alt"></i> Eliminar</button>
                            <!-- View button -->
                            <button type="button" class="btn btn-info btn-sm view-btn" 
                                    data-id="<%= proveedor.getIdProveedor() %>" 
                                    data-nombre="<%= proveedor.getNombrrpro() %>"
                                    data-direccion="<%= proveedor.getDireccion() %>"
                                    data-rfc="<%= proveedor.getRfc() %>"
                                    data-telefono="<%= proveedor.getTelefono() %>">
                                <i class="fas fa-eye"></i> Visualizar
                            </button>
                        </td>
                    </tr>
                    <%
                        i++;
                }
                // Cerrar conexión y liberar recursos
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();%>
                    <tr>
                        <td colspan="6"><%= e.getMessage() %></td>
                    </tr>

                    <%

            }
                    %>
                </tbody>
            </table>
        </div>



        <!-- Cuadro de diálogo (aviso) -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"><%=request.getAttribute("tipoResult")%></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <%=request.getAttribute("idResult")%>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.href = 'Proveedores.jsp';"> Cerrar </button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Cuadro de diálogo (visualizar) -->
        <div class="modal fade" id="viewModal" tabindex="-2" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos del proveedor</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table border="0" cellspacing="1" cellpadding="1">
                            <tbody>
                                <tr>
                                    <td>Nombre: </td>
                                    <td id="modal-nombre"></td>
                                </tr>
                                <tr>
                                    <td>Dirección: </td>
                                    <td id="modal-direccion"></td>
                                </tr>
                                <tr>
                                    <td>RFC: </td>
                                    <td id="modal-rfc"></td>
                                </tr>
                                <tr>
                                    <td>Telefono: </td>
                                    <td id="modal-telefono"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>


    </body>

    <!-- Bootstrap JS y dependencias de jQuery y Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


    <script>
                            document.querySelectorAll('.edit-btn').forEach(button => {
                                button.addEventListener('click', function () {
                                    var idProveedor = this.getAttribute('data-edit-id');
                                    editProveedor(idProveedor);
                                });
                            });
                            document.querySelectorAll('.del-btn').forEach(button => {
                                button.addEventListener('click', function () {
                                    var idProveedor = this.getAttribute('data-del-id');
                                    deleteProveedor(idProveedor);
                                });
                            });
                            document.querySelectorAll('.view-btn').forEach(button => {
                                button.addEventListener('click', function () {
                                    var nombre = this.getAttribute('data-nombre');
                                    var direccion = this.getAttribute('data-direccion');
                                    var rfc = this.getAttribute('data-rfc');
                                    var telefono = this.getAttribute('data-telefono');
                                    document.getElementById('modal-nombre').innerText = nombre;
                                    document.getElementById('modal-direccion').innerText = direccion;
                                    document.getElementById('modal-rfc').innerText = rfc;
                                    document.getElementById('modal-telefono').innerText = telefono;
                                    $('#viewModal').modal('show');
                                });
                            });
                            function deleteProveedor(idProveedor) {
        <%
                            cs = conexion.prepareCall("call deleteProveedor (" + idProveedor + " )");
                            cs.executeQuery();
        %>
                window.location.href = "Proveedores.jsp";
                                //window.location.href = "ProveedorServlet?id=" + idProveedor + "&&tipo=2";
                            }
                            function editProveedor(idProveedor) {
                                window.location.href = "ConfigProveedor.jsp?id=" + idProveedor + "&&tipo=1";
                            }
                            function newProveedor() {
                                window.location.href = "ConfigProveedor.jsp?id=0";
                            }
                            window.onload = function () {
        <% if (request.getAttribute("idResult") != null) { %>
                                $('#myModal').modal('show');
        <% } %>
                            };
    </script>


</html>
