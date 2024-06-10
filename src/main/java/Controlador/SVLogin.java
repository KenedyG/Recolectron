package Controlador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

import Datos.LoginDAO;
import Modelo.LoginJB;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "SVLogin", value = "/SVLogin")
public class SVLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  LoginDAO loginDAO = new LoginDAO();
    private  LoginJB loginJB = new LoginJB();

    public void init() { loginDAO = new LoginDAO (); };


                public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("Usuario");
        String pass = request.getParameter("Contraseña");
        loginJB.setUsuario(user);
        loginJB.setPassword(pass);

            if(loginDAO.validar(loginJB)){
                RequestDispatcher rd = request.getRequestDispatcher("Vista_Empleado.jsp");
                rd.forward(request, response);
            }
            else{
                out.print("Error de Usuario o Contraseña, intenta de nuevo");
                response.sendRedirect("JSP/Registro.jsp");
            }
        }
    }

