/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Kraken
 */
public class ButtonEditor extends javax.swing.DefaultCellEditor {
    protected javax.swing.JButton button;
    private String    label;
    private boolean   isPushed;
    private javax.swing.JTable tabla;
    private int fila;
    
    public ButtonEditor( ) {
        super(new javax.swing.JCheckBox());
        button = new javax.swing.JButton();
        button.setOpaque(true);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    
    @Override
    public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else{
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value ==null) ? "" : value.toString();
        button.setText( label );
        isPushed = true;
        tabla = table;
        fila = row;
        return button;
    }
 
    @Override
    public Object getCellEditorValue() {
        String cod = tabla.getModel().getValueAt(fila, 0).toString();
        if (isPushed)  {
            System.out.println("Pulsado");
            javax.swing.JOptionPane.showMessageDialog(button ,cod + ": Ouch!");
        }
        isPushed = false;
        return new String( label ) ;
    }
   
    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
 
    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}