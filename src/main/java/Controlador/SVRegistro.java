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
        String nombre = request.getParameter("Nombre");
        String apellidoP = request.getParameter("Apellido Paterno");
        String apellidoM = request.getParameter("Apellido Materno");
        String correo = request.getParameter("Correo");
        String usuario = request.getParameter("Usuario");
        String password = request.getParameter("Password");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellidoP);
        System.out.println("Apellido: " + apellidoM);
        System.out.println("Correo: " + correo);
        System.out.println("Usuario recibido: " + usuario);
        System.out.println("Contraseña recibida: " + password);
        try {
            registroJB = new RegistroJB(nombre, apellidoP, apellidoM, correo, usuario, password);
            registroDAO.agregarRegistro(registroJB);
            System.out.println("Registrado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



