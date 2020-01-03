
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sun.security.util.Length;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cem
 */
public class memurPaneli extends javax.swing.JFrame {
       
        DefaultTableModel tblKitapModel;
        DefaultTableModel tblDosyaKitapModel;
        DefaultTableModel OlanKitapModel;
        DefaultTableModel tblEmanetUyeModel;
        DefaultTableModel tblEmanetModel;
        DefaultTableModel tblCezaModel;
        KitapIslemleri kitapIslemleri=new KitapIslemleri();
        KategoriIslemleri kategoriIslemleri=new KategoriIslemleri();
        UyeIslemleri uyeIslemleri=new UyeIslemleri();
        OduncIslemleri emanetIslemleri=new OduncIslemleri();
        
    /**
     * Creates new form görevliEkrani
     */
    public memurPaneli() {
        initComponents();
        tblKitapModel=(DefaultTableModel)tbl_kitap.getModel();
        tblDosyaKitapModel=(DefaultTableModel)tbl_dostaKitap.getModel();
        tblEmanetModel=(DefaultTableModel)tbl_oduncEmanet.getModel();
        tblEmanetModel =(DefaultTableModel) tbl_oduncEmanet.getModel();
        
        OlanKitapModel=(DefaultTableModel)tbl_oduncKitap.getModel();
        tblEmanetUyeModel=(DefaultTableModel)tbl_oduncUye.getModel();
        tblCezaModel=(DefaultTableModel)tbl_ceza.getModel();
        olanKitapGoruntule();
        EmanetUyeGoruntule();
        kitapGoruntule();
        EmanetGoruntule();
        EmanetGoruntule();
        cezalilariGoruntule();
        
    }
        @SuppressWarnings("empty-statement")
    
