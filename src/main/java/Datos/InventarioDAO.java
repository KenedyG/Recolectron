package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.InventarioJB;

public class InventarioDAO {
    private static final String selectSQL = "SELECT * FROM inventario";
    private static final String insertSQL = "INSERT INTO inventario (nombre,fabricante,modelo,especificaciones,peso,status,stock) VALUES (?,?,?,?,?,?,?)";
    private static final String updateSQL = "UPDATE inventario SET nombre = ?,fabricante = ?,modelo = ?,especificaciones = ?,peso = ?,status = ?,stock = ?";
    private static final String deleteSQL = "DELETE FROM inventario WHERE idelectronico = ?";

    public List<InventarioJB> listar(){
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<InventarioJB> inventariojb = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while (result.next()) {
                int idelectronico = result.getInt("idelectronico");
                String nombre = result.getString("nombre");
                String fabricante = result.getString("fabricante");
                String modelo = result.getString("modelo");
                String especificaciones = result.getString("especificaciones");
                String peso = result.getString("peso");
                String status = result.getString("status");
                int stock = result.getInt("stock");

                InventarioJB inventario = new InventarioJB();
                inventariojb.add(inventario);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
        return inventariojb;
    }
    public void agregarInventario (InventarioJB inventario) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setString(1, inventario.getNombre());
            state.setString(2, inventario.getFabricante());
            state.setString(3, inventario.getModelo());
            state.setString(4, inventario.getEspecificaciones());
            state.setString(5, inventario.getPeso());
            state.setString(6, inventario.getStatus());
            state.setInt(7, inventario.getStock());
            state.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    public void actualizarInventario (InventarioJB inventario) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setString(1, inventario.getNombre());
            state.setString(2, inventario.getFabricante());
            state.setString(3, inventario.getModelo());
            state.setString(4, inventario.getEspecificaciones());
            state.setString(5, inventario.getPeso());
            state.setString(6, inventario.getStatus());
            state.setInt(7, inventario.getStock());
            state.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }
    public void eliminarInventario (InventarioJB inventario) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);

            state.setInt(1, inventario.getIdelectronico());
            state.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
