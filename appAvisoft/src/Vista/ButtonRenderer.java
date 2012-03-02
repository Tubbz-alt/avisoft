/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Kraken
 */
public class ButtonRenderer extends javax.swing.JButton implements javax.swing.table.TableCellRenderer {
 
  public ButtonRenderer() {
    setOpaque(true);
  }
  
    @Override
  public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else{
      setForeground(table.getForeground());
      setBackground(javax.swing.UIManager.getColor("Button.background"));
    }
    setText( (value ==null) ? "" : value.toString() );
    return this;
  }
}