        public void cezalilariGoruntule(){
        
          
         tblCezaModel.setRowCount(0);
        ArrayList<Odunc> cezalilar=new ArrayList<Odunc>();
           
        cezalilar=emanetIslemleri.cezalilariGetir();
        if (cezalilar!=null){
            
        for (Odunc emanet:cezalilar)
        {
        Object[] ekle={emanet.getUyeNo(),emanet.getUyeAdı(),emanet.getUyeSoyadı(),emanet.getCeza()+"TL BORÇLU"};
        tblCezaModel.addRow(ekle);
        }
            }
        
            
        }
        public void EmanetGoruntule(){
        tblEmanetModel.setRowCount(0);
        ArrayList<Odunc> emanetler=new ArrayList<Odunc>();
        emanetler=emanetIslemleri.emanetleriGetir();
        if (emanetler!=null){
        for (Odunc emanet:emanetler)
        {
        Object[] ekle={emanet.getEmanetNo(),emanet.getUyeNo(),emanet.getUyeAdı(),emanet.getUyeSoyadı(),emanet.getKitapId(),emanet.getKitapAdi(),emanet.getEmanetTrh(),emanet.getZorunluTeslimTarihi(),emanet.getTeslimTrh(),emanet.getCeza()+"TL BORÇLU"};
        tblEmanetModel.addRow(ekle);
        }
            }
        
        
        }
        public void EmanetUyeGoruntule(){
           
            
            tblEmanetUyeModel.setRowCount(0);
            ArrayList<Uyeler> uyeler=new ArrayList<Uyeler>();
            uyeler=uyeIslemleri.UyeleriGetir();
            if(uyeler!=null){
                for(Uyeler uye:uyeler){
                   
                    Object[] ekle={uye.getUyeNo(),uye.getUyeAdi(),uye.getUyeSoyad()};
                    
                    tblEmanetUyeModel.addRow(ekle);
                }
                
            }
            
            
            
            
            
        }
        public void olanKitapGoruntule(){
            OlanKitapModel.setRowCount(0);
            ArrayList<Kitap> olanKitaplar=new ArrayList<Kitap>();
            olanKitaplar=kitapIslemleri.kutuphanedeOlanKitaplariGetir();
            
            if(olanKitaplar!=null){
                for(Kitap kitap:olanKitaplar){
                    Object[] eklenecek={kitap.getKitapID(),kitap.getKitapAdi(),kitap.getKategori()};
                    OlanKitapModel.addRow(eklenecek);
                }
                
                
            }
            
            
        }
        public void kitapGoruntule(){
        
        tblKitapModel.setRowCount(0);
        tblDosyaKitapModel.setRowCount(0);
        
        ArrayList<Kitap> kitaplar=new ArrayList<Kitap>();
        
        kitaplar=kitapIslemleri.kitaplariGetir();
        
        if (kitaplar!=null) {
            for(Kitap kitap:kitaplar){
                Object[] satir = {kitap.getKitapID(),kitap.getKitapAdi(),kitap.getYayinTarihi(),kitap.getSayfaSayisi(),kitap.getKategori(),kitap.getYazarAdiSoyadi()};
                tblKitapModel.addRow(satir);
                tblDosyaKitapModel.addRow(satir);
                
            
            }
            
        }
            
    
   
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frm_memur = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_kitapAdi = new javax.swing.JTextField();
        tf_SayfaSayisi = new javax.swing.JTextField();
        tf_yazarAdSoyad = new javax.swing.JTextField();
        tf_YayinTrh = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kitap = new javax.swing.JTable();
        btn_kitapEkle = new javax.swing.JButton();
        btn_kitapSil = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_kitapAdet = new javax.swing.JTextField();
        tf_kategoriler = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        yazi_alani = new javax.swing.JTextArea();
        btn_dosyasec = new javax.swing.JButton();
        btn_dosyakaydet = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_dostaKitap = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_oduncUye = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_oduncKitap = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_oduncEmanet = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_teslimat = new javax.swing.JButton();
        tf_emanetAra = new javax.swing.JTextField();
        dt_zorunluTeslim = new com.toedter.calendar.JDateChooser();
        tf_kitapAra = new javax.swing.JTextField();
        tf_uyeAra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_ceza = new javax.swing.JTable();
        tf_ceza = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frm_memur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        frm_memur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frm_memurMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Kitap Adı:");

        jLabel2.setText("Yayın Yılı:");

        jLabel3.setText("Sayfa Sayısı:");

        jLabel4.setText("Kategori:");

        jLabel5.setText("Yazar Adı Soyadı:");

        tf_kitapAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kitapAdiActionPerformed(evt);
            }
        });

        tf_yazarAdSoyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_yazarAdSoyadActionPerformed(evt);
            }
        });

        tbl_kitap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap ID", "Kitap Adı", "Yayın Tarihi", "Sayfa Sayısı", "Kategori", "Yazarı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_kitap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kitapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kitap);

        btn_kitapEkle.setText("KİTAP EKLE");
        btn_kitapEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kitapEkleActionPerformed(evt);
            }
        });

        btn_kitapSil.setText("SEÇİLİ KİTABI SİL");
        btn_kitapSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kitapSilActionPerformed(evt);
            }
        });

        jLabel6.setText("(Birden fazla yazar için aralarına \",\" koyunuz)");

        jLabel9.setText("Eklenecek Kitap Sayısı:");

        tf_kitapAdet.setText("1");

        jLabel16.setText("(Birden fazla kategori için aralarına \",\" koyunuz)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_YayinTrh)
                            .addComponent(tf_SayfaSayisi)
                            .addComponent(tf_yazarAdSoyad)
                            .addComponent(tf_kategoriler)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_kitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_kitapAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btn_kitapEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(370, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_kitapSil, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_kitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kitapEkle))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_YayinTrh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_SayfaSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_kategoriler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_yazarAdSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_kitapAdet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_kitapSil)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        frm_memur.addTab("Kitap İşlemleri", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        yazi_alani.setColumns(20);
        yazi_alani.setRows(5);
        jScrollPane5.setViewportView(yazi_alani);

        btn_dosyasec.setText("DOSYA SEÇ");
        btn_dosyasec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dosyasecActionPerformed(evt);
            }
        });

        btn_dosyakaydet.setText("KAYDET");
        btn_dosyakaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dosyakaydetActionPerformed(evt);
            }
        });

        tbl_dostaKitap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap ID", "Kitap Adı", "Yayın Tarihi", "Sayfa Sayısı", "Kategori", "Yazarı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dostaKitap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dostaKitapMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_dostaKitap);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_dosyasec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dosyakaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(259, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_dosyasec)
                        .addGap(32, 32, 32)
                        .addComponent(btn_dosyakaydet)))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frm_memur.addTab("Dosyadan Kitap Ekle", jPanel1);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setText("Emanet verilecek üyeyi seçiniz:");

        tbl_oduncUye.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Üye No", "Üye Adı", "Üye Soyadı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_oduncUye);

        jLabel8.setText("Emanet verilecek kitabı seçiniz:");

        tbl_oduncKitap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kitap No", "Kitap Adı", "Kategorisi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_oduncKitap);

        tbl_oduncEmanet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emanet Numarası", "Üye No", "Üye Adı", "Üye Soyadı", "Kitap No", "Kitap Adı", "Emanet Tarihi", "Getirmesi Gereken Tarih", "Teslim Tarihi", "Ceza Durumu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_oduncEmanet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_oduncEmanetMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_oduncEmanet);

        jButton1.setText("EMANET VER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_teslimat.setText("EMANETİ TESLİM AL");
        btn_teslimat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_teslimatActionPerformed(evt);
            }
        });

        tf_emanetAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_emanetAraActionPerformed(evt);
            }
        });
        tf_emanetAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_emanetAraKeyReleased(evt);
            }
        });

        dt_zorunluTeslim.setDateFormatString("yyyy.MM.dd");

        tf_kitapAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_kitapAraKeyReleased(evt);
            }
        });

        tf_uyeAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_uyeAraKeyReleased(evt);
            }
        });

        jLabel10.setText("Ara:");

        jLabel13.setText("Getirmesi Gereken Tarih:");

        jLabel14.setText("Ara:");

        jLabel15.setText("Ara:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_uyeAra, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(49, 49, 49))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_kitapAra, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(dt_zorunluTeslim, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 424, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(tf_emanetAra, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_teslimat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_uyeAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(tf_kitapAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_teslimat)
                            .addComponent(tf_emanetAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dt_zorunluTeslim, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 296, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        frm_memur.addTab("Emanet İşlemleri", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        tbl_ceza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Üye ID", "Üye Adı", "Üye Soyadı", "Ceza Durumu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbl_ceza);

        tf_ceza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cezaKeyReleased(evt);
            }
        });

        jLabel11.setText("Ara:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Borçlular");

        jButton2.setText("Borcu Sil");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(tf_ceza, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ceza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        frm_memur.addTab("Borçlu İşlemleri", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frm_memur, javax.swing.GroupLayout.PREFERRED_SIZE, 1083, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(frm_memur, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(463, 463, 463))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_kitapAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kitapAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kitapAdiActionPerformed

    private void tf_yazarAdSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_yazarAdSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_yazarAdSoyadActionPerformed
   
    
    private void btn_kitapEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kitapEkleActionPerformed
        if(tf_kitapAdi.getText().equals("")|| tf_SayfaSayisi.getText().equals("")|| tf_YayinTrh.getText().equals("") || tf_kitapAdet.getText().equals("") || tf_yazarAdSoyad.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Lütfen boş alanları doldurunuz");
        }

        else{
        String kitapAd=tf_kitapAdi.getText();
        String yayinTrh=tf_YayinTrh.getText();
        String sayfaSayisi=tf_SayfaSayisi.getText();
        String[] kategoriler=tf_kategoriler.getText().split(",");
        String[] yazarlar=tf_yazarAdSoyad.getText().split(",");
        int adet=Integer.parseInt(tf_kitapAdet.getText());
        for(int i=1;i<=adet;i++){
        kitapIslemleri.kitapEkle(kitapAd, yayinTrh, sayfaSayisi, kategoriler, yazarlar);
        }
        kitapGoruntule();
        }
        
    }//GEN-LAST:event_btn_kitapEkleActionPerformed

    private void tbl_kitapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kitapMouseClicked
       int selectedRow=tbl_kitap.getSelectedRow();
       tf_kategoriler.setText(tblKitapModel.getValueAt(selectedRow, 4).toString());
       tf_kitapAdi.setText(tblKitapModel.getValueAt(selectedRow, 1).toString());
       tf_YayinTrh.setText(tblKitapModel.getValueAt(selectedRow, 2).toString());
       tf_SayfaSayisi.setText(tblKitapModel.getValueAt(selectedRow, 3).toString());
       tf_yazarAdSoyad.setText(tblKitapModel.getValueAt(selectedRow, 5).toString());
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_tbl_kitapMouseClicked

    private void btn_kitapSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kitapSilActionPerformed
        int selectedRow=tbl_kitap.getSelectedRow();
        if(selectedRow==-1){
            
            if(tblKitapModel.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null, "Kitap tablosu şu anda boş...");
            }
            else {
                JOptionPane.showMessageDialog(null, "Lütfen silinecek kitabı seçiniz...");
            }
        }
        else {
        int kitapId=(int)tblKitapModel.getValueAt(selectedRow, 0);
        
        kitapIslemleri.kitapSil(kitapId);
        kitapGoruntule();
        JOptionPane.showMessageDialog(null, "Kitap başarıyla silindi...");
        
        }






    }//GEN-LAST:event_btn_kitapSilActionPerformed

    private void frm_memurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frm_memurMouseClicked
        olanKitapGoruntule();
    }//GEN-LAST:event_frm_memurMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        Date simdikiZaman=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        String tarih=df.format(new Date());
        String zorunluTeslimTarihi =df.format(dt_zorunluTeslim.getDate());
        
        int secilikitap=tbl_oduncKitap.getSelectedRow();
        int seciliUye=tbl_oduncUye.getSelectedRow();
        int uyeId=Integer.parseInt(tbl_oduncUye.getValueAt(seciliUye, 0).toString());
       
        int kitapId=(int)tbl_oduncKitap.getValueAt(secilikitap,0);
        
        emanetIslemleri.emanetVer(uyeId,kitapId,tarih,zorunluTeslimTarihi);
        JOptionPane.showMessageDialog(null,"Emanet verildi.");
        EmanetGoruntule();
        EmanetGoruntule();
        olanKitapGoruntule();
        cezalilariGoruntule();
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_teslimatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_teslimatActionPerformed
        Date simdikiZaman=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        String tarih=df.format(new Date());
        int seciliEmanet=tbl_oduncEmanet.getSelectedRow();
        int emanetNo=(int)tbl_oduncEmanet.getValueAt(seciliEmanet,0);
        int kitapId=(int)tbl_oduncEmanet.getValueAt(seciliEmanet, 4);
        emanetIslemleri.emanetAl(tarih, emanetNo, kitapId);
        EmanetGoruntule();
        olanKitapGoruntule();
        JOptionPane.showMessageDialog(null,"teslim alındı");
    }//GEN-LAST:event_btn_teslimatActionPerformed
