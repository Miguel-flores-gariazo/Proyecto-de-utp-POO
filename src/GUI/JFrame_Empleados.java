
package GUI;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import plazavea.empleados.Empleado;
public class JFrame_Empleados extends javax.swing.JFrame {

    private ArrayList<Empleado> listaEmpleados;
    
    public JFrame_Empleados() {
        initComponents();
         listaEmpleados = new ArrayList<>(); // Inicializamos la lista de empleados
         
         // Ejemplo: Llenamos la lista con datos de prueba
        listaEmpleados.add(new Empleado(1, "Juan", "Pérez", 30, "Masculino", "12345678A", "123456789", "Desarrollador", "Seguro de Salud"));
        listaEmpleados.add(new Empleado(2, "María", "Gómez", 28, "Femenino", "87654321B", "987654321", "Analista", "Seguro de Vida"));
        listaEmpleados.add(new Empleado(3, "Carlos", "López", 35, "Masculino", "56789012C", "987654321", "Gerente", "Seguro de Jubilación"));
        
        // Actualizamos el JTable con los datos de la lista de empleados
        actualizarTabla();
    }
private void actualizarTabla() {
        // Creamos un DefaultTableModel con los datos de los empleados
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Edad");
        model.addColumn("Género");
        model.addColumn("DNI");
        model.addColumn("Teléfono");
        model.addColumn("Puesto");
        model.addColumn("Tipo de Seguro");

        // Llenamos el modelo con los datos de los empleados
        for (Empleado emp : listaEmpleados) {
            model.addRow(new Object[]{emp.getId(), emp.getNombre(), emp.getApellidos(), emp.getEdad(), emp.getGenero(),
                    emp.getDni(), emp.getTelefono(), emp.getPuesto(), emp.getTipoSeguro()});
        }

        // Asignamos el modelo al JTable
        tbempleados.setModel(model);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbempleados = new javax.swing.JTable();
        botonregistrarempleado = new javax.swing.JButton();
        botoneliminar = new javax.swing.JButton();
        botonmodificar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de empleados");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("EMPLEADOS ");

        tbempleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Edad", "Genero", "DNI", "Telefono", "Puesto", "Tipo de Seguro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbempleados.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbempleados);
        tbempleados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        botonregistrarempleado.setText("REGISTRAR NUEVO EMPLEADO");
        botonregistrarempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonregistrarempleadoActionPerformed(evt);
            }
        });

        botoneliminar.setText("ELIMINAR");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });

        botonmodificar.setText("MODIFICAR");

        atras.setText("ATRAS");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        botonBuscar.setText("BUSCAR");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(botonBuscar)
                .addGap(55, 55, 55)
                .addComponent(botonmodificar)
                .addGap(35, 35, 35)
                .addComponent(botoneliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(botonregistrarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(atras)
                .addGap(17, 17, 17))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonregistrarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botoneliminar)
                        .addComponent(botonmodificar)
                        .addComponent(atras)
                        .addComponent(botonBuscar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonregistrarempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregistrarempleadoActionPerformed
                  JFrame_Registrar Inicio=new JFrame_Registrar();
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_botonregistrarempleadoActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
                  JFrame_Menu Inicio=new JFrame_Menu();
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
            JFrame_Buscar Inicio=new JFrame_Buscar();
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
          JFrame_Eliminar Eliminar=new JFrame_Eliminar();
             Eliminar.setVisible(true);
             dispose();
    }//GEN-LAST:event_botoneliminarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Empleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton botonregistrarempleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbempleados;
    // End of variables declaration//GEN-END:variables
}
