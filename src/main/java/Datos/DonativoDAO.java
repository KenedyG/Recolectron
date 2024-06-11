package Datos;

import java.sql.*;
import java.util.*;
import Modelo.DonativoJB;

public class DonativoDAO {
    private static final String selectSQL = "SELECT * FROM donativo;";
    private static final String insertSQL = "INSERT INTO donativo (id_donativo, nombre, nombreObjeto) VALUES (?, ?, ?)";
    private static final String updateSQL = "UPDATE donativo SET nombre = ?, nombreObjeto = ? WHERE id_donativo = ?";

    public List<DonativoJB> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<DonativoJB> donativos = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while (result.next()) {
                int id_donativo = result.getInt("id_donativo");
                String nombre = result.getString("nombre");
                String nombreObjeto = result.getString("nombreObjeto");

                DonativoJB donativo = new DonativoJB(nombre, nombreObjeto);
                donativos.add(donativo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        return donativos;
    }

    public void agregar(DonativoJB donativo) {
        Connection con = null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setInt(1, donativo.getIdDonativo());
            state.setString(2, donativo.getNombre());
            state.setString(3, donativo.getNombreobjeto());
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    public void ModificarDonativo (DonativoJB donativo){

        Connection con =  null;
        PreparedStatement state = null;
        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setString(1, donativo.getNombre());
            state.setString(2, donativo.getNombreobjeto());
            state.setInt(3, donativo.getIdDonativo());
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
}
