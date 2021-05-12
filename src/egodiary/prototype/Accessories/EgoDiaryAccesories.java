package egodiary.prototype.Accessories;

import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class EgoDiaryAccesories{

    //get app tittle
    public String appTitle(String title){
        return title;
    }
    
    //put a frame to fullscreen
    public void getFullScreen(JFrame frame){
     GraphicsDevice devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
     devices.setFullScreenWindow(frame);
    }
    
    //get any Textfield its limit to input values    
  public class EgoTextFieldLimits extends PlainDocument{
      
      private int limits;
      public EgoTextFieldLimits(int limits){
          super();
          this.limits = limits;
      }
      
      public EgoTextFieldLimits(int limits, boolean upper){
          super();
          this.limits = limits;
      }
      
      public void insertString(int offset, String egotext, AttributeSet attr) throws BadLocationException {
          
          if(egotext == null)
              return;
          
          if((getLength() + egotext.length() <= 20)){
              super.insertString(offset, egotext, attr);
          }
      }
    
}
  
  public class EgoPasswordField extends PlainDocument{
      
     private int limits;
     public EgoPasswordField(int limits){
         super();
         this.limits  = limits;
     }
     public EgoPasswordField(int limits, boolean upper){
         super();
         this.limits = limits;
     }
     
     public void insertString(int offset, String pass, AttributeSet attr) throws BadLocationException{
      
         if(pass == null)
             return;
         
         if(getLength() + pass.length() <= 16){
             super.insertString(offset,pass, attr);
         }
         
     }
      
  }
  
  public void exitFrame(JFrame frame){
      frame.setVisible(false);
      frame.dispose();
  }
  
  
    
    
}