package Controlador;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import Datos.SolucitudesDAO;
import Modelo.SolicitudesJB;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVVerSolicitudes",value = "/SVVerSolicitudes")
public class SVVerSolicitudes extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SolucitudesDAO solucitudesDAO = new SolucitudesDAO();
    private SolicitudesJB solicitudesJB = new SolicitudesJB();

    public <httpServletRequest> void doGet(httpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolucitudesDAO solucitudesDAO = new SolucitudesDAO();
        List<SolicitudesJB> solicitudesJBList = (List<SolicitudesJB>) solucitudesDAO;
        request.getRequestDispatcher("./JSP/JSP").forward(request, response);

    }
}

