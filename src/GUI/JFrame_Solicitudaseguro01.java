package GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import plazavea.solicitudseguro.SolicitudSeguroSalud;

import javax.swing.JOptionPane;
import plazavea.solicitudseguro.Repositorio;


public class JFrame_Solicitudaseguro01 extends javax.swing.JFrame {
    
private SolicitudSeguroSalud solicitud;

    public JFrame_Solicitudaseguro01() {
        initComponents();
        buttonGroup1.add(boton_hombre);
        buttonGroup1.add(boton_nujer);
        buttonGroup2.add(boton_solter);
        buttonGroup2.add(boton_casad);
        buttonGroup2.add(boton_divorciad);
        buttonGroup2.add(boton_viudo);
    }

    private boolean validarCampos() {
        // Verifica si al menos uno de los campos no está vacío
        // Verifica si al menos uno de los campos no está vacío
        boolean hayDatos = !tex_razonsocial.getText().trim().isEmpty() ||
                           !tex_numeroruc.getText().trim().isEmpty() ||
                           !tex_apellidoP.getText().trim().isEmpty() ||
                           !tex_apellidoM.getText().trim().isEmpty() ||
                           !tex_nombres.getText().trim().isEmpty() ||
                           !tex_numero.getText().trim().isEmpty() ||
                           !tex_fecha.getText().trim().isEmpty() ||
                           !tex_numertelefono.getText().trim().isEmpty() ||
                           !tex_gmail.getText().trim().isEmpty() ||
                           !tex_direccion.getText().trim().isEmpty() ||
                           boton_hombre.isSelected() ||
                           boton_nujer.isSelected() ||
                           boton_solter.isSelected() ||
                           boton_casad.isSelected() ||
                           boton_divorciad.isSelected() ||
                           boton_viudo.isSelected();

        if (!hayDatos) {
            mostrarError("Debe ingresar al menos un campo con datos.");
            return false;
        }

        String razonSocial = tex_razonsocial.getText().trim();
        if (razonSocial.isEmpty() || razonSocial.length() < 2 || razonSocial.length() > 100 || !razonSocial.matches("[a-zA-Z ]+")) {
            mostrarError("La razón social debe tener entre 2 y 100 caracteres y no debe contener caracteres especiales.");
            return false;
        }

        String ruc = tex_numeroruc.getText().trim();
        if (ruc.isEmpty() || ruc.length() != 11 || !ruc.matches("\\d+")) {
            mostrarError("El número de RUC debe tener 11 dígitos y contener solo números.");
            return false;
        }

        String apellidoPaterno = tex_apellidoP.getText().trim();
        if (apellidoPaterno.isEmpty() || !apellidoPaterno.matches("[a-zA-Z ]{2,50}")) {
            mostrarError("El apellido paterno debe tener entre 2 y 50 caracteres y solo debe contener letras.");
            return false;
        }

        String apellidoMaterno = tex_apellidoM.getText().trim();
        if (apellidoMaterno.isEmpty() || !apellidoMaterno.matches("[a-zA-Z ]{2,50}")) {
            mostrarError("El apellido materno debe tener entre 2 y 50 caracteres y solo debe contener letras.");
            return false;
        }

        String nombres = tex_nombres.getText().trim();
        if (nombres.isEmpty() || !nombres.matches("[a-zA-Z ]{2,50}")) {
            mostrarError("Los nombres deben tener entre 2 y 50 caracteres y solo deben contener letras.");
            return false;
        }

        String numeroDocumento = tex_numero.getText().trim();
        if (numeroDocumento.isEmpty() || !numeroDocumento.matches("\\d+")) {
            mostrarError("El número de documento debe contener solo números.");
            return false;
        }

        String fechaNacimiento = tex_fecha.getText().trim();
        if (fechaNacimiento.isEmpty() || !esFechaValida(fechaNacimiento)) {
            mostrarError("La fecha de nacimiento debe tener el formato dd/MM/yyyy y no puede ser una fecha futura o una fecha en la que la persona sea menor de 18 años.");
            return false;
        }

        if (!boton_hombre.isSelected() && !boton_nujer.isSelected()) {
            mostrarError("Debe seleccionar el sexo del afiliado titular.");
            return false;
        }

        if (!boton_solter.isSelected() && !boton_casad.isSelected() && !boton_divorciad.isSelected() && !boton_viudo.isSelected()) {
            mostrarError("Debe seleccionar el estado civil del afiliado titular.");
            return false;
        }

        String numeroTelefono = tex_numertelefono.getText().trim();
        if (numeroTelefono.isEmpty() || numeroTelefono.length() != 9 || !numeroTelefono.matches("\\d+")) {
            mostrarError("Debe ingresar un número de teléfono válido (9 dígitos y solo números).");
            return false;
        }

        String email = tex_gmail.getText().trim();
        if (email.isEmpty() || !esEmailValido(email)) {
            mostrarError("Debe ingresar un correo electrónico válido.");
            return false;
        }

        String direccion = tex_direccion.getText().trim();
        if (direccion.isEmpty() || direccion.length() < 5 || direccion.length() > 100) {
            mostrarError("La dirección debe tener entre 5 y 100 caracteres.");
            return false;
        }

        return true;
    }

