package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import plazavea.empleados.Empleado;

public class JFrame_Empleados extends javax.swing.JFrame{

    private Empleado empleado;
    private final ArrayList<Empleado> listaEmpleados;
    private final DefaultTableModel modeloTabla;
    private int selectedRow = -1;

public JFrame_Empleados() {
        initComponents();
        listaEmpleados = new ArrayList<>();
        modeloTabla = new DefaultTableModel(
                new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Género", "DNI", "Teléfono", "Puesto", "Tipo Seguro", "Correo Electrónico", "Estado Civil", "Fecha de Nacimiento", "Nacionalidad"}, 0);
        tbempleados.setModel(modeloTabla);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbempleados = new javax.swing.JTable();
        botoneliminar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        botonExportar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanelRegistrar = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        Tipodocumento = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtTipoSeguro = new javax.swing.JTextField();
        comboGenero = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();
        txtNacionalidad = new javax.swing.JTextField();
        dateFechaNacimiento = new javax.swing.JTextField();
        comboEstadoCivil = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        botonGuardarEmpleado = new javax.swing.JButton();
        botonmodificar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtBuscarEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de empleados");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("EMPLEADOS ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 84, 1020, -1));

        botoneliminar.setText("ELIMINAR");
        botoneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoneliminarActionPerformed(evt);
            }
        });
        getContentPane().add(botoneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        atras.setText("ATRAS");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        botonExportar.setText("EXPORTAR");
        botonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarActionPerformed(evt);
            }
        });
        getContentPane().add(botonExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jButton1.setText("Importar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jPanelRegistrar.setBackground(new java.awt.Color(204, 255, 255));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel15.setText("REGISTRO DE EMPLEADOS");

        jLabel14.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel14.setText("Datos personales:");

        jLabel2.setText("Numero de Identificacion:");

        Tipodocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Carnet de Extranjeria" }));

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Apellido Materno:");

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino ", "Femenino" }));

        jLabel9.setText("Tipo de seguro:");

        jLabel6.setText("Edad:");

        jLabel7.setText("Genero:");

        jLabel8.setText("Telefono:");

        jLabel10.setText("Puesto:");

        jLabel11.setText("Correo:");

        jLabel12.setText("Estado civil:");

        jLabel13.setText("Nacionalidad:");

        comboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Viudo", "Separado", "Divorciado" }));

        jLabel16.setText("Fecha de Nacimiento:");

        botonGuardarEmpleado.setText("GUARDAD");
        botonGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarEmpleadoActionPerformed(evt);
            }
        });

        botonmodificar.setText("MODIFICAR");
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegistrarLayout = new javax.swing.GroupLayout(jPanelRegistrar);
        jPanelRegistrar.setLayout(jPanelRegistrarLayout);
        jPanelRegistrarLayout.setHorizontalGroup(
            jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel15))
                    .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre)))
                .addGap(12, 12, 12))
            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                        .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(Tipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtTipoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRegistrarLayout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPuesto))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRegistrarLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(30, 30, 30)
                                .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                    .addComponent(botonmodificar)
                                    .addGap(103, 103, 103)
                                    .addComponent(botonGuardarEmpleado))
                                .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelRegistrarLayout.setVerticalGroup(
            jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtTipoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarEmpleado)
                    .addComponent(botonmodificar))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanelRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 320, 680));

        jLabel17.setText("Buscar: ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtBuscarEmpleado.setText("POR DNI O NOMBRE");
        getContentPane().add(txtBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
                  JFrame_Menu Inicio=new JFrame_Menu();
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        cargarEmpleadoParaModificar();
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void botonGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarEmpleadoActionPerformed
guardarEmpleado();
    }//GEN-LAST:event_botonGuardarEmpleadoActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed
      eliminarEmpleado();
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

    
    private void guardarEmpleado() {
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        int edad = Integer.parseInt(txtEdad.getText());
        String genero = (String) comboGenero.getSelectedItem();
        String dni = txtDni.getText();
        String telefono = txtTelefono.getText();
        String puesto = txtPuesto.getText();
        String tipoSeguro = txtTipoSeguro.getText();
        String gmail = txtGmail.getText();
        String estadoCivil = (String) comboEstadoCivil.getSelectedItem();
        Date fechaNacimiento = new Date(); // Reemplazar con la forma correcta de obtener la fecha.
        String nacionalidad = txtNacionalidad.getText();

        empleado = new Empleado(nombre, apellidoPaterno, apellidoMaterno, edad, genero, dni, telefono, puesto, tipoSeguro, gmail, estadoCivil, fechaNacimiento, nacionalidad);

        if (selectedRow == -1) { // Nuevo empleado
            listaEmpleados.add(empleado);
            modeloTabla.addRow(new Object[]{nombre, apellidoPaterno, apellidoMaterno, edad, genero, dni, telefono, puesto, tipoSeguro, gmail, estadoCivil, fechaNacimiento, nacionalidad});
        } else { // Modificar empleado existente
            listaEmpleados.set(selectedRow, empleado);
            modeloTabla.setValueAt(nombre, selectedRow, 0);
            modeloTabla.setValueAt(apellidoPaterno, selectedRow, 1);
            modeloTabla.setValueAt(apellidoMaterno, selectedRow, 2);
            modeloTabla.setValueAt(edad, selectedRow, 3);
            modeloTabla.setValueAt(genero, selectedRow, 4);
            modeloTabla.setValueAt(dni, selectedRow, 5);
            modeloTabla.setValueAt(telefono, selectedRow, 6);
            modeloTabla.setValueAt(puesto, selectedRow, 7);
            modeloTabla.setValueAt(tipoSeguro, selectedRow, 8);
            modeloTabla.setValueAt(gmail, selectedRow, 9);
            modeloTabla.setValueAt(estadoCivil, selectedRow, 10);
            modeloTabla.setValueAt(fechaNacimiento, selectedRow, 11);
            modeloTabla.setValueAt(nacionalidad, selectedRow, 12);
            selectedRow = -1; // Resetear selección
        }
        limpiarCampos();
    }
 
    private void eliminarEmpleado() {
        int selectedRow = tbempleados.getSelectedRow();
        if (selectedRow != -1) {
            listaEmpleados.remove(selectedRow);
            modeloTabla.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void cargarEmpleadoParaModificar() {
        selectedRow = tbempleados.getSelectedRow();
        if (selectedRow != -1) {
            Empleado empleado = listaEmpleados.get(selectedRow);
            txtNombre.setText(empleado.getNombre());
            txtApellidoPaterno.setText(empleado.getApellido_Paterno());
            txtApellidoMaterno.setText(empleado.getApellido_Materno());
            txtEdad.setText(String.valueOf(empleado.getEdad()));
            comboGenero.setSelectedItem(empleado.getGenero());
            txtDni.setText(empleado.getDni());
            txtTelefono.setText(empleado.getTelefono());
            txtPuesto.setText(empleado.getPuesto());
            txtTipoSeguro.setText(empleado.getTipoSeguro());
            txtGmail.setText(empleado.getGmail());
            comboEstadoCivil.setSelectedItem(empleado.getEcivil());
            // dateFechaNacimiento.setDate(empleado.getFechaN()); // Implementar la conversión de Date a JTextField
            txtNacionalidad.setText(empleado.getNacionalidad());
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     private void limpiarCampos() {
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtEdad.setText("");
        comboGenero.setSelectedIndex(0); // O el valor por defecto adecuado
        txtDni.setText("");
        txtTelefono.setText("");
        txtPuesto.setText("");
        txtTipoSeguro.setText("");
        txtGmail.setText("");
        comboEstadoCivil.setSelectedIndex(0); // O el valor por defecto adecuado
        // dateFechaNacimiento.setDate(null); // Implementar la conversión de Date a JTextField
        txtNacionalidad.setText("");
    }


     
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Tipodocumento;
    private javax.swing.JButton atras;
    private javax.swing.JButton botonExportar;
    private javax.swing.JButton botonGuardarEmpleado;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JComboBox<String> comboEstadoCivil;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JTextField dateFechaNacimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbempleados;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtBuscarEmpleado;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoSeguro;
    // End of variables declaration//GEN-END:variables
}