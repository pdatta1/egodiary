package EgoDatabase;
/** @author Patrick Atta-Baah
 * 
 */
import java.sql.*;
import egodiary.prototype.HomePage;
import egodiary.prototype.MainFrame;


public class UserAccount  extends User  implements DatabaseEncryption {




    
    
public UserAccount(String username, String emailaddress, String password, Object gender, String dob ,String firstname, String lastname){
    super(username, emailaddress,password, gender, dob,firstname,lastname);
}


     HomePage hp;
     //User
     
     public UserAccount(){
        
     }
     
     private String User;

     Login login = new Login();

     String IUser;
   
     MainFrame main = new MainFrame();

     Connection db_connection;
     PreparedStatement db_statement;
    
     
 
   
     //THIS CLASS IS A GHOST, NOT IN USED.
     
     
     
    
    
    
     
   
     
  
     
    
     


     /* USER INFO */
     //set Firstname
    //how to display a String function in a button setText String parameter(BUG)
 


 

}
   