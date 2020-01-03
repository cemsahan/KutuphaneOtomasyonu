
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemurIslemleri extends Baglan{

    public ArrayList<Memur> memurlariGetir(){
        ArrayList<Memur> cikti=new ArrayList<Memur>();
        
        try {
            statement=con.createStatement();
            String sorgu="SELECT * FROM memur";
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id=rs.getInt("memurID");
                String ad=rs.getString("memurAd");
                String soyad=rs.getString("memurSoyad");
                String email=rs.getString("email");
                String parola=rs.getString("parola");
                cikti.add(new Memur(id, ad, soyad, email, parola));
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(MemurIslemleri.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
        
    }
    public void memurSil(int gorevliID){
        
        String sorgu="DELETE FROM memur WHERE memurID=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, gorevliID);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MemurIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
        
        
    }
    
    
    
    
    public void memurEkle(String ad,String soyad,String email,String parola){
        String sorgu="INSERT INTO memur(memurAd,memurSoyad,email,parola) VALUES (?,?,?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, parola);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MemurIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public void memurGuncelle(String memurAd,String memurSoyad,String memurEmail,String memurParola,int memurID){
        
        
        String sorgu="UPDATE memur SET memurAd=? , memurSoyad=? , email=? , parola=? WHERE memurID=? ";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, memurAd);
            preparedStatement.setString(2, memurSoyad);
            preparedStatement.setString(3, memurEmail);
            preparedStatement.setString(4, memurParola);
            preparedStatement.setInt(5, memurID);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MemurIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    
    
}
