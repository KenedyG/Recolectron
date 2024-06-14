<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 12/06/2024
  Time: 11:25 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.InventarioJB" %>
<%@ page import="Modelo.RegistroEgresoJB" %>

<%
    List<InventarioJB> inventarioList = (List<InventarioJB>) request.getAttribute("inventario");
    List<RegistroEgresoJB> registroEList = (List<RegistroEgresoJB>) request.getAttribute("registroList");
    if (registroEList == null || registroEList.isEmpty()) {
        request.getRequestDispatcher("/SVEgresoL").forward(request, response);
        return;
    }
    if (inventarioList == null || inventarioList.isEmpty()) {
        request.getRequestDispatcher("/SVInventario").forward(request, response);
        return;
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario Disponible</title>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Satoshi', sans-serif;
            background-color: #F0F0F0;
        }

        .content-container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #f2f2f2;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .container {
            background-color: #f9f9f9;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            color: black;
            padding-bottom: 10px;
            margin-bottom: 20px;
            border-bottom: 2px solid #ddd;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .form-group button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #218838;
        }

        nav {
            background-color: #587ea1;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 2rem;
            font-weight: bold;
        }

        .nav-items {
            display: flex;
            gap: 10px;
        }

        .nav-items a {
            color: white;
            text-decoration: none;
            padding: 8px 12px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .nav-items a:hover {
            background-color: #45698e;
        }
        .btn {
            padding: 8px 12px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            color: white;
            text-decoration: none;
            display: inline-block;
        }

        .btn-modificar {
            background-color: #007bff;
        }

        .btn-modificar:hover {
            background-color: #0056b3;
        }

        .btn-eliminar {
            background-color: #dc3545;
        }

        .btn-eliminar:hover {
            background-color: #c82333;
        }

    </style>
</head>
<body>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="Vista_Empleado.jsp">Regresar a la página principal</a>
    </div>
</nav>
<div class="content-container">
    <div class="container">
        <h1>Lista de Inventario:</h1>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Fabricante</th>
                <th>Modelo</th>
                <th>Especificaciones</th>
                <th>Peso</th>
                <th>Status</th>
                <th>Stock</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <% for (InventarioJB inventario : inventarioList) { %>
            <tr>
                <td><%= inventario.getIdelectronico() %></td>
                <td><%= inventario.getNombre() %></td>
                <td><%= inventario.getFabricante() %></td>
                <td><%= inventario.getModelo() %></td>
                <td><%= inventario.getEspecificaciones() %></td>
                <td><%= inventario.getPeso() %></td>
                <td><%= inventario.getStatus() %></td>
                <td><%= inventario.getStock() %></td>
                <td>
                    <a href="../JSP/ModInventario.jsp" class="btn btn btn-modificar">Modificar</a>
                    <form action="<%= request.getContextPath()%>/SVMInventario" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="eliminar">
                        <input type="hidden" name="id" value="<%= inventario.getIdelectronico() %>">
                        <button type="submit" class="btn btn-eliminar">Eliminar</button>
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <div class="content-container">
        <div class="container">
            <h1>Lista de Egresos:</h1>
            <table>
                <thead>
                <tr>
                    <th>ID Egreso</th>
                    <th>Nombre</th>
                    <th>Matricula</th>
                    <th>Materia</th>
                    <th>Facultad</th>
                    <th>Carrera</th>
                    <th>Nivel Academico</th>
                    <th>Monto de Donativo:</th>
                    <th>Fecha de Egreso</th>
                    <th>ID Electronico</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (registroEList == null || registroEList.isEmpty()) {
                %>
                <tr>
                    <td colspan="6">No hay donativos </td>
                </tr>
                <%
                } else {
                    for (RegistroEgresoJB registro : registroEList) {
                %>
                <tr>
                    <td><%= registro.getIdRegistroEgreso() %></td>
                    <td><%= registro.getNombre() %></td>
                    <td><%= registro.getMatricula() %></td>
                    <td><%= registro.getMateria() %></td>
                    <td><%= registro.getFacultad() %></td>
                    <td><%= registro.getCarrera() %></td>
                    <td><%= registro.getNivelacademico() %></td>
                    <td><%= registro.getDonativo() %></td>
                    <td><%= registro.getFecha() %></td>
                    <td><%= registro.getIdelectronico() %></td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    <div class="container form-container">
        <h2>Registrar Egreso de Inventario</h2>
        <form action="<%= request.getContextPath()%>/SVEgreso" method="get">
            <div class="form-group">
                <label for="nombre">Nombre Completo:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="matricula">Matricula:</label>
                <input type="text" id="matricula" name="matricula" required>
            </div>
            <div class="form-group">
                <label for="materia">Materia:</label>
                <input type="text" id="materia" name="materia" required>
            </div>
            <div class="form-group">
                <label for="facultad">Facultad:</label>
                <input type="text" id="facultad" name="facultad" required>
            </div>
            <div class="form-group">
                <label for="carrera">Carrera:</label>
                <input type="text" id="carrera" name="carrera" required>
            </div>
            <div class="form-group">
                <label for="nivel_academico">Nivel Academico:</label>
                <input type="text" id="nivel_academico" name="nivel_academico" required>
            </div>
            <div class="form-group">
                <label for="donativoe">Monto de Donativo:</label>
                <input type="number" id="donativoe" name="donativoe" required>
            </div>
            <div class="form-group">
                <label for="fecha">Fecha de Egreso:</label>
                <input type="date" id="fecha" name="fecha" required>
            </div>
            <div class="form-group">
                <label for="id_electronico">ID del Electronico:</label>
                <input type="number" id="id_electronico" name="id_electronico" required>
            </div>
            <div class="form-group">
                <button type="submit">Registrar Egreso</button>
            </div>
        </form>
    </div>
    </div>
</div>
</body>
</html>
