package plazavea.fallecimientos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class JFrame_Fallecimiento extends javax.swing.JFrame {

private HashMap<Integer, fallecimiento> fallecimientos;
    private DefaultTableModel tableModel;
    private int nextId;

    public JFrame_Fallecimiento() {
        fallecimientos = new HashMap<>();
        nextId = 1;

        // Configurar el JFrame
        setTitle("Registro de Fallecimientos");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la tabla
        tableModel = new DefaultTableModel(new String[]{"ID", "Empleado", "Fecha", "Hora"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Crear el panel de formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        formPanel.add(new JLabel("Empleado:"));
        JTextField empleadoField = new JTextField();
        formPanel.add(empleadoField);

        formPanel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        JTextField fechaField = new JTextField();
        formPanel.add(fechaField);

        formPanel.add(new JLabel("Hora (HH:MM):"));
        JTextField horaField = new JTextField();
        formPanel.add(horaField);

        JButton addButton = new JButton("Agregar");
        formPanel.add(addButton);

        add(formPanel, BorderLayout.SOUTH);

        // Acción del botón para agregar nuevos fallecimientos
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empleado = empleadoField.getText();
                String fecha = fechaField.getText();
                String hora = horaField.getText();

                if (!empleado.isEmpty() && !fecha.isEmpty() && !hora.isEmpty()) {
                    fallecimiento fallecimiento = new fallecimiento(empleado, fecha, hora);
                    fallecimientos.put(nextId, fallecimiento);
                    tableModel.addRow(new Object[]{nextId, empleado, fecha, hora});
                    nextId++;
                    
                    // Limpiar los campos
                    empleadoField.setText("");
                    fechaField.setText("");
                    horaField.setText("");
                } else {
                    JOptionPane.showMessageDialog(JFrame_Fallecimiento.this, "Por favor complete todos los campos.");
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFrame_Fallecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Fallecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Fallecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Fallecimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Fallecimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
