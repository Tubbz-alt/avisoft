package Reportes;

import Modelo.Conexion;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class IFactCompra {
    //Se establece la conexion a la base de datos
    private Conexion con= new Conexion();
    private final String logoSena= "/Images/sena.png";
    private final String logoAvisoft= "/Images/logo.png";
    
    public void ver_Reporte(int numFactura){
        JasperReport repor;
        JasperPrint re;
        
        try{
            //Se carga el archivo jasper
            URL in= this.getClass().getResource("facturaCompra.jasper");
            repor= (JasperReport) JRLoader.loadObject(in);
            //Parametros de entrada
            Map<String, Object> parametros= new HashMap<String, Object>();
            parametros.clear();
            parametros.put("numFac", numFactura);
            parametros.put("logoSena", getClass().getResourceAsStream(logoSena));
            parametros.put("logoAvisoft", getClass().getResourceAsStream(logoAvisoft));
            re= JasperFillManager.fillReport(repor, parametros, con.getConnection());
            JasperViewer.viewReport(re, false);
            con.cerrar();
        }
        catch(JRException e){
            
        }
    }
}
