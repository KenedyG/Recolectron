<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 09/06/2024
  Time: 05:09 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel de Administrador</title>
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
            <h1>Bienvenido, Administrador</h1>
            <ul>
                <li><a href="Inventario.jsp">Ir a Inventario</a></li>
                <li><a href="Solicitudes.jsp">Seleccionar Horario</a></li>
                <li><a href="RegistroA.jsp">Dar de Alta Alumno</a></li>
                <li><a href="RegistroA.jsp">Ver lista de Alumnos</a></li>
            </ul>
        </div>
    </div>
</section>
</body>
</html>
