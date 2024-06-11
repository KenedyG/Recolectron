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
        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");
        try {
            boolean status = registroDAO.validar(user, pass);
            HttpSession session = request.getSession();
            if(status){
                request.setAttribute("usuario",user);
                request.getRequestDispatcher("./JSP/Vista_Admin.jsp");
            }else{
                request.setAttribute("usuario",user);
                request.getRequestDispatcher("./JSP/Vista_Empleado");

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}