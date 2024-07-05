package GUI;



public class jframe_solicitudSeguro2 extends javax.swing.JFrame {

  

    public jframe_solicitudSeguro2() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        titulo2 = new javax.swing.JLabel();
        tercerdato = new javax.swing.JLabel();
        conyyge = new javax.swing.JLabel();
        vinculofamiliar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tex_nombreconyu = new javax.swing.JTextField();
        tex_apeconyu = new javax.swing.JTextField();
        apellidocony = new javax.swing.JLabel();
        comobox_numerodocu = new javax.swing.JComboBox<>();
        tex_numer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombrescony = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tex_numdoc2 = new javax.swing.JTextField();
        tex_apellidomayo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ComboBox_tipodocu2 = new javax.swing.JComboBox<>();
        tex_nomhijoma = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        texpais = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tex_depa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tex_distr = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tex_direc = new javax.swing.JTextField();
        quintodato = new javax.swing.JLabel();
        boton_incrip = new javax.swing.JRadioButton();
        boton_baja = new javax.swing.JRadioButton();
        boton_modificacion = new javax.swing.JRadioButton();
        cuartodato = new javax.swing.JLabel();
        boton_divorcio = new javax.swing.JRadioButton();
        boton_porsolicitud = new javax.swing.JRadioButton();
        boton_fallecimiento = new javax.swing.JRadioButton();
        boton_porotros = new javax.swing.JRadioButton();
        fachafv_falle = new javax.swing.JLabel();
        tex_fecha = new javax.swing.JTextField();
        botonatras = new javax.swing.JButton();
        botonsalir = new javax.swing.JButton();
        botonEnviar = new javax.swing.JButton();

        jLabel12.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel12.setText("edad:");

        jLabel13.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel13.setText("nombres:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo2.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        titulo2.setText("SOLICITUD DE SEGURO DE SALUD ");

        tercerdato.setFont(new java.awt.Font("Complex_IV50", 0, 12)); // NOI18N
        tercerdato.setText("III.DATOS DE LOS DERECHOHABIENTES:");

        conyyge.setText("Cónyuge:");

        vinculofamiliar.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        vinculofamiliar.setText("VINCULO fAMILIAR:");

        jLabel6.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel6.setText("número de documento:");

        apellidocony.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        apellidocony.setText("apellidos:");

        comobox_numerodocu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nª DNI:", "NºCARNET DE EXTRANJERIA:" }));

        jLabel3.setText("Hijo mayor :");

        nombrescony.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        nombrescony.setText("nombres:");

        jLabel9.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel9.setText("número de documento:");

        jLabel10.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel10.setText("apellidos:");

        ComboBox_tipodocu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nª DNI:", "NºCARNET DE EXTRANJERIA:" }));

        jLabel11.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel11.setText("nombres:");

        jLabel14.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel14.setText("domicilio:");

        jLabel4.setText("País");

        jLabel15.setText("Departamento");

        jLabel17.setText("Distrito");

        jLabel18.setText("Dirección");

        quintodato.setFont(new java.awt.Font("Complex_IV50", 0, 12)); // NOI18N
        quintodato.setText("V.MOTIVO DE BAJA:");

        boton_incrip.setText("INSCRIPCIÓN");

        boton_baja.setText("BAJA");

        boton_modificacion.setText("MODIFICACIÓN");

        cuartodato.setFont(new java.awt.Font("Complex_IV50", 0, 12)); // NOI18N
        cuartodato.setText("IV.Tipo de proceso de solicitud:");

        boton_divorcio.setText("DIVORCIO");

        boton_porsolicitud.setText("POR SOLICITUD");

        boton_fallecimiento.setText("FALLECIMIENTO");

        boton_porotros.setText("POR OTROS....");

        fachafv_falle.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        fachafv_falle.setText("FECHA DE FIN DE VINCULO/FALLECIMIENTO:");

        botonatras.setText("ATRAS");

        botonsalir.setText("SALIR");
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });

        botonEnviar.setText("ENVIAR");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(titulo2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(boton_incrip)
                                .addGap(85, 85, 85)
                                .addComponent(boton_baja))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(tex_nomhijoma, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(texpais, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel15))
                                    .addComponent(tex_depa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(tex_distr, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tex_direc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(boton_modificacion)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cuartodato, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conyyge)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(nombrescony, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(apellidocony, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tercerdato, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quintodato, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fachafv_falle, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton_divorcio)
                                .addGap(18, 18, 18)
                                .addComponent(boton_porsolicitud)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boton_fallecimiento)
                                .addGap(18, 18, 18)
                                .addComponent(boton_porotros)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(tex_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonatras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(botonsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(botonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tex_apellidomayo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(tex_nombreconyu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tex_apeconyu, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ComboBox_tipodocu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tex_numdoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(comobox_numerodocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tex_numer, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(vinculofamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(597, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titulo2)
                .addGap(18, 18, 18)
                .addComponent(tercerdato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(conyyge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidocony, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrescony, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tex_nombreconyu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_apeconyu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comobox_numerodocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_numer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tex_nomhijoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_tipodocu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_apellidomayo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_numdoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tex_depa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tex_distr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tex_direc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(texpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(cuartodato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_incrip)
                    .addComponent(boton_baja)
                    .addComponent(boton_modificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quintodato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_divorcio)
                    .addComponent(boton_porsolicitud)
                    .addComponent(boton_fallecimiento)
                    .addComponent(boton_porotros))
                .addGap(18, 18, 18)
                .addComponent(fachafv_falle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tex_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonatras)
                    .addComponent(botonsalir)
                    .addComponent(botonEnviar))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(vinculofamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(543, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void botonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonsalirActionPerformed
      
    }//GEN-LAST:event_botonsalirActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonEnviarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

    java.awt.EventQueue.invokeLater(() -> new jframe_solicitudSeguro2().setVisible(true));
    }

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_tipodocu2;
    private javax.swing.JLabel apellidocony;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JRadioButton boton_baja;
    private javax.swing.JRadioButton boton_divorcio;
    private javax.swing.JRadioButton boton_fallecimiento;
    private javax.swing.JRadioButton boton_incrip;
    private javax.swing.JRadioButton boton_modificacion;
    private javax.swing.JRadioButton boton_porotros;
    private javax.swing.JRadioButton boton_porsolicitud;
    private javax.swing.JButton botonatras;
    private javax.swing.JButton botonsalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> comobox_numerodocu;
    private javax.swing.JLabel conyyge;
    private javax.swing.JLabel cuartodato;
    private javax.swing.JLabel fachafv_falle;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nombrescony;
    private javax.swing.JLabel quintodato;
    private javax.swing.JLabel tercerdato;
    private javax.swing.JTextField tex_apeconyu;
    private javax.swing.JTextField tex_apellidomayo;
    private javax.swing.JTextField tex_depa;
    private javax.swing.JTextField tex_direc;
    private javax.swing.JTextField tex_distr;
    private javax.swing.JTextField tex_fecha;
    private javax.swing.JTextField tex_nombreconyu;
    private javax.swing.JTextField tex_nomhijoma;
    private javax.swing.JTextField tex_numdoc2;
    private javax.swing.JTextField tex_numer;
    private javax.swing.JTextField texpais;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel vinculofamiliar;
    // End of variables declaration//GEN-END:variables

    
