/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUICompra.java
 *
 * Created on 28/02/2012, 11:24:32 PM
 */
package Vista;

import Modelo.Compra;
import Modelo.Insumo;
import Modelo.Proveedor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author zirex
 */
public class GUICompra extends Interfaz {
    private GUIPrincipal p;
    private ArrayList<String[]> insumos;
    private ArrayList<HashMap> proveedores;
    private ArrayList<String[]> vendedores;
    private ModeloTabla model;
    private Compra compra;

    /** Creates new form GUICompra */
    public GUICompra(GUIPrincipal principal) {
        initComponents();
        this.p= principal;
        this.p.forms.add(this);
        txtNumFact.setText(Compra.getMaxNumFact());
        setLocationRelativeTo(null);
        cargarInsumos();
        cargarProveedores();
        cargarTabla();
   }
    
    public GUICompra(GUIConsInv padre, int numFact){
        initComponents();
        this.p= padre.getPadre();
        this.p.forms.add(this);
        cargarInsumos();
        cargarProveedores();
        btnGuardar.setText("Actualizar");
        btnGuardar.setIcon(new ImageIcon(getClass().getResource("/Images/Update.png")));
        //Carga la factura de la consulta para editarla
        compra = Compra.existe(numFact);
        txtNumFact.setText(String.valueOf(compra.getNumFact()));
        cmbNIT.setSelectedItem(compra.getNit());
        cmbCedulaVen.setSelectedItem(compra.getCedula());
        txtTotalCompra.setText(compra.getTotal()+"");
        cargarTabla();
        ccbFecha.setDate(compra.getFecha());
        
        setLocationRelativeTo(null);
    }
    
