
package electricity.billing.system;
import javax.swing.*;
//There is a concept in java like when we do swing.* then all the packages in swind will be called but 
//The subpackages will not be callled so
import javax.swing.border.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;




public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    Choice accType;
     JTextField meter;
     JTextField username;
     JTextField name;
     JTextField password ;
   
    
    Signup(){
        //Now we will use new method to create the frame which is using
        setBounds(450,150,700,400);
        //Setting the color of the Panel
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
     //Basically there is a whole frame now here we need to define a Panel in this frame 
     
     JPanel panel = new JPanel();
     //So now panel is the object of the class Jpanel
     panel.setBounds(30,30,650,300);
     //Setting up the Border
     //Arguments of lineBorder
     //1.Setting up the color normally we can do COLOR.COLORNAME
     //Or else we can do new Color() for RGB
     //2. We give shae in our care it is 2
     //3. Now line border hasbeen done now we will work on title border
     panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(170,216,230)));
     panel.setBackground(Color.WHITE);
     panel.setLayout(null);
     //Now setting up the font color for that we use Foreground
     panel.setForeground(new Color(34,139,34));
     add(panel);
     
     //Setting Up instructions in the Panel
     
     JLabel heading = new JLabel("Create Account");
     heading.setBounds(100,50,140,20);
     heading.setForeground(Color.GRAY);
     //Editing the font
     //Tahoma:Font style Font.Bold: font style,14: Font Size
     heading.setFont(new Font("Tahoma",Font.BOLD,14));
     //We directly cannot do it we need to call through panel
     panel.add(heading);
     
     accType= new Choice();
     accType.add("Admin");
     accType.add("Customer");
     accType.setBounds(260,50,140,20);
     //If you donot do it panel.add instead if you directly do add so it wont be visible on panel as it will be on the frame
     
     panel.add(accType);
     
     JLabel lblmeter = new JLabel("Meter Number");
     lblmeter.setBounds(100,90,140,20);
     lblmeter.setForeground(Color.GRAY);
     //Editing the font
     //Tahoma:Font style Font.Bold: font style,14: Font Size
     lblmeter.setFont(new Font("Tahoma",Font.BOLD,14));
     lblmeter.setVisible(false);
     //We directly cannot do it we need to call through panel
     panel.add(lblmeter);
     
     //Creating the TextFiled
     
     meter= new JTextField();
     meter.setBounds(260,90,140,20);
     meter.setVisible(false);
     panel.add(meter);
     
     //Now as soon as user leaves the meter text field 
     //We have to display the name
     //For this we will be Using function called ad addFocusListener()
     meter.addFocusListener(new FocusListener(){
         @Override
         public void focusGained(FocusEvent fe){}
         @Override
         public void focusLost(FocusEvent fe){
             
             //Now we need to API call
             try{
                 Conn c = new Conn();
                 //So now from login table we have to get meter_no
                 //And if it matches the meter_no which is enetered by the customer then 
                 //we have to display the name stored into it
                 ResultSet rs = c.s.executeQuery("select * from  login where meter_no='"+meter.getText()+"'");
                 while(rs.next()){
                     //So now we have to set our name as given with the meter number
                     name.setText(rs.getString("name"));
                     
                     
                         
             }
             
             }
             catch(Exception e){
                     e.printStackTrace();
             }
         }

        
    });
     
     //Setting Up the Username
     JLabel lblusername = new JLabel("UserName");
     lblusername.setBounds(100,130,140,20);
     lblusername.setForeground(Color.GRAY);
     //Editing the font
     //Tahoma:Font style Font.Bold: font style,14: Font Size
     lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
     //We directly cannot do it we need to call through panel
     panel.add(lblusername);
           
     
    //TextField for UserName
    username = new JTextField();
    username.setBounds(260,130,150,20);
    panel.add(username);
    
    
    
    
    //Setting Up the field for Name
    
     JLabel lblname = new JLabel("Name");
     lblname.setBounds(100,170,140,20);
     lblname.setForeground(Color.GRAY);
     //Editing the font
     //Tahoma:Font style Font.Bold: font style,14: Font Size
     lblname.setFont(new Font("Tahoma",Font.BOLD,14));
     //We directly cannot do it we need to call through panel
     panel.add(lblname);
           
     
    //TextField for UserName
    name = new JTextField();
    name.setBounds(260,170,150,20);
    panel.add(name);
    
    //Setting Up the Password
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(100,210,140,20);
    lblpassword.setForeground(Color.GRAY);
    lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
    panel.add(lblpassword);
    
    password = new JTextField();
    password.setBounds(260,210,140,20);
    panel.add(password);
    
    //Now here if customer is selected then we need to display meter number
    accType.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ae){
            String user=accType.getSelectedItem();
            if(user.equals("Customer")){
                //If it is Customer the meter should be visible
                lblmeter.setVisible(true);
                meter.setVisible(true);
                //So now in case of customer we are not allowing to edit
                name.setEditable(false);
                
                
            }
            else{
                  lblmeter.setVisible(false);
                meter.setVisible(false);
                //In case of admin we are allowing hin=m to enter his name
                 name.setEditable(true);
                
            }
        }
    });
    
    
    create = new JButton("Create");
    
    create.setBackground(Color.BLACK);
    create.setForeground(Color.WHITE);
    create.setBounds(140,260,120,25);
    panel.add(create);
    create.addActionListener(this);
    
    back = new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(300,260,120,25);
    panel.add(back);
    back.addActionListener(this);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
    Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(415,30,250,250);
    panel.add(image);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
           //Now here as we know that textfield and choice will return some string value so we need to store it
           //So for acctype we have to select from admin or customer so now here we need to take those values so we will use function called getSelectedItem()
           String atype=accType.getSelectedItem();
           //Now here username is the textfield and not dropdown menu
           
           String susername=username.getText();
           String sname=name.getText();
           String spassword=password.getText();
           String smeter=meter.getText();
           
            //Fetching Up the values
        try{
            //This is the class we created for connection
            Conn c= new Conn();
          //Making the query and inserting the values in the table
          String query=null;
          //So if tyhe login is for admin then we need all the values
          if(accType.equals("Admin")){
              query ="insert into login values('"+smeter+"','"+susername+"','"+sname+"','"+spassword+"','"+atype+"')";
          }
          //Else if customer
          else{
              //Here we need to update the existing table where we jut need to add username and password
              query="update login set username='"+susername+"',password='"+spassword+"',user='"+atype+"'where meter_no='"+smeter+"'";
          }
          
          //c:connection s:update
          c.s.executeUpdate(query);
          //Now if successfully executed then we have to show the Pop-uP
          //In first argument it takes some paramenter which we set as null

          JOptionPane.showMessageDialog(null,"Account Created Successfully");
          //So if account is created successfully then we will close the frame and open the login frame
          setVisible(false);
          new Login();
            
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
           
            
        }
        else if(ae.getSource()==back){
            //Close the frame and then open the Login page
            setVisible(false);
            new Login();
            
        }
       
        
        
        
        
    }
    
    
    
    
    
    
     
     
        
        
        
    
    public static void main(String[] args){
        new Signup();
    }
    
}
