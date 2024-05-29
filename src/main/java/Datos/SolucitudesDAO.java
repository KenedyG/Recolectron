package Datos;
import Datos.Conexion;
import Modelo.SolicitudesJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SolucitudesDAO {
    public static final String insertSQL = "INSERT INTO Solicitudes(id_solicitud,noequipo,fecha_solicitud,fecha_usolicitud) VALUES (?,?,?,?)";
    public static final String updateSQL = "UPDATE Solicitudes SET fecha_solicitud=?,fecha_usolicitud=? WHERE id_solicitud=? ";
    public static final String deleteSQL = "DELETE FROM Solicitudes WHERE id_solicitud=?";
    public static final String selectSQL = "SELECT * FROM Solicitudes WHERE id_solicitud=?";


}
