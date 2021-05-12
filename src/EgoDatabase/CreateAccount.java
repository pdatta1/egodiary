package EgoDatabase;

import java.sql.*;
import egodiary.prototype.*;
import javax.swing.JOptionPane;
import java.io.*;



public class CreateAccount extends User implements DatabaseEncryption{
 
 
    
 
    Statement db_statement = null;
    PreparedStatement pd_Statement = null;
    Connection db_connection;

    //result set
    ResultSet result;
    
  public CreateAccount(String username, String emailaddress, String password, Object gender, String dob, String firstname, String lastname, String exist, String  valid, String notvalid){
      super(username, emailaddress, password, gender, dob, firstname, lastname,exist, valid,notvalid);
  }
    
    
    //class init
   CAFrame cframe = new CAFrame();
    
   public void createAccount(File file) throws SQLException, Exception{
           
           
           //Register JDBC DRIVER for EgoDatabase
           Class.forName("com.mysql.jdbc.Driver");
           
          //File
          FileInputStream fis = new FileInputStream(file);
           
           //connection to EgoDatabase
           System.out.println("Connecting to Database......"); //remove after real project(rarj) // System.out.println values

           db_connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
           //create new user
           System.out.println("Creating User");
           String Egodb_injector = "INSERT INTO User" +
                   "(username,emailaddress,password,gender,DOB,firstname,lastname,age)" 
                   + "VALUES(?,?,?,?,?,?,?,?)";
           pd_Statement = db_connection.prepareStatement(Egodb_injector);
           pd_Statement.setString(1,getUsername());
           pd_Statement.setString(2,getEmailAddress());
           pd_Statement.setString(3,getPassword());
           pd_Statement.setObject(4, getGender());
           pd_Statement.setString(5,getDOB());
           pd_Statement.setString(6,getFirstname());
           pd_Statement.setString(7,getLastname());
           pd_Statement.setBinaryStream(1,fis,(int)file.length());
           //FIX AGE TO DOB 
           //NEED FIXING
           pd_Statement.setInt(8,16);
           
         //BUG OVER HERE , NEED FIX
           //Check if user exist
          String IQuery = "SELECT * FROM User WHERE username = ?";
          PreparedStatement statement = db_connection.prepareStatement(IQuery);
          statement.setString(1,getUsername());
          ResultSet rs = statement.executeQuery();
          if(rs.next()){
           
              JOptionPane.showMessageDialog(null,"username Exists");
              }else{
                  //Create new User
                     if(isValidEmailAddress(getEmailAddress())){
                         System.out.println("Valid EmailAddress");
                      pd_Statement.executeUpdate();
                         System.out.println("User Created");
                     
                       
                         JOptionPane.showMessageDialog(null,"User Created " + getUsername() + ",Please login to continue");
                         
                         
                     }else{
                      JOptionPane.showMessageDialog(null,getNotvalidStatus());
                              }
            
                  
              }
            db_connection.close();
           pd_Statement.close();
   }
          
         
            
          
            
           
           
           
          
         
           
       

     
       
     
       
       
   
   
 
   
   //validate emailaddress to it format
   public void validemail(String email){
       if(isValidEmailAddress(email)){
           System.out.println("Valid EmailAddress");
          
       }else{
            JOptionPane.showMessageDialog(null,"InValid EmailAddress");
       }
   }
   
   public boolean isValidEmailAddress(String emailaddress) {
           String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailPattern);
           java.util.regex.Matcher m = p.matcher(emailaddress);
           return m.matches();
    }
}
   
   
   