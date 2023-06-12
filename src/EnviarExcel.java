
import PlaceHolder.PlaceHolder;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jona
 */
public class EnviarExcel extends javax.swing.JFrame {

    /**
     * Creates new form EnviarExcel
     */
    public EnviarExcel() {

        initComponents();
        try {//esto es para que muestre el correo a enviar de una vez y no tenga que dijitarlo
               ArrayList<String> lista_informaciontxt = new ArrayList<String>();

                FileReader lector = new FileReader("BD/BD/BD.txt");
                BufferedReader Br = new BufferedReader(lector);

                String bfRead;
                while ((bfRead = Br.readLine()) != null) {

                    lista_informaciontxt.add(bfRead);//tomare toda la informacion que esta en el archivo y lo guardo a una lista

                }
            
                lector.close();
                Br.close();
            
            Correo.setText(lista_informaciontxt.get(3));
            lista_informaciontxt.clear();
        }        
            
         catch (FileNotFoundException ex) {
                 AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>No se encontro la base de datos de la clave!! la moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
            } catch (IOException ex) {
                AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ●︿●  vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

            }
      
        Clave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {

        }

        diseño_Botones();//llama al metodo para que arregle todos los botones

      //  this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

         this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

      //  this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla

    }

    public void diseño_Botones() {
        Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);
;

        Boton_Mostrarclave.setOpaque(false);
        Boton_Mostrarclave.setContentAreaFilled(false);
        Boton_Mostrarclave.setBorderPainted(false);



        BarraProgreso_EnviarExcel.setVisible(false);
        
