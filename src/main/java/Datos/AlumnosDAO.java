package Datos;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import Datos.AlumnosDAO;


public class AlumnosDAO {

    private static final String selectSQL = "SELECT * FROM alumnos WHERE idAlumno = ?, nombre = ?, materia = ?";
    private static final String insertSQL = "INSERT INTO alumnos (nombre,materia) VALUES (?,?)";
    private static final String updateSQL = "UPDATE alumnos SET nombre = ?, materia = ? WHERE id_alumno";
    private static final String deleteSQL = "DELETE FROM Alumnos WHERE id_alumnos  = ? ";

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
        } catch (SQLException e) {
         Conexion.close(result);
        }
    }
}
