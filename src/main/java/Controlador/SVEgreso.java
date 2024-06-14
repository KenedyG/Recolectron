package Controlador;

import Datos.RegistroEDAO;
import Modelo.RegistroEgresoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@WebServlet(name = "SVEgreso",value = "/SVEgreso")
public class SVEgreso extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistroEDAO registroEDAO = new RegistroEDAO();
    private RegistroEgresoJB registroEgresoJB = new RegistroEgresoJB();

    public void init(){
        registroEDAO = new RegistroEDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String matricula = request.getParameter("matricula");
        String materia = request.getParameter("materia");
        String facultad = request.getParameter("facultad");
        String carrera = request.getParameter("carrera");
        String nivelacademico = request.getParameter("nivel_academico");
        double donativoe = Double.parseDouble(request.getParameter("donativoe"));
        String fecha1 = request.getParameter("fecha");
        int id_electronico = Integer.parseInt(request.getParameter("id_electronico"));
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try{
            LocalDate fecha = LocalDate.parse(fecha1);
            RegistroEgresoJB registro = new RegistroEgresoJB();
            registro.setNombre(nombre);
            registro.setMatricula(matricula);
            registro.setMateria(materia);
            registro.setFacultad(facultad);
            registro.setCarrera(carrera);
            registro.setNivelacademico(nivelacademico);
            registro.setDonativo(donativoe);
            registro.setFecha(Date.valueOf(fecha));
            registro.setIdelectronico(id_electronico);
            registroEDAO.agregarRegistro(registro);

        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("JSP/Inventario.jsp").forward(request, response);

    }
}
