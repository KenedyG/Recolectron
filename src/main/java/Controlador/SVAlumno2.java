package Controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.AlumnosDAO;
import Modelo.AlumnosJB;

import java.io.IOException;

@WebServlet(name = "SVAlumnoRegistro", value = "/SVAlumnoRegistro")
public class SVAlumno2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AlumnosDAO alumnosDAO = new AlumnosDAO();
    private AlumnosJB alumnosJB = new AlumnosJB();

    public void init(){
        alumnosDAO = new AlumnosDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String materia = request.getParameter("materia");
        System.out.println(nombre);
        System.out.println(materia);
        try{
            alumnosJB = new AlumnosJB(nombre,materia);
            alumnosDAO.AgregarAlumnos(alumnosJB);
            System.out.println("Alumno Registrado");
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/JSP/Solicitudes.jsp").forward(request, response);

    }
}
