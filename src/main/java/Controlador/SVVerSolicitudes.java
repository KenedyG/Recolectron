package Controlador;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.InventarioDAO;
import Datos.SolucitudesDAO;
import Modelo.InventarioJB;
import Modelo.SolicitudesJB;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVVerSolicitudes",value = "/SVVerSolicitudes")
public class SVVerSolicitudes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SolucitudesDAO solucitudesDAO = new SolucitudesDAO();
    private SolicitudesJB solicitudesJB = new SolicitudesJB();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{

        SolucitudesDAO solucitudesDAO1 = new SolucitudesDAO();
        List<SolicitudesJB> solicitudesJBList = solucitudesDAO1.solicitudes();
        request.setAttribute("Solicitudes",solucitudesDAO1);
        request.getRequestDispatcher("./JSP/Solicitudes.JSP").forward(request,response);
    }
}

