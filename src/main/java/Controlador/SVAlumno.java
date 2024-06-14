package Controlador;

import Datos.AlumnosDAO;
import Modelo.AlumnosJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVAlumno", value = "/SVAlumno")
public class SVAlumno extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Entre");
        AlumnosDAO alumnosDAO = new AlumnosDAO();
        List<AlumnosJB> alumnoList = alumnosDAO.listar();
        request.setAttribute("alumnos", alumnoList);

        request.getRequestDispatcher("/JSP/Solicitudes.jsp").forward(request, response);
    }
}
