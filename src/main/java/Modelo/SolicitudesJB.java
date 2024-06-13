package Modelo;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class SolicitudesJB implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idSolicitud;
    private int noequipo;
    private Timestamp fechaSolicitud;
    private Timestamp fechaUso;
    private String status;
    private int idalumno;

    public SolicitudesJB() {}

    public SolicitudesJB(int idSolicitud, int noequipo, Timestamp fechaSolicitud, Timestamp fechaUso, String status, int idalumno) {
        this.idSolicitud = idSolicitud;
        this.noequipo = noequipo;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaUso = fechaUso;
        this.status = status;
        this.idalumno = idalumno;
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
    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public Timestamp getFechaUso() {
        return fechaUso;
    }
    public void setFechaUso(Timestamp fechaUso) { this.fechaUso = fechaUso;}
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