public void dinamikAra(String ara){
    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(tblEmanetModel);
    tbl_oduncEmanet.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(ara));
}
    private void tf_emanetAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_emanetAraKeyReleased
        // TODO add your handling code here:
        String ara=tf_emanetAra.getText();
        dinamikAra(ara);
        
    }//GEN-LAST:event_tf_emanetAraKeyReleased

    private void btn_dosyasecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dosyasecActionPerformed
    
        JFileChooser fc =new JFileChooser();
    
    int i=fc.showOpenDialog(this);
    if(i==JFileChooser.APPROVE_OPTION){
        File file=fc.getSelectedFile();
        try(Scanner scanner=new Scanner(new BufferedReader(new FileReader(file)))){
            String icerik="";
            while(scanner.hasNextLine()){
                icerik+=scanner.nextLine()+"\n";
                
            }
            yazi_alani.setText(icerik);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(memurPaneli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_btn_dosyasecActionPerformed

    private void btn_dosyakaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dosyakaydetActionPerformed
if(yazi_alani.getText().equals("")){
    JOptionPane.showMessageDialog(null, "Dosya seçiniz");
}       
else{ String[] line=yazi_alani.getText().split("-");
       
       for (String l : line) 
       {
           
       String[] dizi=l.split(",");
       String kitapAdi=dizi[0];
       String yayinTarihi=dizi[1];
       String sayfaSayisi=dizi[2];
       String[] kategori={dizi[3]};
       String[] yazarlar={dizi[4]};
       
     
       kitapIslemleri.kitapEkle(kitapAdi, yayinTarihi, sayfaSayisi,kategori, yazarlar);
      }
           
             kitapGoruntule();
             JOptionPane.showMessageDialog(null,"Dosyadaki kitaplar eklendi");
}                              
    }//GEN-LAST:event_btn_dosyakaydetActionPerformed

    private void tbl_oduncEmanetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_oduncEmanetMouseClicked
       
    }//GEN-LAST:event_tbl_oduncEmanetMouseClicked

    private void tf_emanetAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_emanetAraActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tf_emanetAraActionPerformed

    private void tf_kitapAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_kitapAraKeyReleased

        
        
        String ara=tf_kitapAra.getText();
        dinamikAra2(ara);
        
        
        
        
        
    }//GEN-LAST:event_tf_kitapAraKeyReleased

    private void tf_uyeAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_uyeAraKeyReleased
        
        String ara=tf_uyeAra.getText();
        dinamikAra3(ara);
        
        
        
    }//GEN-LAST:event_tf_uyeAraKeyReleased

    private void tf_cezaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cezaKeyReleased
        String ara=tf_ceza.getText();
        dinamikAra4(ara);
        
    }//GEN-LAST:event_tf_cezaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow=tbl_ceza.getSelectedRow();
        if(selectedRow==-1){

            if(tblCezaModel.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(this, "Cezalılar tablosu şu anda boş...");
            }
            else {
                JOptionPane.showMessageDialog(null, "Lütfen güncellenecek Cezalıyı seçiniz...");
            }
        }
        else {
            int uyeNo=(int)tbl_ceza.getValueAt(selectedRow, 0);
            emanetIslemleri.cezaliSil(uyeNo);
            JOptionPane.showMessageDialog(null, "Seçilen üyenin borcu silindi");
            cezalilariGoruntule();
            EmanetUyeGoruntule();
            EmanetGoruntule();
            
            
            

        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_dostaKitapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dostaKitapMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_dostaKitapMouseClicked
public void dinamikAra4(String ara){
    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(tblCezaModel);
    tbl_oduncUye.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(ara));
}
    public void dinamikAra3(String ara){
    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(tblEmanetUyeModel);
    tbl_oduncUye.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(ara));
}
    public void dinamikAra2(String ara){
    TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(OlanKitapModel);
    tbl_oduncKitap.setRowSorter(tr);
    tr.setRowFilter(RowFilter.regexFilter(ara));
}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(memurPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memurPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memurPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memurPaneli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memurPaneli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dosyakaydet;
    private javax.swing.JButton btn_dosyasec;
    private javax.swing.JButton btn_kitapEkle;
    private javax.swing.JButton btn_kitapSil;
    private javax.swing.JButton btn_teslimat;
    private com.toedter.calendar.JDateChooser dt_zorunluTeslim;
    private javax.swing.JTabbedPane frm_memur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tbl_ceza;
    private javax.swing.JTable tbl_dostaKitap;
    private javax.swing.JTable tbl_kitap;
    private javax.swing.JTable tbl_oduncEmanet;
    private javax.swing.JTable tbl_oduncKitap;
    private javax.swing.JTable tbl_oduncUye;
    private javax.swing.JTextField tf_SayfaSayisi;
    private javax.swing.JTextField tf_YayinTrh;
    private javax.swing.JTextField tf_ceza;
    private javax.swing.JTextField tf_emanetAra;
    private javax.swing.JTextField tf_kategoriler;
    private javax.swing.JTextField tf_kitapAdet;
    private javax.swing.JTextField tf_kitapAdi;
    private javax.swing.JTextField tf_kitapAra;
    private javax.swing.JTextField tf_uyeAra;
    private javax.swing.JTextField tf_yazarAdSoyad;
    private javax.swing.JTextArea yazi_alani;
    // End of variables declaration//GEN-END:variables

    
}