    private void setAnchoColumnas(){
        JViewport scroll =  (JViewport) tabla.getParent();
        int ancho = scroll.getWidth();
        int anchoColumna=0;
        TableColumnModel modeloColumna = tabla.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            switch(i){
                case 0: anchoColumna = (13*ancho)/100;
                        break;
                case 1: anchoColumna = (90*ancho)/100;
                        break;
                case 2: anchoColumna = (35*ancho)/100;
                        break;
                case 3: anchoColumna = (40*ancho)/100;
                        break;
                case 4: anchoColumna = (40*ancho)/100;
                        break;
            }                     
            columnaTabla.setPreferredWidth(anchoColumna);           
        }
    }
    
    private void inicializarTabla(){
        this.model= new ModeloTabla(txtTotalCompra);
        tabla.setModel(model);
        tabla.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cmbInsumos));
        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        InputMap im = tabla.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        im.put(enter, im.get(tab));
        tabla.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (model.rowAdd) {
                    tabla.changeSelection ( tabla.getRowCount () - 1, 0, false, false );
                    model.rowAdd = false;
                }
            }
        });
        this.setAnchoColumnas();
    }
    
    private void cargarTabla(){
        this.inicializarTabla();
        if(compra == null){
            this.model.anhadeItem(new ItemCompra(0, null, 0, 0, 0));
        }
        else{
            ArrayList<ItemCompra> items= compra.getItemsCompra();
            for(ItemCompra item: items){
                this.model.anhadeItem(item);
            }
        }
    }    
    
    private void cargarInsumos(){
        this.insumos= Insumo.getInsumos();
        for (String[] insumo : insumos){
            cmbInsumos.addItem(insumo[0]+": "+insumo[1]);
        }
    }
    
    private void cargarProveedores(){
        this.proveedores= new ArrayList<HashMap>();
        this.proveedores= Proveedor.getProveedores();
        cmbProveedores.addItem(null);
        cmbNIT.addItem(null);
        if(this.proveedores != null){
            for(HashMap prd: this.proveedores){
                this.cmbProveedores.addItem(prd.get("razon_social"));
                cmbNIT.addItem(prd.get("nit"));
            }
        }
    }
    
    private void cargarVendedor(String nit){
        this.vendedores= Proveedor.getVendedores(nit);
        int i = 0;
        int size = this.vendedores.size();
        String[] vndrs= new String[size+1];
        String[] cedulas = new String[size+1];
        vndrs[0]= null;
        while(i<size){
            String [] vdr= this.vendedores.get(i);
            i++;
            vndrs[i]= vdr[1]+" "+vdr[2];
            cedulas[i] = vdr[0];
        }
        this.cmbVendedor.setModel( new javax.swing.DefaultComboBoxModel(vndrs) );
        this.cmbCedulaVen.setModel( new javax.swing.DefaultComboBoxModel(cedulas) );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpmTabla = new javax.swing.JPopupMenu();
        jmiEliminar = new javax.swing.JMenuItem();
        cmbInsumos = new com.jidesoft.swing.AutoCompletionComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(){
            //http://marciosouzajunior.blogspot.com/2012/06/jtable-selecionar-todo-texto-quando.html
            // Selecionar o conteúdo da célula quando editar
            /*public void changeSelection(int row, int column, boolean toggle, boolean extend)
            {
                super.changeSelection(row, column, toggle, extend);

                if (editCellAt(row, column))
                {
                    Component editor = getEditorComponent();
                    editor.requestFocusInWindow();

                    if (editor instanceof JTextComponent){
                        ((JTextComponent) editor).selectAll();
                    }
                }
            }
            */
            @Override
            public boolean editCellAt(int row, int column, EventObject e)
            {
                boolean result = super.editCellAt(row, column, e);

                selectAll(e);

                return result;
            }

            /*
            * Select the text when editing on a text related cell is started
            */
            private void selectAll(EventObject e)
            {
                final Component editor = getEditorComponent();

                if (editor == null
                    || ! (editor instanceof JTextComponent))
                return;

                if (e == null)
                {
                    ((JTextComponent)editor).selectAll();
                    return;
                }

                //  Typing in the cell was used to activate the editor

                if (e instanceof KeyEvent)
                {
                    ((JTextComponent)editor).selectAll();
                    return;
                }

                //  F2 was used to activate the editor

                if (e instanceof ActionEvent)
                {
                    ((JTextComponent)editor).selectAll();
                    return;
                }

                //  A mouse click was used to activate the editor.
                //  Generally this is a double click and the second mouse click is
                //  passed to the editor which would remove the text selection unless
                //  we use the invokeLater()

                if (e instanceof MouseEvent)
                {
                    SwingUtilities.invokeLater(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                ((JTextComponent)editor).selectAll();
                            }
                        });
                    }
                }
            }
            ;
            btnGuardar = new javax.swing.JButton();
            jPanel3 = new javax.swing.JPanel();
            jLabel8 = new javax.swing.JLabel();
            cmbProveedores = new com.jidesoft.swing.AutoCompletionComboBox();
            jLabel9 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            txtNumFact = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            cmbNIT = new com.jidesoft.swing.AutoCompletionComboBox();
            cmbCedulaVen = new com.jidesoft.swing.AutoCompletionComboBox();
            cmbVendedor = new com.jidesoft.swing.AutoCompletionComboBox();
            ccbFecha = new com.toedter.calendar.JDateChooser();
            txtTotalCompra = new javax.swing.JTextField();
            jLabel10 = new javax.swing.JLabel();

            jmiEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
            jmiEliminar.setText("Eliminar fila(s).");
            jmiEliminar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jmiEliminarActionPerformed(evt);
                }
            });
            jpmTabla.add(jmiEliminar);

            cmbInsumos.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmbInsumosActionPerformed(evt);
                }
            });

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Recepción de insumos");
            setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/buy_register.png")).getImage());
            setResizable(false);

            tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Id", "Nombre Ins.", "Cantidad", "Precio Unit.", "Total"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
                };
                boolean[] canEdit = new boolean [] {
                    false, true, true, true, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tabla.setComponentPopupMenu(jpmTabla);
            tabla.getTableHeader().setReorderingAllowed(false);
            jScrollPane1.setViewportView(tabla);
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(8);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(130);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(40);
            tabla.getColumnModel().getColumn(3).setResizable(false);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(4).setResizable(false);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(25);

            btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png"))); // NOI18N
            btnGuardar.setText("Grabar");
            btnGuardar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnGuardarActionPerformed(evt);
                }
            });

            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la compra"));

            jLabel8.setText("Proveedor:");

            cmbProveedores.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    actualizarVendedor(evt);
                }
            });

            jLabel9.setText("Fecha compra:");

            jLabel11.setText("Fact. N°:");

            txtNumFact.setEditable(false);

            jLabel1.setText("Vendedor:");

            cmbNIT.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    cmbNITItemStateChanged(evt);
                }
            });

            cmbCedulaVen.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    cmbCedulaVenItemStateChanged(evt);
                }
            });

            cmbVendedor.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    cmbVendedorItemStateChanged(evt);
                }
            });

            ccbFecha.setDate(new java.util.Date());

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbNIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(ccbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(cmbCedulaVen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ccbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmbCedulaVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            );

            txtTotalCompra.setEditable(false);
            txtTotalCompra.setText("0");

            jLabel10.setText("Total Compra:");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addGap(6, 6, 6)
                            .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnGuardar)
                                .addComponent(jLabel10))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jmiEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarActionPerformed
        // TODO add your handling code here:
        int filas= tabla.getRowCount()-1;
        this.model.borraItem(tabla.getSelectedRow());
        if(filas<tabla.getRowCount()){
            javax.swing.JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún \n item para borrar",
                                                      "Aviso", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        if(tabla.getRowCount() == 0){
            this.model.anhadeItem(new ItemCompra(0, null, 0, 0, 0));
        }
    }//GEN-LAST:event_jmiEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        int numFact= Integer.parseInt(txtNumFact.getText());
        double totalCompra = Double.valueOf(txtTotalCompra.getText());
        java.util.Date fechaFact= ccbFecha.getDate();
        String cedula=cmbCedulaVen.getSelectedItem().toString();
        ArrayList<ItemCompra> items = new ArrayList<ItemCompra>();
        
        if(totalCompra == 0){
            javax.swing.JOptionPane.showMessageDialog(this, "No ha agregado ningún item de insumos", "Advertencia", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            for(int i=0; i<this.tabla.getRowCount(); i++){
                if(!this.tabla.getValueAt(i, 4).toString().equals("0.0")){
                    ItemCompra item = new ItemCompra();
                    item.setId(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                    item.setNombre(tabla.getValueAt(i, 1).toString());
                    item.setCantidad(Integer.parseInt(tabla.getValueAt(i, 2).toString()));
                    item.setPrecioUnt(Float.parseFloat(tabla.getValueAt(i, 3).toString()));
                    item.setTotal(Float.parseFloat(tabla.getValueAt(i, 4).toString()));
                    items.add(item);
                }
            }
            if(!cedula.equals("") && btnGuardar.getText().equals("Grabar")){
                Compra.create(numFact, fechaFact, totalCompra, cedula, cmbNIT.getSelectedItem().toString(), items);
                int facturaNueva= JOptionPane.showConfirmDialog(this, "Exito: se ha ingresado una \n nueva orden de compra... \n "+
                                                                "¿Desea crear una nueva factura?");
                if(JOptionPane.OK_OPTION==facturaNueva){
                    txtNumFact.setText(Compra.getMaxNumFact());
                    tabla.removeAll();
                }
                else{this.dispose();}
            }
            else{
                if(!cedula.equals("") && btnGuardar.getText().equals("Actualizar")){
                    if(!compra.getCedula().equals(cedula)){
                        compra.setCedula(cedula);
                    }
                    if(!compra.getFecha().equals(fechaFact)){
                        compra.setFechaFact(fechaFact);
                    }
                    if(compra.getTotal() != totalCompra){
                        compra.setTotal(totalCompra);
                        compra.setItemsCompra(compra.getNumFact());
                    }
                    if(!compra.getNit().equals(cmbNIT.getSelectedItem())){
                        compra.setNit(cmbNIT.getSelectedItem().toString());
                    }
                    JOptionPane.showMessageDialog(this, "Exito... Se guardaron las modificaciones", "Actualización", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                else{
                    javax.swing.JOptionPane.showMessageDialog(this, "Se ha generado un error al crear la factura de compra", "Error", 
                                                              javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void actualizarVendedor(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actualizarVendedor
        String nit = null;
        int index = cmbProveedores.getSelectedIndex();
        if(this.proveedores != null && cmbProveedores.getSelectedItem() != null){
            nit = proveedores.get(cmbProveedores.getSelectedIndex()-1).get("nit").toString();
        }
        if (cmbNIT.getSelectedIndex() != index) {
            cmbNIT.setSelectedIndex(index);
        }
        this.cargarVendedor(nit);
    }//GEN-LAST:event_actualizarVendedor

    private void cmbNITItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNITItemStateChanged
        // TODO add your handling code here:
        int index = cmbNIT.getSelectedIndex();
        if (cmbProveedores.getSelectedIndex() != index) {
            cmbProveedores.setSelectedIndex(index);
        }
    }//GEN-LAST:event_cmbNITItemStateChanged

    private void cmbCedulaVenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCedulaVenItemStateChanged
        // TODO add your handling code here:
        int index = cmbCedulaVen.getSelectedIndex();
        if (cmbVendedor.getSelectedIndex() != index) {
            cmbVendedor.setSelectedIndex(index);
        }
    }//GEN-LAST:event_cmbCedulaVenItemStateChanged

    private void cmbVendedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVendedorItemStateChanged
        // TODO add your handling code here:
        int index = cmbVendedor.getSelectedIndex();
        if (cmbCedulaVen.getSelectedIndex() != index) {
            cmbCedulaVen.setSelectedIndex(index);
        }
    }//GEN-LAST:event_cmbVendedorItemStateChanged

    private void cmbInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInsumosActionPerformed
        // TODO add your handling code here:
        if (tabla.getRowCount() != 0) {
            int index = cmbInsumos.getSelectedIndex();
            if (index != -1) {
                tabla.setValueAt(insumos.get(index)[0], model.getLastRow(), 0);
            }
        }
    }//GEN-LAST:event_cmbInsumosActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private com.toedter.calendar.JDateChooser ccbFecha;
    private com.jidesoft.swing.AutoCompletionComboBox cmbCedulaVen;
    private com.jidesoft.swing.AutoCompletionComboBox cmbInsumos;
    private com.jidesoft.swing.AutoCompletionComboBox cmbNIT;
    private com.jidesoft.swing.AutoCompletionComboBox cmbProveedores;
    private com.jidesoft.swing.AutoCompletionComboBox cmbVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiEliminar;
    private javax.swing.JPopupMenu jpmTabla;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNumFact;
    private javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
