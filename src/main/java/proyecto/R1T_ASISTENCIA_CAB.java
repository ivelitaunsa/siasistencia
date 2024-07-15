package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class R1T_ASISTENCIA_CAB extends javax.swing.JFrame {

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
    
    public R1T_ASISTENCIA_CAB() {
        initComponents();
        desactivarFields();
        llenarTablaCabecera();
        cargarComboDe("ChaTem","R1Z_CHARLA");
        cargarComboDe("DiaDes","GZZ_DIA");
        cargarComboDe("CarDes","GZZ_CARGO");
        cargarComboDe("EstAsiDes","GZZ_EST_ASISTENCIA");
        tablaCabecera.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    int fila = tablaCabecera.getSelectedRow();
                    if(fila>=0) {
                        String codigo = (String) tablaCabecera.getValueAt(fila, 0);
                        llenarTablaDetalle(codigo);
                    }
                }
            }
        });
    }
                      
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cabCodField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboCharla = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboExp = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        minField = new javax.swing.JTextField();
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
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        secuenciaField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        estRegDetField = new javax.swing.JTextField();
        comboAsistencia = new javax.swing.JComboBox<>();
        nombreField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnInactivarDet = new javax.swing.JButton();
        btnModificarDet = new javax.swing.JButton();
        btnReactivarDet = new javax.swing.JButton();
        btnEliminarDet = new javax.swing.JButton();
        btnActualizarDet = new javax.swing.JButton();
        btnCancelarDet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ASISTENCIA DETALLE");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(226, 226, 226));

        jLabel3.setText("Codigo:");

        jLabel4.setText("Tema:");

        jLabel5.setText("Dia:");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Expositor:");

        dateChooser.setDateFormatString("dd-MM-yyyy");

        jLabel9.setText("Minutos:");

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
                    .addComponent(minField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboCharla, 0, 250, Short.MAX_VALUE)
                        .addComponent(comboExp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cabCodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(comboCharla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(minField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(estRegField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Registro de Asistencia Cabecera");

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
        jLabel19.setText("Tabla_Asistencia_Cabecera");

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
        jLabel11.setText("ASISTENCIA CABECERA");

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalle);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Tabla_Asistencia_Detalle");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel8.setBackground(new java.awt.Color(226, 226, 226));

        jLabel13.setText("Secuencia:");

        nombreLabel.setText("Nombre:");

        jLabel17.setText("Estado:");

        jLabel21.setText("Estado registro:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(nombreLabel)
                            .addComponent(jLabel17))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secuenciaField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreField)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(estRegDetField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(secuenciaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comboAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(estRegDetField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Registro de Asistencia Detalle");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        btnInactivarDet.setText("Inactivar");
        btnInactivarDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarDetActionPerformed(evt);
            }
        });

        btnModificarDet.setText("Modificar");
        btnModificarDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDetActionPerformed(evt);
            }
        });

        btnReactivarDet.setText("Reactivar");
        btnReactivarDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactivarDetActionPerformed(evt);
            }
        });

        btnEliminarDet.setText("Eliminar");
        btnEliminarDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetActionPerformed(evt);
            }
        });

        btnActualizarDet.setText("Actualizar");
        btnActualizarDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDetActionPerformed(evt);
            }
        });

        btnCancelarDet.setText("Cancelar");
        btnCancelarDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(btnInactivarDet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReactivarDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarDet, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarDet, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarDet)
                    .addComponent(btnModificarDet)
                    .addComponent(btnInactivarDet)
                    .addComponent(btnCancelarDet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReactivarDet)
                    .addComponent(btnActualizarDet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1))
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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnAdicionarCabActionPerformed(java.awt.event.ActionEvent evt) {                                                
        activarFields();
        cabCodField.setEditable(false);
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
        if(CarFlaAct == 1) {
                
            Date FechaSeleccionada = dateChooser.getDate();
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(FechaSeleccionada);
            String fecDia=null;String fecMes=null;String fecAnio=null;String codigo;
            if(cabCodField.getText().equals("")) {
                fecAnio =  String.valueOf(calendario.get(Calendar.YEAR));
                fecMes = String.valueOf(calendario.get(Calendar.MONTH)+1);
                fecDia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
                codigo = fecAnio+fecMes+fecDia;
            } else {
               codigo = cabCodField.getText();
            }
            String tema = String.valueOf(comboCharla.getSelectedIndex()+1);
            String dia = String.valueOf(comboDia.getSelectedIndex()+1);
            String expositor = String.valueOf(comboExp.getSelectedIndex()+1);
            String cantidad = "0";
            String minutos = minField.getText();
            String estadoRegistro = estRegField.getText();
            try {
                PreparedStatement stmt;
                switch(comandoActivo) {      
                    case 1 -> { 
                        stmt = conn.prepareStatement("INSERT INTO R1T_ASISTENCIA_CAB (AsiCabcod,AsiCabFecDia,AsiCabFecMes,AsiCabFecAnio,AsiCabCan,AsiCabMin,ChaNum,DiaNum,CarCod,EstRegCod) VALUES (?,?,?,?,?,?,?,?,?,?)");
                        stmt.setString(1, codigo);
                        stmt.setString(2, fecDia);
                        stmt.setString(3, fecMes);
                        stmt.setString(4, fecAnio);
                        stmt.setString(5, cantidad);
                        stmt.setString(6, minutos);
                        stmt.setString(7, tema);
                        stmt.setString(8, dia);
                        stmt.setString(9, expositor);
                        stmt.setString(10, estadoRegistro);
                        stmt.executeUpdate();
                        //Agregando trabajadores al crear una charla
                        crearDetalles(codigo);
                        
                    }
                    case 2 -> { 
                        stmt = conn.prepareStatement("UPDATE R1T_ASISTENCIA_CAB SET AsiCabMin = ? WHERE AsiCabCod = ?");
                        stmt.setString(1, minutos);
                        stmt.setString(2, codigo);
                        stmt.executeUpdate();
                    }
                    default -> {
                        stmt = conn.prepareStatement("UPDATE R1T_ASISTENCIA_CAB SET EstRegCod = ? WHERE AsiCabCod = ?");
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
        minField.setText("");
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
            minField.setEditable(true);
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

    private void btnInactivarDetActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int filaSeleccionada = tablaDetalle.getSelectedRow();
        btnActualizarDet.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 4;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDetalle(filaSeleccionada);
            estRegDetField.setText("I");
            desactivarFieldsDetalle();
        }
        btnCancelarCab.setEnabled(false);
    }                                               

    private void btnModificarDetActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int filaSeleccionada = tablaDetalle.getSelectedRow();
        if(filaSeleccionada != -1) {
            desactivarFieldsDetalle();
            comandoActivo = 2;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDetalle(filaSeleccionada);
            comboAsistencia.setEditable(true);
            String estReg = estRegDetField.getText();
            
            if(estReg.equals("I" )||estReg.equals("*"))
                btnActualizarDet.setEnabled(false);
            else
                btnActualizarDet.setEnabled(true);
            estRegField.setEditable(false);
        }
    }                                               

    private void btnReactivarDetActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int filaSeleccionada = tablaDetalle.getSelectedRow();
        btnActualizarDet.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 5;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDetalle(filaSeleccionada);
            estRegDetField.setText("A");
            desactivarFieldsDetalle();
        }
        btnCancelarCab.setEnabled(false);        
    }                                               

    private void btnEliminarDetActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int filaSeleccionada = tablaDetalle.getSelectedRow();
        btnActualizarDet.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 3;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDetalle(filaSeleccionada);
            estRegDetField.setText("*");            
            desactivarFields();
        }
        btnCancelarCab.setEnabled(false);     
    }                                              

    private void btnActualizarDetActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if(CarFlaAct == 1) {    
            String cabecera = (String) modeloDetalle.getValueAt(1, 0);
            String secuencia = secuenciaField.getText();
            String estAsistencia = String.valueOf(comboAsistencia.getSelectedIndex());
            String estadoRegistro = estRegDetField.getText();
            try {
                PreparedStatement stmt;
                switch(comandoActivo) {                              
                    case 2 -> { 
                        stmt = conn.prepareStatement("UPDATE R1T_ASISTENCIA_DET SET EstAsiCod=? WHERE AsiCabCod=? AND AsiDetSec=?");
                        stmt.setString(1,estAsistencia);
                        stmt.setString(2,cabecera);
                        stmt.setString(3, secuencia);
                        stmt.executeUpdate();
                    }
                    default -> {
                        stmt = conn.prepareStatement("UPDATE R1T_ASISTENCIA_DET SET EstRegCod=? WHERE AsiCabCod=? AND AsiDetSec=?");
                        stmt.setString(1, estadoRegistro);
                        stmt.setString(2,cabecera);
                        stmt.setString(3,secuencia);
                        stmt.executeUpdate();
                    }
                }
                
                
            }catch(SQLException e) {
                System.out.println("Error: "+e);
            }
            llenarTablaDetalle(cabecera);
            CarFlaAct = 0;
            desactivarFieldsDetalle();
            comandoActivo = 0;
            estRegDetField.setText("");
            btnCancelarCab.setEnabled(true);
        }
    }                                                

    private void btnCancelarDetActionPerformed(java.awt.event.ActionEvent evt) {                                               
        secuenciaField.setText("");
        estRegDetField.setText("");
        switch(comandoActivo) {
            case 2 -> btnModificarDet.setEnabled(false);
            case 3 -> btnEliminarDet.setEnabled(false);
            case 4 -> btnInactivarDet.setEnabled(false);
            case 5 -> btnReactivarDet.setEnabled(false);           
        }
        if(comandoActivo==0) {
            btnModificarDet.setEnabled(true);
            btnEliminarDet.setEnabled(true);
            btnInactivarDet.setEnabled(true);
            btnReactivarDet.setEnabled(true);           
        }
        desactivarFieldsDetalle();
        comandoActivo = 0;
        //Cambiamos el flag a 0
        CarFlaAct = 0;
        btnCancelarCab.setEnabled(true);
    }                                              

    private void cargarComboDe(String campo, String tabla) {
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM "+ tabla;
            ResultSet rs = statement.executeQuery(consulta);
            
            JComboBox<String> auxCombo = null;
            
            switch(tabla) {
                case "R1Z_CHARLA" -> auxCombo=comboCharla;
                case "GZZ_DIA" -> auxCombo=comboDia;
                case "GZZ_CARGO" -> auxCombo=comboExp;
                case "GZZ_EST_ASISTENCIA" -> auxCombo=comboAsistencia;
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
        comboCharla.setEditable(false);
        comboDia.setEditable(false);
        comboExp.setEditable(false);
        estRegField.setEditable(false);
        minField.setEditable(false);
    }
    
    private void activarFields() {
        cabCodField.setEditable(true);
        comboCharla.setEditable(true);
        comboDia.setEditable(true);
        comboExp.setEditable(true);
        estRegField.setEditable(true);
        minField.setEditable(true);
    }
    
    private void desactivarFieldsDetalle() {
        secuenciaField.setEditable(false);
        comboAsistencia.setEditable(false);
        estRegDetField.setEditable(false);
        nombreField.setEditable(false);
    }
    
    private void crearDetalles(String cod) {
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT TraCod FROM R1M_TRABAJADOR WHERE EstRegCod='A'";
            ResultSet rs = statement.executeQuery(consulta);
            int cont = 1;
            //Agregando los datos
            while(rs.next()) {
                PreparedStatement stmt;
                stmt = conn.prepareStatement("INSERT INTO R1T_ASISTENCIA_DET (AsiDetSec,AsiCabCod,TraCod,EstAsiCod,EstRegCod) VALUES (?,?,?,?,?)");
                stmt.setInt(1, cont);
                stmt.setString(2,cod);
                stmt.setString(3,rs.getString("TraCod"));
                stmt.setString(4,"0");
                stmt.setString(5,"A");
                stmt.executeUpdate();
                cont++;
            }

        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }  
    }
    
    private void llenarTablaCabecera() {
        modelo.setColumnIdentifiers(new Object[]{"Codigo","Dia","Tema","Expositor","Estado Registro"});
        modelo.setRowCount(0);
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT AsiCabCod,DiaNum,ChaNum,CarCod,EstRegCod FROM R1T_ASISTENCIA_CAB WHERE EstRegCod NOT IN('*')";
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modelo.addRow(new Object[]{rs.getString("AsiCabCod"),rs.getString("DiaNum"),rs.getString("ChaNum"),rs.getString("CarCod"),rs.getString("EstRegCod")});
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
            String consulta = "SELECT * FROM R1T_ASISTENCIA_CAB WHERE AsiCabCod="+codigo;
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()) {
                cabCodField.setText(codigo);
                comboDia.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila,1))-1);
                comboCharla.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila,2))-1);
                comboExp.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila, 3))-1);
                minField.setText(rs.getString("AsiCabMin"));
                estRegField.setText((String) modelo.getValueAt(fila,4));
                
                Calendar calendario = Calendar.getInstance();
                calendario.set(Calendar.YEAR,Integer.parseInt(rs.getString("AsiCabFecAnio")));
                calendario.set(Calendar.MONTH,Integer.parseInt(rs.getString("AsiCabFecMes"))-1);
                calendario.set(Calendar.DAY_OF_MONTH,Integer.parseInt(rs.getString("AsiCabFecDia")));
                Date fecha = calendario.getTime();
                dateChooser.setDate(fecha);
            }
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    private void llenarTablaDetalle(String cod) {
        modeloDetalle.setColumnIdentifiers(new Object[]{"Cabecera","Secuencia","Trabajador","Estado Asistencia","Estado Registro"});
        modeloDetalle.setRowCount(0);
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT AsiCabCod,AsiDetSec,TraCod,EstAsiCod,EstRegCod FROM R1T_ASISTENCIA_DET WHERE EstRegCod NOT IN('*') AND AsiCabCod="+cod;
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modeloDetalle.addRow(new Object[]{rs.getString("AsiCabCod"),rs.getString("AsiDetSec"),rs.getString("TraCod"),rs.getString("EstAsiCod"),rs.getString("EstRegCod")});
            }
            //Asigna Modelo a tabla
            tablaDetalle.setModel(modeloDetalle);
            
            
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
    
    private void cargarDatosDetalle(int fila) {
        String cabecera = (String) modeloDetalle.getValueAt(fila, 0);
        String secuencia = (String) modeloDetalle.getValueAt(fila, 1);
        String trabajador = (String) modeloDetalle.getValueAt(fila, 2);
        try {
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM R1T_ASISTENCIA_DET WHERE AsiCabCod="+cabecera+" AND AsiDetSec="+secuencia;
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()) {
                secuenciaField.setText(secuencia);
                
                //Cargar datos trabajador
                Statement statement1 = conn.createStatement();
                String consulta1 = "SELECT * FROM R1M_TRABAJADOR WHERE TraCod="+trabajador;
                ResultSet rs1 = statement1.executeQuery(consulta1);
                while(rs1.next()) {
                    nombreField.setText(rs1.getString("TraNom"));
                }
                comboAsistencia.setSelectedIndex(Integer.parseInt((String) modeloDetalle.getValueAt(fila, 3)));
                estRegDetField.setText((String) modeloDetalle.getValueAt(fila,4));
            }
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizarCab;
    private javax.swing.JButton btnActualizarDet;
    private javax.swing.JButton btnAdicionarCab;
    private javax.swing.JButton btnCancelarCab;
    private javax.swing.JButton btnCancelarDet;
    private javax.swing.JButton btnEliminarCab;
    private javax.swing.JButton btnEliminarDet;
    private javax.swing.JButton btnInactivarCab;
    private javax.swing.JButton btnInactivarDet;
    private javax.swing.JButton btnModificarCab;
    private javax.swing.JButton btnModificarDet;
    private javax.swing.JButton btnReactivarCab;
    private javax.swing.JButton btnReactivarDet;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField cabCodField;
    private javax.swing.JComboBox<String> comboAsistencia;
    private javax.swing.JComboBox<String> comboCharla;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboExp;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTextField estRegDetField;
    private javax.swing.JTextField estRegField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField minField;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField secuenciaField;
    private javax.swing.JTable tablaCabecera;
    private javax.swing.JTable tablaDetalle;
    // End of variables declaration                   
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modeloDetalle = new DefaultTableModel();
}
