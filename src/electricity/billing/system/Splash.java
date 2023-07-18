
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
//As multiple inheritance is not allowed in Java so we caanot do public class Splash extends JFrame,Thread
//Instead we need to use the second conpet i.e. implements 
//But doing this will throw an error as Runnable Interface has absract method called run()

public class Splash extends JFrame implements Runnable {
    //Now we cannot call run method directly which is inside Runnable
    //So we need to compulsory make the object of thread class
   // By passing this as an argument to the Thread constructor, you are essentially creating a new thread that will execute the run method of the current object. 
    //The run method is defined in the Runnable interface and represents the entry point for the new thread's execution
    Thread t = new Thread(this);
    
    //Step 2 Creating the Splash Constructor
    
    Splash(){
       // Step 4: Adding the image
        //making Object of the class ImageICon
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        
        //Now we will use Image class which is the part of awt
        
        Image i2=  i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        
        //Now here there is also a problem we cannot directly pass object of class Image in Jlabel
        
        ImageIcon i3=new ImageIcon(i2);
        
        //Now we will use function add to add iamge to the frame but we cannot directly do it
        
        //So we wil take the help of the JLabel class
        
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        
       
        int x=1;
        for(int i=2;i<600;i+=4,x+=1){
            setSize(i+x,i);
            //Doing this -i it will be visible in such a way that screen is expanding in all four direction
            
            setLocation(700-((i+x/2)),400-(i/2));
            try{
                //So this takes input in mili seconds
                Thread.sleep(5);
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }
        //Now calling the run method
        //To call the run method we have to use start method internally start method call run
        
        t.start();
        setVisible(true);
    }
         public void run(){
            try{
                //Now we want to stop our execution to seven seconds so now we will
                //do 7000 miliseconds
                Thread.sleep(7000);
                //Now after this we want to close our frame so
                setVisible(false);
                //Now after seconds we will dispaly login page so calling the login function
                new Login();
            } catch(Exception e){
                e.printStackTrace();
        }
         }
        
         
        
        
        
        //Step 3: Calling the function which is present inside the JFrame 
//        
//        setSize(730,550);
//        
//        //Setting up the location
//        
//        //setLocation(x dirn,y dirn)
//         
//        setLocation(500,200);
//        
//        //By defaukt the visibility is disabled so we need to on it
//        
//        
//        setVisible(true);
        
    
    
    //As soon as we do this the frame will be displayed on the top left
    
    
    public static void main(String[] args){
        
        //Now first of all we will make the object of our class
        
        //Splash s = new Splash();
        
        //We will create anonymous Object Directly as we are not going to use s anywhenre
        
        new Splash();
        
    }
    
}
