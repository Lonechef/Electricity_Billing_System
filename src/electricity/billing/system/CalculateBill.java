
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;





public class CalculateBill extends JFrame implements ActionListener{
    //Declaring required textfields globally
    JTextField tfname,tfunitsconsumed;
    JLabel lblname,lbladdress;
    Choice meterno,cmonth;
    //Adding few buttons
    JButton Next,Cancel;
    CalculateBill(){
        setSize(700,500);
        setLocation(400,200);
        
        ///Now we will make a Panel
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(180,10,400,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel meterNumber = new JLabel("Meter No");
        meterNumber.setBounds(100,80,100,20);
        p.add(meterNumber);
        
        meterno=new Choice();
        //Now here we need to get data of the customer table
        try{
           //Building a Connection with the database
           Conn c = new Conn();
           //Now storing our fetched data in the result set
           ResultSet rs = c.s.executeQuery("select * from customer");
           //Now here we need to loop through all the queries of the customer table
           //For this we will use the while loop
           while(rs.next()){
               //Now adding choices directly to meterno
               //here meter_no is the meter number stored in the customer table
               meterno.add(rs.getString("meter_no"));
           }
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
        meterno.setBounds(240,80,200,20);
        p.add(meterno);
        
      
        JLabel Name = new JLabel("Name");
        Name.setBounds(100,120,100,20);
        p.add(Name);
        
        lblname = new JLabel("");
        lblname.setBounds(240,120,100,20);
        p.add(lblname);
        
        
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(100,160,100,20);
        p.add(lblAddress);
        
        
        lbladdress= new JLabel();
        lbladdress.setBounds(240,160,200,20);
        p.add(lbladdress);
        
        //As the meter number changes the name and address should aslo change
        //So do this we use ItemListener
        //For button it is Event Listenerer and here for choice it is Item Listener
        meterno.addItemListener(new ItemListener(){
            //Now ItemListener has its own method called itemsStateChanged so doing method overriding
            public void itemStateChanged(ItemEvent ie){
                //Now the values of name and adress should be entered dynamically according to the meter number
        try{
            Conn c = new Conn();
            //Now here we need to select only those query whose meter number which is selected by user matches to the which in data bse
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meterno.getSelectedItem()+"'");
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lbladdress.setText(rs.getString("address"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
            
        }
                
                
            }
        });
        
        JLabel lblUnitConsumed = new JLabel("Units Consumed");
        lblUnitConsumed.setBounds(100,200,100,20);
        p.add(lblUnitConsumed);
        
        
        tfunitsconsumed= new JTextField();
        tfunitsconsumed.setBounds(240,200,200,20);
        p.add(tfunitsconsumed);
        
        JLabel lblMonth = new JLabel("Month");
        lblMonth.setBounds(100,240,100,20);
        p.add(lblMonth);
        
        
        
        cmonth= new Choice();
        cmonth.setBounds(240,240,200,20);
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
        p.add(cmonth);

        
        Next = new JButton("Next");
        Next.setBounds(120,390,100,25);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        //Adding actionListener to the next
        Next.addActionListener(this);
        p.add(Next);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(250,390,100,25);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        p.add(Cancel);
        
        
        //Setting up the border Layout
        
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2=i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        //Now we have to appply image on the west side
        add(image,"West");
        
        //Now changing the color of the background of the image inserted
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    //Now overriding the abstract method present in the action Listener class
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Next){
          String meter= meterno.getSelectedItem();
          String units=tfunitsconsumed.getText();
          String month=cmonth.getSelectedItem();
          
          int totalbill=0;
          int units_consumed=Integer.parseInt(units);
          String query= "select * from tax";
 
         try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
               
          while(rs.next()){
              //So now bill can be calculated by doing units*tax
             totalbill+= units_consumed*Integer.parseInt(rs.getString("cost_per_unit"));
             totalbill+=units_consumed*Integer.parseInt(rs.getString("meter_rent"));
             totalbill+=units_consumed*Integer.parseInt(rs.getString("service_charge"));
             totalbill+=units_consumed*Integer.parseInt(rs.getString("service_tax"));
             totalbill+=units_consumed*Integer.parseInt(rs.getString("swacch_bharat_cess"));
             totalbill+=units_consumed*Integer.parseInt(rs.getString("fixed_tax"));
             
          }
          }catch(Exception e){
                e.printStackTrace();
                
          }
         //Now here we will make query for inserting the values in the table
        
        String query2 ="insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','Not Paid')";
        
        //So after making this query we need to execute it
        try{
            Conn c = new Conn();
            //So now we are inserting the values in the table so we need to do executeUpdate
            c.s.executeUpdate(query2);
            //And if this is done  we need to pop a dialog box
            JOptionPane.showMessageDialog(null,"Customer bill updated Successfully");
            setVisible(false);
            
        }
            
        
        catch(Exception e){
            e.printStackTrace();
            
        }
        }
        
        
        
        else{
            
            //If we press the cancel button then 
            setVisible(false);
        }
     }
   
    
    
    public static void main(String [] args){
        new CalculateBill();
    }
    
    
}