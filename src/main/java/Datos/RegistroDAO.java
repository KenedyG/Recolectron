package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Modelo.RegistroJB;

public class RegistroDAO {
    private static final String selectSQL = "SELECT * FROM registro";
    private static final String insertSQL = "INSERT INTO registro (nombre,apellidop,apellidom,correo,usuario,password) VALUES (?,?,?,?,?,?)";
    private static final String updateSQL = "UPDATE registro SET nombre = ?, apellidop = ?, apellidom = ?, correo = ?, usuario = ?, password = ?";
    private static final String deleteSQL = "DELETE FROM registro WHERE id_user=?";
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
                String nombre = result.getString("nombre");
                String apellidop = result.getString("apellidop");
                String apellidom = result.getString("apellidom");
                String correo = result.getString("correo");
                String usuario = result.getString("usuario");
                String password = result.getString("password");

                RegistroJB listar = new RegistroJB(nombre,apellidop,apellidom,correo,usuario,password);
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
            state.setString(1,registro.getNombre());
            state.setString(2,registro.getApellidoP());
            state.setString(3,registro.getApellidoM());
            state.setString(4,registro.getCorreo());
            state.setString(5,registro.getUsuario());
            state.setString(6,registro.getPassword());
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
            state.setString(1,registro.getNombre());
            state.setString(2,registro.getApellidoP());
            state.setString(3,registro.getApellidoM());
            state.setString(4,registro.getCorreo());
            state.setString(5,registro.getUsuario());
            state.setString(6,registro.getPassword());
            state.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void eliminarRegistro(RegistroJB registro){
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);
            state.setInt(1,registro.getId_user());
            state.executeUpdate();
        }catch (Exception e){
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
            state = con.prepareStatement("SELECT password FROM registro WHERE usuario = ?");
            state.setString(1, usuario);
            result = state.executeQuery();
            if(result.next()){
                String pass = result.getString("password");
                //Credenciales Hardcoded por el momento, no es buena practica, no debe ser asi
                //pero hasta no tener claro lo de rol funciona asi.
                if("Admin".equals(usuario) && "R3c0AAdmin".equals(password)){
                    existe = true;
                    System.out.println("Admin");
                }
                else if(password.equals(pass)){
                    existe = false;
                    System.out.println("Empleado");
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
    //Pendiente de aprobacion, funcion para comprobacion de rol teorica
    public int detector(String usuario) {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;
        int status = 0;

        try{
            con = Conexion.getConnection();
            state = con.prepareStatement("SELECT status FROM registro WHERE usuario = ?");
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
