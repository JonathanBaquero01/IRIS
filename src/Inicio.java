

import PlaceHolder.PlaceHolder;
import java.applet.AudioClip;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Inicio extends javax.swing.JFrame {
   
int contadorFilasCliente=1;//para tener siempre donde esta el cliente que busque
    int precioPagar=0;//esto es el precio final que debe pagar el cliente
    ArrayList<String> lista_productos_tabla = new ArrayList<String>();//en esta lista guardare todos los codigos de la tabla, para saber cuanto se repite cada uno
    ArrayList<String> lista_codigos_en_orden = new ArrayList<String>();//aqui alamacenare los codigos pero en el orden en q estan en la tabla sin q se repitan
 ArrayList<Integer> lista_posicionProductosExcel = new ArrayList<Integer>();//guardare en que posicion del excel esta cada codigo que compraran
    public Inicio() {
       /* try {
            administradorFechas();
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
            */
        //llenarEspacios();
        
        initComponents();
       Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
    
        
        try {//ESTO TIENE QUE VER CON LA CLASE FONDOSQING PARA COLOCAR IMAGEN DE FONDO
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("BD/Fondo.jpg")));

            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>(¬､¬)No encontre el fondo, alguien lo movio≖_≖ </b>", "vaya...(¬､¬)", JOptionPane.INFORMATION_MESSAGE, icon);
        }

        diseño_Botones();//llama al metodo para que arregle todos los botones

        this.setBounds(0, 0, 1080, 620); //modifico el ancho y alto por defecti si se minimiza

        // this.setResizable(false); //para que no modifiquen el ancho y no se agrande
        this.setLocationRelativeTo(this); // para que este en el centro de la pantalla

        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/IRIS.png"));//le coloco el icono a la aplicacion

        this.setIconImage(icono);

        this.setExtendedState(Inicio.MAXIMIZED_BOTH); // para que inicie ocupando toda la pantalla

          
    }
