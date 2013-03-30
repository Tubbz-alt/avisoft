/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;

/**
 *
 * @author Kraken
 */
public class ButtonRenderer extends javax.swing.JButton implements javax.swing.table.TableCellRenderer {
    
  public ButtonRenderer() {
      setOpaque(true);
  }
  
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
              setForeground(table.getSelectionForeground());
              setBackground(table.getSelectionBackground());
        } else{
              setForeground(table.getForeground());
              setBackground(javax.swing.UIManager.getColor("Button.background"));
        }
        setEnabled(true);
        setContentAreaFilled(false);
        if(value.equals("add")) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png")));
            setToolTipText("Agregar lote");
        } else if (value.equals("block")) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/block.png")));
            setEnabled(false);
        }
        return this;
  }
    
}
