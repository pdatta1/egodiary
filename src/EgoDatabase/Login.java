package EgoDatabase;
/** @author Patrick Atta-Baah
 * 
 */
import egodiary.prototype.HomePage;
import egodiary.prototype.HomeScreen;
import java.sql.*;
import javax.swing.JOptionPane;
import egodiary.prototype.MainFrame;
import egodiary.prototype.ExecuteApp;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import egodiary.prototype.Accessories.*;

/* Valid The user credential, if the user credential is right, it send data to UserAccount class, UserAccount retrieved all the user credential from 
login and that's it end of Login Class Job
*/
public class Login extends User implements DatabaseEncryption{
 

 

 //Ego credential
public Login(String username, String password){
    super(username, password);
    
}

public Login(){
    
}




String isLoggedin;
UserAccount ua; 
 //validate a specific user during login attempt
 public void  validateUser() throws SQLException , Exception{
     
   
     Connection DBConnection = null;
     PreparedStatement Pstatement = null;
    
     
     
     try{
         
         //class registration
         Class.forName("com.mysql.jdbc.Driver");
         
         //connect to database
         System.out.println("Connecting to Database........");
         DBConnection =  DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
         System.out.println("Connected");
         
         //statement
         String ILogin = "SELECT * FROM User WHERE username = ? AND password = ?";
         Pstatement = DBConnection.prepareStatement(ILogin);
         Pstatement.setString(1,getUsername());
         Pstatement.setString(2, getPassword());
     
         
         //get items from Query
         ResultSet rs = Pstatement.executeQuery();
         if(rs.next()){
             
            JOptionPane.showMessageDialog(null,"Login Success");
            //User Future code goes here
           
           isLoggedin = "UPDATE  User SET IsLogged  = 1 where username = ?";
            Pstatement = DBConnection.prepareStatement(isLoggedin);
            Pstatement.setString(1,getUsername());
            Pstatement.executeUpdate();
             
            
                 //display isloggedin here
          ExecuteApp execute = new ExecuteApp("App-Killer : HomeScreen");
          execute.stop();
             HomePage hpage = new HomePage();
             hpage.initHomepage();
             hpage.BARS();
             hpage.firstLane();
             hpage.secondLane();
             
             
         }else{
             JOptionPane.showMessageDialog(null,"Login Failed, Invalid Username and Password");
             System.out.println("Invalid credential");
         }
         
         
         
         //clean up db
         Pstatement.close();
         DBConnection.close();
         
     }catch(SQLException sqlcrash){
         sqlcrash.printStackTrace();
         JOptionPane.showMessageDialog(null,"Cannot connect to Server, please try again later");
 
     }catch(Exception  crash){
         crash.printStackTrace();
          JOptionPane.showMessageDialog(null,"Cannot connect to Server, please try again later");
     }
   finally{
         try{
             if(Pstatement != null)
                 Pstatement.close();
         }catch(Exception e){
             e.printStackTrace();
         }
         
         try{
             if(DBConnection != null)
                 DBConnection.close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
     
 }
 
 /* This function send back the data to UserAccount class From the Login Cycle */
     

 
  
   


 
    
}