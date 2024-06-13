package Controlador;

import  javax.servlet.ServletException;
import  javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Datos.AsistenciasDAO;
import Modelo.AsistenciasJB;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

@WebServlet(name = "SVEasistencias", value = "/SVERAsistencias")

public class SVERAsistencias extends Hashtable {
    private static final long SerialVersionUID = 1L;
    private AsistenciasJB asistenciasJB = new AsistenciasJB();
    private AsistenciasDAO asistenciasDAO = new AsistenciasDAO();

public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
    AsistenciasDAO asistenciasDAO01 = new AsistenciasDAO();
    List<AsistenciasJB> asistenciasDaoList = asistenciasDAO01.listar();
    request.setAttribute("Asistencias",asistenciasDAO01);
    request.getRequestDispatcher("./JSP/Empelados.JSP").forward(request,response);
}
}