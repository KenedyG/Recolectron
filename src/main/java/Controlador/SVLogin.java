package Controlador;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import Datos.RegistroDAO;

@WebServlet(name = "SVLogin", value = "/SVLogin")
public class SVLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistroDAO registroDAO;

    public void init(){
        registroDAO = new RegistroDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String user = request.getParameter("Usuario");
        String pass = request.getParameter("Password");
        System.out.println("Usuario recibido: " + user);
        System.out.println("Contraseña recibida: " + pass);
        request.setAttribute("usuario",user);

        try {
            boolean status = registroDAO.validar(user, pass);
            System.out.println("Estado de validación: " + status);
            HttpSession session = request.getSession();
            if(status){
                System.out.println("Redirigiendo a Vista_Admin.jsp");
                response.sendRedirect(request.getContextPath() + "/JSP/Vista_Admin.jsp");
            }else{
                System.out.println("Redirigiendo a Vista_Empleado.jsp");
                response.sendRedirect(request.getContextPath() + "/JSP/Vista_Empleado.jsp");

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}