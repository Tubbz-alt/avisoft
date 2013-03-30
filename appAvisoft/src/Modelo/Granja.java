/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Kraken
 */
public class Granja {

    protected Conexion con;
    protected String nombre, direccion, user;
    protected int propietario, departamento, municipio;
    protected char clima, tipo;
    protected double area;

    public Granja(String nombre, String direccion, int propietario, int departamento, int municipio, char clima, char tipo, double area, String user) {
        this.con = new Conexion();
        ArrayList<HashMap> res = this.con.query("SELECT nombre, direccion, tipo, area, usuario, cod_mun, cod_dep, ced_propietario, clima FROM granja WHERE nombre ='" + nombre + "'");
        if (res.isEmpty()) {
            this.con.query("INSERT INTO persona (nombre, direccion, tipo, area, usuario, cod_mun, cod_dep, ced_propietario, clima) VALUES('" + nombre + "', '" + direccion + "', '" + tipo + "', '" + area + "', '" + user + "', '" + municipio + "', '" + departamento + "', '" + propietario + "', '" + clima + "')");
            this.nombre = nombre;
            this.direccion = direccion;
            this.area = area;
            this.user = user;
            this.propietario = propietario;
            this.departamento = departamento;
            this.municipio = municipio;
            this.clima = clima;
            this.tipo = tipo;
        } else {
            this.nombre = res.get(0).get("nombre").toString();
            this.direccion = res.get(0).get("direccion").toString();
            this.area = Double.parseDouble(res.get(0).get("area").toString());
            this.user = res.get(0).get("usuario").toString();
            this.propietario = Integer.parseInt(res.get(0).get("ced_propietario").toString());
            this.departamento = Integer.parseInt(res.get(0).get("cod_dep").toString());
            this.municipio = Integer.parseInt(res.get(0).get("cod_mun").toString());
            this.clima = res.get(0).get("clima").toString().charAt(0);
            this.tipo = res.get(0).get("tipo").toString().charAt(0);
        }
    }

    public Granja(Conexion con, String nombre, String direccion, int propietario, int departamento, int municipio, char clima, char tipo, double area, String user) {
        this.con = con;
        this.nombre = nombre;
        this.direccion = direccion;
        this.propietario = propietario;
        this.departamento = departamento;
        this.municipio = municipio;
        this.clima = clima;
        this.tipo = tipo;
        this.area = area;
        this.user = user;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.con.query("UPDATE granja SET area='" + area + "' WHERE nombre='" + this.nombre + "';");
        this.area = area;
    }

    public char getClima() {
        return clima;
    }

    public void setClima(char clima) {
        this.con.query("UPDATE granja SET clima='" + clima + "' WHERE nombre='" + this.nombre + "';");
        this.clima = clima;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.con.query("UPDATE granja SET cod_dep='" + departamento + "' WHERE nombre='" + this.nombre + "';");
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.con.query("UPDATE granja SET direccion='" + direccion + "' WHERE nombre='" + this.nombre + "';");
        this.direccion = direccion;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.con.query("UPDATE granja SET cod_mun='" + municipio + "' WHERE nombre='" + this.nombre + "';");
        this.municipio = municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.con.query("UPDATE granja SET nombre='" + nombre + "' WHERE nombre='" + this.nombre + "';");
        this.nombre = nombre;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.con.query("UPDATE granja SET ced_propietario='" + propietario + "' WHERE nombre='" + this.nombre + "';");
        this.propietario = propietario;
    }

    public static ArrayList<String[]> getMunicipios(String dpto) {
        Conexion con = new Conexion();
        ArrayList<String[]> mun = new ArrayList<String[]>();
        ArrayList<HashMap> mpios = con.query("SELECT cod_mun, nombre, clima FROM municipio WHERE cod_dep = '" + dpto + "'");
        for (HashMap mpio : mpios) {
            String m[] = {mpio.get("cod_mun").toString(), mpio.get("nombre").toString(), mpio.get("clima").toString()};
            mun.add(m);
        }
        return mun;
    }

    public static ArrayList<String[]> getDepartamentos() {
        Conexion con = new Conexion();
        ArrayList<String[]> dep = new ArrayList<String[]>();
        ArrayList<HashMap> dptos = con.query("SELECT cod, nombre FROM departamento");
        for (HashMap dpto : dptos) {
            String m[] = {dpto.get("cod").toString(), dpto.get("nombre").toString()};
            dep.add(m);
        }
        return dep;
    }
    
    public static ArrayList<String[]> getPropietarios() {
        Conexion con = new Conexion();
        ArrayList<String[]> res = new ArrayList<String[]>();
        ArrayList<HashMap> props = con.query("SELECT cedula, nombres, apellidos FROM persona WHERE prop = '1'");
        for (HashMap prop : props) {
            String p[] = {prop.get("cedula")+"", prop.get("nombres")+"", prop.get("apellidos")+""};
            res.add(p);
        }
        return res;
    }
    
}
