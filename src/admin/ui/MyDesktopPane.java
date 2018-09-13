/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin.ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author vijay
 */
public class MyDesktopPane extends JDesktopPane{
    
    Image backImage;

    public MyDesktopPane() {
        
         backImage = new ImageIcon(getClass().getResource("/admin/ui/back.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
       if(backImage!=null){
            g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
           
       }else{
        super.paintComponent(g); 
    }
    
    }
}