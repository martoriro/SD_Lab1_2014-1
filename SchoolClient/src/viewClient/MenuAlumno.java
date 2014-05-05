/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewClient;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import rmiClient.RmiConnection;

/**
 *
 * @author jorgef
 */
public class MenuAlumno extends javax.swing.JFrame {
    String rut;
    private static RmiConnection connection = new RmiConnection();
    
    /**
     * Creates new form MenuAlumno
     */
    public MenuAlumno(String user) throws RemoteException {
        initComponents();
        rut = user;
        txtBv.setText("BIENVENIDO(A) ALUMNO(A): " + connection.getServer().nombreApellido(rut).toUpperCase());
        ocultaVentanas();
        cbTipoAnotacion.addItem("Todas");
        cbTipoAnotacion.addItem("Positivas");
        cbTipoAnotacion.addItem("Negativas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        txtBv = new javax.swing.JLabel();
        jPAsignatura = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTable();
        txtProm = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVerNotas = new javax.swing.JButton();
        cbAsignaturas = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPPromedio = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPromedios = new javax.swing.JTable();
        txtPromGeneral = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JpAnotaciones = new javax.swing.JPanel();
        cbTipoAnotacion = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        contAnotacion = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaAnotaciones = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        bntVerAnotacion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtProfesor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JpMensajes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        contMensaje = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        bntVerMensaje = new javax.swing.JButton();
        cbAsunto = new javax.swing.JComboBox();
        cbFecha = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMisNotas = new javax.swing.JMenuItem();
        menuPromedioGeneral = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuMisAnotaciones = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuMensajes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido alumno");
        setLocationByPlatform(true);

        txtBv.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txtBv.setForeground(new java.awt.Color(0, 0, 153));
        txtBv.setText("BIENVENIDO(A) ALUMNO(A) : ");

        jPAsignatura.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Promedio:");

        jtNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Prueba", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtNotas);
        jtNotas.getColumnModel().getColumn(1).setMinWidth(50);
        jtNotas.getColumnModel().getColumn(1).setPreferredWidth(50);
        jtNotas.getColumnModel().getColumn(1).setMaxWidth(50);

        txtProm.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtProm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProm.setText("0.0");
        txtProm.setToolTipText("");
        txtProm.setInheritsPopupMenu(false);
        txtProm.setName(""); // NOI18N

        jLabel1.setText("Asignatura: ");

        btnVerNotas.setText("VER NOTAS");
        btnVerNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerNotasActionPerformed(evt);
            }
        });

        cbAsignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsignaturasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("MIS NOTAS POR ASIGNATURA");

        javax.swing.GroupLayout jPAsignaturaLayout = new javax.swing.GroupLayout(jPAsignatura);
        jPAsignatura.setLayout(jPAsignaturaLayout);
        jPAsignaturaLayout.setHorizontalGroup(
            jPAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAsignaturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAsignaturaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerNotas))
                    .addGroup(jPAsignaturaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtProm, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPAsignaturaLayout.setVerticalGroup(
            jPAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAsignaturaLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerNotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAsignaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPAsignaturaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProm, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jtPromedios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Asignatura", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtPromedios);
        jtPromedios.getColumnModel().getColumn(1).setMinWidth(70);
        jtPromedios.getColumnModel().getColumn(1).setPreferredWidth(70);
        jtPromedios.getColumnModel().getColumn(1).setMaxWidth(70);

        txtPromGeneral.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPromGeneral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPromGeneral.setText("0.0");
        txtPromGeneral.setToolTipText("");
        txtPromGeneral.setInheritsPopupMenu(false);
        txtPromGeneral.setName(""); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Promedio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("MI PROMEDIO GENERAL");

        javax.swing.GroupLayout jPPromedioLayout = new javax.swing.GroupLayout(jPPromedio);
        jPPromedio.setLayout(jPPromedioLayout);
        jPPromedioLayout.setHorizontalGroup(
            jPPromedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPromedioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPPromedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPPromedioLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPPromedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPromGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPromedioLayout.setVerticalGroup(
            jPPromedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPromedioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPPromedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPromedioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPromGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbTipoAnotacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbTipoAnotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoAnotacionActionPerformed(evt);
            }
        });

        btnFiltrar.setText("FILTRAR");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        contAnotacion.setEditable(false);
        contAnotacion.setColumns(20);
        contAnotacion.setRows(5);
        jScrollPane4.setViewportView(contAnotacion);

        jScrollPane5.setViewportView(listaAnotaciones);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ANOTACIONES");

        bntVerAnotacion.setText("VER");
        bntVerAnotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerAnotacionActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Anotación:");

        txtFecha.setEditable(false);

        txtProfesor.setEditable(false);

        jLabel11.setText("Fecha:");

        jLabel12.setText("Profesor:");

        javax.swing.GroupLayout JpAnotacionesLayout = new javax.swing.GroupLayout(JpAnotaciones);
        JpAnotaciones.setLayout(JpAnotacionesLayout);
        JpAnotacionesLayout.setHorizontalGroup(
            JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAnotacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpAnotacionesLayout.createSequentialGroup()
                        .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntVerAnotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(cbTipoAnotacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JpAnotacionesLayout.createSequentialGroup()
                                .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProfesor)
                                    .addComponent(txtFecha)))))
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        JpAnotacionesLayout.setVerticalGroup(
            JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpAnotacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoAnotacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(JpAnotacionesLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(bntVerAnotacion))
                    .addGroup(JpAnotacionesLayout.createSequentialGroup()
                        .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JpAnotacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contMensaje.setColumns(20);
        contMensaje.setRows(5);
        jScrollPane6.setViewportView(contMensaje);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("MENSAJES");

        bntVerMensaje.setText("VER");
        bntVerMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVerMensajeActionPerformed(evt);
            }
        });

        cbAsunto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAsuntoActionPerformed(evt);
            }
        });

        cbFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha:");

        jLabel10.setText("Asunto:");

        javax.swing.GroupLayout JpMensajesLayout = new javax.swing.GroupLayout(JpMensajes);
        JpMensajes.setLayout(JpMensajesLayout);
        JpMensajesLayout.setHorizontalGroup(
            JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMensajesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpMensajesLayout.createSequentialGroup()
                        .addGroup(JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpMensajesLayout.createSequentialGroup()
                                .addComponent(cbAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bntVerMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)))
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        JpMensajesLayout.setVerticalGroup(
            JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMensajesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(14, 14, 14)
                .addGroup(JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JpMensajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntVerMensaje)
                    .addComponent(cbAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jMenu1.setText("Notas");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuMisNotas.setText("Ver mis notas");
        menuMisNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMisNotasActionPerformed(evt);
            }
        });
        jMenu1.add(menuMisNotas);

        menuPromedioGeneral.setText("Promedio General");
        menuPromedioGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPromedioGeneralActionPerformed(evt);
            }
        });
        jMenu1.add(menuPromedioGeneral);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Anotaciones");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        menuMisAnotaciones.setText("Mis anotaciones");
        menuMisAnotaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMisAnotacionesActionPerformed(evt);
            }
        });
        jMenu2.add(menuMisAnotaciones);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Mensajes");

        menuMensajes.setText("Ver recibidos");
        menuMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMensajesActionPerformed(evt);
            }
        });
        jMenu3.add(menuMensajes);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Salir");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu4MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBv)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JpAnotaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JpMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBv)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPAsignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpAnotaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ocultaVentanas(){
        JpAnotaciones.setVisible(false);
        JpMensajes.setVisible(false);
        jPAsignatura.setVisible(false);
        jPPromedio.setVisible(false);        
    }
    
    private void menuMisNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMisNotasActionPerformed
        ocultaVentanas();
        cbAsignaturas.removeAllItems();
        try {            
            String [] ramos; 
            ramos = connection.getServer().verAsignaturas(rut);
            for(int i=0 ; i< ramos.length; i++){
                cbAsignaturas.addItem(ramos[i]);
            }
            jPAsignatura.setVisible(rootPaneCheckingEnabled);
            
        } catch (RemoteException ex) {
            Logger.getLogger(MenuAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menuMisNotasActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void menuMisAnotacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMisAnotacionesActionPerformed
        ocultaVentanas();
        listaAnotaciones.removeAll();
        contAnotacion.setText("");
        JpAnotaciones.setVisible(rootPaneCheckingEnabled);
        
    }//GEN-LAST:event_menuMisAnotacionesActionPerformed

    private void menuMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMensajesActionPerformed
        ocultaVentanas();
        JpMensajes.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_menuMensajesActionPerformed

    private void menuPromedioGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPromedioGeneralActionPerformed
        ocultaVentanas();
        jPPromedio.setVisible(rootPaneCheckingEnabled);
        try {
            String asignaturas[][] =  connection.getServer().asignaturaPromedioAlumno(rut);
            if(asignaturas[0].length>0){
                DefaultTableModel model = (DefaultTableModel) jtPromedios.getModel();
                model.setRowCount(0);
                String aux[] = new String[2];
                
                for(int i = 0; i< asignaturas[0].length; i++){
                    aux[0]= asignaturas[0][i];
                    aux[1]= asignaturas[1][i];
                    model.addRow(aux);
                }
                jtPromedios.setModel(model);
                txtPromGeneral.setText(connection.getServer().promedioGeneralAlumno(rut)+"");
            }else{
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MenuAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_menuPromedioGeneralActionPerformed

    private void cbAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsignaturasActionPerformed
        ocultaVentanas();
        jPAsignatura.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_cbAsignaturasActionPerformed

    private void btnVerNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerNotasActionPerformed
        String asignatura = (String)cbAsignaturas.getSelectedItem();
        try {
            String aux[] = connection.getServer().verNotas(rut, asignatura);
            int cant  = aux.length;
            Object[] fila = new Object[2];
            DefaultTableModel model = (DefaultTableModel) jtNotas.getModel();
            model.setRowCount(0);
            for(int i = 0; i< cant; i++){
                fila[0] = aux[i].split("/")[0];
                fila[1] = aux[i].split("/")[1];
                model.addRow(fila);
            }
            jtNotas.setModel(model);
            txtProm.setText(connection.getServer().calculaPromedioAsignatura(asignatura, rut)+"");
        } catch (RemoteException ex) {
            Logger.getLogger(alumnoMisNotas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnVerNotasActionPerformed

    private void cbTipoAnotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoAnotacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoAnotacionActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String tipoAnotacion = (String)cbTipoAnotacion.getSelectedItem();
        listaAnotaciones.removeAll();
        contAnotacion.setText("");
        txtProfesor.setText("");
        txtFecha.setText("");
        String[] anotaciones;
        try{
            if(tipoAnotacion.equals("Todas")){
                DefaultListModel modelo1 = new DefaultListModel();
                anotaciones = connection.getServer().anotacionesTodas(rut);
                for(int i = 0 ; i< anotaciones.length; i++){
                    modelo1.addElement(anotaciones[i]);
                }
                listaAnotaciones.setModel(modelo1);
            }if(tipoAnotacion.equals("Positivas")){
                DefaultListModel modelo2 = new DefaultListModel();
                anotaciones = connection.getServer().filtraAnotaciones(rut, "positiva");
                for(int i = 0 ; i< anotaciones.length; i++){
                    modelo2.addElement(anotaciones[i]);
                }
                listaAnotaciones.setModel(modelo2);
            }if(tipoAnotacion.equals("Negativas")){
                DefaultListModel modelo3 = new DefaultListModel();
                anotaciones = connection.getServer().filtraAnotaciones(rut, "negativa");
                for(int i = 0 ; i< anotaciones.length; i++){
                    modelo3.addElement(anotaciones[i]);
                }
                listaAnotaciones.setModel(modelo3);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MenuAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void bntVerAnotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerAnotacionActionPerformed
        int idAnotacion = Integer.parseInt(listaAnotaciones.getSelectedValue()+"");
        try {
            String anotacion[] = connection.getServer().miAnotacion(idAnotacion);
            txtFecha.setText(anotacion[0]);
            txtProfesor.setText(anotacion[1]);                   
            contAnotacion.setText(anotacion[2]);
        } catch (RemoteException ex) {
            Logger.getLogger(MenuAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bntVerAnotacionActionPerformed

    private void cbAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAsuntoActionPerformed

    private void bntVerMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVerMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntVerMensajeActionPerformed

    private void cbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFechaActionPerformed

    private void jMenu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MousePressed
        System.exit(0);
    }//GEN-LAST:event_jMenu4MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpAnotaciones;
    private javax.swing.JPanel JpMensajes;
    private javax.swing.JButton bntVerAnotacion;
    private javax.swing.JButton bntVerMensaje;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnVerNotas;
    private javax.swing.JComboBox cbAsignaturas;
    private javax.swing.JComboBox cbAsunto;
    private javax.swing.JComboBox cbFecha;
    private javax.swing.JComboBox cbTipoAnotacion;
    private javax.swing.JTextArea contAnotacion;
    private javax.swing.JTextArea contMensaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPAsignatura;
    private javax.swing.JPanel jPPromedio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jtNotas;
    private javax.swing.JTable jtPromedios;
    private javax.swing.JList listaAnotaciones;
    private javax.swing.JMenuItem menuMensajes;
    private javax.swing.JMenuItem menuMisAnotaciones;
    private javax.swing.JMenuItem menuMisNotas;
    private javax.swing.JMenuItem menuPromedioGeneral;
    private javax.swing.JLabel txtBv;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtProfesor;
    private javax.swing.JLabel txtProm;
    private javax.swing.JLabel txtPromGeneral;
    // End of variables declaration//GEN-END:variables
}
