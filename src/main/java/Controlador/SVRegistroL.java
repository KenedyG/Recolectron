package Controlador;

import Datos.RegistroDAO;
import Modelo.RegistroJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "SVRegistroL", value = "/SVRegistroL")
public class SVRegistroL extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistroDAO registroDAO = new RegistroDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<RegistroJB> registrosList = registroDAO.listar();
        List<RegistroJB> registrosFiltrados = filtrarAdmin(registrosList);
        List<RegistroJB> registrosSinAdmin = omitirAdmin(registrosFiltrados);

        /* Debugging para mostrar la lista que se enviarÃ¡ al JSP
        System.out.println("Lista enviada al JSP:");
        for (RegistroJB registro : registrosSinAdmin) {
            System.out.println(registro.getId_user() + " - " + registro.getNombre() + " - " + registro.getUsuario());
        }

         */

        request.setAttribute("registro", registrosSinAdmin);
        request.getRequestDispatcher("/JSP/Asistencia.jsp").forward(request, response);
    }

    private List<RegistroJB> filtrarAdmin(List<RegistroJB> registrosList) {
        List<RegistroJB> registrosFiltrados = new ArrayList<>();

        for (RegistroJB registro : registrosList) {
            if (!"Admin".equals(registro.getUsuario())) {
                registrosFiltrados.add(registro);
            }
        }

        return registrosFiltrados;
    }

    private List<RegistroJB> omitirAdmin(List<RegistroJB> registrosList) {
        List<RegistroJB> registrosSinAdmin = new ArrayList<>();

        // No funciona ningun filtro
        for (int i = 1; i < registrosList.size(); i++) {
            registrosSinAdmin.add(registrosList.get(i));
        }

        return registrosSinAdmin;
    }
}