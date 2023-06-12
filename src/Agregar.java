
import PlaceHolder.PlaceHolder;
import com.sun.glass.ui.Cursor;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jona
 */
public class Agregar extends javax.swing.JFrame {

    public Agregar() {
        initComponents();
Texto_agregarProducto.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            
        }

        diseño_Botones();
        // diseño_Botones();//llama al metodo para que arregle todos los botones

        //this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

         this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(Agregar.this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

      //  this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla
    }

    public void diseño_Botones() {//hara unos arreglos a todos los botones, quitar bordes, que deje solo la imagen

        Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);

        Boton_copiar.setOpaque(false);
        Boton_copiar.setContentAreaFilled(false);
        Boton_copiar.setBorderPainted(false);
        Boton_copiar.setVisible(false);

      PlaceHolder placeholder = new PlaceHolder("Nombre producto", Texto_agregarProducto);
         placeholder = new PlaceHolder("Precio de compra", Texto_agregar_precioCompra);
           placeholder = new PlaceHolder("Cantidad", Texto_agregar_inventario);
             placeholder = new PlaceHolder("Alarma", Texto_alarma);
               placeholder = new PlaceHolder("Codigo(opcional)", Texto_agregar_codigo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Texto_agregarProducto = new javax.swing.JTextField();
        Boton_ok = new javax.swing.JButton();
        Label_codigo_barras = new javax.swing.JLabel();
        Boton_copiar = new javax.swing.JButton();
        Texto_agregar_precioCompra = new javax.swing.JTextField();
        Texto_agregar_codigo = new javax.swing.JTextField();
        Texto_agregar_inventario = new javax.swing.JTextField();
        Texto_alarma = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(374, 436));

        Texto_agregarProducto.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_agregarProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_agregarProducto.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_agregarProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_agregarProducto.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_agregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_agregarProductoActionPerformed(evt);
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

        Boton_copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/copiar.png"))); // NOI18N
        Boton_copiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_copiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/copiar2.png"))); // NOI18N
        Boton_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_copiarActionPerformed(evt);
            }
        });

        Texto_agregar_precioCompra.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_agregar_precioCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_agregar_precioCompra.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_agregar_precioCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_agregar_precioCompra.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_agregar_precioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_agregar_precioCompraActionPerformed(evt);
            }
        });

        Texto_agregar_codigo.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_agregar_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_agregar_codigo.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_agregar_codigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_agregar_codigo.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_agregar_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_agregar_codigoActionPerformed(evt);
            }
        });

        Texto_agregar_inventario.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_agregar_inventario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_agregar_inventario.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_agregar_inventario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_agregar_inventario.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_agregar_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_agregar_inventarioActionPerformed(evt);
            }
        });

        Texto_alarma.setFont(new java.awt.Font("Tempus Sans ITC", 3, 25)); // NOI18N
        Texto_alarma.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_alarma.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_alarma.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_alarma.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_alarma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_alarmaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Texto_agregar_precioCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Texto_agregarProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Label_codigo_barras, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_copiar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Texto_agregar_codigo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Texto_alarma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(Texto_agregar_inventario, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boton_copiar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_codigo_barras, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Texto_agregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Texto_agregar_precioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Texto_agregar_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Texto_alarma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Texto_agregar_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Texto_agregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_agregarProductoActionPerformed

    }//GEN-LAST:event_Texto_agregarProductoActionPerformed

    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed
