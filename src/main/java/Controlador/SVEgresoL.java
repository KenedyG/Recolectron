package Controlador;

import Datos.RegistroEDAO;
import Modelo.RegistroEgresoJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SVEgresoL", value = "/SVEgresoL")
public class SVEgresoL extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistroEDAO registroEDAO = new RegistroEDAO();
    private RegistroEgresoJB registroEgresoJB = new RegistroEgresoJB();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistroEDAO registroEDAO = new RegistroEDAO();
        List<RegistroEgresoJB> registroList = registroEDAO.listar();
        request.setAttribute("registroList", registroList);
        request.getRequestDispatcher("/JSP/Inventario.jsp").forward(request, response);

    }

}