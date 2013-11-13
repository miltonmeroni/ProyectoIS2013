/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Acciones.Operaciones;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Turqito
 */
public class ListarLibros extends javax.swing.JFrame {

    /**
     * Creates new form ListarLibros
     */
    private Operaciones operaciones;
    
    
    //Lista con los libros levantados desde la base de datos.
    private LinkedList<Libro> lista_libros = new LinkedList();
    
    public boolean aparecer;
    
    public ListarLibros() {
        initComponents();
        operaciones = new Operaciones();
        operaciones.conectar();
        this.setResizable(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamanio = tk.getScreenSize();
        this.setBounds(0, 0, tamanio.width, tamanio.height-40);
        this.agregarlibros();
        jTable2.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e) 
      {  
         boolean encontre = false;
         int fila = jTable2.rowAtPoint(e.getPoint());
         int i = 0;
         int columna = 0;//"jTable2.columnAtPoint(e.getPoint());
//         System.out.println("Fila: "+fila+" Columna: "+columna);
         if ((fila > -1) && (columna > -1)){
            String libro_seleccionado = (String) (jTable2.getModel().getValueAt(fila,columna));           
            while ((i < lista_libros.size()) & (!encontre)){
                if (libro_seleccionado.equals(lista_libros.get(i).getTitulo())){
                    encontre = true;
               }
                else{
                    i++;
                }
            }
            if (encontre){    
                Configurar().setEnabled(false);
                new DetalleLibro(lista_libros.get(i), fila, jTable2, lista_libros, i,Configurar());
                 
            }
                    
         }  
      }
    });       
        this.setVisible(true);
    }
    private ListarLibros Configurar (){
       return this;
    }
    private void agregarlibros() {
      try{
        operaciones.conectar();
            try (ResultSet rs = operaciones.consulta.executeQuery("SELECT * FROM libros")) {
                while (rs.next()){ 
                    Libro librito;
                    librito = new Libro (Integer.parseInt(rs.getString(1)),
                                         rs.getString(2),
                                         rs.getString(3),
                                         Integer.parseInt(rs.getString(4)),
                                         Float.parseFloat(rs.getString(5)),
                                         rs.getString(6),
                                         rs.getString(7),
                                         rs.getString(8),
                                         Integer.parseInt(rs.getString(9)),
                                         Integer.parseInt(rs.getString(10)));
                    lista_libros.add(librito);
                }
               if (!lista_libros.isEmpty()) {
                  for (int i=0; i<lista_libros.size();i++){
                      Object[] datos_fila ={
                        lista_libros.get(i).getTitulo(),
                        this.operaciones.buscoNombreAutor(lista_libros.get(i).getAutor_id()),
                        lista_libros.get(i).getPrecio()
                      };
                      DefaultTableModel modeloDeLaTabla=(DefaultTableModel)jTable2.getModel();
                      modeloDeLaTabla.addRow(datos_fila);
                      jTable2.setModel(modeloDeLaTabla);
                  }
                
               }
                   }
                   }catch(SQLException e){
                        JOptionPane.showConfirmDialog(null, "Algo fallo");
                    }
    }
      
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            } //Disallow the editing of any cell
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CerrarSesion = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        agregarLibro = new javax.swing.JButton();
        ImgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CookBooks");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Titulo", "Autor", "Precio"
            }

        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 870, 220));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 32)); // NOI18N
        jLabel2.setText(" Listado de Libros");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 230, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cookbook2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 250, 110));

        CerrarSesion.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        CerrarSesion.setText("Cerrar  Sesión");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(CerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, 180, 40));

        atras.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        jPanel1.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 180, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 150));

        agregarLibro.setFont(new java.awt.Font("Calibri", 0, 17)); // NOI18N
        agregarLibro.setText("Agregar libro");
        agregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarLibroActionPerformed(evt);
            }
        });
        getContentPane().add(agregarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 160, 180, 40));

        ImgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        ImgFondo.setText("Fondo");
        getContentPane().add(ImgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1360, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarLibroActionPerformed
        // TODO add your handling code here:
        AgregarLibros nuevo = new AgregarLibros();
        nuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agregarLibroActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        Principal prueba = new Principal();
        prueba.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        ListarPedidos prueba = new ListarPedidos();
        prueba.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_atrasActionPerformed

   public static void main (String[] args){
       new ListarLibros().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JLabel ImgFondo;
    private javax.swing.JButton agregarLibro;
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables


}