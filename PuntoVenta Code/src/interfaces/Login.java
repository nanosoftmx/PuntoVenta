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
import javax.swing.*;
//import Imagenes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import org.postgresql.*;

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

    public static final String URL = "jdbc:postgresql://localhost:5432/PuntoVentaIng";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "123456789";

    PreparedStatement ps;
    ResultSet rs;


    public Login(){
        super("Login");
        //setLayout(new FlowLayout());
        //setBackground(Color.DARK_GRAY);
        setSize(750,500);
        setMinimumSize(new Dimension(750,500));
        setResizable(true);
        crear_componentes();
        annadir_componentes();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
         
    }

    /**
     *Conexion con la base de datos
     */
    public static Connection getConection() {
        Connection con = null;

        try {

            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    private void limpiarCajas() {

        user.setText(null);
        contrasenna.setText(null);
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
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                    btnIngresarActionPerformed(evt);
            }
        });


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

    public void evtbtnsalir(ActionEvent evt) {
        System.exit(0);
    }

    /**
     *
     * @param evt
     * METODO DE EL BOTON ACEPTAR, PERMITE INGRESAR AL SISTEMA
     */
    private void btnIngresarActionPerformed(ActionEvent evt){

        Connection con = null;

        try{
            con = getConection();
             ps = con.prepareStatement("SELECT * FROM empleado WHERE usuario = ? and contraseña = ? ");
             // ps.setString(1, );
             ps.setString(1, user.getText());
             ps.setString(2, contrasenna.getText());

             rs = ps.executeQuery();

        if (rs.next()) {
            user.setText(rs.getString("usuario"));
            contrasenna.setText(rs.getString("contraseña"));
            PanelVentas p = new PanelVentas();
            p.ejecutar();
            dispose();
        } else {
            JOptionPane.showMessageDialog(aceptar, "Datos ingresados incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
            } catch (Exception e) {
                System.err.println(e);

            }

            }


    public static void main(String[]args){
        Login l=new Login();
        
    }
    
}
