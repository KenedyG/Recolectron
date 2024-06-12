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

        /* Debugging, dios si existe
        System.out.println("Lista de inventario recibida en el servlet:");
        for (InventarioJB item : inventario) {
            System.out.println("------------------------------------");
            System.out.println("ID: " + item.getIdelectronico());
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Fabricante: " + item.getFabricante());
            System.out.println("Modelo: " + item.getModelo());
            System.out.println("Especificaciones: " + item.getEspecificaciones());
            System.out.println("Peso: " + item.getPeso());
            System.out.println("Status: " + item.getStatus());
            System.out.println("Stock: " + item.getStock());
            System.out.println("------------------------------------");
        }
        */
        //Se manda el objeto como atributo con nombre inventario, CONSTA QUE SI RECIBE LA LISTA ENTERA :'D
        request.setAttribute("inventario", inventario);
        //Se redirige al JSP, no funcionaba antes porque aputaba al mismo servlet, pido perdon
        request.getRequestDispatcher("/JSP/Inventario.jsp").forward(request, response);
        /*Debugging 2 - Ahora es personal
        System.out.println("Regresando al JSP");
        */
    }
}
