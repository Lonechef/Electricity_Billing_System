
package electricity.billing.system;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;



//Now we are using ActionListener to provide actions to menu items

public class Project extends JFrame implements ActionListener {
    //Adding argumnet to Project class to get and idea of account type
    String atype,meter;
    //User already has his meter number from login class 
    
    Project(String atype,String meter){
        this.atype=atype;
        this.meter=meter;
        //Now here we want that our screen should open in the full screen\
        //
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        //We have to scale this image according to our Laptop Screen
        Image i2 =i1.getImage().getScaledInstance(2000, 1500, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
       
        
        
        //Now we will Create a Menubar which is there in the Header of our newly inserted image
        
        JMenuBar mb= new JMenuBar();
        setJMenuBar(mb);
        
        //Now we will palce the menu 
        JMenu Master = new JMenu ("Master");
        Master.setForeground(Color.BLUE);
        
        JMenuItem newcustomer= new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,12));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1= icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        //Now we have to set the image 
        //To do this there is a function called as setIcon
        //setIcon do not directly take Image so converting it to ImageIcon
        newcustomer.setIcon(new ImageIcon(image1));
        //Adding action listener
        newcustomer.addActionListener(this);
        //Setting the memonic
        newcustomer.setMnemonic('D');
        
        //Now we will set the shortcut\
        //KeyEvent and ActionEvent lies in the event package
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        //Now menu Items are inside the menu so we need to add it inside the menu
        Master.add(newcustomer);
        
        
        JMenuItem customerdetails= new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.addActionListener(this);
        customerdetails.setMnemonic('M');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        
        
        Master.add(customerdetails);
        
        
        JMenuItem calculatebill= new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.addActionListener(this);
        calculatebill.setMnemonic('B');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        
        Master.add(calculatebill);
        
        JMenuItem depositdetails= new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        depositdetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(image3));
        depositdetails.addActionListener(this);
        depositdetails.setMnemonic('N');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        Master.add(depositdetails);
        
        
        
        ///SECOND MENU ITEM 
        JMenu info = new JMenu ("Information");
        info.setForeground(Color.RED);
        
        
        JMenuItem updateinfo= new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updateinfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(image3));
        updateinfo.addActionListener(this);

        updateinfo.setMnemonic('U');
        updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        
        info.add(updateinfo);
        
        
        JMenuItem viewinfo= new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(image6));
        viewinfo.addActionListener(this);
        viewinfo.setMnemonic('V');
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        
        info.add(viewinfo);
        
        JMenu user = new JMenu("User");
        user.setBackground(Color.WHITE);
        user.setForeground(Color.BLUE);
     
        
        JMenuItem paybill= new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image7));
        paybill.addActionListener(this);
        paybill.setMnemonic('R');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        
        user.add(paybill);
        
        
        JMenuItem billdetails= new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,12));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image8));
        billdetails.addActionListener(this);
        billdetails.setMnemonic('A');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        
        user.add(billdetails);
        
         JMenu report = new JMenu("Report");
        report.setBackground(Color.WHITE);
        report.setForeground(Color.RED);
        
        
        JMenuItem generatebill= new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,12));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        generatebill.addActionListener(this);
        report.add(generatebill);
        
        JMenu utility = new JMenu("Utility");
        utility.setBackground(Color.WHITE);
        utility.setForeground(Color.BLUE);
        
        
        JMenuItem notepad= new JMenuItem("Note Pad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        notepad.addActionListener(this);
        
        utility.add(notepad);
        
        JMenuItem Calculator= new JMenuItem("Calculator");
        Calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        Calculator.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Calculator.setIcon(new ImageIcon(image11));
        Calculator.setMnemonic('C');
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        Calculator.addActionListener(this);
        
        
        utility.add(Calculator);
        
         
       JMenu Mexit = new JMenu("Exit");
        Mexit.setBackground(Color.WHITE);
        Mexit.setForeground(Color.RED);
        
        
        JMenuItem exit= new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image12));
        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        
       Mexit.add(exit);
       if(atype.equals("Admin")){
           //If it is admin then add maseter an
           mb.add(Master);
       }
       else if(atype.equals("Customer")){
           //If acc type is Customer then just add info,user,report
       mb.add(info);
       mb.add(user);
       mb.add(report); 
       
   }
  //This two should be includeded in any of the case
    mb.add(Mexit);
    mb.add(utility);
    setLayout(new FlowLayout());
    setVisible(true);
   
    }
    
    //So after Constructor we will add the abstract method
    
    public void actionPerformed(ActionEvent ae){
        //Now this can be done in two ways one is using getSource option
        //Method 2
        //Basically getAction Command() takes the value what is being clicked and gets stored in msg
        
        String msg=ae.getActionCommand();
        //Now msg.equals("") here in double quote we have to mention same as what is being displayed on the scree
        
    if(msg.equals("New Customer")){
    //So now just in this we have to open our class newCutomer
    new NewCustomer();        
        
    }
    else if(msg.equals("Customer Details")){
        new CustomerDetails();
            
    }
    else if(msg.equals("Calculate Bill")){
    new CalculateBill();
    }
        
    
    else if(msg.equals("Deposit Details")){
        new DepositDetails();
            
    }
    else if(msg.equals("View Information")){
        //Now we will pass meter number as parameter to the class ViewInfromation
        new ViewInformation(meter);
        
    }
    else if(msg.equals("Update Information")){
        new UpdateInformation(meter);
    }
    else if(msg.equals("Bill Details")){
        new BillDetails(meter);
    }
    else if(msg.equals("Note Pad")){
        //To open the notepad of the system
        try{
            //In Java we directly call the executable file for notepad it is notepad.exe
            Runtime.getRuntime().exec("notepad.exe");
        }
            
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
     else if(msg.equals("Calculator")){
        //To open the notepad of the system
        try{
            //In Java we directly have the executable file fro calculator we have calc.exe
            Runtime.getRuntime().exec("calc.exe");
        }
            
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
     else if(msg.equals("Exit")){
         setVisible(false);
         new Login();
     }
     else if(msg.equals("Pay Bill")){
         new PayBill(meter);
    
    }
     else if(msg.equals("Generate Bill")){
         new GenerateBill(meter);
     } 
 }
    
       
    public static void main(String[] args){
        new Project("","");
        
              
        
    }
    
}
