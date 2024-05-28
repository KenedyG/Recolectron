package Modelo;

import java.io.*;

public class InventarioJB implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idelectronico;
    private String nombre;
    private String fabricante;
    private String modelo;
    private String especificaciones;
    private String peso;
    private String status;
    private int stock;

    public InventarioJB() {

    }
    public InventarioJB(int idelectronico, String nombre, String fabricante, String modelo, String especificaciones, String peso, String status, int stock){

    }

    public int getIdelectronico() {
        return idelectronico;
    }
    public void setIdelectronico(int idelectronico) {
        this.idelectronico = idelectronico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getEspecificaciones() {
        return especificaciones;
    }
    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }
    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}

