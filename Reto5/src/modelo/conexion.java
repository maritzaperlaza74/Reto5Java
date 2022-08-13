/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
/**
 *
 * @author jlpc8830
 */
public class conexion {
    
    public void as(){
    
        
        
    }
    
    Connection con =  null;
    
    
    public Connection conexion(){
   
    try{
         Class.forName("org.mariadb.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/proyectosconstruccion","root","aggripa3128120229");
         System.out.println("Conexión ok");

} 

    catch(Exception e){
    System.out.println("Error "+e);
}
    
       return con;
    }
}
    
