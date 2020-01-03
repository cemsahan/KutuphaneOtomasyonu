

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class OduncIslemleri extends Baglan {
    
  
    
    
    public void cezaHesapla(String zorunluTarih,int emanetNo){

        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        
        String suanTarih=df.format(new Date());
        
        if(zorunluTarih.equals("-")){
            return ;
        }
        
        int zorunluGun=(Integer.parseInt(zorunluTarih.substring(0,4))*365)+(Integer.parseInt(zorunluTarih.substring(5,7))*30)+Integer.parseInt(zorunluTarih.substring(8,10));
        int simdikiGun=(Integer.parseInt(suanTarih.substring(0,4))*365)+(Integer.parseInt(suanTarih.substring(5,7))*30)+Integer.parseInt(suanTarih.substring(8,10));
        int fark=zorunluGun-simdikiGun;
        int cezaTutarı=1;
        if(fark<0){
            cezaTutarı=Math.abs(fark)*10;
            
            
            String sorgu="UPDATE emanet SET cezaDurumu=? WHERE emanetNo=?";
           try {
               preparedStatement=con.prepareStatement(sorgu);
               preparedStatement.setInt(1, cezaTutarı);
            preparedStatement.setInt(2, emanetNo);
            preparedStatement.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            
            
        }
           
}
    public void cezaliSil(int uyeNo){
           
        String sorgu="UPDATE emanet SET cezaDurumu=0,zorunluTeslimTarihi='-' WHERE uyeNo=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, uyeNo);
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
       }
    public ArrayList<Odunc> cezalilariGetir(){
        String sorgu="SELECT uyeler.uyeNo,uyeler.uyeAdi,uyeler.uyeSoyadi,SUM(cezaDurumu) FROM emanet , uyeler WHERE uyeler.uyeNo=emanet.uyeNo GROUP BY (uyeNo) HAVING (SUM(cezaDurumu)>0)";
        
        ArrayList<Odunc> cikti=new ArrayList<Odunc>();
        
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
    
            
            int uyeNo=rs.getInt("uyeNo");
            String uyeAdı=rs.getString("uyeAdi");
            String uyeSoyadı=rs.getString("uyeSoyadi"); 
            int ceza=rs.getInt("SUM(cezaDurumu)");
            cikti.add(new Odunc(uyeNo, uyeAdı, uyeSoyadı, ceza));
            
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    
    
    public ArrayList<Odunc> emanetleriGetir(){
    String sorgu="SELECT * FROM kitaplar k INNER JOIN emanet e ON k.kitapID=e.kitapID INNER JOIN uyeler u ON u.uyeNo=e.uyeNo";
    
    ArrayList<Odunc> cikti=new ArrayList<Odunc>();
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
    int ceza=rs.getInt("cezaDurumu");
    int emanetNo=rs.getInt("emanetNo"); 
    int uyeNo=rs.getInt("uyeNo");
     String uyeAdı=rs.getString("uyeAdi");
     String uyeSoyadı=rs.getString("uyeSoyadi"); 
     int kitapId=rs.getInt("kitapID");
   String kitapAdi=rs.getString("kitapAdi");
     String emanetTrh=rs.getString("emanetTarihi");
     String zorunluTeslimTarihi=rs.getString("zorunluTeslimTarihi");
     String teslimTrh=rs.getString("teslimTarihi");
                if(teslimTrh.equals("null"))
                {
                    cezaHesapla(zorunluTeslimTarihi,emanetNo);
                }
     
     
     cikti.add(new Odunc(emanetNo, uyeNo, uyeAdı, uyeSoyadı, kitapId, kitapAdi, emanetTrh,zorunluTeslimTarihi, teslimTrh,ceza));
            
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            
            return null;
        }
        
    
    
    
    }
    public void kitapVer(int kitapId){
        String sorgu="UPDATE kitaplar SET varmi='false' where kitapID=? ";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,kitapId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void kitapAl(int kitapId){
        String sorgu="UPDATE kitaplar SET varmi='true' where kitapID=? ";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,kitapId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void emanetVer(int uyeId, int kitapId,String trh,String zorunlu_trh)
    {
        
       
       String sorgu="  INSERT INTO emanet (emanetTarihi,kitapID,uyeNo,zorunluTeslimTarihi) VALUES(?,?,?,?)";
       
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, trh);
            preparedStatement.setInt(2,kitapId);
            preparedStatement.setInt(3, uyeId);
            preparedStatement.setString(4,zorunlu_trh);
            preparedStatement.executeUpdate();
            kitapVer(kitapId);
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public  void emanetAl(String tarih,int emanetNo,int kitapID){
        String sorgu="UPDATE emanet SET teslimTarihi=?  where emanetNo=?";
        try {
            preparedStatement=con.prepareStatement(sorgu); 
            preparedStatement.setString(1,tarih);
            preparedStatement.setInt(2,emanetNo);
          
            preparedStatement.executeUpdate();
            kitapAl(kitapID);
        } catch (SQLException ex) {
            Logger.getLogger(OduncIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    
    
}
