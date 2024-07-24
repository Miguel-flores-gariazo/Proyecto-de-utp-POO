package RAArray;

import GUI.JFrame_Menu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class registroAccidente extends javax.swing.JFrame {

    private final ArrayList<Accidente> listaAccidentes = new ArrayList<>();
    private javax.swing.table.DefaultTableModel modeloTabla;
    
    public registroAccidente() {
        initComponents();
        jDateChooser1.setDate(new Date()); // Establecer la fecha actual como valor predeterminado

    jDateChooser1.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("date")) {
            Date selectedDate = (Date) evt.getNewValue();
            Date currentDate = new Date();
            if (selectedDate != null && selectedDate.after(currentDate)) {
                jDateChooser1.setDate(currentDate);
            }
        }
    }
    });
        modeloTabla = (DefaultTableModel) jtDatos.getModel();
        jtDatos.setModel(modeloTabla);
        modeloTabla.setRowCount(0);
        jtDatos.getColumnModel().getColumn(5).setCellRenderer(new FechaTableCellRenderer());
        jtDatos.getColumnModel().getColumn(7).setCellRenderer(new FechaTableCellRenderer());
    }

    private class FechaTableCellRenderer extends DefaultTableCellRenderer {
        private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Date) {
                value = sdf.format((Date) value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    
    private void guardarAccidente() {
    if (TFID.getText().isEmpty()
        || CBTD.getSelectedItem() == null
        || ND.getText().isEmpty()
        || NOMBRES.getText().isEmpty()
        || APELLIDOS.getText().isEmpty()
        || jComboBox2.getSelectedItem() == null
        || jComboBox3.getSelectedItem() == null
        || jTextArea1.getText().isEmpty()
        || jDateChooser1.getDate() == null
        || jDateChooser2.getDate() == null) {

        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }  
    
    String idEmpleado = TFID.getText();
    for (Accidente accidente : listaAccidentes) {
        if (accidente.getIdEmpleado().equals(idEmpleado)) {
            JOptionPane.showMessageDialog(this, "El ID de empleado ya existe. Por favor, ingrese un ID diferente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    if (NOMBRES.getText().length() < 4) {
        JOptionPane.showMessageDialog(this, "El nombre debe tener al menos 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (APELLIDOS.getText().length() < 4) {
        JOptionPane.showMessageDialog(this, "El apellido debe tener al menos 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (jTextArea1.getText().length() < 4) {
        JOptionPane.showMessageDialog(this, "La descripción debe tener al menos 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Date fechaNacimiento = jDateChooser2.getDate();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(fechaNacimiento);
    calendar.add(Calendar.YEAR, 18);
    Date fechaMinima = calendar.getTime();

    if (new Date().before(fechaMinima)) {
        JOptionPane.showMessageDialog(this, "Necesitas ser mayor de edad.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String tipoDocumento = CBTD.getSelectedItem().toString();
    String numeroDocumento = ND.getText();
    
    

    if (tipoDocumento.equals("DNI") && numeroDocumento.length() != 8) {
        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (tipoDocumento.equals("Carnet de Extranjería") && numeroDocumento.length() != 12) {
        JOptionPane.showMessageDialog(this, "El Carnet de Extranjería debe tener 12 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (tipoDocumento.equals("Registro Único de Contribuyentes") && (numeroDocumento.length() != 8 && numeroDocumento.length() != 11)) {
        JOptionPane.showMessageDialog(this, "El RUC debe tener 8 o 11 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (tipoDocumento.equals("Partida de Nacimiento")) {
        ND.setEditable(false); // bloquear el campo de número de documento
        numeroDocumento = ""; // vaciar el campo de número de documento
    }

    Accidente accidente = new Accidente(TFID.getText(), CBTD.getSelectedItem().toString(), ND.getText(), NOMBRES.getText(), APELLIDOS.getText(), jDateChooser2.getDate(), jComboBox2.getSelectedItem().toString(), jDateChooser1.getDate(), jComboBox3.getSelectedItem().toString(), jTextArea1.getText());

    listaAccidentes.add(accidente);
    modeloTabla.addRow(new Object[]{
        accidente.getIdEmpleado(),
        accidente.getTipoDocumento(),
        accidente.getNumeroDocumento(),
        accidente.getNombres(),
        accidente.getApellidos(),
        accidente.getFechaNacimiento(),
        accidente.getSexo(),
        accidente.getFechaAccidente(),
        accidente.getTipoAccidente(),
        accidente.getDescripcion()
    });

    Date fechaAccidente = jDateChooser1.getDate();
    
    limpiarCampos();
    
    // Establecer la fecha de accidente en el jDateChooser1
    jDateChooser1.setDate(fechaAccidente);
    }
    
    private void modificarAccidente() {
    int selectedRow = jtDatos.getSelectedRow();
        if (selectedRow != -1 && selectedRow < listaAccidentes.size()) {
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

    
public class ExcelExporter {
    public void exportToExcel(JTable table, String excelFilePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Recorre las filas y columnas del JTable
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            Row row = sheet.createRow(rowIndex);

            for (int colIndex = 0; colIndex < table.getColumnCount(); colIndex++) {
                Cell cell = row.createCell(colIndex);
                cell.setCellValue(table.getValueAt(rowIndex, colIndex).toString());
            }
        }

        // Guarda el archivo de Excel
        FileOutputStream fileOut = new FileOutputStream(new File(excelFilePath));
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
}
    
    private void cargarAccidenteParaModificar() {
        int selectedRow = jtDatos.getSelectedRow();
        if (selectedRow != -1 && selectedRow < listaAccidentes.size()) {
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
        DefaultTableModel model = (DefaultTableModel) jtDatos.getModel();
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
        jtDatos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO DE ACCIDENTES"));

        jLabel1.setText("ID Accidente");

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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGuardar1.setText("GUARDAR");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO DE DOCUMENTO", "N° DOCUMENTO", "NOMBRES", "APELLIDOS", "FECHA DE NACIMIENTO", "SEXO", "FECHA DE ACCIDENTE", "GRAVEDAD DE ACCIDENTE", "DESCRIPCION"
            }
        ));
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtDatos);
        if (jtDatos.getColumnModel().getColumnCount() > 0) {
            jtDatos.getColumnModel().getColumn(0).setResizable(false);
            jtDatos.getColumnModel().getColumn(1).setResizable(false);
            jtDatos.getColumnModel().getColumn(2).setResizable(false);
            jtDatos.getColumnModel().getColumn(3).setResizable(false);
            jtDatos.getColumnModel().getColumn(4).setResizable(false);
            jtDatos.getColumnModel().getColumn(5).setResizable(false);
            jtDatos.getColumnModel().getColumn(6).setResizable(false);
            jtDatos.getColumnModel().getColumn(7).setResizable(false);
            jtDatos.getColumnModel().getColumn(8).setResizable(false);
            jtDatos.getColumnModel().getColumn(9).setResizable(false);
        }

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

        btnExportar.setText("EXPORTAR");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnImportar.setText("IMPORTAR");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
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
                        .addComponent(btnImportar)
                        .addGap(33, 33, 33)
                        .addComponent(btnExportar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnGuardar1)
                                .addGap(41, 41, 41)
                                .addComponent(jButton3)
                                .addGap(39, 39, 39)
                                .addComponent(jButton2))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btnExportar)
                        .addComponent(btnImportar)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    int selectedRow = jtDatos.getSelectedRow();
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
    if (c < '0' || c > '9' || (ND.getText().length() == 8 && c != '\u0008')) { 
        evt.consume();
    }   

    }//GEN-LAST:event_NDKeyTyped

    private void NOMBRESKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NOMBRESKeyTyped
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A')| c>'z') evt.consume();
    }//GEN-LAST:event_NOMBRESKeyTyped

    private void APELLIDOSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_APELLIDOSKeyTyped
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A')| c>'z') evt.consume();
    }//GEN-LAST:event_APELLIDOSKeyTyped

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
    try {
        ExcelExporter exporter = new ExcelExporter();
        exporter.exportToExcel(jtDatos, "accidentes.xlsx");
        JOptionPane.showMessageDialog(this, "Los datos se han exportado correctamente a accidentes.xlsx");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al exportar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
    JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Excel", "xlsx"));
int returnValue = fileChooser.showOpenDialog(this);
if (returnValue == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fileChooser.getSelectedFile();
    try {
        FileInputStream fileInputStream = new FileInputStream(selectedFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        DefaultTableModel modeloTabla = (DefaultTableModel) jtDatos.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Object[] fila = new Object[10]; // Crear un arreglo para almacenar los datos de la fila
            int columnIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (columnIndex) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    case 8:
                    case 9:
                        fila[columnIndex] = cell.getStringCellValue();
                        break;
                    case 5:
                    case 7:
                        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                            fila[columnIndex] = cell.getDateCellValue();
                        } else {
                            fila[columnIndex] = cell.getStringCellValue();
                        }
                        break;
                }
                columnIndex++;
            }
            modeloTabla.addRow(fila); // Agregar la fila a la tabla
        }
        JOptionPane.showMessageDialog(this, "Los datos se han importado correctamente");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al importar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}      
    }//GEN-LAST:event_btnImportarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        generarGraficoAccidentes();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame_Menu login = new JFrame_Menu();
    login.setVisible(true);
    dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnGuardar1;
    public javax.swing.JButton btnImportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTable jtDatos;
    // End of variables declaration//GEN-END:variables
}


