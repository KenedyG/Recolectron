package Controlador;
import Datos.RegistroDAO.*;
import Modelo.RegistroJB.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebServlet(name ="SVSolcitudH", value = "/SVSolicitud")
public class SVSolicitudH extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletRequest response)
        throws ServletException, IOException{

    }
@Override
    protected void doPost(HttpServletRequest request,HttpServletRequest response)
        throws ServletException,IOException{
        try {
            int noequipo = Integer.parseInt(request.getParameter("noequipo"));
            String fecha_solicitud = request.getQueryString(""))

        }
}
}

