package Controlador;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import Datos.Conexion;
import Datos.LoginDAO;
import Modelo.LoginJB;

import java.io.IOException;
import java.sql.Connection;

import static java.lang.System.out;

@WebServlet(name = "SVLogin", value = "/SVLogin")
public class SVLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  LoginDAO loginDAO = new LoginDAO();
    private  LoginJB loginJB = new LoginJB();

    public void init() { loginDAO = new LoginDAO (); };

                public void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                    String user = request.getParameter("Usuario");
                    String pass = request.getParameter("Contraseña");

                    try  {
                        int status = loginDAO.detector(user);
                        boolean existe = loginDAO.validar(user,pass);
                        HttpSession session = request.getSession();
                        if (existe) {
                            switch (status) {
                                case 0:
                                    session.setAttribute("usuario", user);
                                    response.sendRedirect("Vista_Admin.jsp");
                                    break;
                                case 1:
                                    session.setAttribute("usuario", user);
                                    response.sendRedirect("Vista_Empleado.jsp");
                                    break;
                            }
                        }else{
                            request.setAttribute("Error","Usuario o Contraseña Incorrectos");
                            request.getRequestDispatcher("/JSP/Registro.jsp").forward(request, response);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
}

