
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UyeIslemleri extends Baglan{

    
    public ArrayList<Uyeler> uyeleriGetir(){
        
        ArrayList<Uyeler> cikti=new ArrayList<Uyeler>();
        
        //,sehir,ilce,mahalle,cadde,binaNo,postaKodu
        try {
            statement=con.createStatement();
            String sorgu="SELECT * "
                    + "FROM uyeler, adresler "
                    + "WHERE uyeler.adresNo=adresler.adresNo";
            
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next())
            {
                int  uyeNo=rs.getInt("uyeNo");
                String uyeAdi=rs.getString("uyeAdi");
                String uyeSoyadi=rs.getString("uyeSoyadi");
                String tel=rs.getString("tel");
                String email=rs.getString("email");
                String cinsiyet=rs.getString("cinsiyet");
                String parola =rs.getString("parola");
                String il=rs.getString("sehir");
                String ilce=rs.getString("ilce");
                String mahalle=rs.getString("mahalle");
                String sokak=rs.getString("sokak");
                String binaNo=rs.getString("binaNo");
                String daireNo=rs.getString("daireNo");
                String postaKodu=rs.getString("postaKodu");
                cikti.add(new Uyeler(uyeNo, uyeAdi, uyeSoyadi, tel, email, cinsiyet, parola, il, ilce, mahalle, sokak, binaNo, daireNo ,postaKodu));
               
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            
            
            return null;
        
        }
        
    }
    
    public void adresEkle(String il,String ilce,String mahalle,String sokak,String binaNo,String daireNo ,String postaKodu)
    {
         try {
            String sorgu="INSERT INTO adresler (sehir,ilce,mahalle,sokak,binaNo,daireNo,postaKodu) VALUES (?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, il);
            preparedStatement.setString(2, ilce);
            preparedStatement.setString(3, mahalle);
            preparedStatement.setString(4, sokak);
            preparedStatement.setString(5, binaNo);
            preparedStatement.setString(6, daireNo);
            preparedStatement.setString(7, postaKodu);
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public int adresNo(){
        
        try{
         String sorgu3="SELECT MAX(adresNo) FROM adresler";
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu3);
            int no;
            while(rs.next()){
                no=rs.getInt(1);
            return no;
            }
            
            return 0;
        
        } 
        catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        
        
    }
    public void uyeEkle(String uyeAdi,String  uyeSoyadi,String parola,String tel,String email,String cinsiyet)
    {
        
            
        try {
            String sorgu1="INSERT INTO uyeler (uyeAdi,uyeSoyadi,tel,email,cinsiyet,parola,adresNo) VALUES (?,?,?,?,?,?,?)";
            preparedStatement=con.prepareStatement(sorgu1);
            preparedStatement.setString(1, uyeAdi);
            preparedStatement.setString(2, uyeSoyadi);
            preparedStatement.setString(3, tel);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, cinsiyet);
            preparedStatement.setString(6, parola);
            preparedStatement.setInt(7,adresNo());
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void uyeGuncelle(String uyeAdi,String  uyeSoyadi,String parola,String tel,String email,String cinsiyet,int uyeNo){
        String sorgu="UPDATE uyeler SET uyeAdi=? , uyeSoyadi=? , tel=? , email=? , cinsiyet=? , parola=? WHERE uyeNo=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, uyeAdi);
            preparedStatement.setString(2, uyeSoyadi);
            preparedStatement.setString(3, tel);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, cinsiyet);
            preparedStatement.setString(6, parola);
            preparedStatement.setInt(7, uyeNo);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int adresBul(int uyeNo){
        try{
            
            String sorgu="SELECT adresNo FROM uyeler WHERE uyeNo="+uyeNo;
            
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            
            int no;
            while(rs.next()){
            no=rs.getInt(1);
            return no;
            }
            
            return 0;
        
        } 
        catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    public void adresSil(int adresNo){
        String sorgu="DELETE FROM adresler WHERE adresNo=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, adresNo);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void uyeSil(int uyeNo){
        int a=adresBul(uyeNo);
        String sorgu="DELETE FROM uyeler WHERE uyeNo=?";
        
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, uyeNo);
            preparedStatement.executeUpdate();
            adresSil(a);    
            JOptionPane.showMessageDialog(null, "Üye başarıyla silindi...");
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Seçili Üyede Emanet kitap Var Silinemez");
        }
        
                
        
        
        
        
    }
    public void adresGuncelle(String il,String ilce,String mahalle,String sokak,String binaNo,String daireNo ,String postaKodu,int uyeNo){
        String sorgu="UPDATE adresler SET sehir=? , ilce=? , mahalle=? , sokak=? , binaNo=? , daireNo=? , postaKodu=? WHERE adresNo=? ";
            
         try {
            
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setString(1, il);
            preparedStatement.setString(2, ilce);
            preparedStatement.setString(3, mahalle);
            preparedStatement.setString(4, sokak);
            preparedStatement.setString(5, binaNo);
            preparedStatement.setString(6, daireNo);
            preparedStatement.setString(7, postaKodu);
            preparedStatement.setInt(8, adresBul(uyeNo));
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }
    
}
