/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 *
 * @author admin
 */
public class PanelVentas extends JPanel{
    private JLabel etisubTotal,etIva,etiTotal,etiBusqueda,etiFolio,titulo,etiClave,etiNombre,etiMarca,etiAncho,etiCant,etiExist,busqueda,etiFecha,etiOrden,etiCliente,etiDatos,etiClaveMarca,etiNombreMarca,etiProv,etiRfc,etiDireccion,etiFax,etiConvenio,etiEnvio,etiTel,etiExt,etiEjecutivo,etiCorreo;
    private JButton regresar,cancelar,cobrar, buscar;
    private JTextField txtsubTotal,txtIVA,txtTotal,txtClave,txtFolio,txtNombre,txtMarca,txtAncho,txtCant,txtExist,txtFecha,txtOrden,txtCliente,txtDatos,txtClaveMarca,txtNombreMarca,txtProv,txtRfc,txtDireccion,txtFax,txtConvenio,txtEnvio,txtTel,txtExt,txtEjecutivo,txtCorreo;
    private JTable listRegistro,listaDatosBancarios;
    private GridBagConstraints c,c47,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25;
    DefaultTableModel modelo = new DefaultTableModel();
    public static final String URL = "jdbc:postgresql://localhost:5432/PuntoVentaIng";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "123456789";

    PreparedStatement ps,ps1;
    ResultSet rs,rs1;

    int folioventa=1;

    public PanelVentas(){
        setLayout(new GridBagLayout());
        crear();
        setVisible(true);
    }



