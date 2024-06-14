<%--
  Created by IntelliJ IDEA.
  User: SOTH
  Date: 12/06/2024
  Time: 12:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Modelo.InventarioJB" %>

<!DOCTYPE html>
<html>
<head>
    <title>Buscar y Modificar Inventario</title>
    <link href="https://api.fontshare.com/v2/css?f[]=satoshi@500&display=swap" rel="stylesheet">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        nav {
            background-color: #587ea1;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 2rem;
            font-weight: bold;
            color: #333;

        }

        .nav-items {
            display: flex;
            gap: 10px;
        }

        .nav-items a {
            text-decoration: none;
            padding: 8px 12px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            color: #333;

        }

        .nav-items a:hover {
            background-color: #45698e;
        }

        h2{
            text-align: center;
        }
        h1{
          text-align: center;
            margin-bottom: 20px;
            font-size: 2rem;
            color: #333;
        }
        .container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .form-container {
            width: 45%;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-container h2 {
            margin-top: 0;
        }
        .form-container form {
            margin-top: 10px;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
        }
        .form-container input[type="text"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        .form-container button {
            padding: 10px 15px;
            background-color: #587ea1;
            color: white;
            border: none;
            cursor: pointer;
        }
        body {
            font-family: 'Satoshi', sans-serif; /* Fuente Satoshi */
        }

    </style>

</head>
<nav>
    <div class="logo">RECOLECTRÓN</div>
    <div class="nav-items">
        <a href="Vista_Empleado.jsp">Regresar a la pagina principal</a>
    </div>
</nav>
<body>
<h1>Status</h1>
<% String mensaje = (String) request.getAttribute("mensaje"); %>
<% if (mensaje != null && !mensaje.isEmpty()) { %>
<p><%= mensaje %></p>
<% } %>
<div class="container">
    <div class="form-container">
        <h2>Buscar y Modificar Inventario</h2>
        <form action="<%= request.getContextPath()%>/ModificarInventario" method="post">
            <label for="idElectronico">ID del Electrónico:</label>
            <input type="text" id="idElectronico" name="idElectronico">
            <button type="submit" name="action" value="buscar">Buscar</button>
        </form>

        <% InventarioJB inventario = (InventarioJB) request.getAttribute("inventario"); %>
        <% if (inventario != null) { %>
        <hr>
        <form action="<%= request.getContextPath()%>/ModificarInventario" method="post">
            <input type="hidden" name="id" value="<%= inventario.getIdelectronico() %>">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= inventario.getNombre() %>"><br>
            <label for="fabricante">Fabricante:</label>
            <input type="text" id="fabricante" name="fabricante" value="<%= inventario.getFabricante() %>"><br>
            <label for="modelo">Modelo:</label>
            <input type="text" id="modelo" name="modelo" value="<%= inventario.getModelo() %>"><br>
            <label for="especificaciones">Especificaciones:</label>
            <input type="text" id="especificaciones" name="especificaciones" value="<%= inventario.getEspecificaciones() %>"><br>
            <label for="peso">Peso:</label>
            <input type="text" id="peso" name="peso" value="<%= inventario.getPeso() %>"><br>
            <label for="status">Status:</label>
            <input type="text" id="status" name="status" value="<%= inventario.getStatus() %>"><br>
            <label for="stock">Stock:</label>
            <input type="text" id="stock" name="stock" value="<%= inventario.getStock() %>"><br>
            <button type="submit" name="action" value="modificar">Modificar</button>
        </form>
        <% } %>
    </div>

    <div class="form-container">
        <h2>Añadir Objeto al Inventario</h2>
        <form action="<%= request.getContextPath()%>/ModificarInventario" method="post">
            <label for="nombreNuevo">Nombre:</label>
            <input type="text" id="nombreNuevo" name="nombreNuevo">
            <label for="fabricanteNuevo">Fabricante:</label>
            <input type="text" id="fabricanteNuevo" name="fabricanteNuevo">
            <label for="modeloNuevo">Modelo:</label>
            <input type="text" id="modeloNuevo" name="modeloNuevo">
            <label for="especificacionesNuevo">Especificaciones:</label>
            <input type="text" id="especificacionesNuevo" name="especificacionesNuevo">
            <label for="pesoNuevo">Peso:</label>
            <input type="text" id="pesoNuevo" name="pesoNuevo">
            <label for="statusNuevo">Status:</label>
            <input type="text" id="statusNuevo" name="statusNuevo">
            <label for="stockNuevo">Stock:</label>
            <input type="text" id="stockNuevo" name="stockNuevo">
            <button type="submit" name="action" value="agregar">Agregar</button>
        </form>
    </div>
</div>
</body>
</html>
