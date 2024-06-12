<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 12/06/2024
  Time: 11:25 p. m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.InventarioJB" %>

<%
    //Se crea la lista, se recibe el atributo mencionado en el Servlet
    List<InventarioJB> inventarioList = (List<InventarioJB>) request.getAttribute("inventario");

    //Comprueba que la lista no esté vacía
    if (inventarioList == null || inventarioList.isEmpty()) {
        //Llama al servlet por fin, por esto no funcionaban las anteriores versiones, esto ya es el estandar para los
        //demas jsp que tengan que ver con tablas.
        request.getRequestDispatcher("/SVInventario").forward(request, response);
        return; // Se detiene
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Inventario Disponible</title>
    <link rel="stylesheet" href="../CSS/RegistroStyle.css">
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Satoshi', sans-serif;
        }

        nav {
            height: 80px;
            background: #587ea1;
            display: flex;
            font-size: 20px;
            font-weight: bold;
            justify-content: space-between;
            align-items: center;
            padding: 0 calc((100vw - 1300px)/2);
        }

        .logo {
            color: #000;
            font-size: 2.5rem;
            font-weight: bold;
            padding: 0 2rem;
        }

        .nav-items {
            display: flex;
        }

        nav a {
            text-decoration: none;
            color: black;
            padding: 0 1.5rem;
        }

        .content-container {
            padding: 3rem calc((100vw - 1300px)/2);
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

        .btn {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            margin: 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        .btn-eliminar {
            background-color: #f44336; /* Red */
        }
    </style>
</head>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="Vista_Empleado.jsp">Regresar a la pagina principal</a>
    </div>
</nav>
<body>
<div class="content-container">
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
        <%
            // Iterar sobre la lista de inventario y mostrar los datos en la tabla
            for (InventarioJB inventario : inventarioList) {
        %>
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
                <a href="ModInventario.jsp">Modificar</a>
                </form>
                <form action="<%= request.getContextPath()%>/SVMInventario" method="post">
                    <input type="hidden" name="action" value="eliminar">
                    <input type="hidden" name="id" value="<%= inventario.getIdelectronico() %>">
                    <button type="submit" class="btn btn-eliminar">Eliminar</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