    public void crear(){
         titulo=new JLabel("VENTAS");
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
         
         etiFolio=new JLabel("Folio");
         etiFolio.setFont(new Font("Century Gothic", 4, 12));
         etiFolio.setForeground(Color.WHITE);
         c1=new GridBagConstraints();
         c1.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c1.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c1.anchor = GridBagConstraints.CENTER; //bottom of space
         c1.insets = new Insets(4,20,4,4);  //top padding
         c1.gridx = 4;       //aligned with button 2
         c1.gridwidth = 1;   //2 columns wide
         c1.gridy = 0;       //third row
         add(etiFolio,c1);
         
         txtFolio=new JTextField();
         txtFolio.setFont(new Font("Century Gothic", 4, 12));
         c2=new GridBagConstraints();
         c2.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c2.ipady = 0;       //make this component tall
         c2.weightx = 1.0; //request any extra vertical space
         c2.anchor = GridBagConstraints.CENTER; //bottom of space
         c2.insets = new Insets(4,4,4,20);  //top padding
         c2.gridx = 5;       //aligned with button 2
         c2.gridwidth = 1;   //2 columns wide
         c2.gridy = 0;       //third row
         add(txtFolio,c2);
         
         etiClave=new JLabel("Codigo");
         etiClave.setFont(new Font("Century Gothic", 4, 12));
         etiClave.setForeground(Color.WHITE);
         c3=new GridBagConstraints();
         c3.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c3.ipady = 0;       //make this component tall
         //c1.weightx = 1.0; //request any extra vertical space
         c3.anchor = GridBagConstraints.CENTER; //bottom of space
         c3.insets = new Insets(4,20,4,4);  //top padding
         c3.gridx = 0;       //aligned with button 2
         c3.gridwidth = 1;   //2 columns wide
         c3.gridy = 1;       //third row
         add(etiClave,c3);
         
         txtClave=new JTextField();
         txtClave.setFont(new Font("Century Gothic", 4, 12));
         c4=new GridBagConstraints();
         c4.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c4.ipady = 0;       //make this component tall
         c4.weightx = 1.0; //request any extra vertical space
         c4.anchor = GridBagConstraints.CENTER; //bottom of space
         c4.insets = new Insets(4,4,4,4);  //top padding
         c4.gridx = 1;       //aligned with button 2
         c4.gridwidth = 1;   //2 columns wide
         c4.gridy = 1;       //third row
         add(txtClave,c4);
         
         etiNombre=new JLabel("Nombre Producto");
         etiNombre.setFont(new Font("Century Gothic", 4, 12));
         etiNombre.setForeground(Color.WHITE);
         c5=new GridBagConstraints();
         c5.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c5.ipady = 0;       //make this component tall
         //c3.weightx = 1.0; //request any extra vertical space
         c5.anchor = GridBagConstraints.CENTER; //bottom of space
         c5.insets = new Insets(4,4,4,4);  //top padding
         c5.gridx = 2;       //aligned with button 2
         c5.gridwidth = 1;   //2 columns wide
         c5.gridy = 1;       //third row
         add(etiNombre,c5);
         
         txtNombre=new JTextField();
         txtNombre.setFont(new Font("Century Gothic", 4, 12));
         c6=new GridBagConstraints();
         c6.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c6.ipady = 0;       //make this component tall
         c6.weightx = 1.0; //request any extra vertical space
         c6.anchor = GridBagConstraints.CENTER; //bottom of space
         c6.insets = new Insets(4,4,4,4);  //top padding
         c6.gridx = 3;       //aligned with button 2
         c6.gridwidth = 1;   //2 columns wide
         c6.gridy = 1;       //third row
         add(txtNombre,c6);
         
         etiMarca=new JLabel("Descripción");
         etiMarca.setFont(new Font("Century Gothic", 4, 12));
         etiMarca.setForeground(Color.WHITE);
         c7=new GridBagConstraints();
         c7.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c7.ipady = 0;       //make this component tall
         //c5.weightx = 1.0; //request any extra vertical space
         c7.anchor = GridBagConstraints.CENTER; //bottom of space
         c7.insets = new Insets(4,20,4,4);  //top padding
         c7.gridx = 4;       //aligned with button 2
         c7.gridwidth = 1;   //2 columns wide
         c7.gridy = 1;       //third row
         add(etiMarca,c7);
         
         txtMarca=new JTextField();
         txtMarca.setFont(new Font("Century Gothic", 4, 12));
         c8=new GridBagConstraints();
         c8.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c8.ipady = 0;       //make this component tall
         c8.weightx = 1.0; //request any extra vertical space
         c8.anchor = GridBagConstraints.CENTER; //bottom of space
         c8.insets = new Insets(4,4,4,20);  //top padding
         c8.gridx = 5;       //aligned with button 2
         c8.gridwidth = 1;   //2 columns wide
         c8.gridy = 1;       //third row
         add(txtMarca,c8);
                          
         etiAncho=new JLabel("Cantidad");
         etiAncho.setFont(new Font("Century Gothic", 4, 12));
         etiAncho.setForeground(Color.WHITE);
         c9=new GridBagConstraints();
         c9.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c9.ipady = 0;       //make this component tall
         //c7.weightx = 1.0; //request any extra vertical space
         c9.anchor = GridBagConstraints.CENTER; //bottom of space
         c9.insets = new Insets(4,20,4,4);  //top padding
         c9.gridx = 0;       //aligned with button 2
         c9.gridwidth = 1;   //2 columns wide
         c9.gridy = 2;       //third row
         add(etiAncho,c9);
         
         txtAncho=new JTextField();
         txtAncho.setFont(new Font("Century Gothic", 4, 12));
         c10=new GridBagConstraints();
         c10.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c10.ipady = 0;       //make this component tall
         c10.weightx = 1.0; //request any extra vertical space
         c10.anchor = GridBagConstraints.CENTER; //bottom of space
         c10.insets = new Insets(4,4,4,4);  //top padding
         c10.gridx = 1;       //aligned with button 2
         c10.gridwidth = 1;   //2 columns wide
         c10.gridy = 2;       //third row
         add(txtAncho,c10);
         
         etiCant=new JLabel("Precio unitario");
         etiCant.setFont(new Font("Century Gothic", 4, 12));
         etiCant.setForeground(Color.WHITE);
         c11=new GridBagConstraints();
         c11.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c11.ipady = 0;       //make this component tall
         //c9.weightx = 1.0; //request any extra vertical space
         c11.anchor = GridBagConstraints.CENTER; //bottom of space
         c11.insets = new Insets(4,4,4,4);  //top padding
         c11.gridx = 2;       //aligned with button 2
         c11.gridwidth = 1;   //2 columns wide
         c11.gridy = 2;       //third row
         add(etiCant,c11);
         
         txtCant=new JTextField();
         txtCant.setFont(new Font("Century Gothic", 4, 12));
         c12=new GridBagConstraints();
         c12.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c12.ipady = 0;       //make this component tall
         c12.weightx = 1.0; //request any extra vertical space
         c12.anchor = GridBagConstraints.CENTER; //bottom of space
         c12.insets = new Insets(4,4,4,4);  //top padding
         c12.gridx = 3;       //aligned with button 2
         c12.gridwidth = 1;   //2 columns wide
         c12.gridy = 2;       //third row
         add(txtCant,c12);
         
         etiExist=new JLabel("Nombre vendedor");
         etiExist.setFont(new Font("Century Gothic", 4, 12));
         etiExist.setForeground(Color.WHITE);
         c13=new GridBagConstraints();
         c13.fill = GridBagConstraints.HORIZONTAL; 
         c13.ipady = 0;      
         c13.anchor = GridBagConstraints.CENTER; 
         c13.insets = new Insets(4,4,4,4);  
         c13.gridx = 4;       
         c13.gridwidth = 1;   
         c13.gridy = 2;      
         add(etiExist,c13);
         
         txtExist=new JTextField("NomVendedor");
         txtExist.setFont(new Font("Century Gothic", 4, 12));
         c15=new GridBagConstraints();
         c15.fill = GridBagConstraints.HORIZONTAL;  
         c15.ipady = 0;      
         c15.weightx = 1.0; 
         c15.anchor = GridBagConstraints.CENTER; 
         c15.insets = new Insets(4,4,4,20); 
         c15.gridx = 5;       
         c15.gridwidth = 1;  
         c15.gridy = 2;     
         add(txtExist,c15);
         
        
         
         //String[] columnNames = {"Código","Nombre producto","Descripción","Cantidad","Precio unitario","total"};
       //  Object[][] data = {};


        ;
        listRegistro=new JTable(modelo);
        modelo.addColumn("Codigo Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Marca");
        modelo.addColumn("Fabricante");
        modelo.addColumn("Precio");
        listRegistro.setFont(new Font("Century Gothic", 4, 12));
        listRegistro.setPreferredScrollableViewportSize(new Dimension(500, 100));
        listRegistro.setFillsViewportHeight(true);
        //Create the scroll pane and add the table to it.
         JScrollPane scrollPane = new JScrollPane(listRegistro);
        //Add the scroll pane to this panel.
         c16=new GridBagConstraints();
         c16.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c16.ipady = 0;       //make this component tall
         //c12.weighty = 1.0;
         //c20.weightx = 1.0; //request any extra vertical space
         c16.anchor = GridBagConstraints.CENTER; //bottom of space
         c16.insets = new Insets(4,20,4,20);  //top padding
         c16.gridx = 0;       //aligned with button 2
         c16.gridwidth = 6;
         c16.gridy = 5;       //third row
         add(scrollPane,c16);
         
         buscar=new JButton("Buscar");
         buscar.setFont(new Font("Century Gothic",4,12));
         add(buscar);
         buscar.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
                 enter(evt);
             }
         });
         
         regresar=new JButton("Menú Principal");
         regresar.setFont(new Font("Century Gothic", 4, 12));
         c17=new GridBagConstraints();
         c17.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c17.ipady = 0;       //make this component tall
         c17.weightx = 1.0; //request any extra vertical space
         c17.anchor = GridBagConstraints.CENTER; //bottom of space
         c17.insets = new Insets(4,20,4,4);  //top padding
         c17.gridx = 3;       //aligned with button 2
         c17.gridwidth = 1;   //2 columns wide
         c17.gridy = 12;       //third row
         add(regresar,c17);
         
         etisubTotal=new JLabel("SUBTOTAL :");
         etisubTotal.setFont(new Font("Century Gothic", 4, 12));
         etisubTotal.setForeground(Color.WHITE);
         c18=new GridBagConstraints();
         c18.fill = GridBagConstraints.WEST; 
         c18.ipady = 0;      
         c18.anchor = GridBagConstraints.CENTER; 
         c18.insets = new Insets(4,4,4,4);  
         c18.gridx = 4;       
         c18.gridwidth = 1;   
         c18.gridy = 12;      
         add(etisubTotal,c18);
         
         txtsubTotal=new JTextField();
         txtsubTotal.setFont(new Font("Century Gothic", 4, 12));
         txtsubTotal.setEnabled(false);
         txtsubTotal.setForeground(Color.BLACK);
         txtsubTotal.setDisabledTextColor(Color.BLACK);
         c19=new GridBagConstraints();
         c19.fill = GridBagConstraints.HORIZONTAL;  
         c19.ipady = 0;      
         c19.weightx = 1.0; 
         c19.anchor = GridBagConstraints.CENTER; 
         c19.insets = new Insets(4,4,4,20); 
         c19.gridx = 5;       
         c19.gridwidth = 1;  
         c19.gridy = 12;     
         add(txtsubTotal,c19);
         
         cancelar=new JButton("Cancelar");
         cancelar.setFont(new Font("Century Gothic", 4, 12));
         c25=new GridBagConstraints();
         c25.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c25.ipady = 0;       //make this component tall
         c25.weightx = 1.0; //request any extra vertical space
         c25.anchor = GridBagConstraints.CENTER; //bottom of space
         c25.insets = new Insets(4,20,4,4);  //top padding
         c25.gridx = 3;       //aligned with button 2
         c25.gridwidth = 1;   //2 columns wide
         c25.gridy = 13;       //third row
         add(cancelar,c25);
         
         etIva=new JLabel("I.V.A. :");
         etIva.setFont(new Font("Century Gothic", 4, 12));
         etIva.setForeground(Color.WHITE);
         c20=new GridBagConstraints();
         c20.fill = GridBagConstraints.WEST; 
         c20.ipady = 0;      
         c20.anchor = GridBagConstraints.CENTER; 
         c20.insets = new Insets(4,4,4,4);  
         c20.gridx = 4;       
         c20.gridwidth = 1;   
         c20.gridy = 13;      
         add(etIva,c20);
         
         txtIVA=new JTextField();
         txtIVA.setFont(new Font("Century Gothic", 4, 12));
         txtIVA.setEnabled(false);
         txtIVA.setForeground(Color.BLACK);
         txtIVA.setDisabledTextColor(Color.BLACK);
         c21=new GridBagConstraints();
         c21.fill = GridBagConstraints.HORIZONTAL;  
         c21.ipady = 0;      
         c21.weightx = 1.0; 
         c21.anchor = GridBagConstraints.CENTER; 
         c21.insets = new Insets(4,4,4,20); 
         c21.gridx = 5;       
         c21.gridwidth = 1;  
         c21.gridy = 13;     
         add(txtIVA,c21);
         
         etiTotal=new JLabel("TOTAL :");
         etiTotal.setFont(new Font("Century Gothic", 4, 12));
         etiTotal.setForeground(Color.WHITE);
         c22=new GridBagConstraints();
         c22.fill = GridBagConstraints.WEST; 
         c22.ipady = 0;      
         c22.anchor = GridBagConstraints.CENTER; 
         c22.insets = new Insets(4,4,4,4);  
         c22.gridx = 4;       
         c22.gridwidth = 1;   
         c22.gridy = 14;      
         add(etiTotal,c22);
         
         txtTotal=new JTextField();
         txtTotal.setFont(new Font("Century Gothic", 4, 12));
         txtTotal.setEnabled(false);
         txtTotal.setEditable(false);
         txtTotal.setForeground(Color.BLACK);
         txtTotal.setDisabledTextColor(Color.BLACK);
         c23=new GridBagConstraints();
         c23.fill = GridBagConstraints.HORIZONTAL;  
         c23.ipady = 0;      
         c23.weightx = 1.0; 
         c23.anchor = GridBagConstraints.CENTER; 
         c23.insets = new Insets(4,4,4,20); 
         c23.gridx = 5;       
         c23.gridwidth = 1;  
         c23.gridy = 14;     
         add(txtTotal,c23);
         
         cobrar=new JButton("Cobrar");
         cobrar.setFont(new Font("Century Gothic", 4, 12));
         c24=new GridBagConstraints();
         c24.fill = GridBagConstraints.HORIZONTAL;  //natural height, maximum width
         c24.ipady = 0;       //make this component tall
         c24.weightx = 1.0; //request any extra vertical space
         c24.anchor = GridBagConstraints.CENTER; //bottom of space
         c24.insets = new Insets(4,20,4,4);  //top padding
         c24.gridx = 3;       //aligned with button 2
         c24.gridwidth = 1;   //2 columns wide
         c24.gridy = 14;       //third row
         add(cobrar,c24);


    }
    public void paintComponent(Graphics g){
        Dimension tamanno=getSize();
        ImageIcon imageFondo=new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imageFondo.getImage(), 0, 0, tamanno.width,tamanno.height,null);
        setOpaque(false);
        super.paintComponents(g);
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


    private void enter(ActionEvent e){
            //System.out.println("asd");
            Connection con = null;

            try {
                con = getConection();
                ps = con.prepareStatement("SELECT * FROM ingenieria.producto WHERE codigo_producto = ?");

                ps1 = con.prepareStatement("SELECT precio FROM ingenieria.producto WHERE codigo_producto = ?");

                // ps.setString(1, );
                
                ps.setInt(1, Integer.parseInt(txtClave.getText()));
                ps1.setInt(1, Integer.parseInt(txtClave.getText()));

                rs = ps.executeQuery();
                rs1 = ps1.executeQuery();

                if (rs.next()) {
                    //Object[][] data = {{rs.getString("codigo_producto"),rs.getString("descripcion"),rs.getString("marca"),rs.getString("fabricante"),rs.getString("precio")}};
                    Object[] fila = new Object[6];
                    fila[0] = rs.getObject("codigo_producto");
                    fila[2] = rs.getObject("descripcion");
                    fila[3] = rs.getObject("marca");
                    fila[4] = rs.getObject("fabricante");
                    fila[5] = rs.getObject("precio");
                    modelo.addRow(fila);
                    txtCant.setText(rs.getString("precio"));
                    //txtTotal.setText("$  " + rs.getString("precio"));

                    double total=0.0;
                    int totalrow=listRegistro.getRowCount();
                    totalrow-=1;
                    for(int i = 0 ; i <= (totalrow) ; i++){
                        double sumatoria = Double.parseDouble(String.valueOf(modelo.getValueAt(i,5)));
                        total+=sumatoria;
                    }
                    txtsubTotal.setText("$  " + total);
                    double iva = total * 0.16;
                    double total2 = total + iva;
                    txtIVA.setText("$  " + iva);
                    txtTotal.setText("$  " + total2);
                    txtFolio.setText("" + folioventa);
                } else {
                    JOptionPane.showMessageDialog(cobrar, "Datos ingresados incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }

                
            } catch (Exception f) {
                System.err.println(f);

            }
        }




    public void ejecutar(){
        JFrame n=new JFrame();
        n.setMinimumSize(new Dimension(750,500));
        PanelVentas p=new PanelVentas();
        n.add(p);
        n.setVisible(true);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
