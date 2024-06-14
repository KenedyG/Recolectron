package Datos;

import java.sql.*;
import java.util.*;
import Modelo.AsistenciasJB;

public class AsistenciasDAO{
    private static final String selectSQL = "SELECT * FROM asistencias ;";
    private static final String insertSQL = "INSERT INTO asistencias  (horaentrada , horasalida, id_user) VALUES (?, ?, ?)";
    private static final String updateSQL = "UPDATE asistencias  SET horaentrada = ?, horasalida = ? WHERE id_asistencia = ?";

    public List<AsistenciasJB> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<AsistenciasJB> asistenciasjb = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while (result.next()) {
                AsistenciasJB asistencia = new AsistenciasJB ();

                int id_asistencia = result.getInt("id_asistencia");
                Timestamp horaentrada = result.getTimestamp("horaentrada");
                Timestamp horasalida = result.getTimestamp("horasalida");
                int id_user = result.getInt("id_user");
                asistencia.setId_asistencia(id_asistencia);
                asistencia.setHoraentrada(horaentrada);
                asistencia.setHorasalida(horasalida);
                asistencia.setId_User(id_user);

                asistenciasjb.add(asistencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return asistenciasjb;
    }

    public void agregarAsistencia(AsistenciasJB asistencia) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement("INSERT INTO asistencias (horaentrada, horasalida, id_user) VALUES (?, ?, ?)");

            state.setTimestamp(1, asistencia.getHoraentrada());
            state.setTimestamp(2, asistencia.getHorasalida());
            state.setInt(3,asistencia.getId_User());
            System.out.println("Ejecutando INSERT en asistencias:");
            System.out.println("Hora entrada: " + asistencia.getHoraentrada());
            System.out.println("ID Usuario: " + asistencia.getId_User());
            System.out.println("Horasalida: " + asistencia.getHorasalida());
            state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
public void modificarAsistencia(AsistenciasJB asistencia){
        Connection con = null;
        PreparedStatement state = null;
        try {
        con = Conexion.getConnection();
        state = con.prepareStatement(updateSQL);
        state.setTimestamp(1,asistencia.getHoraentrada());
        state.setTimestamp(2,asistencia.getHorasalida());
        state.setInt(3, asistencia.getId_asistencia());
        state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(con);
            Conexion.close(state);

        }
}
public void modificarHoraSalida(int idUser, Timestamp horaSalida ){
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement("UPDATE asistencias SET horasalida = ? WHERE id_user = ?");
            state.setTimestamp(1, horaSalida);
            state.setInt(2, idUser);
            state.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(con);
            Conexion.close(state);
        }
}

}