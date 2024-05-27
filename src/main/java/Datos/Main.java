package Datos;

public class Main {
    public static void main(String[] args) {
        // Verificar la conexión a la base de datos
        try {
            System.out.println("Probando conexión a la base de datos...");
            Conexion.getConnection();
            System.out.println("Conectados");
        } catch (Exception e) {
            System.out.println("Error, checa la configuración" + e.getMessage());
        }
    }
}