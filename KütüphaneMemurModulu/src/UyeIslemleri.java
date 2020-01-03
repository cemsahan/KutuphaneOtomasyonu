
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class UyeIslemleri extends Baglan{
   
    
    public ArrayList<Uyeler> UyeleriGetir(){
        
        
        
        ArrayList<Uyeler> cikti=new ArrayList<Uyeler>();
        try {
            statement=con.createStatement();
            
            String sorgu="SELECT * FROM uyeler";
            
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                int uyeNo=rs.getInt("uyeNo");
                String uyeAdi=rs.getString("uyeAdi");
                String uyeSoyadi=rs.getString("uyeSoyadi");
                cikti.add(new Uyeler(uyeNo,uyeAdi,uyeSoyadi));
               
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
        
        
    }
    
    
}
