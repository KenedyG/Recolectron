package Modelo;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;

public class SolicitudesJB implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idSolicitud;
    private int noequipo;
    private String fechaSolicitud;
    private String fechaUso;
    private String status;
    private int idalumno;

    public SolicitudesJB() {

    }
    public SolicitudesJB(int idSolicitud,int noequipo, Date fechaSolicitud, Date fechaUso, String status, int idalumno) {

    }
    public int getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public int getNoequipo() {
        return noequipo;
    }
    public void setNoequipo(int Noequipo) {
        this.noequipo = Noequipo;
    }
    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public Timestamp getFechaUso() {
        return fechaUso;
    }
    public String setFechaUso(String fechaUso) {
        this.fechaUso = fechaUso;
        return  fechaUso;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getIdalumno() {
        return idalumno;
    }
    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }
}
