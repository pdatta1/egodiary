package egodiary.prototype;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

import egodiary.prototype.Accessories.*;

public class HomeScreen extends JFrame implements EgoMainComponents {
 
    public HomeScreen(){
        
       
        
        
       
    }
    
   //main Frame
   
    
    
    //dragging variables

    
    
    static Point HMDrag;
    
    //variables
  
    private JPanel HMPanel;
    private JMenuBar FCBars;
    private JButton EXbtn;
    private JButton MNbtn;
    
    //HMpanel subpanels
    private JPanel App_title;
    private JPanel CAPanel;
    private JPanel Footer;
    
    
    //class init
    CAFrame cframe;
    MainFrame mframe;
    
    public void initFrame(){
    
        //HMFrame code
     
       setSize(1000,870);
       setResizable(false);
       setUndecorated(true);
          try{
              UIManager.setLookAndFeel("Nimbus");
          }catch(Exception e){}
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       
        
         
        
        
        
        /* Dragging HMFrame */
       //Dragging HMFrame
        
      HMDrag = null;
      
      addMouseListener(new MouseAdapter(){
         
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
      
      addMouseMotionListener(new MouseAdapter(){
         public void mouseMoved(MouseEvent e){
             
         } 
         public void mouseDragged(MouseEvent e){
             Point mouseCord = e.getLocationOnScreen();
             setLocation(mouseCord.x - HMDrag.x, mouseCord.y - HMDrag.y);
         }
      });
   


        /* Dragging ends here */
        
        //menubar
        
        FCBars = new JMenuBar();
        FCBars.setBackground(Color.white);
       
        
        EXbtn = new JButton();
        EXbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        URL imgurl = this.getClass().getResource("/images/exit1.png");
        ImageIcon exicon = new ImageIcon(imgurl);
        JLabel exlabel = new JLabel(exicon);
        EXbtn.add(exlabel);
        
        FCBars.add(EXbtn);
        
        //main layout
        HMPanel = new JPanel();
        HMPanel.setLayout(new GridLayout(2,1));
        
        //sub
        App_title = new JPanel();
        App_title.setLayout(new FlowLayout());
        App_title.setBackground(Color.white);
 
     
        
        //sub
        CAPanel = new JPanel();
        CAPanel.setLayout(new FlowLayout());
        CAPanel.setBackground(Color.white);
        
        Footer = new JPanel();
        Footer.setLayout(new FlowLayout());
        Footer.setBackground(Color.white);
        
        
        
        //init sub panels
        HMPanel.add(App_title);
        HMPanel.add(CAPanel);
        HMPanel.setVisible(false);
        

        
        
        cframe = new CAFrame();
        cframe.setCAPanel();
        cframe.setVisible(false);
        
        mframe = new MainFrame();
        mframe.setVisible(false);
         
        setJMenuBar(FCBars);
        add(HMPanel);
        add(cframe);
        add(mframe);
        setVisible(true);
        
    }
    
  
    
   
   
    
    private JButton LNCreateAccount;
    private JButton LNLogin;
    
        
   
        
    public void firstLane(){
        URL imageUrl = this.getClass().getResource("/images/AppIcon6.png");
        ImageIcon App_Icon = new ImageIcon(imageUrl);
        JLabel show_icon = new JLabel(App_Icon,JLabel.CENTER);
        App_title.add(show_icon);
        
    }
    
    public void secondLane(){
       
        JPanel pane =  new JPanel();
        pane.setBackground(Color.white);
        
        GridBagLayout gbl = new GridBagLayout();
        pane.setLayout(gbl);
        
        // link to create account frame
       LNCreateAccount = new JButton("Create Account");
       LNCreateAccount.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                  cframe.setVisible(true);
                  HMPanel.setVisible(false);
                   
                }
       });
       
       
       //link to login frame (MainFrame)
       LNLogin = new JButton("Login");
       LNLogin.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               mframe.setVisible(true);
               HMPanel.setVisible(false);
           }
       });
       
       JButton SWGoogle = new JButton("Sign in with Google");
       SWGoogle.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
           }
       });
       
      
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.fill = GridBagConstraints.VERTICAL;
       
       gbc.ipady = 30;
       gbc.ipadx = 60;
       gbc.gridx = 0;
       gbc.gridy = 0;
       pane.add(LNCreateAccount,gbc);
       
       gbc.ipady = 30;
       gbc.ipadx = 60;
       gbc.gridx = 1;
       gbc.gridy = 0;
       pane.add(LNLogin,gbc);
       
       gbc.fill = GridBagConstraints.HORIZONTAL;
       gbc.ipady = 10;
     
       gbc.gridx = 0;
       gbc.gridy = 2;
       gbc.gridwidth = 2;
       pane.add(SWGoogle,gbc);
      
       
       CAPanel.add(pane);
       
      setVisible(true);
    }
    
    public void thirdLane(){
        
    }
    
   
 }
    
