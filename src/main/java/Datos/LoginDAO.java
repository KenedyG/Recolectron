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
    private static final String insertSQL = "INSERT INTO login (usuario,password,id_user) VALUES (?,?,?)";
    private static final String updateSQL = "UPDATE login SET usuario = ?, password = ?, id_user = ?";
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
                int id_user = result.getInt("id_user");

                LoginJB loginJB = new LoginJB(usuario, password, id_user);
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
            state.setInt(3,login.getIduser());
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

}
