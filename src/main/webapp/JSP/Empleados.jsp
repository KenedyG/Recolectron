<%--
  Created by IntelliJ IDEA.
  User: kenedy
  Date: 13/06/2024
  Time: 12:31 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.AsistenciasJB" %>
<%@ page import="Modelo.RegistroJB" %>

<%
    List<AsistenciasJB> asistenciasJBList = (List<AsistenciasJB>) request.getAttribute("Asistencia");
    List<RegistroJB> alumnoList = (List<RegistroJB>) request.getAttribute("alumnos");


    if(asistenciasJBList == null || asistenciasJBList.isEmpty()){
        request.getRequestDispatcher("/SVERAsistencias").forward(request,response);
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Asistencia de Empleados</title>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">
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

        h1 {
            color: black;
            padding-bottom: 10px;
            margin-bottom: 20px;
            border-bottom: 2px solid #ddd;
        }

        body {
            font-family: 'Satoshi', sans-serif;
            background-color: #F0F0F0;
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
    </style>
</head>
<body>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="Vista_Admin.jsp">Regresar a la página principal</a>
    </div>
</nav>
<div class="content-container">
    <div class="container">
        <h1>Lista de Empleados:</h1>
        <table>
            <thead>
            <tr>
                <th>ID Asistencia</th>
                <th>Hora Entrada</th>
                <th>Hora Salida</th>
                <th>ID User</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (AsistenciasJB asistencias : asistenciasJBList) {
            %>
            <tr>
                <td><%= asistencias.getId_asistencia() %></td>
                <td><%= asistencias.getHoraentrada() %></td>
                <td><%= asistencias.getHorasalida() %></td>
                <td><%= asistencias.getId_User() %></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
