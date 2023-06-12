
import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFRegionUtil;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFBorderFormatting;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jona
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();

        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {

        }

        diseño_Botones();

        this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

        // this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(Admin.this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

        this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla

    }

    public void diseño_Botones() {//hara unos arreglos a todos los botones, quitar bordes, que deje solo la imagen
    
        Boton_inicio.setOpaque(false);
        Boton_inicio.setContentAreaFilled(false);
        Boton_inicio.setBorderPainted(false);

        Boton_cambiarClave.setOpaque(false);
        Boton_cambiarClave.setContentAreaFilled(false);
        Boton_cambiarClave.setBorderPainted(false);

        BotonEnviar_Excel.setOpaque(false);
        BotonEnviar_Excel.setContentAreaFilled(false);
        BotonEnviar_Excel.setBorderPainted(false);

        BotonCambiar_Correodestino.setOpaque(false);
        BotonCambiar_Correodestino.setContentAreaFilled(false);
        BotonCambiar_Correodestino.setBorderPainted(false);

        BotonCambiar_Correoclave.setOpaque(false);
        BotonCambiar_Correoclave.setContentAreaFilled(false);
        BotonCambiar_Correoclave.setBorderPainted(false);

        boton_atras.setOpaque(false);
        boton_atras.setContentAreaFilled(false);
        boton_atras.setBorderPainted(false);

        BotonGenerar_codigo.setOpaque(false);
        BotonGenerar_codigo.setContentAreaFilled(false);
        BotonGenerar_codigo.setBorderPainted(false);

        Boton_alarma.setOpaque(false);
        Boton_alarma.setContentAreaFilled(false);
        Boton_alarma.setBorderPainted(false);

        boton_RestaurarExcel.setOpaque(false);
        boton_RestaurarExcel.setContentAreaFilled(false);
        boton_RestaurarExcel.setBorderPainted(false);
        
    
        
        BarraProgreso_RestaurarExcel.setVisible(false);//para hacer la barra invisible
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        Boton_inicio = new javax.swing.JButton();
        Boton_cambiarClave = new javax.swing.JButton();
        BotonEnviar_Excel = new javax.swing.JButton();
        BotonCambiar_Correodestino = new javax.swing.JButton();
        BotonCambiar_Correoclave = new javax.swing.JButton();
        boton_atras = new javax.swing.JButton();
        BotonGenerar_codigo = new javax.swing.JButton();
        Boton_alarma = new javax.swing.JButton();
        boton_RestaurarExcel = new javax.swing.JButton();
        BarraProgreso_RestaurarExcel = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1280, 720));

        Boton_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IRIS_inicio.png"))); // NOI18N
        Boton_inicio.setActionCommand("Boton_inicio");
        Boton_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_inicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IRIS_inicio2.png"))); // NOI18N
        Boton_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_inicioActionPerformed(evt);
            }
        });

        Boton_cambiarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cambiarclave.png"))); // NOI18N
        Boton_cambiarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_cambiarClave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cambiarclave2.png"))); // NOI18N
        Boton_cambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_cambiarClaveActionPerformed(evt);
            }
        });

        BotonEnviar_Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EnviarExcel.png"))); // NOI18N
        BotonEnviar_Excel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEnviar_Excel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EnviarExcel2.png"))); // NOI18N
        BotonEnviar_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviar_ExcelActionPerformed(evt);
            }
        });

        BotonCambiar_Correodestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Correo_destino.png"))); // NOI18N
        BotonCambiar_Correodestino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCambiar_Correodestino.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Correo_destino2.png"))); // NOI18N
        BotonCambiar_Correodestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCambiar_CorreodestinoActionPerformed(evt);
            }
        });

        BotonCambiar_Correoclave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Correo_remitente.png"))); // NOI18N
        BotonCambiar_Correoclave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCambiar_Correoclave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Correo_remitente2.png"))); // NOI18N
        BotonCambiar_Correoclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCambiar_CorreoclaveActionPerformed(evt);
            }
        });

        boton_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        boton_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_atras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras2.png"))); // NOI18N
        boton_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_atrasActionPerformed(evt);
            }
        });

        BotonGenerar_codigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generarCodigo.png"))); // NOI18N
        BotonGenerar_codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonGenerar_codigo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generarCodigo2.png"))); // NOI18N
        BotonGenerar_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerar_codigoActionPerformed(evt);
            }
        });

        Boton_alarma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alarma.png"))); // NOI18N
        Boton_alarma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_alarma.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Alarma2.png"))); // NOI18N
        Boton_alarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_alarmaActionPerformed(evt);
            }
        });

        boton_RestaurarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RestaurarExcel.png"))); // NOI18N
        boton_RestaurarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton_RestaurarExcel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RestaurarExcel2.png"))); // NOI18N
        boton_RestaurarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_RestaurarExcelActionPerformed(evt);
            }
        });

        BarraProgreso_RestaurarExcel.setForeground(new java.awt.Color(255, 51, 204));

        jMenu1.setText("Productos");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar-Menu.png"))); // NOI18N
        jMenuItem1.setText("Agregar");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editar_Menu.png"))); // NOI18N
        jMenuItem2.setText("Editar");
        jMenuItem2.setToolTipText("");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CambiarAlarma-Menu.png"))); // NOI18N
        jMenuItem3.setText("Cambiar alarma");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarProducto-Menu.png"))); // NOI18N
        jMenuItem4.setText("Eliminar");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarCliente-Menu.png"))); // NOI18N
        jMenuItem6.setText("Agregar");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editarcliente-Menu.png"))); // NOI18N
        jMenuItem5.setText("Editar");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarCliente-Menu.png"))); // NOI18N
        jMenuItem7.setText("Eliminar");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonGenerar_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                        .addComponent(BarraProgreso_RestaurarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_alarma, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonEnviar_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(275, 275, 275)
                                    .addComponent(Boton_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Boton_cambiarClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotonCambiar_Correoclave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonCambiar_Correodestino, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_RestaurarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonGenerar_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonCambiar_Correoclave, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonCambiar_Correodestino, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(boton_RestaurarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(Boton_cambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonEnviar_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_alarma, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(BarraProgreso_RestaurarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_inicioActionPerformed

        Inicio inicio = new Inicio();
        inicio.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        inicio.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton_Inicio.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual
    }//GEN-LAST:event_Boton_inicioActionPerformed

    private void Boton_cambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_cambiarClaveActionPerformed

        CambiarClave cambiarclave = new CambiarClave();
        cambiarclave.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        cambiarclave.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual   
    }//GEN-LAST:event_Boton_cambiarClaveActionPerformed

    private void BotonEnviar_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviar_ExcelActionPerformed

        EnviarExcel enviarexcel = new EnviarExcel();
        enviarexcel.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        enviarexcel.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual         

    }//GEN-LAST:event_BotonEnviar_ExcelActionPerformed

    private void BotonCambiar_CorreodestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambiar_CorreodestinoActionPerformed

        Cambiar_Correodestino cambiar_correodestino = new Cambiar_Correodestino();
        cambiar_correodestino.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        cambiar_correodestino.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual    
    }//GEN-LAST:event_BotonCambiar_CorreodestinoActionPerformed

    private void boton_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_atrasActionPerformed

        Ingreso ingreso = new Ingreso();
        ingreso.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        ingreso.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual
    }//GEN-LAST:event_boton_atrasActionPerformed

    private void BotonCambiar_CorreoclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCambiar_CorreoclaveActionPerformed

        Cambiar_Correoremitente cambiar_correoclave = new Cambiar_Correoremitente();
        cambiar_correoclave.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        cambiar_correoclave.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual    
    }//GEN-LAST:event_BotonCambiar_CorreoclaveActionPerformed

    private void BotonGenerar_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerar_codigoActionPerformed

        GenerarCodigo generarcodigo = new GenerarCodigo();
        generarcodigo.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        generarcodigo.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual
    }//GEN-LAST:event_BotonGenerar_codigoActionPerformed

    private void Boton_alarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_alarmaActionPerformed

        Alarma alarma = new Alarma();
        alarma.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        alarma.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual
    }//GEN-LAST:event_Boton_alarmaActionPerformed

    private void boton_RestaurarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_RestaurarExcelActionPerformed
        AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Prender.wav"));
        sonido.play();
        int resp = JOptionPane.showConfirmDialog(null, "<html><b> {0_o} Estas seguro de restaurar el Excel??", " Restaurar Excel??????", JOptionPane.INFORMATION_MESSAGE);
        if (JOptionPane.OK_OPTION == resp) { //si la opcion es si que pase al codigo
            Operaciones_restaurarExcel();//lo envio al metodo

        } else {
            //si presiona no o cancel se va al else
        }
    }//GEN-LAST:event_boton_RestaurarExcelActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          Agregar agregar = new Agregar();
        agregar.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        agregar.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Editar editar = new Editar();
        editar.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        editar.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
          CambiarAlarma_Producto cambiaralarma_producto = new CambiarAlarma_Producto();
        cambiaralarma_producto.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        cambiaralarma_producto.setVisible(true);
        AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       Eliminar eliminar = new Eliminar();
        eliminar.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        eliminar.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       AgregarCliente agregarcliente = new AgregarCliente();
        agregarcliente.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        agregarcliente.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      EditarCliente editarcliente = new EditarCliente();
        editarcliente.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        editarcliente.setVisible(true);
        AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      EliminarCliente eliminarcliente = new EliminarCliente();
        eliminarcliente.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        eliminarcliente.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    public void Operaciones_restaurarExcel() {//aqui lo dirijira a la clase Progreso_RestaurarExcel y hara las operaciones, todo esto es para que muestre una barra de carga
          BarraProgreso_RestaurarExcel.setVisible(true);
                Progreso_RestaurarExcel p = new Progreso_RestaurarExcel(BarraProgreso_RestaurarExcel); //lo dirijo a la clase Progreso_EnviarExcel que hara las operaciones y mostrata una barra de carga, tambn le mando el correo y la clave

                p.addPropertyChangeListener(new PropertyChangeListener() {// todo esto es para cambiar el cursor a cursor de carga
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equalsIgnoreCase("progreso_restaurarexcel")) {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        } else {
                            if (evt.getPropertyName().equalsIgnoreCase("state")) {
                                switch ((SwingWorker.StateValue) evt.getNewValue()) {
                                    case DONE://si ya esta entonces quite la barra y deje cursor por defecto
                                        BarraProgreso_RestaurarExcel.setVisible(false);
                                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
 
                                        break;
                                    case STARTED://si empezo ponga cursor de carga
                                        setCursor(new Cursor(Cursor.WAIT_CURSOR));
                                        break;
                                    case PENDING://si sigue pendiente no haga nada

                                        break;
                                }
                            }
                        }
                    }
                });
                p.execute();
        
       

    }

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JProgressBar BarraProgreso_RestaurarExcel;
    private javax.swing.JButton BotonCambiar_Correoclave;
    private javax.swing.JButton BotonCambiar_Correodestino;
    private javax.swing.JButton BotonEnviar_Excel;
    private javax.swing.JButton BotonGenerar_codigo;
    private javax.swing.JButton Boton_alarma;
    private javax.swing.JButton Boton_cambiarClave;
    private javax.swing.JButton Boton_inicio;
    private javax.swing.JButton boton_RestaurarExcel;
    private javax.swing.JButton boton_atras;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables
}
