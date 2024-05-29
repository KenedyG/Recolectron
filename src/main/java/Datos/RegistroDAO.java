package Datos;

import java.util.*;

public class RegistroDAO {
    private static final String selectSQL = "SELECT * FROM registro WHERE id_user = ?, nombre = ?, apellidop = ?, apellidom = ?, correo = ?, usuario = ?, password = ?";
    private static final String insertSQL = "INSERT INTO registro (id_user,nombre,apellidop,apellidom,correo,usuario,password) VALUES (?,?,?,?,?,?,?)";
    private static final String deleteSQL = "DELETE FROM registro WHERE id_user = ?";

    public List<RegistroDAO> listar() {

    }
}
