package Modelo;
import java.io.*;
public class AsistenciasJB implements Serializable{
    private int id_Asistencia;
    private String HoraEntrada;
    private String HorasSalida;
    private int id_User;


    public AsistenciasJB(){

    }

    public int getId_Asistencia() {
        return id_Asistencia;
    }

    public void setId_Asistencia(int id_Asistencia) {
        this.id_Asistencia = id_Asistencia;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        HoraEntrada = horaEntrada;
    }

    public String getHorasSalida() {
        return HorasSalida;
    }

    public void setHorasSalida(String horasSalida) {
        HorasSalida = horasSalida;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }
}
