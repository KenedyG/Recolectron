package Controlador;

import Datos.DonativoDAO;
import Modelo.DonativoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SVDonativoR",value = "/SVDonativoR")
public class SVDonativoR extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DonativoDAO donativodao = new DonativoDAO();

    public void init(){
        donativodao = new DonativoDAO();
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        String nombre = request.getParameter("nombre");
        String nombreObjeto = request.getParameter("nombreObjeto");
        try{
            DonativoJB donativo = new DonativoJB();
            donativo.setNombre(nombre);
            donativo.setNombreobjeto(nombreObjeto);
            donativodao.agregarDonativo(donativo);
            System.out.println("Donativo agregado exitosamente");
            response.sendRedirect(request.getContextPath()+"/JSP/Donativo.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
