/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zirex
 */
public class Proveedor extends Persona {
    
    private String nit;
    private String razonSocial;
    private String telEmp;
    private String dirEmp;
    private String estado;

    public Proveedor(String nit, String razonSocial, String telEmp, String dirEmp, String cedula, String nombres, String apellidos, String direccion, String telefono) {
        super(cedula, nombres, apellidos, direccion, telefono);
        ArrayList<HashMap> res = this.con.query("SELECT razon_social, telefono, direccion FROM empresa WHERE nit = '"+nit+"'");
        if(res.isEmpty()) {
            this.con.query("INSERT INTO empresa (nit, razon_social, telefono, direccion) VALUES ('"+nit+"', '"+razonSocial+"', '"+telefono+"', '"+direccion+"')");
            this.nit = nit;
            this.razonSocial = razonSocial;
            this.telEmp = telEmp;
            this.dirEmp = dirEmp;
        } else {
            this.nit = res.get(0).get("nit")+"";
            this.razonSocial = res.get(0).get("razon_social")+"";
            this.telEmp = res.get(0).get("telefono")+"";
            this.dirEmp = res.get(0).get("direccion")+"";
        }
        res = this.con.query("SELECT COUNT(cedula) as num FROM persona WHERE cedula = '"+cedula+"'");
        if(Integer.parseInt(res.get(0).get("num")+"") == 0) {
            super.create(cedula, nombres, apellidos, direccion, telefono);
        }
        res = this.con.query("SELECT COUNT(*) as num FROM empresa_proveedor WHERE cedula = '"+cedula+"' AND nit= '"+nit+"';");
        if(Integer.parseInt(res.get(0).get("num")+"") == 0) {
            this.estado = "1";
            this.con.query("INSERT INTO empresa_proveedor (nit, cedula) VALUES ('"+nit+"', '"+cedula+"')");
        }
    }

