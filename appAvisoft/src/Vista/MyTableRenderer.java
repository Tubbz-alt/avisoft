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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

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
     
     // <editor-fold defaultstate="collapsed" desc="Código para solo un boton">
     /*------------------------BARRA SEPARADORA---------------------------------
    
    public static abstract class AccionBotonCompra implements TableCellEditor, ActionListener{

        public final Icon PREVIEW_ICON = new ImageIcon(getClass().getResource("/Images/preview.png"));
        public final Icon EDIT_ICON= new ImageIcon(getClass().getResource("Images/editFact.png"));
 
        private TableCellEditor editor; 
        private JButton customEditorButton = new JButton(EDIT_ICON);
        private JButton customPreviewButton= new JButton(PREVIEW_ICON);
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
    
    *------------------------BARRA SEPARADORA---------------------------------*
    
    public static class StringActionTableCellEditor extends AccionBotonCompra{ 
        public StringActionTableCellEditor(TableCellEditor editor){ 
            super(editor); 
        } 

        @Override
        protected void editCell(JTable table, int row, int column){
            int value = Integer.parseInt(table.getValueAt(row, 0).toString());
            new IFactCompra().ver_Reporte(value);
        }
    }*/
     //</editor-fold>
     
    /*-------------------------CÓDIGO DOS BOTONES CELDA -----------------------*/
    
    public static class ButtonsPanel extends JPanel {
        public final Icon PREVIEW_ICON= new ImageIcon(getClass().getResource("/Images/preview.png"));
        public final Icon EDIT_ICON= new ImageIcon(getClass().getResource("/Images/editFact.png"));
        public final java.util.List<JButton> buttons = java.util.Arrays.asList(new JButton(EDIT_ICON), new JButton(PREVIEW_ICON));
        public ButtonsPanel() {
            super();
            setOpaque(true);
            for(JButton b: buttons) {
                b.setFocusable(false);
                b.setRolloverEnabled(false);
                add(b);
            }
        }
    }
    
    public static class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {
	    public ButtonsRenderer() {
	        super();
	        setName("Table.cellRenderer");
	    }
	    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
	        return this;
	    }
	}
	/*******************************************/
	public static class ButtonsEditor extends ButtonsPanel implements TableCellEditor {
	    public ButtonsEditor(final JTable table) {
	        super();
	       
	        MouseListener ml = new MouseAdapter() {
	            public void mousePressed(MouseEvent e) {
	                ButtonModel m = ((JButton)e.getSource()).getModel();
	                if(m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
	                    setBackground(table.getBackground());
	                }
	            }
	        };
	        buttons.get(0).addMouseListener(ml);
	      //  buttons.get(0).setIcon(new ImageIcon(getClass().getResource("/iconos/vista-preliminar-del-documento-icono-6420-96.png")));
	        buttons.get(1).addMouseListener(ml);
	       // buttons.get(1).setIcon(new ImageIcon(getClass().getResource("/iconos/icon_edit.png")));
	        //<----

	        buttons.get(0).addActionListener(new ActionListener() {
	            @Override public void actionPerformed(ActionEvent e) {
	                fireEditingStopped();
	                JOptionPane.showMessageDialog(table, "Vista Previa");
	            }
	        });

	        buttons.get(1).addActionListener(new ActionListener() {
	            @Override public void actionPerformed(ActionEvent e) {
	                int row = table.convertRowIndexToModel(table.getEditingRow());
	                int o = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
	                fireEditingStopped();
	                new IFactCompra().ver_Reporte(o);
	            }
	        });

	        addMouseListener(new MouseAdapter() {
	            @Override public void mousePressed(MouseEvent e) {
	                fireEditingStopped();
	            }
	        });
	    }
	    @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        this.setBackground(table.getSelectionBackground());
	        return this;
	    }
	    @Override public Object getCellEditorValue() {
	        return "";
	    }

	    transient protected ChangeEvent changeEvent = null;

	    @Override public boolean isCellEditable(java.util.EventObject e) {
	        return true;
	    } 
	    @Override public boolean shouldSelectCell(java.util.EventObject anEvent) {
	        return true;
	    }
	    @Override public boolean stopCellEditing() {
	        fireEditingStopped();
	        return true;
	    }
	    @Override public void  cancelCellEditing() {
	        fireEditingCanceled();
	    }
	    @Override public void addCellEditorListener(CellEditorListener l) {
	        listenerList.add(CellEditorListener.class, l);
	    }
	    @Override public void removeCellEditorListener(CellEditorListener l) {
	        listenerList.remove(CellEditorListener.class, l);
	    }
	    public CellEditorListener[] getCellEditorListeners() {
	        return listenerList.getListeners(CellEditorListener.class);
	    }
	    protected void fireEditingStopped() {
	      
	        Object[] listeners = listenerList.getListenerList();
	        for(int i = listeners.length-2; i>=0; i-=2) {
	            if(listeners[i]==CellEditorListener.class) {
	              
	                if(changeEvent == null) changeEvent = new ChangeEvent(this);
	                ((CellEditorListener)listeners[i+1]).editingStopped(changeEvent);
	            }
	        }
	    }
	    protected void fireEditingCanceled() {
	        //  devuelve una matriz no nula
	        Object[] listeners = listenerList.getListenerList();
	        // a�ade evnetos y la notificaci�n
	        for(int i = listeners.length-2; i>=0; i-=2) {
	            if(listeners[i]==CellEditorListener.class) {
	                // crea el evento
	                if(changeEvent == null) changeEvent = new ChangeEvent(this);
	                ((CellEditorListener)listeners[i+1]).editingCanceled(changeEvent);
	            }
	        }
	    }
	}
    }