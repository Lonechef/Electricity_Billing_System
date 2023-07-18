
package electricity.billing.system;

import javax.swing.*;

import java.awt.*;

import java.sql.*;

//TO give some commant to button we need to import event listener'

import java.awt.event.*;


public class Login  extends JFrame implements  ActionListener {
    JButton Login,Cancel,SignUp;
    
    //Now defining the user inputs for login in the global scope
    JTextField username,password;
    Choice logginin;
   
    Login(){
        //Now if we want to set the name of the frame this is done by using suoer
        //super is always written in the first line of the class
        super("Login Page");
        
      //To get the access of the full frame we need to use getContentPane()
      JLabel lblusername=new JLabel("Username");
      //Now we will use setBound to set location of our username
      //THis will only work when our setLayout is null
      lblusername.setBounds(300,20,100,20);
      add(lblusername);
      //Budefault  the layout is border so we need to change it
      setLayout(null);
      
      //Now we need to make the text field
      
      username= new JTextField();
      username.setBounds(400,20,150,20);
      add(username);
      
      //Setting up for Password
      JLabel lblpassword=new JLabel("Password");
      lblpassword.setBounds(300,60,100,20);
      add(lblpassword);
      setLayout(null);
      
      password= new JTextField();
      password.setBounds(400, 60, 150, 20);
      add(password);
      
      //Setting up for LoginInAs
      
      JLabel loggininas = new JLabel("Loggin in as");
      loggininas.setBounds(300,100,100,20);
      add(loggininas);
      
      //Setting up Dropdown box using Choice class
      
      logginin = new Choice();
      //Now we will add something in the dropdown menu
      logginin.add("Admin");
      logginin.add("Customer");
      logginin.setBounds(400, 100, 150, 20);
      add(logginin);
      
      // Setting Up Image on the button
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
      Image i2= i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      //Also we cannot pass Image so converted it ti ImageIcon
      
      
      ImageIcon i3= new ImageIcon(i2);
      
      //Setting up the Cancel Page
      
      ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
      Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      
       ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
      Image i8=i7.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
      
      ImageIcon i9= new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
      Image i10=i9.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
      ImageIcon i11=new ImageIcon(i10);
      //Now as we want to set the image on the frame so 
      JLabel image= new JLabel(i11);
      image.setBounds(0,0,250,250);
      add(image);
      //We can also set cancel icon 
      
      //Creating the Button
      //We can directly pass image as a icon on the button
      
      Login= new JButton("Login",i3);
      Login.setBounds(330,160,100,20);
      Login.addActionListener(this);
      add(Login);
      //Directly converting Image to ImageIcon
      Cancel= new JButton("Cancel",new ImageIcon(i6));
      Cancel.setBounds(450,160,100,20);
      Cancel.addActionListener(this);
      add(Cancel);
      
      SignUp= new JButton("Signup",new ImageIcon(i8));
      SignUp.setBounds(380,200,100,20);
      SignUp.addActionListener(this);
      
      add(SignUp);
      
      
     
      getContentPane().setBackground(Color.WHITE);
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        //Giving Source to the Action Event
        if(ae.getSource()==Login){
            String susername=username.getText();
            String spassword=password.getText();
            String suser=logginin.getSelectedItem();
            try{
                Conn c= new Conn();
                String query="select * from login where username='"+susername+"'and password='"+spassword+"' and user='"+suser+"'";
                
                //Now here we are trying to get the data from the table 
                //executeQuery is used from this basically this returns the Object of class ResultSet
                //This is there inside the sql package
                
                ResultSet rs=c.s.executeQuery(query);
                
                //if the query retirns null also then it will get stored in rs
                
                if(rs.next()){
                    
                   //Now here we will store our meter number in meter variable and pass it as parameter to Project class
                    String meter =rs.getString("meter_no");
                    //If data is there in rs then it will go to if statemnet 
                    //If data matches then close the fram and open Project Frame
                    setVisible(false);
                    new Project(suser,meter);
                    
                }
                else{
                    //This means it was uable to find the data so may be data entered by the user would be incorrect
                        JOptionPane.showMessageDialog(null,"Inavalid Login");
                        
                }
             
             
                
                
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            
        }
        else if(ae.getSource()==Cancel){
            //As we click on cancel button the frame should be closed
            setVisible(false);
            
        }
        else if(ae.getSource()==SignUp){
            //For this first close login Frame and open the signup
            setVisible(false);
            new Signup();
            
            
        }
       
        
        
        
        
    }
    public static void main(String [] args){
        new Login();
    }
    
}
