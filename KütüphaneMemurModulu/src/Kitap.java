





public class Kitap {
    
    private int kitapID;
    private String kitapAdi;
    private String yayinTarihi;
    private String sayfaSayisi;
    private String kategori;
   private String yazarAdiSoyadi;
    

    public Kitap(int kitapID, String kitapAdi, String yayinTarihi, String sayfaSayisi, String kategori, String yazarAdiSoyadi) {
        this.kitapID = kitapID;
        this.kitapAdi = kitapAdi;
        this.yayinTarihi = yayinTarihi;
        this.sayfaSayisi = sayfaSayisi;
        this.kategori = kategori;
        this.yazarAdiSoyadi=yazarAdiSoyadi;
       
    }

    

    public int getKitapID() {
        return kitapID;
    }

    public void setKitapID(int kitapID) {
        this.kitapID = kitapID;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(String yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    public String getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(String sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getYazarAdiSoyadi() {
        return yazarAdiSoyadi;
    }

    public void setYazarAdiSoyadi(String yazarAdiSoyadi) {
        this.yazarAdiSoyadi = yazarAdiSoyadi;
    }

   
   
    
    
    
}
