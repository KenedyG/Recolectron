<%--
  Created by IntelliJ IDEA.
  User: kenedy
  Date: 13/06/2024
  Time: 12:31 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.AsistenciasJB" %>


<%
    List<AsistenciasJB> asistenciasJBList = (List<AsistenciasJB>) request.getAttribute("Asistencia");

    if(asistenciasJBList == null || asistenciasJBList.isEmpty()){
        request.getRequestDispatcher("SVAsistencias ")
    }
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
