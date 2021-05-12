package egodiary.prototype;

import javax.swing.JFrame;
import java.sql.*;
import egodiary.prototype.MainFrame;
import egodiary.prototype.HomePage;




public class ExecuteApp  implements Runnable{
    
    private String ThreadName;
    private Thread appstarter;
    
    HomePage hp;
    HomeScreen hs;
    
    Connection DBConnection = null;
    PreparedStatement pstatement = null;
    ResultSet rs = null;
         
    static String User = "root";
    static String pass = "hgt.22-3";
    static String URL = "jdbc:mysql://localhost/EgoDatabase";
    public ExecuteApp(String threadname){
        ThreadName = threadname;
        System.out.println("Creating Thread : " + ThreadName);
    }
    
   
    public void isLogged(){
         try{
            Class.forName("com.mysql.jdbc");
            String checker = "Select IsLogged From User Where username = ? ";
        DBConnection= DriverManager.getConnection(URL,User,pass);
           pstatement = DBConnection.prepareStatement(checker);
           MainFrame mf = new MainFrame();
           pstatement.setString(1,mf.userdata);
           rs =pstatement.executeQuery();
         }catch(Exception e){
             
         }
           
    }
    
    public void run(){
        try{
          
        SplashScreen screen = new SplashScreen();
        Thread.sleep(5000);
        screen.dispose();
         hs = new HomeScreen();
         hs.initFrame();
       hs. firstLane();
       hs. secondLane();
       hs. thirdLane();
        
        
      
        
      
      
         
        }catch(InterruptedException ite){
            ite.printStackTrace();
            System.out.println("Thread Interrupted : " + ThreadName);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void stop(){
     System.out.println("Ending Thread : " + ThreadName);
     if(appstarter == null)
         appstarter = new Thread(this,ThreadName);
         appstarter.stop();
    }
    
    
    public void start(){
        
        System.out.println("Starting Thread : " + ThreadName);
        if(appstarter== null){
          appstarter = new Thread(this, ThreadName);
          appstarter.start();
        }
        
    }
    
    
    
    
    
    public static void main(String [] args){
       
  
     ExecuteApp execute = new ExecuteApp("AppStarter : SplashScreen");
     execute.start();
     
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.region"));
    
                
   }
  
}