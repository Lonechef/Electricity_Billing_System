
package electricity.billing.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;




public class DepositDetails extends JFrame implements ActionListener{
    
    Choice cmeterno,cmonth;
    JButton search,print;
    
    //Now we will make table in Java
    JTable table;
    DepositDetails(){
       //Now using super function we will set the name of the frame
      super("Deposit Details");
      setSize(700,700);
      setLocation(400,100);
      
      //So basically setLayout is the method by which we take all the control from the system other wise system will accordingly set everything
      
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
     
      
      JLabel lblmeternumber=new JLabel("Search by Meter Number");
      lblmeternumber.setBounds(20,30,150,20);
      add(lblmeternumber);
      
      cmeterno= new Choice();
      cmeterno.setBounds(180,30,100,20);
      add(cmeterno);
      
      try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer");
          while(rs.next()){
            cmeterno.add(rs.getString("meter_no"));
          }
           }catch(Exception e){
          e.printStackTrace();
      }
      
      JLabel month=new JLabel("Search by Month");
      month.setBounds(400,30,120,20);
      add(month);
      
      cmonth= new Choice();
      cmonth.setBounds(530,30,100,20);
      cmonth.add("January");
      cmonth.add("February");
      cmonth.add("March");
      cmonth.add("April");
      cmonth.add("May");
      cmonth.add("June");
      cmonth.add("July");
      cmonth.add("August");
      cmonth.add("September");
      cmonth.add("October");
      cmonth.add("November");
      cmonth.add("December");
      add(cmonth);
      
      table= new JTable();
      try{
          //So here we have to find all the data in the database according to vale asked by admin
          Conn c = new Conn();
          ResultSet rs= c.s.executeQuery("select * from bill");
          //Here we will using DButils class to do this 
          //setModel is the function which helps to set the data
          table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch(Exception e){
          e.printStackTrace();
      }
      //Also in JAVA we need to make the scroll bar manually
      
      JScrollPane sp= new JScrollPane(table);
      sp.setBounds(0,100,700,600);
      add(sp);
      
      search = new JButton("Search");
      search.setBounds(20,70,80,20);
      search.addActionListener(this);
      add(search);
      
      print = new JButton("Print");
      print.setBounds(120,70,80,20);
      print.addActionListener(this);
      add(print);
      
      
      
       setVisible(true);
      
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
   //So now after admin selects the meter number and month according to that the details should be displayed
        
String query="select * from bill where meter_no='"+cmeterno.getSelectedItem()+"' and month='"+cmonth.getSelectedItem()+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                //Now the data should be printed in the table
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            
        }
        else if(ae.getSource()==print){
            
        
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
        new DepositDetails();
        
    }
    
}
