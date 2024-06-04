package Controlador;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DonativoDAO;
import Modelo.DonativoJB;

import java.io.IOException;

@WebServlet(name = "SVDonativo", value = "/SVDonativo")
public class SVDonativo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DonativoDAO donativoDAO =  new DonativoDAO();
    private DonativoJB donativoJB = new DonativoJB();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String nombreObjeto = request.getParameter("nombreObjeto");
                try{
                    donativoJB = new DonativoJB(0,nombre,nombreObjeto);
                    donativoDAO.agregar(donativoJB);
                }catch (Exception e){
                    e.printStackTrace();
                }
}}
