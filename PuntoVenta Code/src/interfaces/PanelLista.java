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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author admin
 */
public class PanelLista extends JPanel{
    private JLabel informacion,titulo;
    private JTable tablaLista;
    private JButton print,regresar,agregar,eliminar,editar;
    private GridBagConstraints c,c1,c2,c3,c4,c5,c6,c7;
    
    public PanelLista(){
        setLayout(new GridBagLayout());
        crear();
        setVisible(true);
    }
    public void crear(){
         titulo=new JLabel("EMPLEADOS");
         titulo.setFont(new Font("Century Gothic", 3, 20));
         titulo.setForeground(Color.WHITE);
         c=new GridBagConstraints();
         c.fill = GridBagConstraints.BOTH;  //natural height, maximum width
         c.ipady = 1;       //make this component tall
         c.anchor = GridBagConstraints.NORTHWEST; //bottom of space
         c.insets = new Insets(4,20,4,4);  //top padding
         c.gridheight = 1; 
         c.gridwidth = 3;   
         c.gridx=0;
         c.gridy = 0;       //third row
         add(titulo,c);
         
         
         String[] columnNames = {"Núm","Nombre empleado","puesto","Antigüedad","Sueldo base"};
         Object[][] data = {{"1","Juan Gutiérrez","vendedor","2 años","$1500.00"}};

     tablaLista=new JTable(data,columnNames);
        tablaLista.setFont(new Font("Century Gothic", 2, 12));
        tablaLista.setPreferredScrollableViewportSize(new Dimension(500, 150));
        tablaLista.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
         JScrollPane scrollPane = new JScrollPane(tablaLista);
        //Add the scroll pane to this panel.
         c2=new GridBagConstraints();
         c2.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c2.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c2.anchor = GridBagConstraints.CENTER; //bottom of space
         c2.insets = new Insets(4,20,4,20);  //top padding
         c2.gridx = 0;       //aligned with button 2
         c2.gridwidth = 5;
         c2.gridheight = 1;  //2 columns wide
         c2.gridy = 2;       //third row
         add(scrollPane,c2);
         
     print=new JButton("Menú principal");
         print.setFont(new Font("Century Gothic", 2, 12));
         c3=new GridBagConstraints();
         c3.fill = GridBagConstraints.NONE;  //natural height, maximum width
         c3.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c3.anchor = GridBagConstraints.CENTER; //bottom of space
         c3.insets = new Insets(4,20,4,4);  //top padding
         c3.gridx = 0;       //aligned with button 2
         c3.gridwidth = 1;   //2 columns wide
         c3.gridy = 3;       //third row
         add(print,c3);
         
         regresar=new JButton("Agregar");
         regresar.setFont(new Font("Century Gothic", 2, 12));
         c4=new GridBagConstraints();
         c4.fill = GridBagConstraints.NONE;  //natural height, maximum width
         c4.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c4.anchor = GridBagConstraints.EAST; //bottom of space
         c4.insets = new Insets(4,4,4,20);  //top padding
         c4.gridx = 2;       //aligned with button 2
         c4.gridwidth = 1;   //2 columns wide
         c4.gridy = 3;       //third row
         add(regresar,c4);
         
         editar=new JButton("Editar");
         editar.setFont(new Font("Century Gothic", 2, 12));
         c5=new GridBagConstraints();
         c5.fill = GridBagConstraints.NONE;  //natural height, maximum width
         c5.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c5.anchor = GridBagConstraints.EAST; //bottom of space
         c5.insets = new Insets(4,4,4,20);  //top padding
         c5.gridx = 3;       //aligned with button 2
         c5.gridwidth = 1;   //2 columns wide
         c5.gridy = 3;       //third row
         add(editar,c5);
         
         eliminar=new JButton("Eliminar");
         eliminar.setFont(new Font("Century Gothic", 2, 12));
         c6=new GridBagConstraints();
         c6.fill = GridBagConstraints.NONE;  //natural height, maximum width
         c6.ipady = 0;       //make this component tall
         //c12.weighty = 1.0; 
         //c12.weightx = 1.0; //request any extra vertical space
         c6.anchor = GridBagConstraints.EAST; //bottom of space
         c6.insets = new Insets(4,4,4,20);  //top padding
         c6.gridx = 4;       //aligned with button 2
         c6.gridwidth = 1;   //2 columns wide
         c6.gridy = 3;       //third row
         eliminar.setForeground(Color.RED);
         add(eliminar,c6);
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
        PanelLista p=new PanelLista();
        n.add(p);
        n.setVisible(true);
    }
    
}
