package GUI;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import plazavea.empleados.Empleado;
 //FUNCIONA NO BORRAR
public class JFrame_Buscar extends javax.swing.JFrame {
    private HashMap<String, Empleado> empleadosMap; // HashMap para buscar empleados
    private ArrayList<Empleado> listaEmpleados; // Lista de empleados para manejar el original

    public JFrame_Buscar(ArrayList<Empleado> empleados) {
        this.listaEmpleados = empleados; // Recibimos la lista de empleados desde JFrame_Empleados
        this.empleadosMap = new HashMap<>(); // Inicializamos el HashMap
        initComponents();
        llenarEmpleadosMap();
        mostrarEmpleados();
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
        btn_Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbempleados = new javax.swing.JTable();

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

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        tbempleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido_Paterno", "Apellido_Materno", "Edad", "Genero", "DNI", "Telefono", "Puesto", "Tipo de Seguro", "Fecha de Nacimiento", "Correo", "Estado Civil", "Nacionalidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbempleados);
        if (tbempleados.getColumnModel().getColumnCount() > 0) {
            tbempleados.getColumnModel().getColumn(0).setResizable(false);
            tbempleados.getColumnModel().getColumn(1).setResizable(false);
            tbempleados.getColumnModel().getColumn(2).setResizable(false);
            tbempleados.getColumnModel().getColumn(3).setResizable(false);
            tbempleados.getColumnModel().getColumn(4).setResizable(false);
            tbempleados.getColumnModel().getColumn(5).setResizable(false);
            tbempleados.getColumnModel().getColumn(6).setResizable(false);
            tbempleados.getColumnModel().getColumn(7).setResizable(false);
            tbempleados.getColumnModel().getColumn(8).setResizable(false);
            tbempleados.getColumnModel().getColumn(9).setResizable(false);
            tbempleados.getColumnModel().getColumn(10).setResizable(false);
            tbempleados.getColumnModel().getColumn(11).setResizable(false);
            tbempleados.getColumnModel().getColumn(12).setResizable(false);
            tbempleados.getColumnModel().getColumn(13).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(regresar))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        JFrame_Empleados Empleado=new JFrame_Empleados();
             Empleado.setVisible(true);
             dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void eliminarEmpleado() {
        int selectedRow = tbempleados.getSelectedRow();
        if (selectedRow != -1) {
            String dni = tbempleados.getValueAt(selectedRow, 5).toString();
            Empleado empleado = empleadosMap.get(dni);
            if (empleado != null) {
                listaEmpleados.remove(empleado);
                empleadosMap.remove(dni);
                ((DefaultTableModel) tbempleados.getModel()).removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    private void llenarEmpleadosMap() {
        empleadosMap.clear();
        for (Empleado emp : listaEmpleados) {
            empleadosMap.put(emp.getDni(), emp);
        }
    }

        private void mostrarEmpleados() {
        DefaultTableModel model = (DefaultTableModel) tbempleados.getModel();
        model.setRowCount(0);
        for (Empleado emp : listaEmpleados) {
            model.addRow(new Object[]{
                emp.getNombre(), emp.getApellido_Paterno(), emp.getApellido_Materno(), emp.getEdad(), emp.getGenero(),
                emp.getDni(), emp.getTelefono(), emp.getPuesto(), emp.getTipoSeguro()
            });
        }
    }
        
      private void buscarPersona(String buscar) {
    if (buscar == null || buscar.trim().isEmpty()) {
        mostrarEmpleados();
        return;
    }

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Apellido_Paterno");
    model.addColumn("Apellido_Materno");
    model.addColumn("Edad");
    model.addColumn("Género");
    model.addColumn("DNI");
    model.addColumn("Teléfono");
    model.addColumn("Puesto");
    model.addColumn("Tipo de Seguro");

    boolean encontrado = false;

    // Primero intentamos buscar por DNI
    Empleado empleadoPorDNI = empleadosMap.get(buscar);
    if (empleadoPorDNI != null) {
        model.addRow(new Object[]{
            empleadoPorDNI.getNombre(), empleadoPorDNI.getApellido_Paterno(), empleadoPorDNI.getApellido_Materno(), empleadoPorDNI.getApellido_Materno(), empleadoPorDNI.getApellido_Materno(), empleadoPorDNI.getEdad(), empleadoPorDNI.getGenero(),
            empleadoPorDNI.getDni(), empleadoPorDNI.getTelefono(), empleadoPorDNI.getPuesto(), empleadoPorDNI.getTipoSeguro()
        });
        encontrado = true;
    }

    // Si no se encontró por DNI, buscamos por nombre en toda la lista
    if (!encontrado) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getNombre().equalsIgnoreCase(buscar)) {
                model.addRow(new Object[]{
                    emp.getNombre(), emp.getApellido_Paterno(), emp.getApellido_Materno(), emp.getEdad(), emp.getGenero(),
                    emp.getDni(), emp.getTelefono(), emp.getPuesto(), emp.getTipoSeguro()
                });
                encontrado = true;
            }
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(this, "No se encontró ningún empleado con el término de búsqueda proporcionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    tbempleados.setModel(model);
}
   
        
    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
      buscarPersona(txt_buscar.getText());
      
    }//GEN-LAST:event_btbuscarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
         eliminarEmpleado();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {                                           
           buscarPersona(txt_buscar.getText());
    }                                      
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
     java.awt.EventQueue.invokeLater(() -> new JFrame_Buscar(new ArrayList<>()).setVisible(true));
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
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JLabel datos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tbempleados;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
