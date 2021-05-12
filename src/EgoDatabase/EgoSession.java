package EgoDatabase;


import java.sql.*;
/*This class check if user is already logged into EgoDiary and also Retrives all
* all information  of that specific user
*/
public class EgoSession extends Thread{

    //private variables
    private Thread egothread;
    private String threadname;
    private String UserAccount;



    //Database
     static final String DB_URL = "jdbc:mysql://192.168.0.7:3306/EgoDatabase";
     //credential
     static final String DB_USER = "CodeLord";
     static final String DB_PASS = "hgt.22-3";
     Connection db_connection = null;
     PreparedStatement db_statement = null;
     Boolean isloggedin;


     //User is loggedin
     public Boolean isLoggedin(Class userclass){
  
         try{
         Object obj = userclass.newInstance();

         db_connection = DriverManager.getConnection(DB_USER,DB_PASS,DB_URL);
         }catch(InstantiationException ise){

         }catch(IllegalAccessException iae){

         }catch(SQLException sqlcrash){

         }catch(Exception e){

         }

        return isloggedin;
     }

     public void run(){

     }

     public void start(){

     }



}