    private boolean esFechaValida(String fechaStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date fecha = sdf.parse(fechaStr);
            Date hoy = new Date();
            return !fecha.after(hoy) && calcularEdad(fecha) >= 18;
        } catch (ParseException e) {
            return false;
        }
    }

    private int calcularEdad(Date fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int añoActual = Integer.parseInt(sdf.format(new Date()));
        int añoNacimiento = Integer.parseInt(sdf.format(fechaNacimiento));
        return añoActual - añoNacimiento;
    }

    private boolean esEmailValido(String email) {
        // Expresión regular mejorada para la validación de correos electrónicos
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}|\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}|\\[?[a-zA-Z0-9-]*:[a-zA-Z0-9-]*\\]?)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void guardarDatos() {
        if (validarCampos()) {
            solicitud = new SolicitudSeguroSalud(
                    tex_razonsocial.getText().trim(),
                    tex_numeroruc.getText().trim(),
                    tex_apellidoP.getText().trim(),
                    tex_apellidoM.getText().trim(),
                    tex_nombres.getText().trim(),
                    combox_tipodocu.getSelectedItem().toString(),
                    tex_numero.getText().trim(),
                    tex_fecha.getText().trim(),
                    boton_hombre.isSelected() ? "Hombre" : "Mujer",
                    boton_solter.isSelected() ? "Soltero(a)" : boton_casad.isSelected() ? "Casado(a)" : boton_divorciad.isSelected() ? "Divorciado(a)" : "Viudo(a)",
                    tex_numertelefono.getText().trim(),
                    tex_gmail.getText().trim(),
                    tex_direccion.getText().trim()
            );
            // Lógica para guardar la solicitud
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        TITULO1 = new javax.swing.JLabel();
        Primerdato = new javax.swing.JLabel();
        ruc = new javax.swing.JLabel();
        razonsocial = new javax.swing.JLabel();
        segundodato = new javax.swing.JLabel();
        apellidoM = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        fechanaci = new javax.swing.JLabel();
        tex_apellidoP = new javax.swing.JTextField();
        tex_apellidoM = new javax.swing.JTextField();
        tex_nombres = new javax.swing.JTextField();
        apellidoP = new javax.swing.JLabel();
        combox_tipodocu = new javax.swing.JComboBox<>();
        tex_numero = new javax.swing.JTextField();
        tipodocu = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        tex_fecha = new javax.swing.JTextField();
        estadocivil = new javax.swing.JLabel();
        boton_hombre = new javax.swing.JRadioButton();
        boton_nujer = new javax.swing.JRadioButton();
        sexo = new javax.swing.JLabel();
        boton_solter = new javax.swing.JRadioButton();
        boton_casad = new javax.swing.JRadioButton();
        boton_divorciad = new javax.swing.JRadioButton();
        boton_viudo = new javax.swing.JRadioButton();
        numtelefono = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        gmail = new javax.swing.JLabel();
        tex_numertelefono = new javax.swing.JTextField();
        tex_gmail = new javax.swing.JTextField();
        tex_direccion = new javax.swing.JTextField();
        boton_siguiente = new javax.swing.JButton();
        boton_volver = new javax.swing.JButton();
        tex_razonsocial = new javax.swing.JTextField();
        tex_numeroruc = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        jLabel9.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel9.setText("APELLIDO PATERNO:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TITULO1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 24)); // NOI18N
        TITULO1.setText("SOLICITUD DE SEGURO DE SALUD ");

        Primerdato.setFont(new java.awt.Font("Complex_IV50", 0, 12)); // NOI18N
        Primerdato.setText("I. DATOS DE LA ENTIDAD EMPLEDORA/RESPONSABLE :");

        ruc.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        ruc.setText("Nº RUC:");

        razonsocial.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        razonsocial.setText("Razon social(Nombre de la empresa):");

        segundodato.setFont(new java.awt.Font("Complex_IV50", 0, 12)); // NOI18N
        segundodato.setText("II.DATOS DEL AFILIADO TITULAR:");

        apellidoM.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        apellidoM.setText("APELLIDO MATERNO:");

        nombre.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        nombre.setText("NOMBRES:");

        fechanaci.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        fechanaci.setText("FECHA DE NACIMIENTO:");

        apellidoP.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        apellidoP.setText("APELLIDO PATERNO:");

        combox_tipodocu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nª DNI:", "Nª CARNET DE EXTRANGERIA:" }));

        tipodocu.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        tipodocu.setText("TIPO DE DOCUMENTO:");

        estadocivil.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        estadocivil.setText("ESTADO CIVIL:");

        boton_hombre.setText("HOMBRE");

        boton_nujer.setText("MUJER");

        sexo.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        sexo.setText("SEXO:");

        boton_solter.setText("SOLTERO(A)");

        boton_casad.setText("CASADO(A)");

        boton_divorciad.setText("DIVORCIADO(A)");

        boton_viudo.setText("VIUDO(A)");

        numtelefono.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        numtelefono.setText("NÚMERO TELEFONO:");

        direccion.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        direccion.setText("DIRECCIÓN:");

        gmail.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        gmail.setText("GMAIL:");

        boton_siguiente.setText("SIGUIENTE");
        boton_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_siguienteActionPerformed(evt);
            }
        });

        boton_volver.setText("VOLVER A MENÚ");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(TITULO1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Primerdato, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(segundodato, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(boton_hombre))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tex_numertelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(325, 325, 325))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(estadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(boton_solter)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(boton_viudo)
                                            .addComponent(boton_divorciad)
                                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(tex_gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tex_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combox_tipodocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(tipodocu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(boton_nujer))
                                        .addComponent(numtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(boton_casad))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tex_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fechanaci, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(tex_fecha)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(tex_apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(tex_apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(tex_razonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tex_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tex_numeroruc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(razonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(453, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(TITULO1)
                .addGap(18, 18, 18)
                .addComponent(Primerdato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tex_razonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_numeroruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(segundodato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tex_apellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tex_apellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tex_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tipodocu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combox_tipodocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tex_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tex_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(fechanaci, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_hombre)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boton_nujer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(estadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(boton_solter))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(boton_divorciad))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_viudo)
                            .addComponent(boton_casad))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tex_numertelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_gmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tex_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_siguiente)
                    .addComponent(boton_volver))
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(razonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(482, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
 int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea volver al menú? Se perderán todos los datos no guardados.", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            JFrame_Menu menu = new JFrame_Menu();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_boton_volverActionPerformed

    private void boton_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_siguienteActionPerformed
     
        if (validarCampos()) {
            guardarDatos();
            
            // Obtener el repositorio global y agregar la solicitud
            Repositorio repositorio = Repositorio.getInstance();
            repositorio.addSolicitudSalud(solicitud);

            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        if (validarCampos()) {
        guardarDatos();

            JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    
            // Si los campos están validados correctamente, procedemos a guardar los datos en la instancia de SolicitudSeguroSalud
            String razonSocial = tex_razonsocial.getText().trim();
            String ruc = tex_numeroruc.getText().trim();
            String apellidoPaterno = tex_apellidoP.getText().trim();
            String apellidoMaterno = tex_apellidoM.getText().trim();
            String nombres = tex_nombres.getText().trim();
            String tipoDocumento = combox_tipodocu.getSelectedItem().toString();
            String numeroDocumento = tex_numero.getText().trim();
            String fechaNacimiento = tex_fecha.getText().trim();
            String sexo = boton_hombre.isSelected() ? "HOMBRE" : "MUJER";
            String estadoCivil = boton_solter.isSelected() ? "SOLTERO(A)" :
                                 boton_casad.isSelected() ? "CASADO(A)" :
                                 boton_divorciad.isSelected() ? "DIVORCIADO(A)" :
                                 "VIUDO(A)";
            String numeroTelefono = tex_numertelefono.getText().trim();
            String email = tex_gmail.getText().trim();
            String direccion = tex_direccion.getText().trim();

            solicitud = new SolicitudSeguroSalud(razonSocial, ruc, apellidoPaterno, apellidoMaterno, nombres, tipoDocumento, numeroDocumento, fechaNacimiento, sexo, estadoCivil, numeroTelefono, email, direccion);

            // Mostrar los datos en consola para verificar
            System.out.println(solicitud);

              // Abrir la siguiente ventana
        jframe_solicitudSeguro2 siguienteVentana = new jframe_solicitudSeguro2();
        siguienteVentana.setVisible(true);
        this.dispose();
    }
    }
    }//GEN-LAST:event_boton_siguienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> new JFrame_Solicitudaseguro01().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Primerdato;
    private javax.swing.JLabel TITULO1;
    private javax.swing.JLabel apellidoM;
    private javax.swing.JLabel apellidoP;
    private javax.swing.JRadioButton boton_casad;
    private javax.swing.JRadioButton boton_divorciad;
    private javax.swing.JRadioButton boton_hombre;
    private javax.swing.JRadioButton boton_nujer;
    private javax.swing.JButton boton_siguiente;
    private javax.swing.JRadioButton boton_solter;
    private javax.swing.JRadioButton boton_viudo;
    private javax.swing.JButton boton_volver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> combox_tipodocu;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel estadocivil;
    private javax.swing.JLabel fechanaci;
    private javax.swing.JLabel gmail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel numtelefono;
    private javax.swing.JLabel razonsocial;
    private javax.swing.JLabel ruc;
    private javax.swing.JLabel segundodato;
    private javax.swing.JLabel sexo;
    private javax.swing.JTextField tex_apellidoM;
    private javax.swing.JTextField tex_apellidoP;
    private javax.swing.JTextField tex_direccion;
    private javax.swing.JTextField tex_fecha;
    private javax.swing.JTextField tex_gmail;
    private javax.swing.JTextField tex_nombres;
    private javax.swing.JTextField tex_numero;
    private javax.swing.JTextField tex_numeroruc;
    private javax.swing.JTextField tex_numertelefono;
    private javax.swing.JTextField tex_razonsocial;
    private javax.swing.JLabel tipodocu;
    // End of variables declaration//GEN-END:variables

}
