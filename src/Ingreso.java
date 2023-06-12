
import PlaceHolder.PlaceHolder;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.commons.codec.digest.DigestUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jona
 */

public class Ingreso extends javax.swing.JFrame {
public boolean error=false;
    public Ingreso() {
       
        initComponents();

        
        
        Password.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
           
        }

        diseño_Botones();

        this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

        // this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(Ingreso.this); // para que este en el centro de la pantalla
        //this.setTitle("xd");
       
        
       
        
    Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

        this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla
    }

    public void diseño_Botones() {
        Boton_inicio.setOpaque(false);
        Boton_inicio.setContentAreaFilled(false);
        Boton_inicio.setBorderPainted(false);

        Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);

        Boton_Mostrarclave.setOpaque(false);
        Boton_Mostrarclave.setContentAreaFilled(false);
        Boton_Mostrarclave.setBorderPainted(false);
        
        Boton_Recuperarclave.setOpaque(false);
        Boton_Recuperarclave.setContentAreaFilled(false);
        Boton_Recuperarclave.setBorderPainted(false);
        
        boton_atras.setOpaque(false);
        boton_atras.setContentAreaFilled(false);
        boton_atras.setBorderPainted(false);
        
         BotonEnviar_Excel.setOpaque(false);
        BotonEnviar_Excel.setContentAreaFilled(false);
        BotonEnviar_Excel.setBorderPainted(false);
        
         BotonGenerar_codigo.setOpaque(false);
        BotonGenerar_codigo.setContentAreaFilled(false);
        BotonGenerar_codigo.setBorderPainted(false);
        
               PlaceHolder placeholder = new PlaceHolder("Clave", Password);
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton_inicio = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        Boton_ok = new javax.swing.JButton();
        Boton_Mostrarclave = new javax.swing.JButton();
        Boton_Recuperarclave = new javax.swing.JButton();
        boton_atras = new javax.swing.JButton();
        BotonEnviar_Excel = new javax.swing.JButton();
        BotonGenerar_codigo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

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

        Password.setFont(new java.awt.Font("Segoe Print", 1, 25)); // NOI18N
        Password.setCaretColor(new java.awt.Color(255, 51, 204));
        Password.setSelectionColor(new java.awt.Color(255, 51, 204));
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        Boton_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        Boton_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok2.png"))); // NOI18N
        Boton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_okActionPerformed(evt);
            }
        });

        Boton_Mostrarclave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mostrar.png"))); // NOI18N
        Boton_Mostrarclave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_Mostrarclave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mostrar2.png"))); // NOI18N
        Boton_Mostrarclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_MostrarclaveActionPerformed(evt);
            }
        });

        Boton_Recuperarclave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recuperarclave.png"))); // NOI18N
        Boton_Recuperarclave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_Recuperarclave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Recuperarclave2.png"))); // NOI18N
        Boton_Recuperarclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_RecuperarclaveActionPerformed(evt);
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

        BotonEnviar_Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EnviarExcel.png"))); // NOI18N
        BotonEnviar_Excel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEnviar_Excel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EnviarExcel2.png"))); // NOI18N
        BotonEnviar_Excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEnviar_ExcelActionPerformed(evt);
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

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarCliente-Menu.png"))); // NOI18N
        jMenuItem4.setText("Agregar");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Editarcliente-Menu.png"))); // NOI18N
        jMenuItem5.setText("Editar");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boton_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Boton_Recuperarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_Mostrarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 849, Short.MAX_VALUE)
                        .addComponent(Boton_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonEnviar_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(BotonGenerar_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Boton_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_Mostrarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(113, 113, 113)
                .addComponent(BotonGenerar_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonEnviar_Excel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boton_Recuperarclave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_atras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_inicioActionPerformed

        Inicio inicio = new Inicio();
        
        inicio.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        inicio.setVisible(true);
        AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton_Inicio.wav"));
        sonido2.play();
        dispose();//para cerrar la ventana actual
    }//GEN-LAST:event_Boton_inicioActionPerformed

    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed

        if ("".equals(Password.getText())) {
              AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Pregunta.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Para que ingresas un campo vacio ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
Password.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        } else {

            try {

                FileReader lector = new FileReader("BD/BD/BD.txt");//leo el txt
                BufferedReader Br = new BufferedReader(lector);

                String bfRead;
                bfRead = Br.readLine();//solo quiero la primera linea del txt asi que no necesito un ciclo

                String claveEncriptada = DigestUtils.md5Hex(Password.getText());//cifro la clave que el usuario ingresa

                if (claveEncriptada.equals(bfRead)) {//si el cifrado es igual a la quenesta en el txt entonces si es la clave
                   lector.close();//cierro el archivo

                    Admin admin = new Admin();
                    admin.setTitle("IRIS❤ Admin");//para que muestre en el la pantalla esquina superior izquierda un titutlo
                    admin.setVisible(true);//voy a admin
                    AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
                    dispose();

                } else {
  AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
        Password.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                      Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>(¬､¬)Clave incorrecta✘, quien eres?≖_≖</b> ", "(¬､¬)✘✘✘✘✘✘", JOptionPane.INFORMATION_MESSAGE, icon);
                    lector.close();//cierro el archivo

                }

            }
            
            catch (FileNotFoundException ex) {
                  AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>No encontre la base de datos de la clave!! la moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
            }
            
            catch (IOException ex) {
                  AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>Error desconocido✘ ●︿●  vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

            }

        }

    }//GEN-LAST:event_Boton_okActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void Boton_MostrarclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_MostrarclaveActionPerformed
char mostrarClave =0;
 
        Password.setEchoChar(mostrarClave);
         
Password.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo


    }//GEN-LAST:event_Boton_MostrarclaveActionPerformed

    private void Boton_RecuperarclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_RecuperarclaveActionPerformed
AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Prender.wav"));
        sonido.play();      
     int   resp = JOptionPane.showConfirmDialog(null,"<html><b> {0_o} Estas seguro de recuperar la clave?", " Restaurar clave??????", JOptionPane.INFORMATION_MESSAGE);
     if (JOptionPane.OK_OPTION == resp){ 
   RestaurarClave restaurarclave = new RestaurarClave();
   
   restaurarclave.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        restaurarclave.setVisible(true);
        
        
        dispose();
 }
      else{
    //si presiona no o cancel se va al else
   }
    }//GEN-LAST:event_Boton_RecuperarclaveActionPerformed

    private void boton_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_atrasActionPerformed

        Inicio inicio = new Inicio();
       inicio.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
      
      inicio.setVisible(true);
        AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        
        
        dispose();//para cerrar la ventana actual
    }//GEN-LAST:event_boton_atrasActionPerformed

    private void BotonEnviar_ExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEnviar_ExcelActionPerformed

        EnviarExcel enviarexcel = new EnviarExcel();
        enviarexcel.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        enviarexcel.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
       
    }//GEN-LAST:event_BotonEnviar_ExcelActionPerformed

    private void BotonGenerar_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerar_codigoActionPerformed

        GenerarCodigo generarcodigo = new GenerarCodigo();
        generarcodigo.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        generarcodigo.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
      
    }//GEN-LAST:event_BotonGenerar_codigoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Agregar agregar = new Agregar();
        agregar.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        agregar.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          Editar editar = new Editar();
        editar.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        editar.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       CambiarAlarma_Producto cambiaralarma_producto = new CambiarAlarma_Producto();
        cambiaralarma_producto.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        cambiaralarma_producto.setVisible(true);
        AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       AgregarCliente agregarcliente = new AgregarCliente();
        agregarcliente.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        agregarcliente.setVisible(true);
        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        EditarCliente editarcliente = new EditarCliente();
        editarcliente.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        editarcliente.setVisible(true);
        AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEnviar_Excel;
    private javax.swing.JButton BotonGenerar_codigo;
    private javax.swing.JButton Boton_Mostrarclave;
    private javax.swing.JButton Boton_Recuperarclave;
    private javax.swing.JButton Boton_inicio;
    private javax.swing.JButton Boton_ok;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton boton_atras;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