int alarmaPersonalizadaProducto=0;//para ssaber la alarma del producto
        int precioCompra=0;
        int inventario=0;
        int alarma=0;
        boolean precioCompra_numero = true;
        boolean alarmaNumero= true;
        try {//vere si en precio compra intrudiceron un numero
           precioCompra= Integer.parseInt(Texto_agregar_precioCompra.getText()); //veo si se puede pasar a int
           inventario= Integer.parseInt(Texto_agregar_inventario.getText()); //veo si se puede pasar a int
        } catch (Exception e) {
            precioCompra_numero = false;
        }

        
        try {//ahora verificare si la alarma es numero
            alarma= Integer.parseInt(Texto_alarma.getText()); //veo si se puede pasar a int
        } catch (Exception e) {
               alarmaNumero = false;
        }
        
        if ("".equals(Texto_agregarProducto.getText()) || "".equals(Texto_agregar_precioCompra.getText()) || "".equals(Texto_agregar_inventario.getText()) || "".equals(Texto_alarma.getText()) )  { //si se ingreso un campo vacio no lo dejara hacer la operacion
AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Pregunta.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Para que guardar un espacio vacio? no lo guardare ¯\\_(ツ)_/¯</b>", " ¯\\(o_o)/¯", JOptionPane.INFORMATION_MESSAGE, icon);

        } else if (precioCompra_numero == false) {
            AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El precio o inventario debe ser un numero ¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       
        } 
       else if(precioCompra<=0){
           AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
       Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El precio de compra debe ser mayor a 0 ¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
      Texto_agregar_precioCompra.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
       }
         else if(inventario<0){
             AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
       Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El inventario no puede ser negativo  ¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
      Texto_agregar_inventario.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
         }
        
         else if(Texto_agregar_precioCompra.getText().startsWith("0")){
           AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
       Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Como el precio de compra empezara en 0?? ¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
      Texto_agregar_precioCompra.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
         }
         
         else if (alarmaNumero == false){//verifico que la alarma no sea un numero
           AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
       Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>La alarma debe ser un numero ¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
      Texto_alarma.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
         }
         
         else if(alarma<0){
         AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
       Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>La alarma no puede ser negativa ¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
      Texto_alarma.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
         }
        else {
            if (!"".equals(Texto_agregar_codigo.getText())) {//si Texto_agregar_codigo es diferente de  nulo
               // Operaciones_agregar(Texto_agregar_codigo.getText());//lo mando al metodo de  agregar el producto con el codigo que el usuario dio
               Codigo_barrasPersonalizado();//este metodo es si se quiere un codigo de barras donde el codigo lo introduzcan y no lo genere el programa
            } else {
                Codigo_barras(); //no es campo vacio me voy a la clase de operaciones
            }

        }


    }//GEN-LAST:event_Boton_okActionPerformed

    private void Boton_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_copiarActionPerformed
    
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        ImageIcon image = (ImageIcon) Label_codigo_barras.getIcon(); //PARA PODER COPIAR EL CODIGO
        ImageSelection dh = new ImageSelection(image.getImage());
        cb.setContents(dh, null);
         AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();

    }//GEN-LAST:event_Boton_copiarActionPerformed

    private void Texto_agregar_precioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_agregar_precioCompraActionPerformed

    }//GEN-LAST:event_Texto_agregar_precioCompraActionPerformed

    private void Texto_agregar_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_agregar_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_agregar_codigoActionPerformed

    private void Texto_agregar_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_agregar_inventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_agregar_inventarioActionPerformed

    private void Texto_alarmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_alarmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_alarmaActionPerformed

    public void Codigo_barrasPersonalizado(){
    
         
        try {
Barcode barcode = null;
            barcode = BarcodeFactory.createCode128(Texto_agregar_codigo.getText());//le asigno el codigo pa q genere las barras

            barcode.setBarWidth(2);//largo de las  barras
            barcode.setBarHeight(60); //ancho de las barras
            BufferedImage image = new BufferedImage(300, 100, BufferedImage.TYPE_INT_ARGB); // ,top
            Graphics2D g = (Graphics2D) image.getGraphics();

            barcode.draw(g, 5, 20);

            ImageIcon icon = new ImageIcon(image);
            FileOutputStream fos = new FileOutputStream("BD/BD/codigo.png");
            BarcodeImageHandler.writePNG(barcode, fos);
            rsscalelabel.RSScaleLabel.setScaleLabel(Label_codigo_barras, "BD/BD/codigo.png");

            Boton_copiar.setVisible(true);

            // jLabel2.setIcon(icon);
            Operaciones_agregar(Texto_agregar_codigo.getText());//lo envio a que agregue el codigo al excel
        } catch (FileNotFoundException ex) {
          AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se encontro la imagen del codigo!! </b>⊙﹏⊙", "uh! ⊙﹏⊙✘", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (Exception z) {
            AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ●︿● vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
        }

    
    }
    
    
    
    public void Codigo_barras() {
      
        try {
              String a = Integer.toString((int) (Math.random() * 9));
        String b = Integer.toString((int) (Math.random() * 9));
        String c = Integer.toString((int) (Math.random() * 9));//para generar el codigo de barras
        String d = Integer.toString((int) (Math.random() * 9));
        String e = Integer.toString((int) (Math.random() * 9));

        String codigo_barras = a + b + c + d + e;//sumo los numeros aleatorios, tipo 1+2 = 12
        Barcode barcode = null;

            barcode = BarcodeFactory.createCode128(codigo_barras);//le asigno el codigo pa q genere las barras

            barcode.setBarWidth(2);//largo de las  barras
            barcode.setBarHeight(60); //ancho de las barras
            BufferedImage image = new BufferedImage(300, 100, BufferedImage.TYPE_INT_ARGB); // ,top
            Graphics2D g = (Graphics2D) image.getGraphics();

            barcode.draw(g, 5, 20);

            ImageIcon icon = new ImageIcon(image);
            FileOutputStream fos = new FileOutputStream("BD/BD/codigo.png");
            BarcodeImageHandler.writePNG(barcode, fos);
            rsscalelabel.RSScaleLabel.setScaleLabel(Label_codigo_barras, "BD/BD/codigo.png");

            Boton_copiar.setVisible(true);

            // jLabel2.setIcon(icon);
            Operaciones_agregar(codigo_barras);//lo envio a que agregue el codigo al excel
        } catch (FileNotFoundException ex) {
          AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se encontro la imagen del codigo!! </b>⊙﹏⊙", "uh! ⊙﹏⊙✘", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (Exception z) {
            AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ●︿● vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
        }

    }

    public void Operaciones_agregar(String codigo_barras)  {

        try {
            int contadorColumnas = 0;
            int contadorFilas = 3; //3 ya que la primera posicion del excel a agregar es 3
            int alarmaPersonalizadaProducto=0;
            int inventario=0;
            boolean estado = true;
            FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));
           //este es por si el excel tiene clave
             // XSSFWorkbook wb = (XSSFWorkbook) WorkbookFactory.create(new File("Cuentas e inventario IRIS.xlsx"), ("a")); 
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);//con q hoja empezaremos

            while (estado == true) {
                XSSFRow fila = sheet.getRow(contadorFilas);//numero de filas filas

                if (fila == null)//si la fila no es nula no entra y el contador de filas se incrementa, es decir mirara la sgte fila
                {
                    fila = sheet.createRow(contadorFilas);//cuando la fila sea nula entra al if y segun el contador esa sera la fila a escribir

                    XSSFCell celda = fila.createCell(0);//sera la primera columna ya que es la de codigos de productos

                    celda.setCellValue(codigo_barras);//se lo asigno

                    celda = fila.createCell(1);//la segunda sera para guardar el nombre 

                    celda.setCellValue(Texto_agregarProducto.getText());//lo que el usuario ingreso es decir el nombre del producto l oagrego a la celda

                    celda = fila.createCell(2);//en la tercera va el precio de compra
                    celda.setCellValue(Texto_agregar_precioCompra.getText());

                    celda = fila.createCell(3);//en la cuarta va el inventario del producto
                    celda.setCellValue(Texto_agregar_inventario.getText());
                    
                    
                    
                    
                      sheet = wb.getSheetAt(2);//con q hoja empezaremos, ahora le asignaremos estos valores a la hoja 3, solo la alarma
                       fila = sheet.createRow(contadorFilas);//
                     celda = fila.createCell(0);//sera la primera columna ya que es la de codigos de productos

                    celda.setCellValue(codigo_barras);//se lo asigno
                    celda = fila.createCell(1);//y en la posicion 2 el nombre

                    celda.setCellValue(Texto_agregarProducto.getText());
                    
                     celda = fila.createCell(2);//y en la posicion 3 la alarma

                    celda.setCellValue(Texto_alarma.getText());
                      
                      
                   
                    
                    
                    try {//guardo para mas abajo saber si poner color a la celda de inventario 
                        file.close();

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();

                    } catch (Exception e) {
                      AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> ✘o(╥﹏╥)o✘", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                 break;
                    }
                    
                    
                    sheet = wb.getSheetAt(2);//voy a la hoja 3
            fila = sheet.getRow(contadorFilas);  
              celda = fila.getCell(2);//cojo la alarma personalizada del producto
           alarmaPersonalizadaProducto = Integer.parseInt(Texto_alarma.getText());// y se la asigno a la variable
           inventario = Integer.parseInt(Texto_agregar_inventario.getText());
           //vere el inventario ya es menor o igual a la alarma
             
           if(alarmaPersonalizadaProducto>= inventario){//si el inventario es menor o igual a la alarma
         sheet = wb.getSheetAt(0);//me devuelvo a la hoja 1
            fila = sheet.getRow(contadorFilas);  //obtengo la posicion del producto
              celda = fila.getCell(3);//cojo la alarma personalizada del producto
         
          XSSFCellStyle style1 = wb.createCellStyle(); 
          style1.setFillForegroundColor(HSSFColor.RED.index);//y le pongo color rojo al inventario
          style1.setFillPattern(CellStyle.SOLID_FOREGROUND); 
                 celda.setCellStyle(style1);//y se lo asigno a la celda

           }
           

             estado = false;//paso el estado a falso para que no siga el while
            try {
                        file.close();

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/guardado.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>Se Guardo " + Texto_agregarProducto.getText() + " con exito!✔</b> ٩(•̮̮̃•̃)۶", "Guardado ◕ ‿‿ ◕", JOptionPane.INFORMATION_MESSAGE, icon);
                        Texto_agregarProducto.setText("");
                        Texto_agregar_precioCompra.setText("");
                        Texto_agregar_inventario.setText("");
                        Texto_agregar_codigo.setText("");
                        Texto_alarma.setText("");
                        Texto_agregarProducto.requestFocus();
                    } catch (Exception e) {
                      AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> ✘o(╥﹏╥)o✘", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                    }

                } else {
                    XSSFCell celda = fila.getCell(0); //voy verificando en cada fila la primera celda si el codigo no se repite

                    if (codigo_barras.equals(celda.getStringCellValue())) { //si el codigo  es igual a la celda del excel...
                    AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>Se repite el codigo ●︿●  vuelve a intentarlo o digita uno nuevo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                        estado = false;
                        
                        try {
                               file.close();//guardo y cierro el archivo
                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
                        } catch (Exception e) {//si da error al guardar
                            AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido2.play();
                           Icon icon2 = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                      
                           JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon2);
                        }
                      

                    }
                }
                contadorFilas++;
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
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_copiar;
    private javax.swing.JButton Boton_ok;
    private javax.swing.JLabel Label_codigo_barras;
    private javax.swing.JTextField Texto_agregarProducto;
    private javax.swing.JTextField Texto_agregar_codigo;
    private javax.swing.JTextField Texto_agregar_inventario;
    private javax.swing.JTextField Texto_agregar_precioCompra;
    private javax.swing.JTextField Texto_alarma;
    // End of variables declaration//GEN-END:variables
}
