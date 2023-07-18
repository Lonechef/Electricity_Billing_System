package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class ViewInformation extends JFrame{
    JButton Cancel;
    String meter;
    ViewInformation(String meter){
        this.meter=meter;
        
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading= new JLabel("View Customer Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(70,80,100,20);
        add(lblname);
        
        JLabel name= new JLabel();
        name.setBounds(250,80,100,20);
        add(name);
        
        JLabel lblmeterNumber= new JLabel("Meter Number");
        lblmeterNumber.setBounds(70,140,100,20);
        add(lblmeterNumber);
        
        JLabel meterNumber= new JLabel();
        meterNumber.setBounds(250,140,100,20);
        add(meterNumber);
        
        
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(70,200,100,20);
        add(lbladdress);
        
        JLabel address= new JLabel();
        address.setBounds(250,200,100,20);
        add(address);
        
        JLabel lblstate= new JLabel("State");
        lblstate.setBounds(350,80,100,20);
        add(lblstate);
        
        JLabel state= new JLabel();
        state.setBounds(500,80,100,20);
        add(state);
        
        JLabel lblcity= new JLabel("City");
        lblcity.setBounds(70,260,100,20);
        add(lblcity);
        
        JLabel city= new JLabel();
        city.setBounds(250,260,100,20);
        add(city);
        
        JLabel lblEmail= new JLabel("Email");
        lblEmail.setBounds(350,140,100,20);
        add(lblEmail);
        
        JLabel email= new JLabel();
        email.setBounds(500,140,100,20);
        add(email);
        
        JLabel lblPhone= new JLabel("Phone");
        lblPhone.setBounds(350,200,100,20);
        add(lblPhone);
        
        JLabel phone= new JLabel();
        phone.setBounds(500,200,100,20);
        add(phone);
        try{
            Conn c = new Conn();
            //Now from customer class we will add all the information 
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                meterNumber.setText(rs.getString("meter_no"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                
                
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(350,340,100,20);
        add(Cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);

        
        
        
        
        
        
        
               
               
        setVisible(true);
    }
    public static void main(String []args){
        new ViewInformation("");
    }
        
    
}
