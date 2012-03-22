/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIInsumo.java
 *
 * Created on 23/02/2012, 04:05:54 PM
 */
package Vista;

import Modelo.Insumo;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author zirex
 */
public class GUIInsumo extends Interfaz {
    private HashMap insumos;

    /** Creates new form GUIInsumo */
    public GUIInsumo(GUIPrincipal principal) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.insumos= new HashMap();
    }
    
    private void limpiar(){
        this.txtCodigo.setText(null);
        this.txtNombre.setText(null);
        this.txtTipo.setText(null);
        this.txtCantidad.setText(null);
        this.cmbMedida.setSelectedIndex(0);
        
        this.btnAceptar.setText("Guardar");
        this.btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png")));
        this.txtCodigo.setEditable(true);
        this.txtCantidad.setEditable(true);
        this.txtCodigo.requestFocus();
    }
    
    private boolean validarInsumo(){
        boolean error=false;
        if(txtCodigo.getText().isEmpty()){
            showError(txtCodigo, "No ha digitado ningun código valido");
            error=true;
        }
        
        if(txtNombre.getText().isEmpty()){
            showError(txtNombre, "No le ha colocado un nombre al insumo");
            error=true;
        }
        
        if(txtTipo.getText().isEmpty()){
            showError(txtTipo, "No ha digitado el tipo de insumo");
            error=true;
        }
        
        if(txtCantidad.getText().isEmpty()){
            showError(txtCantidad, "No ha ingresado una cantidad para el insumo");
            error=true;
        }
        
        if(error) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor revise los campos", "Error en el formulario", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
            
        return error;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Insumos");
        setIconImage(getIconImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Tipo:");

        jLabel4.setText("Cantidad:");

        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoFocusLost(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        txtTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoFocusLost(evt);
            }
        });

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info.png"))); // NOI18N
        jLabel6.setToolTipText("Sí ya existe un Insumo, automaticamente se cargara en el sistema");

        cmbMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kg.", "gr.", "mts.", "cms." }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png"))); // NOI18N
        btnAceptar.setText("Guardar");
        btnAceptar.setToolTipText("Guarda y actualiza un insumo");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnAceptar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        //no repitamos tantas funciones si podemos almacenarlas y no usemos to upperCase
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String tipo = txtTipo.getText().trim();
        String cantidad = txtCantidad.getText().trim();
        String medida = cmbMedida.getSelectedItem().toString();
        if(validarInsumo()){
            return;
        }
        if(this.btnAceptar.getText().equals("Guardar")){
            Insumo ins= new Insumo(codigo, nombre, tipo, Integer.parseInt(cantidad), medida);
            JOptionPane.showMessageDialog(null, "Exito: Se registro un nuevo insumo...");
            this.insumos.put(ins.getId(), ins);
            limpiar();
        }
        else{
            Insumo insumo= (Insumo)insumos.get(txtCodigo.getText());
            insumo.setNombre(nombre);
            insumo.setTipo(tipo);
            insumo.setMedida(medida);
            
            JOptionPane.showMessageDialog(null, "Exito: el insumo a sido actualizado...");
            limpiar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
       Insumo aux = (Insumo) this.insumos.get(txtCodigo.getText());
        if(aux!=null){
            int confirmado= JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar \n el insumo?");
            if(JOptionPane.OK_OPTION==confirmado){
                aux.eliminar();
                this.insumos.remove(txtCodigo.getText());
                limpiar();

                JOptionPane.showMessageDialog(null, "Exito: Se elimino el insumo...");
            }
            else{
                JOptionPane.showMessageDialog(null, "Vale!! no borro nada...");
            }
        }
        else
            JOptionPane.showMessageDialog(this, "No hay ningún insumo para eliminar");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusLost
        // TODO add your handling code here:
        if(!txtCodigo.getText().isEmpty())
            normalizeInput(txtCodigo);
        
        Insumo ins = (Insumo) insumos.get(txtCodigo.getText());
        if(ins==null){
            ins= Insumo.existe(txtCodigo.getText().trim());
            if(ins!=null)
            this.insumos.put(ins.getId(), ins);
            }                
        if(ins != null){
            txtNombre.setText(ins.getNombre());
            txtTipo.setText(ins.getTipo());
            txtCantidad.setText(ins.getCantidad()+"");
            cmbMedida.setSelectedItem(ins.getMedida());

            this.txtCodigo.setEditable(false);
            this.txtCantidad.setEditable(false);
            this.btnAceptar.setText("Actualizar");
            this.btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Update.png")));
            }
        
    }//GEN-LAST:event_txtCodigoFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        if(!txtNombre.getText().isEmpty())
            normalizeInput(txtNombre);
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtTipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoFocusLost
        // TODO add your handling code here:
        if(!txtTipo.getText().isEmpty())
            normalizeInput(txtTipo);
    }//GEN-LAST:event_txtTipoFocusLost

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        // TODO add your handling code here:
        if(!txtCantidad.getText().isEmpty())
            normalizeInput(txtCantidad);
    }//GEN-LAST:event_txtCantidadFocusLost

    @Override
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = java.awt.Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/product.png"));
        return retValue;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
