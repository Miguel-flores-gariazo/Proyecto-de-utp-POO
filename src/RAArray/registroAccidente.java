package RAArray;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.IOException;
import com.opencsv.CSVWriter;
import java.text.ParseException;

public class registroAccidente extends javax.swing.JFrame {
    
   
    private final ArrayList<Accidente> listaAccidentes = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private javax.swing.table.DefaultTableModel modeloTabla;
    

    public registroAccidente() {
        initComponents();
        modeloTabla = (DefaultTableModel) jTable1.getModel();
        jTable1.setModel(modeloTabla);
        modeloTabla.setRowCount(0);
    }

    private void guardarAccidente() {
        String idEmpleado = TFID.getText();
        String tipoDocumento = CBTD.getSelectedItem().toString();
        String numeroDocumento = ND.getText();
        String nombres = NOMBRES.getText();
        String apellidos = APELLIDOS.getText();
        String sexo = (String) jComboBox2.getSelectedItem();
        String tipoAccidente = (String) jComboBox3.getSelectedItem();
        String descripcion = jTextArea1.getText();
        Date fechaAccidente = jDateChooser1.getDate();
        Date fechaNacimiento = jDateChooser2.getDate();

        Accidente accidente = new Accidente(idEmpleado, tipoDocumento, numeroDocumento, nombres, apellidos, fechaNacimiento, sexo, fechaAccidente, tipoAccidente, descripcion);

        listaAccidentes.add(accidente);
        modeloTabla.addRow(new Object[]{idEmpleado, tipoDocumento, numeroDocumento, nombres, apellidos, fechaNacimiento, sexo, fechaAccidente, tipoAccidente, descripcion});

        limpiarCampos();
    }
    
    private void modificarAccidente() {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        Accidente accidente = listaAccidentes.get(selectedRow);
        accidente.setIdEmpleado(TFID.getText());
        accidente.setTipoDocumento(CBTD.getSelectedItem().toString());
        accidente.setNumeroDocumento(ND.getText());
        accidente.setNombres(NOMBRES.getText());
        accidente.setApellidos(APELLIDOS.getText());
        accidente.setSexo((String) jComboBox2.getSelectedItem());
        accidente.setTipoAccidente((String) jComboBox3.getSelectedItem());
        accidente.setDescripcion(jTextArea1.getText());
        accidente.setFechaAccidente(jDateChooser1.getDate());
        accidente.setFechaNacimiento(jDateChooser2.getDate());

        modeloTabla.setValueAt(TFID.getText(), selectedRow, 0);
        modeloTabla.setValueAt(CBTD.getSelectedItem().toString(), selectedRow, 1);
        modeloTabla.setValueAt(ND.getText(), selectedRow, 2);
        modeloTabla.setValueAt(NOMBRES.getText(), selectedRow, 3);
        modeloTabla.setValueAt(APELLIDOS.getText(), selectedRow, 4);
        modeloTabla.setValueAt(jDateChooser2.getDate(), selectedRow, 5);
        modeloTabla.setValueAt(jComboBox2.getSelectedItem(), selectedRow, 6);
        modeloTabla.setValueAt(jDateChooser1.getDate(), selectedRow, 7);
        modeloTabla.setValueAt(jComboBox3.getSelectedItem(), selectedRow, 8);
        modeloTabla.setValueAt(jTextArea1.getText(), selectedRow, 9);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila válida para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void cargarAccidenteParaModificar() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            Accidente accidente = listaAccidentes.get(selectedRow);
            TFID.setText(accidente.getIdEmpleado());
            CBTD.setSelectedItem(accidente.getTipoDocumento());
            ND.setText(accidente.getNumeroDocumento());
            NOMBRES.setText(accidente.getNombres());
            APELLIDOS.setText(accidente.getApellidos());
            jComboBox2.setSelectedItem(accidente.getSexo());
            jComboBox3.setSelectedItem(accidente.getTipoAccidente());
            jTextArea1.setText(accidente.getDescripcion());
            jDateChooser1.setDate(accidente.getFechaAccidente());
            jDateChooser2.setDate(accidente.getFechaNacimiento());
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila válida para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        listaAccidentes.clear();
    }
    

