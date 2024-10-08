<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 09/06/2024
  Time: 05:10 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vista de Empleado</title>
    <link rel="icon" href="../IMG/Reco_Logo_Min.png" type="image/x-icon">
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../CSS/EmpleadoStyle.css">
</head>
<body>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="<%=request.getContextPath()%>/SvLogout">Cerrar Sesión</a>
    </div>
</nav>
<section class="content">
    <div class="content-container">
        <div class="opciones">
            <h1>Bienvenido, Empleado</h1>
            <ul>
                <li><a href="Inventario.jsp">Ir a Inventario y Egresos</a></li>
                <li><a href="Solicitudes.jsp">Administrador de Horarios</a></li>
                <li><a href="Asistencia.jsp">Marcar Entrada y Salida</a></li>
                <li><a href="Donativo.jsp">Administrador de Donativos</a></li>
            </ul>
        </div>
    </div>
</section>
</body>
</html>
