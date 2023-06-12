
import PlaceHolder.PlaceHolder;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jona
 */
public class Cambiar_Correoremitente extends javax.swing.JFrame {

    /**
     * Creates new form Cambiar_Correoclave
     */
    public Cambiar_Correoremitente() {
        initComponents();
        
         Correoclave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            
        }

        diseño_Botones();

        //this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

         this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(Cambiar_Correoremitente.this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

       // this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla
    }

 public void diseño_Botones(){
 
        Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);
        
           PlaceHolder placeholder = new PlaceHolder("Correo remitente", Correoclave);
        
        
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton_ok = new javax.swing.JButton();
        Correoclave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(446, 166));

        Boton_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        Boton_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok2.png"))); // NOI18N
        Boton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_okActionPerformed(evt);
            }
        });

        Correoclave.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Correoclave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Correoclave.setCaretColor(new java.awt.Color(255, 0, 204));
        Correoclave.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Correoclave.setSelectionColor(new java.awt.Color(255, 51, 204));
        Correoclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorreoclaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Correoclave, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Correoclave, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed
        
 boolean validacion_Correo=false; //valido si el correo tiene @ o termina en com oco o sus derivados
        if(Correoclave.getText().contains("@")&& Correoclave.getText().endsWith(".com") ||Correoclave.getText().endsWith(".co")||Correoclave.getText().endsWith(".org")  ||Correoclave.getText().endsWith(".es") ||Correoclave.getText().endsWith(".it") ||Correoclave.getText().endsWith(".fr") ||Correoclave.getText().endsWith(".cat") ||Correoclave.getText().endsWith(".net"))  {
         validacion_Correo=true;
        }
        
        if ("".equals(Correoclave.getText())) {//si los campos estan vacios
            AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Pregunta.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Para que ingresas un campo vacio ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
        Correoclave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        } 
        else if(validacion_Correo==false || Correoclave.getText().startsWith("@") ){
             AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
           Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Pero ese correo nisiquiera es valido ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
      Correoclave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        }
        
         else if(Correoclave.getText().endsWith("@.com") ||Correoclave.getText().endsWith("@.co")||Correoclave.getText().endsWith("@.org")  ||Correoclave.getText().endsWith("@.es") ||Correoclave.getText().endsWith("@.it") ||Correoclave.getText().endsWith("@.fr") ||Correoclave.getText().endsWith("@.cat")||Correoclave.getText().endsWith("@.net")){
        AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
          JOptionPane.showMessageDialog(null, "<html><b>Pero ese correo nisiquiera es valido ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
        Correoclave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
         }
        
        
        else {

            try {
                ArrayList<String> lista_informaciontxt = new ArrayList<String>();

                FileReader lector = new FileReader("BD/BD/BD.txt");
                BufferedReader Br = new BufferedReader(lector);

                String bfRead;
                while ((bfRead = Br.readLine()) != null) {

                    lista_informaciontxt.add(bfRead);//tomare toda la informacion que esta en el archivo y lo guardo a una lista

                }

                PrintWriter printWriter;

//ahora vuelvo a crear el archivo y escribo la nueva clave y le agrego lo que tenia antes ya q esta en la lista
                FileWriter archivo = new FileWriter("BD/BD/BD.txt"); //si fuera "BD.txt",true no lo recrearia solo saltaria lineas y escribiria debajo de ellas
                lector = new FileReader("BD/BD/BD.txt");
                Br = new BufferedReader(lector);
                printWriter = new PrintWriter(archivo);

                printWriter.println(lista_informaciontxt.get(0));
               printWriter.println(lista_informaciontxt.get(1));//en la posicion 2 esta el correo destino
                printWriter.println(lista_informaciontxt.get(2));//en la posicion 3 esta el numero de alarma
                printWriter.println(Correoclave.getText());//en la posicion 4 esta el correo que se enviara la clave si se olvida
                 printWriter.println(lista_informaciontxt.get(4));//en la posicion 5 esta el correo destino2
                lista_informaciontxt.clear();//elimino todo lo de la lista para que no quede consumiendo memoria
                archivo.close();
                lector.close();
                Br.close();
                Correoclave.setText("");
                Correoclave.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                 AudioClip  sonido;
       sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
        sonido.play();

                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/guardado.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>Se Guardo el correo destino   con exito! :3</b> ٩(•̮̮̃•̃)۶", "Guardado ◕ ‿‿ ◕", JOptionPane.INFORMATION_MESSAGE, icon);
Admin admin = new Admin();
        admin.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        admin.setVisible(true);

        dispose();//para cerrar la ventana actual
            } catch (FileNotFoundException ex) {
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


    }    
            

    }//GEN-LAST:event_Boton_okActionPerformed

    private void CorreoclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorreoclaveActionPerformed

    }//GEN-LAST:event_CorreoclaveActionPerformed

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
            java.util.logging.Logger.getLogger(Cambiar_Correoremitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambiar_Correoremitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambiar_Correoremitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambiar_Correoremitente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cambiar_Correoremitente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_ok;
    private javax.swing.JTextField Correoclave;
    // End of variables declaration//GEN-END:variables
}
