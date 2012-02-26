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
    
    public static ArrayList<String[]> getMunicipios(String dpto) {
        Conexion con = new Conexion();
        ArrayList<String[]> mun = new ArrayList<String[]>();
        ArrayList<HashMap> mpios = con.query("SELECT cod_mun, nombre, clima FROM municipio WHERE cod_dep = '"+dpto+"'");
        for (HashMap mpio: mpios) {
            String m[] = {mpio.get("cod_mun").toString(), mpio.get("nombre").toString(), mpio.get("clima").toString()};
            mun.add(m);
        }
        return mun;
    }
    
    public static ArrayList<String[]> getDepartamentos() {
        Conexion con = new Conexion();
        ArrayList<String[]> dep = new ArrayList<String[]>();
        ArrayList<HashMap> dptos = con.query("SELECT cod, nombre FROM departamento");
        for (HashMap dpto: dptos) {
            String m[] = {dpto.get("cod").toString(), dpto.get("nombre").toString()};
            dep.add(m);
        }
        return dep;
    }
    
}
