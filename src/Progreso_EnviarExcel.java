

import java.applet.AudioClip;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jona
 */
public class Progreso_EnviarExcel extends SwingWorker<Integer, String> {

    //aqui hara las operaciones para evr si el correo y la clave son validas, ademas de mostrar una barra de carga

    private JProgressBar jpbar;
    private String Correo;
    private String Clave;
    

    public Progreso_EnviarExcel(JProgressBar jpbar, String Correo, String Clave) {//le maqnde el correo y la clave

        this.jpbar = jpbar;
        this.Correo = Correo;
        this.Clave = Clave;

    }

   

   

    @Override
    protected Integer doInBackground() throws Exception {

        getJpbar().setIndeterminate(true);
        //aqui abajo va el proceso
int ciclo=0;//son 2 ciclos y en cada ciclo se tomara  valor diferente, esw¡to es para saber la posicion del correo 1 y 2
        try {
            ArrayList<String> lista_informaciontxt = new ArrayList<String>();//en la lista guardare todo lo que este en el txt
            FileReader lector = new FileReader("BD/BD/BD.txt");
            BufferedReader Br = new BufferedReader(lector);

            String bfRead;
            while ((bfRead = Br.readLine()) != null) {

                lista_informaciontxt.add(bfRead);//tomare toda la informacion que esta en el archivo y lo guardo a una lista

            }
            lector.close();
            Br.close();
            //hare un cilo de 2 ya que enviara a 2 correos
            for (int i = 0; i < 2; i++) {
                

            
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.live.com"); //servidor de yahoo	
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");//puerto de outlook y hotmail
            props.setProperty("mail.smtp.auth", "true");

           
            Session session = Session.getDefaultInstance(props);
             String correoReceptor = "";//lo declaro por que tengo que manipularlo en un ciclo
             String CorreoReceptorciclo1=  lista_informaciontxt.get(1);
if(i==0){
    

//en el primer ciclo se coge el correo 2 de la BD y ese viene con el tipo de correo, se lo tengo que quitar

//obtengo el correo y su tipo

//aqui le quitare el tipo de correo
   CorreoReceptorciclo1=  lista_informaciontxt.get(1);
                  int NumerovariablesCorreoEnviar= lista_informaciontxt.get(1).length();//cojo su numero de palabras para el for
                for (int i2 = 0; i2 < NumerovariablesCorreoEnviar; i2++) {
                CorreoReceptorciclo1 = CorreoReceptorciclo1.substring(1,CorreoReceptorciclo1.length());//partire la cadena, numero de variables que elimina, numero de variables que coge
               //en cada ciclo elimina parte del tipo de correo que ya viene en la cadena, cuando lo elimine quedara  el espacio, luego lo elimina y si no lo detecta termina el ciclo
                if(CorreoReceptorciclo1.contains(" ")){
                
                }
                else{//si no lo tiene ya esta solo el correo
                
                    break;
                }
                
                }  
}


            String correoRemitente = Correo;
            String passwordRemitente = Clave;
            if(i==0){//si va en el primer ciclo que coja el correo que le quite el tipo de correo
             correoReceptor = CorreoReceptorciclo1;// el correo 1 esta en la posicion 2 de la lista y el 2 en la 4
            }
            else{//en el segundo ciclo entra al else y coje el otro correo de la lista, esta normal
            correoReceptor= lista_informaciontxt.get(4);
            
            }

            String asunto = "Cuentas e inventario IRIS";
            String mensaje = "<html><b>IRIS Excel</b>";

            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("Cuentas e inventario IRIS.xlsx")));
            adjunto.setFileName("Cuentas e inventario IRIS.xlsx");

            MimeMultipart miltiParte = new MimeMultipart();
            miltiParte.addBodyPart(texto);
            miltiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setContent(miltiParte);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            }
            lista_informaciontxt.clear();//limpio la lista
            getJpbar().setIndeterminate(false);
            AudioClip sonido;
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Realizado.wav"));
            sonido.play();
            Icon icon = new ImageIcon(getClass().getResource("/Imagenes/Correo_enviado.png")); //para poner icono al aviso
            JOptionPane.showMessageDialog(null, "<html><b> Correo enviado </b> \\ (•◡•) /", "Enviado \\ (•◡•) / ◕ ‿‿ ◕", JOptionPane.INFORMATION_MESSAGE, icon);


 
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
