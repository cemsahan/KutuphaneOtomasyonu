
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class GrafikIslemleri extends Baglan {
    
 
   public ArrayList<Tarih> tarihGetir(){
         ArrayList<Tarih> cikti=new ArrayList<Tarih>();
           
       
        
        try {
            statement=con.createStatement();
            String sorgu="SELECT emanetTarihi,COUNT(kitapID) FROM emanet GROUP BY (emanetTarihi)";
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next())
            {
                int toplam=rs.getInt("COUNT(kitapID)");
                String tarih=rs.getString("emanetTarihi");
                cikti.add(new Tarih(tarih, toplam));
            }
      return cikti;
        
    }   catch (SQLException ex) {
            Logger.getLogger(GrafikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        
    return null;
    }
   }
    public ArrayList<Kategori> kategoriGetir(){
        
        
        
        
        ArrayList<Kategori> cikti=new ArrayList<Kategori>();
        
        try {
            statement=con.createStatement();
            String sorgu="SELECT kitap_kategori.kategoriID,kategori.kategoriAdi, COUNT(kitap_kategori.kategoriID) "
                    + "FROM emanet,kitap_kategori ,kategori "
                    + "WHERE emanet.kitapID=kitap_kategori.kitapID and kategori.kategoriID=kitap_kategori.kategoriID "
                    + "GROUP BY (kitap_kategori.kategoriID) HAVING COUNT(kitap_kategori.kategoriID)";
            
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next())
            {
                int toplam=rs.getInt("COUNT(kitap_kategori.kategoriID)");
                String kategoriAdi=rs.getString("kategoriAdi");
                cikti.add(new Kategori(toplam, kategoriAdi));
            }
      return cikti;
        
    }   catch (SQLException ex) {
            Logger.getLogger(GrafikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        
    return null;
    }
    
}
}