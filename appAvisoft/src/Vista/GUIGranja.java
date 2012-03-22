/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIGranja.java
 *
 * Created on 19/01/2012, 12:32:21 PM
 */
package Vista;

import Modelo.Granja;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kraken
 */
public class GUIGranja extends Interfaz {

    private GUIPrincipal p;
    private ArrayList<String> depar;
    private ArrayList<String[]> muni;
    private javax.swing.table.DefaultTableModel model;
    private int cont;
    private int areaGalpones;
    private HashMap lotes;
    
    /** Creates new form GUIGranja */
    public GUIGranja(GUIPrincipal principal) {
        if(log != null) {
            this.p = principal;
            this.cont = 1;
            this.areaGalpones= 0;
            this.depar = new ArrayList<String>();
            this.muni = new ArrayList<String[]>();
            this.lotes = new HashMap();
            this.p.forms.add(this);
            initComponents();
            this.model = (DefaultTableModel) tblGalpon.getModel();
            cargar();
            javax.swing.table.TableColumn addLote = tblGalpon.getColumn("Agregar Lote");
            addLote.setCellEditor(new ButtonEditor(this));
            addLote.setCellRenderer(new ButtonRenderer());
        } else {
            salir();
        }
    }

    public HashMap getLotes() {
        return lotes;
    }
    
    public int getTipo(){
        return cmbTipo.getSelectedIndex();
    }
    
    public int getClima () {
        return cmbTemp.getSelectedIndex();
    }
    
