package Controlador;

import Datos.SolucitudesDAO;
import Modelo.SolicitudesJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
@WebServlet(name = "SVSolicitudA", value = "/SVSolicitudA")
public class SVSolicitudes extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SolucitudesDAO solicitudesDAO = new SolucitudesDAO();
    private SolicitudesJB solicitudesJB = new SolicitudesJB();

    public void init(){
        solicitudesDAO = new SolucitudesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int noequipo = Integer.parseInt(request.getParameter("noequipo"));
        Timestamp fecha_solicitud = new Timestamp(System.currentTimeMillis());
        String fechaUsoStr = request.getParameter("fechaUso");
        String horaUsoStr = request.getParameter("horaUso");
        int idalumno = Integer.parseInt(request.getParameter("idalumno"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaHoraStr = fechaUsoStr + " " + horaUsoStr;
        try{
            Date fechaHora = dateFormat.parse(fechaHoraStr);
            Timestamp fechaUso = new Timestamp(fechaHora.getTime());
            SolicitudesJB solicitud = new SolicitudesJB();
            solicitud.setNoequipo(noequipo);
            solicitud.setFechaSolicitud(fecha_solicitud);
            solicitud.setFechaUso(fechaUso);
            solicitud.setIdalumno(idalumno);
            solicitud.setStatus("Pendiente");
            solicitudesDAO.agregarSolicitud(solicitud);

        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/JSP/Solicitudes.jsp").forward(request, response);
    }

}