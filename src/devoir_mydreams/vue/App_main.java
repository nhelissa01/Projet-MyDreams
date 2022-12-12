/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devoir_mydreams.vue;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author nheli
 */
public class App_main {
     public static void main(String[] args) {
         try {
             UIManager.setLookAndFeel(new NimbusLookAndFeel());
         } catch (UnsupportedLookAndFeelException ex) {
             Logger.getLogger(App_main.class.getName()).log(Level.SEVERE, null, ex);
         }
        My_Dreams md=new My_Dreams();
        md.setVisible(true);
    }
     
}
