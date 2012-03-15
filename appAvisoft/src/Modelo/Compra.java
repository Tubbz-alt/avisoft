/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

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

    public Compra(int numFact, Date fechaFact, double total, String cedula, String id, String nombre, String tipo, int cantidad, String medida, Object [][] items) {
        this.con= new Conexion();
        this.con.query("INSERT INTO compra VALUES ("+numFact+", "+fechaFact+", "+total+", '"+cedula+"')");
        this.numFact = numFact;
        this.fechaFact = fechaFact;
        this.total = total;
        this.cedula = cedula;
        this.items= items;
        
        for(int i=0; i<this.items.length; i++){
            this.con.query("INSERT INTO detalle_compra VALUES ('"+this.items[i][0].toString()+"', '"+this.items[i][1].toString()+"', '"+
                           this.items[i][2].toString()+"', '"+this.items[i][3].toString()+"');");
            
        }
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
    
}
