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
    private static final String insertSQL = "INSERT INTO registro_egreso (nombre,matricula,materia,facultad,carrera,nivel_academico,donativoe,fecha,id_electronico) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String updateSQL = "UPDATE registro_egreso SET  nombre = ?, matricula  = ?, materia = ?, facultad = ?, nivel_academico = ?, donativoe = ?, fecha = ?, id_electronico = ? WHERE idRegistroEgreso = ?";


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
                RegistroEgresoJB registro = new RegistroEgresoJB();
                int idrp = result.getInt("id_rp");
                String Nombre = result.getString("nombre");
                String Matricula = result.getString("matricula");
                String Materia = result.getString("materia");
                String Facultad = result.getString("facultad");
                String Carrera = result.getString("carrera");
                String nivelacademico = result.getString("nivel_academico");
                double donativo = result.getDouble("donativoe");
                Date fecha = result.getDate("fecha");
                int idelectronico = result.getInt("id_electronico");
                /*debug
                System.out.println("ID RP: " + idrp);
                System.out.println("Nombre: " + Nombre);
                System.out.println("Matrícula: " + Matricula);
                System.out.println("Materia: " + Materia);
                System.out.println("Facultad: " + Facultad);
                System.out.println("Nivel Académico: " + nivelacademico);
                System.out.println("Donativo: " + donativo);
                System.out.println("Fecha: " + fecha);
                System.out.println("ID Electrónico: " + idelectronico);

                 */
                registro.setIdRegistroEgreso(idrp);
                registro.setNombre(Nombre);
                registro.setMatricula(Matricula);
                registro.setMateria(Materia);
                registro.setFacultad(Facultad);
                registro.setCarrera(Carrera);
                registro.setNivelacademico(nivelacademico);
                registro.setDonativo(donativo);
                registro.setFecha(fecha);
                registro.setIdelectronico(idelectronico);
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
            state.setString(1, registroeJB.getNombre());
            state.setString(2, registroeJB.getMatricula());
            state.setString(3, registroeJB.getMateria());
            state.setString(4,registroeJB.getFacultad());
            state.setString(5,registroeJB.getCarrera());
            state.setString(6, registroeJB.getNivelacademico());
            state.setDouble(7, registroeJB.getDonativo());
            state.setDate(8, registroeJB.getFecha());
            state.setInt(9,registroeJB.getIdelectronico());

            state.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }

    public void modificarRegistro(RegistroEgresoJB registroeJB){
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setString(1, registroeJB.getNombre());
            state.setString(2, registroeJB.getMatricula());
            state.setString(3, registroeJB.getMateria());
            state.setString(4,registroeJB.getFacultad());
            state.setString(5, registroeJB.getNivelacademico());
            state.setDouble(6, registroeJB.getDonativo());
            state.setDate(7, registroeJB.getFecha());
            state.setInt(8,registroeJB.getIdelectronico());

            state.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