public void administradorFechas() throws FileNotFoundException, IOException {
    
  int contadorFilas = 6;//la inicialiso en 6 ya que empieza en la fila 5
  //throws FileNotFoundException, IOException
   boolean estado = true;

        Date myDate = new Date();
        //XSSFCell myCell = null;

        FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);//con q hoja empezaremos
        while (estado == true) {
            XSSFRow fila = sheet.getRow(1);//en que parte de la columna 1 empezaremos
            XSSFCell celda = fila.getCell(contadorFilas);//que fila cogeremos

            try {

                if (new SimpleDateFormat("dd-MM-yyyy").format(myDate).equals(celda.getStringCellValue())) { //si la fecha es igual a la fecha del excel...
                    estado = false;

                    try {
                        file.close();

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();

                    } catch (Exception e) {
                      AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido2.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>Hubo un error al guardar el excel, intentalo de nuevo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                    }

                } else {
                    contadorFilas = contadorFilas + 5;
                }

            } catch (Exception e) {//si llega a ser  vacia dara un error y lo mandare  aun catch

                celda = fila.createCell(contadorFilas);//numero de la fila

                celda.setCellValue(new SimpleDateFormat("dd-MM-yyyy").format(myDate));//le asigno la fecha
                estado = false;
                try {
                    file.close();

                    FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                    wb.write(output);
                    output.close();

                } catch (IOException e2) {
                   AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido2.play();
                    Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                    JOptionPane.showMessageDialog(null, "<html><b>Hubo un error al guardar el excel, intentalo de nuevo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                }

            }

        }
}
    public void diseño_Botones() {//hara unos arreglos a todos los botones, quitar bordes, que deje solo la imagen
        

        Boton_ok.setOpaque(false);
        Boton_ok.setContentAreaFilled(false);
        Boton_ok.setBorderPainted(false);

        Boton_ok_eliminar.setOpaque(false);
        Boton_ok_eliminar.setContentAreaFilled(false);
        Boton_ok_eliminar.setBorderPainted(false);

        Boton_admin.setOpaque(false);
        Boton_admin.setContentAreaFilled(false);
        Boton_admin.setBorderPainted(false);

        Boton_borrarLista.setOpaque(false);
        Boton_borrarLista.setContentAreaFilled(false);
        Boton_borrarLista.setBorderPainted(false);
        
               Boton_comprar.setOpaque(false);
        Boton_comprar.setContentAreaFilled(false);
        Boton_comprar.setBorderPainted(false);
        
         PlaceHolder placeholder = new PlaceHolder("Eliminar", Texto_eliminar);
         placeholder = new PlaceHolder("Codigo item", Texto_codigo);
          placeholder = new PlaceHolder("Precio item", Texto_Precio);
           placeholder = new PlaceHolder("ID cliente", Texto_ID);

        //aqui modifico la letra de los titulos de la tabla
        JTableHeader th;
        th = tabla.getTableHeader();
        Font fuente = new Font("Vijaya", Font.BOLD, 28);
        th.setFont(fuente);

       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Texto_codigo = new javax.swing.JTextField();
        Boton_ok = new javax.swing.JButton();
        Boton_admin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        Texto_eliminar = new javax.swing.JTextField();
        Boton_ok_eliminar = new javax.swing.JButton();
        Boton_borrarLista = new javax.swing.JButton();
        Label_totalPagar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Boton_comprar = new javax.swing.JButton();
        Texto_ID = new javax.swing.JTextField();
        Texto_Precio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Texto_Pago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setSize(new java.awt.Dimension(1280, 720));

        Texto_codigo.setFont(new java.awt.Font("Tempus Sans ITC", 3, 30)); // NOI18N
        Texto_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_codigo.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_codigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_codigo.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_codigoActionPerformed(evt);
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

        Boton_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Admin.png"))); // NOI18N
        Boton_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_admin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Admin2.png"))); // NOI18N
        Boton_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_adminActionPerformed(evt);
            }
        });

        tabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla.setFont(new java.awt.Font("Vijaya", 0, 28)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "ID cliente", "Cliente", "Codigo", "Producto", "Cantidad", "Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tabla.setRowHeight(25);
        tabla.setRowMargin(0);
        tabla.setSelectionBackground(new java.awt.Color(255, 51, 255));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(142);
            tabla.getColumnModel().getColumn(0).setHeaderValue("Fecha");
            tabla.getColumnModel().getColumn(1).setPreferredWidth(170);
            tabla.getColumnModel().getColumn(1).setHeaderValue("ID cliente");
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setHeaderValue("Cliente");
            tabla.getColumnModel().getColumn(3).setPreferredWidth(140);
            tabla.getColumnModel().getColumn(3).setHeaderValue("Codigo");
            tabla.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(4).setHeaderValue("Producto");
            tabla.getColumnModel().getColumn(5).setPreferredWidth(113);
            tabla.getColumnModel().getColumn(5).setHeaderValue("Cantidad");
            tabla.getColumnModel().getColumn(6).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(6).setHeaderValue("Venta");
        }

        Texto_eliminar.setFont(new java.awt.Font("Tempus Sans ITC", 3, 30)); // NOI18N
        Texto_eliminar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_eliminar.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_eliminar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_eliminar.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_eliminarActionPerformed(evt);
            }
        });

        Boton_ok_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        Boton_ok_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_ok_eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok2.png"))); // NOI18N
        Boton_ok_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ok_eliminarActionPerformed(evt);
            }
        });

        Boton_borrarLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrarLista.png"))); // NOI18N
        Boton_borrarLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_borrarLista.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrarLista2.png"))); // NOI18N
        Boton_borrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_borrarListaActionPerformed(evt);
            }
        });

        Label_totalPagar.setFont(new java.awt.Font("Vijaya", 1, 30)); // NOI18N
        Label_totalPagar.setText("0");

        jLabel4.setFont(new java.awt.Font("Vijaya", 1, 36)); // NOI18N
        jLabel4.setText("Total:");

        Boton_comprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Comprar.png"))); // NOI18N
        Boton_comprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Boton_comprar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Comprar2.png"))); // NOI18N
        Boton_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_comprarActionPerformed(evt);
            }
        });

        Texto_ID.setFont(new java.awt.Font("Tempus Sans ITC", 3, 30)); // NOI18N
        Texto_ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_ID.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_ID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_ID.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_IDActionPerformed(evt);
            }
        });

        Texto_Precio.setFont(new java.awt.Font("Tempus Sans ITC", 3, 30)); // NOI18N
        Texto_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_Precio.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_Precio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_Precio.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_Precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_PrecioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Vijaya", 1, 40)); // NOI18N
        jLabel7.setText("Pago:");

        Texto_Pago.setFont(new java.awt.Font("Tempus Sans ITC", 3, 30)); // NOI18N
        Texto_Pago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Texto_Pago.setCaretColor(new java.awt.Color(255, 0, 204));
        Texto_Pago.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Texto_Pago.setSelectionColor(new java.awt.Color(255, 51, 204));
        Texto_Pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto_PagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Texto_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                        .addComponent(Texto_Precio)
                        .addComponent(Texto_ID, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Texto_eliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(Boton_ok_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Boton_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_borrarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_totalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton_comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Texto_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Texto_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Boton_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Texto_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Boton_ok_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Label_totalPagar)
                                    .addComponent(jLabel4))
                                .addGap(53, 53, 53))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(Texto_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addComponent(Boton_comprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(Boton_borrarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(Boton_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarEspacios(){//al eliminar un producto si detecta un espacio vacio hasta ahi llega y deja de eliminar la fila, por lo cual, al iniciar el programa llenare todos los campos vacios de cada producto EN LA FECHA DE HOY
        try {
              int contadorFilas_fecha = 6;//la inicialiso en 6 ya que empieza en la fila 5
              int contadorColumnas_Productos=3;//hare operaciones por cada producto, en la posicion 4 esta el primer producto
int contador_filasVaciasAtras=0;
              boolean estado = true;
   boolean estado2=true;
   boolean estado3=true;

        Date myDate = new Date();
        //XSSFCell myCell = null;

        FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);//con q hoja empezaremos
            
      while (estado == true) {
          
            XSSFRow fila = sheet.getRow(1);//en que parte de la columna 1 empezaremos
            XSSFCell celda = fila.getCell(contadorFilas_fecha);//que fila cogeremos
        
            if (new SimpleDateFormat("dd-MM-yyyy").format(myDate).equals(celda.getStringCellValue())) { //si la fecha es igual a la fecha del excel...
                    estado = false;
                   
                    while(estado2==true){//aqui procedemos a llenar los campos vacios
                        fila = sheet.getRow(contadorColumnas_Productos);//numero de filas, verificare cada columna del producto a ver cuando es nula
                        if(fila==null){
                        estado2=false;
                        }
                        else{
                            
                            try {
                                celda = fila.getCell(contadorFilas_fecha-2);
                                if (celda.getStringCellValue() != null) { //si es diferente de vacio
                            //no quiero que haga nada
                               
                                    }
                                }
                             catch (Exception e) {//cuando sea nula dara un error asi que aprovecho y lo mando a un catch       
                         celda = fila.createCell(contadorFilas_fecha-2);//numero de la fila, como tenemos la posicon de la fecha le restaremos -2 , -1 , 0 +1 y +2 ya que hay estan las posiciones a llenar

                celda.setCellValue("´");//le doy un valor para llenarla
                             }
                            /////////////////////////////////////////////////////////////////////////////
                               try {
                                celda = fila.getCell(contadorFilas_fecha-1);
                                if (celda.getStringCellValue() != null) { //si es diferente de vacio
                            //no quiero que haga nada
                               
                                    }
                                }
                             catch (Exception e) {//cuando sea nula dara un error asi que aprovecho y lo mando a un catch       
                         celda = fila.createCell(contadorFilas_fecha-1);//numero de la fila, como tenemos la posicon de la fecha le restaremos -2 , -1 , 0 +1 y +2 ya que hay estan las posiciones a llenar

                celda.setCellValue("´");//le doy un valor para llenarla
                             }
                      //////////////////////////////////////////////////////////////////////////////      
                try {
                                celda = fila.getCell(contadorFilas_fecha);
                                if (celda.getStringCellValue() != null) { //si es diferente de vacio
                            //no quiero que haga nada
                               
                                    }
                                }
                             catch (Exception e) {//cuando sea nula dara un error asi que aprovecho y lo mando a un catch       
                         celda = fila.createCell(contadorFilas_fecha);//numero de la fila, como tenemos la posicon de la fecha le restaremos -2 , -1 , 0 +1 y +2 ya que hay estan las posiciones a llenar

                celda.setCellValue("´");//le doy un valor para llenarla
                             }
                
                  //////////////////////////////////////////////////////////////////////////////      
                try {
                                celda = fila.getCell(contadorFilas_fecha+1);
                                if (celda.getStringCellValue() != null) { //si es diferente de vacio
                            //no quiero que haga nada
                               
                                    }
                                }
                             catch (Exception e) {//cuando sea nula dara un error asi que aprovecho y lo mando a un catch       
                         celda = fila.createCell(contadorFilas_fecha+1);//numero de la fila, como tenemos la posicon de la fecha le restaremos -2 , -1 , 0 +1 y +2 ya que hay estan las posiciones a llenar

                celda.setCellValue("´");//le doy un valor para llenarla
                             }
                
                //////////////////////////////////////////////////////////////////////////////      
                try {
                                celda = fila.getCell(contadorFilas_fecha+2);
                                if (celda.getStringCellValue() != null) { //si es diferente de vacio
                            //no quiero que haga nada
                               
                                    }
                                }
                             catch (Exception e) {//cuando sea nula dara un error asi que aprovecho y lo mando a un catch       
                         celda = fila.createCell(contadorFilas_fecha+2);//numero de la fila, como tenemos la posicon de la fecha le restaremos -2 , -1 , 0 +1 y +2 ya que hay estan las posiciones a llenar

                celda.setCellValue("´");//le doy un valor para llenarla
                             }
                
                
                    contador_filasVaciasAtras= contadorFilas_fecha-3;//menos 3 ya que vere si las anteriores celdas son vacias
                    estado3=true;
                   while(estado3==true){
                       //ahora vere si en las anteriores fechas ahi campos vacios, asi que los lleno
                        try {
                            celda = fila.getCell(contador_filasVaciasAtras);
                           
                            if(celda.getStringCellValue()!=null){ //verifica si la celda anterior es nula
                        //si es diferente de  nulo, es decir que hay un valor
                        estado3=false;
                        }
                            
                        } catch (Exception e) {//cuando sea nula dara error, asi q pondre en el catch lo que hara en un else
                             celda = fila.createCell(contador_filasVaciasAtras);
                celda.setCellValue("´");//lleno la celda vacia
                contador_filasVaciasAtras--;//voy a la celda anterior a ver si tambien  esta vacia
                        }
                         
                        
                    }
                
                        contadorColumnas_Productos++;
                        }
                    
                    }
            }
            else{
            contadorFilas_fecha = contadorFilas_fecha + 5;//si va al else es que la fecha es diferente asi q pasara a la sgte celda de fecha
            }
            
      }
      
      try {
                    file.close();

                    FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                    wb.write(output);
                    output.close();

                } catch (IOException e2) {
                   AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido2.play();
                    Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                    JOptionPane.showMessageDialog(null, "<html><b>Hubo un error al guardar el excel, intentalo de nuevo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                }
      
        } 
        catch (FileNotFoundException ex) {
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
    
    private void Texto_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_codigoActionPerformed

    }//GEN-LAST:event_Texto_codigoActionPerformed

    private void Boton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_okActionPerformed
       long IDcliente =0;//vere si el ID del cliente es un numero
       int precio =0;
       int precioTabla=0;

       int contadorCodigoProducto2=0;//para saber en que posicion esta el codigo del producto en la tabla
       boolean IDclienteoPrecio_numero=true;
       boolean EstaElCodigoEnLaTabla=false;
        String Codigotabla="";
        try {
            IDcliente= Long.parseLong(Texto_ID.getText());
            precio= Integer.parseInt(Texto_Precio.getText());
        } catch (Exception e) {
            IDclienteoPrecio_numero=false;
        }
        if ("".equals(Texto_codigo.getText()) || "".equals(Texto_ID.getText()) || "".equals(Texto_Precio.getText())) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Uno de los campos esta vacio :c¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
           
        } 
        
        else if(IDclienteoPrecio_numero==false){
         AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El ID del cliente  o el precio debe ser un numero¯\\_(ツ)_/¯</b>", "¯\\(o_o)/¯ pffff", JOptionPane.INFORMATION_MESSAGE, icon);
            Texto_ID.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        
        }
        else if(precio<=0){
        AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El precio debe ser mayor a 0¯\\_(ツ)_/¯</b>", "¯\\(o_o)/¯ pffff", JOptionPane.INFORMATION_MESSAGE, icon);
            Texto_Precio.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        
        }
        
           else if(Texto_Precio.getText().startsWith("0")){
        AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El precio no puede empezar con 0¯\\_(ツ)_/¯</b>", "¯\\(o_o)/¯ ", JOptionPane.INFORMATION_MESSAGE, icon);
            Texto_Precio.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        
        }
        
        else {
            try {//solo debe a ver un cliente por compra, verificare si no cambia el ID
                     Object obj = tabla.getValueAt(0,1);//columna , fila --> vere si hay un cliente ya comprando, vere si hay un ID en la priemra columna
                                       
                      String ClienteactualString= obj.toString();//tengo que pasarlo a string y luego a int o da error
                     long Clienteactual= Long.parseLong(ClienteactualString);
                    long clienteEnLa_cajaDeTexto= Long.parseLong(Texto_ID.getText());
                    if(Clienteactual!=clienteEnLa_cajaDeTexto){
                        AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Solo un cliente por compra¯\\_(ツ)_/¯</b>", "¯\\(o_o)/¯ pffff", JOptionPane.INFORMATION_MESSAGE, icon);
            Texto_ID.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                    }
                    
                    else{//si es igual  el cliente pasa al else
                        //vere si el codigo esta en la tabla
                          for (int i = 0; i < tabla.getRowCount(); i++) {
				contadorCodigoProducto2=i;
                                Object obj3= tabla.getValueAt(contadorCodigoProducto2,3);//columna , fila --> obtengo el codigo del producto 
                                       
                       Codigotabla= obj3.toString();//tengo que pasarlo a string y luego a int o da error
                      //si el codigo ingresado es igual al de la tabla...
                    if(Codigotabla.equals(Texto_codigo.getText())){
                        EstaElCodigoEnLaTabla=true;
                    break;
                    }
				
			}
                        
                        //con este if verificare si el codigo ingresado del producto ya esta en la tabla o no
                        if(EstaElCodigoEnLaTabla==true){
                        
                   
                        //lo que hare es comprobar si el precio del producto es igual al que esta en la tabla, deben ser iguales
               
                        //ya habia calculado donde esta el producto en la tabla
                          Object obj2= tabla.getValueAt(contadorCodigoProducto2,6);//columna , fila --> obtengo el precio de la tabla
                                       
                      String precioTablaString= obj2.toString();//tengo que pasarlo a string y luego a int o da error
                      precioTabla= Integer.parseInt(precioTablaString);
                      
                      //si es igual el precio ingresado al de la tabla
                      if(precioTabla== Integer.parseInt(Texto_Precio.getText())){
                          Object obj3= tabla.getValueAt(0,2);//columna , fila --> cogere el nombre del lciente de la primera columna                                      
                      String NombreCliente= obj3.toString();
                       Object obj4= tabla.getValueAt(0,1);//columna , fila --> cogere elID del cliente de la primera columna
                        String IDclienteString= obj4.toString();
                         IDcliente=Long.parseLong(IDclienteString);
                         
                         
                          Operaciones_Excel(IDcliente, NombreCliente);//voy a las operaciones y le paso el ID y el codigo
                      
                       
                                
                      }
                      else{//si no, doy una advertencia
                             AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El precio del mismo producto debe ser igual ⊙﹏⊙</b>", "●︿●", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_Precio.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                      }
                    
                    }
                        
                        else{//si pasa al else no esta el codigo en la tabla
                          Object obj3= tabla.getValueAt(0,2);//columna , fila --> cogere el nombre del lciente de la primera columna                                      
                      String NombreCliente= obj3.toString();
                       Object obj4= tabla.getValueAt(0,1);//columna , fila --> cogere elID del cliente de la primera columna
                        String IDclienteString= obj4.toString();
                         IDcliente=Long.parseLong(IDclienteString);
                         
                         
                          Operaciones_Excel(IDcliente, NombreCliente);//voy a las operaciones y le paso el ID y el codigo
                            
                            
                       
                        }
                    }
                
            } catch (Exception e) {//si da error es que no hay cliente
           buscarElCliente();//y lo busco
            }
            
          
        }
    }//GEN-LAST:event_Boton_okActionPerformed

    private void Boton_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_adminActionPerformed
AudioClip  sonido2= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Boton.wav"));
        sonido2.play();
        Ingreso ingreso = new Ingreso();
        ingreso.setTitle("IRIS❤");//para que muestre en el la pantalla esquina superior izquierda un titutlo
        ingreso.setVisible(true);

        dispose();//para cerrar la ventana actual

    }//GEN-LAST:event_Boton_adminActionPerformed

    private void Texto_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_eliminarActionPerformed

    private void Boton_ok_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ok_eliminarActionPerformed
       int precio =0;//este es el precio a restar
        int posicion_producto_tabla = 0;
        int contador_codigo_en_la_tabla = 0;//para saber cuantas veces esta el codigo en la tabla, es decir cuantos productos del mismo tipo se compraran
        boolean codigo_en_tabla = false;
        for (int i = 0; i < lista_codigos_en_orden.size(); i++) {//verifico si el codigo  introducido esta en la lista de codigos de la tabla
            if (lista_codigos_en_orden.get(i).equals(Texto_eliminar.getText())) {//si en tal posicion lo encontro , es q existe en la tabla
                codigo_en_tabla = true; //si existe

            }
        }

        if ("".equals(Texto_eliminar.getText())) { //verifico si ingresaron algo vacio
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No has ingresado nada¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_eliminar.requestFocus();//esto es para que se pueda volver a escribir en el Jtext si tener que clickearlo
        } else if (codigo_en_tabla == false) {
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Ese codigo nisiquiera esta en la tabla¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_eliminar.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        } else {

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); //le digo que ya esta el modelo hecho, se lo doy
            tabla.setModel(modelo);

            for (int i = 0; i < lista_productos_tabla.size(); i++) {//verifico cuantas veces esta el codigo en la tabla
                if (lista_productos_tabla.get(i).equals(Texto_eliminar.getText())) {//si en tal posicion lo encontro le sumo al contador
                    contador_codigo_en_la_tabla++;

                }
            }
            if (contador_codigo_en_la_tabla > 1) {//si es mayor a uno es por q se repite

                lista_productos_tabla.remove(Texto_eliminar.getText());//elimino de  una vez el codigo de la lista, igual se repite el codigo mas de una vez ya que contador_codigo_en_la_tabla es mayor a uno osea hay mas de un producto del mismo tipo

                for (int i = 0; i < lista_codigos_en_orden.size(); i++) {//aqui lo que hare es saber en que posicion esta el codigo, el numero de posicion de la lista es igual al de la columna de la tabla
                    if (lista_codigos_en_orden.get(i).equals(Texto_eliminar.getText())) {//si en tal posicion lo encontro , la posicion la asigno a una variable
                        posicion_producto_tabla = i;

                    }
                }

                contador_codigo_en_la_tabla = contador_codigo_en_la_tabla - 1;//como ya se cuantas veces se repite, solo le restare uno y se lo asigno
                tabla.setValueAt(contador_codigo_en_la_tabla, posicion_producto_tabla, 5);//valor a  modificar , numero columna , numero fila

                
            
                
                
               //aqui obtengo el precio del producto en la tabla
                      Object obj = tabla.getValueAt(posicion_producto_tabla,6);//columna , fila --> la fila siempre estara en la posicion 3
                  
                      
                      String precioString= obj.toString();//tengo que pasarlo a string y luego a int o da error
                      precio= Integer.parseInt(precioString);
                               precioPagar=precioPagar - precio;//lo convierto a int y se lo asigno a precio Pagar
                                Label_totalPagar.setText(Integer.toString(precioPagar));//se lo asigno al label y lo paso a string
                
                Texto_eliminar.setText("");
Texto_eliminar.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
 AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
                    sonido.play();
    }//GEN-LAST:event_Boton_ok_eliminarActionPerformed
   else {//si no es mayor a 1... paso a eliminar esa fila
                
                      for (int i = 0; i < lista_codigos_en_orden.size(); i++) {//aqui lo que hare es saber en que posicion esta el codigo, el numero de posicion de la lista es igual al de la columna de la tabla
                    if (lista_codigos_en_orden.get(i).equals(Texto_eliminar.getText())) {//si en tal posicion lo encontro , la posicion la asigno a una variable
                        posicion_producto_tabla = i;
//vuelvo a repetir ya que si no lo hizo en el if lo hace aqui
                    }
                }

                                  //aqui obtengo el precio del producto en la tabla
                      Object obj = tabla.getValueAt(posicion_producto_tabla,6);//columna , fila --> la fila siempre estara en la posicion 3
                  
                       String precioString= obj.toString();//tengo que pasarlo a string y luego a int o da error
                      precio= Integer.parseInt(precioString);
                               precioPagar=precioPagar - precio;//lo convierto a int y se lo asigno a precio Pagar
                                Label_totalPagar.setText(Integer.toString(precioPagar));//se lo asigno al label y lo paso a string
                
          

                modelo.removeRow(posicion_producto_tabla);//ya habia calculado la posicion del producto en la tabla
                //este for es para saber en que posicion de la lista esta el codigo a eliminar
               
                for (int i = 0; i <lista_codigos_en_orden.size() ; i++) {
                    if(lista_codigos_en_orden.get(i).equals(Texto_eliminar.getText())){//cuando encuentre la posicion....
                    
                        lista_posicionProductosExcel.remove(i);//en esa misma posicion elimina el numero de posicion de producto en el excel, por ejemplo la lista_codigos_en_orden de primer valor esta esmalte, y lista_posicionProductosExcel esta 2 que seria su posicion en el excel
                 
                        break;//para que termine el ciclo
                    }
                }
                
                
                lista_productos_tabla.remove(Texto_eliminar.getText());//elimino de una vez el codigo de la lista, esta vez no se repite
                lista_codigos_en_orden.remove(Texto_eliminar.getText());//en la que los tiene en orden tambien
                 // System.out.println(lista_codigos_en_orden);
              //  System.out.println(lista_posicionProductosExcel);
             

                
Texto_eliminar.setText("");
Texto_eliminar.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
 AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
                    sonido.play();
            }
        }
    }
    private void Boton_borrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_borrarListaActionPerformed

        if (lista_productos_tabla.isEmpty() && lista_codigos_en_orden.isEmpty()) {//veo si las listas estan vacias
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Pero si no hay nada en la tabla¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        } else {

            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Prender.wav"));
            sonido.play();
            int resp = JOptionPane.showConfirmDialog(null, "<html><b> {0_o} Estas seguro de borrar todo?", "Borrar todo??", JOptionPane.INFORMATION_MESSAGE);
            if (JOptionPane.OK_OPTION == resp) {
lista_posicionProductosExcel.clear();
                lista_productos_tabla.clear(); //borro todo lo de las listas
                lista_codigos_en_orden.clear();

                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); //le digo que ya esta el modelo hecho, se lo doy
                int numeroFilas_Tabla = modelo.getRowCount() -1;//averiguo el numero de filas

                for (int i = numeroFilas_Tabla; i >= 0; i--) {//y con un for lo recorro y ya esta
                    modelo.removeRow(i);
                }
                                precioPagar=0;//le asigno el 0
                                Label_totalPagar.setText(Integer.toString(precioPagar));//se lo asigno al label y lo paso a string
                                Texto_codigo.setText("");
                                Texto_ID.setText("");
                                Texto_Precio.setText("");
                                Texto_Pago.setText("");
Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
            }
Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        }

    }//GEN-LAST:event_Boton_borrarListaActionPerformed

    private void Boton_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_comprarActionPerformed
    int vueltos =0;
    int Pagocliente=0;
   
   boolean esPagonumero=true;
        try {
            Pagocliente = Integer.parseInt(Texto_Pago.getText());//lo paso a int
        } catch (Exception e) {//si da error es que no es un numero
            esPagonumero=false;
        }
        if (lista_productos_tabla.isEmpty() && lista_codigos_en_orden.isEmpty()) {//veo si las listas estan vacias
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Pero si no hay nada en la tabla¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
        }
      else if("".equals(Texto_Pago.getText())){
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Nisiquiera se a pagado¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_Pago.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
      
      }
      
      else if(esPagonumero==false){
      AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>En la casilla de pago debe ir un numero :(</b>", "●︿●", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_Pago.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
      }
      
      else if(Pagocliente<=0){
      AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El pago no puede ser menor o igual a 0¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_Pago.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
      }
      
      
      else if(Texto_Pago.getText().startsWith("0")){
       AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El pago no puede empezar en 0¯\\_(ツ)_/¯</b>", "??¯\\(o_o)/¯??", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_Pago.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
      }
      else if(Pagocliente-precioPagar<0){
           AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>El pago no alcanza para la compra :(</b>", "●︿●", JOptionPane.INFORMATION_MESSAGE, icon);
       Texto_Pago.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
      }
      
      else{
          
          try {//aqui ya hare la operacion de ventas
              vueltos= Pagocliente-precioPagar;
              int contadorPosicionFechas=0;//aqui guardare cuantas celdas hacia abajo tomaran las fechas, asi guardo su posicion 
     int Nuevoinventario=0;
     int CantidadAcomprar=0;
     long PrecioCompraMes=0;
     long PrecioVentaMes=0;
     long GananciaBrutaMes=0;
              int contadorColumnasTabla= 0; //contador para ir recorriendo las columnas de la tabla una por una 
              long ComprasClienteActual=0;//para saber el valor actual del excel de cuanto a comprado el cliente
              int contadorFilas=1;//para la hoja de utilidad, la 2
              int contadorLista=0;//servira para recorrer toda la lista, obtener sus posiciones 
              String Mes="";
              String fechaTabla="";//cogere la fecha de la tabla para la hoja 3
              String IDcliente="";
              String NombreCliente="";
              String NombreProducto="";
              int PrecioCompra=0;
              int PrecioVenta=0;
              int GananciaBruta=0;
              int Cantidad=0;
             boolean  estado=true;
             boolean estado2=true;
             int AlarmaPersonalizadaProducto=0; //tomare la alarma personalizada del product
             
             ArrayList<String> lista_informaciontxt = new ArrayList<String>();

                FileReader lector = new FileReader("BD/BD/BD.txt");
                BufferedReader Br = new BufferedReader(lector);

                String bfRead;
                while ((bfRead = Br.readLine()) != null) {//leere la BD para saber el valor de la alarma general

                    lista_informaciontxt.add(bfRead);//tomare toda la informacion que esta en el archivo y lo guardo a una lista

                }
            
                lector.close();
                Br.close();
 
           int Alarmageneral = Integer.parseInt(lista_informaciontxt.get(2));//se lo asigno a alarma general
           lista_informaciontxt.clear();
             
             
             
               FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);//con q hoja empezaremos
              //aqui restara la cantidad que se compro al inventario del producto
            while(estado==true){
                 sheet = wb.getSheetAt(0);//como cambie de hoja en el cilo me devuelvo a la que estaba
                 XSSFRow fila = sheet.getRow(lista_posicionProductosExcel.get(contadorLista));//numero de fila, siempre sera la primera posicion ya que luego al eliminar la posicion la segunda pasa a la primera

              Object obj = tabla.getValueAt(contadorColumnasTabla,5);//columna , fila --> cojere la cantidad del producto en la tabla
                                       
                      String CantidadAcomprarString= obj.toString();//tengo que pasarlo a string y luego a int o da error
                      CantidadAcomprar = Integer.parseInt(CantidadAcomprarString);//vere cuantos productos del mismo tipo se compraran
                      XSSFCell celda = fila.getCell(3);//cogere el inventario del producto actual
                      Nuevoinventario= Integer.parseInt(celda.getStringCellValue());//lo asigno
                      Nuevoinventario = Nuevoinventario-CantidadAcomprar;//el nuevo inventario le resto los prodcuto que se compraron
                     celda.setCellValue(Integer.toString(Nuevoinventario));//y lo agrego al excel
                     celda = fila.getCell(1);//cogere el nombre del producto
                     String nombre=celda.getStringCellValue();
                     
                     if(Nuevoinventario<Alarmageneral){//si el nuevoinventario es menor a la alarma general
                          AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
                    sonido.play();
                    Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                    JOptionPane.showMessageDialog(null, "<html><b>Quedan menos de "+Alarmageneral+" "+nombre+"!! ⊙△⊙</b>", "⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                     
                     }
                 
                     //ahora vamos con la alarma de cada producto, la personalizada
           sheet = wb.getSheetAt(2);//
            fila = sheet.getRow(lista_posicionProductosExcel.get(contadorLista));  
              celda = fila.getCell(2);//cojo la alarma personalizada del producto
           AlarmaPersonalizadaProducto = Integer.parseInt(celda.getStringCellValue());
           //vere el inventario ya es menor o igual a la alarma
             
           if(AlarmaPersonalizadaProducto>= Nuevoinventario){//si el inventario es menor o igual a la alarma
         sheet = wb.getSheetAt(0);//me devuelvo a la hoja 1
            fila = sheet.getRow(lista_posicionProductosExcel.get(contadorLista));  //obtengo la posicion del producto
              celda = fila.getCell(3);//cojo la alarma personalizada del producto
         
          XSSFCellStyle style1 = wb.createCellStyle(); 
          style1.setFillForegroundColor(HSSFColor.RED.index);//y le pongo color rojo al inventario
          style1.setFillPattern(CellStyle.SOLID_FOREGROUND); 
                 celda.setCellStyle(style1);//y se lo asigno a la celda

           }
           
              
                     if(contadorLista==lista_codigos_en_orden.size()-1 ){//si el contador de la lista ya es igual a su tamaño, termino el ciclo
                   //-1 ya que si por ejemplo hay 2 elementos en una lista  el .sise dara 2, pero el contador ira hasta el 1 ya que para obtener el segundo elemento de la lista arrojara 1
                         estado=false;
                    
                     break;
                     
                     }
                     contadorLista++;//le sumo 1 para pasar al siguiente valor de la lista
                      contadorColumnasTabla++;
            }
         //Ahora agregare el valor que  compro el cliente
            sheet = wb.getSheetAt(3);
            
             XSSFRow fila = sheet.getRow(contadorFilasCliente);  //ya se donde esta el cliente
              XSSFCell celda = fila.getCell(3);//cogere el inventario del producto actual//cojo la alarma personalizada del producto
            ComprasClienteActual= Long.parseLong(celda.getStringCellValue());
            ComprasClienteActual= ComprasClienteActual+ precioPagar;
            celda.setCellValue(Long.toString(ComprasClienteActual));
            
             sheet = wb.getSheetAt(1);//ahora me voy a la hoja de 2 de utilidad, los datos de la tabla los pondre en esa hoja
            //recorrere las fechas hasta encontrar una igual o detectar una celda nula
          
             while(estado2==true){//ahora a la hoja de utilidad, este while me dire cual fila esta nula
                  fila = sheet.getRow(contadorFilas);//numero de filas filas
               
                if (fila == null)//si la fila  es nula no entra y el contador de filas se incrementa, es decir mirara la sgte fila
                { estado2=false;
                
                
                 DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); //le digo que ya esta el modelo hecho, se lo doy
                int numeroFilas_Tabla = modelo.getRowCount() -1;//averiguo el numero de filas
Collections.reverse(lista_codigos_en_orden);
Collections.reverse(lista_posicionProductosExcel); //invierto las listas ya que las filas de la tabla se eliminaran de abajo hacia arriba y el orden de las listas estaba de arriba hacia abajo
                for (int i = numeroFilas_Tabla; i >= 0; i--) {//este for dara vueltas segun el numero de columnas de la tabla
                  contadorPosicionFechas++;//le sumo 1 ya que fue una posicion abajo
                    fila = sheet.getRow(contadorFilas);
                   
                   //la columna pongo i ya que es la fila que se eliminara asi que cojo sus valores
                       Object obj2 = tabla.getValueAt(i,0);//columna , fila --> cojere la fecha de la tabla, me sirve la de cualquier producto, cogere la del primero                                      
                       fechaTabla= obj2.toString();
                      fila = sheet.createRow(contadorFilas);//cuando la fila sea nula entra al if y segun el contador esa sera la fila a escribir
                     celda = fila.createCell(0);//sera la primera celda ya que es la de fecha 
                    celda.setCellValue(fechaTabla);//se lo asigno
                    
                    Object obj3 = tabla.getValueAt(i,1);//columna , fila --> ahora cogere el ID del cliente
                IDcliente= obj3.toString();
                celda = fila.createCell(1);//sera la segunda celda ya que es la de iDcliente
                    celda.setCellValue(IDcliente);//se lo asigno
                  
                    Object obj4 = tabla.getValueAt(i,2);//columna , fila --> ahora cogere el nombre del cliente
                NombreCliente= obj4.toString();
                celda = fila.createCell(2);//sera la tercera celda ya que es la de nombre cliente
                    celda.setCellValue(NombreCliente);//se lo asigno
                    
                    
                    
                    Object obj5 = tabla.getValueAt(i,4);//columna , fila --> ahora cogere el nombre del producto
                NombreProducto= obj5.toString();
                celda = fila.createCell(3);//sera la cuarta celda ya que es la de nombre del producto
                    celda.setCellValue(NombreProducto);//se lo asigno
                    
                     Object obj8 = tabla.getValueAt(i,5);//columna , fila --> ahora cogere la cantidad del producto
                String CantidadString= obj8.toString();               
                celda = fila.createCell(4);//sera la quibta celda ya que es la de cantidad del producto comprado
                    celda.setCellValue(CantidadString);//se lo asigno
                    
                    
                    
                    
                     sheet = wb.getSheetAt(0);//ire a la hoja 1 a traer el precio de compra del producto
                      fila = sheet.getRow(lista_posicionProductosExcel.get(0));//siempre cogere la posicion 1 ya que al final elimina la posicion 1 y la segunda pasa a la primera
                      celda = fila.getCell(2);//cojo el precio de compra del producto
                      PrecioCompra= Integer.parseInt(celda.getStringCellValue());//y lo asigno a una variable                   
                      sheet = wb.getSheetAt(1);//me devuelvo a la hoja de utilidad
                       fila = sheet.getRow(contadorFilas);//lo reposiciono en la fila
                        celda = fila.createCell(5);//sera la sexta celda
                        PrecioCompra=PrecioCompra* Integer.parseInt(CantidadString);
                    celda.setCellValue(Integer.toString(PrecioCompra));//se lo asigno
                    
                    
                     sheet = wb.getSheetAt(1);//me devuelvo a la hoja de utilidad
                       Object obj6 = tabla.getValueAt(i,6);//columna , fila --> ahora cogere el precio de venta del producto
                String PrecioVentaString= obj6.toString();
                PrecioVenta = Integer.parseInt(PrecioVentaString);            
               PrecioVenta= PrecioVenta* Integer.parseInt(CantidadString);//lo que hago es multiplicar el precio de venta del producto por su cantidad   
                celda = fila.createCell(6);//sera la septima ahi va el preciode venta del producto
                    celda.setCellValue(Integer.toString(PrecioVenta));//se lo asigno
                   
                    
                     celda = fila.createCell(7);//y la septima que es ganancia bruta, que es una resta y ya
                     GananciaBruta=PrecioVenta;
                     GananciaBruta=GananciaBruta-PrecioCompra;
                     //si la ganancia bruta llega a ser negativa el precio de venta esta mal asi que reinicio todo                                    
                      celda.setCellValue(Integer.toString(GananciaBruta));//se lo asigno
                    
                      contadorFilas++;//para que vaya a la sgte fila a llenar
                    modelo.removeRow(i);
                    lista_codigos_en_orden.remove(0);
                    lista_posicionProductosExcel.remove(0);
                    
                    
                }
                  
                
                
                
                  
                }
                

                else{//si no es nula paso al else
                
                contadorFilas++;
                }
            
                 }
                // ahora todo lo que se compro lo agregare al mes
                contadorFilas--;//aqui esta la posicion de la ultima fecha, le quito 1 ya que tiene una posicion mas abajo demas
               //contadorPosicionFechas tiene el numero de columnas quee bajo registrando fechas, asi que si lo recorro hasta disminuirlo a 0 llegara hasta la primera fecha que registro
               //contadorFilas tiene la posicion de la ultima fecha que registramos
               
               //cuanto i llegue a contadorPosicionFechas es que ya llego a la ultima fecha que registramos en esta compra
               sheet = wb.getSheetAt(1);//vamos a la hoja de utilidad
               //haga el ciclo hasta  que i sea igual al contadorPosicionFechas, que es el numero de columnas que usamos para registrar las fechas 
               for (int i = 0; i < contadorPosicionFechas; i++) {
                  
                       fila = sheet.getRow(contadorFilas);
                       celda = fila.getCell(0);//en la celda1 esta la fecha
                       Mes = celda.getStringCellValue();
                       Mes = Mes.substring(3,10);//partire la cadena solo cogiendo el numero del mes, numero de variaboes que elimina, numero de variables que coge
                      Mes = Mes.substring(0, Mes.length() - 5); //aqui elimino desde atras, arriba fue desde adelante, el -5 es cuantas letras eliminara desde atras
                   //ahora segun el mes que sea hara cierta operacion, para saber a que celda ir
                      switch(Integer.parseInt(Mes)){
                      case 1 :
     fila = sheet.getRow(1);//si es el mes 1 que se vaya a la columna del mes 2
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Enero");//y digo que es el mes 1
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(1);//creo la fila del mes 1
                               celda = fila.createCell(9);
                                 celda.setCellValue("Enero");//y digo que es el mes 1
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(1);//lo reposiciono en el ultimo mes que estamos operando
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(1);//lo reposiciono en el mes 1
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(1);//lo reposiciono en la celda de el mes 1
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(1);//me devuelvo a ladel mes 1 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(1);//me devuelvo a ladel mes 1 
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(1);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(1);//me devuelvo a la celda de mes pa registrar el valor
// celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(1);//me devuelvo a la celda de mes pa registrar el valor
  // celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(1);//me devuelvo a la celda de mes pa registrar el valor
  // celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                         break;
                      case 2 :
                         
                          fila = sheet.getRow(2);//si es el mes 2 que se vaya a la columna del mes 2
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Febrero");//y digo que es el mes 1
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(2);//creo la fila del mes 2
                               celda = fila.createCell(9);
                                 celda.setCellValue("Febrero");//y digo que es el mes 1
                          }
  
               
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(2);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(2);//lo reposiciono en el mes 2
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(2);//lo reposiciono en la celda de el mes 2
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(2);//me devuelvo a ladel mes 2 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(2);//me devuelvo a ladel mes 2 
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(2);//me devuelvo al mes 2
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(2);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(2);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(2);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                         break;
                          
                          
                        
                          
                            case 3 :
                                   fila = sheet.getRow(3);//si es el mes 3 que se vaya a la columna del mes 2
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Marzo");//y digo que es el mes 1
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(3);//creo la fila del mes 3
                               celda = fila.createCell(9);
                                 celda.setCellValue("Marzo");//y digo que es el mes 1
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(3);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(3);//lo reposiciono en el mes 3
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(3);//lo reposiciono en la celda de el mes 3
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(3);//me devuelvo a ladel mes 3 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(3);//me devuelvo a ladel mes 2 
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(3);//me devuelvo al mes 3
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(3);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(3);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(3);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                                
                          
                          break;
                            case 4 :
                                   fila = sheet.getRow(4);//si es el mes 4 que se vaya a la columna del mes 4
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Abril");//y digo que es el mes 4
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(4);//creo la fila del mes 4
                               celda = fila.createCell(9);
                                 celda.setCellValue("Abril");//y digo que es el mes 4
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(4);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(4);//lo reposiciono en el mes 4
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(4);//lo reposiciono en la celda de el mes 4
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(4);//me devuelvo a ladel mes 4 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(4);//me devuelvo a ladel mes 4
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(4);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(4);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(4);//me devuelvo a la celda de mes pa registrar el valor
 //  celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(4);//me devuelvo a la celda de mes pa registrar el valor
  // celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                                
                          
                          break;
                            case 5 :
                                   fila = sheet.getRow(5);//si es el mes 5 que se vaya a la columna del mes 5
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Mayo");//y digo que es el mes 5
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(5);//creo la fila del mes 5
                               celda = fila.createCell(9);
                                 celda.setCellValue("Mayo");//y digo que es el mes 5
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(5);//lo reposiciono en el ultimo mes que estamos operando
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(5);//lo reposiciono en el mes 5
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(5);//lo reposiciono en la celda de el mes 5
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(5);//me devuelvo a ladel mes 5 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(5);//me devuelvo a ladel mes 1 
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(5);//me devuelvo a ladel mes 5 para registrar el valor
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(5);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(5);//me devuelvo a la celda de mes pa registrar el valor
  // celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(5);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                            case 6 :
                                    fila = sheet.getRow(6);//si es el mes 6 que se vaya a la columna del mes 6
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Junio");//y digo que es el mes 6
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(6);//creo la fila del mes 6
                               celda = fila.createCell(9);
                                 celda.setCellValue("Junio");//y digo que es el mes 6
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(6);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(6);//lo reposiciono en el mes 6
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(6);//lo reposiciono en la celda de el mes 6
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(6);//me devuelvo a ladel mes 6 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(6);//me devuelvo a ladel mes 6
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(6);
   celda = fila.getCell(12);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que registramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(6);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(6);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(6);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                           
                          break;
                            case 7 :
                                    fila = sheet.getRow(7);//si es el mes 7 que se vaya a la columna del mes 7
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Julio");//y digo que es el mes 7
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(7);//creo la fila del mes 7
                               celda = fila.createCell(9);
                                 celda.setCellValue("Julio");//y digo que es el mes 7
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(7);//lo reposiciono en el ultimo mes
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(7);//lo reposiciono en el mes 7
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(7);//lo reposiciono en la celda de el mes 7
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(7);//me devuelvo a ladel mes 1 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(7);//me devuelvo a ladel mes 7
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(7);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(7);//me devuelvo a la celda de mes pa registrar el valor
// celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(7);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(7);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                          
                            case 8 :
                                    fila = sheet.getRow(8);//si es el mes 8 que se vaya a la columna del mes 8
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Agosto");//y digo que es el mes 8
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(8);//creo la fila del mes 8
                               celda = fila.createCell(9);
                                 celda.setCellValue("Agosto");//y digo que es el mes 8
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(8);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(8);//lo reposiciono en el mes 1
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(8);//lo reposiciono en la celda de el mes 8
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(8);//me devuelvo a ladel mes 8 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(8);//me devuelvo a ladel mes 8
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(8);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(8);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(8);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(8);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                            case 9 :
                                     fila = sheet.getRow(9);//si es el mes 9 que se vaya a la columna del mes 2
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Septiembre");//y digo que es el mes 9
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(9);//creo la fila del mes 9
                               celda = fila.createCell(9);
                                 celda.setCellValue("Septiembre");//y digo que es el mes 9
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(9);//lo reposiciono
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(9);//lo reposiciono en el mes 9
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(9);//lo reposiciono en la celda de el mes 9
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(9);//me devuelvo a ladel mes 9 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(9);//me devuelvo a ladel mes 9
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(9);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(9);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(9);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(9);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                            case 10 :
                                     fila = sheet.getRow(10);//si es el mes 10 que se vaya a la columna del mes 2
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Octubre");//y digo que es el mes 10
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(10);//creo la fila del mes 10
                               celda = fila.createCell(9);
                                 celda.setCellValue("Octubre");//y digo que es el mes 10
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(10);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(10);//lo reposiciono en el mes 1
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(10);//lo reposiciono en la celda de el mes 10
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(10);//me devuelvo a ladel mes 10 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(10);//me devuelvo a ladel mes 10
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(10);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(10);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(10);//me devuelvo a la celda de mes pa registrar el valor
  // celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(10);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                            case 11 :
                                     fila = sheet.getRow(11);//si es el mes 11 que se vaya a la columna del mes 11
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Noviembre");//y digo que es el mes 11
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(11);//creo la fila del mes 11
                               celda = fila.createCell(9);
                                 celda.setCellValue("Noviembre");//y digo que es el mes 11
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(11);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(11);//lo reposiciono en el mes 11
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(11);//lo reposiciono en la celda de el mes 11
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(11);//me devuelvo a ladel mes 1 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(11);//me devuelvo a ladel mes 1 1
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(11);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(11);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(11);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(11);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                           case 12 :
                                   fila = sheet.getRow(12);//si es el mes 12 que se vaya a la columna del mes 12
                          try {
                                celda = fila.createCell(9);//ahora lo dirijo a su fila
                                     celda.setCellValue("Diciembre");//y digo que es el mes 12
                          } catch (Exception e) {//si da error es por que la fila no esta creada
                               fila = sheet.createRow(12);//creo la fila del mes 12
                               celda = fila.createCell(9);
                                 celda.setCellValue("Diciembre");//y digo que es el mes 12
                          }
                          try {
                              celda = fila.getCell(10);//ahora voy a la celda de  precioCompra del mes
                              if (celda.getStringCellValue() != null) { //si es diferente de vacio, es decir hay un valor
                                  fila = sheet.getRow(12);//lo reposiciono 
PrecioCompraMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioCompra del mes que esta ahi
 fila = sheet.getRow(contadorFilas);//lo reposiciono en el ultimo mes que estamos operando
 celda = fila.getCell(5);//ahora cogere el precio compra de la fecha que regitramos
 PrecioCompraMes=PrecioCompraMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(12);//lo reposiciono en el mes 12
 celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
 
  //AHORA LO MISMO PERO CON PRECIO-VENTA
  //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
   fila = sheet.getRow(12);//lo reposiciono en la celda de el mes 12
  celda = fila.getCell(11);
                  PrecioVentaMes=Long.parseLong(celda.getStringCellValue());//obtengo el precioVenta del mes que esta ahi
                   fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(6);//ahora cogere el precio venta de la fecha que registramos
 PrecioVentaMes=PrecioVentaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
 fila = sheet.getRow(12);//me devuelvo a ladel mes 12 para registrar el valor
   celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno                     
                              
  //AHORA LO MISMO PERO CON GANANCIA-BRUTA
    //si precioCompra que es el primero esta lleno, entonces los demas tambien tendran valor
    fila = sheet.getRow(12);//me devuelvo a ladel mes 12
    celda = fila.getCell(12);
                  GananciaBrutaMes=Long.parseLong(celda.getStringCellValue());//obtengo la ganancia bruta del mes que esta ahi
                     fila = sheet.getRow(contadorFilas);
 celda = fila.getCell(7);//ahora cogere la ganancia bruta de la fecha que registramos
 GananciaBrutaMes=GananciaBrutaMes+ Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
    fila = sheet.getRow(12);
   celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno   
                              }
                              
                              
                          } catch (Exception e) {//si la celda es nula dara un error asi que voy a catch usandolo como else
                                fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
                          celda = fila.getCell(5);// cogere el precio compra de la fecha que regitramos
 PrecioCompraMes= Long.parseLong(celda.getStringCellValue()); //y se lo asigno a PrecioCompraMes
  fila = sheet.getRow(12);//me devuelvo a la celda de mes pa registrar el valor
 //celda = fila.getCell(10);//ahora voy a la celda 11 para asignarle el valor
                                celda = fila.createCell(10);//creo la celda ya que como estaba nula no estaba creada
                              
  celda.setCellValue(Long.toString(PrecioCompraMes));//se lo asigno
  
   //AHORA LO MISMO PERO CON PRECIO-VENTA

      fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
 celda = fila.getCell(6);// cogere el precio venta de la fecha que registramos
 PrecioVentaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
     fila = sheet.getRow(12);//me devuelvo a la celda de mes pa registrar el valor
  // celda = fila.getCell(11);//ahora voy a la celda 10 para asignarle el valor
   celda = fila.createCell(11);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(PrecioVentaMes));//se lo asigno  
                      
   //AHORA LO MISMO PERO CON GANANCIA BRUTA
    fila = sheet.getRow(contadorFilas);//voy a la ultima fecha que estamos operando
    celda = fila.getCell(7);// cogere LA GANANCIA BRUTA de la fecha que registramos
 GananciaBrutaMes=Long.parseLong(celda.getStringCellValue()); //y se lo sumo al del mes
  fila = sheet.getRow(12);//me devuelvo a la celda de mes pa registrar el valor
   //celda = fila.getCell(12);//ahora voy a la celda 10 para asignarle el valor
     celda = fila.createCell(12);//creo la celda ya que como estaba nula no estaba creada
  celda.setCellValue(Long.toString(GananciaBrutaMes));//se lo asigno  
                          
                          }

                          contadorFilas--;
                          
                          break;
                          
                          
                      }
                      
                      
                    
                 }
           
             
            try {
                         file.close();

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/guardado.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b><span style=\"font-size:1.5em\">Vueltos: "+vueltos+ " ✔ ٩(•̮̮̃•̃)۶</b>", "✔✔✔✔✔✔✔", JOptionPane.INFORMATION_MESSAGE, icon);
                 Texto_codigo.setText("");//el <span style=\"font-size:1.5em\"> es para asignarle tamaño a la letra
                 Texto_ID.setText("");
                 Texto_Precio.setText("");
                 Texto_Pago.setText("");
                  Label_totalPagar.setText("0");
                  
                   precioPagar=0;  
                   lista_codigos_en_orden.clear();
                     lista_posicionProductosExcel.clear();
                     lista_productos_tabla.clear();
                    
                               
                          Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                          
                            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); //le digo que ya esta el modelo hecho, se lo doy
                int numeroFilas_Tabla = modelo.getRowCount() -1;//averiguo el numero de filas

                for (int i = numeroFilas_Tabla; i >= 0; i--) {//y con un for lo recorro y ya esta
                    modelo.removeRow(i);
                }
                          
                    } catch (Exception e) {
                        
                         AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                        sonido.play();
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                    }
            
           
            
          } catch (FileNotFoundException ex) {
         AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se a encontrado la base de datos o el Excel!! lo moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (IOException ex) {
        AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
        sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ●︿●  vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
        }
      }
    
      
      
      
    }//GEN-LAST:event_Boton_comprarActionPerformed

    private void Texto_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_IDActionPerformed

    private void Texto_PrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_PrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_PrecioActionPerformed

    private void Texto_PagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto_PagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Texto_PagoActionPerformed

    public void buscarElCliente(){
    
        try {
            
            
         long IDcliente = 0;
         String NombreCliente="";
             contadorFilasCliente = 1;//contador de las filas del excel, empiezan desde el 2 del excel
           
            boolean estado = true;

            FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(3);//con q hoja empezaremos, vamos a la de  los clientes
            
                  while (estado == true) {

                XSSFRow fila = sheet.getRow(contadorFilasCliente);//numero de filas 
                if (fila == null)//si la fila es nula, no encontro el codigo
                {   estado = false;
                    AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                    sonido.play();
                    Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                    JOptionPane.showMessageDialog(null, "<html><b>verifica si digito bien el ID del cliente o  registra este nuevo cliente</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

                 
                    try {

                        file.close(); //cierro el archivo

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
                          Texto_ID.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo

                    } catch (Exception e) {//si no guarda
                        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                        sonido2.play();
                        Icon icon2 = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon2);
                    }

                }
                
                if(estado ==false){//si el estado ya es falso rompo el ciclo
                break;
                }
                 XSSFCell celda = fila.getCell(0); //voy verificando en cada fila la primera celda si el codigo se repite
                    if (Texto_ID.getText().equals(celda.getStringCellValue()) && estado == true) {//si el codigo ingresado es igual al codigo que encontro del excel...
                        estado = false;
                         celda = fila.getCell(0); //en la priemra esta el ID               
                        IDcliente= Long.parseLong(celda.getStringCellValue());
                        
                            celda = fila.getCell(1); //en la tercera del excel esta el nombre
                NombreCliente = celda.getStringCellValue();
                       
                         
                Operaciones_Excel(IDcliente , NombreCliente);//ahora voy a las operaciones del excel a llenar la tabla
                      
                    }
                    else{
                    contadorFilasCliente++;//paso a la sgte fila buscando el codigo
                    }
                  }
            
        } catch (FileNotFoundException ex) {
            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se a encontrado el excel!! lo moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (IOException ex) {
            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ●︿●  vuelve a intentarlo!</b>", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    
    }
    
    public void Operaciones_Excel(long IDcliente , String NombreCliente ) {//ya viene con el ID y nombre del cliente del metodo anterior

        try {
 Date myDate = new Date();
            String valorInventario = "";
            int precioCompra=0;
            int valorInventario_int = 0;
            int contadorFilas = 3;//contador de las filas del excel, empiezan desde el 3
            int posicion_producto_tabla = 0; //sabre la posicion en columnas de cierto producto para modificar algo
            int contador_codigos_lista = 0;//contador de cuantas veces se repite un codigo en la lista
            boolean estado = true;
            int inventario = 0;//inventario del producto que se vaya a registrar en la tabla, para saber si se registra o no
            int contador_codigos_lista_para_inventario = 0;//vere cuantas veces se repite un codigo en la lista y que no sobre pase al invetario del excel
            FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);//con q hoja empezaremos

            while (estado == true) {

                XSSFRow fila = sheet.getRow(contadorFilas);//numero de filas 

                if (fila == null)//si la fila es nula, no encontro el codigo
                {
                    AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                    sonido.play();
                    Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                    JOptionPane.showMessageDialog(null, "<html><b>No se encontro el codigo!!</b> \n busca el nombre del producto en el excel y veras el codigo(˘︹˘)", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

                    estado = false;
                    try {

                        file.close(); //cierro el archivo

                        FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                        wb.write(output);
                        output.close();
                          Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo

                    } catch (Exception e) {//si no guarda
                        AudioClip sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                        sonido2.play();
                        Icon icon2 = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon2);
                    }

                }
               

                    if(estado ==false){//si el estado ya es falso rompo el ciclo
                break;
                }
                    XSSFCell celda = fila.getCell(0); //voy verificando en cada fila la primera celda si el codigo se repite

                    if (Texto_codigo.getText().equals(celda.getStringCellValue()) && estado == true) {//si el codigo ingresado es igual al codigo que encontro del excel...
                        estado = false;
                        
                        celda = fila.getCell(2); //cogere el precio de compra
                        precioCompra=  Integer.parseInt(celda.getStringCellValue());
                      
                       if(Integer.parseInt(Texto_Precio.getText())-precioCompra <0){//si precio venta - precio compra es menor a  0 no puede dejar seguir , hay algo mal
                        AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                                sonido.play();
                                Icon icon2 = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                                JOptionPane.showMessageDialog(null, "<html><b>La ganancia bruta da negativa, el precio podria estar mal</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon2);
                            return; //el return en este caso sirve para salir de un metodo
                           
                        }
                        
                      celda = fila.getCell(0);//lo reposiciono en la posicion del codigo
                        lista_productos_tabla.add(celda.getStringCellValue()); //le asigno a la lista el codigo
                        celda = fila.getCell(3);//lo asigno a la posicion del inventario
                        inventario = Integer.parseInt(celda.getStringCellValue());//como ya esta en la posicion del inventario lo paso a int

                        for (int i = 0; i < lista_productos_tabla.size(); i++) {//vere cuantas veces se repite un codigo, segun el numero q se repite es el numero q estara en la tabla
                            if (lista_productos_tabla.get(i).equals(Texto_codigo.getText())) {//recorrera todas las posiciones viendo cuantas veces coinside
                                contador_codigos_lista_para_inventario++;//cada que lo encuentre le sumare uno al contador

                            }
                        }

                        if (inventario < 1) {//si el inventario es menor a 1 es decir 0 no lo dejare hacer las operaciones
                            celda = fila.getCell(0);
                            lista_productos_tabla.remove(celda.getStringCellValue());//elimino el codigo de la lista
                            celda = fila.getCell(1);
                            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
                            sonido.play();
 Texto_codigo.setText("");
  Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                            JOptionPane.showMessageDialog(null, "<html><b>Vaya... no tenemos " + celda.getStringCellValue() + ", inventario vacio ⊙△⊙ </b> ", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                        } else if (inventario < contador_codigos_lista_para_inventario) {//tambn si el inventario ya es menor al numero de productos que se registraran en la tabla...
                            celda = fila.getCell(0);
                            lista_productos_tabla.remove(celda.getStringCellValue());//elimino el codigo de la lista
                            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
                            sonido.play();
                            celda = fila.getCell(1);//lo reasigno a la posicion de nombre
                            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
                            JOptionPane.showMessageDialog(null, "<html><b>Vaya... nos quedan mas " + celda.getStringCellValue() + ", inventario vacio ⊙△⊙ </b> ", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);
                            Texto_codigo.setText("");
                            Texto_Precio.setText("");
                              Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
                        } else {//si el inventario es mayor a 0 pasara al else y hace las operaciones
                            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); //le digo que ya esta el modelo hecho, se lo doy
                            tabla.setModel(modelo);
                            celda = fila.getCell(0);//lo regreso a la posicion del codigo

                            for (int i = 0; i < lista_productos_tabla.size(); i++) { //aqui verificare cuantas veces se repite el codigo en la lista
                                if (lista_productos_tabla.get(i).equals(celda.getStringCellValue())) {//verifico cada posicion, si se repite le sumo al contador
                                    contador_codigos_lista++;//segun el numero de veces que se repita es la cantidad que el cliente comprara

                                }

                            }
                            if (contador_codigos_lista > 1) { //si es mayor a 1 es por q se repite un codigo en la tabla asi q no le agregare mas columnas

                                for (int i = 0; i < lista_codigos_en_orden.size(); i++) {//aqui lo que hare es saber en que posicion esta el codigo, el numero de posicion de la lista es igual al de la columna de la tabla
                                    if (lista_codigos_en_orden.get(i).equals(celda.getStringCellValue())) {//si en tal posicion lo encontro , la posicion la asigno a una variable
                                        posicion_producto_tabla = i;

                                    }
                                }

                                Object[] filas_tabla = new Object[7]; //numero de filas  de la tabla -> ----
                               
                              filas_tabla[0] =  new SimpleDateFormat("dd-MM-yyyy").format(myDate); //en la primera fila va la fecha
                                //filas_tabla[0] = celda = fila.getCell(0);//el codigo esta en la fila 1 del excel
                               // filas_tabla[1] = celda = fila.getCell(1); //el nombre esta en la fila 2 del excel
                               filas_tabla[1] =IDcliente;//en la segunda fila el ID del cliente
                                filas_tabla[2] = NombreCliente; //en la tercera el nombre del cliente
                                filas_tabla[3] = celda = fila.getCell(0);// en la cuarta el codigo del producto, el codigo esta en la fila 1 del excel
                                // filas_tabla[2] = contador_codigos_lista;//esta es la cantidad de productos q va a comprar el cliente
                                filas_tabla[4] = celda = fila.getCell(1); //en la quinta el nombre del producto, esta en la fila 2 del excel
                                filas_tabla[5] = contador_codigos_lista;//en la sexta esta es la cantidad de productos q va a comprar el cliente
                               // filas_tabla[3] = celda = fila.getCell(2); //el precio de compra esta en la fila 3 del excel     
                                filas_tabla[6] = Texto_Precio.getText(); //el precio de compra lo dijita el usuario    
                                tabla.setValueAt(contador_codigos_lista, posicion_producto_tabla, 5);//valor a  modificar - numero columna - numero fila
                                
                                // celda = fila.getCell(2);//vuelvo a asignar la celda en la posicion 3 que esta el precio
                                precioPagar=precioPagar + Integer.parseInt(Texto_Precio.getText());//lo convierto a int y se lo asigno a precio Pagar
                                Label_totalPagar.setText(Integer.toString(precioPagar));//se lo asigno al label y lo paso a string
 Texto_codigo.setText("");
 Texto_Precio.setText("");
   Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
 AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
                    sonido.play();
                            } else {//so va al else es que este producto no se repite en la tabla asi que asignare una columna para este nuevo producto
                                Object[] filas_tabla = new Object[7]; //numero de filas  de la tabla -> ----
                           //   filas_tabla[0] = celda = fila.getCell(0);//el codigo esta en la fila 1 lo asigno para mostrar en la tabla
                               // filas_tabla[1] = celda = fila.getCell(1); //el nombre esta en la fila 2 lo asigno para mostrar en la tabla
                               //  filas_tabla[2] = contador_codigos_lista; //esta es la cantidad de productos q va a comprar el cliente
                           //   filas_tabla[3] =  celda = fila.getCell(2); //este es el precio de compra, esta en la posicion 3 del excel
                             filas_tabla[0] =  new SimpleDateFormat("dd-MM-yyyy").format(myDate); //en la primera fila va la fecha
                             filas_tabla[1] =IDcliente;//en la segunda fila el ID del cliente
                                filas_tabla[2] = NombreCliente; //en la tercera el nombre del cliente
                                filas_tabla[3] = celda = fila.getCell(0);// en la cuarta el codigo del producto, el codigo esta en la fila 1 del excel
                                filas_tabla[4] = celda = fila.getCell(1); //en la quinta el nombre del producto, esta en la fila 2 del excel
                                filas_tabla[5] = contador_codigos_lista;//en la sexta esta es la cantidad de productos q va a comprar el cliente   
                                filas_tabla[6] = Texto_Precio.getText(); //el precio de compra lo dijite el usuario    
                                 modelo.addRow(filas_tabla);
                                celda = fila.getCell(0);//lo regreso al 0 ya que ahi esta el codigo
                                lista_codigos_en_orden.add(celda.getStringCellValue());//y aqui se lo asigno a la lista que los tendra en orden
                                lista_posicionProductosExcel.add(contadorFilas);//le asigno la posicion en el excel donde se encuentra
                               //  celda = fila.getCell(2);//vuelvo a a signar la celda en la posicion 3 que esta el precio
                                precioPagar=precioPagar + Integer.parseInt(Texto_Precio.getText());//lo convierto a int y se lo asigno a precio Pagar
                                Label_totalPagar.setText(Integer.toString(precioPagar));//se lo asigno al label y lo paso a string
                                
 Texto_codigo.setText("");
 Texto_Precio.setText("");
   Texto_codigo.requestFocus();//esto es para que se puede volver a escribir en el Jtext si tener que clickearlo
  AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
                    sonido.play();
                            }

                            // valorInventario_int = Integer.parseInt( celda.getStringCellValue());//me toca pasarlo a int para restarle 1
                            // valorInventario_int=valorInventario_int-1;
                            //  valorInventario= Integer.toString(valorInventario_int);//lo paso a string para que lo guarde al excel
                            //       celda.setCellValue(valorInventario);
                            try {

                                file.close(); //cierro el archivo

                                FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                                wb.write(output);
                                output.close();

                            } catch (Exception e) {//si no guarda
                                AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                                sonido.play();
                                Icon icon2 = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                                JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon2);
                            }
                        }
                    } else {
                        contadorFilas++;
                    }

                

            }

        } catch (FileNotFoundException ex) {
            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se a encontrado el excel!! lo moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (IOException ex) {
            AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new Inicio().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_admin;
    private javax.swing.JButton Boton_borrarLista;
    private javax.swing.JButton Boton_comprar;
    private javax.swing.JButton Boton_ok;
    private javax.swing.JButton Boton_ok_eliminar;
    private javax.swing.JLabel Label_totalPagar;
    private javax.swing.JTextField Texto_ID;
    private javax.swing.JTextField Texto_Pago;
    private javax.swing.JTextField Texto_Precio;
    private javax.swing.JTextField Texto_codigo;
    private javax.swing.JTextField Texto_eliminar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
