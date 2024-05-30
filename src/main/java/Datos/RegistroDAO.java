package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import Modelo.RegistroJB;

public class RegistroDAO {
    private static final String selectSQL = "SELECT * FROM registro";
    private static final String insertSQL = "INSERT INTO registro (id_user,nombre,apellidop,apellidom,correo,usuario,password) VALUES (?,?,?,?,?,?,?)";
    private static final String updateSQL = "UPDATE registro SET id_user = ?,nombre = ?, apellidop = ?, apellidom = ?, correo = ?, usuario = ?, password = ?";
    public List<RegistroJB> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<RegistroJB> registroDAOS = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while(result.next()) {
                int id_user = result.getInt("id_user");
                String nombre = result.getString("nombre");
                String apellidop = result.getString("apellidop");
                String apellidom = result.getString("apellidom");
                String correo = result.getString("correo");
                String usuario = result.getString("usuario");
                String password = result.getString("password");

                RegistroJB listar = new RegistroJB(id_user,nombre,apellidop,apellidom,correo,usuario,password);
                registroDAOS.add(listar);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
        return registroDAOS;
    }
    public void agregarRegistro(RegistroJB registro) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            /*Recuerda que el parameterindex es el orden de como van los datos, 1,2,3..
            * dependiendo de cuantas "?" tengas en tu orden sql*/
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setInt(1,registro.getId_user());
            state.setString(2,registro.getNombre());
            state.setString(3,registro.getApellidoP());
            state.setString(4,registro.getApellidoM());
            state.setString(5,registro.getCorreo());
            state.setString(6,registro.getUsuario());
            state.setString(7,registro.getPassword());
            state.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    public void actualizarRegistro(RegistroJB registro) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setInt(1,registro.getId_user());
            state.setString(2,registro.getNombre());
            state.setString(3,registro.getApellidoP());
            state.setString(4,registro.getApellidoM());
            state.setString(5,registro.getCorreo());
            state.setString(7,registro.getUsuario());
            state.setString(7,registro.getPassword());
            state.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
