/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIProveedor.java
 *
 * Created on 21/02/2012, 04:08:45 PM
 */
package Vista;

import Modelo.Proveedor;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class GUIProveedor extends Interfaz {
    private GUIPrincipal p;
    private HashMap proveedores;
    /** Creates new form GUIProveedor */
    public GUIProveedor(GUIPrincipal principal) {
        initComponents();
        this.p= principal;
        this.p.forms.add(this);
        setLocationRelativeTo(null);
        btnConfig.setVisible(false);
    }
    
    private void limpiar(){
        txtNit.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtTlf.setText("");
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDirVendedor.setText("");
        txtTlfVendedor.setText("");
        
        normalizeInput(txtNit);
        normalizeInput(txtRazonSocial);
        normalizeInput(txtDireccion);
        normalizeInput(txtTlf);
        normalizeInput(txtCedula);
        normalizeInput(txtNombres);
        normalizeInput(txtApellidos);
        normalizeInput(txtDirVendedor);
        normalizeInput(txtTlfVendedor);
        
        txtNit.setEditable(true);
        txtCedula.setEditable(true);
        btnAceptar.setText("Guardar");
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png")));
        btnConfig.setVisible(false);
    }
    
    private boolean validarCamposProv(){
        boolean error=false;
        if(txtNit.getText().isEmpty()){
            showError(txtNit, "No se ha digitado el nit \n de la empresa");
            error=true;
        }
        if(txtRazonSocial.getText().isEmpty()){
            showError(txtRazonSocial, "No se ha digitado el nombre \n de la empresa");
            error=true;
        }
        if(txtDireccion.getText().isEmpty()){
            showError(txtDireccion, "No se ha digitado la dirección \n de la empresa");
            error=true;
        }
        if(txtTlf.getText().isEmpty()){
            showError(txtTlf, "No se ha digitado el teléfono \n de la empresa");
            error=true;
        }
        if(txtCedula.getText().isEmpty()){
            showError(txtCedula, "No se ha digitado la cedula \n del vendedor");
            error=true;
        }
        if(txtNombres.getText().isEmpty()){
            showError(txtNombres, "No se ha digitado los nombres \n del vendedor");
            error=true;
        }
        if(txtApellidos.getText().isEmpty()){
            showError(txtApellidos, "No se ha digitado los apellidos \n del vendedor");
            error=true;
        }
        if(txtDirVendedor.getText().isEmpty()){
            showError(txtDirVendedor, "No se ha digitado la dirección \n del vendedor");
            error=true;
        }
        if(txtTlfVendedor.getText().isEmpty()){
            showError(txtTlfVendedor, "No se ha digitado el teléfono \n del vendedor");
            error=true;
        }
        
        if(error) {
            JOptionPane.showMessageDialog(this, "Por favor revise los campos", "Error en el formulario", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
        return !error;
    }
    
    private Proveedor validacion(String ced){
        return Proveedor.proveedor(ced);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDirVendedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTlfVendedor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTlf = new javax.swing.JTextField();
        btnConfig = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear proveedor");
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Proveedor"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Vendedor"));

        jLabel5.setText("Cedula....:");

        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
        });

        jLabel6.setText("Nombres:");

        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel7.setText("Apellidos:");

        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel8.setText("Dirección:");

        txtDirVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirVendedorFocusLost(evt);
            }
        });

        jLabel9.setText("Tlf./Cel...:");

        txtTlfVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTlfVendedorFocusLost(evt);
            }
        });
        txtTlfVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTlfVendedorKeyTyped(evt);
            }
        });

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
                            .addComponent(txtTlfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDirVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTlfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos de la Empresa"));

        jLabel1.setText("NIT...............:");

        txtNit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNitFocusLost(evt);
            }
        });

        jLabel2.setText("Razón Social:");

        txtRazonSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRazonSocialFocusLost(evt);
            }
        });

        jLabel3.setText("Dirección.....:");

        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });

        jLabel4.setText("Tlf. Empresa:");

        txtTlf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTlfFocusLost(evt);
            }
        });
        txtTlf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTlfKeyTyped(evt);
            }
        });

        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/company.png"))); // NOI18N
        btnConfig.setToolTipText("Editar empresa");
        btnConfig.setBorder(null);
        btnConfig.setContentAreaFilled(false);
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(txtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("borrar entradas");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png"))); // NOI18N
        btnAceptar.setText("Guardar");
        btnAceptar.setToolTipText("Guarda empresa y proveedor");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String nit= txtNit.getText().trim();
        String razonSocial= txtRazonSocial.getText().trim();
        String tlfEm= txtTlf.getText().trim();
        String dirEm= txtDireccion.getText().trim();
        String cedula= txtCedula.getText().trim();
        String nombres= txtNombres.getText().trim();
        String apellidos= txtApellidos.getText().trim();
        String dirVen= txtDirVendedor.getText().trim();
        String tlfVen= txtTlfVendedor.getText().trim();
        
        if(!validarCamposProv()){
            return;
        }
        Proveedor pro= validacion(cedula);
        String [] empresa= Proveedor.getEmpresa(nit);
        if(btnAceptar.getText().equals("Guardar")){
            if(empresa == null || empresa[1].equals(razonSocial)){
                new Proveedor(nit, razonSocial, tlfEm, dirEm, cedula,
                                   nombres, apellidos, dirVen, tlfVen, false);
                JOptionPane.showMessageDialog(this, "Exito: Se agrego un nuevo proveedor...");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(this, "El nit ya existe con el nombre de otra empresa", "Advertensia", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            if(pro.getNit().equals(nit)){
                pro.setRazonSocial(razonSocial);
                pro.setDirEmp(dirEm);
                pro.setTelEmp(tlfEm);
                pro.setNombres(nombres);
                pro.setApellidos(apellidos);
                pro.setDireccion(dirVen);
                pro.setTelefono(tlfVen);
            }
            else{
                new Proveedor(nit, razonSocial, tlfEm, dirEm, cedula,
                                  nombres, apellidos, dirVen, tlfVen, false);
            }
            JOptionPane.showMessageDialog(this, "Exito: Se actualizo el proveedor...");
            limpiar();
            }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtTlfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTlfKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtTlfKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtTlfVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTlfVendedorKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtTlfVendedorKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        soloABC(evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        soloABC(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        // TODO add your handling code here:
        // <editor-fold defaultstate="collapsed" desc="Codigo de eliminacion">
        /*  Proveedor pro= (Proveedor) proveedores.get(txtCedula.getText());
            if(pro!=null){
                int confirmado= JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar \n el proveedor?");
                if(JOptionPane.OK_OPTION==confirmado){
                    pro.eliminar();
                    proveedores.remove(txtCedula.getText());
                    JOptionPane.showMessageDialog(this, "Exito: Se elimino el proveedor", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                }
                else JOptionPane.showMessageDialog(this, "Vale... no se eliminará el proveedor", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(this, "No hay ningún proveedor para ser eliminado...");
         * 
         */
        // </editor-fold>
        if(btnAceptar.getText().equals("Actualizar")){            
            txtNit.setEditable(false);
            txtRazonSocial.setEditable(true);
            txtDireccion.setEditable(true);
            txtTlf.setEditable(true);
            txtRazonSocial.requestFocus();
        }
    }//GEN-LAST:event_btnConfigActionPerformed

    private void txtNitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNitFocusLost
        // TODO add your handling code here:
        String [] empresa= Proveedor.getEmpresa(txtNit.getText().trim());
        if(empresa != null){
            txtNit.setText(empresa[0]);
            txtRazonSocial.setText(empresa[1]);
            txtTlf.setText(empresa[2]);
            txtDireccion.setText(empresa[3]);            
        }
        if(!txtNit.getText().isEmpty()){
            normalizeInput(txtNit);
        }
    }//GEN-LAST:event_txtNitFocusLost

    private void txtRazonSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazonSocialFocusLost
        // TODO add your handling code here:
        if(!txtRazonSocial.getText().isEmpty()){
            normalizeInput(txtRazonSocial);
        }
    }//GEN-LAST:event_txtRazonSocialFocusLost

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        // TODO add your handling code here:
        if(!txtDireccion.getText().isEmpty()){
            normalizeInput(txtDireccion);
        }
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtTlfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTlfFocusLost
        // TODO add your handling code here:
        if(!txtTlf.getText().isEmpty() && isPhone(txtTlf.getText())){
            normalizeInput(txtTlf);
        }
    }//GEN-LAST:event_txtTlfFocusLost

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost
        // TODO add your handling code here:
        if(!txtCedula.getText().isEmpty()){
            Proveedor pro= validacion(txtCedula.getText().trim());
            if(pro != null) {
                normalizeInput(txtNit);
                normalizeInput(txtNombres);
                normalizeInput(txtApellidos);
                normalizeInput(txtDirVendedor);
                normalizeInput(txtTlfVendedor);
                normalizeInput(txtNit);
                normalizeInput(txtRazonSocial);
                normalizeInput(txtDireccion);
                normalizeInput(txtTlf);
                
                txtCedula.setText(pro.getCedula());
                txtNombres.setText(pro.getNombres());
                txtApellidos.setText(pro.getApellidos());
                txtDirVendedor.setText(pro.getDireccion());
                txtTlfVendedor.setText(pro.getTelefono());
               
                if(pro.getEstado().equals("1")){
                    txtNit.setText(pro.getNit());
                    txtRazonSocial.setText(pro.getRazonSocial());
                    txtDireccion.setText(pro.getDirEmp());
                    txtTlf.setText(pro.getTelEmp());
                    txtNit.setEditable(false);
                    txtRazonSocial.setEditable(false);
                    txtDireccion.setEditable(false);
                    txtTlf.setEditable(false);
                    btnAceptar.setText("Actualizar");
                    btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Update.png")));
                    btnConfig.setVisible(true);
                }
                
                txtCedula.setEditable(false);
                
            }
            normalizeInput(txtCedula);
        }
    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        // TODO add your handling code here:
        if(!txtNombres.getText().isEmpty()){
            normalizeInput(txtNombres);
        }
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        // TODO add your handling code here:
        if(!txtApellidos.getText().isEmpty()){
            normalizeInput(txtApellidos);
        }
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtDirVendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirVendedorFocusLost
        // TODO add your handling code here:
        if(!txtDirVendedor.getText().isEmpty()){
            normalizeInput(txtDirVendedor);
        }
    }//GEN-LAST:event_txtDirVendedorFocusLost

    private void txtTlfVendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTlfVendedorFocusLost
        // TODO add your handling code here:
        if(!txtTlfVendedor.getText().isEmpty() && isPhone(txtTlfVendedor.getText())){
            normalizeInput(txtTlfVendedor);
        }      
    }//GEN-LAST:event_txtTlfVendedorFocusLost

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== evt.VK_ENTER)
            txtCedula.transferFocus();
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        proveedores= new HashMap();
    }//GEN-LAST:event_formWindowOpened

    @Override
    public java.awt.Image getIconImage(){
        java.awt.Image retValue= java.awt.Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/supplier.png"));
        return retValue;
    }
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDirVendedor;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTlf;
    private javax.swing.JTextField txtTlfVendedor;
    // End of variables declaration//GEN-END:variables
}
