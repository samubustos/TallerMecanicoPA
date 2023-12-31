/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Sql.CrudMarcaSql;
import Sql.CrudModeloSql;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan Arias
 */
public class ModeloConsultar extends javax.swing.JFrame {

    CrudModeloSql crudModelo = new CrudModeloSql();

    public ModeloConsultar() {
        initComponents();
        this.cargarMarca();
        this.cbmarca.setSelectedItem(null);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbmodelo = new javax.swing.JComboBox<>();
        txtid = new javax.swing.JTextField();
        cbestado = new javax.swing.JComboBox<>();
        txtanio = new javax.swing.JTextField();
        cbmarca = new javax.swing.JComboBox<>();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consultar Modelo");

        jLabel2.setText("Modelo");

        jLabel3.setText("Id");

        jLabel5.setText("Estado");

        jLabel6.setText("Marca");

        jLabel7.setText("año");

        cbmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmodeloActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setEnabled(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbestado.setEnabled(false);

        txtanio.setEnabled(false);
        txtanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanioActionPerformed(evt);
            }
        });

        cbmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmarcaActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.setEnabled(false);
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.setEnabled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnvolver)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtanio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btneditar)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnmodificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnvolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanioActionPerformed

    private void cargarMarca(){
        CrudMarcaSql crud = new CrudMarcaSql();
        crud.cargarNombresMarcas(cbmarca);
    }    
    
    private void cbmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmarcaActionPerformed
        // TODO add your handling code here:
       
        int idMarca = this.crudModelo.buscarIdMarca((String) cbmarca.getSelectedItem());
        cbmodelo.removeAllItems();
        try {
            
            cbmodelo = this.crudModelo.consultarModelo(idMarca,cbmodelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloConsultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbmarcaActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        // TODO add your handling code here:
        ModeloVista vm = new ModeloVista();
        vm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void cbmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmodeloActionPerformed

    }//GEN-LAST:event_cbmodeloActionPerformed

    /**
    * Maneja la acción del botón "Buscar" en la interfaz gráfica. Habilita la edición de los campos
    * de ID, estado y año, así como los botones "Modificar" y "Eliminar". Luego, obtiene el nombre
    * del modelo seleccionado en el JComboBox 'cbmodelo' y utiliza este nombre para consultar y
    * cargar los datos relacionados con el modelo, como el ID, el estado y el año, en los campos de
    * texto correspondientes ('txtid', 'cbestado' y 'txtanio') desde la base de datos utilizando
    * el objeto 'crudModelo' de la clase 'CrudModeloSql'.
    *
    * @param evt El evento de acción que desencadena esta función, como hacer clic en el botón "Buscar".
    */
    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        
        if (cbmarca.getSelectedItem()!=null) {
            this.habilitarCampos();

            String nombre = (String) cbmodelo.getSelectedItem();
            try {
                this.crudModelo.consultarDatos(nombre, txtid, cbestado, txtanio);
            } catch (SQLException ex) {
                Logger.getLogger(ModeloConsultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Por favor seleccione una marca y su correspondiente modelo","Mensaje de Error",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btneditarActionPerformed

    /**
    * Maneja la acción del botón "Modificar" en la interfaz gráfica. Primero, intenta obtener el ID,
    * el estado y el año ingresados en los campos de texto ('txtid', 'cbestado' y 'txtanio').
    * Luego, utiliza estos valores para actualizar el modelo correspondiente en la base de datos
    * utilizando el objeto 'crudModelo' de la clase 'CrudModeloSql'. Si ocurre algún error en la
    * conversión de datos o durante la actualización, se muestra un mensaje de error. Finalmente,
    * se limpian los campos de texto.
    *
    * @param evt El evento de acción que desencadena esta función, como hacer clic en el botón "Modificar".
    */
    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed

        int id = Integer.parseInt(txtid.getText());
        String estadoStr = (String) cbestado.getSelectedItem();
        boolean estado = Boolean.parseBoolean(estadoStr);
        String a=txtanio.getText();
        int anioInt = 0;
        
        

        if (a != null && !a.isEmpty()) {
                anioInt = Integer.parseInt(a); 
                if (anioInt>1900 && anioInt<3000){
                    this.crudModelo.actualizarModelo(id,estado,anioInt);
                    this.limpiarCampos();
                    this.deshabilitarCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Coloque un rango de año valido", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
                }
            
            } else {
                JOptionPane.showMessageDialog(null, "El año es incorrecto", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);

            }
        

    }//GEN-LAST:event_btnmodificarActionPerformed

    /**
    * Maneja la acción del botón "Eliminar" en la interfaz gráfica. Primero, intenta obtener el ID
    * del modelo ingresado en el campo de texto 'txtid'. Luego, utiliza este ID para eliminar el
    * modelo correspondiente en la base de datos utilizando el objeto 'crudModelo' de la clase
    * 'CrudModeloSql'. Si ocurre algún error durante la eliminación, se muestra un mensaje de error.
    * Finalmente, se limpian los campos de texto.
    *
    * @param evt El evento de acción que desencadena esta función, como hacer clic en el botón "Eliminar".
    */
    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int id = Integer.parseInt(txtid.getText());
        this.crudModelo.eliminarModelo(id);
        this.limpiarCampos();
        this.deshabilitarCampos();
    }//GEN-LAST:event_btneliminarActionPerformed

    /**
    * Resetea los campos.
    */
    public void limpiarCampos(){
        cbestado.setSelectedItem(null);
        txtanio.setText("");
        txtid.setText("");
        this.cargarMarca();
        cbmarca.setSelectedItem(null);
        cbmodelo.setSelectedItem(null);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModeloConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModeloConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModeloConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModeloConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModeloConsultar().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JComboBox<String> cbmarca;
    private javax.swing.JComboBox<String> cbmodelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtanio;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    private void habilitarCampos() {
        this.txtid.setEnabled(true);
        this.cbestado.setEnabled(true);
        this.txtanio.setEnabled(true);
        this.btnmodificar.setEnabled(true);
        this.btneliminar.setEnabled(true);
    }
    private void deshabilitarCampos() {
        this.txtid.setEnabled(false);
        this.cbestado.setEnabled(false);
        this.txtanio.setEnabled(false);
        this.btnmodificar.setEnabled(false);
        this.btneliminar.setEnabled(false);
    }
}
