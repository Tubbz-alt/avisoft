/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.ArrayList;

/**
 *
 * @author Kraken
 */
public abstract class Interfaz extends javax.swing.JFrame {
    
    protected Log log;
    protected ArrayList<javax.swing.JFrame> forms;
    
    protected Interfaz() {
        this.log = Log.check();
        this.forms = new ArrayList<javax.swing.JFrame>();
    }
    
    protected void salir() {
        for(javax.swing.JFrame form: forms) {
            form.dispose();
        }
        log.out();
        new GUILogin().setVisible(true);
    }
    
    public static void soloNum(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }
    
    public static void soloABC(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || c == ' ' || c == 8)) {
            evt.consume();
        }
    }
    
}
