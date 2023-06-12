
import PlaceHolder.PlaceHolder;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
public class AgregarCliente extends javax.swing.JFrame {

    /**
     * Creates new form AgregarCliente
     */
    public AgregarCliente() {
       initComponents();
       // Thread.sleep(2500);
       Texto_Nombre.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            
        }

        diseño_Botones();//llama al metodo para que arregle todos los botones

       // this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

         this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

       // this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Texto_ID = new javax.swing.JTextField();
        Texto_Nombre = new javax.swing.JTextField();
        Boton_ok = new javax.swing.JButton();
        Texto_Telefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(392, 253));

        Texto_ID.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_ID.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_ID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_ID.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_IDActionPerformed(evt);
            }
        });

        Texto_Nombre.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_Nombre.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_Nombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_Nombre.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_NombreActionPerformed(evt);
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

        Texto_Telefono.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_Telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_Telefono.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_Telefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_Telefono.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_TelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Texto_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Texto_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Texto_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Texto_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_IDActionPerformed

    }//GEN-LAST:event_Texto_IDActionPerformed

    private void Texto_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_NombreActionPerformed

    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed
        boolean IDcliente_numeroOTelefono=true;
        try {
            //vere si el ID y el telefono es un numero
            long IDcliente = Long.parseLong(Texto_ID.getText());//vere si el id es un numero
            long TelefonoCliente =   Long.parseLong(Texto_Telefono.getText());
        } catch (Exception e) {//si da error es que es un texto
            IDcliente_numeroOTelefono=false;
        }
        
        if("".equals(Texto_ID.getText()) || "".equals(Texto_Nombre.getText()) || "".equals(Texto_Telefono.getText()) ){
        AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Uno de los campos esta vacio ⊙﹏⊙</b>", "●︿●", JOptionPane.INFORMATION_MESSAGE, icon);
          
        }
        //si el IDdel cliente llega a tener un numero
        else if(IDcliente_numeroOTelefono==false){
                AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El ID del cliente o telefono debe ser un numero¯\\(o_o)/¯ </b>", "¯\\(o_o)/¯ ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
         Texto_ID.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        }
        
        else if (Texto_Nombre.getText().contains("0") || Texto_Nombre.getText().contains("1") || Texto_Nombre.getText().contains("2") || Texto_Nombre.getText().contains("3") || Texto_Nombre.getText().contains("4") || Texto_Nombre.getText().contains("5") || Texto_Nombre.getText().contains("6") || Texto_Nombre.getText().contains("7") || Texto_Nombre.getText().contains("8") || Texto_Nombre.getText().contains("9")){
        AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Desde cuando un nombre tiene numeros? ¯\\(o_o)/¯ </b>", "¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);
        Texto_Nombre.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        }
        
        else{
        agregarCliente();
        }
      
    }//GEN-LAST:event_Boton_okActionPerformed

    private void Texto_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_TelefonoActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void diseño_Botones(){
    
        
         Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);
        
           PlaceHolder placeholder = new PlaceHolder("Nombre cliente", Texto_Nombre);
         placeholder = new PlaceHolder("ID cliente", Texto_ID);
           placeholder = new PlaceHolder("Telefono", Texto_Telefono);
    
    }
    
    public void agregarCliente(){
        try {     
             
            int contadorColumnas = 0;
            int contadorFilas = 1; //1 ya que la primera posicion del excel a agregarclientes es la 2
            boolean estado = true;

            FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(3);//con q hoja empezaremos
            
            while (estado ==true){
              XSSFRow fila = sheet.getRow(contadorFilas);//numero de filas filas
              
              if (fila == null)//si la fila no es nula no entra y el contador de filas se incrementa, es decir mirara la sgte fila
                {
                   estado = false;//paso el estado a falso para que no siga el while
                    fila = sheet.createRow(contadorFilas);//cuando la fila sea nula entra al if y segun el contador esa sera la fila a escribir

                    XSSFCell celda = fila.createCell(0);//sera la primera columna ya que es la de codigos de productos

                    celda.setCellValue(Texto_ID.getText());//le asigno el numero de cedula

                    celda = fila.createCell(1);//la segunda sera para guardar el nombre 

                    celda.setCellValue(Texto_Nombre.getText());//lo que el usuario ingreso es decir el nombre del producto l oagrego a la celda

                    celda = fila.createCell(2);//la tercera ira el telefono

                    celda.setCellValue(Texto_Telefono.getText());//lo que el usuario ingreso es decir el nombre del producto l oagrego a la celda
                    
                          celda = fila.createCell(3);//la cuarta lo q le a comprado aIRIS, empieza en 0

                    celda.setCellValue("0");
                    
                    try {//ahora cerrare y guardare el archivo excel
                        file.close();

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/guardado.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>Se Guardo " + Texto_Nombre.getText() + " con exito!✔</b> ٩(•̮̮̃•̃)۶", "Guardado ◕ ‿‿ ◕", JOptionPane.INFORMATION_MESSAGE, icon);
                        Texto_ID.setText("");
                        Texto_Nombre.setText("");
                        Texto_Telefono.setText("");
                          Texto_Nombre.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                       
                    } catch (Exception e) {
                      AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> ✘o(╥﹏╥)o✘", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                    }
                    
                   
              }
              else{
              
                  XSSFCell celda = fila.getCell(0); //voy verificando en cada fila la primera celda si el codigo no se repite

                    if (Texto_ID.getText().equals(celda.getStringCellValue())) { //si el ID  es igual a la celda del excel...
                  estado = false;//lo pongo a falso ya que el cliente ya esta registrado
                        AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>El cliente ya se encuentra registrado✔ !</b>", ":3", JOptionPane.INFORMATION_MESSAGE, icon);
                        
                        
                        try {
                               file.close();//guardo y cierro el archivo
                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
                        Texto_Nombre.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                        } catch (Exception e) {//si da error al guardar
                            AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido2.play();
                           Icon icon2 = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                      
                           JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon2);
                        }
                      

                    }
                  
              }
              contadorFilas++;//si no entra al else es que no se repite, y como no entro al if es que aun no termine de recorrer los IDs asi que sigo a la sgte fila
            }
            
        } catch (FileNotFoundException ex) {
         AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se a encontrado el excel!! lo moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (IOException ex) {
        AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ●︿●  vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    
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
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_ok;
    private javax.swing.JTextField Texto_ID;
    private javax.swing.JTextField Texto_Nombre;
    private javax.swing.JTextField Texto_Telefono;
    // End of variables declaration//GEN-END:variables
}
