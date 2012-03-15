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
public class Insumo {
    private Conexion con;
    private String id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private String medida;

    public Insumo(String id, String nombre, String tipo, int cantidad, String medida) {
        this.con= new Conexion();
        ArrayList<HashMap> res= this.con.query("SELECT nombre, tipo, cantidad, medida FROM insumo WHERE id='"+id+"';");
        if(res.isEmpty()){
            this.con.query("INSERT INTO insumo VALUES('"+id+"', '"+nombre+"', '"+tipo+"', "+cantidad+", '"+medida+"');");
            this.id = id;
            this.nombre = nombre;
            this.tipo = tipo;
            this.cantidad = cantidad;
            this.medida = medida;
        }
        else{
            this.id= res.get(0).get("id")+"";
            this.nombre= res.get(0).get("nombre").toString();
            this.tipo= res.get(0).get("tipo")+"";
            this.cantidad= Integer.valueOf(res.get(0).get("cantidad")+"");
            this.medida= res.get(0).get("medida").toString();
        }
    }
    
    public static ArrayList<String[]> getInsumos() {
        Conexion con = new Conexion();
        ArrayList<String[]> ins = new ArrayList<String[]>();
        ArrayList<HashMap> inms = con.query("SELECT * FROM insumo");
        for (HashMap inm: inms) {
            String m[] = {inm.get("id").toString(), inm.get("nombre").toString(), inm.get("tipo").toString(), inm.get("cantidad").toString(), inm.get("medida").toString()};
            ins.add(m);
        }
        return ins;
    }

    private Insumo(String id, String nombre, String tipo, int cantidad, String medida, char a) {
        this.con=new Conexion();
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.medida = medida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getId() {
        return id;
    }

    public String getMedida() {
        return medida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setMedida(String medida) {
        this.con.query("UPDATE insumo SET medida='"+medida+"' WHERE id='"+this.id+"';");
        this.medida = medida;
    }

    public void setTipo(String tipo) {
        this.con.query("UPDATE insumo SET tipo='"+tipo+"' WHERE id='"+this.id+"';");
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.con.query("UPDATE insumo SET cantidad= cantidad+"+cantidad+" WHERE id='"+this.id+"';");
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.con.query("UPDATE insumo SET nombre= '"+nombre+"' WHERE id= '"+this.id+"';");
        this.nombre = nombre;
    }
    
    public void eliminar(){
        this.con.query("DELETE FROM insumo WHERE id= '"+this.id+"';");
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Insumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Insumo existe(String id){
        Conexion c= new Conexion();
        ArrayList<HashMap> res= c.query("SELECT nombre, tipo, cantidad, medida FROM insumo WHERE id= '"+id+"';");
        if(!res.isEmpty()){
            return new Insumo(id, res.get(0).get("nombre")+"", 
                              res.get(0).get("tipo").toString(),
                              Integer.parseInt(res.get(0).get("cantidad")+""),
                              res.get(0).get("medida").toString(), 'a');
        }
        return null;
    }

    @Override
    public String toString() {
        return "Insumo{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", cantidad=" + cantidad + ", medida=" + medida + '}';
    }
    
}
