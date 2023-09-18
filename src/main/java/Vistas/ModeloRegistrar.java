
package Vistas;


import Sql.CrudMarcaSql;
import Sql.CrudModeloSql;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class ModeloRegistrar extends javax.swing.JFrame {

    CrudModeloSql crudModelo = new CrudModeloSql();

    
    public ModeloRegistrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cargarMarca();
        cbmarca.setSelectedItem(null);
        cbestado.setSelectedItem(null);
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
        cbestado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        cbmarca = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtanio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Registrar Modelo");

        jLabel2.setText("Marca");

        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        jLabel4.setText("Nombre");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado");

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        cbmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmarcaActionPerformed(evt);
            }
        });

        jLabel6.setText("Año");

        txtanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnvolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbmarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnregistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(cbestado, 0, 141, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtanio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnregistrar)
                .addGap(25, 25, 25)
                .addComponent(btnvolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        // TODO add your handling code here:
        ModeloVista vm = new ModeloVista();
        vm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    /**
    * Maneja el evento de registro de un nuevo modelo en la base de datos.
    * Cuando se hace clic en el botón "Registrar", este método recopila la información
    * ingresada por el usuario desde los campos de texto y los elementos seleccionados
    * en la interfaz. Luego, realiza validaciones en los datos ingresados, como verificar
    * que el año sea un número válido y que no esté vacío, y que el nombre no esté vacío.
    * Si las validaciones son exitosas, utiliza el objeto 'crudModelo' para registrar el
    * nuevo modelo en la base de datos, incluyendo el nombre, estado, identificador de la marca
    * y el año. En caso de que alguna validación falle, muestra un mensaje de error.
    * 
    * @param evt Evento de acción que desencadena la ejecución del método, en este caso, el clic en el botón "Registrar".
    */
    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
       // TODO add your handling code here:

        String nombre = txtnombre.getText();
        Object estado = cbestado.getSelectedItem();
        String marca = (String) cbmarca.getSelectedItem();
        int id = this.crudModelo.buscarIdMarca(marca);
        String a = txtanio.getText();
        int anioInt = 0; // Inicializamos a 0 por defecto
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        
        if (cbmarca.getSelectedItem()!=null && cbestado.getSelectedItem()!=null) {
            if (a != null && !a.isEmpty()) {
                anioInt = Integer.parseInt(a); 
            
                if (anioInt>1900 && anioInt<anioActual){
                    if (nombre.matches("^[A-Za-z0-9]+$")) {
                        this.crudModelo.registrar(nombre, estado, id, anioInt);
                        this.limpiarCampos();
                    }else {
                        JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras y números, y no debe estar vacío.", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Coloque un rango de año valido", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
                }
            
            } else {
                JOptionPane.showMessageDialog(null, "El año es incorrecto", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor seleccione una marca y un estado", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }





        
        
        
    }//GEN-LAST:event_btnregistrarActionPerformed
    
    /**
    * Carga la lista de nombres de marcas disponibles en la base de datos en un JComboBox.
    * Este método utiliza el objeto 'crud' de la clase 'CrudMarcaSql' para obtener la lista
    * de nombres de marcas almacenados en la base de datos. Luego, los nombres se agregan
    * al JComboBox 'cbmarca', lo que permite al usuario seleccionar una marca desde la lista
    * desplegable en la interfaz gráfica.
    */
    private void cargarMarca(){
        CrudMarcaSql crud = new CrudMarcaSql();
        crud.cargarNombresMarcas(cbmarca);
    }
    private void cbmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmarcaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbmarcaActionPerformed

    private void txtanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtanioActionPerformed

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
            java.util.logging.Logger.getLogger(ModeloRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModeloRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModeloRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModeloRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModeloRegistrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JComboBox<String> cbmarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtanio;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

    private ModeloVista CrudModeloVista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void limpiarCampos() {
        cbmarca.setSelectedItem(null);
        txtnombre.setText("");
        cbestado.setSelectedItem(null);
        txtanio.setText("");
    }
}