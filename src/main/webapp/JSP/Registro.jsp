<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>Inicio de Sesión</title>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../CSS/LoginStyle.css">
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-in">
        <form action="<%= request.getContextPath()%>/SVLogin" method="post" class="form-sign-in">
            <h1>Inicio de Sesión</h1>
            <input type="text" name="Usuario" id="usuario2" placeholder="Usuario" required>
            <input type="password" name="Password" id="pswd2" placeholder="Contraseña" required>
            <input type="submit" value="Iniciar Sesión">
        </form>
    </div>
</div>

</body>
</html>
