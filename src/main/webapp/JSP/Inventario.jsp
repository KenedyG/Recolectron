<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Modelo.InventarioJB" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inventario Disponible</title>
</head>
<body>
<h1>Lista de Inventario:</h1>
<table border="1">
    <thead>
    <tr>
        <th>id_electronico</th>
        <th>nombre</th>
        <th>fabricante</th>
        <th>modelo</th>
        <th>especificaciones</th>
        <th>peso</th>
        <th>status</th>
        <th>stock</th>
    </tr>
    </thead>
    <tbody>
    <jsp:include page="/SVInventario" />
    <%
        List<InventarioJB> inventarioList = (List<InventarioJB>) request.getAttribute("inventario");
        if (inventarioList != null && !inventarioList.isEmpty()) {
            for (InventarioJB inventario : inventarioList) {
    %>
    <tr>
        <td><%= inventario.getIdelectronico() %></td>
        <td><%= inventario.getNombre() %></td>
        <td><%= inventario.getFabricante() %></td>
        <td><%= inventario.getModelo() %></td>
        <td><%= inventario.getEspecificaciones() %></td>
        <td><%= inventario.getPeso() %></td>
        <td><%= inventario.getStatus() %></td>
        <td><%= inventario.getStock() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="8">No hay datos</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
