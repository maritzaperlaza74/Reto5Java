/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import vista.*;
import modelo.*;

/**
 *
 * @author jlpc8830
 */
public class controlador  implements ActionListener {

    DefaultTableModel tabla = new DefaultTableModel();
    Object [] datos = null;
    
    
    private Vista view;
    
    public controlador() {
        this.view = new Vista();
    }
    
    public void inicio(){
    view.setVisible(true);
    view.setTitle("Reto aprediendo java");
    this.view.informe1.addActionListener(this);
    this.view.informe2.addActionListener(this);
    this.view.informe3.addActionListener(this);
    
}
    
    public void consultalider(){
        
         DefaultTableModel tabla = new DefaultTableModel();
         view.area.setText("");
        
     
        view.area.append("Informe basado en la tabla con la información respectiva al “Líder”. \n" +
"El listado contiene: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia.\n" +
"Este informe está ordenado por la “Ciudad_Residencia” de forma alfabética");
        
        
        
        datos = new Object[4];
        
        try {
            conexion con1 = new conexion();
            
            Connection con = con1.conexion();
            
            String sql = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia ASC";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            String[] encabezado = {"ID_Lider", "Nombre", "Primer_Apellido", "Ciudad_Residencia"};
            tabla.setColumnIdentifiers(encabezado);
            view.tablavista.setModel(tabla);
            while(rs.next()){
                
                //view.area.append(rs.getString(1)+"\n");
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                
            tabla.addRow(datos);
            
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta1 " +ex);
            
           
            
            
        }






}
    
    
    public void consulta2(){
        
          DefaultTableModel tabla = new DefaultTableModel();
       
         view.area.setText("");
        view.area.append("Informe basado en la información de los proyectos cuya clasicación sea casa campestre, \n"+
                "y que están ubicados en la ciudad de Santa Marta, Cartagena y Barranquilla. \n"+
                "Contiene los campos ID_Proyecto, Constructora, Número de habitaciones y la Ciudad");
        
        
        datos = new Object[4];
        
        try {
            conexion con1 = new conexion();
            
            Connection con = con1.conexion();
            
            String sql = "SELECT ID_Proyecto,Constructora,Numero_Habitaciones,Ciudad FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Barranquilla', 'Santa Marta', 'Cartagena')";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            String[] encabezado = {"ID_Proyecto", "Constructora", "Numero_Habitaciones", "Ciudad"};
            tabla.setColumnIdentifiers(encabezado);
            view.tablavista.setModel(tabla);
            while(rs.next()){
                
                //view.area.append(rs.getString(1)+"\n");
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                
            tabla.addRow(datos);
            
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta1 " +ex);
        }






}
     
    public void consulta3(){
        
        DefaultTableModel tabla = new DefaultTableModel();
        
        view.area.setText("");
        
        view.area.append("Informe basado en las compras realizadas por los proyectos con el proveedor Homecenter, \n"+
                "y para la ciudad de Salento. Este informe incluye ID_compra, Constructora y Banco vinculado");
        
        
        datos = new Object[3];
        
        try {
            conexion con1 = new conexion();
            
            Connection con = con1.conexion();
            
            String sql = "SELECT Y.ID_Compra,X.Constructora,X.Banco_Vinculado FROM PRoyecto X JOIN Compra Y ON X.ID_Proyecto = Y.ID_Proyecto WHERE Y.Proveedor = 'Homecenter' AND X.Ciudad = 'Salento'";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            String[] encabezado = {"ID_Compra", "Constructora", "Banco_Vinculado"};
            tabla.setColumnIdentifiers(encabezado);
            view.tablavista.setModel(tabla);
            while(rs.next()){
                
                //view.area.append(rs.getString(1)+"\n");
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                
                
            tabla.addRow(datos);
            
            }
            
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta1 " +ex);
        }






}
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == view.informe1){
            
            consultalider();
        }
        
        if (e.getSource() == view.informe2){
            
            consulta2();
        
        }
        
        if (e.getSource() == view.informe3){
            
            consulta3();
        
        }
        
        
         }
    

}