    private Proveedor(String nit, String razonSocial, String telEmp, String dirEmp, String cedula, String nombres, String apellidos, String direccion, String telefono, String estado) {
        super(cedula, nombres, apellidos, direccion, telefono);
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telEmp = telEmp;
        this.dirEmp = dirEmp;
        this.estado= estado;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public String getNit() {
        return nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTelEmp() {
        return telEmp;
    }

    public String getEstado() {
        return estado;
    }
    
    public static ArrayList<HashMap> getProveedores(){
        Conexion c= new Conexion();
        ArrayList<HashMap> res= c.query("SELECT e.nit, e.razon_social FROM empresa e;");
        if(!res.isEmpty()){
            return res;
        }
        else{
            return null;
        }
    }
    
    public static ArrayList<String[]> getVendedores(String nit){
        Conexion c= new Conexion();
        ArrayList<String[]> ven= new ArrayList<String[]>();
        ArrayList<HashMap> res= c.query("SELECT ep.cedula, p.nombres, p.apellidos"+
                                        " FROM empresa_proveedor ep, persona p WHERE ep.nit='"+nit+
                                        "' AND ep.cedula=p.cedula AND ep.estado=1;");
        if(!res.isEmpty()){
            for (HashMap vdr : res) {
                String[] v= {vdr.get("cedula").toString(),
                             vdr.get("nombres").toString(),
                             vdr.get("apellidos").toString()};
                ven.add(v);
            }
        }
        return ven;
    }
    
    public static AbstractTableModel tablaProv(){
        AbstractTableModel tabla= new AbstractTableModel() {
            private Conexion con;
            private String[] ColumnName={"Nit", "Razón social", "Cédula", "Nombres","Apellidos", "Estado"};
            private Object[][] cons= this.contenido();
            
            private Object[][] contenido(){
                boolean activo= true;
                boolean inactivo= false;
                this.con= new Conexion();
                Object [][] datos;
                ArrayList<HashMap> res= con.query("SELECT ep.nit, e.razon_social, ep.cedula, p.nombres, p.apellidos, ep.estado "+
                                                  "FROM empresa_proveedor ep, empresa e, persona p "+
                                                  "WHERE ep.nit=e.nit AND ep.cedula=p.cedula");
                datos= new Object[res.size()][ColumnName.length];
                int i=0;
                for (HashMap fila : res) {
                    String [] col= {fila.get("nit").toString(), fila.get("razon_social").toString(), fila.get("cedula").toString(),
                                    fila.get("nombres").toString(), fila.get("apellidos").toString(), fila.get("estado").toString()};
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
                return ColumnName.length;
            }
            
            @Override
            public String getColumnName(int columnIndex) {
                // Devuelve el nombre de cada columna. Este texto aparecerá en la
                // cabecera de la tabla.
                switch (columnIndex)
                {
                    case 0:
                        return ColumnName[0];
                    case 1:
                        return ColumnName[1];
                    case 2:
                        return ColumnName[2];
                    case 3:
                        return ColumnName[3];
                    case 4:
                        return ColumnName[4];
                    case 5:
                        return ColumnName[5];
                    default:
                        return null;
                }
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Devuelve la clase que hay en cada columna.
                return this.cons[0][columnIndex].getClass();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return this.cons[rowIndex][columnIndex];
            }
            
            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex){
                if(columnIndex == 5){
                    boolean value= Boolean.parseBoolean(aValue.toString());
                    Proveedor p= Proveedor.proveedor(this.cons[rowIndex][2].toString());
                    String estado= "0";
                    if(value == true){
                        estado= "1";
                    }
                    if(!p.getEstado().equals("1") || value == false){
                        p= Proveedor.existe(this.cons[rowIndex][2].toString(), this.cons[rowIndex][0].toString());
                        p.setEstado(estado);
                        this.cons[rowIndex][columnIndex]= value;
                        // Disparamos el Evento TableDataChanged (La tabla ha cambiado)
                        //fireTableCellUpdated(rowIndex, columnIndex);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "El proveedor debe estar activo solo una vez", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex==5;
            }
        };
        return tabla;
    }

    public void setDirEmp(String dirEmp) {
        this.con.query("UPDATE empresa SET direccion = '"+dirEmp+"' WHERE nit = '"+this.nit+"'");
        this.dirEmp = dirEmp;
    }

    public void setRazonSocial(String razonSocial) {
        this.con.query("UPDATE empresa SET razon_social = '"+razonSocial+"' WHERE nit = '"+this.nit+"'");
        this.razonSocial = razonSocial;
    }

    public void setTelEmp(String telEmp) {
        this.con.query("UPDATE empresa SET telefono = '"+telEmp+"' WHERE nit = '"+this.nit+"'");
        this.telEmp = telEmp;
    }

    public void setEstado(String estado) {
        this.con.query("UPDATE empresa_proveedor SET estado = '"+estado+"' WHERE cedula ='"+this.cedula+"' AND NIT ='"+this.nit+"'");
        this.estado = estado;
    }
    
    public static Proveedor existe (String cedula, String nit) {
        Conexion c = new Conexion();
        ArrayList<HashMap> res = c.query("SELECT p.nombres, p.apellidos, p.direccion, p.telefono, pro.estado, e.nit, e.razon_social, e.direccion as dir_emp, e.telefono as tel_emp FROM empresa e, persona p, empresa_proveedor pro WHERE pro.nit = e.nit AND pro.cedula = p.cedula AND pro.cedula = '"+cedula+"' AND pro.NIT= '"+nit+"'");
        if(!res.isEmpty()) {
            return new Proveedor(res.get(0).get("nit")+"", res.get(0).get("razon_social")+"", res.get(0).get("tel_emp")+"", res.get(0).get("dir_emp")+"", cedula, res.get(0).get("nombres")+"", res.get(0).get("apellidos")+"", res.get(0).get("direccion")+"", res.get(0).get("telefono")+"", res.get(0).get("estado")+"");
        }
        return null;
    }
    
    public static Proveedor proveedor(String cedula){
        Conexion c= new Conexion();
        ArrayList<HashMap> res= c.query("SELECT p.cedula, p.nombres, p.apellidos, p.telefono, p.direccion, e.NIT, e.razon_social, e.telefono AS tel_emp, e.direccion AS dir_emp, ep.estado "+
                                        "FROM persona p "+
                                        "LEFT OUTER JOIN empresa_proveedor AS ep ON p.cedula= ep.cedula "+
                                        "LEFT OUTER JOIN empresa AS e ON ep.NIT= e.NIT "+
                                        "WHERE p.cedula= '"+cedula+"'");
        Proveedor p= null;
        if(!res.isEmpty()){
            for (HashMap pro : res) {
                if(pro.get("estado")!= null){
                    if(!pro.get("estado").equals("0")){
                        p= new Proveedor(pro.get("nit")+"", pro.get("razon_social")+"", pro.get("tel_emp")+"", pro.get("dir_emp")+"", pro.get("cedula")+"", pro.get("nombres")+"", pro.get("apellidos")+"", pro.get("direccion")+"", pro.get("telefono")+"", pro.get("estado")+"");
                        break;
                    }
                    else{
                        p= new Proveedor(pro.get("nit")+"", pro.get("razon_social")+"", pro.get("tel_emp")+"", pro.get("dir_emp")+"", pro.get("cedula")+"", pro.get("nombres")+"", pro.get("apellidos")+"", pro.get("direccion")+"", pro.get("telefono")+"", pro.get("estado")+"");
                    }
                }
                else{
                    p= new Proveedor(pro.get("nit")+"", pro.get("razon_social")+"", pro.get("tel_emp")+"", pro.get("dir_emp")+"", pro.get("cedula")+"", pro.get("nombres")+"", pro.get("apellidos")+"", pro.get("direccion")+"", pro.get("telefono")+"", pro.get("estado")+"");
                }
            }
        }
        return p;
    }
    
    public static String [] getEmpresa(String nit){
        Conexion c= new Conexion();
        ArrayList<HashMap> res= c.query("SELECT * FROM empresa WHERE nit= '"+nit+"'");
        if(!res.isEmpty()){
            String [] empresa= new String [5];
            empresa[0]= res.get(0).get("nit").toString();
            empresa[1]= res.get(0).get("razon_social").toString();
            empresa[2]= res.get(0).get("telefono").toString();
            empresa[3]= res.get(0).get("direccion").toString();
            return empresa;
        }
        else{ return null;}
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nit=" + nit + ", razonSocial=" + razonSocial + ", telEmp=" + telEmp + ", dirEmp=" + dirEmp + ", estado=" + estado + '}';
    }
    
}
