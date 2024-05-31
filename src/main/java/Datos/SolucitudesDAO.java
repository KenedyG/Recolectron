package Datos;
import Datos.Conexion;
import Modelo.SolicitudesJB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SolucitudesDAO {
    public static final String insertSQL = "INSERT INTO Solicitudes(id_solicitud ,noequipo,fecha_solicitud,fecha_uso,status) VALUES (?,?,?,?,?)";
    public static final String updateSQL = "UPDATE Solicitudes SET fecha_solicitud=?,fecha_usolicitud=? WHERE id_solicitud=? ";
    public static final String deleteSQL = "DELETE FROM Solicitudes WHERE id_solicitud =?";



 public List<SolicitudesJB> solicitudes(){
     Connection con = null;
     PreparedStatement state = null;
     ResultSet Result = null;

     List<SolicitudesJB> solicitudes = new ArrayList<>();
   try {
      con = Conexion.getConnection();
     state = con.prepareStatement("SELECT * FROM solicitudes ORDER BY id_solicitud  ASC;");
     Result = state.executeQuery();
     while (Result.next()) {
         int id_solicitudes = Result.getInt("id_solicitud");
         int noequipo = Result.getInt("noequipo");
         Date fecha_solicitud = Result.getDate("fecha_solicitud ");
         Date fecha_uso = Result.getDate("fecha_uso ");
         String status = Result.getString("status");
         int id_alumno = Result.getInt("id_alumno ");

         SolicitudesJB Solicitudes = new SolicitudesJB(id_solicitudes, noequipo, fecha_solicitud, fecha_uso, status, id_solicitudes);
         solicitudes.add(Solicitudes);
     }
   }catch (Exception e) {
   e.printStackTrace();
   }finally {
    Conexion.close(Result);
    Conexion.close(state);
    Conexion.close(con);
   }
   return solicitudes;
 }

 public void agregarSolicitud (SolicitudesJB solicitudes){
     Connection con = null;
     PreparedStatement state = null;
     try {
         con = Conexion.getConnection();
         state = con.prepareStatement(insertSQL);

         state.setInt(1,solicitudes.getIdSolicitud());
         state.setInt(2,solicitudes.getNoequipo());
         state.setTimestamp(3,solicitudes.getFechaSolicitud());
         state.setTimestamp(4,solicitudes.getFechaUso());
         state.setString(5,solicitudes.getStatus());

         state.executeUpdate();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }finally {

         Conexion.close(state);
         Conexion.close(con);
     }
     }
    public int modificar (SolicitudesJB solicitudes){
        Connection con = null;
        PreparedStatement state = null;
        int registros = 0;

        try{
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);

            state.setInt(1,solicitudes.getIdSolicitud());
            state.setInt(2,solicitudes.getNoequipo());
            state.setTimestamp(3,solicitudes.getFechaSolicitud());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return registros;
    }
    public void eliminar(SolicitudesJB solicitudes){
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);

            state.setString(1, String.valueOf(solicitudes));
            state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
 }

