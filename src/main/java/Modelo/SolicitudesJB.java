package Modelo;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;

public class SolicitudesJB implements Serializable {
    private static final long serialVersionUID = 1L;
    private int noequipo;
    private Timestamp fechaSolicitud;
    private Timestamp fechaUso;
    private String status;
    private int idalumno;

    public SolicitudesJB() {}

    public SolicitudesJB(int noequipo, Date fechaSolicitud, Date fechaUso, String status, int idSolicitudes) {
    }

    public SolicitudesJB(int noequipo, String fechaSolicitud, Date fechaUso, String status, int idAlumno) {
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
    public Timestamp setFechaUso(Timestamp fechaUso) {
        this.fechaUso = fechaUso;
        return fechaUso;
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

    public void setIdSolicitud(int idSolicitud) {

    }

    public int getIdSolicitud() {
        return 0;
    }
}
