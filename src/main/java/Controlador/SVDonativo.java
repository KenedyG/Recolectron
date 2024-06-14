package Controlador;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.DonativoDAO;
import Datos.SolucitudesDAO;
import Modelo.DonativoJB;
import Modelo.SolicitudesJB;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVDonativo", value = "/SVDonativo")
public class SVDonativo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DonativoDAO donativoDAO =  new DonativoDAO();
    private DonativoJB donativoJB = new DonativoJB();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DonativoDAO donativo1 = new DonativoDAO();
        List<DonativoJB> donativoList = donativo1.listar();
        request.setAttribute("donativos",donativoList);
        request.getRequestDispatcher("./JSP/Donativo.jsp").forward(request,response);
}}
