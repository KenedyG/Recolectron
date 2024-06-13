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

<%
    List<AsistenciasJB> asistenciasJBList = (List<AsistenciasJB>) request.getAttribute("Asistencia");

    if(asistenciasJBList == null || asistenciasJBList.isEmpty()){
        request.getRequestDispatcher("SVERAsistencias ").forward(request,response);
    return;
    }%>
<!DOCTYPE html>
<html>
<head>
    <title>Empleados Asistencias</title>
    <link>link rel="stylesheet" href="../CSS/RegistroStyle.css">
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
<div class="content-container">
    <h1>Lista de Epleados:</h1>
    <table>
        <thead>
        <tr>
            <th>ID asistencia</th>
            <th>Horaentrada</th>
            <th>Horasalida</th>
            <th>id User</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Iterar sobre la lista de inventario y mostrar los datos en la tabla
            for (AsistenciasJB asistencias : asistenciasJBList) {
        %>
        <tr>
            <td><%= asistencias.getId_asistencia() %></td>
            <td><%= asistencias.getHoraentrada() %></td>
            <td><%= asistencias.getHorasalida() %></td>
            <td><%= asistencias.getId_User() %></td>
            <td>
                <a href="ModInventario.jsp">Modificar</a>
                </form>
                <form action="<%= request.getContextPath()%>/SVERAsistencias" method="post">
                    <input type="hidden" name="action" value="eliminar">
                    <input type="hidden" name="id" value="<%= asistencias.getId_User() %>">
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
