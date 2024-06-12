package Controlador;

import javax.servlet.http.HttpServlet;
import Datos.InventarioDAO;
import Modelo.InventarioJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModificarInventario", value = "/ModificarInventario")
public class SVMODInventario2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("buscar")) {
            // Acción: Buscar por ID
            buscarPorId(request, response);
        } else if (action.equals("modificar")) {
            // Acción: Modificar inventario
            modificarInventario(request, response);
        } else if (action.equals("agregar")) {
            agregarAlInventario(request, response);
        }
    }

    private void buscarPorId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("idElectronico");
        int id = Integer.parseInt(idStr);

        InventarioDAO inventarioDAO = new InventarioDAO();
        InventarioJB inventario = inventarioDAO.InventarioID(id);

        if (inventario != null) {
            request.setAttribute("inventario", inventario);
            request.getRequestDispatcher("/JSP/ModInventario.jsp").forward(request, response);
        }
    }

    private void modificarInventario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String fabricante = request.getParameter("fabricante");
        String modelo = request.getParameter("modelo");
        String especificaciones = request.getParameter("especificaciones");
        int peso = Integer.parseInt(request.getParameter("peso"));
        String status = request.getParameter("status");
        int stock = Integer.parseInt(request.getParameter("stock"));

        InventarioJB inventarioActualizado = new InventarioJB();
        inventarioActualizado.setIdelectronico(id);
        inventarioActualizado.setNombre(nombre);
        inventarioActualizado.setFabricante(fabricante);
        inventarioActualizado.setModelo(modelo);
        inventarioActualizado.setEspecificaciones(especificaciones);
        inventarioActualizado.setPeso(peso);
        inventarioActualizado.setStatus(status);
        inventarioActualizado.setStock(stock);

        InventarioDAO inventarioDAO = new InventarioDAO();
        inventarioDAO.actualizarInventario(inventarioActualizado);

        response.sendRedirect(request.getContextPath() + "/JSP/Inventario.jsp");
    }
    protected void agregarAlInventario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombreNuevo");
        String fabricante = request.getParameter("fabricanteNuevo");
        String modelo = request.getParameter("modeloNuevo");
        String especificaciones = request.getParameter("especificacionesNuevo");
        int peso = Integer.parseInt(request.getParameter("pesoNuevo"));
        String status = request.getParameter("statusNuevo");
        int stock = Integer.parseInt(request.getParameter("stockNuevo"));

        InventarioJB nuevoInventario = new InventarioJB();
        nuevoInventario.setNombre(nombre);
        nuevoInventario.setFabricante(fabricante);
        nuevoInventario.setModelo(modelo);
        nuevoInventario.setEspecificaciones(especificaciones);
        nuevoInventario.setPeso(peso);
        nuevoInventario.setStatus(status);
        nuevoInventario.setStock(stock);

        InventarioDAO inventarioDAO = new InventarioDAO();
        inventarioDAO.agregarInventario(nuevoInventario);
        request.setAttribute("mensaje", "Objeto añadido al inventario correctamente");

        response.sendRedirect(request.getContextPath() + "/JSP/ModInventario.jsp");
    }

}
