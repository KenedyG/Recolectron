package Controlador;

import Datos.InventarioDAO;
import Modelo.InventarioJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SVMInventario", value = "/SVMInventario")
public class SVMODInventario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "modificar":
                    modificarInventario(request, response);
                    break;
                case "eliminar":
                    eliminarInventario(request, response);
                    break;
                default:
                    break;
            }
        }
    }
    private void modificarInventario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Usamos el metodo actualizarInventario del DAO
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String fabricante = request.getParameter("fabricante");
        String modelo = request.getParameter("modelo");
        String especificaciones = request.getParameter("especificaciones");
        int peso = Integer.parseInt(request.getParameter("peso"));
        String status = request.getParameter("status");
        int stock = Integer.parseInt(request.getParameter("stock"));

        InventarioJB inventario = new InventarioJB();
        inventario.setIdelectronico(id);
        inventario.setNombre(nombre);
        inventario.setFabricante(fabricante);
        inventario.setModelo(modelo);
        inventario.setEspecificaciones(especificaciones);
        inventario.setPeso(peso);
        inventario.setStatus(status);
        inventario.setStock(stock);

        InventarioDAO inventarioDAO = new InventarioDAO();
        inventarioDAO.actualizarInventario(inventario);
        System.out.println("Objeto Actualizado");

        response.sendRedirect(request.getContextPath() + "/JSP/Inventario.jsp");
    }
    private void eliminarInventario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Usamos el metodo de eliminarInventario del DAO
        int id = Integer.parseInt(request.getParameter("id"));

        InventarioJB inventario = new InventarioJB();
        inventario.setIdelectronico(id);

        InventarioDAO inventarioDAO = new InventarioDAO();
        inventarioDAO.eliminarInventario(inventario);
        System.out.println("Objeto Eliminado");

        response.sendRedirect(request.getContextPath() + "/JSP/Inventario.jsp");
    }
}
