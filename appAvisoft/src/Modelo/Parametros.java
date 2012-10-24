/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author Kraken
 */
public class Parametros {
    private static Parametros INSTANCE;
    private static String email;
    private static String passwordEmail;
    
    private Parametros () {
        Conexion conexion = new Conexion ();
        HashMap res = conexion.query("SELECT email, clave_email FROM parametros").get(0);
        email = res.get("email").toString();
        passwordEmail = res.get("clave_email").toString();
        try {
            Cipher encrypt = Cipher.getInstance("DES");
            KeySpec ks = new DESKeySpec("projectSena".getBytes("UTF8"));
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey ky = kf.generateSecret(ks);
            encrypt.init(Cipher.DECRYPT_MODE, ky);
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(passwordEmail);
            passwordEmail = new String( encrypt.doFinal(dec), "UTF8" );
        } catch (Exception ex) {
            Logger.getLogger(Parametros.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Parametros();
        }
    }
    
    public static String getEmail () {
        createInstance();
        return email;
    }
    
    public static String getPasswordEmail () {
        createInstance();
        return passwordEmail;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
    }
    
}