         PlaceHolder placeholder = new PlaceHolder("Correo", Correo);
             placeholder = new PlaceHolder("clave", Clave);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Clave = new javax.swing.JPasswordField();
        Boton_ok = new javax.swing.JButton();
        Correo = new javax.swing.JTextField();
        Boton_Mostrarclave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BarraProgreso_EnviarExcel = new javax.swing.JProgressBar();
        SelectorCorreos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(1280, 720));
        setSize(new java.awt.Dimension(670, 332));

        Clave.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        Clave.setCaretColor(new java.awt.Color(255, 0, 204));
        Clave.setSelectionColor(new java.awt.Color(255, 51, 204));
        Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveActionPerformed(evt);
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

        Correo.setFont(new java.awt.Font("Tempus Sans ITC", 3, 30)); // NOI18N
        Correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Correo.setCaretColor(new java.awt.Color(255, 0, 204));
        Correo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Correo.setSelectionColor(new java.awt.Color(255, 51, 204));
        Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoActionPerformed(evt);
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

        BarraProgreso_EnviarExcel.setForeground(new java.awt.Color(255, 51, 204));

        SelectorCorreos.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        SelectorCorreos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gmail", "Outlook", "Yahoo Mail" }));
        SelectorCorreos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectorCorreosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        jLabel4.setText("Elegir primero el tipo de correo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectorCorreos, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 189, Short.MAX_VALUE))
                    .addComponent(BarraProgreso_EnviarExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Correo)
                    .addComponent(Clave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_Mostrarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BarraProgreso_EnviarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Mostrarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SelectorCorreos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveActionPerformed

    private void CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoActionPerformed

    }//GEN-LAST:event_CorreoActionPerformed

    private void Boton_MostrarclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_MostrarclaveActionPerformed
        char mostrarClave = 0;
        Clave.setEchoChar(mostrarClave);
        Clave.setEchoChar(mostrarClave);
        Clave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
    }//GEN-LAST:event_Boton_MostrarclaveActionPerformed


    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed

            //cogere el correo de IRIS que esta en la base de datos
           
             boolean Hay_internet = true;//es para saber si hay internet
        try {

            URL ruta = new URL("http://www.google.es"); //si logra conectarse a google hay internet
            URLConnection rutaC = ruta.openConnection();
            rutaC.connect();

        } catch (Exception e) {

            Hay_internet = false;
        }

        boolean validacion_Correo = false; //valido si el correo tiene @ o termina en com oco o sus derivados
        if (Correo.getText().contains("@") && Correo.getText().endsWith(".com") || Correo.getText().endsWith(".co") || Correo.getText().endsWith(".org") || Correo.getText().endsWith(".es") || Correo.getText().endsWith(".it") || Correo.getText().endsWith(".fr") || Correo.getText().endsWith(".cat") || Correo.getText().endsWith(".net")) {
            validacion_Correo = true;
        }
        if ("".equals(Correo.getText()) || "".equals(Clave.getText())) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Pregunta.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Para que ingresas un campo vacio ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (validacion_Correo == false || Correo.getText().startsWith("@")) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso

            JOptionPane.showMessageDialog(null, "<html><b>Pero ese correo nisiquiera es valido ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
            Correo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        } else if (Hay_internet == false) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso

            JOptionPane.showMessageDialog(null, "<html><b>Nisiquiera hay internet✘¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
        } else if (Correo.getText().endsWith("@.com") || Correo.getText().endsWith("@.co") || Correo.getText().endsWith("@.org") || Correo.getText().endsWith("@.es") || Correo.getText().endsWith("@.it") || Correo.getText().endsWith("@.fr") || Correo.getText().endsWith("@.cat") || Correo.getText().endsWith("@.net")) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso

            JOptionPane.showMessageDialog(null, "<html><b>Pero ese correo nisiquiera es valido ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
            Correo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        } else {
            
            if (SelectorCorreos.getSelectedItem() == "Outlook") {//si es Outlook...
  BarraProgreso_EnviarExcel.setVisible(true);
               BarraProgreso_EnviarExcel.setVisible(true);
                Progreso_EnviarExcel p = new Progreso_EnviarExcel(BarraProgreso_EnviarExcel, Correo.getText(), Clave.getText()); //lo dirijo a la clase Progreso_EnviarExcel que hara las operaciones y mostrata una barra de carga, tambn le mando el correo y la clave

                p.addPropertyChangeListener(new PropertyChangeListener() {// todo esto es para cambiar el cursor a cursor de carga
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equalsIgnoreCase("progreso_enviarexcel")) {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        } else {
                            if (evt.getPropertyName().equalsIgnoreCase("state")) {
                                switch ((SwingWorker.StateValue) evt.getNewValue()) {
                                    case DONE://si ya esta entonces quite la barra y deje cursor por defecto
                                        BarraProgreso_EnviarExcel.setVisible(false);
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

            } else if (SelectorCorreos.getSelectedItem() == "Gmail") {//si es Gamil...

                BarraProgreso_EnviarExcel.setVisible(true);
                Progreso_EnviarExcelGmail p2 = new Progreso_EnviarExcelGmail(BarraProgreso_EnviarExcel, Correo.getText(), Clave.getText()); //lo dirijo a la clase Progreso_EnviarExcel que hara las operaciones y mostrata una barra de carga, tambn le mando el correo y la clave

                 p2.addPropertyChangeListener(new PropertyChangeListener() {// todo esto es para cambiar el cursor a cursor de carga
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equalsIgnoreCase("progreso_restaurarexcel")) {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        } else {
                            if (evt.getPropertyName().equalsIgnoreCase("state")) {
                                switch ((SwingWorker.StateValue) evt.getNewValue()) {
                                    case DONE://si ya esta entonces quite la barra y deje cursor por defecto
                                        BarraProgreso_EnviarExcel.setVisible(false);
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
                p2.execute();

            }

             else if (SelectorCorreos.getSelectedItem() == "Yahoo Mail") {//si es Gamil...

                BarraProgreso_EnviarExcel.setVisible(true);
                Progreso_EnviarExcelYahoo p3 = new Progreso_EnviarExcelYahoo(BarraProgreso_EnviarExcel, Correo.getText(), Clave.getText()); //lo dirijo a la clase Progreso_EnviarExcel que hara las operaciones y mostrata una barra de carga, tambn le mando el correo y la clave

                p3.addPropertyChangeListener(new PropertyChangeListener() {// todo esto es para cambiar el cursor a cursor de carga
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equalsIgnoreCase("progreso_enviarexcelyahoo")) {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        } else {
                            if (evt.getPropertyName().equalsIgnoreCase("state")) {
                                switch ((SwingWorker.StateValue) evt.getNewValue()) {
                                    case DONE://si ya esta entonces quite la barra y deje cursor por defecto
                                  BarraProgreso_EnviarExcel.setVisible(false);
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
                p3.execute();

            }
            
        }

  
    }//GEN-LAST:event_Boton_okActionPerformed

    private void SelectorCorreosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectorCorreosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectorCorreosActionPerformed

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
            java.util.logging.Logger.getLogger(EnviarExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnviarExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnviarExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnviarExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviarExcel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JProgressBar BarraProgreso_EnviarExcel;
    private javax.swing.JButton Boton_Mostrarclave;
    private javax.swing.JButton Boton_ok;
    public static javax.swing.JPasswordField Clave;
    public static javax.swing.JTextField Correo;
    private javax.swing.JComboBox<String> SelectorCorreos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
