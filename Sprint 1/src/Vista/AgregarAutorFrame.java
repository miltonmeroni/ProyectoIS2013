/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Acciones.Operaciones;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author MILTON
 */
public class AgregarAutorFrame extends javax.swing.JFrame {
    
    DefaultComboBoxModel modeloComboPais = new DefaultComboBoxModel();
    String seleccionPais;
    String CampoacercaDe;
    AgregarLibros frameAgregarLibros;
    Operaciones operaciones;

    public AgregarAutorFrame(AgregarLibros frameAgregar) {
        initComponents();
        this.setResizable(false);
        frameAgregarLibros = frameAgregar;
        operaciones = new Operaciones();
        operaciones.conectar();
        operaciones.cargarPais(modeloComboPais);
        jTextArea_AcercaDe.setLineWrap(true);
        this.setLocation(450, 180);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() { 
        public void windowClosing(java.awt.event.WindowEvent e) {	
            frameAgregarLibros.setEnabled(true);
            frameAgregarLibros.setVisible(true);
            dispose();
        }; 
        }); 
    }

    private AgregarAutorFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NombreAutor = new javax.swing.JLabel();
        ApellidoAutor = new javax.swing.JLabel();
        paisId = new javax.swing.JLabel();
        nacimiento = new javax.swing.JLabel();
        Sexo = new javax.swing.JLabel();
        AcercaDe = new javax.swing.JLabel();
        agregarAutor = new javax.swing.JButton();
        campo_ApellidoAutor = new java.awt.TextField();
        campo_NombreAutor = new java.awt.TextField();
        comboPais = new javax.swing.JComboBox();
        comboSexo = new javax.swing.JComboBox();
        agregarFecha = new javax.swing.JButton();
        campo_FechaNac = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_AcercaDe = new javax.swing.JTextArea();
        AgregarPais = new javax.swing.JButton();
        CancelarAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agregar nuevo autor...");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NombreAutor.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        NombreAutor.setText("Nombre:");
        jPanel1.add(NombreAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        ApellidoAutor.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        ApellidoAutor.setText("Apellido:");
        jPanel1.add(ApellidoAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));

        paisId.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        paisId.setText("Pais:");
        jPanel1.add(paisId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        nacimiento.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        nacimiento.setText("Fecha de nacimiento:");
        jPanel1.add(nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, 30));

        Sexo.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        Sexo.setText("Sexo:");
        jPanel1.add(Sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 30));

        AcercaDe.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        AcercaDe.setText("Acerca de:");
        jPanel1.add(AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        agregarAutor.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        agregarAutor.setText("Agregar");
        agregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAutorActionPerformed(evt);
            }
        });
        jPanel1.add(agregarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 100, -1));
        jPanel1.add(campo_ApellidoAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, 30));
        jPanel1.add(campo_NombreAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 30));

        comboPais.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        comboPais.setModel(modeloComboPais);
        comboPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPaisActionPerformed(evt);
            }
        });
        jPanel1.add(comboPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 200, 30));

        comboSexo.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        jPanel1.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 120, 30));

        agregarFecha.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        agregarFecha.setText("Fecha");
        agregarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFechaActionPerformed(evt);
            }
        });
        jPanel1.add(agregarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 80, 30));

        campo_FechaNac.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        jPanel1.add(campo_FechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 100, 30));

        jTextArea_AcercaDe.setColumns(20);
        jTextArea_AcercaDe.setRows(5);
        jScrollPane1.setViewportView(jTextArea_AcercaDe);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 360, 180));

        AgregarPais.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        AgregarPais.setText("Nuevo");
        AgregarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPaisActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 80, 30));

        CancelarAutor.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        CancelarAutor.setText("Cancelar");
        CancelarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarAutorActionPerformed(evt);
            }
        });
        jPanel1.add(CancelarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFechaActionPerformed
        // TODO add your handling code here:
        int año_malo = 0;
        String seleccion;
        do{
           seleccion = JOptionPane.showInputDialog(null,"Escriba un año de publicación del libro"); 
           System.out.println("la seleccion fue "+seleccion);
           año_malo = Integer.parseInt(seleccion);
           if (año_malo <= 1600) {
                 JOptionPane.showMessageDialog(null,"Ingreso un año inválido, vuelva a ingresarlo nuevamente");
            }
        }while (año_malo < 1600);
        DatePicker fecha = new DatePicker(Integer.parseInt(seleccion));
        String fecha_elegida;
        fecha_elegida = fecha.setPickedDate();       
        campo_FechaNac.setText(fecha_elegida);
    }//GEN-LAST:event_agregarFechaActionPerformed

    private void comboPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPaisActionPerformed
        // TODO add your handling code here:
        seleccionPais = (String)comboPais.getSelectedItem();   
    }//GEN-LAST:event_comboPaisActionPerformed

    private void agregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAutorActionPerformed
        // TODO add your handling code here:
        CampoacercaDe = "";
        String line = new String(jTextArea_AcercaDe.getText());        
        StringTokenizer st = new StringTokenizer(line,"\n");                
        while (st.hasMoreTokens()){
            String pepe = st.nextToken();
            CampoacercaDe = ""+pepe;
        }          
        int idPais = operaciones.buscoIdPais(seleccionPais);        
        if ((!campo_NombreAutor.getText().isEmpty()) & (!campo_ApellidoAutor.getText().isEmpty()) & (!campo_FechaNac.getText().isEmpty()) & (!CampoacercaDe.isEmpty())){
            Autor autor = new Autor(0, campo_NombreAutor.getText(), campo_ApellidoAutor.getText(),idPais, campo_FechaNac.getText(), (String) comboSexo.getSelectedItem(),CampoacercaDe );             
            operaciones.guardarAutor(autor);
            limpiar();
            JOptionPane.showMessageDialog(null,"Se agrego nuevo autor");               
            frameAgregarLibros.modeloComboAutor.removeAllElements();
            frameAgregarLibros.operaciones.cargarAutores(frameAgregarLibros.modeloComboAutor);            
            this.dispose();
            this.frameAgregarLibros.setEnabled(true);
            this.frameAgregarLibros.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Por favor complete todos los campos del nuevo autor");
        
        }          
        
    }//GEN-LAST:event_agregarAutorActionPerformed


    private void AgregarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPaisActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        AgregarNuevoPais nuevoPais = new AgregarNuevoPais(this);
        nuevoPais.setVisible(true);
    }//GEN-LAST:event_AgregarPaisActionPerformed

    private void CancelarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarAutorActionPerformed
        // TODO add your handling code here:
        this.frameAgregarLibros.setVisible(true);
        this.frameAgregarLibros.setEnabled(true);
        this.dispose();
        
    }//GEN-LAST:event_CancelarAutorActionPerformed

    public void limpiar(){
        campo_ApellidoAutor.setText("");
        campo_NombreAutor.setText("");
        campo_FechaNac.setText("");
        jTextArea_AcercaDe.setText("");
        
    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AcercaDe;
    private javax.swing.JButton AgregarPais;
    private javax.swing.JLabel ApellidoAutor;
    private javax.swing.JButton CancelarAutor;
    private javax.swing.JLabel NombreAutor;
    private javax.swing.JLabel Sexo;
    private javax.swing.JButton agregarAutor;
    private javax.swing.JButton agregarFecha;
    private java.awt.TextField campo_ApellidoAutor;
    private javax.swing.JLabel campo_FechaNac;
    private java.awt.TextField campo_NombreAutor;
    private javax.swing.JComboBox comboPais;
    private javax.swing.JComboBox comboSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_AcercaDe;
    private javax.swing.JLabel nacimiento;
    private javax.swing.JLabel paisId;
    // End of variables declaration//GEN-END:variables

 
}
