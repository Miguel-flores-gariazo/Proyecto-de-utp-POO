package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.text.ParseException;
import plazavea.empleados.Empleado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
public class JFrame_Empleados extends javax.swing.JFrame{

    private ArrayList<Empleado> listaEmpleados;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public JFrame_Empleados() { 
        listaEmpleados = new ArrayList<>(); // Inicializamos la lista de empleados    
        initComponents();
 
        cargarEmpleados();
        actualizarTabla(); // Actualizamos la tabla con los datos iniciales
        
        try {
            // Ejemplo: Llenamos la lista con datos de prueba
            listaEmpleados.add(new Empleado("Juan", "Pérez", "Lopez", 30, "Masculino", "12345678A", "123456789", "Desarrollador", "Seguro de Salud", "juan.perez@gmail.com", "Soltero", sdf.parse("01-01-1994"), "Peruano"));
            listaEmpleados.add(new Empleado("María", "Gómez", "Garcia", 28, "Femenino", "87654321B", "987654321", "Analista", "Seguro de Vida", "maria.gomez@gmail.com", "Casada", sdf.parse("15-05-1996"), "Peruana"));
            listaEmpleados.add(new Empleado("Carlos", "López", "Chupitaz", 35, "Masculino", "56789012C", "987654321", "Gerente", "Seguro de Jubilación", "carlos.lopez@gmail.com", "Divorciado", sdf.parse("20-08-1988"), "Peruano"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Actualizamos el JTable con los datos de la lista de empleados
        actualizarTabla();
    }
    
    
     public void agregarEmpleado(Empleado emp) {
        listaEmpleados.add(emp);
        actualizarTabla();
    }
    
     private void cargarEmpleados() {  
    }
     
    private void actualizarTabla() {
        // Creamos un DefaultTableModel con los datos de los empleados
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellido_Paterno");
        model.addColumn("Apellido_Materno");
        model.addColumn("Edad");
        model.addColumn("Género");
        model.addColumn("DNI");
        model.addColumn("Teléfono");
        model.addColumn("Puesto");
        model.addColumn("Tipo de Seguro");
        model.addColumn("Email");
        model.addColumn("Estado Civil");
        model.addColumn("Fecha de Nacimiento");
        model.addColumn("Nacionalidad");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Llenamos el modelo con los datos de los empleados
        for (Empleado emp : listaEmpleados) {
            model.addRow(new Object[]{
                    emp.getNombre(), 
                    emp.getApellido_Paterno(),
                    emp.getApellido_Materno(),
                    emp.getEdad(), 
                    emp.getGenero(),
                    emp.getDni(), 
                    emp.getTelefono(), 
                    emp.getPuesto(), 
                    emp.getTipoSeguro(),
                    emp.getGmail(),
                    emp.getEcivil(),
                    sdf.format(emp.getFechaN()),
                    emp.getNacionalidad()
            });
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
        botonExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de empleados");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("EMPLEADOS ");

        tbempleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Genero", "DNI", "Telefono", "Puesto", "Tipo de Seguro", "Fecha De Nacimiento", "Correo", "Estado Civil", "Nacionaldad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbempleados.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbempleados);
        tbempleados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        botonExportar.setText("EXPORTAR");
        botonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(botonBuscar)
                .addGap(52, 52, 52)
                .addComponent(botonmodificar)
                .addGap(35, 35, 35)
                .addComponent(botoneliminar)
                .addGap(40, 40, 40)
                .addComponent(botonExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(botonregistrarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(atras)
                .addGap(17, 17, 17))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonregistrarempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botoneliminar)
                                .addComponent(botonmodificar)
                                .addComponent(atras)
                                .addComponent(botonBuscar)
                                .addComponent(botonExportar)))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonregistrarempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonregistrarempleadoActionPerformed
             JFrame_Registrar Inicio=new JFrame_Registrar(new ArrayList<>());
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_botonregistrarempleadoActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
                  JFrame_Menu Inicio=new JFrame_Menu();
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        JFrame_Buscar buscarFrame = new JFrame_gestorsolicitud(listaEmpleados);
        buscarFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
          int selectedRow = tbempleados.getSelectedRow();
        if (selectedRow != -1) {
            listaEmpleados.remove(selectedRow);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botoneliminarActionPerformed

    private void botonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarActionPerformed
                                           
    // Crear un StringBuilder para almacenar el contenido del archivo
    StringBuilder sb = new StringBuilder();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    // Añadir los encabezados de la tabla al archivo
    sb.append("Nombre, Apellidos, Edad, Género, DNI, Teléfono, Puesto, Tipo de Seguro, Email, Estado Civil, Fecha de Nacimiento, Nacionalidad\n");

    // Añadir los datos de cada empleado
    for (Empleado emp : listaEmpleados) {
        sb.append(emp.getNombre()).append(", ")
          .append(emp.getApellido_Paterno()).append(", ")
          .append(emp.getApellido_Materno()).append(", ")
          .append((char) emp.getEdad()).append(", ")
          .append(emp.getGenero()).append(", ")
          .append(emp.getDni()).append(", ")
          .append(emp.getTelefono()).append(", ")
          .append(emp.getPuesto()).append(", ")
          .append(emp.getTipoSeguro()).append(", ")
          .append(emp.getGmail()).append(", ")
          .append(emp.getEcivil()).append(", ")
          .append(sdf.format(emp.getFechaN())).append(", ")
          .append(emp.getNacionalidad()).append("\n");
    }

    // Elegir la ruta y el nombre del archivo
    // Definir la ruta completa dentro del paquete 'repositorio'
    String filePath = "src/repositorio/empleados.txt";

    // Escribir el contenido en el archivo
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        writer.write(sb.toString());
        JOptionPane.showMessageDialog(this, "Datos exportados exitosamente a " + filePath);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al exportar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_botonExportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> new JFrame_Empleados().setVisible(true));
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
    private javax.swing.JButton botonExportar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton botonregistrarempleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbempleados;
    // End of variables declaration//GEN-END:variables
}
