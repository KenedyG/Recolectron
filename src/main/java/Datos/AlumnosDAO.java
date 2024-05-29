package Datos;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import Datos.AlumnosDAO;
import Modelo.AlumnosJB;


public class AlumnosDAO {

    private static final String selectSQL = "SELECT * FROM alumnos WHERE id_alumno = ?, nombre = ?, materia = ?";
    private static final String insertSQL = "INSERT INTO alumnos (nombre,materia) VALUES (?,?)";
    private static final String updateSQL = "UPDATE alumnos SET nombre = ?, materia = ? WHERE id_alumno";
    private static final String deleteSQL = "DELETE FROM alumnos WHERE id_alumno  = ? ";

    public List<AlumnosDAO> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<AlumnosDAO> alumnosDAOS = new ArrayList<>();

        try {
            con = Conexion.getConnection ();
            state = con.prepareStatement("SELECT * FROM Alumnos");
            result = state.executeQuery();
            while (result.next()) {
                int id_aulumno = result.getInt("id_aulumno");
                String nombre = result.getString("nombre");
                String materia = result.getString("Materia");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
        return alumnosDAOS;
    }
    public void agregarAlumnos (AlumnosJB Alumnos) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);

            state.setInt(1,Alumnos.getIdalumno());
            state.setString(2,Alumnos.getNombre());
            state.setString(2,Alumnos.getMateria());
            state.executeUpdate();
        } catch (SQLException e) {
        } finally {
                Conexion.close(state);
                Conexion.close(con);
        }
    }
    public int ModificarAlumnos (AlumnosJB Alumnos) {
        Connection con = null;
        PreparedStatement state = null;
        int registro=0;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);

            state.setInt(1,Alumnos.getIdalumno());
            state.setString(2,Alumnos.getMateria());
            state.setString(2,Alumnos.getMateria());

            registro = state.executeUpdate();
            if(registro>0){System.out.println("Tu registro a sido actualizado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return registro;
    }
}
