/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author zirex
 */
public class Compra{
    private Conexion con;
    private int numFact;
    private Date fechaFact;
    private double total;
    private String cedula;
    private Object [][] items;

    public Compra(int numFact, Date fechaFact, double total, String cedula, Object [][] items) {
        this.con= new Conexion();
        this.con.query("INSERT INTO compra VALUES ("+numFact+", '"+new java.sql.Date(fechaFact.getTime())+"', "+total+", '"+cedula+"')");
        this.numFact = numFact;
        this.fechaFact = fechaFact;
        this.total = total;
        this.cedula = cedula;
        this.items= items;
        
        for(int i=0; i<items.length; i++){this.con.query("INSERT INTO detalle_compra VALUES ('"+items[i][0].toString()+"', '"+items[i][1].toString()+"', '"+
                           items[i][2].toString()+"', '"+items[i][3].toString()+"');");       
        }
    }
    
    private Compra(int numFact, Date fechaFact, double total, String cedula, Object [][] items, char a){
        this.con= new Conexion();
        this.numFact= numFact;
        this.fechaFact= fechaFact;
        this.total= total;
        this.cedula= cedula;
        this.items= items;
    }

    public String getCedula() {
        return cedula;
    }

    public Date getFechaFact() {
        return fechaFact;
    }

    public Object[][] getItems() {
        return items;
    }

    public int getNumFact() {
        return numFact;
    }

    public double getTotal() {
        return total;
    }
    
    public static Compra existe(String numFact){
        Conexion c= new Conexion();
        Object [][] itemsCompra;
        ArrayList<String []> insumos= Insumo.getInsumos();
        
        ArrayList<HashMap> res= c.query("SELECT fecha, total, cedula from compra where num="+numFact);
        if(!res.isEmpty()){
            ArrayList<HashMap> res1= c.query("SELECT * FROM detalle_compra where num="+numFact);
            itemsCompra= new Object[res1.size()][3];
            for(int i=0; i<res1.size(); i++)
                for(String [] insumo: insumos)
                    if(insumo[0].equals(res.get(i).get("id"))){
                        itemsCompra[i][0]=insumo[1];
                        itemsCompra[i][1]=res.get(i).get("cantidad");
                        itemsCompra[i][2]=res.get(i).get("precio");
                        break;
                    }
            return new Compra(Integer.parseInt(res.get(0).get("num")+""),
                              (Date) res.get(0).get("fecha"),
                              Double.parseDouble(res.get(0).get("total")+""),
                              res.get(0).get("cedula")+"",
                              itemsCompra,'a');
        }
        return null;
    }
    
    public static String getMaxNumFact() {
        Conexion c = new Conexion();
        ArrayList<HashMap> res = c.query("SELECT MAX(num) as max FROM compra");
        int max = 0;
        Object data = res.get(0).get("max");
        if (data != null) {
            max = Integer.parseInt(data.toString());
        }
        return (max+1)+"";
    }
}
