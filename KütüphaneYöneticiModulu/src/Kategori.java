public class Kategori {
   
    private int kitapToplami;
    private String kategoriAdi;

    public Kategori(int kitapToplami, String kategoriAdi) {
        this.kitapToplami = kitapToplami;
        this.kategoriAdi = kategoriAdi;
    }

    public int getKitapToplami() {
        return kitapToplami;
    }

    public void setKitapToplami(int kitapToplami) {
        this.kitapToplami = kitapToplami;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    
}
