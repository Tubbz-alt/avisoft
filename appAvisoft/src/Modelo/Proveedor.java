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
    
    public static ArrayList<String[]> getProveedores(){
        Conexion c= new Conexion();
        ArrayList<String[]> pro= new ArrayList<String[]>();
        ArrayList<HashMap> res= c.query("SELECT ep.cedula, pn.nombres, pn.apellidos,"+
                                        " ep.nit, e.razon_social FROM empresa_proveedor ep,"+
                                        " persona pn, empresa e WHERE ep.cedula= pn.cedula"+
                                        " AND ep.nit= e.nit AND ep.estado= 1");
        if(!res.isEmpty()){
            for (HashMap prv : res) {
                String[] p= {prv.get("nit").toString(), prv.get("razon_social").toString(),
                             prv.get("cedula").toString(), prv.get("nombres").toString(),
                             prv.get("apellidos").toString()};
                pro.add(p);
            }
        }
        return pro;
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
        this.con.query("UPDATE empresa_proveedor SET estado = '"+estado+"' WHERE cedula ='"+this.cedula+"'");
        this.estado = estado;
    }
    
    @Override
    public void eliminar() {
        this.con.query("DELETE FROM proveedor WHERE nit = '"+this.nit+"' AND cedula = '"+this.cedula+"'");
        this.con.query("DELETE FROM empresa WHERE nit = '"+this.nit+"'");
        super.eliminar();
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Proveedor existe (String cedula) {
        Conexion c = new Conexion();
        ArrayList<HashMap> res = c.query("SELECT p.nombres, p.apellidos, p.direccion, p.telefono, pro.estado, e.nit, e.razon_social, e.direccion as dir_emp, e.telefono as tel_emp FROM empresa e, persona p, empresa_proveedor pro WHERE pro.nit = e.nit AND pro.cedula = p.cedula AND p.cedula = '"+cedula+"'");
        if(!res.isEmpty()) {
            return new Proveedor(res.get(0).get("nit")+"", res.get(0).get("razon_social")+"", res.get(0).get("tel_emp")+"", res.get(0).get("dir_emp")+"", cedula, res.get(0).get("nombres")+"", res.get(0).get("apellidos")+"", res.get(0).get("direccion")+"", res.get(0).get("telefono")+"", res.get(0).get("estado")+"");
        }
        return null;
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