    private void limpiarCampos() {
        TFID.setText("");
        CBTD.setSelectedIndex(0);
        ND.setText("");
        NOMBRES.setText("");
        APELLIDOS.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jTextArea1.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }
    
    public void exportarDatos() {
    JFileChooser chooser = new JFileChooser();
    int opcion = chooser.showSaveDialog(this); // Abre el dialogo para guardar archivo

    if (opcion == JFileChooser.APPROVE_OPTION) {
        File archivo = chooser.getSelectedFile();
        String filePath = archivo.getAbsolutePath();

        if (!filePath.toLowerCase().endsWith(".csv")) {
            archivo = new File(filePath + ".csv");
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(archivo))) {
            for (Accidente accidente : listaAccidentes) {
                writer.writeNext(obtenerDatosAccidente(accidente));
            }
            JOptionPane.showMessageDialog(this, "Datos exportados correctamente a " + archivo.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al exportar datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}

private String[] obtenerDatosAccidente(Accidente accidente) {
    String fechaNacimiento = accidente.getFechaNacimiento() != null ? sdf.format(accidente.getFechaNacimiento()) : "";
    String fechaAccidente = accidente.getFechaAccidente() != null ? sdf.format(accidente.getFechaAccidente()) : "";

    return new String[]{
            accidente.getIdEmpleado(),
            accidente.getTipoDocumento(),
            accidente.getNumeroDocumento(),
            accidente.getNombres(),
            accidente.getApellidos(),
            fechaNacimiento,
            accidente.getSexo(),
            fechaAccidente,
            accidente.getTipoAccidente(),
            accidente.getDescripcion()
    };
}



private void importarDatos() {
    JFileChooser chooser = new JFileChooser();
    int opcion = chooser.showOpenDialog(this);

    if (opcion == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = chooser.getSelectedFile();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
            String linea;

            // Limpiar la tabla antes de importar nuevos datos
            limpiarTabla();

            boolean primeraLinea = true; // Para omitir la primera línea si es un encabezado
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Saltar la primera línea si es un encabezado
                }

                String[] datos = linea.split(",");

                if (datos.length != 10) {
                    throw new Exception("Formato incorrecto en el archivo CSV.");
                }

                Accidente accidente = new Accidente();
                accidente.setIdEmpleado(datos[0]);
                accidente.setTipoDocumento(datos[1]);
                accidente.setNumeroDocumento(datos[2]);
                accidente.setNombres(datos[3]);
                accidente.setApellidos(datos[4]);

                // Verificar si la fecha de nacimiento es vacía
                if (!datos[5].trim().isEmpty()) {
                    try {
                        accidente.setFechaNacimiento(sdf.parse(datos[5]));
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this, "Error al parsear fecha de nacimiento: " + datos[5]);
                        continue; // Saltar a la siguiente línea
                    }
                } else {
                    accidente.setFechaNacimiento(null); // Asignar null si la fecha es vacía
                }

                accidente.setSexo(datos[6]);

                // Verificar si la fecha de accidente es vacía
                if (!datos[7].trim().isEmpty()) {
                    try {
                        accidente.setFechaAccidente(sdf.parse(datos[7]));
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this, "Error al parsear fecha de accidente: " + datos[7]);
                        continue; // Saltar a la siguiente línea
                    }
                } else {
                    accidente.setFechaAccidente(null); // Asignar null si la fecha es vacía
                }

                accidente.setTipoAccidente(datos[8]);
                accidente.setDescripcion(datos[9]);

                listaAccidentes.add(accidente); // Agregar el objeto Accidente a la lista

                // Agregar el objeto Accidente a la tabla
                Object[] fila = new Object[] {
                    accidente.getIdEmpleado(),
                    accidente.getTipoDocumento(),
                    accidente.getNumeroDocumento(),
                    accidente.getNombres(),
                    accidente.getApellidos(),
                    accidente.getFechaNacimiento()!= null? sdf.format(accidente.getFechaNacimiento()) : "",
                    accidente.getSexo(),
                    accidente.getFechaAccidente()!= null? sdf.format(accidente.getFechaAccidente()) : "",
                    accidente.getTipoAccidente(),
                    accidente.getDescripcion()
                };
                modeloTabla.addRow(fila); // Agregar la fila a la tabla
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al importar archivo CSV: " + e.getMessage());
        }
    }
}

