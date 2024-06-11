<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 11/06/2024
  Time: 12:16 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alta de Alumno</title>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../CSS/RegistroStyle.css">
</head>
<body>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="Vista_Admin.jsp">Regresar a la pagina principal</a>
    </div>
</nav>

<div class="container" id="container">
    <div class="form-container sign-up">
        <form action="<%= request.getContextPath()%>/SVRegistro" method="post">
            <h1>Registro de Alumno</h1>
            <input type="text" name="Nombre" id="nombre" placeholder="Nombre" required>
            <input type="text" name="Apellido Paterno" id="apellidoP" placeholder="Apellido Paterno" required>
            <input type="text" name="Apellido Materno" id="apellidoM" placeholder="Apellido Materno" required>
            <input type="email" name="Correo" id="correo" placeholder="Correo" required>
            <input type="text" name="Usuario" id="usuario" placeholder="Usuario" required>
            <input type="password" name="Password" id="pswd1" placeholder="Contraseña"required>
            <input type="submit" value="Registrarse">
        </form>
    </div>
</div>
</body>
</html>
