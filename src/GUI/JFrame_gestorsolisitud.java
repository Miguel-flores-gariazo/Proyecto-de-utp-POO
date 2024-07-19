package GUI;

import plazavea.solicitudseguro.Repositorio;
import plazavea.solicitudseguro.SolicitudSeguroSalud;
import plazavea.solicitudseguro.SolicitudSeguroSalud2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class JFrame_gestorsolisitud extends javax.swing.JFrame {
    private Repositorio repositorio;
    private DefaultTableModel tableModel;

    public JFrame_gestorsolisitud() {
        initComponents();
        repositorio = Repositorio.getInstance(); // Usar singleton para obtener la instancia del repositorio
        initializeTable();
        populateTable();
    }

    private void initializeTable() {
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"DNI", "Nombre", "Apellido", "Tipo de Solicitud", "Fecha de Solicitud", "Estado"}
        );
        tbsolicitud.setModel(tableModel);
    }

    private void populateTable() {
        tableModel.setRowCount(0);

        List<SolicitudSeguroSalud> saludSolicitudes = repositorio.getSolicitudesSalud();
        List<SolicitudSeguroSalud2> salud2Solicitudes = repositorio.getSolicitudesSalud2();

        for (SolicitudSeguroSalud s : saludSolicitudes) {
            tableModel.addRow(new Object[]{
                s.getNumeroDocumento(), // DNI
                s.getNombres(),         // Nombre
                s.getApellidoPaterno() + " " + s.getApellidoMaterno(), // Apellido
                "Salud",
                s.getFechaNacimiento(), // Fecha de solicitud
                s.getEstadoCivil()     // Estado
            });
        }

        for (SolicitudSeguroSalud2 s : salud2Solicitudes) {
            tableModel.addRow(new Object[]{
                s.getNumeroDocumentoConyuge(), // DNI
                s.getNombreConyuge(),         // Nombre
                s.getApellidoConyuge(),       // Apellido
                "Salud2",
                s.getFechaFinVinculo(),       // Fecha de solicitud
                s.getTipoProceso()           // Estado
            });
        }
    }

    private void buscarSolicitud(String buscar) {
        tableModel.setRowCount(0);

        List<SolicitudSeguroSalud> saludSolicitudes = repositorio.getSolicitudesSalud();
        List<SolicitudSeguroSalud2> salud2Solicitudes = repositorio.getSolicitudesSalud2();

        for (SolicitudSeguroSalud s : saludSolicitudes) {
            if (s.getNombres().contains(buscar) || (s.getApellidoPaterno() + " " + s.getApellidoMaterno()).contains(buscar)) {
                tableModel.addRow(new Object[]{
                    s.getNumeroDocumento(), // DNI
                    s.getNombres(),         // Nombre
                    s.getApellidoPaterno() + " " + s.getApellidoMaterno(), // Apellido
                    "Salud",
                    s.getFechaNacimiento(), // Fecha de solicitud
                    s.getEstadoCivil()     // Estado
                });
            }
        }

        for (SolicitudSeguroSalud2 s : salud2Solicitudes) {
            if (s.getNombreConyuge().contains(buscar) || s.getApellidoConyuge().contains(buscar)) {
                tableModel.addRow(new Object[]{
                    s.getNumeroDocumentoConyuge(), // DNI
                    s.getNombreConyuge(),         // Nombre
                    s.getApellidoConyuge(),       // Apellido
                    "Salud2",
                    s.getFechaFinVinculo(),       // Fecha de solicitud
                    s.getTipoProceso()           // Estado
                });
            }
        }
    }

    private void eliminarSolicitud() {
        int selectedRow = tbsolicitud.getSelectedRow();
        if (selectedRow >= 0) {
            String dni = (String) tableModel.getValueAt(selectedRow, 0);

            // Eliminar solicitud de SolicitudSeguroSalud
            repositorio.removeSolicitudSalud(dni);

            // Eliminar solicitud de SolicitudSeguroSalud2
            repositorio.removeSolicitudSalud2(dni);

            // Actualizar la tabla
            populateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbsolicitud = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btbuscar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbsolicitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "APELLIDO", "TIPO DE SOLICITUD", "FECHA DE SOLICITUD", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbsolicitud);
        if (tbsolicitud.getColumnModel().getColumnCount() > 0) {
            tbsolicitud.getColumnModel().getColumn(0).setResizable(false);
            tbsolicitud.getColumnModel().getColumn(1).setResizable(false);
            tbsolicitud.getColumnModel().getColumn(2).setResizable(false);
            tbsolicitud.getColumnModel().getColumn(3).setResizable(false);
            tbsolicitud.getColumnModel().getColumn(4).setResizable(false);
            tbsolicitud.getColumnModel().getColumn(5).setResizable(false);
        }

        titulo.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        titulo.setText("GESTOR DE SOLICITUDES ");

        regresar.setText("REGRESAR");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel3.setText("ID SOLICITUD:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btbuscar)
                            .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(titulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Eliminar)
                    .addComponent(btbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        JFrame_Menu menu = new JFrame_Menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
       buscarSolicitud(txt_buscar.getText());
    }//GEN-LAST:event_btbuscarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
          eliminarSolicitud();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        buscarSolicitud(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_gestorsolisitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_gestorsolisitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_gestorsolisitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_gestorsolisitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
          java.awt.EventQueue.invokeLater(() -> new JFrame_gestorsolisitud().setVisible(true));
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tbsolicitud;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
