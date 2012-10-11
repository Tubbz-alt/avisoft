/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

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
    private String nit;
    private Object [][] items;
    
    public Compra(int numFact, Date fechaFact, double total, String cedula, String nit, Object [][] items) {
        this.con= new Conexion();
        this.con.query("INSERT INTO compra VALUES ("+numFact+", '"+new java.sql.Date(fechaFact.getTime())+"', "+total+", '"+cedula+"', '"+nit+"')");
        this.numFact = numFact;
        this.fechaFact = fechaFact;
        this.total = total;
        this.cedula = cedula;
        this.nit= nit;
        this.items= items;
        
        for(int i=0; i<items.length; i++){
            this.con.query("INSERT INTO detalle_compra VALUES ('"+items[i][0].toString()+"', '"+items[i][1].toString()+"', '"+
                           items[i][2].toString()+"', '"+items[i][3].toString()+"');");
            Insumo ins= Insumo.existe(items[i][1].toString());
            ins.setCantidad(Integer.parseInt(items[i][2]+""), 1);
        }
    }
    
    private Compra(int numFact, Date fechaFact, double total, String cedula, String nit, Object [][] items, char a){
        this.con= new Conexion();
        this.numFact= numFact;
        this.fechaFact= fechaFact;
        this.total= total;
        this.cedula= cedula;
        this.nit=nit;
        this.items= items;
    }
    
    public static DefaultTableModel tablaCompra(){
        DefaultTableModel tabla;
        Conexion con= new Conexion();
        String[] ColumnName={"Num. Factura", "Proveedor"};
        ArrayList<HashMap> res= con.query("SELECT c.num, p.nombres, p.apellidos, e.razon_social "+
                                          "FROM compra c "+
                                          "INNER JOIN persona p ON c.cedula= p.cedula "+
                                          "INNER JOIN empresa e ON c.nit= e.nit");
        Object [][] datos= new Object[res.size()][ColumnName.length];
        int i=0;
        for (HashMap fila : res) {
            datos[i][0]= fila.get("num").toString();
            datos[i][1]= fila.get("razon_social").toString() +", "+fila.get("nombres").toString()+" "+fila.get("apellidos").toString();
            i++;
        }
        tabla= new DefaultTableModel(datos, ColumnName){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex==1;
            }
            @Override
            public Class<?> getColumnClass(int c){
                return super.getColumnClass(c).getClass();
            }
        };
        return tabla;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFechaFact() {
        SimpleDateFormat formateador= new SimpleDateFormat("yyyy-MM-dd", new Locale("es_ES"));
        String fecha=formateador.format(fechaFact.getTime());
        return fecha;
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
        SimpleDateFormat formateador= new SimpleDateFormat("yyyy-MM-dd", new Locale("es_ES"));
        java.util.Date fecha= null;
        Conexion c= new Conexion();
        Object [][] itemsCompra;
        ArrayList<String []> insumos= Insumo.getInsumos();
        
        ArrayList<HashMap> res= c.query("SELECT fecha, total, cedula, nit from compra where num="+numFact);
        if(!res.isEmpty()){
            ArrayList<HashMap> res1= c.query("SELECT * FROM detalle_compra where num="+numFact);
            itemsCompra= new Object[res1.size()][3];
            int i=0;
            while(i < res1.size()){
                for(String [] insumo: insumos){
                    if(insumo[0].equals(res1.get(i).get("id"))){
                        itemsCompra[i][0]=insumo[1];
                        itemsCompra[i][1]=res1.get(i).get("cantidad");
                        itemsCompra[i][2]=res1.get(i).get("precio");                        
                        break;
                    }
                }
                i++;
            }
            try {
                fecha= formateador.parse(res.get(0).get("fecha").toString());
            } catch (ParseException ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
            return new Compra(Integer.parseInt(numFact),
                              new java.util.Date(fecha.getTime()),
                              Double.parseDouble(res.get(0).get("total")+""),
                              res.get(0).get("cedula")+"",
                              res.get(0).get("nit")+"",
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
    
    //---------------Código para imprimir factura---------------------------
    public void imprimir(){
        Imprimir imp= new Imprimir();
        imp.imprimir_Compra("Avisoft", String.valueOf(this.numFact), 
                            String.valueOf(this.cedula), String.valueOf(this.total), items);
    }
}
