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

    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
        button.setEnabled(true);
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else{
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        if(value.equals("add")) {
            button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/plus.png")));
            label = "add";
        } else if (value.equals("block")) {
            button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/block.png")));
            button.setEnabled(false);
            label = "block";
        }
        
        isPushed = true;
        javax.swing.table.TableModel model = table.getModel();
        fila = new Object[] {model.getValueAt(row, 0), model.getValueAt(row, 1), model.getValueAt(row, 2)};
        return button;
    }
 
    @Override
    public Object getCellEditorValue() {
        if (isPushed && !label.equals("block"))  {
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