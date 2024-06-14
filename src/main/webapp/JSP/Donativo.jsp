<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 13/06/2024
  Time: 02:38 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.DonativoJB" %>

<%
    // Se recibe el atributo mencionado en el Servlet
    List<DonativoJB> donativoList = (List<DonativoJB>) request.getAttribute("donativos");

    // Comprueba que la lista no esté vacía
    if (donativoList == null || donativoList.isEmpty()) {
        // Llama al servlet si la lista es nula o está vacía
        request.getRequestDispatcher("/SVDonativo").forward(request, response);
        return; // Se detiene
    }
%>

<!DOCTYPE html>
<html>
<head>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">

    <title>Donativos</title>
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

    </style>
</head>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="Vista_Empleado.jsp">Regresar a la página principal</a>
    </div>
</nav>
<body>
<div class="content-container">
    <div class="container">
        <h1>Lista de Donativos:</h1>
        <table>
            <thead>
            <tr>
                <th>ID Donativo</th>
                <th>Nombre</th>
                <th>Nombre Objeto</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (donativoList == null || donativoList.isEmpty()) {
            %>
            <tr>
                <td colspan="6">No hay donativos </td>
            </tr>
            <%
            } else {
                for (DonativoJB donativo : donativoList) {
            %>
            <tr>
                <td><%= donativo.getIdDonativo() %></td>
                <td><%= donativo.getNombre() %></td>
                <td><%= donativo.getNombreobjeto() %></td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>

    <div class="container form-container">
        <h2>Registrar Donativo</h2>
        <form action="<%= request.getContextPath()%>/SVDonativoR" method="get">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="nombreObjeto">Nombre del Objeto:</label>
                <input type="text" id="nombreObjeto" name="nombreObjeto" required>
            </div>
            <div class="form-group">
                <button type="submit">Registrar objeto</button>
            </div>
        </form>
    </div>


</div>
</body>
</html>