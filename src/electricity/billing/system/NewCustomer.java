
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



public class NewCustomer extends JFrame implements ActionListener{
    //Declaring required textfields globally
    JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfPhone;
    JLabel meterno;
    //Adding few buttons
    JButton Next,Cancel;
    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);
        
        ///Now we will make a Panel
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180,10,220,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        
        tfname= new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);
        
        //Now we will create the meter number
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100,120,100,20);
        p.add(lblmeter);
        
        //Here the meter number should not be edited by the customer so we should use JLabel only rather then using any textField
        
        meterno = new JLabel("");
        meterno.setBounds(240,120,100,20);
        p.add(meterno);
        
        //Rnadom class is present in util package
        
        Random ran = new Random();
        //We require a six digit number so we do modulus to it 
        long number=ran.nextLong()%1000000;
        //Now at palce of label we will set out text
        //setText takes string as the input so here we but number is in integer so we do inverted comma +integer 
        meterno.setText(""+Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        
        tfaddress= new JTextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity);
        
        tfcity= new JTextField();
        tfcity.setBounds(240,240,200,20);
        p.add(tfcity);
        
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100,200,100,20);
        p.add(lblstate);
        
        tfstate= new JTextField();
        tfstate.setBounds(240,200,200,20);
        p.add(tfstate);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        
        tfemail= new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        
        tfPhone= new JTextField();
        tfPhone.setBounds(240,320,200,20);
        p.add(tfPhone);
        
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
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
          String name= tfname.getText();
          String smeter=meterno.getText();
          String address=tfaddress.getText();
          String state=tfstate.getText();
          String city=tfcity.getText();
          String email=tfemail.getText();
          String phone=tfPhone.getText();
          
          //Now here we have to make two query's
          
          String query1="insert into customer values('"+name+"','"+smeter+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"') ";
          //Now we will write query to insert values in the login table
          //But here we have only name and smeter to be  entered while all other values we donot have so we will keep it blank
          //The order should be same as the columns of the login table
          String query2="insert into login values('"+smeter+"','','"+name+"','','')";
       
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                //If querys executed successfully throw a Pop Up
                JOptionPane.showConfirmDialog(null, "Customers Details Entered SuccesFully");
                setVisible(false);
                
                //Getting to new Fram i.e of Meter Info
                 new MeterInfo(smeter);
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
            
        
        else{
            
            //If we press the cancel button then 
            setVisible(false);
        }
     }
   
    
    
    public static void main(String [] args){
        new NewCustomer();
    }
    
    
}