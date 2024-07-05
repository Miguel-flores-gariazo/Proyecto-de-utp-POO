package RAHashMap;

import GUI.JFrame_Empleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Jframe_registroAccidente extends javax.swing.JFrame {
    
    private Accidente accidente;
    
    private final HashMap<String, Accidente> mapaAccidentes;
    private final DefaultTableModel modeloTabla;
    private int selectedRow = -1;
    
    public Jframe_registroAccidente() {
        initComponents();
        mapaAccidentes = new HashMap<>();
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Tipo Documento", "N° Documento", "Nombres", "Apellidos", "Fecha Nacimiento", "Sexo", "Fecha Accidente", "Tipo Accidente", "Descripción"}, 0);
        jTable1.setModel(modeloTabla);

        btnGuardar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarAccidente();
            }
        });
        
        jButton2.addActionListener(new ActionListener() { // Botón Eliminar
            public void actionPerformed(ActionEvent e) {
                eliminarAccidente();
            }
        });

        jButton3.addActionListener(new ActionListener() { // Botón Modificar
            public void actionPerformed(ActionEvent e) {
                cargarAccidenteParaModificar();
            }
        });
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
    
    accidente = new Accidente(idEmpleado, tipoDocumento, numeroDocumento, nombres, apellidos, fechaNacimiento, sexo, fechaAccidente, tipoAccidente, descripcion);

    
    if (selectedRow == -1) { // Nuevo accidente
        if (mapaAccidentes.containsKey(idEmpleado)) {
                JOptionPane.showMessageDialog(this, "El ID de empleado ya existe. Introduzca un ID diferente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        mapaAccidentes.put(idEmpleado, accidente);
        modeloTabla.addRow(new Object[]{idEmpleado, tipoDocumento, numeroDocumento, nombres, apellidos, fechaNacimiento, sexo, fechaAccidente, tipoAccidente, descripcion});
    } else { // Modificar accidente existente
        String idOriginal = (String) modeloTabla.getValueAt(selectedRow, 0);
        mapaAccidentes.remove(idOriginal);
        mapaAccidentes.put(idEmpleado, accidente);
        modeloTabla.setValueAt(idEmpleado, selectedRow, 0);
        modeloTabla.setValueAt(tipoDocumento, selectedRow, 1);
        modeloTabla.setValueAt(numeroDocumento, selectedRow, 2);
        modeloTabla.setValueAt(nombres, selectedRow, 3);
        modeloTabla.setValueAt(apellidos, selectedRow, 4);
        modeloTabla.setValueAt(fechaNacimiento, selectedRow, 5);
        modeloTabla.setValueAt(sexo, selectedRow, 6);
        modeloTabla.setValueAt(fechaAccidente, selectedRow, 7);
        modeloTabla.setValueAt(tipoAccidente, selectedRow, 8);
        modeloTabla.setValueAt(descripcion, selectedRow, 9);
        selectedRow = -1; // Resetear selección
    }
    limpiarCampos();
}
    
    private void eliminarAccidente() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String idEmpleado = (String) modeloTabla.getValueAt(selectedRow, 0);
            mapaAccidentes.remove(idEmpleado);
            modeloTabla.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarAccidenteParaModificar() {
        selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String idEmpleado = (String) modeloTabla.getValueAt(selectedRow, 0);
            Accidente accidente = mapaAccidentes.get(idEmpleado);
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
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiarCampos() {
    TFID.setText("");
    CBTD.setSelectedIndex(0); // O el valor por defecto adecuado
    ND.setText("");
    NOMBRES.setText("");
    APELLIDOS.setText("");
    jComboBox2.setSelectedIndex(0); // O el valor por defecto adecuado
    jComboBox3.setSelectedIndex(0); // O el valor por defecto adecuado
    jTextArea1.setText("");
    jDateChooser1.setDate(null);
    jDateChooser2.setDate(null);
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

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suave", "Grave", "Mortal" }));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(APELLIDOS)
                                .addComponent(NOMBRES, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ND, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TFID, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CBTD, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(38, 38, 38)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(12, Short.MAX_VALUE))
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
     
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame_Empleados empleados=new JFrame_Empleados();
             empleados.setVisible(true);
             dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Jframe_registroAccidente frame = new Jframe_registroAccidente();
        frame.setVisible(true);
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

