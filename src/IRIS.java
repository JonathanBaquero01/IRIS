
import java.applet.AudioClip;
import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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


public class IRIS extends JFrame {

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, InterruptedException {
 
        
          
        Inicio inicio = new Inicio();
        inicio.setTitle("IRIS❤");//para que muestre en el programa un titutlo
       inicio.setVisible(true);
       
         SonidoPrender sonidoprender = new SonidoPrender();//llamo la clase
        sonidoprender.ejecutarSonido();//llamo el metodo para q ejecute un sonido cuando prenda
             
       
        
     
         
       
         
       
        
      
        
        
      
        
   
       
    }
    
    
    

}
