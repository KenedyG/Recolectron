package Controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.SolicitudesJB;
import Datos.SolucitudesDAO;

@WebServlet(name = "SVSolicitudes", value = "/SVSolicitudes")
public class SVSolicitudH extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DIABLO");
        SolucitudesDAO solicitudDAO = new SolucitudesDAO();
        List<SolicitudesJB> listaSolicitudes = solicitudDAO.solicitudes();


        request.setAttribute("solicitudes", listaSolicitudes);
        System.out.println("VA DE REGRESO");
        request.getRequestDispatcher("/JSP/Solicitudes.jsp").forward(request, response);
        System.out.println("REGRESE");
 
    }

}
