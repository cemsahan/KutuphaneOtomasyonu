
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KitapIslemleri extends KategoriIslemleri{

    public ArrayList<Kitap> kitaplariGetir(){
        
        
         ArrayList<Kitap> cikti=new ArrayList<Kitap>();
        try {
            statement=con.createStatement();
            String sorgu="SELECT * FROM kitaplar";
       
            ResultSet rs=statement.executeQuery(sorgu);
        while(rs.next()){
            int kitapId=rs.getInt("kitapID");
            String kitapAdi=rs.getString("kitapAdi");
            String yayinTrh=rs.getString("yayinTarihi");
            String sayfaSayisi=rs.getString("SayfaSayisi");
            String kategorisi=kategoriAdiBul(kategoriIdBul(kitapId));
            String yazarAdsoyad=yazarAdiBul(yazarIdBul(kitapId));
            
            
            cikti.add(new Kitap(kitapId, kitapAdi, yayinTrh, sayfaSayisi, kategorisi, yazarAdsoyad));
        }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
    }
    public int kitapId(){
        
        
       try{
         String sorgu3="SELECT MAX(kitapID) FROM kitaplar";
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu3);
            int no;
            while(rs.next()){
                no=rs.getInt(1);
                    return no;
            }
            
            return 0;
        
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return -1;
        
        } 
        
        
    }
    public void kitapEkle(String kitapAdi,String yayinTarihi,String sayfaSayisi,String[] kategoriAdi,String[] yazarlar){
        String sorgu="INSERT INTO KİTAPLAR(kitapAdi,yayinTarihi,SayfaSayisi) VALUES (?,?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, kitapAdi);
            preparedStatement.setString(2, yayinTarihi);
            preparedStatement.setString(3, sayfaSayisi);
            preparedStatement.executeUpdate();
            
            yazarEkle(yazarlar, kitapId());
            kategoriEkle(kategoriAdi, kitapId());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
      
    public void kitapSil(int kitapId){
        String sorgu="DELETE FROM kitaplar WHERE kitapID=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, kitapId);
            preparedStatement.executeUpdate();
            kitap_kategoriSil(kitapId);
            yazar_kitapSil(kitapId);
            
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
    public ArrayList<Kitap> kutuphanedeOlanKitaplariGetir(){
        ArrayList<Kitap> cikti=new ArrayList<Kitap>();
        try {
            statement=con.createStatement();
            String sorgu="SELECT * FROM kitaplar WHERE varmi='true'";
       
            ResultSet rs=statement.executeQuery(sorgu);
        while(rs.next()){
            int kitapId=rs.getInt("kitapID");
            String kitapAdi=rs.getString("kitapAdi");
            String yayinTrh=rs.getString("yayinTarihi");
            String sayfaSayisi=rs.getString("SayfaSayisi");
            String kategorisi=kategoriAdiBul(kategoriIdBul(kitapId));
            String yazarAdsoyad=yazarAdiBul(yazarIdBul(kitapId));
            cikti.add(new Kitap(kitapId, kitapAdi, yayinTrh, sayfaSayisi, kategorisi, yazarAdsoyad));
        }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }


}
             

