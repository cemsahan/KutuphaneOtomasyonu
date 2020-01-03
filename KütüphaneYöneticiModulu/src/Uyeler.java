
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Uyeler {
    private int uyeNo;
    private String uyeAdi;
    private String uyeSoyad;
    private String tel;
    private String email;
    private String cinsiyet; 
    private String parola;
    private String sehir;
    private String ilce;
    private String mahalle;
    private String sokak;
    private String binaNo;
    private String daireNo;
    private String postaKodu;
    
    
    public Uyeler() {
       
        
    }
    
    
    
    public int getUyeNo() {
        return uyeNo;
    }

    public void setUyeNo(int uyeNo) {
        this.uyeNo = uyeNo;
    }

    public String getUyeAdi() {
        return uyeAdi;
    }

    public void setUyeAdi(String uyeAdi) {
        this.uyeAdi = uyeAdi;
    }

    public String getUyeSoyad() {
        return uyeSoyad;
    }

    public void setUyeSoyad(String uyeSoyad) {
        this.uyeSoyad = uyeSoyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    

    public String getBinaNo() {
        return binaNo;
    }

    public void setBinaNo(String binaNo) {
        this.binaNo = binaNo;
    }

    public String getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(String postaKodu) {
        this.postaKodu = postaKodu;
    }

    public Uyeler(int uyeNo, String uyeAdi, String uyeSoyad, String tel, String email, String cinsiyet,String parola, String sehir, String ilce, String mahalle, String sokak, String binaNo,String daireNo, String postaKodu) {
        this.uyeNo = uyeNo;
        this.uyeAdi = uyeAdi;
        this.uyeSoyad = uyeSoyad;
        this.tel = tel;
        this.email = email;
        this.cinsiyet = cinsiyet;
        this.sehir = sehir;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.sokak = sokak;
        this.binaNo = binaNo;
        this.daireNo=daireNo;
        this.postaKodu = postaKodu;
        this.parola=parola;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public String getDaireNo() {
        return daireNo;
    }

    public void setDaireNo(String daireNo) {
        this.daireNo = daireNo;
    }

    /**
     * @return the parola
     */
    public String getParola() {
        return parola;
    }

    /**
     * @param parola the parola to set
     */
    public void setParola(String parola) {
        this.parola = parola;
    }

    

    
    
    
    
    
    
    
    
}
