/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

/**
 * @author DiscoDurodeRoer
 */
public class FondoSwing implements Border {
    //ESTA CLASE ES PARA COLOCAR EL FONDO Y SE AJUSTE CON EL TAMAÑO DE LA VENTANA
    private BufferedImage mImagen = null;
   
    /**
     * Constructor, indicamos la imagen que queremos que se redimensione
     * @param pImagen ImageIO.read(new File(ruta imagen))
     */
    public FondoSwing(BufferedImage pImagen) {
        mImagen = pImagen;       
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }
    
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}

