/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zirex
 */
public class Insumo {
    private Conexion con;
    private String id;
    private String nombre;
    private int cantidad;
    private String medida;
    private String estado;
    private String nombre_tipo;

    public Insumo(String id, String nombre, int cantidad, String medida, String nombre_tipo) {
        this.con= new Conexion();
        ArrayList<HashMap> res= this.con.query("SELECT * FROM insumo WHERE id='"+id+"';");
        if(res.isEmpty()){
            this.con.query("INSERT INTO insumo (id, nombre, cantidad, medida, nombre_tipo) VALUES('"+id+"', '"+nombre+"', "+cantidad+", '"+medida+"', '"+nombre_tipo+"');");
            this.id = id;
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.medida = medida;
            this.estado= "1";
            this.nombre_tipo = nombre_tipo;
        }
        else{
            this.id= res.get(0).get("id")+"";
            this.nombre= res.get(0).get("nombre").toString();
            this.cantidad= Integer.valueOf(res.get(0).get("cantidad")+"");
            this.medida= res.get(0).get("medida").toString();
            this.estado= res.get(0).get("estado").toString();
            this.nombre_tipo= res.get(0).get("nombre_tipo")+"";
        }
    }
    
    public Insumo(String id, String nombre, int cantidad, String medida, String estado, String nombre_tipo) {
        this.con=new Conexion();
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.medida = medida;
        this.estado= estado;
        this.nombre_tipo= nombre_tipo;
    }
    
    public static boolean addTipo(String tipo){
        Conexion con = new Conexion();
        ArrayList<HashMap> res= con.query("SELECT * FROM tipo WHERE nombre_tipo= '"+tipo+"';");
        if(res.isEmpty()){
            con.query("INSERT INTO tipo VALUES ('"+tipo+"');");
            return true;
        }
        else{
            return false;
        }
    }
    
    public static ArrayList<String> consulTipo(){
        Conexion con= new Conexion();
        ArrayList<String> tipos= new ArrayList<String>();
        ArrayList<HashMap> res= con.query("SELECT * FROM tipo");
        for (HashMap tipo : res) {
            tipos.add(tipo.get("nombre_tipo").toString());
        }
        return tipos;
    }
    
    public static ArrayList<String[]> getInsumos() {
        Conexion con = new Conexion();
        ArrayList<String[]> ins = new ArrayList<String[]>();
        ArrayList<HashMap> inms = con.query("SELECT * FROM insumo WHERE estado= 1");
        for (HashMap inm: inms) {
            String m[] = {inm.get("id").toString(), inm.get("nombre").toString(), inm.get("nombre_tipo").toString(), inm.get("cantidad").toString(), inm.get("medida").toString()};
            ins.add(m);
        }
        return ins;
    }
    
    public static AbstractTableModel tablaIns(){
        AbstractTableModel tabla= new AbstractTableModel() {
            private Conexion con;
            private String[] ColumnName= {"Id", "Nombre", "Tipo", "Cant.", "Medida", "Estado"};
            private Object [][] cons= this.contenido();
            
            private Object[][] contenido(){
                boolean activo= true;
                boolean inactivo= false;
                this.con= new Conexion();
                Object [][] datos;
                ArrayList<HashMap> res= con.query("SELECT * FROM insumo");
                datos= new Object[res.size()][ColumnName.length];
                int i=0;
                for (HashMap fila : res) {
                    String [] col= {fila.get("id").toString(), fila.get("nombre").toString(), fila.get("nombre_tipo").toString(),
                                    fila.get("cantidad").toString(), fila.get("medida").toString(), fila.get("estado").toString()};
                    for(int j=0; j<ColumnName.length; j++){
                        if(j !=5){
                            datos[i][j]= col[j];
                        }
                        else{
                            if(Integer.parseInt(col[j]+"") == 1){
                                datos[i][j]= activo;
                            }
                            else{
                                datos[i][j]= inactivo;
                            }
                        }
                    }
                    i++;
                }
                return datos;
            }

            @Override
            public int getRowCount() {
                return this.cons.length;
            }

            @Override
            public int getColumnCount() {
                return this.ColumnName.length;
            }

            @Override
            public Object getValueAt(int i, int i1) {
                return this.cons[i][i1];
            }
            
            @Override
            public String getColumnName(int columnIndex){
                return this.ColumnName[columnIndex];
            }
            
            @Override
            public Class<?> getColumnClass(int c){
                return this.cons[0][c].getClass();
            }
            
            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex){
                if(columnIndex == 5){
                    boolean value= Boolean.parseBoolean(aValue.toString());
                    String estado= "0";
                    if(value == true){
                        estado= "1";
                    }
                    Insumo i= Insumo.existe(this.cons[rowIndex][0].toString());
                    i.setEstado(estado);
                    this.cons[rowIndex][columnIndex]= value;
                    // Disparamos el Evento TableDataChanged (La tabla ha cambiado)
                    //fireTableCellUpdated(rowIndex, columnIndex);
                }
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex==5;
            }
        };
        return tabla;
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
        return nombre_tipo;
    }

    public void setEstado(String estado) {
        this.con.query("UPDATE insumo SET estado='"+estado+"' WHERE id='"+this.id+"';");
        this.estado = estado;        
    }

    public void setMedida(String medida) {
        this.con.query("UPDATE insumo SET medida='"+medida+"' WHERE id='"+this.id+"';");
        this.medida = medida;
    }

    public void setTipo(String nombre_tipo) {
        this.con.query("UPDATE insumo SET nombre_tipo='"+nombre_tipo+"' WHERE id='"+this.id+"';");
        this.nombre_tipo = nombre_tipo;
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
        ArrayList<HashMap> res= c.query("SELECT nombre, nombre_tipo, cantidad, medida, estado FROM insumo WHERE id= '"+id+"';");
        if(!res.isEmpty()){
            return new Insumo(id, res.get(0).get("nombre")+"",
                              Integer.parseInt(res.get(0).get("cantidad")+""),
                              res.get(0).get("medida").toString(),
                              res.get(0).get("estado")+"", 
                              res.get(0).get("nombre_tipo").toString());
        }
        return null;
    }
    
    public static boolean update(String valores, String id)
    {
        Conexion conn= new Conexion();
        boolean res = false;
        String q = " UPDATE insumo SET " + valores + " WHERE id= " + id;
        ArrayList<HashMap> oper= conn.query(q);
        if(oper==null)
            res=true;
        return res;
    }

    @Override
    public String toString() {
        return "Insumo{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + nombre_tipo + ", cantidad=" + cantidad + ", medida=" + medida + ", estado=" + estado + '}';
    }
    
}
