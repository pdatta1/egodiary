package egodiary.prototype;

import javax.swing.*;
import java.net.URL;
import java.awt.CardLayout;

public class SplashScreen extends JFrame{

    public SplashScreen(){
        InitSplash();
    }
    
    public void InitSplash(){
        
        setSize(500,500);
        setResizable(false);
        setLayout(new CardLayout());
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        URL imgurl = this.getClass().getResource("/images/AppIcon7.png");
        ImageIcon appIcon = new ImageIcon(imgurl);
        JLabel applabel = new JLabel(appIcon);
        add(applabel);
        
        setVisible(true);
    }
    
}