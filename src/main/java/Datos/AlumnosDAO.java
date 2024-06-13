package Datos;

import java.sql.*;
import java.util.*;

import Modelo.AlumnosJB;

import javax.swing.plaf.nimbus.State;


public class AlumnosDAO {

    private static final String insertSQL = "INSERT INTO alumnos (nombre,materia) VALUES (?,?)";
    private static final String updateSQL = "UPDATE alumnos SET nombre = ?, materia = ? WHERE id_alumno";
    private static final String deleteSQL = "DELETE FROM alumnos WHERE id_alumno  = ? ";

    public List<AlumnosJB> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<AlumnosJB> alumnosDAOS = new ArrayList<>();

        try {
            con = Conexion.getConnection ();
            state = con.prepareStatement("SELECT * FROM Alumnos");
            result = state.executeQuery();
            while (result.next()) {
                AlumnosJB alumno = new AlumnosJB();
                int id_alumno = result.getInt("id_alumno");
                String nombre = result.getString("nombre");
                String materia = result.getString("Materia");
                alumno.setIdalumno(id_alumno);
                alumno.setNombre(nombre);
                alumno.setMateria(materia);
                alumnosDAOS.add(alumno);

                System.out.println(id_alumno);
                System.out.println(nombre);
                System.out.println(materia);
            }

            }catch (Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
        return alumnosDAOS;
    }
    public void AgregarAlumnos (AlumnosJB Alumnos) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);

            state.setString(1,Alumnos.getNombre());
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

            registro = state.executeUpdate();
            if(registro>0){System.out.println("Tu registro ha sido actualizado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return registro;
    }
    public void EliminarAlumno(AlumnosJB Alumnos){
        Connection con =null;
        PreparedStatement state =null;
        try{
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);

            state.setInt(1,Alumnos.getIdalumno());
            state.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Conexion.close(state);
            Conexion.close(con);

        }
    }


}
