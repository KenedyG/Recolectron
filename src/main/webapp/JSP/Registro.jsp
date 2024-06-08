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
        <form action="../SVRegistro" method="post">
            <h1>Registrarse</h1>
            <input type="text" name="Nombre" id="nombre" placeholder="Nombre">
            <input type="text" name="Apellido Paterno" id="apellidoP" placeholder="Apellido Paterno">
            <input type="text" name="Apellido Materno" id="apellidoM" placeholder="Apellido Materno">
            <input type="email" name="Correo" id="correo" placeholder="Correo">
            <input type="text" name="Usuario" id="usuario" placeholder="Usuario">
            <input type="password" name="Contraseña" id="pswd1" placeholder="Contraseña">
            <button>Registrarse</button>
        </form>
    </div>
    <div class="form-container sign-in">
        <form action="../SVLogin" method="post">
            <h1>Inicio de Sesión</h1>
            <input type="email" name="Correo" id="correo2" placeholder="Correo">
            <input type="password" name="Contraseña" id="pswd2" placeholder="Contraseña">
            <a href="../JSP/PswdRecovery.jsp">¿Olvidaste tu Contraseña?</a>
            <button>Iniciar Sesión</button>
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
