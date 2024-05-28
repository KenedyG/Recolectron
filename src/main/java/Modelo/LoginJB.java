package Modelo;

import java.io.*;

public class LoginJB implements Serializable {
    private static final long SerialVersionUID = 1L;
    private String usuario;
    private String password;
    private int iduser;

    public LoginJB(){

    }

    public LoginJB(String usuario, String password, int iduser){

    }
    public String getUsuario (){
        return usuario;
    }
    public void setUsuario(){
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    
}
