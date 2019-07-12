/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class FondoPanel extends JPanel {
    public FondoPanel(){
      setVisible(true);
    }
    public void paintComponent(Graphics g){
        Dimension tamanno=getSize();
        ImageIcon imageFondo=new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imageFondo.getImage(), 0, 0, tamanno.width,tamanno.height,null);
        setOpaque(false);
        super.paintComponents(g);
    }
    
}
