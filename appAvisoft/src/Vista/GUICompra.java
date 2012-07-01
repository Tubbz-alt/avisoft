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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author zirex
 */
public class GUICompra extends Interfaz {
    private GUIPrincipal p;
    private ArrayList<String[]> insumos;
    private ArrayList<String[]> proveedores;
    private ModeloTabla model;
    private float totalCompra=0;

    /** Creates new form GUICompra */
    public GUICompra(GUIPrincipal principal) {
        initComponents();
        this.p= principal;
        this.p.forms.add(this);
        this.insumos= new ArrayList<String[]>();
        this.proveedores= new ArrayList<String[]>();
        txtNumFact.setText(Compra.getMaxNumFact());
        setLocationRelativeTo(null);
        cargarInsumos();
        cargarProveedores();
        cargarTabla();
   }
    
    private void cargarTabla(){
        this.model= new ModeloTabla();
        tabla.setModel(model);
        this.model.anhadeItem(new ItemCompra(0, null, 0, 0, 0));
        tabla.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(cmbInsumos));
        KeyStroke enter= KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        tabla.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "richard");
        tabla.getActionMap().put("richard", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        tabla.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent ke) {
                if(model.generarEvento(ke, tabla.getSelectedRow(), tabla.getSelectedColumn())){
                    tabla.changeSelection ( tabla.getRowCount () - 1, 0, false, false );
                }
                else {
                    if (ke.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
                        ke.setKeyCode(java.awt.event.KeyEvent.VK_TAB);//este codigo lo que hace es convertir el enter en tab
                   }
                }
            }

            @Override
            public void keyTyped(KeyEvent ke) {
                if(model.generarEvento(ke, tabla.getSelectedRow(), tabla.getSelectedColumn())){
                    tabla.changeSelection ( tabla.getRowCount () - 1, 0, false, false );
                }
                else {
                    if (ke.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
                        ke.setKeyCode(java.awt.event.KeyEvent.VK_TAB);//este codigo lo que hace es convertir el enter en tab
                   }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if(model.generarEvento(ke, tabla.getSelectedRow(), tabla.getSelectedColumn())){
                    tabla.changeSelection ( tabla.getRowCount () - 1, 0, false, false );
                }
                else {
                    if (ke.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
                        ke.setKeyCode(java.awt.event.KeyEvent.VK_TAB);//este codigo lo que hace es convertir el enter en tab
                   }
                }
            }            
        });
    }
    
    private void cargarInsumos(){
        this.insumos= Insumo.getInsumos();
        for (String[] insumo : insumos){
            cmbInsumos.addItem(insumo[1]);
        }
    }
    
    private void cargarProveedores(){
        this.proveedores= Proveedor.getProveedores();
        for (String[] prv : proveedores) {
            cmbProveedores.addItem(prv[1]+" : "+prv[3]+" : "+prv[4]);
        }
    }
    
    private boolean validarCampos(){
        boolean error=false;
        
        if(txtCantidad.getText().isEmpty()){
            showError(txtCantidad, "No ha ingresado ninguna cantidad.");
            error=true;
        }
        else{
            if(txtCantidad.getText().trim().indexOf(",") > 0 || txtCantidad.getText().trim().indexOf(".")>0){
                showError(txtCantidad, "La cantidad no puede contener decimales.");
                error=true;
            }
            else{
                if(Integer.parseInt(txtCantidad.getText().trim())<= 0){
                    showError(txtCantidad, "La cantidad no puede ser menor a 1");
                    error=true;
                }
            }
        }
        
        if(txtPrecio.getText().isEmpty()){
            showError(txtPrecio, "No ha ingresado ningún precio");
            error=true;
        }
        else{
            if(txtPrecio.getText().trim().indexOf(",")>0){
                showError(txtPrecio, "Para colocar un decimal utiliza la tecla punto");
                error=true;
            }
        }
        return !error;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtExistencia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMedida = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cmbInsumos = new com.jidesoft.swing.AutoCompletionComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbProveedores = new com.jidesoft.swing.AutoCompletionComboBox();
        jLabel9 = new javax.swing.JLabel();
        ccbFecha = new de.wannawork.jcalendar.JCalendarComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNumFact = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jmiEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jmiEliminar.setText("Eliminar fila(s).");
        jmiEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEliminarActionPerformed(evt);
            }
        });
        jpmTabla.add(jmiEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recepción de insumos");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/buy_register.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalle Insumo:"));

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Existencia:");

        txtCodigo.setEditable(false);

        jLabel4.setText("Tipo:");

        txtTipo.setEditable(false);

        txtExistencia.setEditable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingresar:"));

        jLabel5.setText("Medida:");

        jLabel6.setText("Cantidad:");

        txtMedida.setEditable(false);

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });

        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioFocusLost(evt);
            }
        });

        jLabel7.setText("Prc. Unitario");

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ok.png"))); // NOI18N
        btnAgregar.setToolTipText("Agrega un insumo a la compra");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar))
        );

        cmbInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInsumosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbInsumos, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Nombre Ins.", "Cantidad", "Precio Unt.", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false
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
        tabla.getColumnModel().getColumn(0).setMinWidth(30);
        tabla.getColumnModel().getColumn(1).setMinWidth(180);
        tabla.getColumnModel().getColumn(2).setMinWidth(80);
        tabla.getColumnModel().getColumn(3).setMinWidth(90);
        tabla.getColumnModel().getColumn(4).setMinWidth(70);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png"))); // NOI18N
        jButton2.setText("Grabar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la compra"));

        jLabel8.setText("Proveedor:");

        jLabel9.setText("Fecha compra:");

        jLabel10.setText("Total Compra:");

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setText("0");

        jLabel11.setText("Fact. N°:");

        txtNumFact.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ccbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addComponent(ccbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/preview.png"))); // NOI18N
        jButton1.setText("Vista previa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInsumosActionPerformed
        // TODO add your handling code here:
        if(cmbInsumos.getSelectedIndex()!=-1)
            for (String [] insumo : insumos) 
                if(insumo[1].equals(cmbInsumos.getSelectedItem())){
                    txtCodigo.setText(insumo[0]);
                    txtTipo.setText(insumo[2]);
                    txtExistencia.setText(insumo[3]);
                    txtMedida.setText(insumo[4]);
                }
    }//GEN-LAST:event_cmbInsumosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(!validarCampos()){
            return;
        }
        
        String codigo= txtCodigo.getText();
        String nombreInsumo= cmbInsumos.getSelectedItem()+"";
        int cantidadInsumo= Integer.parseInt(txtCantidad.getText().trim());
        float precioInsumo= Float.valueOf(txtPrecio.getText().trim());
        float totalPrecioInsumo= cantidadInsumo*precioInsumo;
        
        ItemCompra item = new ItemCompra (Integer.valueOf(codigo), nombreInsumo, cantidadInsumo, precioInsumo, totalPrecioInsumo);
        
        int aux=0;
        if(this.tabla.getRowCount()!=0){
            for(int i=0; i<this.tabla.getRowCount(); i++){
                String numIns= this.tabla.getValueAt(i, 0).toString();
                if(codigo.equals(numIns)){

                    int nuevaCantidad= Integer.parseInt(this.tabla.getValueAt(i, 2).toString())+cantidadInsumo;
                    totalCompra-= Float.parseFloat(tabla.getValueAt(i, 4).toString());
                    totalPrecioInsumo= nuevaCantidad*Float.valueOf(tabla.getValueAt(i, 3).toString());

                    this.tabla.setValueAt(nuevaCantidad, i, 2);
                    this.tabla.setValueAt(totalPrecioInsumo, i, 4);
                    aux=1;
                    break;
                }
            }
        }
        if(aux==0){
            this.model.anhadeItem(item);
        }
        this.totalCompra+=totalPrecioInsumo;
        this.txtTotalCompra.setText(this.totalCompra+"");
        this.txtCantidad.setText(null);
        this.txtPrecio.setText(null);
        this.txtCantidad.requestFocus();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jmiEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEliminarActionPerformed
        // TODO add your handling code here:
        int filas= tabla.getRowCount();
        for(int i= filas; i> -1; i--){
            if(tabla.isRowSelected(i)){
                totalCompra-= Float.parseFloat(tabla.getValueAt(i, 4).toString());
                this.model.borraItem(i);
            }
        }
        if(filas==tabla.getRowCount()){
            javax.swing.JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún \n item para borrar",
                                                      "Aviso", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        txtTotalCompra.setText(totalCompra+"");
    }//GEN-LAST:event_jmiEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int numFact= Integer.parseInt(txtNumFact.getText());
        java.util.Date fechaFact= ccbFecha.getDate();
        double total=Double.parseDouble(txtTotalCompra.getText());
        String cedula=null;
        Object[][] items = null;
        for(String [] prv: this.proveedores){
            String [] aux= this.cmbProveedores.getSelectedItem().toString().split("[:]");
            if(aux[1].trim().equals(prv[3])){
                cedula= prv[2];
                break;
            }
        }
        if(this.tabla.getRowCount()==0){
            javax.swing.JOptionPane.showMessageDialog(this, "No ha agregado ningún item de insumos", "Advertencia", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            items= new Object[this.tabla.getRowCount()][4];
            for(int i=0; i<this.tabla.getRowCount(); i++){
                items[i][0] = numFact;
                items[i][1] = this.tabla.getValueAt(i, 0);
                items[i][2] = this.tabla.getValueAt(i, 2);
                items[i][3] = this.tabla.getValueAt(i, 3);
            }
            if(cedula!= null){
                new Compra(numFact, fechaFact, total, cedula, items);
                int facturaNueva= JOptionPane.showConfirmDialog(this, "Exito: se ha ingresado una \n nueva orden de compra... \n "+
                                                                "¿Desea crear una nueva factura?", "Aviso", JOptionPane.QUESTION_MESSAGE);
                if(JOptionPane.OK_OPTION==facturaNueva){
                    txtNumFact.setText(Compra.getMaxNumFact());
                    tabla.removeAll();
                }
                else{this.dispose();}
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(this, "Se ha generado un error al crear la factura de compra", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Compra com= Compra.existe(txtNumFact.getText());
        if(com != null){
            new ModalCompra(com).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Aun no se ha creado la factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
        if(txtCantidad.getText().isEmpty()){
            showError(txtCantidad, "No ha ingresado ninguna cantidad.");
        }
        else{
            if(txtCantidad.getText().trim().indexOf(",") > 0 || txtCantidad.getText().trim().indexOf(".")>0){
                showError(txtCantidad, "La cantidad no puede contener decimales.");
            }
            else{
                if(Integer.parseInt(txtCantidad.getText().trim())<= 0){
                    showError(txtCantidad, "La cantidad no puede ser menor a 1");
                }
                else{normalizeInput(txtCantidad);}
            }
        }
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusLost
        // TODO add your handling code here:
        if(txtPrecio.getText().isEmpty()){
            showError(txtPrecio, "No ha ingresado ningún precio");
        }
        else{
            if(txtPrecio.getText().trim().indexOf(",")>0){
                showError(txtPrecio, "Para colocar un decimal utiliza la tecla punto");
            }
            else{normalizeInput(txtPrecio);}
        }
    }//GEN-LAST:event_txtPrecioFocusLost

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private de.wannawork.jcalendar.JCalendarComboBox ccbFecha;
    private com.jidesoft.swing.AutoCompletionComboBox cmbInsumos;
    private com.jidesoft.swing.AutoCompletionComboBox cmbProveedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiEliminar;
    private javax.swing.JPopupMenu jpmTabla;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtNumFact;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
