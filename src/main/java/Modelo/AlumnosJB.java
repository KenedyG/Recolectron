package Modelo;

import java.io.*;

public class AlumnosJB implements Serializable {
    private static final long SerialVersionUID = 1L;
    private int idalumno;
    private String nombre;
    private String materia;

    /*Constructor Vacío*/
    public AlumnosJB(){

    }

    public AlumnosJB(int idalumno, String nombre, String materia) {
        /*Constructor Completo*/
    }
    public int getIdalumno() {
        return idalumno;
    }
    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
}
