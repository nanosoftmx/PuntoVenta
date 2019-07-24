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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class PanelConsulta extends JPanel {
    private JTextField txtBuscar;
    private JLabel titulo;
    private JButton btnBuscar,btnCompras,btnRegistroUso,btnprint,btnAgregar,btnEliminar;
    private JTable tablaRegistros;
    private GridBagConstraints c,c1,c2,c3,c4,c5,c6,c7,c8,c9;

    DefaultTableModel modelo = new DefaultTableModel();
    Object[] fila = new Object[6];


    public static final String URL = "jdbc:postgresql://localhost:5432/PuntoVentaIng";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "123456789";

    PreparedStatement ps,psl;
    ResultSet rs,rsl;
    
    public PanelConsulta(){
      setLayout(new GridBagLayout());
      crear();
      setVisible(true);
    }
    public void crear(){
         titulo=new JLabel("CONSULTAR PRODUCTO");
         titulo.setFont(new Font("Century Gothic", 3, 20));
         titulo.setForeground(Color.WHITE);
         c=new GridBagConstraints();
         c.fill = GridBagConstraints.BOTH;  //natural height, maximum width
         c.ipady = 1;       //make this component tall
         c.anchor = GridBagConstraints.NORTHWEST; //bottom of space
         c.insets = new Insets(4,20,4,4);  //top padding
         c.gridheight = 1; 
         c.gridwidth = 1;   
         c.gridx=0;
         c.gridy = 0;       //third row
         add(titulo,c);
        
         txtBuscar=new JTextField();
         txtBuscar.setFont(new Font("Century Gothic", 1, 12));
         c2=new GridBagConstraints();
         c2.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c2.ipady = 0;       //make this component tall
         c2.weightx = 1.0; //request any extra vertical space
         c2.anchor = GridBagConstraints.CENTER; //bottom of space
         c2.insets = new Insets(4,20,4,4);  //top padding
         c2.gridx = 0;       //aligned with button 2
         c2.gridwidth = 1;   //2 columns wide
         c2.gridy = 1;       //third row
         add(txtBuscar,c2);
     
         btnBuscar=new JButton("Buscar");
         btnBuscar.setFont(new Font("Century Gothic", 2, 12));
         c3=new GridBagConstraints();
         c3.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c3.ipady = 0;       //make this component tall
         c3.anchor = GridBagConstraints.CENTER; //bottom of space
         c3.insets = new Insets(4,4,4,100);  //top padding
         c3.gridx = 1;       //aligned with button 2
         c3.gridwidth = 1;   //2 columns wide
         c3.gridy = 1;       //third row
         add(btnBuscar,c3);
         btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnBuscarActionPerformed(evt);
                limpiarCajas();
            }
         });

     


        tablaRegistros=new JTable(modelo);
        modelo.addColumn("Codigo Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Marca");
        modelo.addColumn("Fabricante");
        modelo.addColumn("Precio");
        tablaRegistros.setFont(new Font("Century Gothic", 2, 12));
        tablaRegistros.setPreferredScrollableViewportSize(new Dimension(500, 200));
        tablaRegistros.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
         JScrollPane scrollPane = new JScrollPane(tablaRegistros);
        //Add the scroll pane to this panel.
         c5=new GridBagConstraints();
         c5.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c5.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c5.anchor = GridBagConstraints.CENTER; //bottom of space
         c5.insets = new Insets(4,20,4,20);  //top padding
         c5.gridx = 0;       //aligned with button 2
         c5.gridwidth = 4;
         c5.gridheight = 1;  //2 columns wide
         c5.gridy = 2;       //third row
         add(scrollPane,c5);
     
         btnRegistroUso=new JButton("Menú Principal");
         btnRegistroUso.setFont(new Font("Century Gothic", 2, 12));
         c6=new GridBagConstraints();
         c6.fill = GridBagConstraints.NONE;  //natural height, maximum width
         c6.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c6.anchor = GridBagConstraints.CENTER; //bottom of space
         c6.insets = new Insets(4,4,4,20);  //top padding
         c6.gridx = 0;       //aligned with button 2
         c6.gridwidth = 1;   //2 columns wide
         c6.gridy = 3;       //third row
         add(btnRegistroUso,c6);
         
         btnCompras=new JButton("Editar");
         btnCompras.setFont(new Font("Century Gothic", 2, 12));
         c7=new GridBagConstraints();
         c7.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c7.ipady = 0;       //make this component tall
         c7.anchor = GridBagConstraints.CENTER; //bottom of space
         c7.insets = new Insets(4,4,4,20);  //top padding
         c7.gridx = 1;       //aligned with button 2
         c7.gridwidth = 1;   //2 columns wide
         c7.gridy = 3;       //third row
         add(btnCompras,c7);
         
         btnAgregar=new JButton("Agregar");
         btnAgregar.setFont(new Font("Century Gothic", 2, 12));
         c8=new GridBagConstraints();
         c8.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c8.ipady = 0;       //make this component tall
         c8.anchor = GridBagConstraints.CENTER; //bottom of space
         c8.insets = new Insets(4,4,4,20);  //top padding
         c8.gridx = 2;       //aligned with button 2
         c8.gridwidth = 1;   //2 columns wide
         c8.gridy = 3;       //third row
         add(btnAgregar,c8);
         
         btnEliminar=new JButton("Eliminar");
         btnEliminar.setFont(new Font("Century Gothic", 2, 12));
         c9=new GridBagConstraints();
         c9.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c9.ipady = 0;       //make this component tall
         c9.anchor = GridBagConstraints.CENTER; //bottom of space
         c9.insets = new Insets(4,4,4,20);  //top padding
         c9.gridx = 3;       //aligned with button 2
         c9.gridwidth = 1;   //2 columns wide
         c9.gridy = 3;       //third row
         add(btnEliminar,c9);
         btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEliminarevt(evt);
                limpiarCajas();
            }
        });




    }
      public void paintComponent(Graphics g){
        Dimension tamanno=getSize();
        ImageIcon imageFondo=new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imageFondo.getImage(), 0, 0, tamanno.width,tamanno.height,null);
        setOpaque(false);
        super.paintComponents(g);
    }

    private void limpiarCajas() {

        txtBuscar.setText(null);
    }

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {

        Connection con = null;

        try {

            con = getConection();
            ps = con.prepareStatement("SELECT * FROM ingenieria.producto WHERE nombre like ?");
            ps.setString(1,  "%"+ txtBuscar.getText() + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                fila[0] = rs.getObject("codigo_producto");
                fila[1] = rs.getObject("nombre");
                fila[2] = rs.getObject("descripcion");
                fila[3] = rs.getObject("marca");
                fila[4] = rs.getObject("fabricante");
                fila[5] = rs.getObject("precio");
                modelo.addRow(fila);

            } //else {
                //JOptionPane.showMessageDialog(null, "No existe un producto con ese nombre");
            //}

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "No existe un producto con ese nombre");
        }

    }

    public void btnEliminarevt(java.awt.event.ActionEvent evt){
        int fila = tablaRegistros.getSelectedRow();
        int id = (int) tablaRegistros.getValueAt(fila,0);
        System.out.println(id);

        Connection con = null;

        try {

            con = getConection();
            ps = con.prepareStatement("DELETE FROM ingenieria.producto WHERE codigo_producto = ?");
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se elimino el producto");
        } catch (Exception ex) {
            System.err.println(ex);
        }


        }
    
    public void ejecutar(){
        JFrame n=new JFrame();
        n.setMinimumSize(new Dimension(750,500));
        PanelConsulta p=new PanelConsulta();
        n.add(p);
        n.setVisible(true);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
