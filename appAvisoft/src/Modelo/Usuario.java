/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Kraken
 */
public class Usuario {
    private String usuario;
    private String email;
    private Conexion c;
    
    private Usuario (String usuario,String email) {
        this.c = new Conexion();
        this.usuario = usuario;
        this.email = email;
    }
    
    public static Usuario existe (String usuario) {
        Conexion con = new Conexion();
        ArrayList<HashMap> res = con.query("SELECT email FROM usuario WHERE nombre = '"+usuario+"'");
        if (!res.isEmpty()) {
            return new Usuario (usuario, res.get(0).get("email").toString());
        }
        return null;
    }
    
    public static Usuario existe (String usuario,String clave) {
        Conexion con = new Conexion();
        ArrayList<HashMap> res = con.query("SELECT email FROM usuario WHERE nombre = '"+usuario+"' AND clave = md5('"+clave+"')");
        if(!res.isEmpty()) {
            return new Usuario (usuario, res.get(0).get("email").toString());
        }
        return null;
    }

    public String getEmail() {
        return email;
    }
    
    public String getUsuario() {
        return this.usuario;
    }

    public void setEmail(String email) {
        c.query("UPDATE usuario SET email = '"+email+"' WHERE nombre = '"+this.usuario+"'");
        this.email = email;
    }

    public void setClave(String clave) {
        c.query("UPDATE usuario SET clave = md5('"+clave+"') WHERE nombre = '"+this.usuario+"'");
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", email=" + email + '}';
    }
    
}
