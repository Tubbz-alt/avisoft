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
public class Persona {
    
    protected Conexion con;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String telefono;
    protected boolean isProp;

    protected Persona(String cedula, String nombres, String apellidos, String direccion, String telefono, boolean isProp) {
        this.con = new Conexion();
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.isProp = isProp;
    }
    
    public static Persona create (String cedula, String nombres, String apellidos, String direccion, String telefono) {
        Conexion con = new Conexion ();
        System.out.println("OK");
        con.query("INSERT INTO persona (cedula, nombres, apellidos, telefono, direccion, prop) VALUES('"+cedula+"', '"+nombres+"', '"+apellidos+"', '"+telefono+"', '"+direccion+"', '1')");
        return new Persona(cedula, nombres, apellidos, direccion, telefono, true);
    }
    
    public static Persona existe (String cedula) {
        Conexion con = new Conexion ();
        ArrayList<HashMap> res = con.query("SELECT nombres, apellidos, telefono, direccion, prop FROM persona WHERE cedula ='"+cedula+"'");
        if (!res.isEmpty()) {
            HashMap prop = res.get(0);
            return new Persona(
                    cedula,
                    prop.get("nombres")+"",
                    prop.get("apellidos")+"",
                    prop.get("direccion")+"",
                    prop.get("telefono")+"",
                    ( Integer.parseInt(prop.get("prop")+"") == 1 )
            );
        }
        return null;
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
    
    public void setPropietario (boolean isProp) {
        this.con.query("UPDATE persona SET prop = '"+(isProp?'1':'0')+"' WHERE cedula = '"+this.cedula+"'");
        this.isProp = isProp;
    }
    
    public boolean isPropietario () {
        return this.isProp;
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
