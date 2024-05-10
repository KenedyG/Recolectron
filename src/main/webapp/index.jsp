<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>Inicio de Sesión</title>
    <%-- Link a la hoja de estilos, intento de usar la fuente Montserrat, está hermosa --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:semibold,600" rel="stylesheet">
    <link rel="stylesheet" href="Style.css">
</head>
<body>
    <div class = "container" id = container>
        <div class = "form-container">
            <form action="#">
                <h1>Login</h1>
                <label><b>Nombre de Usuario</b></label>
                <input type="text" name="Nombre" id="nombre" placeholder="Nombre">
                <br><br>
                <label><b>Contraseña</b></label>
                <input type="password" name="Contraseña" id="contraseña" placeholder="Contraseña">
                <br><br>
                <input type="button" name="Login" id="login" value="Iniciar Sesión">
                <br><br>
                <input type="checkbox" id="check">
                <span>Recuérdame</span>
                <br><br>
                <a href="#">¿Olvidaste tu Contraseña?</a>
            </form>
        </div>
    </div>

</body>
</html>
