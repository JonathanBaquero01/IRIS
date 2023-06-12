
import java.applet.AudioClip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jona
 */
public class SonidoPrender {
    
         
        public void ejecutarSonido(){
        AudioClip  sonido= java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Prender.wav"));
        sonido.play();
        }
}
