
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Admin extends Baglan{
    
    
    public boolean girisKontrol(String adminEmail,String parola){
        
        String sorgu="SELECT yoneticiEmail,parola FROM admin WHERE yoneticiEmail=? and parola=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, adminEmail);
            
            preparedStatement.setString(2, parola);
            
            ResultSet rs=preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(girisPaneli.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
        
        return false;
        
        
    }
    
   
}