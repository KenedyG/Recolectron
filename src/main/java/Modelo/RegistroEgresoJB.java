package Modelo;

import java.io.*;
import java.sql.Timestamp;
import java.sql.Date;

public class RegistroEgresoJB implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idRegistroEgreso;
    private String nombre;
    private String matricula;
    private String materia;
    private String facultad;
    private String carrera;
    private String nivelacademico;
    private double donativo;
    private Date fecha;
    private int idelectronico;

    public RegistroEgresoJB() {

    }
    public RegistroEgresoJB(String nombre, String matricula, String materia,String facultad,String carrera, String nivelacademico, double donativo, Date fecha){

    }
    public int getIdRegistroEgreso() {
        return idRegistroEgreso;
    }
    public void setIdRegistroEgreso(int idRegistroEgreso) {
        this.idRegistroEgreso = idRegistroEgreso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getNivelacademico() {
        return nivelacademico;
    }
    public void setNivelacademico(String nivelacademico) {
        this.nivelacademico = nivelacademico;
    }
    public double getDonativo() {
        return donativo;
    }
    public void setDonativo(double donativo) {
        this.donativo = donativo;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getIdelectronico() {
        return idelectronico;
    }
    public void setIdelectronico(int idelectronico) {
        this.idelectronico = idelectronico;
    }
}
