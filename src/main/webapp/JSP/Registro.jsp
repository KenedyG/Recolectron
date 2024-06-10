<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>Inicio de Sesión</title>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../CSS/LoginStyle.css">
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-up">
        <form action="<%= request.getContextPath()%>/SVRegistro" method="post">
            <h1>Registrarse</h1>
            <input type="text" name="Nombre" id="nombre" placeholder="Nombre" required>
            <input type="text" name="Apellido Paterno" id="apellidoP" placeholder="Apellido Paterno" required>
            <input type="text" name="Apellido Materno" id="apellidoM" placeholder="Apellido Materno" required>
            <input type="email" name="Correo" id="correo" placeholder="Correo" required>
            <input type="text" name="Usuario" id="usuario" placeholder="Usuario" required>
            <input type="password" name="Contraseña" id="pswd1" placeholder="Contraseña"required>
            <input type="submit" value="Registrarse">
        </form>
    </div>
    <div class="form-container sign-in">
        <form action="<%= request.getContextPath()%>/SVLogin" method="post" class="form-sign-in">
            <h1>Inicio de Sesión</h1>
            <input type="text" name="Usuario" id="usuario2" placeholder="Usuario" required>
            <input type="password" name="Contraseña" id="pswd2" placeholder="Contraseña" required>
            <input type="submit" value="Iniciar Sesión">
        </form>
    </div>
    <div class="toggle-container">
        <div class="toggle">
            <div class="toggle-panel toggle-left">
                <h1>O Iniciar Sesión</h1>
                <p>En caso de ya estar registrado</p>
                <button class="hidden" id="login">Iniciar Sesión</button>
            </div>
            <div class="toggle-panel toggle-right">
                <h1>O Registrarse</h1>
                <p>En caso de no tener cuenta</p>
                <button class="hidden" id="registro">Registrarse</button>
            </div>
        </div>
    </div>
</div>

<script src="../JS/test.js"></script>
</body>
</html>
