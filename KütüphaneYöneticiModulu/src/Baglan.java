
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public abstract class Baglan {
    
    
    public Connection con=null;
    
    public Statement statement=null;
    
    public PreparedStatement preparedStatement=null;
    
    public Baglan() {
        String url="jdbc:mysql://"+database.host+":"+database.port+"/"+database.db_ismi+"?useUniCode=true&characterEncoding=utf8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            con=DriverManager.getConnection(url, database.kullaniciAdi, database.parola);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);        
        }
        
    }
    
}
