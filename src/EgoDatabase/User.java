package EgoDatabase;

import java.sql.*;
import java.io.*;

import egodiary.prototype.MainFrame;
import javax.swing.ImageIcon;

import java.net.URL;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import egodiary.prototype.CAFrame;

/**
 * @author Patrick Atta-Baah
 * 
 * This is an abstract class that holds all data for create account and login class in the EgoDatabase Server

*/
public abstract class User implements DatabaseEncryption{
    
           /* USER INFO */
    private String Username;
    private String Emailaddress;
    private String Password;
    private Object Gender;
    private String DOB;
    private String Firstname;
    private String Lastname;
    private String Age;
    private String Phone;
    private File profilepic;
    
    //for createaccount only
    private String Exists;
    private String Notvalid;
    private String Valid;
    
    Connection DB_Connection;
    PreparedStatement pstatement;
    ResultSet ego_resultset;
    String IUser;
    String IStatement;
    
         MainFrame main = new MainFrame();
         CAFrame cframe = new CAFrame();
   
    /**  
     *
     */
    //create account const.
    public User(String username, String emailaddress, String password, Object gender, String dob, String firstname, String lastname, String exist, String  valid, String notvalid){
        
        //set private variables
        Username = username;
        Emailaddress = emailaddress;
        Password = password;
        Gender =gender;
        DOB = dob;
        Firstname = firstname;
        Lastname =lastname;
        Exists = exist;
        Notvalid = notvalid;
        Valid = valid;
    

    }
    
    //useraccount const.
    public User(String username, String emailaddress, String password, Object gender, String dob, String firstname, String lastname){
        Username = username;
        Emailaddress = emailaddress;
        Password = password;
        Gender =gender;
        DOB = dob;
        Firstname = firstname;
        Lastname =lastname;
    }
    
    //login const.
    public User(String username, String password){
        Username = username;
        Password = password;
    }
    
    public void uploadpic(File file){
        try{
            connectDatabase();
            
            FileInputStream fis = new FileInputStream(file);
        IStatement = "UPDATE User SET profilepic = ? where username = ?";
        pstatement = DB_Connection.prepareStatement(IStatement);
        pstatement.setBinaryStream(1, fis,(int)file.length());
        pstatement.setString(2,main.userdata);
        pstatement.executeUpdate();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public  void CAUploader(File file){
        try{
            connectDatabase();
            
            FileInputStream fis = new FileInputStream(file);
        IStatement = "Insert into User(profilepic) value(?) SET  where username = ?";
        pstatement = DB_Connection.prepareStatement(IStatement);
        pstatement.setBinaryStream(1, fis,(int)file.length());
        pstatement.setString(2,cframe.userdata);
        pstatement.executeUpdate();
        System.out.println("Uphoto uploader to : " + cframe.userdata);
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
     
 
    public User(){
      
    }
    
    //for user data retrieval
    public void setUserData(String username){
        Username = username;
     try{
        Class.forName("com.mysql.jdbc.Driver");
         connectDatabase();
        IUser = "SELECT  user.username, user.password, user.emailaddress, user.gender, user.firstname, user.lastname, user.profilepic FROM User WHERE user.username = ?";
        pstatement = DB_Connection.prepareStatement(IUser);
        pstatement.setString(1, Username);
       
        
     }catch(SQLException sqlexc){
            sqlexc.printStackTrace();
     }catch(Exception exc){
         exc.printStackTrace();
     }
  }
    
   public BufferedImage getpic(String attri){
       BufferedImage image = null;
       try{
       ego_resultset =  pstatement.executeQuery();
       
       if(ego_resultset.next()){
          Blob ic = ego_resultset.getBlob(attri);
           int iclength = (int)ic.length();
           byte[] content = ic.getBytes(1,iclength);
           
           image = ImageIO.read(new ByteArrayInputStream(content));
     
       }
       
         }catch(Exception e){
             e.printStackTrace();
         }
       return image;
   }

   
    
    public  String getUserStringAttribute(String attri){
        String fb = null;
        try{
            ego_resultset = pstatement.executeQuery();
            if(ego_resultset.next()){
              fb = ego_resultset.getString(attri);
            }
            
        }catch(SQLException sqlexc){
            sqlexc.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return fb;
        
    }
    
 
    
    public void connectDatabase() {
        try{
        
        Class.forName(DB_DRIVER);
        System.out.println("Connecting to Database");
        DB_Connection  = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
        System.out.println("Connected");
        
        }
        catch(SQLException sqlex){
            
        }
        catch(Exception ex){
            
        }
    }
    
    
    
    
    
    
  
    
    public String getUsername(){
        return Username;
    }
    public String getEmailAddress(){
        return Emailaddress;
    }
    public String getPassword(){
     return Password;   
    }
    public Object getGender(){
        return Gender;
    }
    public String getDOB(){
        return DOB;
    }
    public String getFirstname(){
     return Firstname;   
    }
    
    public String getLastname(){
        return Lastname;
    }
    
    //createaccount only
    public String getNotvalidStatus(){
        return Notvalid;
    }
     
                
                
    
    
}