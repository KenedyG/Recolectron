package Controlador;

import Datos.SolucitudesDAO;
import Modelo.SolicitudesJB;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.sql.Timestamp;

@WebServlet(name ="SVSolcitudA", value = "/SVSolicitudA")
public class SVSolicitudes extends HttpServlet{
    private static final long serialVercionUID = 1L;
    private SolucitudesDAO solicitudesDAO = new SolucitudesDAO();
    private SolicitudesJB solicitudesJB = new SolicitudesJB();

    public void init(){
        solicitudesDAO = new SolucitudesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletRequest request)throws ServletException,IOException{
        int noequipo = Integer.parseInt(request.getParameter("noequipo"));
        Timestamp fecha_solicitud = new Timestamp(System.currentTimeMillis());
        String fechaUsoStr = request.getParameter("fechaUso");
        String horaUsoStr = request.getParameter("horaUso");
        int idalumno = Integer.parseInt(request.getParameter("idalumno"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaHoraStr = fechaUsoStr + " " + horaUsoStr;
        try {
            Date fechaHora = dateFormat.parse(fechaHoraStr);
            Timestamp fechaUso = new Timestamp(fechaHora.getTime());
            SolicitudesJB solicitud =  new SolicitudesJB();
            solicitud.setFechaSolicitud(fecha_solicitud);
            solicitud.setIdalumno(idalumno);
            solicitud.setStatus("pendiente");

            solicitudesDAO.agregarSolicitud(solicitud);
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/JSP/Solcitudes.jsp").forward(request,response);
    }

}