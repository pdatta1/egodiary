package egodiary.prototype;
import egodiary.prototype.Accessories.EgoDiaryAccesories;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.text.*;
import javax.mail.*;

import java.sql.*;

import EgoDatabase.*;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;





public class CAFrame extends JPanel{
    
  
  
     //class init
    HomeScreen hframe;
    MainFrame mframe = new MainFrame();
    
    //username
    private JTextField usernametxt_ac;
    private JLabel errorusername;
    
    //panel
    private JPanel App_Logo;
   
    
    public void setCAPanel(){
         
        setLayout(new GridLayout(3,1));
        setVisible(true);
        //font
      Font font = new Font("New Roman",Font.ITALIC,14);
      Font labelfont = new Font("New Roman",Font.BOLD,13);
       
     EgoDiaryAccesories app_accesories = new EgoDiaryAccesories();
     
     //App_Icon
     // First Lane
     
     //Layout
     GridBagLayout fll =  new GridBagLayout();
     GridBagConstraints flc = new GridBagConstraints();
     flc.fill = GridBagConstraints.HORIZONTAL;
     
     
     App_Logo = new JPanel();
     App_Logo.setLayout(fll);
     App_Logo.setBackground(Color.white);
     
 final JFileChooser selectpic = new JFileChooser();
     ImageIcon photo = new ImageIcon();
     JLabel profilepic = new JLabel(photo,JLabel.CENTER);

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
                       final File file = selectpic.getSelectedFile();
                       
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
  
     
     flc.gridx = 0;
     flc.gridy = 0;
     flc.ipady = 20;
     App_Logo.add(profilepic,flc);

     
     /* Second Lane */
      //CAPanel
     final JPanel CAPanel = new JPanel();
     CAPanel.setLayout(new FlowLayout());
     CAPanel.setBackground(Color.white);
     
     //sub panel
     JPanel subPanel = new JPanel();
     subPanel.setBackground(Color.white);
     
   //usernamelabel
     JLabel lbusername = new JLabel("Username       : ");
    lbusername.setFont(new Font("New Roman",Font.BOLD,24));
    lbusername.setForeground(Color.black);
    
    //ibemailadres
   JLabel lbemailaddress = new JLabel("EmailAddress : ");
    lbemailaddress.setFont(new Font("New Roman",Font.BOLD,24));
    lbemailaddress.setForeground(Color.black);
    
    JLabel genderlabel = new JLabel("your Gender ? : ");
       genderlabel.setFont(new Font("New Roman",Font.BOLD,24));
       genderlabel.setForeground(Color.black);
       genderlabel.setVisible(true);
    
    //errors
    final JLabel erroremail = new JLabel("Please insert EmailAddress !!");
      erroremail.setFont(new Font("New Roman",Font.BOLD,10));
      erroremail.setForeground(Color.red);
      erroremail.setVisible(false);
       
       errorusername = new JLabel("Please insert Username !!");
       errorusername.setFont(new Font("New Roman",Font.BOLD,10));
       errorusername.setForeground(Color.red);
       errorusername.setVisible(false);
       
    final JLabel errorpass = new JLabel("Please insert Password!!");
       errorpass.setFont(new Font("New Roman",Font.BOLD,10));
       errorpass.setForeground(Color.red);
       errorpass.setVisible(false);
       
       final JLabel errorfirst = new JLabel("Please insert you firstname");
       errorfirst.setFont(new Font("New Roman",Font.BOLD,10));
       errorfirst.setForeground(Color.red);
       errorfirst.setVisible(false);
       
       final JLabel errorlast = new JLabel("Please Insert you lastname");
       errorlast.setFont(new Font("New Roman",Font.BOLD,10));
       errorlast.setForeground(Color.red);
       errorlast.setVisible(false);
       
     
       
       final JLabel errordob = new JLabel("Date of Birth error");
       errordob.setFont(new Font("New Roman",Font.BOLD,10));
       errordob.setForeground(Color.red);
       errordob.setVisible(false);
         
    //passwordlabel
    final JLabel lbpassword = new JLabel("Password       : ");
    lbpassword.setFont(new Font("New Roman",Font.BOLD,24));
    lbpassword.setForeground(Color.black);
    
     //usernametxt_ac
    
     EgoDiaryAccesories.EgoTextFieldLimits limits=app_accesories.new EgoTextFieldLimits(20);
     usernametxt_ac = new JTextField(20);
     usernametxt_ac.setFont(font);
     usernametxt_ac.setDocument(limits);
   
     
     //usernametxt_ac
     final JTextField EmailAddress_ac = new JTextField(20);
     EmailAddress_ac.setFont(font);
     //usernametxt_ac
    final  JPasswordField passwordtxt_ac = new JPasswordField(20);
     passwordtxt_ac.setFont(font);
     EgoDiaryAccesories.EgoPasswordField passlimits=app_accesories.new EgoPasswordField(16);
     passwordtxt_ac.setDocument(passlimits);
    
        //gendergroup
      final JComboBox<String> gendercom = new JComboBox();
      gendercom.setModel(new DefaultComboBoxModel<>(new String[] {"Male","Female"}));
     
      //DOB
     final JLabel DOBLabel = new JLabel("Date of Birth, format : yyyy-mm-dd");
      DOBLabel.setFont(labelfont);
     final JTextField DOB = new JTextField(15);
     DOB.setFont(font);
     
     
     
     

     GridBagLayout gbl = new GridBagLayout();
     subPanel.setLayout(gbl);
     GridBagConstraints gbc = new GridBagConstraints();
     
     //usernametxt_ac
     gbc.fill = GridBagConstraints.HORIZONTAL;
     gbc.ipady = 20;
     gbc.gridx = 0;
     gbc.gridy = 0;
     subPanel.add(lbusername,gbc);
     
     gbc.ipady = 30;
     gbc.gridx = 1;
     gbc.gridy = 0;
     subPanel.add(usernametxt_ac,gbc);
     
     gbc.ipady = 2;
     gbc.gridx = 2;
     gbc.gridy = 0;
     subPanel.add(errorusername,gbc);
     
     //Emailaddress_ac
     gbc.ipady = 20;
     gbc.gridx = 0;
     gbc.gridy = 1;
     subPanel.add(lbemailaddress,gbc);
     
     gbc.ipady = 30;
     gbc.gridx = 1;
     gbc.gridy = 1;
     subPanel.add(EmailAddress_ac,gbc);
     
     gbc.ipady = 2;
     gbc.gridx = 2;
     gbc.gridy = 1;
     subPanel.add(erroremail,gbc);
     
     
     //passwordttx_ac
     gbc.ipady = 20;
     gbc.gridx = 0;
     gbc.gridy = 2;
     subPanel.add(lbpassword,gbc);
     
     gbc.ipady = 30;
     gbc.gridx = 1;
     gbc.gridy = 2;
     subPanel.add(passwordtxt_ac,gbc);
     
     gbc.ipady = 2;
     gbc.gridx = 2;
     gbc.gridy = 2; 
     subPanel.add(errorpass,gbc);
     
     // genderoption
     gbc.ipady = 20;
     gbc.gridx = 0;
     gbc.gridy = 3;
     subPanel.add(genderlabel,gbc);
     
     gbc.ipady = 20;
     gbc.gridx = 1;
     gbc.gridy = 3;
     subPanel.add(gendercom,gbc);
     
     gbc.ipady = 5;
     gbc.gridx = 0;
     gbc.gridy = 4;
     subPanel.add(DOBLabel,gbc);
     
     gbc.ipady = 5;
     gbc.gridx = 1;
     gbc.gridy = 4;
     subPanel.add(DOB,gbc);
      
     
     
       /*  Component */
       
      //ThirdLane
      final JPanel Footerlane = new JPanel();
      GridBagLayout thirdlanelayout = new GridBagLayout();
      Footerlane.setLayout(thirdlanelayout);
      Footerlane.setBackground(Color.white);
      
            //first name
      JLabel flabel = new JLabel("Firstname :           ");
      flabel.setFont(new Font("New Roman",Font.BOLD,24));
     final  JTextField firstname = new JTextField(20);
      firstname.setFont(font);
      //lastname
      JLabel l_label = new JLabel("Lastname :           ");
      l_label.setFont(new Font("New Roman",Font.BOLD,24));
     final  JTextField lastname = new JTextField(20);
      lastname.setFont(font);
      
      
     
      
      
      //components
      //createaccount_btn
     //create new user account
      //main code for EgoDatabase here
     JButton CABtn = new JButton("Create Account");
     CABtn.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e){
             //class init
             CreateAccount ac;
           
          
             //usernametxt
             if(usernametxt_ac.getText().length() == 0){
                 //show error
                 errorusername.setVisible(true);
                 
                 //hide all other error label that will intervine
                 erroremail.setVisible(false);
                 errorpass.setVisible(false);
                 errorfirst.setVisible(false);
                 errorlast.setVisible(false);
                 errordob.setVisible(false);
                 
             }else if (EmailAddress_ac.getText().length() == 0){
                 erroremail.setVisible(true);
                 errorusername.setVisible(false);
                 errorpass.setVisible(false);
                 errorfirst.setVisible(false);
                 errorlast.setVisible(false);
                 errordob.setVisible(false);
             }
             
             else if(passwordtxt_ac.getText().length() == 0){
                 errorpass.setVisible(true);
                 
                  erroremail.setVisible(false);
                 errorusername.setVisible(false);
                 errorfirst.setVisible(false);
                 errorlast.setVisible(false);
                 errordob.setVisible(false);
                 
             }else if(firstname.getText().length()== 0){
                 errorfirst.setVisible(true);
                  errorpass.setVisible(false);
                  erroremail.setVisible(false);
                 errorusername.setVisible(false);
                 errorlast.setVisible(false);
                 errordob.setVisible(false);
                 
             }else if(lastname.getText().length() == 0){
                 errorlast.setVisible(true);
                 errorfirst.setVisible(false);
                  errorpass.setVisible(false);
                  erroremail.setVisible(false);
                 errorusername.setVisible(false);
                 errordob.setVisible(false);
                 
                 
             }else if(DOB.getText().length() == 0){
                 errordob.setVisible(true);
                 errorfirst.setVisible(false);
                  errorpass.setVisible(false);
                  erroremail.setVisible(false);
                 errorusername.setVisible(false);
                 errorlast.setVisible(false);
             
             }else{ 
                  errordob.setVisible(false);
                 errorfirst.setVisible(false);
                  errorpass.setVisible(false);
                  erroremail.setVisible(false);
                 errorusername.setVisible(false);
                 errorlast.setVisible(false);
                  ac=  new CreateAccount(usernametxt_ac.getText(), EmailAddress_ac.getText(),passwordtxt_ac.getText(), gendercom.getSelectedItem(),DOB.getText(),firstname.getText(),lastname.getText(),"Username Exists","Valid EmailAddress","Not Valid EmailAddress");

              try{
                     
              
                   
                 userdata = usernametxt_ac.getText();
                  new Welcome();
                     ac.createAccount();
                     
                  System.out.println("User created : " + userdata);
                  usernametxt_ac.setText("");
                lastname.setText("");
                DOB.setText("");
                firstname.setText("");
                passwordtxt_ac.setText("");
                 EmailAddress_ac.setText("");
               
                  }catch(SQLException sqlexc){
                      
                  }catch(Exception exc){
                      
                  }
                  

       }
                  
                 
                  
             
         }
     });
   
     //Create Account code ends here
     
        //go back to homepage
      JButton goback = new JButton("Home");
      goback.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             
            usernametxt_ac.setText("");
            lastname.setText("");
            DOB.setText("");
            firstname.setText("");
            passwordtxt_ac.setText("");
            EmailAddress_ac.setText("");
            setVisible(false);
            mframe.setVisible(true);
         
    
           
         } 
      });
      

      
     
      
      //components ends
      
      
      GridBagConstraints tlc = new GridBagConstraints();
      tlc.fill = GridBagConstraints.HORIZONTAL;
  
       
      //firstname
       tlc.gridx = 0;
       tlc.gridy = 0;
       tlc.ipady = 20;
       Footerlane.add(flabel,tlc);
       tlc.gridx = 1;
       tlc.gridy = 0;
       tlc.ipady = 20;
       Footerlane.add(firstname,tlc);
       
       tlc.gridx = 2;
       tlc.gridy = 0;
       tlc.ipady = 2;
       Footerlane.add(errorfirst,tlc);
       
       
       //lastname
       tlc.gridx = 0;
       tlc.gridy = 1;
       tlc.ipady = 20;
       Footerlane.add(l_label,tlc);
       tlc.gridx = 1;
       tlc.gridy = 1;
       tlc.ipady = 20;
       Footerlane.add(lastname,tlc);
       
       tlc.gridx = 2;
       tlc.gridy = 1;
       tlc.ipady = 2;
       Footerlane.add(errorlast,tlc);
       
       
       tlc.gridx = 0;
       tlc.gridy = 3;
       tlc.ipady = 20;
       tlc.gridwidth = 2;
       Footerlane.add(CABtn,tlc);
       
       tlc.gridx = 0;
       tlc.gridy = 4;
       tlc.ipady = 20;
       Footerlane.add(goback,tlc);
       
       
      
   
      
      //third lane ends here
       
        
     
       
        
        App_Logo.add(app_icon);
        
        CAPanel.add(subPanel);
        
     
        add(App_Logo);
        add(CAPanel);
        add(Footerlane);
       
        setVisible(true);
       
        
    }
    
      public static String userdata;
 

    
    
    
    
    
}
