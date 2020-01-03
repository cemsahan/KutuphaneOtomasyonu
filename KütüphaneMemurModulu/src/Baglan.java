
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class Baglan {
    
    public static final String kullaniciAdi="root";
    
    public static final String parola="";
    
    public static final String db_ismi="kutuphane";
    
    public static final String host="localhost";
    
    public static final int port=3306;
    
    public Connection con=null;
    
    public Statement statement=null;
    
    public PreparedStatement preparedStatement=null;
    
    public Baglan() {
        String url="jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?useUniCode=true&characterEncoding=utf8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        try {
            con=DriverManager.getConnection(url, kullaniciAdi, parola);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);        
        }
        
    }
    
    
    
    
    
}
    
