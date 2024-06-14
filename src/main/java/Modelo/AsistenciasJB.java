package Modelo;
import java.io.*;
import java.sql.Timestamp;

public class AsistenciasJB implements Serializable {
    private int id_asistencia;
    private Timestamp horaentrada;
    private Timestamp horasalida;
    private int id_User;

    public AsistenciasJB(){};

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public Timestamp getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(Timestamp horaentrada) {
        this.horaentrada = horaentrada;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public Timestamp getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Timestamp horasalida) {
        this.horasalida = horasalida;
    }
}
