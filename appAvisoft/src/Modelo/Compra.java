/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.ItemCompra;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zirex
 */
public class Compra{
    private Conexion con = new Conexion();
    private int numFact;
    private Date fechaFact;
    private double total;
    private String cedula;
    private String nit;
    private ArrayList<ItemCompra> itemsCompra;
    
    public Compra(){
    }
    
    private Compra(int numFact, Date fechaFact, double total, String cedula, String nit, ArrayList<ItemCompra> itemsCompra) {
        this.numFact = numFact;
        this.fechaFact = fechaFact;
        this.total = total;
        this.cedula = cedula;
        this.nit= nit;
        this.itemsCompra= itemsCompra;
    }
    
    public static Compra create (int numFact, Date fechaFact, double total, String cedula, String nit, ArrayList<ItemCompra> itemsCompra) {
        Compra compra = Compra.existe(numFact);
        Conexion c = new Conexion();
        if(compra == null){
            c.query("INSERT INTO compra VALUES ("+numFact+", '"+new java.sql.Date(fechaFact.getTime())+"', "+total+", '"+cedula+"', '"+nit+"')");
            for(ItemCompra item: itemsCompra){
                c.query("INSERT INTO detalle_compra VALUES ('"+numFact+"', '"+item.getId()+"', '"+
                               item.getCantidad()+"', '"+item.getPrecioUnt()+"');");
            }
            compra = new Compra (numFact, fechaFact, total, cedula, nit, itemsCompra);
        }
        return compra;
    }
    
    public static DefaultTableModel tablaCompra(){
        DefaultTableModel tabla;
        Conexion con= new Conexion();
        String[] ColumnName={"Num. Factura", "Proveedor", "Opciones"};
        ArrayList<HashMap> res= con.query("SELECT c.num, p.nombres, p.apellidos, e.razon_social "+
                                          "FROM compra c "+
                                          "INNER JOIN persona p ON c.cedula= p.cedula "+
                                          "INNER JOIN empresa e ON c.nit= e.nit");
        Object [][] datos= new Object[res.size()][ColumnName.length];
        int i=0;
        for (HashMap fila : res) {
            datos[i][0]= fila.get("num").toString();
            datos[i][1]= fila.get("razon_social").toString() +", "+fila.get("nombres").toString()+" "+fila.get("apellidos").toString();
            datos[i][2]= "";
            i++;
        }
        tabla= new DefaultTableModel(datos, ColumnName){
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex==2;
            }
            @Override
            public Class<?> getColumnClass(int c){
                return super.getColumnClass(c).getClass();
            }
        };
        return tabla;
    }

    public ArrayList<ItemCompra> getItemsCompra() {
        return itemsCompra;
    }
    
    public String getNit() {
        return nit;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFechaFact() {
        SimpleDateFormat formateador= new SimpleDateFormat("yyyy-MM-dd", new Locale("es_ES"));
        String fecha=formateador.format(fechaFact.getTime());
        return fecha;
    }
    
    public Date getFecha () {
        return fechaFact;
    }

    public int getNumFact() {
        return numFact;
    }

    public double getTotal() {
        return total;
    }
    
    public static Compra existe(int numFact){
        SimpleDateFormat formateador= new SimpleDateFormat("yyyy-MM-dd");
        Conexion c = new Conexion();
        
        ArrayList<HashMap> res = c.query("SELECT fecha, total, cedula, nit from compra where num="+numFact);
        if(!res.isEmpty()){
            ArrayList<ItemCompra> registrosCompra = new ArrayList<ItemCompra>();
            String sql = "SELECT dc.id, i.nombre, dc.cantidad, dc.precio from detalle_compra dc "+
                         "INNER JOIN insumo i ON dc.id = i.id "+
                         "INNER JOIN compra c ON c.num=dc.num AND c.num="+numFact;
            System.out.println(sql);
            ArrayList<HashMap> registros = c.query(sql);
            if(!registros.isEmpty()){
                for (HashMap item : registros) {
                    ItemCompra aux;
                    int id = Integer.parseInt(item.get("id").toString());
                    String nombre = item.get("nombre").toString();
                    int cantidad = Integer.parseInt(item.get("cantidad").toString());
                    float precioU = Float.parseFloat(item.get("precio").toString());
                    float totalPrecio = cantidad * precioU;
                    aux = new ItemCompra(id, nombre, cantidad, precioU, totalPrecio);
                    registrosCompra.add(aux);
                }
            }
            try {
                System.out.println(res.get(0).get("fecha"));
                Date fecha = formateador.parse(res.get(0).get("fecha").toString());
                return new Compra(numFact,
                              fecha,
                              Double.parseDouble(res.get(0).get("total")+""),
                              res.get(0).get("cedula")+"",
                              res.get(0).get("nit")+"",
                              registrosCompra);
            } catch (ParseException ex) {
                Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
            }
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
