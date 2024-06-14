package Controlador;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.InventarioDAO;
import Modelo.InventarioJB;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVinventario", value = "/SVInventario")
public class SVVERInventario  extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private InventarioDAO inventarioDAO = new InventarioDAO();
    private InventarioJB inventarioJB = new InventarioJB();

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws  ServletException, IOException{

       InventarioDAO inventarioDAO1 = new InventarioDAO();
        List<InventarioJB> inventarioDAOList = inventarioDAO1.listar();
        request.setAttribute("inventario",inventarioDAOList);
        request.getRequestDispatcher("/JSP/Inventario.jsp").forward(request,response);
    }
}
