package Datos;

import java.sql.*;
import java.util.*;
import Modelo.AsistenciasJB;

public class AsistenciasDAO{
    private static final String selectSQL = "SELECT * FROM asistencias ;";
    private static final String insertSQL = "INSERT INTO asistencias  (id_asistencia , horaentrada , horasalida) VALUES (?, ?, ?)";
    private static final String updateSQL = "UPDATE asistencias  SET horaentrada = ?, horasalida = ? WHERE id_asistencia = ?";

    public List<AsistenciasJB> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<AsistenciasJB> asistencias = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while (result.next()) {
                int id_asistencia = result.getInt("id_asistencia");
                String horaentrada = result.getString("horaentrada");
                String horasalida = result.getString("horasalida");

                AsistenciasJB asistencia = new AsistenciasJB ();
                asistencias.add(asistencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return asistencias;
    }

    public void agregar(AsistenciasJB asistencia) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setInt(1, asistencia.getId_asistencia());
            state.setString(2, asistencia.getHoraentrada());
            state.setString(3, asistencia.getHorasalida());
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
public void modificar(AsistenciasJB asistencia){
        Connection con = null;
        PreparedStatement state = null;
        try {
        con = Conexion.getConnection();
        state = con.prepareStatement(updateSQL);
        state.setString(1,asistencia.getHoraentrada());
        state.setString(2,asistencia.getHorasalida());
        state.setInt(3, asistencia.getId_asistencia());
        state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(con);
            Conexion.close(state);

        }
}

}