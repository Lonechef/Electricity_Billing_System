
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event .*;



public class MeterInfo extends JFrame implements ActionListener {
    Choice cmeterloc,cmetertype,cphasecode,cbilltype;
    JButton Submit;
    String meternumber;
    MeterInfo(String meternumber){
        this.meternumber=meternumber;
    
         setSize(700,500);
        setLocation(400,200);
        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,220,20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        
        JLabel mterno= new JLabel("Meter Number");
        mterno.setBounds(100,60,220,20);
        p.add(mterno);
        
        JLabel nmterno= new JLabel(meternumber);
        nmterno.setBounds(240,60,220,20);
        p.add(nmterno);
        
        
        
        JLabel meterloc= new JLabel("Meter Location");
        meterloc.setBounds(100,100,100,20);
        p.add(meterloc);
        
       cmeterloc = new Choice();
       cmeterloc.add("Outside");
       cmeterloc.add("Inside");
       cmeterloc.setBounds(280,100,150,20);
       p.add(cmeterloc);
       
       
       JLabel meterType= new JLabel("Meter Type");
        meterType.setBounds(100,140,100,20);
        p.add(meterType);
        
        cmetertype=new Choice();
        cmetertype.add("Electric");
        cmetertype.add("Solar");
        cmetertype.add("Smart");
        cmetertype.setBounds(280,140,150,20);
        p.add(cmetertype);
        
        JLabel phase= new JLabel("Phase Code");
        phase.setBounds(100,180,100,20);
        p.add(phase);
        
        cphasecode=new Choice();
        cphasecode.add("011");
        cphasecode.add("022");
        cphasecode.add("033");
        cphasecode.add("044");
        cphasecode.add("055");
        cphasecode.add("066");
        cphasecode.add("077");
        cphasecode.add("088");
        cphasecode.add("099");
        cphasecode.setBounds(280,180,150,20);
        p.add(cphasecode);
        
        JLabel Billtupe= new JLabel("BillT Type");
        Billtupe.setBounds(100,220,100,20);
        p.add(Billtupe);
        
        cbilltype= new Choice();
        cbilltype.add("Normal");
        cbilltype.add("Industrial");
        cbilltype.setBounds(280,220,150,20);
        p.add(cbilltype);
        
        JLabel bdays= new JLabel("Days");
        bdays.setBounds(100,260,100,20);
        
        p.add(bdays);
        
        JLabel numdays=new JLabel("30 Days");
        numdays.setForeground(Color.RED);
        numdays.setBounds(280,260,100,20);
        p.add(numdays);
        
        
         
        JLabel note= new JLabel("Note");
        note.setBounds(100,300,100,20);
        p.add(note);
        
        JLabel billnote= new JLabel("By default bill is calculated for 30 Days");
        billnote.setBounds(280,300,500,20);
        p.add(billnote);
        
        
        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(200,370,100,25);
        Submit.addActionListener(this);
        
        p.add(Submit);
        
         setLayout(new BorderLayout());
        
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
        
        
        
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Submit){
          String meter= meternumber;
          String location=cmeterloc.getSelectedItem();
          String type=cmetertype.getSelectedItem();
          String code=cphasecode.getSelectedItem();
          String billtype=cbilltype.getSelectedItem();
          String days ="30";
          
          
          
          
          String query1="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+billtype+"','"+days+"') ";
         
       
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
           
                
                //If querys executed successfully throw a Pop Up
                JOptionPane.showConfirmDialog(null, "Meter Information added SuccesFully");
                setVisible(false);
                
               
               
                
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
        }
            
        
        else{
            
            //If we press the cancel button then 
            setVisible(false);
        }
      
          
        
        
       
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
              
       
        
        
    
        
        
    }
    public static void main (String [] args){
        new MeterInfo("");
       
    }
    
    
}
