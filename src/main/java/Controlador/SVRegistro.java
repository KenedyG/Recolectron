package Controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.RegistroDAO;
import Modelo.RegistroJB;

import java.io.IOException;

@WebServlet(name = "SVRegistro", value = "/SVRegistro")
public class SVRegistro extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistroDAO registroDAO = new RegistroDAO();
    private RegistroJB registroJB = new RegistroJB();


    public void init(){ registroDAO= new RegistroDAO(); };

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        try {
            registroJB = new RegistroJB(nombre,apellidoP,apellidoM,correo,usuario,password);
            registroDAO.agregarRegistro(registroJB);
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msj","Error!");
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }
}



