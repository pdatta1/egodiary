
package egodiary.prototype.ForgotCredential;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** 
 * 
 * @author patrickDeveloper5
 * This class shows display a JFrame that consists of Login in Credential and it links the user to either password recovery or username
 */
public  class FCredentialPage extends JFrame{
    
    
    /**
     * This constructor loads of the class
     */
    public FCredentialPage(){
        
    }
    
    

    
    //variables
    private JFrame CredentialFrame;
    private JMenuBar CFbar;
    private JPanel MNPanel;
    
    //forgot pass
    private JPanel ForgotPasswordPage;
    private JPanel ForgotUsernamePage;
   
    
    public void initFrame(){
     
       
        setSize(800,500);
        setResizable(false);
        setLayout(new CardLayout());
        try{
            UIManager.setLookAndFeel("Nimbus");
        }catch(Exception e){}
        setUndecorated(true);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent event){
               dispose();
           } 
        });
        
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        add(exit);
        
        
        setVisible(true);
    }
    
    
    
    
    
}