/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zirex
 */
public abstract class Persona {
    
    protected Conexion con;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String telefono;

    public Persona(String cedula, String nombres, String apellidos, String direccion, String telefono) {
        this.con = new Conexion();
        ArrayList<HashMap> res = this.con.query("SELECT nombres, apellidos, telefono, direccion FROM persona WHERE cedula ='"+cedula+"'");
        if(res.isEmpty()){
            this.con.query("INSERT INTO persona (cedula, nombres, apellidos, telefono, direccion) VALUES('"+cedula+"', '"+nombres+"', '"+apellidos+"', '"+telefono+"', '"+direccion+"')");
            this.cedula = cedula;
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.direccion = direccion;
            this.telefono = telefono;
        } else {
            this.cedula = cedula;
            this.nombres = res.get(0).get("nombres")+"";
            this.apellidos = res.get(0).get("apellidos")+"";
            this.direccion = res.get(0).get("direccion")+"";
            this.telefono = res.get(0).get("telefono")+"";
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setApellidos(String apellidos) {
        this.con.query("UPDATE persona SET apellidos = '"+apellidos+"' WHERE cedula = '"+this.cedula+"'");
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.con.query("UPDATE persona SET direccion = '"+direccion+"' WHERE cedula = '"+this.cedula+"'");
        this.direccion = direccion;
    }

    public void setNombres(String nombres) {
        this.con.query("UPDATE persona SET nombres = '"+nombres+"' WHERE cedula = '"+this.cedula+"'");
        this.nombres = nombres;
    }

    public void setTelefono(String telefono) {
        this.con.query("UPDATE persona SET telefono = '"+telefono+"' WHERE cedula = '"+this.cedula+"'");
        this.telefono = telefono;
    }
    
    public void eliminar() {
        this.con.query("DELETE FROM persona WHERE cedula = '"+this.cedula+"'");
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
