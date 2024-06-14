package Datos;

import Modelo.SolicitudesJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolucitudesDAO {
    public static final String insertSQL = "INSERT INTO solicitudes(noequipo, fecha_solicitud, fecha_uso, status, id_alumno) VALUES (?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE solicitudes SET fecha_solicitud=?, fecha_uso=? WHERE id_solicitud=?";
    public static final String deleteSQL = "DELETE FROM solicitudes WHERE id_solicitud =?";

    public List<SolicitudesJB> solicitudes() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<SolicitudesJB> solicitudes = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement("SELECT id_solicitud, noequipo, fecha_solicitud, fecha_uso, status, id_alumno FROM solicitudes");
            result = state.executeQuery();

            while (result.next()) {
                SolicitudesJB solicitud = new SolicitudesJB();
                int id_solicitud = result.getInt("id_solicitud");
                int noequipo = result.getInt("noequipo");
                Timestamp fecha_solicitud = result.getTimestamp("fecha_solicitud");
                Timestamp fecha_uso = result.getTimestamp("fecha_uso");
                String status = result.getString("status");
                int id_alumno = result.getInt("id_alumno");

                solicitud.setIdSolicitud(id_solicitud);
                solicitud.setNoequipo(noequipo);
                solicitud.setFechaSolicitud(fecha_solicitud);
                solicitud.setFechaUso(fecha_uso);
                solicitud.setStatus(status);
                solicitud.setIdalumno(id_alumno);

                /*Debug*/
                System.out.println("ID Solicitud: " + id_solicitud);
                System.out.println("Número de Equipo: " + noequipo);
                System.out.println("Fecha de Solicitud: " + fecha_solicitud);
                System.out.println("Fecha de Uso: " + fecha_uso);
                System.out.println("Status: " + status);
                System.out.println("ID Alumno: " + id_alumno);

                solicitudes.add(solicitud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return solicitudes;
    }

    public void agregarSolicitud(SolicitudesJB solicitud) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);

            state.setInt(1, solicitud.getNoequipo());
            state.setTimestamp(2, solicitud.getFechaSolicitud());
            state.setTimestamp(3, solicitud.getFechaUso());
            state.setString(4, solicitud.getStatus());
            state.setInt(5, solicitud.getIdalumno());

            /*Debug*/
            System.out.println("Agregar Solicitud: ");
            System.out.println("No. de Equipo: " + solicitud.getNoequipo());
            System.out.println("Fecha de Solicitud: " + solicitud.getFechaSolicitud());
            System.out.println("Fecha de Uso: " + solicitud.getFechaUso());
            System.out.println("Status: " + solicitud.getStatus());
            System.out.println("ID Alumno: " + solicitud.getIdalumno());

            state.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }

    public int modificarSolicitud(SolicitudesJB solicitud) {
        Connection con = null;
        PreparedStatement state = null;
        int registros = 0;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);

            state.setTimestamp(1, solicitud.getFechaSolicitud());
            state.setTimestamp(2, solicitud.getFechaUso());
            state.setInt(3, solicitud.getIdSolicitud());

            registros = state.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }

        return registros;
    }

    public void eliminarSolicitud(int idSolicitud) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);

            state.setInt(1, idSolicitud);
            state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
}
