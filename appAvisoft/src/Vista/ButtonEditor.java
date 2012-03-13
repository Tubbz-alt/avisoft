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
    private Object[] fila;
    private GUIGranja g;
    
    public ButtonEditor( GUIGranja parent ) {
        super(new javax.swing.JCheckBox());
        this.g = parent;
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
        fila = new Object[3];
        for(short i=0; i<3; i++) {
            fila[i] = table.getModel().getValueAt(row, i);
        }
        return button;
    }
 
    @Override
    public Object getCellEditorValue() {
        if (isPushed)  {
            new ModalLote(this.g, true, fila).setVisible(true);
        }
        isPushed = false;
        return label ;
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