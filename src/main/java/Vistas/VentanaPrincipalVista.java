
package Vistas;

/**
 * Clase principal que contiene el metodo main por el cual comieza a correr nuestro proyecto.
 */

public class VentanaPrincipalVista extends javax.swing.JFrame {

    /**
     * Contructor de la clase donde iniciamos los componentes generados
     * en el diseño de la clase, y configuramos aspectos varios sobre esta.
     */
    public VentanaPrincipalVista() {
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnmarca = new javax.swing.JButton();
        btnmodelo = new javax.swing.JButton();
        btnvehiculo = new javax.swing.JButton();
        btntecnico = new javax.swing.JButton();
        btncliente = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("CRUD TALLER");

        btnmarca.setText("Marca");
        btnmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmarcaActionPerformed(evt);
            }
        });

        btnmodelo.setText("Modelo");
        btnmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodeloActionPerformed(evt);
            }
        });

        btnvehiculo.setText("Vehiculo");
        btnvehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvehiculoActionPerformed(evt);
            }
        });

        btntecnico.setText("Tecnico");
        btntecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntecnicoActionPerformed(evt);
            }
        });

        btncliente.setText("Cliente");
        btncliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclienteActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
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
                        .addGap(0, 78, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btntecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btncliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnvehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnmarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnmodelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(92, 92, 92))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsalir)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(btnmarca)
                .addGap(18, 18, 18)
                .addComponent(btnmodelo)
                .addGap(18, 18, 18)
                .addComponent(btnvehiculo)
                .addGap(18, 18, 18)
                .addComponent(btntecnico)
                .addGap(18, 18, 18)
                .addComponent(btncliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo que crear una ventana marca cuando el boton
     * sea seleccionado. Ademas cierra la ventana principal.
     */
    private void btnmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmarcaActionPerformed
        
        MarcaVista marca = new MarcaVista();
        marca.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_btnmarcaActionPerformed
    /**
     * Metodo que crear una ventana modelo cuando el boton
     * sea seleccionado. Ademas cierra la ventana principal.
     */
    private void btnmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodeloActionPerformed
        
        ModeloVista modelo = new ModeloVista();
        modelo.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnmodeloActionPerformed
    /**
     * Metodo que crear una ventana vehiculo cuando el boton
     * sea seleccionado. Ademas cierra la ventana principal.
     */
    private void btnvehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvehiculoActionPerformed
        VehiculoVista vv= new VehiculoVista();
        vv.setVisible(true);
        vv.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btnvehiculoActionPerformed
    /**
     * Metodo que crear una ventana tecnico cuando el boton
     * sea seleccionado. Ademas cierra la ventana principal.
     */
    private void btntecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntecnicoActionPerformed
        TecnicoVista tv = new TecnicoVista();
        tv.setVisible(true);
        tv.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btntecnicoActionPerformed

    /**
     * Metodo que crear una ventana cliente cuando el boton
     * sea seleccionado. Ademas cierra la ventana principal.
     */
    
    private void btnclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclienteActionPerformed
        ClienteVista cv = new ClienteVista();
        cv.setVisible(true);
        cv.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnclienteActionPerformed

    /**
     * Metodo que cierra la ventana principal
     */
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    /**
     * Metodo main de inicializacion del proyecto.
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
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalVista().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncliente;
    private javax.swing.JButton btnmarca;
    private javax.swing.JButton btnmodelo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btntecnico;
    private javax.swing.JButton btnvehiculo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
