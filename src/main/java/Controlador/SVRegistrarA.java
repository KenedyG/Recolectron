package Controlador;

import Datos.AsistenciasDAO;
import Modelo.AsistenciasJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "SVRegistrarA",value = "/SVRegistrarA")
public class SVRegistrarA extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AsistenciasDAO asistenciaDAO;
    private AsistenciasJB asistenciaJB = new AsistenciasJB();

    public void init(){
        asistenciaDAO = new AsistenciasDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/Vista_Admin.jsp");
            return;
        }

        switch (action) {
            case "marcarEntrada":
                marcarEntrada(request, response);
                break;
            case "marcarSalida":
                marcarSalida(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/Vista_Admin.jsp");
                break;
        }
    }
    private void marcarEntrada(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        Timestamp horaActual = new Timestamp(System.currentTimeMillis());
        Timestamp placeholderHoraSalida = new Timestamp(0);
        /* DEBUG
        System.out.println("Intentando marcar entrada para idUsuario: " + idUsuario + " - Hora actual: " + horaActual);
         */

        AsistenciasJB asistencia = new AsistenciasJB();
        asistencia.setId_User(idUsuario);
        asistencia.setHoraentrada(horaActual);
        asistencia.setHorasalida(placeholderHoraSalida);

        asistenciaDAO.agregarAsistencia(asistencia);

        request.getRequestDispatcher("/JSP/Asistencia.jsp").forward(request, response);
    }
    private void marcarSalida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        Timestamp horaActual = new Timestamp(System.currentTimeMillis());
        /* DEBUG
        System.out.println("Intentando marcar salida para idUsuario: " + idUsuario + " - Hora actual: " + horaActual);
         */
        asistenciaDAO.modificarHoraSalida(idUsuario, horaActual);

        request.getRequestDispatcher("/JSP/Asistencia.jsp").forward(request, response);
    }
}