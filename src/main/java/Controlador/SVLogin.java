package Controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Datos.LoginDAO;
import Modelo.LoginJB;

import java.io.IOException;

@WebServlet(name = "SVLogin", value = "/SVLogin")
public class SVLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  LoginDAO loginDAO = new LoginDAO();
    private  LoginJB loginJB = new LoginJB();

    public void init() { loginDAO = new LoginDAO (); };


                public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");
        loginJB.setIduser(0);
        loginJB.setUsuario(user);
        loginJB.setPassword(pass);
        try {
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
