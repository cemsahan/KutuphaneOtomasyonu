
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class KategoriIslemleri extends yazarIslemleri{

   
    
    
    public boolean kategoriVarmı(String kategoriAdi){
        String sorgu="SELECT * FROM kategori WHERE kategoriAdi=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, kategoriAdi);
            
            
            ResultSet rs=preparedStatement.executeQuery();
            
                return rs.next();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
        
        
        
        
        
    }
    public int kategoriVarmiEkle(String kategoriAdi){
        
        boolean varmi=kategoriVarmı(kategoriAdi);
        if(varmi==false){
            String sorgu="INSERT INTO kategori(kategoriAdi) VALUES (?)";
            try {
                preparedStatement=con.prepareStatement(sorgu);
                preparedStatement.setString(1,kategoriAdi);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
           
           
            try {
                String sorgu1="SELECT * FROM kategori WHERE kategoriAdi="+"'"+kategoriAdi+"'";
                statement=con.createStatement();
                ResultSet rs=statement.executeQuery(sorgu1);
                while(rs.next()){
                 int id=rs.getInt("kategoriID");
                 return id;
                }
            } catch (SQLException ex) {
                Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
           
        return 0;
        
    }
    public ArrayList kategoriIdBul(int kitapID){
        String sorgu="SELECT kategoriID FROM kitap_kategori WHERE kitapID="+kitapID;
        ArrayList<Integer> idler=new ArrayList<>();
        try {
            statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            
            while(rs.next()){
                idler.add(rs.getInt("kategoriID"));
            }
            
            return idler;
            
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public String kategoriAdiBul(ArrayList<Integer> kategoriIdler){
        
        String kategoriler="";
        try {
            statement=con.createStatement();
         for(Integer idler:kategoriIdler)
        {
            String sorgu="SELECT * FROM kategori WHERE kategoriID="+idler;
            ResultSet rs=statement.executeQuery(sorgu);
            while(rs.next()){
                kategoriler+=rs.getString("kategoriAdi")+"-";
                
            }
            
        }
        return kategoriler;
        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
    }
    public void kategoriEkle(String[] kategoriler,int kitapId){
        
        for(String kategori:kategoriler){
            
        int kategoriId=kategoriVarmiEkle(kategori);
        
        String sorgu="INSERT INTO kitap_kategori(kitapID,kategoriID) VALUES (?,?)";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1, kitapId);
            preparedStatement.setInt(2, kategoriId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
    }
    public void kitap_kategoriSil(int kitapId){
        String sorgu="DELETE FROM kitap_kategori WHERE kitapID=?";
        try {
            preparedStatement=con.prepareStatement(sorgu);
            preparedStatement.setInt(1,kitapId);
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(KategoriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }

    

}