private final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

private void actualizarTabla() {
    modeloTabla.setRowCount(0); // Limpiar la tabla
    for (Accidente accidente : listaAccidentes) {
        Object[] fila = new Object[]{
            accidente.getIdEmpleado(),
            accidente.getTipoDocumento(),
            accidente.getNumeroDocumento(),
            accidente.getNombres(),
            accidente.getApellidos(),
            accidente.getFechaNacimiento() != null ? sdf2.format(accidente.getFechaNacimiento()) : "",
            accidente.getSexo(),
            accidente.getFechaAccidente() != null ? sdf2.format(accidente.getFechaAccidente()) : "",
            accidente.getTipoAccidente(),
            accidente.getDescripcion()
        };
        modeloTabla.addRow(fila); // Agregar la fila a la tabla
    }
    modeloTabla.fireTableDataChanged(); // Notificar a la tabla que los datos han cambiado
}
    
    
    private Accidente crearAccidenteDesdeLineaCSV(String line) throws Exception {
    String[] values = line.split(",");
    if (values.length != 10) {
        throw new Exception("Formato incorrecto en el archivo CSV.");
    }

    String idEmpleado = values[0];
    String tipoDocumento = values[1];
    String numeroDocumento = values[2];
    String nombres = values[3];
    String apellidos = values[4];
    Date fechaNacimiento = sdf.parse(values[5]);
    String sexo = values[6];
    Date fechaAccidente = sdf.parse(values[7]);
    String tipoAccidente = values[8];
    String descripcion = values[9];

    return new Accidente(idEmpleado, tipoDocumento, numeroDocumento, nombres, apellidos, fechaNacimiento, sexo, fechaAccidente, tipoAccidente, descripcion);
}
    
    
    
    private void generarGraficoAccidentes() {
    // Crear un mapa para almacenar la cantidad de accidentes por tipo
    Map<String, Integer> accidentesPorTipo = new HashMap<>();

    // Recorrer la lista de accidentes
    for (Accidente accidente : listaAccidentes) {
        // Obtener el tipo de accidente
        String tipoAccidente = accidente.getTipoAccidente();

        // Incrementar la cantidad de accidentes para ese tipo
        accidentesPorTipo.put(tipoAccidente, accidentesPorTipo.getOrDefault(tipoAccidente, 0) + 1);
    }

    // Crear un gráfico de barras
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    for (Map.Entry<String, Integer> entry : accidentesPorTipo.entrySet()) {
        dataset.addValue(entry.getValue(), "Accidentes", entry.getKey());
    }

    JFreeChart chart = ChartFactory.createBarChart(
        "Tipos de Accidentes más Frecuentes",
        "Tipo de Accidente",
        "Cantidad de Accidentes",
        dataset,
        PlotOrientation.VERTICAL,
        false,
        true,
        false
    );

    // Mostrar el gráfico
    ChartPanel chartPanel = new ChartPanel(chart);
    JFrame frame = new JFrame("Gráfico de Accidentes");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().add(chartPanel);
    frame.pack();
    frame.setVisible(true);
}

    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFID = new javax.swing.JTextField();
        ND = new javax.swing.JTextField();
        NOMBRES = new javax.swing.JTextField();
        APELLIDOS = new javax.swing.JTextField();
        CBTD = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO DE ACCIDENTES"));

        jLabel1.setText("ID Empleado");

        jLabel2.setText("Tipo de Documnto");

        jLabel3.setText("N° Documento");

        jLabel4.setText("Nombres");

        jLabel5.setText("Apellidos");

        jLabel6.setText("Sexo");

        TFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFIDActionPerformed(evt);
            }
        });
        TFID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFIDKeyTyped(evt);
            }
        });

        ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NDActionPerformed(evt);
            }
        });
        ND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NDKeyTyped(evt);
            }
        });

        NOMBRES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOMBRESActionPerformed(evt);
            }
        });
        NOMBRES.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NOMBRESKeyTyped(evt);
            }
        });

        APELLIDOS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                APELLIDOSKeyTyped(evt);
            }
        });

        CBTD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "CARNET DE EXTRANJERIA", "REG. UNICO DE CONTRIBUYENTES", "PASAPORTE", "PART. DE NACIMIENTO" }));
        CBTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTDActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de Accidente");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caídas", "Colisiones ", "Lesiones por objetos caídos ", "Electrocución ", "Incendio ", "Ascensores y escaleras mecánicas ", "Lesiones por objetos cortantes o punzantes", "Accidentes en áreas de comida y bebida", "Robos y agresiones", "Accidentes en áreas de estacionamiento " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha del Accidente ");

        jLabel9.setText("Fecha de Nacimiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CBTD, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                    .addComponent(ND, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NOMBRES, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(APELLIDOS, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox3, 0, 1, Short.MAX_VALUE)
                            .addComponent(TFID, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CBTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NOMBRES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6))
                    .addComponent(APELLIDOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setText("ATRAS");

        btnGuardar1.setText("GUARDAR");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TIPO DE DOCUMENTO", "N° DOCUMENTO", "NOMBRES", "APELLIDOS", "FECHA DE NACIMIENTO", "SEXO", "FECHA DE ACCIDENTE", "GRAVEDAD DE ACCIDENTE", "DESCRIPCION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("EXPORTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("IMPORTAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("GRAFICO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                        .addComponent(jButton1)
                        .addGap(286, 286, 286)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(33, 33, 33)
                        .addComponent(jButton4)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnGuardar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(39, 39, 39)
                                .addComponent(jButton2))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFIDActionPerformed

    private void NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NDActionPerformed

    private void NOMBRESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOMBRESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NOMBRESActionPerformed

    private void CBTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTDActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
    guardarAccidente();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow!= -1) {
        listaAccidentes.remove(selectedRow);
        modeloTabla.removeRow(selectedRow);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila válida para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    cargarAccidenteParaModificar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TFIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFIDKeyTyped
    
        char c = evt.getKeyChar();
        
        if(c<'0' || c>'9') evt.consume();
        
    }//GEN-LAST:event_TFIDKeyTyped

    private void NDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NDKeyTyped
     
        char c = evt.getKeyChar();

        if(c<'0' || c>'9') evt.consume();    

    }//GEN-LAST:event_NDKeyTyped

    private void NOMBRESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMBRESKeyTyped
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A')| c>'z') evt.consume();
    }//GEN-LAST:event_NOMBRESKeyTyped

    private void APELLIDOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APELLIDOSKeyTyped
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A')| c>'z') evt.consume();
    }//GEN-LAST:event_APELLIDOSKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        exportarDatos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        importarDatos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        generarGraficoAccidentes();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroAccidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField APELLIDOS;
    private javax.swing.JComboBox<String> CBTD;
    public javax.swing.JTextField ND;
    public javax.swing.JTextField NOMBRES;
    public javax.swing.JTextField TFID;
    public javax.swing.JButton btnGuardar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    

   
 }


