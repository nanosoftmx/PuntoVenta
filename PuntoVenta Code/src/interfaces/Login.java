/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
//import Imagenes.*;
import java.net.URL;
import javax.swing.Box;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPasswordField;

/**
 *
 * @author admin
 */
public class Login extends JFrame /*implements ActionListener,MouseListener*/{
    private JTextField user;
    private JPasswordField contrasenna;
    private JButton aceptar;
    private JLabel logo,titulo,etiContra,etiUser;
    private Container paneComponentes;
    private FondoPanel pane;
    
    public Login(){
        super("Inventario vinil de Recorte");
        //setLayout(new FlowLayout());
        //setBackground(Color.DARK_GRAY);
        setSize(750,500);
        setMinimumSize(new Dimension(750,500));
        setResizable(true);
        crear_componentes();
        annadir_componentes();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
         
    }
    //Si quiero crear unos nuevos color puedo utlizar new Color(valor1,valor2,valor3)
    public void crear_componentes(){
        //paneComponentes=new Container();
        pane=new FondoPanel();
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        
        titulo=new JLabel("SISTEMAS DE VENTA E INVENTARIOS");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Century Gothic", 3, 20));
        titulo.setForeground(Color.WHITE);
        
        user=new JTextField();
        //user.setPreferredSize(new Dimension(100, 25));
        user.setMaximumSize(new Dimension(300,25));
        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        contrasenna = new JPasswordField(15);
        //contrasenna.setPreferredSize(new Dimension(100, 25));
        contrasenna.setMaximumSize(new Dimension(300,25));
        contrasenna.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        aceptar=new JButton("Aceptar");
        aceptar.setSize(50,20);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo=new JLabel();
        String path="/Imagenes/logo.png";
        URL url=this.getClass().getResource(path);
        ImageIcon icon= new ImageIcon(url);
        logo.setIcon(icon);   
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        etiUser=new JLabel("Usuario");
        etiUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiUser.setFont(new Font("Century Gothic", 2, 14));
        etiUser.setForeground(Color.WHITE);
        
        etiContra=new JLabel("Contraseña");
        etiContra.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiContra.setFont(new Font("Century Gothic", 2, 14));
        etiContra.setForeground(Color.WHITE);
    }
    public void annadir_componentes(){
        add(pane);
        pane.add(Box.createRigidArea(new Dimension(5,50)));
        pane.add(titulo);
        pane.add(Box.createRigidArea(new Dimension(5,20)));
        //Dimension minSize = new Dimension(5, 80);
        //Dimension prefSize = new Dimension(5, 80);  
        //Dimension maxSize = new Dimension(Short.MAX_VALUE, 80);
        //pane.add(new Box.Filler(minSize, prefSize, maxSize));
        pane.add(logo);
        //pane.add(new Box.Filler(minSize, prefSize, maxSize));
        pane.add(Box.createRigidArea(new Dimension(5,20)));
        pane.add(etiUser);
        pane.add(user);
        pane.add(Box.createRigidArea(new Dimension(5,10)));
        pane.add(etiContra);
        pane.add(contrasenna);
        //pane.add(new Box.Filler(minSize, prefSize, maxSize));
        pane.add(Box.createRigidArea(new Dimension(5,20)));
        pane.add(aceptar);
        
        
    }
    public static void main(String[]args){
        Login l=new Login();
        
    }
    
}
