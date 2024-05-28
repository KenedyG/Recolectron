package Modelo;
import java.io.*;

public class DonativoJB implements Serializable {
    private int idDonativo;
    private String nombre;
    private String nombreobjeto;

    public DonativoJB() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDonativo() {
        return idDonativo;
    }

    public void setIdDonativo(int idDonativo) {
        this.idDonativo = idDonativo;
    }

    public String getNombreobjeto() {
        return nombreobjeto;
    }

    public void setNombreobjeto(String nombreobjeto) {
        this.nombreobjeto = nombreobjeto;
    }
}

