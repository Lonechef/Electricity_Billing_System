
package electricity.billing.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;




public class CustomerDetails extends JFrame implements ActionListener{
    
    Choice cmeterno,cmonth;
    JButton search,print;
    
    //Now we will make table in Java
    JTable table;
    CustomerDetails(){
       //Now using super function we will set the name of the frame
      super("Customer Details");
      setSize(1200,650);
      setLocation(200,150);
      
      //So basically setLayout is the method by which we take all the control from the system other wise system will accordingly set everything
      
      
      table= new JTable();
      try{
          //So here we have to find all the data in the database according to vale asked by admin
          Conn c = new Conn();
          ResultSet rs= c.s.executeQuery("select * from customer");
          //Here we will using DButils class to do this 
          //setModel is the function which helps to set the data
          table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch(Exception e){
          e.printStackTrace();
      }
      //Also in JAVA we need to make the scroll bar manually
      
      JScrollPane sp= new JScrollPane(table);
      //So now as we had not give setLayout(null) so now it wont be working here i.e. system will set things accordingly
      //So we cannot use setBounds here
      //By default it will consider it to center
      add(sp);
      
      
      
      print = new JButton("Print");
    
      print.addActionListener(this);
      //We will add this print button to the south
      add(print,"South");
      
      
      
       setVisible(true);
      
    }
    public void actionPerformed(ActionEvent ae){
   
        if(ae.getSource()==print){
            
        
        try{
            //Now here we will be printing the whole table in form of pdf
            //Here jsut we have to give on which command we want to get printed
            table.print();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    public static void main(String [] args){
        new CustomerDetails();
        
    }
    
}
