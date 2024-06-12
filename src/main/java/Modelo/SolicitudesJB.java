package Modelo;

import java.io.*;
import java.sql.Date;

public class SolicitudesJB implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idSolicitud;
    private int noequipo;
    private Date fechaSolicitud;
    private Date fechaUso;
    private String status;
    private int idalumno;

    public SolicitudesJB() {}

    public SolicitudesJB(int idSolicitud, int noequipo, Date fechaSolicitud, Date fechaUso, String status, int idalumno) {
    }

    public int getNoequipo() {
        return noequipo;
    }
    public void setNoequipo(int Noequipo) {
        this.noequipo = Noequipo;
    }
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
    public Date getFechaUso() {
        return fechaUso;
    }
    public Date setFechaUso(Date fechaUso) {
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
}
