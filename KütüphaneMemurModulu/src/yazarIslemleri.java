
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class yazarIslemleri extends Baglan{
    
public int sonYazarId(){
        String sorgu="SELECT MAX(yazarID) FROM yazarlar";
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
               return rs.getInt(1);
            }
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(yazarIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return -1;
        }
        
        
        
    }
public ArrayList yazarIdBul(int kitapID){
         String sorgu="SELECT yazarID FROM kitap_yazar WHERE kitapID="+kitapID;
        ArrayList<Integer> idler=new ArrayList<>();
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                idler.add(rs.getInt("yazarID"));
            }
            return idler;
            
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
public String yazarAdiBul(ArrayList<Integer> yazarIdler){
         String yazarlar="";
        try {
            statement=con.createStatement();
         for(Integer idler:yazarIdler)
        {
            String sorgu="SELECT * FROM yazarlar WHERE yazarID="+idler;
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
                yazarlar+=rs.getString("yazarAdSoyad")+"-";
            }
        }
        return yazarlar;
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
     
          
}public boolean yazarVarMi(String yazarAdi){
   String sorgu="SELECT * FROM yazarlar WHERE yazarAdSoyad=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, yazarAdi);
            
            
            ResultSet rs=preparedStatement.executeQuery();
            
                return rs.next();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
}
public void yazarEkle(String[] yazarlar,int kitapId){
           
            for(String yazar:yazarlar){
                boolean varMi=yazarVarMi(yazar);
                if(varMi==false){
                String sorgu="INSERT INTO yazarlar (yazarAdSoyad) VALUES (?)";
                try {
                    preparedStatement=con.prepareStatement(sorgu);
                    preparedStatement.setString(1, yazar);
                    preparedStatement.executeUpdate();
                    yazar_kitapEkle(sonYazarId(), kitapId);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(yazarIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                } 
                }
                if (varMi==true){
               try {
                String sorgu1="SELECT * FROM yazarlar WHERE yazarAdSoyad="+"'"+yazar+"'";
                statement=con.createStatement();
                ResultSet rs=statement.executeQuery(sorgu1);
                while(rs.next()){
                 int id=rs.getInt("yazarID");
                    yazar_kitapEkle(id, kitapId);
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            
            }
                }
            }
            
            
            
        }
public void yazar_kitapEkle(int yazarID,int kitapID){
    
    
    
    String sorgu="INSERT INTO kitap_yazar(yazarID,kitapID) VALUES (?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, yazarID);
                    preparedStatement.setInt(2, kitapID);
                    preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(yazarIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    
    
}
public void yazar_kitapSil(int kitapId){
    
    String sorgu="DELETE FROM kitap_yazar WHERE kitapID=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, kitapId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(yazarIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
}




}


        



