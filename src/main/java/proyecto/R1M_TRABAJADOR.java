package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class R1M_TRABAJADOR extends javax.swing.JFrame {
    //Flag para la actualización
    private static int CarFlaAct = 0;
    //Comando activo al clickear boton
    /*
    1. Adicionar
    2. Modificar
    3. Eliminar
    4. Inactivar
    5. Reactivar */
    private static int comandoActivo = 1; 
    //Conexion con la DB
    private Conexion conexion = new Conexion();
    private Connection conn = conexion.conn;
    
    public R1M_TRABAJADOR() {
        initComponents();
        desactivarFields();
        llenarTablaCabecera();
        cargarComboDe("RanDes","GZZ_RANGO");
        cargarComboDe("CarDes","GZZ_CARGO");
        cargarComboDe("DepDes","GZZ_DEPARTAMENTO");
    }
                      
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cabCodField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        trabajadorField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboCarg = new javax.swing.JComboBox<>();
        comboRang = new javax.swing.JComboBox<>();        
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboDep = new javax.swing.JComboBox<>();
        estRegField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCabecera = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAdicionarCab = new javax.swing.JButton();
        btnInactivarCab = new javax.swing.JButton();
        btnModificarCab = new javax.swing.JButton();
        btnReactivarCab = new javax.swing.JButton();
        btnEliminarCab = new javax.swing.JButton();
        btnActualizarCab = new javax.swing.JButton();
        btnCancelarCab = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        DNIField = new javax.swing.JTextField();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(226, 226, 226));

        jLabel3.setText("Codigo:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("DNI:");

        jLabel6.setText("Rango:");

        jLabel7.setText("Cargo:");

        jLabel9.setText("Departamento:");

        jLabel8.setText("Genero:");
        
        jLabel10.setText("Estado registro:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estRegField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(trabajadorField, 0, 250, Short.MAX_VALUE)
                        .addComponent(comboCarg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cabCodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboRang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(DNIField, 0, 250, Short.MAX_VALUE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabCodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trabajadorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5))
                .addComponent(DNIField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(comboRang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboCarg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(estRegField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Registro de Trabajador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel5.setBackground(new java.awt.Color(226, 226, 226));

        tablaCabecera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCabecera);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Tabla_Trabajador");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAdicionarCab.setText("Adicionar");
        btnAdicionarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCabActionPerformed(evt);
            }
        });

        btnInactivarCab.setText("Inactivar");
        btnInactivarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarCabActionPerformed(evt);
            }
        });

        btnModificarCab.setText("Modificar");
        btnModificarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCabActionPerformed(evt);
            }
        });

        btnReactivarCab.setText("Reactivar");
        btnReactivarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactivarCabActionPerformed(evt);
            }
        });

        btnEliminarCab.setText("Eliminar");
        btnEliminarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCabActionPerformed(evt);
            }
        });

        btnActualizarCab.setText("Actualizar");
        btnActualizarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCabActionPerformed(evt);
            }
        });

        btnCancelarCab.setText("Cancelar");
        btnCancelarCab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnInactivarCab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReactivarCab, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAdicionarCab, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarCab, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarCab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarCab, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelarCab, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarCab)
                    .addComponent(btnCancelarCab)
                    .addComponent(btnModificarCab)
                    .addComponent(btnAdicionarCab))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInactivarCab)
                    .addComponent(btnReactivarCab)
                    .addComponent(btnActualizarCab)
                    .addComponent(btnSalir))
                .addGap(30, 30, 30))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Trabajador");

 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            )
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        )
)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnAdicionarCabActionPerformed(java.awt.event.ActionEvent evt) {                                                
        activarFields();
        cabCodField.setEditable(true);
        estRegField.setEditable(false);
        estRegField.setText("A");
        //Flag Activada
        CarFlaAct = 1;
        //Reconociendo comando
        comandoActivo = 1;
    }                                               

    private void btnInactivarCabActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        btnActualizarCab.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 4;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            estRegField.setText("I");
            desactivarFields();
        }
    }                                               

    private void btnReactivarCabActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        btnActualizarCab.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 5;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            estRegField.setText("A");
            desactivarFields();
            
        }
    }                                               

    private void btnEliminarCabActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        btnActualizarCab.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 3;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            estRegField.setText("*");            
            desactivarFields();
        }
    }                                              

    private void btnActualizarCabActionPerformed(java.awt.event.ActionEvent evt) {                                                 
            String codigo = cabCodField.getText();
            String nombre = trabajadorField.getText();
            String DNI = DNIField.getText();
            String rango = String.valueOf(comboRang.getSelectedIndex()+1);
            String cargo = String.valueOf(comboCarg.getSelectedIndex()+1);
            String departamento = String.valueOf(comboDep.getSelectedIndex()+1);
            String estadoRegistro = estRegField.getText();

            if(CarFlaAct==1){
                try {
                    PreparedStatement stmt;
                    switch(comandoActivo) {      
                        case 1 -> { 
                            stmt = conn.prepareStatement("INSERT INTO R1M_TRABAJADOR (TraCod,TraNom,TraDni,RanCod,CarCod,DepCod,EstRegCod) VALUES (?,?,?,?,?,?,?)");
                            stmt.setString(1, codigo);
                            stmt.setString(2, nombre);
                            stmt.setString(3, DNI);
                            stmt.setString(4, rango);
                            stmt.setString(5, cargo);
                            stmt.setString(6, departamento);
                            stmt.setString(7, estadoRegistro);
                            stmt.executeUpdate();
                            //Agregando trabajadores al crear una charla
                            
                        }
                        default -> {
                            stmt = conn.prepareStatement("UPDATE R1M_TRABAJADOR SET EstRegCod = ? WHERE TraCod = ?");
                            stmt.setString(1, estadoRegistro);
                            stmt.setString(2,codigo);
                            stmt.executeUpdate();
                        }
                    }
                    
                    
                }catch(SQLException e) {
                    System.out.println("Error: "+e);
                }
                llenarTablaCabecera();
                CarFlaAct = 0;
                desactivarFields();
                comandoActivo = 0;
                estRegField.setText("");
            }
    }                                                

    private void btnCancelarCabActionPerformed(java.awt.event.ActionEvent evt) {                                               
        estRegField.setText("");
        cabCodField.setText("");
        switch(comandoActivo) {
            case 1 -> btnAdicionarCab.setEnabled(false);
            case 2 -> btnModificarCab.setEnabled(false);
            case 3 -> btnEliminarCab.setEnabled(false);
            case 4 -> btnInactivarCab.setEnabled(false);
            case 5 -> btnReactivarCab.setEnabled(false);           
        }
        if(comandoActivo==0) {
            btnAdicionarCab.setEnabled(true);
            btnModificarCab.setEnabled(true);
            btnEliminarCab.setEnabled(true);
            btnInactivarCab.setEnabled(true);
            btnReactivarCab.setEnabled(true);           
        }
        desactivarFields();
        comandoActivo = 0;
        //Cambiamos el flag a 0
        CarFlaAct = 0;
    }                                              

    private void btnModificarCabActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        if(filaSeleccionada != -1) {
            desactivarFields();
            comandoActivo = 2;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            cabCodField.setEditable(true);
            trabajadorField.setEditable(true);
            comboCarg.setEditable(true);
            DNIField.setEditable(true);
            comboDep.setEditable(true);
            comboRang.setEditable(true);
            estRegField.setEditable(true);
            String estReg = estRegField.getText();
            
            if(estReg.equals("I" )||estReg.equals("*"))
                btnActualizarCab.setEnabled(false);
            else
                btnActualizarCab.setEnabled(true);
            estRegField.setEditable(false);
        }
    }                                               

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
    }                                        

    private void cargarComboDe(String campo, String tabla) {
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM "+ tabla;
            ResultSet rs = statement.executeQuery(consulta);
            JComboBox<String> auxCombo = null;

            switch(tabla) {
                case "GZZ_CARGO" -> auxCombo=comboCarg;
                case "GZZ_RANGO" -> auxCombo=comboRang;
                case "GZZ_DEPARTAMENTO" -> auxCombo=comboDep;              
            }
            //Agregando los datos
            while(rs.next()) {
                String val = rs.getString(campo);
                auxCombo.addItem(val);
            }

        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }

    private void desactivarFields() {
        cabCodField.setEditable(false);
        trabajadorField.setEditable(false);
        DNIField.setEditable(false);
        comboCarg.setEditable(false);
        comboDep.setEditable(false);
        comboRang.setEditable(false);
        estRegField.setEditable(false);
    }
    
    private void activarFields() {
        cabCodField.setEditable(true);
        trabajadorField.setEditable(true);
        comboCarg.setEditable(true);
        DNIField.setEditable(true);
        comboDep.setEditable(true);
        comboRang.setEditable(true);
        estRegField.setEditable(true);
    }
    
    
    private void llenarTablaCabecera() {
        modelo.setColumnIdentifiers(new Object[]{"Codigo","Nombre","DNI","Rango","Cargo","Departamento","Estado Registro"});
        modelo.setRowCount(0);
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT TraCod,TraNom,TraDni,RanCod,CarCod,DepCod,EstRegCod FROM R1M_TRABAJADOR WHERE EstRegCod NOT IN('*')";
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modelo.addRow(new Object[]{rs.getString("TraCod"),rs.getString("TraNom"),rs.getString("TraDni"),rs.getString("RanCod"),rs.getString("CarCod"),rs.getString("DepCod"),rs.getString("EstRegCod")});
            }
            //Asigna Modelo a tabla
            tablaCabecera.setModel(modelo);
            
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }        
    }
   
    private void cargarDatos(int fila) {
        String codigo = (String) modelo.getValueAt(fila, 0);
        try {
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM R1M_TRABAJADOR WHERE TraCod="+codigo;
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()) {
                cabCodField.setText(codigo);
                trabajadorField.setText((String) modelo.getValueAt(fila,1));
                DNIField.setText((String) modelo.getValueAt(fila,2));
                comboCarg.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila, 4))-1);
                comboRang.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila, 3))-1);
                comboDep.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila, 5))-1);
                estRegField.setText((String) modelo.getValueAt(fila,6));
            }
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizarCab;
    private javax.swing.JButton btnAdicionarCab;
    private javax.swing.JButton btnCancelarCab;
    private javax.swing.JButton btnEliminarCab;
    private javax.swing.JButton btnInactivarCab;
    private javax.swing.JButton btnModificarCab;
    private javax.swing.JButton btnReactivarCab;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboCarg;
    private javax.swing.JComboBox<String> comboRang;
    private javax.swing.JComboBox<String> comboDep;
    private javax.swing.JTextField cabCodField;
    private javax.swing.JTextField trabajadorField;
    private javax.swing.JTextField DNIField;
    private javax.swing.JTextField estRegField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCabecera;
    private DefaultTableModel modelo = new DefaultTableModel();
}