    public void addLote(java.util.Date fInit, java.util.Date fEnd, int cantInit, String tCriadera, String tBebedero,
            String tComedero, String tVentilador, String cCilindros, String cCriadoras, String cBandejas,
            String cBebederos, String cComederos, String cVentiladores, String cBombillos) {
        int i = tblGalpon.getSelectedRow();
        //Esto se debe validar antes de guardar en memoria que es lo que voy a hacer a continuación
        lotes.put((i+1), new Object[]{fInit, fEnd, cantInit, tCriadera, tBebedero, tComedero, tVentilador, cCilindros,
        cCriadoras, cBandejas, cBebederos, cComederos, cVentiladores, cBombillos});
        ButtonEditor btnEdit = (ButtonEditor) tblGalpon.getCellEditor(i, 3);
        btnEdit.setLabel("block");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblcm = new javax.swing.JLabel();
        txtAreaGalpon = new javax.swing.JTextField();
        cmdAgregarGalpon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDpto = new javax.swing.JTextField();
        txtMpio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbTemp = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbDpto = new com.jidesoft.swing.AutoCompletionComboBox();
        cmbMpio = new com.jidesoft.swing.AutoCompletionComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtProp = new javax.swing.JTextField();
        cmbProp = new com.jidesoft.swing.AutoCompletionComboBox();
        jButton1 = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtArea = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGalpon = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Granja");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel1.setText("Nombre:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Galpon"));

        jLabel7.setText("Area:");

        lblcm.setText("<html> m<sup style='font-size:8px'>2</sup></html>");

        txtAreaGalpon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAreaGalponFocusLost(evt);
            }
        });
        txtAreaGalpon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaGalponKeyTyped(evt);
            }
        });

        cmdAgregarGalpon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/addGalpon.png"))); // NOI18N
        cmdAgregarGalpon.setText("Agregar");
        cmdAgregarGalpon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarGalponActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAreaGalpon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdAgregarGalpon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(txtAreaGalpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblcm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmdAgregarGalpon))
        );

        jLabel2.setText("Dirección:");

        txtDireccion.setMaximumSize(new java.awt.Dimension(6, 20));

        jLabel5.setText("Municipio:");

        jLabel4.setText("Departamento:");

        txtDpto.setEditable(false);
        txtDpto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDptoFocusLost(evt);
            }
        });
        txtDpto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDptoKeyTyped(evt);
            }
        });

        txtMpio.setEditable(false);
        txtMpio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMpioKeyTyped(evt);
            }
        });

        jLabel11.setText("Clima:");

        cmbTemp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija clima", "Calido", "Frio" }));
        cmbTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTempActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/info.png"))); // NOI18N
        jLabel12.setToolTipText("Al cambiar este valor se cambiara en todas las granjas del municipio");

        cmbDpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDptoActionPerformed(evt);
            }
        });

        cmbMpio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMpioActionPerformed(evt);
            }
        });

        jLabel6.setText("Propietario:");

        txtProp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPropKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-user.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija Tipo", "Engorde (Carne)", "Ponedor (Huevo)" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo:");

        jLabel3.setText("Area:");

        txtArea.setMaximumSize(new java.awt.Dimension(6, 20));
        txtArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAreaFocusLost(evt);
            }
        });
        txtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaKeyTyped(evt);
            }
        });

        jLabel10.setText("<html> m<sup style='font-size:8px'>2</sup></html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMpio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDpto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMpio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtProp, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDpto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMpio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMpio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTemp)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        tblGalpon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Area", "Cantidad (Pollos)", "Agregar Lote"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGalpon);
        tblGalpon.getColumnModel().getColumn(2).setMinWidth(150);
        tblGalpon.getColumnModel().getColumn(3).setMinWidth(100);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_1.png"))); // NOI18N
        btnAceptar.setText("Guardar");
        btnAceptar.setToolTipText("Guarda y actualiza un insumo");

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDptoKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtDptoKeyTyped

    private void txtPropKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPropKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtPropKeyTyped

    private void txtMpioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMpioKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtMpioKeyTyped

    private void txtDptoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDptoFocusLost
        // TODO add your handling code here:
        try {
            int cod = Integer.parseInt(txtDpto.getText().trim());
            if(cod>0 && cod<depar.size()) {
                cmbDpto.setSelectedIndex(cod);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Codigo Incorrecto", "ERROR!!", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch(NumberFormatException e) {
            return;
        }
    }//GEN-LAST:event_txtDptoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ModalPropietario(this, true).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbDptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDptoActionPerformed
        // TODO add your handling code here:
        if(cmbDpto.getSelectedIndex() != -1) {
            String dpto = depar.get(cmbDpto.getSelectedIndex());
            txtDpto.setText(dpto);
            ArrayList<String[]> mpios = Granja.getMunicipios(dpto);
            //incializando valores
            cmbMpio.removeAllItems();
            cmbMpio.addItem(null);
            muni = new ArrayList<String[]>();
            muni.add(new String[]{null, "Elija Clima"});
            for(String[] mpio: mpios) {
                cmbMpio.addItem(mpio[1]);
                muni.add(new String[]{mpio[0], mpio[2]});
            }
        } else {
            txtDpto.setText(null);
            cmbMpio.removeAllItems();
        }
    }//GEN-LAST:event_cmbDptoActionPerformed

    private void cmbMpioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMpioActionPerformed
        // TODO add your handling code here:
        if(cmbMpio.getSelectedIndex() != -1) {
            String mpio[] = muni.get(cmbMpio.getSelectedIndex());
            txtMpio.setText(mpio[0]);
            cmbTemp.setSelectedIndex(Integer.parseInt(mpio[1]));
        } else {
            txtMpio.setText(null);
            cmbTemp.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cmbMpioActionPerformed

    private void cmdAgregarGalponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarGalponActionPerformed
        if(txtArea.isEnabled()) {
            if(validarGalpon()) {
                txtArea.setEnabled(false);
                cmbTemp.setEnabled(false);
                cmbTipo.setEnabled(false);
            } else {
                return;
            }
        }
        int area = Integer.parseInt(txtAreaGalpon.getText().trim());
        int resp = (cmbTemp.getSelectedIndex()==1)?area*8:area*10;

        areaGalpones += area;
        if(areaGalpones > Integer.parseInt(txtArea.getText().trim())){
            javax.swing.JOptionPane.showMessageDialog(this, "Has Alcanzado el Limite de Galpones");
            areaGalpones -= area;
            return;
        }
        
        model.addRow(new Object[]{cont++,area, resp, "add"});
    }//GEN-LAST:event_cmdAgregarGalponActionPerformed

    private void cmbTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTempActionPerformed
        // TODO add your handling code here:
        if(cmbTemp.getSelectedIndex() ==0){
            showError(cmbTemp, "No ha Seleccionado Tipo de Clima");
        } else {
            normalizeInput(cmbTemp);
        }
    }//GEN-LAST:event_cmbTempActionPerformed

    private void txtAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAreaFocusLost
        // TODO add your handling code here:
        if(txtArea.getText().trim().isEmpty()) {
            showError(txtArea, "No ha Ingresado Area de la Granja");
        } else {
            normalizeInput(txtArea);
        }
    }//GEN-LAST:event_txtAreaFocusLost

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
        if(cmbTipo.getSelectedIndex()==0){
            showError(cmbTipo, "No ha Seleccionado Tipo de Granja");
        } else {
            normalizeInput(cmbTipo);
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtAreaGalponFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAreaGalponFocusLost
        if(txtAreaGalpon.getText().trim().isEmpty()) {
            showError(txtAreaGalpon, "No ha Ingresado Area de la Granja");
        } else {
            normalizeInput(txtAreaGalpon);
        }
    }//GEN-LAST:event_txtAreaGalponFocusLost

    private void txtAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtAreaKeyTyped

    private void txtAreaGalponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaGalponKeyTyped
        // TODO add your handling code here:
        soloNum(evt);
    }//GEN-LAST:event_txtAreaGalponKeyTyped

    @Override
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = java.awt.Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/farm.png"));
        return retValue;
    }
    
    private boolean validarGalpon() {
        boolean error = false;
        String areaGalpon = txtAreaGalpon.getText().trim();
        String area = txtArea.getText().trim();
        
        if(cmbTipo.getSelectedIndex()==0){
            showError(cmbTipo, "No ha Seleccionado Tipo de Granja");
            error=true;
        }
        if(cmbTemp.getSelectedIndex() == 0){
            showError(cmbTemp, "No ha Seleccionado Tipo de Clima");
            error = true;
        }
        if(area.isEmpty()) {
            showError(txtArea, "No ha Ingresado Area de la Granja");
            error = true;
        } 
        if(areaGalpon.isEmpty()) {
            showError(txtAreaGalpon, "No ha Ingresado Area del Galpon");
            error = true;
        }

        if(!error && Integer.parseInt(area)<Integer.parseInt(areaGalpon)) {
            showError(txtAreaGalpon, "El Tamaño del Galpon Excede el Tamaño de la Granja");
            error = true;
        }
        
        if(error) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor revise los campos", "Error en el formulario", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
        return !error;
    }
    
    private void cargar() {
        ArrayList<String[]> dptos = Granja.getDepartamentos();
        depar.add(null);
        cmbDpto.addItem(null);
        for(String[] dpto: dptos) {
            depar.add(dpto[0]);
            cmbDpto.addItem(dpto[1]);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnLimpiar;
    private com.jidesoft.swing.AutoCompletionComboBox cmbDpto;
    private com.jidesoft.swing.AutoCompletionComboBox cmbMpio;
    private com.jidesoft.swing.AutoCompletionComboBox cmbProp;
    private javax.swing.JComboBox cmbTemp;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JButton cmdAgregarGalpon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcm;
    private javax.swing.JTable tblGalpon;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtAreaGalpon;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDpto;
    private javax.swing.JTextField txtMpio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProp;
    // End of variables declaration//GEN-END:variables
}
