

import PlaceHolder.PlaceHolder;
import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Properties;
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
public class RestaurarClave extends javax.swing.JFrame {

    /**
     * Creates new form RestaurarClave
     */
   
    public RestaurarClave() {
        initComponents();
        Password.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
         try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            
        }

        diseño_Botones();

       // this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

         this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(RestaurarClave.this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

        //this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla
    }

   public void diseño_Botones(){
   
         

        Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);
        
        Boton_Mostrarclave.setOpaque(false);
        Boton_Mostrarclave.setContentAreaFilled(false);
        Boton_Mostrarclave.setBorderPainted(false);
        
         
        
        BarraProgreso_EnviarClave.setVisible(false);
        
        
          PlaceHolder placeholder = new PlaceHolder("Clave del correo registrado", Password);
        
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Password = new javax.swing.JPasswordField();
        Boton_ok = new javax.swing.JButton();
        Boton_Mostrarclave = new javax.swing.JButton();
        BarraProgreso_EnviarClave = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(453, 271));

        Password.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
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

        BarraProgreso_EnviarClave.setForeground(new java.awt.Color(255, 51, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_Mostrarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BarraProgreso_EnviarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarraProgreso_EnviarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Mostrarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed
boolean Hay_internet=true;
        try {

            URL ruta=new URL("http://www.google.es");
            URLConnection rutaC=ruta.openConnection();
            rutaC.connect();
            
           }catch(Exception e){

           Hay_internet=false;
        } 
        if("".equals(Password.getText()) ){
        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Pregunta.png")); //para poner icono al aviso
        AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
            JOptionPane.showMessageDialog(null, "<html><b>Para que ingresas un campo vacio ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
            
       }
        else if(Hay_internet==false){
          AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
         
            JOptionPane.showMessageDialog(null, "<html><b>Nisiquiera hay internet✘¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
        }
       
       else {
          
           try {
           
                ArrayList<String> lista_informaciontxt = new ArrayList<String>();//en la lista guardare todo lo que este en el txt
               FileReader lector = new FileReader("BD/BD/BD.txt");
                BufferedReader Br = new BufferedReader(lector);

                String bfRead;
                while ((bfRead = Br.readLine()) != null) {

                    lista_informaciontxt.add(bfRead);//tomare toda la informacion que esta en el archivo y lo guardo a una lista

                }
               
               
               
         BarraProgreso_EnviarClave.setVisible(true);
                Progreso_EnviarClave p = new Progreso_EnviarClave(BarraProgreso_EnviarClave, lista_informaciontxt.get(3), Password.getText()); //lo dirijo a la clase Progreso_EnviarExcel que hara las operaciones y mostrata una barra de carga, tambn le mando el correo y la clave

                p.addPropertyChangeListener(new PropertyChangeListener() {// todo esto es para cambiar el cursor a cursor de carga
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equalsIgnoreCase("progreso_enviarclave")) {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        } else {
                            if (evt.getPropertyName().equalsIgnoreCase("state")) {
                                switch ((SwingWorker.StateValue) evt.getNewValue()) {
                                    case DONE://si ya esta entonces quite la barra y deje cursor por defecto
                                        BarraProgreso_EnviarClave.setVisible(false);
                                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                        lista_informaciontxt.clear();
 
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
    //para poner icono al aviso
      catch (FileNotFoundException ex) {
             AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
               Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>No se encontro la base de datos de IRIS!!✘ la moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
               
           }
    //para poner icono al aviso
     catch (IOException ex) {
                 AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error leyendo la base de datos ⊙△⊙✘ </b> ", "⊙﹏⊙ perdon, intenta de nuevo", JOptionPane.INFORMATION_MESSAGE, icon);
           }
           
       
       }
              
    }//GEN-LAST:event_Boton_okActionPerformed

    private void Boton_MostrarclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_MostrarclaveActionPerformed

     
    char mostrarClave=0;
    Password.setEchoChar(mostrarClave);
    Password.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo

    }//GEN-LAST:event_Boton_MostrarclaveActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarClave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JProgressBar BarraProgreso_EnviarClave;
    private javax.swing.JButton Boton_Mostrarclave;
    private javax.swing.JButton Boton_ok;
    private javax.swing.JPasswordField Password;
    // End of variables declaration//GEN-END:variables
}
