/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModalBugs.java
 *
 * Created on 13/03/2012, 03:08:09 PM
 */
package Vista;

/**
 *
 * @author Kraken
 */
public class ModalBugs extends javax.swing.JDialog {

    private Log log;
    /** Creates new form ModalBugs */
    public ModalBugs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.log = Log.check();
        if(log != null) {
            initComponents();
            txtVersion.setText("0.1");
            setLocationRelativeTo(null);
        }
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
        cmbModulo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtVersion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbAccion = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        cmdConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Error Encontrado");

        jLabel1.setText("Modulo:");

        cmbModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Principal", "Financiero" }));
        cmbModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModuloActionPerformed(evt);
            }
        });

        jLabel2.setText("Versión:");

        txtVersion.setEditable(false);

        jLabel3.setText("Acción:");

        cmbAccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Iniciar/Finalizar Sessión", "Reportar Bug", "Crear Granja", "Adicionar Lote" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Problema"));

        jLabel4.setText("Titulo:");

        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTituloFocusLost(evt);
            }
        });

        jLabel5.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bug.png"))); // NOI18N
        cmdConfirm.setText("Confirmar Error");
        cmdConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmdConfirm, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdConfirm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModuloActionPerformed
        // TODO add your handling code here:
        
        switch (cmbModulo.getSelectedIndex()) {
            case 0:
                cmbAccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Iniciar/Finalizar Sessión", "Reportar Bug", "Crear Granja", "Adicionar Lote" }));
                break;
            case 1:
                cmbAccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Modificar Proveedor", "Ingresar Proveedor", "Ingresar insumo", "Modificar Insumo" }));
                break;
        }
    }//GEN-LAST:event_cmbModuloActionPerformed

    private void cmdConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdConfirmActionPerformed
        // TODO add your handling code here:
        Interfaz.normalizeInput(txtTitulo);
        Interfaz.normalizeInput(txtDescripcion);
        String version = txtVersion.getText();
        String modulo = cmbModulo.getSelectedItem().toString();
        String accion = cmbAccion.getSelectedItem().toString();
        String titulo = txtTitulo.getText();
        String descripcion = txtDescripcion.getText();
        boolean error = false;
        
        if(titulo.isEmpty()) {
            Interfaz.showError(txtTitulo, "Campo obligatorio");
            error = true;
        }
        if(descripcion.isEmpty()) {
            Interfaz.showError(txtDescripcion, "Campo obligatorio");
            error = true;
        }
        if(error) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor revise los campos", "Error en el formulario", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(WebUtil.enviarEmail("mirdware@gmail.com", this.log.getEmail(),
                "<b>Usuario:</b>"+log.getUser()+
                "<br/><b>Versión:</b>"+version+
                "<br/><b>Modulo:</b>"+modulo+
                "<br/><b>Modulo:</b>"+accion+
                "<br/><b>Problema:</b><br/>"+descripcion,
                "Reporte de error: "+titulo)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Se ha enviado el reporte exitosamente", "Error en el formulario", javax.swing.JOptionPane.PLAIN_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/Images/email.png")));
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se ha podido enviar el reporte", "Error en el formulario", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_cmdConfirmActionPerformed

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        // TODO add your handling code here:
        if(txtTitulo.getText().isEmpty()) {
            Interfaz.showError(txtTitulo, "No ha Ingresado Area del Galpon");
        } else {
            Interfaz.normalizeInput(txtTitulo);
        }
    }//GEN-LAST:event_txtTituloFocusLost

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        // TODO add your handling code here:
        if(txtDescripcion.getText().isEmpty()) {
            Interfaz.showError(txtDescripcion, "No ha Ingresado Area del Galpon");
        } else {
            Interfaz.normalizeInput(txtDescripcion);
        }
    }//GEN-LAST:event_txtDescripcionFocusLost

    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbAccion;
    private javax.swing.JComboBox cmbModulo;
    private javax.swing.JButton cmdConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtVersion;
    // End of variables declaration//GEN-END:variables
}
