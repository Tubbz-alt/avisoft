/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * Hola chicos XD, Esta es la parte que les escuche decir que para que utilizar... ¡muy mal! aprendamos a
 * trabajar con arquitecturas (algun dia me lo agradeceran), dentro del modelo se va a trabajar todo lo
 * que es conexion a la base de datos y nada más. Por su parte en esta capa se "complementa" el trabajo, agregando
 * mayor funcionalidad; por ejemplo aca valido si las cadenas se encentran vacias, si es un email valido,
 * envio emails, etc. Por ultimo la vista se debe encontrar lo más limpia posible (he visto videos en los que no 
 * se programa NADA en la vista, ha exepción de lo que genera NetBeans). Espero medio convencerlos de trabajar 
 * con MVC y dejar de lado el codigo espaguetti que nos enseña Ariza, Pilar, Pastelito... que diga Adarme, etc.
 * 
 * Posdata
 * Si no se han fijado cambie esta clase estatica a una no estatica, pero manejando el patron de diseño SINGLETON
 * un poco modificado.
 */
package Vista;

import Modelo.Usuario;

/**
 *
 * @author Kraken
 */
public class Log {
    private static Log INSTANCE;
    private Usuario user;
    
    private Log(Usuario user) {
        this.user = user;
    }
    
    private synchronized static void createInstance(Usuario user) {
        if (INSTANCE == null) { 
            INSTANCE = new Log(user);
        }
    }
    
    public static Log check() {
        return INSTANCE;
    }
    
    public static String recordarClave(String usuario) {
        if(!usuario.isEmpty()) {
            Usuario suso = Usuario.existe(usuario);
            if(suso != null) {
                String pass = WebUtil.randomString(12);
                if(WebUtil.enviarEmail(suso.getEmail(), "no-reply@mirdware.co.cc", "<h1>Hola "+suso.getUsuario()+"</h1><p>Avisoft ha "
                        + "enviado este correo por que ha sido solicitado dentro de la aplicación."
                        + "</p><p><b>Nueva clave:</b> "+pass+"</p>", "Recordar clave")) {
                    suso.setClave(pass);
                    return "";
                } else {
                    return "No se ha podido enviar el email";
                }
            } else {
                return "Usuario no hallado";
            }
        } else {
            return "El campo usuario se encuentra vacio";
        }
    }
            
    public static String in(String usuario, char[] pass) {
        //validando que no halla una instancia anterior SINGLETON
        if(INSTANCE != null) {
            return "Solo puede existir una session abierta";
        }
        
        if(!usuario.isEmpty() && pass.length != 0) {
            String clave = "";
            for(char str: pass) {
                clave += str;
            }
            Usuario suso = Usuario.existe(usuario, clave);
            if (suso != null) {
                createInstance(suso);
                return "";
            } else {
                return "Ha ocurrido un error al autenticarte";
            }
        } else {
            return "Introduzca su nombre de usuario y contraseña";
        }
    }
    
    public void out() {
        user = null;
        INSTANCE = null;
    }
    
    public String getUser() {
        return user.getUsuario();
    }
    
    public String getEmail() {
        return user.getEmail();
    }
    
    public String set(String email, char[] clave, char[] claver) {
        //validar clave
        if(clave.length != 0) {
            if(clave.length == claver.length) {
                String pass = "";
                for (int i=0, l = clave.length; i<l; i++) {
                    if(clave[i] != claver[i]) {
                        return "Las claves no coinciden";
                    }
                    pass += clave[i];
                }
                user.setClave(pass);
                return "";
            } else {
                return "Las claves no coinciden";
            }
        }
        //validar email
        if(!user.getEmail().equals(email)) {
            if(WebUtil.isEmail(email)) {
                user.setEmail(email);
                return "";
            } else {
                return "email invalido";
            }
        }
        //si no se hacen cambios no se hace nada y se envia ok
        return "No se ha realizado ningun cambio";
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
    }

    @Override
    public String toString() {
        return "Log{" + "user=" + user + '}';
    }
    
}
