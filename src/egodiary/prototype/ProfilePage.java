package egodiary.prototype;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import egodiary.prototype.Accessories.EgoDiaryAccesories;
import egodiary.prototype.Accessories.EgoMainComponents;
import java.net.*;
import EgoDatabase.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import java.io.File;
import java.sql.SQLException;
import javax.swing.filechooser.*;

public class ProfilePage extends User  implements EgoMainComponents{
    //components

    private ImageIcon profilepic;
    private JLabel usernamelabel;
    private JLabel firstnamelabel;
    private JLabel lastnamelabel;
    private JLabel genderlabel;
    private JLabel  emailaddresslabel;
    private JLabel passwordlabel;
    private JButton EditInfo;
    
    //Panels
    public static JPanel BigPage;
    private JPanel FNLane;
    private JPanel SNLane;
    private JPanel THLane;
    
    private EditPage epage;
  
    
    Connection D_Connection;
    PreparedStatement pdstatement;
    ResultSet resultset;
    String IStatement;
    
    
  
    MainFrame main = new MainFrame();
    
    public ProfilePage(){
        setUserData(main.userdata);
        initFrame();
        firstLane();
        secondLane();
        thirdLane();
    }
    public void initFrame(){
        
        BigPage = new JPanel();
        BigPage.setLayout(new GridLayout(3,1));
        
        FNLane= new  JPanel();
        FNLane.setLayout(new FlowLayout());
        FNLane.setBackground(Color.white);
        
        SNLane = new JPanel();
        SNLane.setLayout(new FlowLayout());
        SNLane.setBackground(Color.white);
        
        THLane = new JPanel();
        THLane.setLayout(new FlowLayout());
        THLane.setBackground(Color.white);
        
        
        
        BigPage.add(FNLane);
        BigPage.add(SNLane);
        BigPage.add(THLane);
        BigPage.setVisible(false);
        
        
    }
    HomePage home;
 
    public void firstLane() {
        
        GridBagLayout layout = new GridBagLayout();
        FNLane.setLayout(layout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
       
        final JFileChooser dialog = new JFileChooser();
        
     
          
         profilepic = new ImageIcon(getpic("profilepic").getScaledInstance(400, 400,Image.SCALE_DEFAULT));
           final JLabel elabel = new JLabel(profilepic); 
         
         
        elabel.addMouseListener(new MouseListener(){
        
            public void mouseClicked(MouseEvent me){
                if(me.getClickCount() == 2 && !me.isConsumed()){
                     me.isConsumed();
                  
                     dialog.setAcceptAllFileFilterUsed(false);
                   FileFilter filter = new FileNameExtensionFilter("JPEG file", new String[] {"jpg", "jpeg"});
                       dialog.setFileFilter(filter);
                       dialog.addChoosableFileFilter(filter);
                     
                     int getvalue = dialog.showOpenDialog(new HomePage().HPFrame);
                     if(getvalue == dialog.APPROVE_OPTION){
                         File file = dialog.getSelectedFile();
                           uploadpic(file);
                            System.out.println("Filed Uploaded : " + file.getName());
                           JOptionPane.showMessageDialog(null,"EgoDiary need reset to display your photo");
                           
                           
                          

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
   
        
        
        usernamelabel = new JLabel(getUserStringAttribute("username"));
        usernamelabel.setFont(new Font("New Roman",Font.BOLD, 24));
     
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        FNLane.add(elabel,gbc);
        
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        FNLane.add(usernamelabel, gbc);
     
        BigPage.setVisible(true);
    }
    
     
    
    
    public void secondLane(){
        
        JLabel fdisplay = new JLabel("Firstname : ");
        JLabel ldisplay = new JLabel("Lastname : ");
        JLabel edisplay = new JLabel("EmailAddress : ");
        
        firstnamelabel = new JLabel( getUserStringAttribute("firstname"));
        fdisplay.setFont(new Font("New Roman",Font.BOLD, 24));
        firstnamelabel.setFont(new Font("Cochin",Font.BOLD, 24));
        
        lastnamelabel = new JLabel(getUserStringAttribute("lastname"));
        ldisplay.setFont(new Font("New Roman",Font.BOLD, 24));
        lastnamelabel.setFont(new Font("Cochin",Font.BOLD, 24));
        
        emailaddresslabel = new JLabel(getUserStringAttribute("emailaddress"));
        edisplay.setFont(new Font("New Roman",Font.BOLD, 24));
        emailaddresslabel.setFont(new Font("Cochin",Font.BOLD, 24));
     
        GridBagLayout layout = new GridBagLayout();
        SNLane.setLayout(layout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 0;
        SNLane.add(fdisplay, gbc);
        
        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 0;
        SNLane.add(firstnamelabel, gbc);
        
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        SNLane.add(ldisplay, gbc);
        
        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 1;
        SNLane.add(lastnamelabel, gbc);
        
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 2;
        SNLane.add(edisplay, gbc);
        
        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 2;
        SNLane.add(emailaddresslabel, gbc);
        
    }
    
    public void thirdLane(){
        
        JLabel pdisplay = new JLabel("Password : ");
        passwordlabel = new JLabel("********");
        pdisplay.setFont(new Font("New Roman",Font.BOLD, 24));
        passwordlabel.setFont(new Font("Cochin",Font.BOLD, 24));
        
        JButton goback = new JButton("Back");
        goback.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent e){
                BigPage.setVisible(false);
            }
            
        });
        
        EditInfo = new JButton("Edit Info");
        EditInfo.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent ae){
                FNLane.setVisible(false);
                SNLane.setVisible(false);
                THLane.setVisible(false);
                 
                epage = new EditPage();
                BigPage.setLayout(new CardLayout());
                BigPage.add(epage);
                
                
            }
        
        });
        
        GridBagLayout layout = new GridBagLayout();
        THLane.setLayout(layout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 0;
        THLane.add(pdisplay, gbc);
        
        gbc.ipady = 10;
        gbc.gridx = 1;
        gbc.gridy = 0;
        THLane.add(passwordlabel, gbc);
        
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 1;
        THLane.add(goback, gbc);
        
        gbc.ipady = 30;
        gbc.gridx = 1;
        gbc.gridy = 1;
        THLane.add(EditInfo, gbc);
        
        
    }
}