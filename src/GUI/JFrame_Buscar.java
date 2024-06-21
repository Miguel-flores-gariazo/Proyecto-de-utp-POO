package GUI;
import JcheckBox.CheckBoxColumn;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.HashMap;
import plazavea.empleados.Empleado;
public class JFrame_Buscar extends javax.swing.JFrame {
private HashMap<String, Empleado> empleadosMap; // HashMap para buscar empleados
    double contador;
    int intentos = 0;

   
    public JFrame_Buscar() {
        initComponents();
        empleadosMap = new HashMap<>(); // Inicializamos el HashMap
        mostrarPersonas();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        datos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btn_Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titulo.setText("BUSQUEDA");

        regresar.setText("REGRESAR");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        datos.setText("DATOS:");

        jLabel3.setText("DNI O NOMBRE:");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });

        btbuscar.setText("BUSCAR");
        btbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbuscarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
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
                        .addComponent(regresar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(titulo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btbuscar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_Eliminar))
                                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btbuscar)
                            .addComponent(btn_Eliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

             Empleado.setVisible(true);
             dispose();
    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        JFrame_Empleados Empleado=new JFrame_Empleados();
             Empleado.setVisible(true);
             dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
      buscarPersona(txt_buscar.getText());
      
    }//GEN-LAST:event_btbuscarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
               Logica logica = new Logica();

        long tiempo_inicial = System.currentTimeMillis();

        System.out.println("inicio"+tiempo_inicial);

        for (int i = 0; i < tabla.getRowCount(); i++)
        {
            if  ( CheckBoxColumn.IsSelected(i, 4, tabla))
            {
                logica.eliminarRegistro(Integer.parseInt(tabla.getValueAt(i, 1).toString()));
            }
        }

        mostrarPersonas();

        long tiempo_final = System.currentTimeMillis();
        System.out.println("consumido total seguntos = "+((double)(tiempo_final-tiempo_inicial)/1000));

        contador += ((double)(tiempo_final-tiempo_inicial)/1000);
        intentos ++;

        System.out.println(contador+"  "+intentos);
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
        buscarPersona(txt_buscar.getText());

    }                                      

    public void mostrarPersonas()
    {
        Logica logica = new Logica();
        DefaultTableModel modelo = logica.mostrarPersonas();
        tabla.setModel(modelo);
        CheckBoxColumn checkBoxColumn = new CheckBoxColumn();
        checkBoxColumn.addCheckBox(4, tabla);
        
        // Llenar el HashMap con los datos de la tabla
        llenarEmpleadosMap(modelo);
            
    }
    
        private void llenarEmpleadosMap(DefaultTableModel modelo) {
        empleadosMap.clear(); // Limpiar el HashMap antes de llenarlo nuevamente
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String dni = modelo.getValueAt(i, 5).toString(); // Asumiendo que el DNI está en la columna 5
            String nombre = modelo.getValueAt(i, 1).toString(); // Asumiendo que el nombre está en la columna 1
            Empleado empleado = new Empleado(
                Integer.parseInt(modelo.getValueAt(i, 0).toString()), // ID
                modelo.getValueAt(i, 1).toString(), // Nombre
                modelo.getValueAt(i, 2).toString(), // Apellidos
                Integer.parseInt(modelo.getValueAt(i, 3).toString()), // Edad
                modelo.getValueAt(i, 4).toString(), // Género
                dni, // DNI
                modelo.getValueAt(i, 6).toString() // Otros atributos si hay más
            );
            empleadosMap.put(dni, empleado);
            empleadosMap.put(nombre, empleado);
        }
    }

    
        public void buscarPersona(String buscar) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Edad");
        modelo.addColumn("Género");
        modelo.addColumn("DNI");
        modelo.addColumn("Otros");

        Empleado empleado = empleadosMap.get(buscar);
        if (empleado != null) {
            modelo.addRow(new Object[]{
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellidos(),
                empleado.getEdad(),
                empleado.getGenero(),
                empleado.getDni(),
                empleado.getOtros()
            });
        }

        tabla.setModel(modelo);
        CheckBoxColumn checkBoxColumn = new CheckBoxColumn();
        checkBoxColumn.addCheckBox(4, tabla);
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
            java.util.logging.Logger.getLogger(JFrame_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFrame_Buscar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JLabel datos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
