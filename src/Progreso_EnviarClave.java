import java.applet.AudioClip;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Progreso_EnviarClave extends SwingWorker<Integer, String> {

    //aqui hara las operaciones para evr si el correo y la clave son validas, ademas de mostrar una barra de carga

    private JProgressBar jpbar;
    private String Correo;
    private String Clave;
    

    public Progreso_EnviarClave(JProgressBar jpbar, String Correo, String Clave) {//le maqnde el correo y la clave

        this.jpbar = jpbar;
        this.Correo = Correo;
        this.Clave = Clave;

    }

   

   

    @Override
    protected Integer doInBackground() throws Exception {

        getJpbar().setIndeterminate(true);
        //aqui abajo va el proceso

        try {
              String a = Integer.toString((int) (Math.random() * 9));
        String b = Integer.toString((int) (Math.random() * 9));
        String c = Integer.toString((int) (Math.random() * 9));//para generar la nueva clave
        String d = Integer.toString((int) (Math.random() * 9));
        String e = Integer.toString((int) (Math.random() * 9));

        String nuevaClave = a + b + c + d + e;
            String tipoCorreo="";//toanmre que tipo de correo es, gmail yahoo...
            String CorreoEnviar="";
            
            ArrayList<String> lista_informaciontxt = new ArrayList<String>();//en la lista guardare todo lo que este en el txt
               FileReader lector = new FileReader("BD/BD/BD.txt");
                BufferedReader Br = new BufferedReader(lector);

                String bfRead;
                while ((bfRead = Br.readLine()) != null) {

                    lista_informaciontxt.add(bfRead);//tomare toda la informacion que esta en el archivo y lo guardo a una lista

                }
               CorreoEnviar= lista_informaciontxt.get(1);//le asigno todo el correo con su tip ode correo
                  
                for (int i = 0; i < CorreoEnviar.length(); i++) {//recorrere toda la palabra
                tipoCorreo = CorreoEnviar.substring(0, CorreoEnviar.length() - i);//desde atras recorrere todo hasta detectar cuando hay un espacio
                if(tipoCorreo.contains(" ")){//si tiene un espacio termino el correo y sigue el tipo correo              
            //si contiene un espacio es que no termina de eliminar el correo
                  
                }
                else{//si ya elimino el espacio llego al tipo  de correo
                   tipoCorreo= CorreoEnviar.substring(0, CorreoEnviar.length() - i);//se lo asigno
                    break;//rompo el ciclo
                }
            }
               
            
                  //ahora obtendre  solo el correo
                  int NumerovariablesCorreoEnviar= CorreoEnviar.length();//cojo su numero de palabras para el for
                for (int i = 0; i < NumerovariablesCorreoEnviar; i++) {
                CorreoEnviar = CorreoEnviar.substring(1,CorreoEnviar.length());//partire la cadena, numero de variables que elimina, numero de variables que coge
               //en cada ciclo elimina parte del tipo de correo que ya viene en la cadena, cuando lo elimine quedara  el espacio, luego lo elimina y si no lo detecta termina el ciclo
                if(CorreoEnviar.contains(" ")){
                
                }
                else{//si no lo tiene ya esta solo el correo
                
                    break;
                }
                
                }   
                
                
                
                Properties props = new Properties();
                //ahora segun su tipo de correo entra al if que es
                if("Gmail".equals(tipoCorreo)){
                      props.setProperty("mail.smtp.host", "smtp.gmail.com"); //servidor de yahoo	
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");//puerto de outlook y hotmail
            props.setProperty("mail.smtp.auth", "true");
                
                }
                
                else if("Yahoo".equals(tipoCorreo)){
                  props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com"); //servidor de yahoo	
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "25");//puerto de outlook y hotmail
            props.setProperty("mail.smtp.auth", "true");
                
                }
                
                else if("Outlook".equals(tipoCorreo)){
                  props.setProperty("mail.smtp.host", "smtp.live.com"); //servidor de yahoo	
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");//puerto de outlook y hotmail
            props.setProperty("mail.smtp.auth", "true");
                
                }
              
      

             Session session = Session.getDefaultInstance(props);

             String correoRemitente =CorreoEnviar;//le asigno el correo que enviara
            String passwordRemitente = Clave;
            String correoReceptor = CorreoEnviar;//sera el mismo que lo resibira
            String asunto = "Nueva clave IRIS ◕ ‿‿ ◕";
            String mensaje = "<html><b>**CLAVE**: </b>" + nuevaClave;
             
           

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
              PrintWriter printWriter;

//ahora vuelvo a crear el archivo y escribo la nueva clave y le agrego lo que tenia antes ya q esta en la lista
                FileWriter archivo = new FileWriter("BD/BD/BD.txt"); //si fuera "BD.txt",true no lo recrearia solo saltaria lineas y escribiria debajo de ellas
                lector = new FileReader("BD/BD/BD.txt");
                Br = new BufferedReader(lector);
                printWriter = new PrintWriter(archivo);
                String claveEncriptada = DigestUtils.md5Hex(nuevaClave);//encripto la clave

                printWriter.println(claveEncriptada);
                printWriter.println(lista_informaciontxt.get(1));//en la posicion 2 esta el correo destino
                printWriter.println(lista_informaciontxt.get(2));//en la posicion 3 esta el numero de alarma
                printWriter.println(lista_informaciontxt.get(3));//en la posicion 4 esta el correo que se enviara la clave si se olvida
                 printWriter.println(lista_informaciontxt.get(4));//en la posicion 5 esta el correo destino2
                archivo.close();
                lector.close();
                Br.close();
              lista_informaciontxt.clear();//limpio la lista
            
            getJpbar().setIndeterminate(false);
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Correo_enviado.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b> Se envio la nueva clave </b> \\ (•◡•) /", "Enviado \\ (•◡•) / ◕ ‿‿ ◕", JOptionPane.INFORMATION_MESSAGE, icon);


 
        } catch (AddressException ex) {

            getJpbar().setIndeterminate(false);
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error desconocido ⊙△⊙ </b> ", "Vuelve a intentarlo o reiniciame", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (MessagingException ex) {
        
           getJpbar().setIndeterminate(false);
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Advertencia.wav"));
            sonido.play();           
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Clave o correo incorrectos ⊙△⊙ </b> ", "(¬､¬)Solo Outlook o sus derivados", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (FileNotFoundException ex) {

            getJpbar().setIndeterminate(false);
            
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>No se encontro la base de datos de IRIS!! la moviste?</b>(ง ͠° ͟ل͜ ͡°)ง", "uh! ⊙﹏⊙", JOptionPane.INFORMATION_MESSAGE, icon);

        } catch (IOException ex) {
            getJpbar().setIndeterminate(false);
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Error.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/error.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b>Error leyendo la base de datos ⊙△⊙ </b> ", "⊙﹏⊙ perdon", JOptionPane.INFORMATION_MESSAGE, icon);
        }

        getJpbar().setIndeterminate(false);
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

}

