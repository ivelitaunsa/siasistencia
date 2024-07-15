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


public class R2T_CONTROL_EPP_CAB extends javax.swing.JFrame {

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
    public R2T_CONTROL_EPP_CAB() {
        initComponents();
        desactivarFields();
        desactivarFieldsDesgaste();
        desactivarFieldsEntrega();
        llenarTablaCabecera();
        cargarComboDe("TraNom","R1M_TRABAJADOR",0);
        cargarComboDe("CarDes","GZZ_CARGO",0);
        cargarComboDe("EppNom","GZM_EPP",1);
        cargarComboDe("EppNom","GZM_EPP",2);
        tablaCabecera.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    int fila = tablaCabecera.getSelectedRow();
                    if(fila>=0) {
                        String codigo = (String) tablaCabecera.getValueAt(fila, 0);
                        llenarTablaDesgaste(codigo);
                        llenarTablaEntrega(codigo);
                    }
                }
            }
        });
    }
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cabCodField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboTrabajador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboEncargado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        estRegCab = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCabecera = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnCabSal = new javax.swing.JButton();
        btnCabAdi = new javax.swing.JButton();
        btnCabIna = new javax.swing.JButton();
        btnCabRea = new javax.swing.JButton();
        btnCabEli = new javax.swing.JButton();
        btnCabAct = new javax.swing.JButton();
        btnCabCan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        desSecField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        comboEppDes = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        estRegDes = new javax.swing.JTextField();
        devCheck = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        desCabField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDesgaste = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEntrega = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        entSecField = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        comboEppEnt = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        estRegEnt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        entCabField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btnDesAdi = new javax.swing.JButton();
        btnDesIna = new javax.swing.JButton();
        btnDesRea = new javax.swing.JButton();
        btnDesEli = new javax.swing.JButton();
        btnDesAct = new javax.swing.JButton();
        btnDesCan = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        btnEntAdi = new javax.swing.JButton();
        btnEntIna = new javax.swing.JButton();
        btnEntRea = new javax.swing.JButton();
        btnEntEli = new javax.swing.JButton();
        btnEntAct = new javax.swing.JButton();
        btnEntCan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CONTROL EPP");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("CONTROL EPP CABECERA");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));

        jLabel3.setText("Codigo:");

        jLabel14.setText("Trabajador:");

        jLabel4.setText("Encargado:");

        jLabel6.setText("Fecha:");

        dateChooser.setDateFormatString("dd-MM-yyyy");

        jLabel21.setText("Estado registro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel21))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cabCodField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboTrabajador, 0, 250, Short.MAX_VALUE)
                                .addComponent(comboEncargado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estRegCab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cabCodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(comboTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(estRegCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Registro Control Cabecera");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(490, 490, 490))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
        jLabel19.setText("Tabla_Control_Cabecera");

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

        btnCabSal.setText("Salir");
        btnCabSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabSalActionPerformed(evt);
            }
        });

        btnCabAdi.setText("Adicionar");
        btnCabAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabAdiActionPerformed(evt);
            }
        });

        btnCabIna.setText("Inactivar");
        btnCabIna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabInaActionPerformed(evt);
            }
        });

        btnCabRea.setText("Reactivar");
        btnCabRea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabReaActionPerformed(evt);
            }
        });

        btnCabEli.setText("Eliminar");
        btnCabEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabEliActionPerformed(evt);
            }
        });

        btnCabAct.setText("Actualizar");
        btnCabAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabActActionPerformed(evt);
            }
        });

        btnCabCan.setText("Cancelar");
        btnCabCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnCabAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCabRea, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCabEli, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCabCan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnCabIna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCabAct, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCabSal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCabEli)
                    .addComponent(btnCabCan)
                    .addComponent(btnCabAdi)
                    .addComponent(btnCabRea))
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCabIna)
                    .addComponent(btnCabAct)
                    .addComponent(btnCabSal))
                .addGap(29, 29, 29))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("CONTROL DESGASTE DETALLE");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("CONTROL ENTREGA DETALLE");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel7.setBackground(new java.awt.Color(229, 229, 229));

        jLabel9.setText("Secuencia:");

        jLabel17.setText("Epp:");

        jLabel10.setText("Devuelto:");

        jLabel24.setText("Estado registro:");

        jLabel5.setText("Cabecera:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboEppDes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desSecField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel24))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(devCheck))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(estRegDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(desCabField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(desCabField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desSecField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(comboEppDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(devCheck))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(estRegDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Registro Control Desgaste Detalle");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jPanel9.setBackground(new java.awt.Color(226, 226, 226));

        tablaDesgaste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDesgaste);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Tabla_Control_Desgaste_Detalle");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        jPanel13.setBackground(new java.awt.Color(226, 226, 226));

        tablaEntrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tablaEntrega);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Tabla_Control_Entrega_Detalle");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));

        jPanel15.setBackground(new java.awt.Color(229, 229, 229));

        jLabel11.setText("Secuencia");

        jLabel26.setText("Epp:");

        jLabel29.setText("Estado registro:");

        jLabel12.setText("Cabecera");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(entCabField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(entSecField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboEppEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(estRegEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(entCabField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entSecField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEppEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(estRegEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Registro Control Entrega Detalle");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));

        btnDesAdi.setText("Adicionar");
        btnDesAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesAdiActionPerformed(evt);
            }
        });

        btnDesIna.setText("Inactivar");
        btnDesIna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesInaActionPerformed(evt);
            }
        });

        btnDesRea.setText("Reactivar");
        btnDesRea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesReaActionPerformed(evt);
            }
        });

        btnDesEli.setText("Eliminar");
        btnDesEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesEliActionPerformed(evt);
            }
        });

        btnDesAct.setText("Actualizar");
        btnDesAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesActActionPerformed(evt);
            }
        });

        btnDesCan.setText("Cancelar");
        btnDesCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDesAct, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(btnDesAdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesIna, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesRea, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(btnDesCan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesEli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesEli)
                    .addComponent(btnDesAdi)
                    .addComponent(btnDesRea)
                    .addComponent(btnDesIna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesAct)
                    .addComponent(btnDesCan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(204, 204, 204));

        btnEntAdi.setText("Adicionar");
        btnEntAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntAdiActionPerformed(evt);
            }
        });

        btnEntIna.setText("Inactivar");
        btnEntIna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntInaActionPerformed(evt);
            }
        });

        btnEntRea.setText("Reactivar");
        btnEntRea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntReaActionPerformed(evt);
            }
        });

        btnEntEli.setText("Eliminar");
        btnEntEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntEliActionPerformed(evt);
            }
        });

        btnEntAct.setText("Actualizar");
        btnEntAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntActActionPerformed(evt);
            }
        });

        btnEntCan.setText("Cancelar");
        btnEntCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnEntAdi)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEntIna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntAct, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEntCan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntRea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntEli, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntEli)
                    .addComponent(btnEntAdi)
                    .addComponent(btnEntRea)
                    .addComponent(btnEntIna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntAct)
                    .addComponent(btnEntCan))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 627, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnCabSalActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    private void btnCabAdiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        activarFields();
        cabCodField.setEditable(false);
        estRegCab.setEditable(false);
        estRegCab.setText("A");
        //Flag Activada
        CarFlaAct = 1;
        //Reconociendo comando
        comandoActivo = 1;
    }                                         

    private void btnCabInaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        btnCabAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 4;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            estRegCab.setText("I");
            desactivarFields();
        }
    }                                         

    private void btnCabReaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        btnCabAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 5;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            estRegCab.setText("A");
            desactivarFields();
            
        }
    }                                         

    private void btnCabEliActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaCabecera.getSelectedRow();
        btnCabAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 3;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatos(filaSeleccionada);
            estRegCab.setText("*");            
            desactivarFields();
        }
    }                                         

    private void btnCabActActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
            
            String trabajador = String.valueOf(comboTrabajador.getSelectedIndex()+1);
            String encargado = String.valueOf(comboEncargado.getSelectedIndex()+1);
            String estadoRegistro = estRegCab.getText();
            try {
                PreparedStatement stmt;
                switch(comandoActivo) {      
                    case 1 -> { 
                        stmt = conn.prepareStatement("INSERT INTO R2T_CONTROL_EPP_CAB (ConCabNum,ConFecDia,ConFecMes,ConFecAnio,CarCod,TraCod,EstRegCod) VALUES (?,?,?,?,?,?,?)");
                        stmt.setString(1, codigo);
                        stmt.setString(2, fecDia);
                        stmt.setString(3, fecMes);
                        stmt.setString(4, fecAnio);
                        stmt.setString(5, encargado);
                        stmt.setString(6, trabajador);
                        stmt.setString(7, estadoRegistro);
                        stmt.executeUpdate();
                        
                    }
                    default -> {
                        stmt = conn.prepareStatement("UPDATE R2T_CONTROL_EPP_CAB SET EstRegCod = ? WHERE ConCabNum = ?");
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
            cabCodField.setText("");
            comandoActivo = 0;
            estRegCab.setText("");
        }
    }                                         

    private void btnCabCanActionPerformed(java.awt.event.ActionEvent evt) {                                          
        estRegCab.setText("");
        cabCodField.setText("");
        switch(comandoActivo) {
            case 1 -> btnCabAdi.setEnabled(false);
            case 3 -> btnCabEli.setEnabled(false);
            case 4 -> btnCabIna.setEnabled(false);
            case 5 -> btnCabRea.setEnabled(false);           
        }
        if(comandoActivo==0) {
            btnCabAdi.setEnabled(true);
            btnCabEli.setEnabled(true);
            btnCabIna.setEnabled(true);
            btnCabRea.setEnabled(true);           
        }
        desactivarFields();
        comandoActivo = 0;
        //Cambiamos el flag a 0
        CarFlaAct = 0;
    }                                         

    private void btnDesAdiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        activarFieldsDesgaste();
        estRegDes.setEditable(false);
        estRegDes.setText("A");
        //Flag Activada
        CarFlaAct = 1;
        //Reconociendo comando
        comandoActivo = 1;
        btnCabCan.setEnabled(false);
    }                                         

    private void btnDesInaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaDesgaste.getSelectedRow();
        btnDesAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 4;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDesgaste(filaSeleccionada);
            estRegDes.setText("I");
            desactivarFieldsDesgaste();
        }
        btnCabCan.setEnabled(false);
    }                                         

    private void btnDesReaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaDesgaste.getSelectedRow();
        btnDesAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 5;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDesgaste(filaSeleccionada);
            estRegDes.setText("A");
            desactivarFieldsDesgaste();
        }
        btnCabCan.setEnabled(false);
    }                                         

    private void btnDesEliActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaDesgaste.getSelectedRow();
        btnDesAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 3;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosDesgaste(filaSeleccionada);
            estRegDes.setText("*");
            desactivarFieldsDesgaste();
        }
        btnCabCan.setEnabled(false);
    }                                         

    private void btnDesActActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(CarFlaAct == 1) {    
            String cabecera = (String) desCabField.getText();
            String secuencia = desSecField.getText();
            int epp = comboEppDes.getSelectedIndex()+100+1;
            boolean checkbox = devCheck.isSelected();
            String estadoRegistro = estRegDes.getText();
            try {
                PreparedStatement stmt;
                switch(comandoActivo) {                              
                    case 1 -> { 
                        stmt = conn.prepareStatement("INSERT INTO R2T_CON_DESGASTE_DET (ConCabNum,DesDetSec,EppDev,EppCod,EstRegCod) VALUES (?,?,?,?,?)");
                        stmt.setString(1, cabecera);
                        stmt.setString(2, secuencia);
                        if(checkbox)
                            stmt.setString(3, "s");
                        else
                            stmt.setString(3, "n");
                        
                        stmt.setString(4, String.valueOf(epp));
                        stmt.setString(5, estadoRegistro);
                        stmt.executeUpdate();
                    }
                    default -> {
                        stmt = conn.prepareStatement("UPDATE R2T_CON_DESGASTE_DET SET EstRegCod=? WHERE ConCabNum=? AND DesDetSec=?");
                        stmt.setString(1, estadoRegistro);
                        stmt.setString(2,cabecera);
                        stmt.setString(3,secuencia);
                        stmt.executeUpdate();
                    }
                }
                
                
            }catch(SQLException e) {
                System.out.println("Error: "+e);
            }
            llenarTablaDesgaste(cabecera);
            CarFlaAct = 0;
            desactivarFieldsDesgaste();
            comandoActivo = 0;
            estRegDes.setText("");
            btnCabCan.setEnabled(true);
        }
    }                                         

    private void btnDesCanActionPerformed(java.awt.event.ActionEvent evt) {                                          
        desCabField.setText("");
        desSecField.setText("");
        estRegDes.setText("");
        switch(comandoActivo) {
            case 1 -> btnDesAdi.setEnabled(false);
            case 3 -> btnDesEli.setEnabled(false);
            case 4 -> btnDesIna.setEnabled(false);
            case 5 -> btnDesRea.setEnabled(false);           
        }
        if(comandoActivo==0) {
            btnDesAdi.setEnabled(true);
            btnDesEli.setEnabled(true);
            btnDesIna.setEnabled(true);
            btnDesRea.setEnabled(true);           
        }
        desactivarFieldsDesgaste();
        comandoActivo = 0;
        //Cambiamos el flag a 0
        CarFlaAct = 0;
        btnCabCan.setEnabled(true);
    }                                         

    private void btnEntAdiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        activarFieldsEntrega();
        estRegEnt.setEditable(false);
        estRegEnt.setText("A");
        //Flag Activada
        CarFlaAct = 1;
        //Reconociendo comando
        comandoActivo = 1;
        btnCabCan.setEnabled(false);
    }                                         

    private void btnEntInaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaEntrega.getSelectedRow();
        btnEntAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 4;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosEntrega(filaSeleccionada);
            estRegEnt.setText("I");
            desactivarFieldsEntrega();
        }
        btnCabCan.setEnabled(false);
    }                                         

    private void btnEntReaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaEntrega.getSelectedRow();
        btnEntAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 5;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosEntrega(filaSeleccionada);
            estRegEnt.setText("A");
            desactivarFieldsEntrega();
        }
        btnCabCan.setEnabled(false);
    }                                         

    private void btnEntEliActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int filaSeleccionada = tablaEntrega.getSelectedRow();
        btnEntAct.setEnabled(true);
        if(filaSeleccionada != -1) {
            comandoActivo = 3;    
            //Cambio de Flag
            CarFlaAct = 1;
            cargarDatosEntrega(filaSeleccionada);
            estRegEnt.setText("*");
            desactivarFieldsEntrega();
        }
        btnCabCan.setEnabled(false);
    }                                         

    private void btnEntActActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(CarFlaAct == 1) {    
            String cabecera = (String) entCabField.getText();
            String secuencia = entSecField.getText();
            int epp = comboEppEnt.getSelectedIndex()+100+1;
            String estadoRegistro = estRegEnt.getText();
            try {
                PreparedStatement stmt;
                switch(comandoActivo) {                              
                    case 1 -> { 
                        stmt = conn.prepareStatement("INSERT INTO R2T_CON_ENTREGA_DET (ConCabNum,EntDetSec,EppCod,EstRegCod) VALUES (?,?,?,?)");
                        stmt.setString(1, cabecera);
                        stmt.setString(2, secuencia);                        
                        stmt.setString(3, String.valueOf(epp));
                        stmt.setString(4, estadoRegistro);
                        stmt.executeUpdate();
                    }
                    default -> {
                        stmt = conn.prepareStatement("UPDATE R2T_CON_ENTREGA_DET SET EstRegCod=? WHERE ConCabNum=? AND EntDetSec=?");
                        stmt.setString(1, estadoRegistro);
                        stmt.setString(2,cabecera);
                        stmt.setString(3,secuencia);
                        stmt.executeUpdate();
                    }
                }
                
                
            }catch(SQLException e) {
                System.out.println("Error: "+e);
            }
            llenarTablaEntrega(cabecera);
            CarFlaAct = 0;
            desactivarFieldsEntrega();
            comandoActivo = 0;
            estRegEnt.setText("");
            btnCabCan.setEnabled(true);
        }
    }                                         

    private void btnEntCanActionPerformed(java.awt.event.ActionEvent evt) {                                          
        entCabField.setText("");
        entSecField.setText("");
        estRegEnt.setText("");
        switch(comandoActivo) {
            case 1 -> btnEntAdi.setEnabled(false);
            case 3 -> btnEntEli.setEnabled(false);
            case 4 -> btnEntIna.setEnabled(false);
            case 5 -> btnEntRea.setEnabled(false);           
        }
        if(comandoActivo==0) {
            btnEntAdi.setEnabled(true);
            btnEntEli.setEnabled(true);
            btnEntIna.setEnabled(true);
            btnEntRea.setEnabled(true);           
        }
        desactivarFieldsEntrega();
        comandoActivo = 0;
        //Cambiamos el flag a 0
        CarFlaAct = 0;
        btnCabCan.setEnabled(true);
    }                                         

    private void llenarTablaCabecera() {
        modelo.setColumnIdentifiers(new Object[]{"Codigo","Trabajador","Encargado","Estado Registro"});
        modelo.setRowCount(0);
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT ConCabNum,TraCod,CarCod,EstRegCod FROM R2T_CONTROL_EPP_CAB WHERE EstRegCod NOT IN('*')";
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modelo.addRow(new Object[]{rs.getString("ConCabNum"),rs.getString("TraCod"),rs.getString("CarCod"),rs.getString("EstRegCod")});
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
            String consulta = "SELECT * FROM R2T_CONTROL_EPP_CAB WHERE ConCabNum="+codigo;
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()) {
                cabCodField.setText(codigo);
                comboTrabajador.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila,1))-1);
                comboEncargado.setSelectedIndex(Integer.parseInt((String) modelo.getValueAt(fila,2))-1);
                estRegCab.setText((String) modelo.getValueAt(fila,3));
                
                Calendar calendario = Calendar.getInstance();
                calendario.set(Calendar.YEAR,Integer.parseInt(rs.getString("ConFecAnio")));
                calendario.set(Calendar.MONTH,Integer.parseInt(rs.getString("ConFecMes"))-1);
                calendario.set(Calendar.DAY_OF_MONTH,Integer.parseInt(rs.getString("ConFecDia")));
                Date fecha = calendario.getTime();
                dateChooser.setDate(fecha);
            }
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    private void llenarTablaDesgaste(String cod) {
        modeloDesgaste.setColumnIdentifiers(new Object[]{"Cabecera","Secuencia","Epp","Estado Registro"});
        modeloDesgaste.setRowCount(0);
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT ConCabNum,DesDetSec,EppCod,EstRegCod FROM R2T_CON_DESGASTE_DET WHERE EstRegCod NOT IN('*') AND ConCabNum="+cod;
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modeloDesgaste.addRow(new Object[]{rs.getString("ConCabNum"),rs.getString("DesDetSec"),rs.getString("EppCod"),rs.getString("EstRegCod")});
            }
            //Asigna Modelo a tabla
            tablaDesgaste.setModel(modeloDesgaste);
            
            
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
    
    private void cargarDatosDesgaste(int fila) {
        String cabecera = (String) modeloDesgaste.getValueAt(fila, 0);
        String secuencia = (String) modeloDesgaste.getValueAt(fila, 1);
        try {
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM R2T_CON_DESGASTE_DET WHERE ConCabNum="+cabecera+" AND DesDetSec="+secuencia;
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()) {
                desCabField.setText(cabecera);
                desSecField.setText(secuencia);
                comboEppDes.setSelectedIndex(Integer.parseInt((String) modeloDesgaste.getValueAt(fila, 2))-100-1);
                String marcado = rs.getString("EppDev");
                switch (marcado) {
                    case "s" -> devCheck.setSelected(true);
                    case "n" -> devCheck.setSelected(false);
                }
                estRegDes.setText((String) modeloDesgaste.getValueAt(fila,3));
            }
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }

        private void llenarTablaEntrega(String cod) {
        modeloEntrega.setColumnIdentifiers(new Object[]{"Cabecera","Secuencia","Epp","Estado Registro"});
        modeloEntrega.setRowCount(0);
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT ConCabNum,EntDetSec,EppCod,EstRegCod FROM R2T_CON_ENTREGA_DET WHERE EstRegCod NOT IN('*') AND ConCabNum="+cod;
            ResultSet rs = statement.executeQuery(consulta);
            
            //Agregando los datos
            while(rs.next()) {
                modeloEntrega.addRow(new Object[]{rs.getString("ConCabNum"),rs.getString("EntDetSec"),rs.getString("EppCod"),rs.getString("EstRegCod")});
            }
            //Asigna Modelo a tabla
            tablaEntrega.setModel(modeloEntrega);
            
            
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        } 
    }
    
    private void cargarDatosEntrega(int fila) {
        String cabecera = (String) modeloEntrega.getValueAt(fila, 0);
        String secuencia = (String) modeloEntrega.getValueAt(fila, 1);
         try {
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM R2T_CON_ENTREGA_DET WHERE ConCabNum="+cabecera+" AND EntDetSec="+secuencia;
            ResultSet rs = statement.executeQuery(consulta);
            while(rs.next()) {
                entCabField.setText(cabecera);
                entSecField.setText(secuencia);
                comboEppEnt.setSelectedIndex(Integer.parseInt((String) modeloDesgaste.getValueAt(fila, 2))-100-1);
                estRegDes.setText((String) modeloDesgaste.getValueAt(fila,3));
            }
        }catch(SQLException e) {
            System.out.println("Error: "+e);
        }
    }
    
    private void cargarComboDe(String campo, String tabla,int num) {
        try {
            //Consulta de selección
            Statement statement = conn.createStatement();
            String consulta = "SELECT * FROM "+ tabla;
            ResultSet rs = statement.executeQuery(consulta);
            
            JComboBox<String> auxCombo = null;
            
            switch(tabla) {
                case "R1M_TRABAJADOR" -> auxCombo=comboTrabajador;
                case "GZZ_CARGO" -> auxCombo=comboEncargado;
            }
            switch(num) {
                //0 -> Nothing
                case 1 -> auxCombo=comboEppDes;
                case 2 -> auxCombo=comboEppEnt;
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
        comboTrabajador.setEditable(false);
        comboEncargado.setEditable(false);
        estRegCab.setEditable(false);
    }
    
    private void activarFields() {
        cabCodField.setEditable(true);
        comboTrabajador.setEditable(true);
        comboEncargado.setEditable(true);
        estRegCab.setEditable(true);
    }
    
    private void desactivarFieldsDesgaste() {
        desCabField.setEditable(false);
        desSecField.setEditable(false);
        comboEppDes.setEditable(false);
        estRegDes.setEditable(false);
        devCheck.setEnabled(false);
    }
    
    private void activarFieldsDesgaste() {
        desCabField.setEditable(true);
        desSecField.setEditable(true);
        comboEppDes.setEditable(true);
        estRegDes.setEditable(true);
        devCheck.setEnabled(true);
    }
    
    private void desactivarFieldsEntrega() {
        entCabField.setEditable(false);
        entSecField.setEditable(false);
        comboEppEnt.setEditable(false);
        estRegEnt.setEditable(false);
    }
    
    private void activarFieldsEntrega() {
        entCabField.setEditable(true);
        entSecField.setEditable(true);
        comboEppEnt.setEditable(true);
        estRegEnt.setEditable(true);
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCabAct;
    private javax.swing.JButton btnCabAdi;
    private javax.swing.JButton btnCabCan;
    private javax.swing.JButton btnCabEli;
    private javax.swing.JButton btnCabIna;
    private javax.swing.JButton btnCabRea;
    private javax.swing.JButton btnCabSal;
    private javax.swing.JButton btnDesAct;
    private javax.swing.JButton btnDesAdi;
    private javax.swing.JButton btnDesCan;
    private javax.swing.JButton btnDesEli;
    private javax.swing.JButton btnDesIna;
    private javax.swing.JButton btnDesRea;
    private javax.swing.JButton btnEntAct;
    private javax.swing.JButton btnEntAdi;
    private javax.swing.JButton btnEntCan;
    private javax.swing.JButton btnEntEli;
    private javax.swing.JButton btnEntIna;
    private javax.swing.JButton btnEntRea;
    private javax.swing.JTextField cabCodField;
    private javax.swing.JComboBox<String> comboEncargado;
    private javax.swing.JComboBox<String> comboEppDes;
    private javax.swing.JComboBox<String> comboEppEnt;
    private javax.swing.JComboBox<String> comboTrabajador;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JTextField desCabField;
    private javax.swing.JTextField desSecField;
    private javax.swing.JCheckBox devCheck;
    private javax.swing.JTextField entCabField;
    private javax.swing.JTextField entSecField;
    private javax.swing.JTextField estRegCab;
    private javax.swing.JTextField estRegDes;
    private javax.swing.JTextField estRegEnt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaCabecera;
    private javax.swing.JTable tablaDesgaste;
    private javax.swing.JTable tablaEntrega;
    // End of variables declaration                   
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modeloDesgaste = new DefaultTableModel();
    private DefaultTableModel modeloEntrega = new DefaultTableModel();
}
