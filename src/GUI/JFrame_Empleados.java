package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import plazavea.empleados.Empleado;


public class JFrame_Empleados extends javax.swing.JFrame{

    private final ArrayList<Empleado> listaEmpleados;
    private final DefaultTableModel modeloTabla;
    private int selectedRow = -1;
    
public JFrame_Empleados() {
   initComponents();
        
        listaEmpleados = new ArrayList<>();
        modeloTabla = new DefaultTableModel(
            new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Genero","Dni" ,"telefono", "Puesto", "Tipo de Seguro", "Correo", "Estado Civil","Fecha De Nacimiento", "Nacionalidad"},
            0
        );
        tbempleados.setModel(modeloTabla);
        
        botonGuardarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEmpleado();
            }
        });

        botonmodificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarEmpleadoParaModificar();
            }
        });

        botoneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEmpleado();
            }
        });
            
    }


        private void guardarEmpleado() {
    String dni = txtDni.getText();
    String nombre = txtNombre.getText();
    String apellido_Paterno = txtApellidoPaterno.getText();
    String apellido_Materno = txtApellidoMaterno.getText();
    String edadStr = txtEdad.getText(); 
    String genero = comboGenero.getSelectedItem().toString();
    String telefono = txtTelefono.getText();
    String puesto = txtPuesto.getText();
    String tipoSeguro = txtTipoSeguro.getText();
    String fechaNStr = dateFechaNacimiento.getText();
    String gmail = txtGmail.getText();
    String Ecivil = comboEstadoCivil.getSelectedItem().toString(); 
    String nacionalidad = txtNacionalidad.getText();

    // Validación de campos obligatorios
    if (nombre.isEmpty() || apellido_Paterno.isEmpty() || apellido_Materno.isEmpty() || 
        edadStr.isEmpty() || dni.isEmpty() || telefono.isEmpty() || puesto.isEmpty() ||
        gmail.isEmpty() || fechaNStr.isEmpty() || nacionalidad.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int edad;
    Date fechaN;
    
    try {
        edad = Integer.parseInt(edadStr); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        fechaN = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNStr); 
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe tener el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Creación del objeto Empleado
    Empleado empleado = new Empleado(nombre, apellido_Paterno, apellido_Materno, edad, genero, dni, telefono, puesto, tipoSeguro, gmail, Ecivil, fechaN, nacionalidad);

    if (selectedRow == -1) {
        listaEmpleados.add(empleado);
        modeloTabla.addRow(new Object[]{nombre, apellido_Paterno, apellido_Materno, edad, genero, dni, telefono, puesto, tipoSeguro, gmail, Ecivil, fechaN, nacionalidad});
    } else {
        listaEmpleados.set(selectedRow, empleado);
        modeloTabla.setValueAt(nombre, selectedRow, 0);
        modeloTabla.setValueAt(apellido_Paterno, selectedRow, 1);
        modeloTabla.setValueAt(apellido_Materno, selectedRow, 2);
        modeloTabla.setValueAt(edad, selectedRow, 3);
        modeloTabla.setValueAt(genero, selectedRow, 4);
        modeloTabla.setValueAt(dni, selectedRow, 5);
        modeloTabla.setValueAt(telefono, selectedRow, 6);
        modeloTabla.setValueAt(puesto, selectedRow, 7);
        modeloTabla.setValueAt(tipoSeguro, selectedRow, 8);
        modeloTabla.setValueAt(gmail, selectedRow, 9);
        modeloTabla.setValueAt(Ecivil, selectedRow, 10);
        modeloTabla.setValueAt(fechaN, selectedRow, 11);
        modeloTabla.setValueAt(nacionalidad, selectedRow, 12);
        selectedRow = -1;
        }
        limpiarCampos();
    }

    private void cargarEmpleadoParaModificar() {
    selectedRow = tbempleados.getSelectedRow();
    if (selectedRow != -1) {
        txtDni.setText(modeloTabla.getValueAt(selectedRow, 0).toString());
        txtNombre.setText(modeloTabla.getValueAt(selectedRow, 1).toString());
        txtApellidoPaterno.setText(modeloTabla.getValueAt(selectedRow, 2).toString());
        txtApellidoMaterno.setText(modeloTabla.getValueAt(selectedRow, 3).toString());
        txtEdad.setText(modeloTabla.getValueAt(selectedRow, 4).toString());
        comboGenero.setSelectedItem(modeloTabla.getValueAt(selectedRow, 5).toString());
        txtTelefono.setText(modeloTabla.getValueAt(selectedRow, 6).toString());
        txtPuesto.setText(modeloTabla.getValueAt(selectedRow, 7).toString());
        txtTipoSeguro.setText(modeloTabla.getValueAt(selectedRow, 8).toString());
        dateFechaNacimiento.setText(modeloTabla.getValueAt(selectedRow, 9).toString());
        txtGmail.setText(modeloTabla.getValueAt(selectedRow, 10).toString());
        comboEstadoCivil.setSelectedItem(modeloTabla.getValueAt(selectedRow, 11).toString());
        txtNacionalidad.setText(modeloTabla.getValueAt(selectedRow, 12).toString());
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
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

    private void limpiarCampos() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtEdad.setText("");
        comboGenero.setSelectedIndex(0); // Or set to appropriate default
        txtTelefono.setText("");
        txtPuesto.setText("");
        txtTipoSeguro.setText("");
        dateFechaNacimiento.setText("");
        txtGmail.setText("");
        comboEstadoCivil.setSelectedIndex(0); // Or set to appropriate default
        txtNacionalidad.setText("");
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
        botonImportar = new javax.swing.JButton();
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
        btnBuscar = new javax.swing.JButton();
        botonGrafico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de empleados");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("EMPLEADOS ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        tbempleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Genero", "DNI", "Telefono", "Puesto", "Tipo de Seguro", "Correo", "Estado Civil", "Fecha De Nacimiento", "Nacionaldad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
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
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1020, 600));

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

        botonImportar.setText("Importar");
        botonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImportarActionPerformed(evt);
            }
        });
        getContentPane().add(botonImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jPanelRegistrar.setBackground(new java.awt.Color(204, 255, 255));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardarEmpleado)
                    .addComponent(botonmodificar))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanelRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 320, 680));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        botonGrafico.setText("Grafico");
        botonGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficoActionPerformed(evt);
            }
        });
        getContentPane().add(botonGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
                  JFrame_Menu Inicio=new JFrame_Menu();
             Inicio.setVisible(true);
             dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        guardarEmpleado();
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void botonGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarEmpleadoActionPerformed

    }//GEN-LAST:event_botonGuardarEmpleadoActionPerformed

    private void botoneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoneliminarActionPerformed

    }//GEN-LAST:event_botoneliminarActionPerformed

    private void botonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarActionPerformed
     exportarDatos();
    }//GEN-LAST:event_botonExportarActionPerformed

    private void botonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImportarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo de empleados");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            importarEmpleadosDesdeArchivo(archivo);
        }
    }//GEN-LAST:event_botonImportarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       JFrame_Buscar buscarFrame = new JFrame_Buscar(listaEmpleados);
            buscarFrame.setVisible(true);
                dispose();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void botonGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficoActionPerformed
        JFrame_GraficoGenero grafi = new JFrame_GraficoGenero(listaEmpleados);
            grafi.setVisible(true);
                dispose();
    }//GEN-LAST:event_botonGraficoActionPerformed

     private void importarEmpleadosDesdeArchivo(File archivo) {
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(archivo));
            while ((line = br.readLine()) != null) {
                // Limpiar y dividir la línea por comas
                String[] datos = cleanAndSplitLine(line);

                // Asegurarse de que hay suficientes datos
                if (datos.length != 13) {
                    JOptionPane.showMessageDialog(null, "Formato de línea incorrecto: " + line, "Error", JOptionPane.ERROR_MESSAGE);
                    continue; // Salta esta línea y sigue con la siguiente
                }

                // Crear un objeto Empleado con los datos
                Empleado empleado = new Empleado(
                    datos[0], datos[1], datos[2], Integer.parseInt(datos[3].trim()), datos[4].trim(),
                    datos[5].trim(), datos[6].trim(), datos[7].trim(), datos[8].trim(), datos[9].trim(), datos[10].trim(),
                    parseFecha(datos[11].trim()), datos[12].trim()
                );

                // Agregar el empleado a la lista y al modelo de la tabla
                listaEmpleados.add(empleado);
                modeloTabla.addRow(new Object[]{
                    empleado.getNombre(), empleado.getApellido_Paterno(), empleado.getApellido_Materno(),
                    empleado.getEdad(), empleado.getGenero(), empleado.getDni(), empleado.getTelefono(),
                    empleado.getPuesto(), empleado.getTipoSeguro(), empleado.getGmail(), empleado.getEcivil(),
                    empleado.getFechaN(), empleado.getNacionalidad()
                });
            }
            JOptionPane.showMessageDialog(null, "Empleados importados correctamente desde el archivo.");
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al importar empleados desde el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String[] cleanAndSplitLine(String line) {
        // Eliminar etiquetas de campo y dividir por comas
        String[] parts = line.split(", ");
        String[] datos = new String[13];

        for (int i = 0; i < parts.length; i++) {
            int colonIndex = parts[i].indexOf(": ");
            if (colonIndex != -1) {
                datos[i] = parts[i].substring(colonIndex + 2);
            } else {
                datos[i] = "";
            }
        }
        return datos;
    }

    private Date parseFecha(String fecha) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            return null;
        }
    }
    
    private void exportarDatos() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new java.io.File("empleado.txt"));
        int seleccion = fileChooser.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                for (Empleado emp : listaEmpleados) {
                    writer.write("Nombre: " + emp.getNombre() + ", ");
                    writer.write("Apellido Paterno: " + emp.getApellido_Paterno() + ", ");
                    writer.write("Apellido Materno: " + emp.getApellido_Materno() + ", ");
                    writer.write("Edad: " + emp.getEdad() + ", ");
                    writer.write("Género: " + emp.getGenero() + ", ");
                    writer.write("DNI: " + emp.getDni() + ", ");
                    writer.write("Teléfono: " + emp.getTelefono() + ", ");
                    writer.write("Puesto: " + emp.getPuesto() + ", ");
                    writer.write("Tipo Seguro: " + emp.getTipoSeguro() + ", ");
                    writer.write("Correo Electrónico: " + emp.getGmail() + ", ");
                    writer.write("Estado Civil: " + emp.getEcivil() + ", ");
                    // Formatear la fecha de nacimiento
                String fechaFormateada = emp.getFechaN() != null ? dateFormat.format(emp.getFechaN()) : "null";
                    writer.write("Fecha de Nacimiento: " + fechaFormateada + ", ");
                    writer.write("Nacionalidad: " + emp.getNacionalidad() + "\n");
                }
                JOptionPane.showMessageDialog(this, "Datos exportados correctamente.", "Exportar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al exportar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrame_Empleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Tipodocumento;
    private javax.swing.JButton atras;
    private javax.swing.JButton botonExportar;
    private javax.swing.JButton botonGrafico;
    private javax.swing.JButton botonGuardarEmpleado;
    private javax.swing.JButton botonImportar;
    private javax.swing.JButton botoneliminar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> comboEstadoCivil;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JTextField dateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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