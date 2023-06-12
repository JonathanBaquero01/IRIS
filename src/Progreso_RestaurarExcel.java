
import java.applet.AudioClip;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
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
public class Progreso_RestaurarExcel extends SwingWorker<Integer, String> {

    //aqui hara las operaciones para evr si el correo y la clave son validas, ademas de mostrar una barra de carga

    private JProgressBar jpbar;
   
    

    public Progreso_RestaurarExcel(JProgressBar jpbar) {//le maqnde el correo y la clave

        this.jpbar = jpbar;
      

    }

   

   

    @Override
    protected Integer doInBackground() throws Exception {

        getJpbar().setIndeterminate(true);
        
         
        
        try {
            ArrayList<String> lista_informacion_producto = new ArrayList<String>();//lo que hare es primero almacenar la info del producto, luego borro la fila y escribo la info del producto
            int contadorColumnas = 0;
            int contadorFilas = 3;//empieza en 3 ya q el primer codigo estan en la posicion 4
            int contadorFilas_hoja2=3;//lo mismo pero para la hoja 2
               int contadorFilas_hoja3=1;//lo mismo pero para la hoja 3, empieza en 1 ya que la primera celda esta en la posicion 2
            boolean estado = true;
            boolean estado2=true;// el estado2 es el de la hoja 2
            boolean estado3 = true; //el estado2 es el de la hoja4

            FileInputStream file = new FileInputStream(new File("Cuentas e inventario IRIS.xlsx"));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            /*
            XSSFSheet sheet = wb.getSheetAt(0);//con q hoja empezaremos

        

            //ahora ire a los productos y borrare todo excepto su  codigo nombre y cantidad
            while (estado == true) {
                XSSFRow fila = sheet.getRow(contadorFilas);//numero de filas filas
                if (fila == null)//si la fila  es nula es que ya recorrio todos los codigos existentes
                {
                    estado = false;//solamente pongo el estado en falso pa q deje de recorrer el while
                } else {

                    //guardare primero la informacion del producto
                    XSSFCell celda = fila.getCell(0);
                    lista_informacion_producto.add(celda.getStringCellValue());// en la posicion 1 esta el codigo
                    celda = fila.getCell(1);//en la 2 el nombre
                    lista_informacion_producto.add(celda.getStringCellValue());// en la posicion 1 esta el nombre del producto
                    celda = fila.getCell(2);//en la 3 el precio de compra actual
                    lista_informacion_producto.add(celda.getStringCellValue());
                    celda = fila.getCell(3);//en la 4 el inventario
                    lista_informacion_producto.add(celda.getStringCellValue());

                    XSSFRow removingRow = sheet.getRow(contadorFilas);
                    sheet.removeRow(removingRow);//elimino toda la fila

                    //ahora escribire la info del producto
                    fila = sheet.createRow(contadorFilas);//crea la fila

                    celda = fila.createCell(0);//sera la primera columna ya que es la de codigos de productos

                    celda.setCellValue(lista_informacion_producto.get(0));//escribo en la celda, en la posicion 1 esta es el codigo
                    celda = fila.createCell(1);//en la sgda posicion de la fila esta el nombre del producto
                    celda.setCellValue(lista_informacion_producto.get(1));//cojo la posicion donde esta en la lista
                    //y asi sucesivamente
                    celda = fila.createCell(2);
                    celda.setCellValue(lista_informacion_producto.get(2));
                    celda = fila.createCell(3);
                    celda.setCellValue(lista_informacion_producto.get(3));
                    contadorFilas++;//le aumento 1 pa q pase a la sgte fila
                    lista_informacion_producto.clear();//limpio la lista pa q pase a la sgte fila
                }

            }
       */
            
             XSSFSheet sheet = wb.getSheetAt(3);// ahora voy a la hoja 4 del excel, que son los cliente
             
             while (estado3==true){
               XSSFRow fila = sheet.getRow(contadorFilas_hoja3);//numero de filas filas
                if (fila == null)//si la fila no es nula es que ya recorrio todos los codigos existentes
                {
                    estado3 = false;//solamente pongo el estado en falso pa q deje de recorrer el while
                }
             
                else{
                   //esto es para que me elimine una celda especifica, como solo eliminare un campo por fila no necesito una lista como los procesos anteriores
              //  Row row = sheet.getRow(contadorFilas_hoja3);//numero columna (abajo) , es 3 ya que el primer codigo  esta en la posicion 4
              //  Cell celdaEliminar = row.getCell(2);//numero fila -> solo borrare lo de la celda 3
             //  row.removeCell(celdaEliminar);//la elimino
                XSSFCell celda = fila.createCell(3);//ahora como elimine la celda 4 la vuelvo a crear
                    celda.setCellValue("0");//y le asigno un cero
                contadorFilas_hoja3++;//sumo 1 para que vaya a la siguiente fila
                }
             }
             
             
              sheet = wb.getSheetAt(1);// y por ultimo a la hoja 2 que es la de utilidad
              
              contadorFilas=1;//lo igualo a uno ya que ahi empieza la primera columna
              for (int i = 0; i < 11; i++) {//obligatoriamente me debe eliminar las primeras 11 columnas
                  //ya que si digamos empieza a operar en el mes  12, en la fila 12 como ve que esta llena, no llena los campos de compras ahi
                  try {
                        XSSFRow removingRow = sheet.getRow(contadorFilas);
                    sheet.removeRow(removingRow);//elimino toda la fila
                  } catch (Exception e) {//si la fila llega a estar vacia dara un error, asi que lo mando a un catch pa q lo ignore y siga operando
                  }
                
                    contadorFilas++;
                    
            }
              contadorFilas=12;//a 12 ya que en el ciclo anterior quedo en la 11
              while(estado2==true){//desues de la fila 12 si hay mas que elimine las que hagan falta
              
                   XSSFRow fila = sheet.getRow(contadorFilas);//numero de filas filas
                if (fila == null)//si la fila no es nula es que ya recorrio todos los codigos existentes
                {
                    estado2 = false;//solamente pongo el estado en falso pa q deje de recorrer el while
                }
                else{
                     XSSFRow removingRow = sheet.getRow(contadorFilas);
                    sheet.removeRow(removingRow);//elimino toda la fila
                    contadorFilas++;//voy a la siguiente columna
                
                }
              
              }
              
              
            try {
                file.close();

                FileOutputStream output = new FileOutputStream("Cuentas e inventario IRIS.xlsx"); //ruta donde se guardare el archivo
                wb.write(output);
                output.close();
                AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
        sonido.play();
        getJpbar().setIndeterminate(false);
                        Icon icon = new ImageIcon(getClass().getResource("/Imagenes/guardado.png")); //para poner icono al aviso
                        JOptionPane.showMessageDialog(null, "<html><b>Excel restaurado con exito!✔</b> ٩(•̮̮̃•̃)۶", "Miralo ◕ ‿‿ ◕", JOptionPane.INFORMATION_MESSAGE, icon);


            } catch (Exception e) {
                AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
                sonido.play();
                Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
                JOptionPane.showMessageDialog(null, "<html><b>No se pudo guardar el excel, vuelve a intentarlo</b> o(╥﹏╥)o", "uh! ⊙△⊙", JOptionPane.INFORMATION_MESSAGE, icon);
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
    
        return 1;// no retorna nada, solo q le pongo que devuelva 1 pa q no de error

    }

    /**
     * @return the jpbar
     */
    public JProgressBar getJpbar() {
        return jpbar;
    }

    /**
     * @param jpbar the jpbar to set
     */
    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }

  

   

   

  

}
