/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

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
    private String estado;

    public Insumo(String id, String nombre, String tipo, int cantidad, String medida) {
        this.con= new Conexion();
        ArrayList<HashMap> res= this.con.query("SELECT * FROM insumo WHERE id='"+id+"';");
        if(res.isEmpty()){
            this.con.query("INSERT INTO insumo (id, nombre, tipo, cantidad, medida) VALUES('"+id+"', '"+nombre+"', '"+tipo+"', "+cantidad+", '"+medida+"');");
            this.id = id;
            this.nombre = nombre;
            this.tipo = tipo;
            this.cantidad = cantidad;
            this.medida = medida;
            this.estado= "1";
        }
        else{
            this.id= res.get(0).get("id")+"";
            this.nombre= res.get(0).get("nombre").toString();
            this.tipo= res.get(0).get("tipo")+"";
            this.cantidad= Integer.valueOf(res.get(0).get("cantidad")+"");
            this.medida= res.get(0).get("medida").toString();
            this.estado= res.get(0).get("estado").toString();
        }
    }
    
    public static ArrayList<String[]> getInsumos() {
        Conexion con = new Conexion();
        ArrayList<String[]> ins = new ArrayList<String[]>();
        ArrayList<HashMap> inms = con.query("SELECT * FROM insumo WHERE estado= 1");
        for (HashMap inm: inms) {
            String m[] = {inm.get("id").toString(), inm.get("nombre").toString(), inm.get("tipo").toString(), inm.get("cantidad").toString(), inm.get("medida").toString()};
            ins.add(m);
        }
        return ins;
    }

    public Insumo(String id, String nombre, String tipo, int cantidad, String medida, String estado) {
        this.con=new Conexion();
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.medida = medida;
        this.estado= estado;
    }

    public String getEstado() {
        return estado;
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

    public void setEstado(String estado) {
        this.con.query("UPDATE insumo SET estado='"+estado+"' WHERE id='"+this.id+"';");
        this.estado = estado;        
    }

    public void setMedida(String medida) {
        this.con.query("UPDATE insumo SET medida='"+medida+"' WHERE id='"+this.id+"';");
        this.medida = medida;
    }

    public void setTipo(String tipo) {
        this.con.query("UPDATE insumo SET tipo='"+tipo+"' WHERE id='"+this.id+"';");
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad, int opc) {
        if(opc==1){
            this.con.query("UPDATE insumo SET cantidad= cantidad +"+cantidad+" WHERE id='"+this.id+"';");
            this.cantidad+=cantidad;
        }
        else{
            this.con.query("UPDATE insumo SET cantidad= cantidad -"+cantidad+" WHERE id='"+this.id+"';");
            this.cantidad-=cantidad;
        }
    }

    public void setNombre(String nombre) {
        this.con.query("UPDATE insumo SET nombre= '"+nombre+"' WHERE id= '"+this.id+"';");
        this.nombre = nombre;
    }
    
    public static Insumo existe(String id){
        Conexion c= new Conexion();
        ArrayList<HashMap> res= c.query("SELECT nombre, tipo, cantidad, medida, estado FROM insumo WHERE id= '"+id+"';");
        if(!res.isEmpty()){
            return new Insumo(id, res.get(0).get("nombre")+"", 
                              res.get(0).get("tipo").toString(),
                              Integer.parseInt(res.get(0).get("cantidad")+""),
                              res.get(0).get("medida").toString(),
                              res.get(0).get("estado")+"");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Insumo{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", cantidad=" + cantidad + ", medida=" + medida + ", estado=" + estado + '}';
    }
    
}
