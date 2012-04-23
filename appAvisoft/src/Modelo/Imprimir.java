package Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author zirex
 */
public class Imprimir {
    Font fuente = new Font("Dialog", Font.PLAIN, 10);
//    Font rfcFont = new Font("Arial", Font.BOLD, 8);
//    Font nombreFont = new Font("Arial", Font.BOLD, 6);
//    Font direccioFont = new Font("Arial", Font.BOLD, 6);
    PrintJob pj;
    Graphics pagina;
    static int inc = 110;

    Imprimir() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "PRUEBA", null);
    }

    public void imprimir_Compra(String titulo, String numFact, String vendedor, String
    totalCompra, Object [][] items){

        try{
        pagina = pj.getGraphics();
        pagina.setFont(fuente);
        pagina.setColor(Color.black);
        pagina.drawString(titulo, 200,100);//el 200,100 son las coordenadas en puntos en donde quieres q se dibuje tu registro
        pagina.drawString(numFact, 150, inc+=30);
        pagina.drawString(vendedor, 150, inc+=30);
        for(int i=0; i<items.length; i++){
            pagina.drawString(items[i][0].toString()+"\t"+items[i][1].toString()+
                              "\t"+items[i][2].toString(), 150, inc+=30);
        }
        pagina.drawString(totalCompra, 150, inc+=30);
        pagina.drawString("Guarde su factura!", 150, inc+=30);
        pagina.dispose();
        pj.end();
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Impresión cancelada...", "Aviso",
        JOptionPane.WARNING_MESSAGE);
        }
    }
}
