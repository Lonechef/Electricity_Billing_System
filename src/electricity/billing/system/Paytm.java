
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Paytm  extends JFrame implements ActionListener{
    String meter;
    JButton back;
    Paytm(String meter){
        this.meter=meter;
        
        //Now we will use Text Area Editor Pane gives the text area
        JEditorPane j = new JEditorPane();
        //By default Editor pane is ediatbale so we need to close it
        j.setEditable(false);
      //Now we will import the external link 
      try{
          //Importing the PAYTM LINK
          j.setPage("https://paytm.com/online-payments");
          
          
          
      }
      catch(Exception e){
          //Now we will connect html with java using this
          j.setContentType("text/html");
          j.setText("<html>Could not load</html>");
          
          
      }
      //Adding Scroll BAR
      JScrollPane pane =new JScrollPane(j);
      add(pane);
      
      back = new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setBounds(640,20,80,30);
      back.addActionListener(this);
      
      j.add(back);
      
      setSize(800,600);
      setLocation(400,150);
      setVisible(true);
}
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==back){
       
       setVisible(false);
       new PayBill(meter);
       }
       
   }

    
    public static void main (String [] args){
        new Paytm("");
    }
    
}
