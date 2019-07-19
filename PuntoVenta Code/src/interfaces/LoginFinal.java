/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author fernando
 */
public class LoginFinal extends JPanel{
    private JTextField user;
    private JPasswordField contrasenna;
    private JButton aceptar,salir;
    private JLabel logo,titulo,etiContra,etiUser;
    //private Container paneComponentes;
    private FondoPanel pane;
    private JPanel panel1,panel2;
    private GridBagConstraints c,c1,c2,c3,c4,c5,c6,c7,c8,c9;
    
    public LoginFinal(){
        setLayout(new GridBagLayout());
        crear();
        setVisible(true);
    }
    public void crear(){
         titulo=new JLabel("Login");
         titulo.setFont(new Font("Century Gothic", 3, 20));
         titulo.setForeground(Color.WHITE);
         c=new GridBagConstraints();
         c.fill = GridBagConstraints.BOTH;  //natural height, maximum width
         c.ipady = 1;       //make this component tall
         c.anchor = GridBagConstraints.NORTHWEST; //bottom of space
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
         c1.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c1.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c1.anchor = GridBagConstraints.CENTER; //bottom of space
         c1.insets = new Insets(4,20,4,4);  //top padding
         c1.gridx = 2;       //aligned with button 2
         c1.gridwidth = 2;   //2 columns wide
         c1.gridy = 1;       //third row
         add(logo,c1);
         
         etiUser=new JLabel("Usuario");
         etiUser.setFont(new Font("Century Gothic", 4, 12));
         etiUser.setForeground(Color.WHITE);
         c2=new GridBagConstraints();
         c2.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c2.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c2.anchor = GridBagConstraints.CENTER; //bottom of space
         c2.insets = new Insets(4,20,4,4);  //top padding
         c2.gridx = 2;       //aligned with button 2
         c2.gridwidth = 2;   //2 columns wide
         c2.gridy = 2;       //third row
         add(etiUser,c2);
         
         user=new JTextField();
         user.setFont(new Font("Century Gothic", 4, 12));
         c3=new GridBagConstraints();
         c3.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c3.ipady = 0;       //make this component tall
         c3.weightx = 1.0; //request any extra vertical space
         c3.anchor = GridBagConstraints.CENTER; //bottom of space
         c3.insets = new Insets(4,4,4,20);  //top padding
         c3.gridx = 2;       //aligned with button 2
         c3.gridwidth = 2;   //2 columns wide
         c3.gridy = 3;       //third row
         add(user,c3);
         
         etiContra=new JLabel("Contraseña");
         etiContra.setFont(new Font("Century Gothic", 4, 12));
         etiContra.setForeground(Color.WHITE);
         c4=new GridBagConstraints();
         c4.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c4.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c4.anchor = GridBagConstraints.CENTER; //bottom of space
         c4.insets = new Insets(4,20,4,4);  //top padding
         c4.gridx = 2;       //aligned with button 2
         c4.gridwidth = 2;   //2 columns wide
         c4.gridy = 4;       //third row
         add(etiContra,c4);
         
         contrasenna = new JPasswordField(15);
         contrasenna.setFont(new Font("Century Gothic", 4, 12));
         c5=new GridBagConstraints();
         c5.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c5.ipady = 0;       //make this component tall
         c5.weightx = 1.0; //request any extra vertical space
         c5.anchor = GridBagConstraints.CENTER; //bottom of space
         c5.insets = new Insets(4,4,4,20);  //top padding
         c5.gridx = 2;       //aligned with button 2
         c5.gridwidth = 2;   //2 columns wide
         c5.gridy = 5;       //third row
         add(contrasenna,c5);
         
         aceptar=new JButton("Aceptar");
         aceptar.setFont(new Font("Century Gothic", 4, 12));
         c6=new GridBagConstraints();
         c6.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c6.ipady = 0;       //make this component tall
         c6.weightx = 1.0; //request any extra vertical space
         c6.anchor = GridBagConstraints.CENTER; //bottom of space
         c6.insets = new Insets(4,20,4,4);  //top padding
         c6.gridx = 2;       //aligned with button 2
         c6.gridwidth = 1;   //2 columns wide
         c6.gridy = 6;       //third row
         add(aceptar,c6);
         
         salir=new JButton("Salir");
         salir.setFont(new Font("Century Gothic", 4, 12));
         c7=new GridBagConstraints();
         c7.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c7.ipady = 0;       //make this component tall
         c7.weightx = 1.0; //request any extra vertical space
         c7.anchor = GridBagConstraints.CENTER; //bottom of space
         c7.insets = new Insets(4,20,4,4);  //top padding
         c7.gridx = 3;       //aligned with button 2
         c7.gridwidth = 1;   //2 columns wide
         c7.gridy = 6;       //third row
         add(salir,c7);
    }
    public void paintComponent(Graphics g){
        Dimension tamanno=getSize();
        ImageIcon imageFondo=new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imageFondo.getImage(), 0, 0, tamanno.width,tamanno.height,null);
        setOpaque(false);
        super.paintComponents(g);
    }
    public static void main(String[]args){
        JFrame n=new JFrame();
        n.setMinimumSize(new Dimension(750,500));
        LoginFinal p=new LoginFinal();
        n.add(p);
        n.setVisible(true);
    }
    
}
