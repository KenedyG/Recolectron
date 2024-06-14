package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.InventarioJB;

public class InventarioDAO {
    private static final String selectSQL = "SELECT * FROM inventario";
    private static final String insertSQL = "INSERT INTO inventario (nombre, fabricante, modelo, especificaciones, peso, status, stock) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String updateSQL = "UPDATE inventario SET nombre = ?, fabricante = ?, modelo = ?, especificaciones = ?, peso = ?, status = ?, stock = ? WHERE id_electronico = ?";
    private static final String deleteSQL = "DELETE FROM inventario WHERE id_electronico = ?";

    public List<InventarioJB> listar() {
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;

        List<InventarioJB> inventariojb = new ArrayList<>();
        List<InventarioJB> debugList = new ArrayList<>(); // Lista para debugging

        System.out.println("Ejecutando el método listar() del InventarioDAO.");

        try {
            System.out.println("Estableciendo conexión con la base de datos...");
            con = Conexion.getConnection();
            state = con.prepareStatement(selectSQL);
            result = state.executeQuery();
            while (result.next()) {
                InventarioJB inventario = new InventarioJB();
                inventario.setIdelectronico(result.getInt("id_electronico"));
                inventario.setNombre(result.getString("nombre"));
                inventario.setFabricante(result.getString("fabricante"));
                inventario.setModelo(result.getString("modelo"));
                inventario.setEspecificaciones(result.getString("especificaciones"));
                inventario.setPeso(result.getInt("peso"));
                inventario.setStatus(result.getString("status"));
                inventario.setStock(result.getInt("stock"));

                inventariojb.add(inventario);
                debugList.add(inventario);
                /*
                System.out.println("Lista de Debugging:");
                for (InventarioJB item : debugList) {
                    System.out.println("ID: " + item.getIdelectronico());
                    System.out.println("Nombre: " + item.getNombre());
                    System.out.println("Fabricante: " + item.getFabricante());
                    System.out.println("Modelo: " + item.getModelo());
                    System.out.println("Especificaciones: " + item.getEspecificaciones());
                    System.out.println("Peso: " + item.getPeso());
                    System.out.println("Status: " + item.getStatus());
                    System.out.println("Stock: " + item.getStock());
                    System.out.println("------------------------------------");
                }
                */

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventariojb;
    }

    public void agregarInventario(InventarioJB inventario) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(insertSQL);
            state.setString(1, inventario.getNombre());
            state.setString(2, inventario.getFabricante());
            state.setString(3, inventario.getModelo());
            state.setString(4, inventario.getEspecificaciones());
            state.setInt(5, inventario.getPeso());
            state.setString(6, inventario.getStatus());
            state.setInt(7, inventario.getStock());
            state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }

    public void actualizarInventario(InventarioJB inventario) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(updateSQL);
            state.setString(1, inventario.getNombre());
            state.setString(2, inventario.getFabricante());
            state.setString(3, inventario.getModelo());
            state.setString(4, inventario.getEspecificaciones());
            state.setInt(5, inventario.getPeso());
            state.setString(6, inventario.getStatus());
            state.setInt(7, inventario.getStock());
            state.setInt(8, inventario.getIdelectronico());
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }

    public void eliminarInventario(InventarioJB inventario) {
        Connection con = null;
        PreparedStatement state = null;

        try {
            con = Conexion.getConnection();
            state = con.prepareStatement(deleteSQL);
            state.setInt(1, inventario.getIdelectronico());
            /*
            System.out.println("SQL para eliminar: " + state.toString());

             */

            state.executeUpdate();
            /*
            System.out.println("Objeto eliminado correctamente");

             */
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el objeto");
        } finally {
            Conexion.close(state);
            Conexion.close(con);
        }
    }

    public InventarioJB InventarioID(int id) {
        InventarioJB inventario = new InventarioJB();
        Connection con = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try{
            con = Conexion.getConnection();
            state = con.prepareStatement("SELECT * FROM inventario WHERE id_electronico = ?");
            state.setInt(1, id);
            result = state.executeQuery();
            if (result.next()) {
                inventario = new InventarioJB();
                inventario.setIdelectronico(result.getInt("id_electronico"));
                inventario.setNombre(result.getString("nombre"));
                inventario.setFabricante(result.getString("fabricante"));
                inventario.setModelo(result.getString("modelo"));
                inventario.setEspecificaciones(result.getString("especificaciones"));
                inventario.setPeso(result.getInt("peso"));
                inventario.setStatus(result.getString("status"));
                inventario.setStock(result.getInt("stock"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Conexion.close(result);
            Conexion.close(state);
            Conexion.close(con);
        }
        /*Debug*/
        if (inventario != null) {
            System.out.println("Objeto inventario modificado: " + inventario);
        }
        return inventario;
    }
}
