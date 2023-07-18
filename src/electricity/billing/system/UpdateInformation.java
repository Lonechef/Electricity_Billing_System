
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class UpdateInformation extends JFrame implements ActionListener {
    JTextField tfaddress,tfcity,tfstate,tfemail,tfphone;
    JButton update,cancel;
    JLabel name;
    String meter;
    UpdateInformation(String meter){
        this.meter=meter;
        
        setBounds(300,150,1050,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("Update Customer Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(30,80,100,20);
        add(lblname);
        
        name= new JLabel();
        name.setBounds(250,80,100,20);
        add(name);
        
        JLabel lblmeterNumber= new JLabel("Meter Number");
        lblmeterNumber.setBounds(30,120,100,20);
        add(lblmeterNumber);
        
        JLabel meterNumber= new JLabel();
        meterNumber.setBounds(150,120,100,20);
        add(meterNumber);
        
        
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(30,160,100,20);
        add(lbladdress);
        
        tfaddress= new JTextField();
        tfaddress.setBounds(230,160,100,20);
        add(tfaddress);
        
        JLabel city = new JLabel("City");
        city.setBounds(30,200,100,20);
        add(city);
        
        tfcity= new JTextField();
        tfcity.setBounds(230,200,100,20);
        add(tfcity);
        
        JLabel lblstate= new JLabel("State");
        lblstate.setBounds(30,240,100,20);
        add(lblstate);
        
        tfstate= new JTextField();
        tfstate.setBounds(230,240,100,20);
        add(tfstate);
        
        
        JLabel lblEmail= new JLabel("Email");
        lblEmail.setBounds(30,280,100,20);
        add(lblEmail);
        
        tfemail= new JTextField();
        tfemail.setBounds(230,280,100,20);
        add(tfemail);
        
        JLabel lblPhone= new JLabel("Phone");
        lblPhone.setBounds(30,320,100,20);
        add(lblPhone);
        
        tfphone= new JTextField();
        tfphone.setBounds(230,320,100,20);
        add(tfphone);
        
        try{
            Conn c = new Conn();
            //Now from customer class we will add all the information 
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                meterNumber.setText(rs.getString("meter_no"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
             }
  }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        update= new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(100,370,80,20);
        add(update);
        update.addActionListener(this);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(250,370,80,20);
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 =i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,400,300);
        add(image);
        
        setVisible(true);
        
    }
        
        public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource()==update){
                //So now if you press on update then information like meter number should come
                
                String adddress=tfaddress.getText();
                String city=tfcity.getText();
                String state=tfstate.getText();
                String email=tfemail.getText();
                String phone=tfphone.getText();
                
                
                //Now we will need to Update all this information in the daytabase
                
                try{
                    Conn c= new Conn();
                    c.s.executeUpdate("update customer set address='"+adddress+"',city='"+city+"',state='"+state+"' ,email='"+email+"',phone='"+phone+"' where meter_no='"+meter+"'");
                    JOptionPane.showMessageDialog(null,"User Information Updated Successfully");
                    setVisible(false);
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                
                
            }
            else{
                setVisible(false);
            }
            
        }
         
        
        
        
        
    
    public static void main(String [] args){
        new UpdateInformation("");
        
    }
    
}
