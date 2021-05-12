package egodiary.prototype;

import egodiary.prototype.Accessories.EgoDiaryAccesories;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.*;
import egodiary.prototype.Accessories.EgoMainComponents;
import  egodiary.prototype.ForgotCredential.FCredentialPage;

import EgoDatabase.Login;

import java.sql.*;

public class MainFrame  extends JPanel implements EgoMainComponents{

    
    private JPanel LoginPanel;
    private JPanel App_title;
    private JPanel FooterPanel;
   
    
    private String retrieveUsername;
    private JTextField username_txt;
    //components

    public static String userdata;
    
     Login login;
    CAFrame cframe;
    HomeScreen hframe;
    
  public static String retrieval; 
    
   
 
    
    public MainFrame(){
       initFrame(); 
       secondLane();
       firstLane();
       thirdLane();
       
    }
    
    public void initFrame(){
       
         
        setLayout(new GridLayout(3,1));
        
        App_title = new JPanel();
        App_title.setLayout(new FlowLayout());
        App_title.setBackground(Color.white);
         
        LoginPanel = new JPanel();
        LoginPanel.setLayout(new FlowLayout());
        LoginPanel.setBackground(Color.white);
     
        FooterPanel = new JPanel();
        FooterPanel.setLayout(new FlowLayout());
        FooterPanel.setBackground(Color.white);
        
      
        
        add(App_title);
        add(LoginPanel);
        add(FooterPanel);
        setVisible(false);
        
        
        
    }

    
    public void firstLane(){
       
        URL imgUrl = this.getClass().getResource("/images/AppIcon6.png");
        ImageIcon appIcon = new ImageIcon(imgUrl);
        JLabel elabel = new JLabel(appIcon,JLabel.CENTER);
        App_title.add(elabel);
        setVisible(true);
    }
    
    public void secondLane(){
        
       //classes
       EgoDiaryAccesories access = new EgoDiaryAccesories();
        
        //main font
        Font font = new Font("Courier New",Font.BOLD,16);
        //pane
         JPanel pane = new JPanel();
         pane.setLayout(new FlowLayout());
         pane.setBackground(Color.white);
       
         
         
         //usernamelabel
         JLabel lbusername = new JLabel("Username : ");
         lbusername.setSize(200,300);
         lbusername.setFont(new Font("New Roman",Font.BOLD,24));
         lbusername.setForeground(Color.black);
         
         //passwordlabel
         JLabel lbpassword = new JLabel("Password : ");
         lbpassword.setFont(new Font("New Roman",Font.BOLD,24));
         lbpassword.setForeground(Color.black);
         
         //username
         username_txt = new JTextField(20);
         username_txt.setFont(font);
         EgoDiaryAccesories.EgoTextFieldLimits limits=access.new EgoTextFieldLimits(20);
         username_txt.setDocument(limits);
                 
          //password       
        final  JPasswordField password_txt = new JPasswordField(20);
         password_txt.setFont(font);
         EgoDiaryAccesories.EgoPasswordField passlength=access.new EgoPasswordField(16);
         password_txt.setDocument(passlength);
         
         JWindow window = new JWindow();
         //Login Button
            final JButton  loginBtn = new JButton("Login");
         loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                
               char [] pass = password_txt.getPassword();
               String pwd = String.copyValueOf(pass);
               userdata = username_txt.getText();
               if(username_txt.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Username Textbox cannot be blank");  
               }else if(password_txt.getText().length() == 0){
                   JOptionPane.showMessageDialog(null,"Password Textbox cannot be blank");
               }else{
                   try{
               login = new Login(username_txt.getText(),pwd);
               login.validateUser();
               new HomeScreen().dispose();
               
               
               
             
               
               
             
                   }catch(SQLException sqlexc){
                       
                   }catch(Exception exc){
                       
                   }
               
               }
            }
         });
         
         
           
         
         
         pane.setSize(500,600);
         
         GridBagLayout gbl = new GridBagLayout();
         pane.setLayout(gbl);
         
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.ipady = 50;
         pane.add(lbusername,gbc);
         
         gbc.gridx = 1;
         gbc.gridy = 0;
         gbc.ipady = 20;
         pane.add(username_txt,gbc);
        
      
         gbc.ipady = 50;
         gbc.gridx = 0;
         gbc.gridy = 2;
         pane.add(lbpassword,gbc);
         
       
         gbc.gridx = 1;
         gbc.gridy = 2;
         gbc.ipady = 20;
         pane.add(password_txt,gbc);
         
         gbc.gridx = 0;
         gbc.gridy = 3;
         gbc.ipady = 30;
         gbc.gridwidth = 2;
         pane.add(loginBtn,gbc);
    
        LoginPanel.add(pane);
       setVisible(true);
        
    }
    
    public static String data;
   
    
    public void thirdLane(){
        
        JPanel pane = new JPanel();
        pane.setBackground(Color.white);
        GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);
        
        Font font = new Font("New Roman",Font.ITALIC,14);
        
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){ 
            setVisible(false);   
           }
        });
        //createaccountlink btn
        JButton link_createaccpage = new JButton("Create Account");
        
        /* BUGS IN THIS ACTION LISTENER, NEED FIXING, LINKING TO CREATE ACCOUNT PAGE */
        link_createaccpage.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  
                setVisible(false);
           
               }
        });
        
       
        //forgotuser
        JLabel forgot = new JLabel("Forget Login Credentials ? ");
        forgot.setFont(font);
        forgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgot.addMouseListener(new MouseAdapter(){
        
            public void mouseClicked(MouseEvent e){
             FCredentialPage recoverypage = new FCredentialPage();
             recoverypage.initFrame();
            }
        });
         
       
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //forgotuser layout location
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pane.add(forgot,gbc);
        
        
        
        //createaccountbtn layout location
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.gridwidth = 5;
        pane.add(home,gbc);
        
        FooterPanel.add(pane);
        setVisible(true);
       
        
    }
    
    
   
  
}
    
 
         
    
 
    


  
