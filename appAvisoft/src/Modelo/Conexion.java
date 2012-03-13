//Organizo estas clases en un paquete Controladores, si quieren obvien este paso...
package Modelo;
 
//Estas son clases de java que debemos importar que las usaremos mas adelante...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class Conexion {
    
    private Connection conexion;//atributo de la conección
    private String error;
    
    //Contructor...
    public Conexion() {
        String bd = "avicola";
        String user = "postgres";
        String pass = "mai1991";
        String url = "jdbc:postgresql://localhost:5432/"+bd; //postgres = +bd
        
        try {
            java.lang.Class.forName("org.postgresql.Driver").newInstance();// postgres = 
            this.conexion = DriverManager.getConnection(url,user,pass);
            
            /* Datos del producto, version de mysql, etc. No es necesario por eso esta comentado...
             * DatabaseMetaData meta = (DatabaseMetaData) conexion.getMetaData();
             * System.out.println("El SGBD e s : ");
             * System.out.println(meta.getDatabaseProductName());
             * System.out.println(meta.getDatabaseProductVersion());*/
            
            //System.out.println("Se ha conectado con exito!!!");
            this.error = "";
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            this.error = ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Pequeño método para realizar una consulta
    public ArrayList<HashMap> query(String SQL) {
        SQL = SQL.trim();
        try {
            //   Creamos un tipo Statement que maneja las consultas 
               Statement s = this.conexion.createStatement();
            //   Retorno la consulta especifica...
                if(SQL.toUpperCase().startsWith("SELECT")) {
                    ArrayList<HashMap> res = new ArrayList<HashMap>();
                    ResultSet rs = s.executeQuery(SQL);
                    while(rs.next()) {
                        HashMap map = new HashMap();
                        ResultSetMetaData meta = rs.getMetaData();
                        for (int i=1, l = meta.getColumnCount(); i<=l; i++) {
                            map.put(meta.getColumnLabel(i).toLowerCase(), rs.getString(i));
                        }
                        res.add(map);
                    }
                    return res;
                } else {
                    s.executeUpdate(SQL);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            this.error = ex.getMessage();
        }
        return null;
    }
    
    @Override
    protected void finalize() {
        try {
            super.finalize();
            this.cerrar();
        } catch (Throwable ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Cerramos la conexión previamente abierta...
    public void cerrar() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getError() {
        return error;
    }
    
}