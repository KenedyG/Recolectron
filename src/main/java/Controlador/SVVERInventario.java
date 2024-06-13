package Controlador;

import javax.servlet.RequestDispatcher;
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
public class SVVERInventario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //No funciona con doPost, solo dios sabe porque
        System.out.println("HOLA");
        InventarioDAO inventarioDAO = new InventarioDAO();
        List<InventarioJB> inventario = inventarioDAO.listar();

        //Se manda el objeto como atributo con nombre inventario, CONSTA QUE SI RECIBE LA LISTA ENTERA :'D
        request.setAttribute("inventario", inventario);
        //Se redirige al JSP, no funcionaba antes porque aputaba al mismo servlet, pido perdon
        request.getRequestDispatcher("/JSP/Inventario.jsp").forward(request, response);
        /*Debugging 2 - Ahora es personal
        System.out.println("Regresando al JSP");
        */
    }
}
