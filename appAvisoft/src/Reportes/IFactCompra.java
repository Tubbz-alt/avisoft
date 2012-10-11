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
    //Direccion para la imagen
    private final String logotipo= "/Images/logo.png";
    //Se establece la conexion a la base de datos
    private Conexion con= new Conexion();
    
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
            parametros.put("logo", this.getClass().getResourceAsStream(logotipo));
            parametros.put("numFac", numFactura);
            re= JasperFillManager.fillReport(repor, parametros, con.getConnection());
            JasperViewer.viewReport(re, false);
            con.cerrar();
        }
        catch(JRException e){
            
        }
    }
}
