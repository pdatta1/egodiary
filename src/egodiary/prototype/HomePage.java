package egodiary.prototype;

/** @author Patrick Atta-Baah
 * 
 */
import egodiary.prototype.Accessories.EgoDiaryAccesories;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;
import EgoDatabase.*;
public class HomePage extends User {
   
   MainFrame main = new MainFrame();
    HomeScreen hs = new HomeScreen();
     
    public HomePage(){
        
        setUserData(main.userdata);
       

    }
    
    
    private JPanel HMPanel;
    /* Containers initialization */
   public static JFrame HPFrame;
    private JPanel FSPanel;
    private JPanel SNPanel;
    
      //profile page
    ProfilePage Ppage;
    
    //maybe won't be used
    private JPanel TDPanel;
    
    //component initialization
    private JMenuBar HPBar;
    
    static Point HMDrag;
    
    //(BUttons)
   
    //Database
    
    
    
    //classes declaration
    EgoDiaryAccesories EDA = new EgoDiaryAccesories();
    
    public void initHomepage(){
         
        //HPFrame properties
        HPFrame = new JFrame();
        HPFrame.setResizable(false);
        HPFrame.setLayout(new CardLayout());
        HPFrame.setSize(1000,800);
        HPFrame.setUndecorated(true);
       
        
        //homepage bar
        HPBar = new JMenuBar();
        HPBar.setBackground(Color.white);
        
        //main layout
       HMPanel = new JPanel();
        HMPanel.setLayout(new GridLayout(3,1));
        
        //firstlane
        FSPanel = new JPanel();
        FSPanel.setLayout(new GridLayout(1,2));
        FSPanel.setBackground(Color.white);
        
        //secondlane
        SNPanel = new JPanel();
        SNPanel.setLayout(new GridLayout(0,2));
        SNPanel.setBackground(Color.white);
        
        //thirdlane
        TDPanel = new JPanel();
        TDPanel.setLayout(new FlowLayout());
        TDPanel.setBackground(Color.white);
        
        //add subpanels
        HMPanel.add(FSPanel);
        HMPanel.add(SNPanel);
        HMPanel.add(TDPanel);
        
         //profile page declare
       
        ProfilePage Ppage = new ProfilePage();

        HPFrame.setJMenuBar(HPBar);
        HPFrame.add(HMPanel);
        HPFrame.add(Ppage.BigPage);
       
         HMDrag = null;
      
      HPFrame.addMouseListener(new MouseAdapter(){
         
          public void mouseReleased(MouseEvent e){
              HMDrag = null;
          }
          public void mousePressed(MouseEvent e){
              HMDrag = e.getPoint();
          }
          public void mouseExited(MouseEvent e){
              
          }
          public void mouseEntered(MouseEvent e){
              
          }
          public void mouseClicked(MouseEvent e){
              
          }
          
          
      });
      
      HPFrame.addMouseMotionListener(new MouseAdapter(){
         public void mouseMoved(MouseEvent e){
             
         } 
         public void mouseDragged(MouseEvent e){
             Point mouseCord = e.getLocationOnScreen();
             HPFrame.setLocation(mouseCord.x - HMDrag.x, mouseCord.y - HMDrag.y);
         }
      });
        
       
        
        HPFrame.setVisible(true);
        
    }
    
    
    
    
    //HomeScreen MENUBAR
    public void BARS(){
        
        JButton ExitButton = new JButton();
        URL imgurl = this.getClass().getResource("/images/exit1.png");
        ImageIcon exicon = new ImageIcon(imgurl);
        JLabel exlabel = new JLabel(exicon);
        ExitButton.add(exlabel);
        ExitButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              
            
           } 
        });
        
        JButton miniBtn = new JButton("-");
   
         miniBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    HPFrame.setState(JFrame.ICONIFIED);
                }    
        });
        
         //profile page 
        
        JButton profile_btn = new JButton();
           profile_btn.setText(getUserStringAttribute("firstname"));
           profile_btn.addActionListener(new ActionListener(){
           
               public void actionPerformed(ActionEvent ae){
                   Ppage.BigPage.setVisible(true);
                   HMPanel.setVisible(false);
               }
           });

        
        
    
        
       
         
        URL imageUrl = this.getClass().getResource("/images/AppIcon1.png");
        ImageIcon App_Icon = new ImageIcon(imageUrl);
        JLabel show_icon = new JLabel(App_Icon,JLabel.CENTER);
       
       
        HPBar.add(ExitButton);
        HPBar.add(show_icon);
        HPBar.add(profile_btn);
        HPFrame.setVisible(true);
        
    }
    
    //CODE END POINT(MENUBAR)
    
    
    
    /* first lane code */
    //first lane components init
    private JButton open_txtdiary;
    private JButton open_vidiary;
    
    
    public void firstLane(){
        
        //sub panel
        JPanel SUB_FNPanel = new JPanel();
        SUB_FNPanel.setBackground(Color.white);
        
        
        //logo
        URL imgurl = this.getClass().getResource("/images/AppIcon3.png");
        ImageIcon exicon = new ImageIcon(imgurl);
        JLabel exlabel = new JLabel(exicon);
        
         //open_txtdiary
        open_txtdiary = new JButton("Text Diaries");
        
        //open_vidiary
        open_vidiary = new JButton("Video Diaries");
        
        //recentlabel
        Font labelFont = new Font("New Courier",Font.BOLD,24);
        JLabel recentlabel = new JLabel("Recent",JLabel.CENTER);
        recentlabel.setFont(labelFont);
        
        //layout
        GridBagLayout SPlayout = new GridBagLayout();
        SUB_FNPanel.setLayout(SPlayout);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.ipady =30;
        gbc.gridx = 0;
        gbc.gridy = 0;
        SUB_FNPanel.add(exlabel,gbc);
        
        gbc.ipady = 30;
        gbc.ipadx = 250;
        gbc.gridx = 0;
        gbc.gridy = 1;
        SUB_FNPanel.add(open_txtdiary,gbc);
        
        gbc.ipady = 30;
        gbc.ipadx = 250;
        gbc.gridx = 0;
        gbc.gridy = 2;
        SUB_FNPanel.add(open_vidiary,gbc);
        
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 3;
        SUB_FNPanel.add(recentlabel,gbc);
        
        
       
      //add  components
     FSPanel.add(SUB_FNPanel);
    }
    
    public void secondLane(){
        
        //subpanels
        
          //FRONT VERTICAL
          Font largefont = new Font("New Courier",Font.BOLD,26);
       
     

        
        /* SIDE LEFT (RECENT TEXT DIARIES) */
        //textpanel
        JPanel TXPanel = new JPanel();
        TXPanel.setLayout(new FlowLayout());
        TXPanel.setBackground(Color.blue);
        
        JLabel txlabel = new JLabel("Text");
        txlabel.setFont(largefont);
        
        //txtpanel comp.
        TXPanel.add(txlabel);
        
        //add listbox ------
        
        
        
        /* SIDE RIGHT(RECENT VIDEO DIARIES) */
         //videopanel
        JPanel vidPanel = new JPanel();
        vidPanel.setLayout(new FlowLayout());
        vidPanel.setBackground(Color.green);
        
        JLabel vidlabel = new JLabel("Video");
        vidlabel.setFont(largefont);
        
        
        
        //listbox ------
        
        
        //vidpanel comp.
        vidPanel.add(vidlabel);
        
        
        //add comp.
        SNPanel.add(TXPanel);
        SNPanel.add(vidPanel);
    }
    
   
    
}