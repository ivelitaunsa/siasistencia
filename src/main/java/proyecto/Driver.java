package proyecto;
public class Driver extends javax.swing.JFrame {

    public Driver() {
        initComponents();
    }
                          
    private void initComponents() {

        btnCargo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRango = new javax.swing.JButton();
        btnDep = new javax.swing.JButton();
        btnGen = new javax.swing.JButton();
        btnDia = new javax.swing.JButton();
        btnEstAsi = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        btnCharla = new javax.swing.JButton();
        btnEstReg = new javax.swing.JButton();
        btnEpp = new javax.swing.JButton();
        btnTra = new javax.swing.JButton();
        btnAsi = new javax.swing.JButton();
        btnControl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCargo.setText("CARGO");
        btnCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tablas de Control");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("MENU");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tablas Referenciales");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tablas Fundamentales");

        btnRango.setText("RANGO");
        btnRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRangoActionPerformed(evt);
            }
        });

        btnDep.setText("DEPARTAMENTO");
        btnDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepActionPerformed(evt);
            }
        });

        btnGen.setText("GENERO");
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });

        btnDia.setText("DIA");
        btnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaActionPerformed(evt);
            }
        });

        btnEstAsi.setText("ESTADO ASISTENCIA");
        btnEstAsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstAsiActionPerformed(evt);
            }
        });

        btnMarca.setText("MARCA");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        btnCharla.setText("CHARLA");
        btnCharla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCharlaActionPerformed(evt);
            }
        });

        btnEstReg.setText("ESTADO REGISTRO");
        btnEstReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstRegActionPerformed(evt);
            }
        });

        btnEpp.setText("EPP");
        btnEpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEppActionPerformed(evt);
            }
        });

        btnTra.setText("TRABAJADOR");
        btnTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraActionPerformed(evt);
            }
        });

        btnAsi.setText("ASISTENCIA");
        btnAsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsiActionPerformed(evt);
            }
        });

        btnControl.setText("CONTROL EPP");
        btnControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTra)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnGen, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                            .addComponent(btnCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRango, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCharla, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEstAsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEstReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAsi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btnEpp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnControl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargo)
                    .addComponent(btnRango)
                    .addComponent(btnDep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGen)
                    .addComponent(btnDia)
                    .addComponent(btnEstAsi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMarca)
                    .addComponent(btnCharla)
                    .addComponent(btnEstReg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEpp)
                    .addComponent(btnTra))
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsi)
                    .addComponent(btnControl))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnCargoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        cargo.setVisible(true);
    }                                        

    private void btnRangoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        rango.setVisible(true);
    }                                        

    private void btnDepActionPerformed(java.awt.event.ActionEvent evt) {                                       
        departamento.setVisible(true);
    }                                      

    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {                                       
        genero.setVisible(true);
    }                                      

    private void btnDiaActionPerformed(java.awt.event.ActionEvent evt) {                                       
        dia.setVisible(true);
    }                                      

    private void btnEstAsiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        estadoAsistencia.setVisible(true);
    }                                         

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        marca.setVisible(true);
    }                                        

    private void btnCharlaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        charla.setVisible(true);
    }                                         

    private void btnEstRegActionPerformed(java.awt.event.ActionEvent evt) {                                          
        estadoRegistro.setVisible(true);
    }                                         

    private void btnEppActionPerformed(java.awt.event.ActionEvent evt) {                                       
        epp.setVisible(true);
    }                                      

    private void btnTraActionPerformed(java.awt.event.ActionEvent evt) {                                       
        trabajador.setVisible(true);
    }                                      

    private void btnAsiActionPerformed(java.awt.event.ActionEvent evt) {                                       
        asistencia.setVisible(true);
    }                                      

    private void btnControlActionPerformed(java.awt.event.ActionEvent evt) {                                           
        control.setVisible(true);
    }                                          

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Driver driver = new Driver();
                driver.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAsi;
    private javax.swing.JButton btnCargo;
    private javax.swing.JButton btnCharla;
    private javax.swing.JButton btnControl;
    private javax.swing.JButton btnDep;
    private javax.swing.JButton btnDia;
    private javax.swing.JButton btnEpp;
    private javax.swing.JButton btnEstAsi;
    private javax.swing.JButton btnEstReg;
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnRango;
    private javax.swing.JButton btnTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
    private GZZ_CARGO cargo = new GZZ_CARGO();
    private GZZ_RANGO rango = new GZZ_RANGO();
    private GZZ_DEPARTAMENTO departamento = new GZZ_DEPARTAMENTO();
    private GZZ_GENERO genero = new GZZ_GENERO();
    private GZZ_DIA dia = new GZZ_DIA();
    private GZZ_EST_ASISTENCIA estadoAsistencia = new GZZ_EST_ASISTENCIA();
    private GZZ_MARCA marca = new GZZ_MARCA();
    private R1Z_CHARLA charla = new R1Z_CHARLA();
    private GZZ_ESTADO_REGISTRO estadoRegistro = new GZZ_ESTADO_REGISTRO();
    private GZM_EPP epp = new GZM_EPP();
    private R1M_TRABAJADOR trabajador = new R1M_TRABAJADOR();
    private R1T_ASISTENCIA_CAB asistencia = new R1T_ASISTENCIA_CAB();
    private R2T_CONTROL_EPP_CAB control = new R2T_CONTROL_EPP_CAB();
}
