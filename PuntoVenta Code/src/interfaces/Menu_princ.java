/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Stephanie Martínez
 */
public class Menu_princ extends JPanel {
    
    private JLabel logo,titulo;
    private JButton gerente,vendedor;
    private GridBagConstraints c,c1,c2,c3;
    
    public Menu_princ(){
        setLayout(new GridBagLayout());
        crear();
        setVisible(true);
    }
    public void paintComponent(Graphics g){
        Dimension tamanno=getSize();
        ImageIcon imageFondo=new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imageFondo.getImage(), 0, 0, tamanno.width,tamanno.height,null);
        setOpaque(false);
        super.paintComponents(g);
    }
    private void crear() {
        titulo=new JLabel("Menú Principal");
         titulo.setFont(new Font("Century Gothic", 3, 20));
         titulo.setForeground(Color.WHITE);
         c=new GridBagConstraints();
         c.fill = GridBagConstraints.CENTER;  //natural height, maximum width
         c.ipady = 1;       //make this component tall
         //c.anchor = GridBagConstraints.NORTHWEST; //bottom of space
         c.insets = new Insets(4,20,4,4);  //top padding
         c.gridheight = 1; 
         c.gridwidth = 6;   
         c.gridx=0;
         c.gridy = 0;       //third row
         add(titulo,c);

         logo=new JLabel();
         String path="/Imagenes/logo.png";
         URL url=this.getClass().getResource(path);
         ImageIcon icon= new ImageIcon(url);
         logo.setIcon(icon);   
         c1=new GridBagConstraints();
         c1.fill = GridBagConstraints.CENTER;  //natural height, maximum width
         c1.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c1.anchor = GridBagConstraints.CENTER; //bottom of space
         c1.insets = new Insets(4,20,4,4);  //top padding
         c1.gridx = 2;       //aligned with button 2
         c1.gridwidth = 2;   //2 columns wide
         c1.gridy = 1;       //third row
         add(logo,c1);
         
         vendedor=new JButton("VENTAS");
         vendedor.setFont(new Font("Century Gothic", 3, 20));
         vendedor.setForeground(Color.WHITE);
         String path1="/imagenes/vendedor.png";
         URL url2=this.getClass().getResource(path1);
         ImageIcon icon2= new ImageIcon(url2);
         String path2="/imagenes/vendedor3.png";
         URL url3=this.getClass().getResource(path2);
         ImageIcon icon3= new ImageIcon(url3);
         vendedor.setIcon(icon2);  
         vendedor.setContentAreaFilled(false);
         vendedor.setBorderPainted(false);
         vendedor.setFocusPainted(false);
         vendedor.setPressedIcon(icon3);
         c2=new GridBagConstraints();
         c2.fill = GridBagConstraints.CENTER;  //natural height, maximum width
         c2.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c2.anchor = GridBagConstraints.CENTER; //bottom of space
         c2.insets = new Insets(65,20,4,20);  //top padding
         c2.gridx = 2;       //aligned with button 2
         c2.gridwidth = 1;   //2 columns wide
         c2.gridy = 4;       //third row
         add(vendedor,c2);
         
         gerente=new JButton("GERENCIA");
         gerente.setFont(new Font("Century Gothic", 3, 20));
         gerente.setForeground(Color.WHITE);
         String pat="/imagenes/gerente.png";
         URL ur=this.getClass().getResource(pat);
         ImageIcon ic= new ImageIcon(ur);
         String pat1="/imagenes/gerente3.png";
         URL u=this.getClass().getResource(pat1);
         ImageIcon ic1= new ImageIcon(u);
         gerente.setIcon(ic);  
         gerente.setContentAreaFilled(false);
         gerente.setBorderPainted(false);
         gerente.setFocusPainted(false);
         gerente.setPressedIcon(ic1);
         c3=new GridBagConstraints();
         c3.fill = GridBagConstraints.CENTER;  //natural height, maximum width
         c3.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c3.anchor = GridBagConstraints.CENTER; //bottom of space
         c3.insets = new Insets(65,20,4,20);  //top padding
         c3.gridx = 3;       //aligned with button 2
         c3.gridwidth = 1;   //2 columns wide
         c3.gridy = 4;       //third row
         add(gerente,c3);
    }
    public static void main(String[]args){
        JFrame n=new JFrame();
        n.setMinimumSize(new Dimension(750,500));
        Menu_princ p=new Menu_princ();
        n.add(p);
        n.setVisible(true);
    }

    
}
