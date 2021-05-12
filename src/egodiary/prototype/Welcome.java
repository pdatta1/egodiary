
package egodiary.prototype;

import EgoDatabase.CreateAccount;
import EgoDatabase.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.filechooser.*;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;

public class Welcome extends User{
    
    private JPanel FNLane;
    private JPanel SNLane;
    private JPanel THLane;

    
    
    
    public static JFrame MNPanel;
    

    
    static Point WDrag;
    
    public Welcome(){
        initFrame();
        firstlane();
    }
    
    public void initFrame(){
       
    
        MNPanel = new JFrame();
        MNPanel.setLayout(new GridLayout(2,1));
        MNPanel.setBackground(Color.green);
        
        
        
        
      
      
      //panels
      //firstlane
      FNLane  = new JPanel();
      FNLane.setBackground(Color.white);
      FNLane.setLayout(new CardLayout());
        
      //second
      SNLane = new JPanel();
      SNLane.setBackground(Color.white);
      
      //third
      THLane = new JPanel();
      THLane.setBackground(Color.white);
      
        //add componenent
   
        MNPanel.add(FNLane);
        MNPanel.add(SNLane);
        MNPanel.add(THLane);
        MNPanel.setVisible(true);
    }
    
    User user;
    
    public void firstlane(){
 
        GridBagLayout layout = new GridBagLayout();
        FNLane.setLayout(layout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
      final JFileChooser selectpic = new JFileChooser();
      ImageIcon photo = new ImageIcon();
      
        final JLabel profilepic = new JLabel("Double Click to choose File");
        
        
        profilepic.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent me){
                
                if(me.getClickCount() == 2 & !me.isConsumed()){
                    me.isConsumed();
                    selectpic.setAcceptAllFileFilterUsed(false);
                    FileFilter filter = new FileNameExtensionFilter("JPEG file", new String [] {"jpg","jpeg"});
                    selectpic.setFileFilter(filter);
                    selectpic.addChoosableFileFilter(filter);
                    
                    int getvalue = selectpic.showOpenDialog(new HomeScreen());
                    if(getvalue == selectpic.APPROVE_OPTION){
                        File file = selectpic.getSelectedFile();
                        uploadpic(file);
                        System.out.println("Filed Uploaded : " + file.getName() + "to : " + CAFrame.userdata);
                      
                    }
                    
                   
                }
                    
            }
             public void mousePressed(MouseEvent e) {
            
             }
             

              public void mouseReleased(MouseEvent e) {
              
              }

      
              public void mouseEntered(MouseEvent e) {
              
              }

     
              public void mouseExited(MouseEvent e) {
      
              }
        });
        
      
        
        
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        FNLane.add(profilepic,gbc);
        MNPanel.setVisible(true);
        
        
    }

    
    public void secondLane(){
        
    }
    
    public void thirdLane(){
        
    }
    
}