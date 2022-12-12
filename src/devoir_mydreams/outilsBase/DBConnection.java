package devoir_mydreams.outilsBase;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {
 static Connection con=null;
  
 public static Connection getCon(){
     try {
         // Charger le pilote de la base de donnees
         Class.forName("com.mysql.cj.jdbc.Driver");
         // etablir la connexion a la BD
         String url="jdbc:mysql://localhost:3307/mydreamsconnexion";
         con=DriverManager.getConnection(url,"root","");
         System.out.println("Hello");
     } catch (ClassNotFoundException ex) {
         JOptionPane.showMessageDialog(null, " Erreur "+ex);
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "SQL  Erreur "+ex);
     }
     return con;
 }
 

 
 
}
