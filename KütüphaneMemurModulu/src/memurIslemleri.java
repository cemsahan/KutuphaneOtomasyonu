
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class memurIslemleri extends Baglan{
    
    public boolean girisYap(String email,String parola){
        
        String sorgu="SELECT * FROM memur WHERE email=? and parola=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, email);
            
            preparedStatement.setString(2, parola);
            
            ResultSet rs=preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(girisPaneli.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
