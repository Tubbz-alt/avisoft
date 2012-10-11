/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Reportes.IFactCompra;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author zirex
 */
public class MyTableRenderer {
    
     public static class ImageRenderer extends DefaultTableCellRenderer {
         @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            boolean bool = Boolean.parseBoolean(value.toString());
            Image img = null;
            if(bool) {
                img = getToolkit().getImage(getClass().getResource("/Images/green.png"));
            } else {
                img = getToolkit().getImage(getClass().getResource("/Images/red.png"));
            }
            setSize(16, 16);
            setHorizontalAlignment(SwingConstants.CENTER);
            setIcon(new ImageIcon(img));
            super.getTableCellRendererComponent(table, "", isSelected,
                    hasFocus, row, column);
            return this;
            }        
     }
     
     /*------------------------BARRA SEPARADORA---------------------------------*/
    
    public static abstract class AccionBotonCompra implements TableCellEditor, ActionListener{

        public final Icon PREVIEW_ICON = new ImageIcon(getClass().getResource("/Images/preview.png")); 
 
        private TableCellEditor editor; 
        private JButton customEditorButton = new JButton(PREVIEW_ICON); 

        protected JTable table; 
        protected int row, column; 

        public AccionBotonCompra(TableCellEditor editor){ 
            this.editor = editor; 
            customEditorButton.addActionListener(this); 

            // ui-tweaking 
            customEditorButton.setFocusable(false); 
            customEditorButton.setFocusPainted(false); 
            customEditorButton.setMargin(new Insets(0, 0, 0, 0)); 
        } 

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value
                        , boolean isSelected, int row, int column){ 
            JPanel panel = new JPanel(new BorderLayout()); 
            panel.add(editor.getTableCellEditorComponent(table, value, isSelected, row, column)); 
            panel.add(customEditorButton, BorderLayout.EAST); 
            this.table = table; 
            this.row = row; 
            this.column = column; 
            return panel; 
        } 

        @Override
        public Object getCellEditorValue(){ 
            return editor.getCellEditorValue(); 
        } 

        @Override
        public boolean isCellEditable(EventObject anEvent){ 
            return editor.isCellEditable(anEvent); 
        } 

        @Override
        public boolean shouldSelectCell(EventObject anEvent){ 
            return editor.shouldSelectCell(anEvent); 
        } 

        @Override
        public boolean stopCellEditing(){ 
            return editor.stopCellEditing(); 
        } 

        @Override
        public void cancelCellEditing(){ 
            editor.cancelCellEditing(); 
        } 

        @Override
        public void addCellEditorListener(CellEditorListener l){ 
            editor.addCellEditorListener(l); 
        } 

        @Override
        public void removeCellEditorListener(CellEditorListener l){ 
            editor.removeCellEditorListener(l); 
        } 

        @Override
        public final void actionPerformed(ActionEvent e){ 
            editor.cancelCellEditing(); 
            editCell(table, row, column); 
        } 

        protected abstract void editCell(JTable table, int row, int column);
        
    }
    
    /*------------------------BARRA SEPARADORA---------------------------------*/
    
    public static class StringActionTableCellEditor extends AccionBotonCompra{ 
        public StringActionTableCellEditor(TableCellEditor editor){ 
            super(editor); 
        } 

        @Override
        protected void editCell(JTable table, int row, int column){
            int value = Integer.parseInt(table.getValueAt(row, 0).toString());
            new IFactCompra().ver_Reporte(value);
        }
    }
}

