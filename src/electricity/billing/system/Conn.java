
package electricity.billing.system;

import java.sql.*;

public class Conn {
    //Making Global variable of type Connection
    
    //This Connection lies in the package sql
    
    Connection c;
    //Cretaing a statement of jdbc connectivity
    Statement s;
    Conn(){
        try{
        //So for connecting the MySql we use the class Driver 
        //3306 is the Port Number for MySql
        //ebs is the name of our database
        
       
        //DriverManager.getConnection("jdbc:dabase name://localhost:3306/ebs","my sql username","my sql password");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","Saumya@129284263");
        //So basically this is helpful creating a statement using a connectio  object to interact with the database
        s=c.createStatement();
        
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }
    
}
