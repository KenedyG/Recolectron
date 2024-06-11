package Datos;

import Modelo.LoginJB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    private static final String selectSQL = "SELECT * FROM login";
    private static final String insertSQL = "INSERT INTO login (usuario,password) VALUES (?,?)";
    private static final String updateSQL = "UPDATE login SET usuario = ?, password = ?";
    private static final String deleteSQL = "DELETE FROM login WHERE  id_user = ?";

    public List<LoginJB> login() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<LoginJB> login = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while(result.next()) {
                String usuario = result.getString("usuario");
                String password = result.getString("password");
                LoginJB loginJB = new LoginJB(usuario,password);
                login.add(loginJB);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return login;
    }
    public void agregarUsuario(LoginJB login) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setString(1, login.getUsuario());
            state.setString(2, login.getPassword());
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    public void actualizarUsuario(LoginJB login) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setString(1, login.getUsuario());
            state.setString(2, login.getPassword());
            state.setInt(3, login.getIduser());
            state.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    public void eliminarUsuario(LoginJB login) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);
            state.setInt(1, login.getIduser());
            state.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    /*Metodo para iniciar sesion, fase de prueba*/
    public boolean validar(String usuario, String password) {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;
        boolean existe = false;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement("SELECT password FROM login WHERE usuario = ?");
            state.setString(1, usuario);
            if(result.next()){
                String pass = result.getString("password");
                if(password.equals(pass)){
                    existe = true;
                    System.out.println("Contraseña correcta crack :D");
                }else{
                    System.out.println("Contraseña incorrecta fiera D:");
                }
            }else {
                System.out.println("Usuario no ha encontrado");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return existe;
    }

    public int detector(String usuario) {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;
        int status = 0;

        try{
            con = Conexion.getConnection();
            state = con.prepareStatement("SELECT status FROM login WHERE usuario = ?");
            state.setString(1, usuario);
            result = state.executeQuery();
            if(result.next()){
                status = result.getInt("status");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

}
