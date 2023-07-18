
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;




public class PayBill extends JFrame implements  ActionListener {
    Choice cmonth;
    JButton Pay,Cancel;
    String meter;
    
    PayBill(String meter){
        this.meter=meter;
        setLayout(null);
        setBounds(300,150,900,600);
        JLabel heading= new JLabel("Electricity Bill");
        heading.setFont(new Font("Tahoma",Font.BOLD,24));
        heading.setBounds(120,5,400,30);
        add(heading);
        
        JLabel lblmeternumber= new JLabel("Meter Number");
        lblmeternumber.setBounds(30,80,200,20);
        add(lblmeternumber);
        
        JLabel meterno= new JLabel("meter");
        meterno.setBounds(250,80,200,20);
        add(meterno);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(30,120,200,20);
        add(lblname);
        
        JLabel name= new JLabel();
        name.setBounds(250,120,200,20);
        add(name);
        
        JLabel month= new JLabel("Month");
        month.setBounds(30,160,200,20);
        add(month);
        
        cmonth= new Choice();
        cmonth.setBounds(250,160,200,20);
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
        
        JLabel lblUnits= new JLabel("Units");
        lblUnits.setBounds(30,200,200,20);
        add(lblUnits);
        
        JLabel units= new JLabel();
        units.setBounds(250,200,200,20);
        add(units);
        
        JLabel lblBill= new JLabel("Toatal Bill");
        lblBill.setBounds(30,240,200,20);
        add(lblBill);
        
        JLabel bill= new JLabel();
        bill.setBounds(250,240,200,20);
        add(bill);
        
        JLabel lblStatus= new JLabel("Status");
        lblStatus.setBounds(30,280,200,20);
        add(lblStatus);
        
        JLabel status= new JLabel();
        status.setBounds(250,280,200,20);
        status.setForeground(Color.RED);
        add(status);
        
        Pay = new JButton("Pay");
        Pay.setBackground(Color.BLACK);
        Pay.setForeground(Color.WHITE);
        Pay.setBounds(150,340,100,20);
        Pay.addActionListener(this);
        
        add(Pay);
        
        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(350,340,100,20);
        Cancel.addActionListener(this);
        add(Cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);
        
        
        //Now here few details like name and meter number are in customer table 
        //So we will call the cuatomer 
        
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
               //Setting metenumeber and name 
              meterno.setText(meter);
              name.setText(rs.getString("name"));
              
              
            }
            
           //While details like units,toatalbill,status are in table which is created named as bill
            rs = c.s.executeQuery("select * from bill where meter_no='"+meter+"' And month='"+cmonth.getSelectedItem()+"'");
            while(rs.next()){
            //Setting metenumeber and name 
            units.setText(rs.getString("units"));
            bill.setText(rs.getString("totalbill"));
            status.setText(rs.getString("status"));
            
        }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        //Now here if we change the month then the deatils should be changed 
        
        //ForChoice we use ItemListener
        cmonth.addItemListener(new ItemListener(){
        //Now overiding the abstract method
            public void itemStateChanged(ItemEvent ae){
               try{
                   Conn c = new Conn();
                   ResultSet rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"'And month='"+cmonth.getSelectedItem()+"' ");
                   while(rs.next()){
            units.setText(rs.getString("units"));
            bill.setText(rs.getString("totalbill"));
            status.setText(rs.getString("status"));
                       
                   }
         }
               catch(Exception e){
                   e.printStackTrace();
            }
            }
            
        
    });
        
       
        setVisible(true);
        
    }
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Pay){
            try
            {
             Conn c = new Conn();
             //Now here we will update the bill status whether paid or not
             c.s.executeUpdate("update bill set status ='Paid' where meter_no='"+meter+"' And month='"+cmonth.getSelectedItem()+"' ");
         }
           catch(Exception e){
                e.printStackTrace();
           }
            setVisible(false);
            //Now we will call our Paytm class to do Payments
            new Paytm(meter);
       }
        else{
            setVisible(false);
         }
        }
           
        

         
       
           
       
    public static void main(String[]args){
        new PayBill("");
    }
    
}
