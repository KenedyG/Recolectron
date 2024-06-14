<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.SolicitudesJB" %>
<%@ page import="Modelo.AlumnosJB" %>

<%
    List<SolicitudesJB> solicitudList = (List<SolicitudesJB>) request.getAttribute("solicitudes");
    List<AlumnosJB> alumnoList = (List<AlumnosJB>) request.getAttribute("alumnos");
    if (alumnoList == null || alumnoList.isEmpty()) {

        request.getRequestDispatcher("/SVAlumno").forward(request, response);
        return;
    }

    if (solicitudList == null || solicitudList.isEmpty()) {
        request.getRequestDispatcher("/SVSolicitudes").forward(request, response);
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Solicitudes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
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
    </style>
</head>
<body>
<div class="content-container">
    <!-- Contenedor de la tabla de solicitudes -->
    <div class="container">
        <h1>Lista de Solicitudes:</h1>
        <table>
            <thead>
            <tr>
                <th>ID Solicitud</th>
                <th>Número de Equipo</th>
                <th>Fecha de Solicitud</th>
                <th>Fecha de Uso</th>
                <th>Status</th>
                <th>ID Alumno</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (solicitudList == null || solicitudList.isEmpty()) {
            %>
            <tr>
                <td colspan="6">No hay solicitudes registradas</td>
            </tr>
            <%
            } else {
                // Iterar sobre la lista de solicitudes y mostrar los datos en la tabla
                for (SolicitudesJB solicitud : solicitudList) {
            %>
            <tr>
                <td><%= solicitud.getIdSolicitud() %></td>
                <td><%= solicitud.getNoequipo() %></td>
                <td><%= solicitud.getFechaSolicitud() %></td>
                <td><%= solicitud.getFechaUso() %></td>
                <td><%= solicitud.getStatus() %></td>
                <td><%= solicitud.getIdalumno() %></td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>

    <div class="container form-container">
        <h2>Agregar Solicitud</h2>
        <form action="<%= request.getContextPath()%>/SVSolicitudA" method="get">
            <div class="form-group">
                <label for="noequipo">Número de Equipo:</label>
                <input type="text" id="noequipo" name="noequipo" required>
            </div>
            <div class="form-group">
                <label for="fechaUso">Fecha de Uso:</label>
                <input type="date" id="fechaUso" name="fechaUso" required>
            </div>
            <div class="form-group">
                <label for="horaUso">Hora de Uso:</label>
                <input type="time" id="horaUso" name="horaUso" step="1" required>
            </div>
            <div class="form-group">
                <label for="idalumno">ID Alumno:</label>
                <select id="idalumno" name="idalumno" required>
                    <option value="">Seleccione un alumno</option>
                    <%
                        if (alumnoList != null) {
                            for (AlumnosJB alumno : alumnoList) {
                    %>
                    <option value="<%= alumno.getIdalumno() %>"><%= alumno.getNombre() %> - <%= alumno.getMateria() %></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <button type="submit">Agregar Solicitud</button>
            </div>
        </form>
    </div>


    <div class="container form-container">
        <h2>Registrar Alumno</h2>
        <form action="<%= request.getContextPath()%>/SVAlumnoRegistro" method="get">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="materia">Materia:</label>
                <input type="text" id="materia" name="materia" required>
            </div>
            <div class="form-group">
                <button type="submit">Registrar Alumno</button>
            </div>
        </form>
    </div>


</div>
</body>
</html>