/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cem
 */
public class Odunc {
    private int emanetNo; 
    private int uyeNo;
    private String uyeAdı;
    private String uyeSoyadı; 
    private int kitapId;
    private String kitapAdi;
    private String emanetTrh;
    private String zorunluTeslimTarihi;
    private String teslimTrh;
    private int ceza;
    public Odunc(int uyeNo, String uyeAdı, String uyeSoyadı, int ceza) {
        this.uyeNo = uyeNo;
        this.uyeAdı = uyeAdı;
        this.uyeSoyadı = uyeSoyadı;
        this.ceza = ceza;
    }
    

    public Odunc(int emanetNo, int uyeNo, String uyeAdı, String uyeSoyadı, int kitapId, String kitapAdi, String emanetTrh, String zorunluTeslimTarihi, String teslimTrh,int ceza) {
        this.emanetNo = emanetNo;
        this.uyeNo = uyeNo;
        this.uyeAdı = uyeAdı;
        this.uyeSoyadı = uyeSoyadı;
        this.kitapId = kitapId;
        this.kitapAdi = kitapAdi;
        this.emanetTrh = emanetTrh;
        this.zorunluTeslimTarihi = zorunluTeslimTarihi;
        this.teslimTrh = teslimTrh;
        this.ceza=ceza;
    }

    public int getCeza() {
        return ceza;
    }

    public void setCeza(int ceza) {
        this.ceza = ceza;
    }

    public int getEmanetNo() {
        return emanetNo;
    }

    public void setEmanetNo(int emanetNo) {
        this.emanetNo = emanetNo;
    }

    public int getUyeNo() {
        return uyeNo;
    }

    public void setUyeNo(int uyeNo) {
        this.uyeNo = uyeNo;
    }

    public String getUyeAdı() {
        return uyeAdı;
    }

    public void setUyeAdı(String uyeAdı) {
        this.uyeAdı = uyeAdı;
    }

    public String getUyeSoyadı() {
        return uyeSoyadı;
    }

    public void setUyeSoyadı(String uyeSoyadı) {
        this.uyeSoyadı = uyeSoyadı;
    }

    public int getKitapId() {
        return kitapId;
    }

    public void setKitapId(int kitapId) {
        this.kitapId = kitapId;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getEmanetTrh() {
        return emanetTrh;
    }

    public void setEmanetTrh(String emanetTrh) {
        this.emanetTrh = emanetTrh;
    }

    public String getZorunluTeslimTarihi() {
        return zorunluTeslimTarihi;
    }

    public void setZorunluTeslimTarihi(String zorunluTeslimTarihi) {
        this.zorunluTeslimTarihi = zorunluTeslimTarihi;
    }

    public String getTeslimTrh() {
        return teslimTrh;
    }

    public void setTeslimTrh(String teslimTrh) {
        this.teslimTrh = teslimTrh;
    }

   
   
    
    
    
    
}
