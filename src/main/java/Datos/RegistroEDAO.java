package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.*;
import Modelo.RegistroEgresoJB;
import Modelo.RegistroJB;

public class RegistroEDAO {
    private static final String selectSQL = "SELECT * FROM registro_egreso";
    private static final String insertSQL = "INSERT INTO registro_egreso (idRegistroEgreso,Nombre,Matricula,Materia,nivelacademico,donativo,fecha,idelectronico) VALUES (?,?,?,?,?,?,?,?)";
    private static final String updateSQL = "UPDATE registro_egreso SET idRegistroEgreso = ?, Nombre = ?, Matricula  = ?, Materia = ?, nivelacademico = ?, donativo = ?, fecha = ?, idelectronico = ?";

    public List<RegistroEgresoJB> listar(){
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<RegistroEgresoJB> registroeJB = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while (result.next()) {
                int idRegistroEgreso = result.getInt("idRegistroEgreso");
                String Nombre = result.getString("Nombre");
                String Matricula = result.getString("Matricula");
                String Materia = result.getString("Materia");
                String nivelacademico = result.getString("nivelacademico");
                String donativo = result.getString("donativo");
                Date fecha = result.getDate("fecha");
                int idelectronico = result.getInt("idelectronico");
                RegistroEgresoJB registro = new RegistroEgresoJB(idRegistroEgreso,Nombre,Matricula,Materia,nivelacademico,donativo,fecha,idelectronico);
                registroeJB.add(registro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return registroeJB;
    }

    public void agregarRegistro(RegistroEgresoJB registroeJB){
        Connection con = null;
        PreparedStatement state = null;

        try{
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setInt(1, registroeJB.getIdRegistroEgreso());
            state.setString(2, registroeJB.getNombre());
            state.setString(3, registroeJB.getMatricula());
            state.setString(4, registroeJB.getMateria());
            state.setString(5, registroeJB.getNivelacademico());
            state.setString(6, registroeJB.getDonativo());
            state.setDate(7, registroeJB.getFecha());
            state.setInt(8,registroeJB.getIdelectronico());

            state.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void modificarRegistro(RegistroEgresoJB registroeJB){
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setInt(1, registroeJB.getIdRegistroEgreso());
            state.setString(2, registroeJB.getNombre());
            state.setString(3, registroeJB.getMatricula());
            state.setString(4, registroeJB.getMateria());
            state.setString(5, registroeJB.getNivelacademico());
            state.setString(6, registroeJB.getDonativo());
            state.setDate(7, registroeJB.getFecha());
            state.setInt(8, registroeJB.getIdelectronico());

            state.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
