package Vista;

import Acciones.Operaciones;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class agregarNuevoIdioma extends javax.swing.JFrame {
    Operaciones operaciones;
    AgregarLibros frameLibros;
 
    public agregarNuevoIdioma(AgregarLibros nuevo) {
        frameLibros = nuevo;
        initComponents();
        operaciones = new Operaciones();
        operaciones.conectar();
        this.setLocation(450, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() { 
        public void windowClosing(java.awt.event.WindowEvent e) {	
            frameLibros.setEnabled(true);
            frameLibros.setVisible(true);
            dispose();
        }; 
        }); 
    }

    private agregarNuevoIdioma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNuevoIdioma = new java.awt.TextField();
        cancelarIdioma = new javax.swing.JButton();
        AgregarIdioma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jLabel1.setText("Idioma:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 27));
        jPanel1.add(campoNuevoIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 310, 27));

        cancelarIdioma.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        cancelarIdioma.setText("Cancelar");
        cancelarIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarIdiomaActionPerformed(evt);
            }
        });
        jPanel1.add(cancelarIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        AgregarIdioma.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        AgregarIdioma.setText("Agregar");
        AgregarIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarIdiomaActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarIdiomaActionPerformed
        // TODO add your handling code here:
        frameLibros.setEnabled(true);
        frameLibros.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarIdiomaActionPerformed

    private void AgregarIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarIdiomaActionPerformed
        // TODO add your handling code here:
        if (!campoNuevoIdioma.getText().isEmpty()){
            operaciones.guardarIdioma(campoNuevoIdioma.getText());
            frameLibros.modeloComboIdioma.removeAllElements();
            frameLibros.operaciones.cargarIdioma(frameLibros.modeloComboIdioma);
            JOptionPane.showMessageDialog(null,"Se agrego nuevo idioma");
            this.dispose();
            frameLibros.setEnabled(true);
            frameLibros.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor ingrese un idioma");
        }       
    }//GEN-LAST:event_AgregarIdiomaActionPerformed


//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(agregarNuevoIdioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(agregarNuevoIdioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(agregarNuevoIdioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(agregarNuevoIdioma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new agregarNuevoIdioma().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarIdioma;
    private java.awt.TextField campoNuevoIdioma;
    private javax.swing.JButton cancelarIdioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
