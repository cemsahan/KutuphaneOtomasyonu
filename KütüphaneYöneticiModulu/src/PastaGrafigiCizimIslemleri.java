
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;


public class PastaGrafigiCizimIslemleri extends JPanel{
    
     GrafikIslemleri grafikIslemleri=new GrafikIslemleri();
    
     public PastaGrafigiCizimIslemleri() {
        setBackground(Color.white);
    }
    
     
      @Override
    public void paint(Graphics g) {
        
        super.paint(g); 
     
         ArrayList<Integer> kategori_aci=new ArrayList<>();
         ArrayList<Integer> kitap_aci=new ArrayList<>();

         
         
        ArrayList<Kategori> kategoriler=new ArrayList<>();
        kategoriler=grafikIslemleri.kategoriGetir();
        
        
        
        int kitapToplami=0;
        
        
        g.drawString("Kitap Sayısı-Kategori Pasta Grafiği ", 10, 10);
        g.drawString("Kitap Sayısı-Tarih Pasta Grafiği ", 10, 380);
        for(Kategori k: kategoriler){
            
          kitapToplami+=k.getKitapToplami();     //kaç tane kitap oldugunu buluyoruz
            
        }
        
        int aci=360/kitapToplami; //her bir kitaba kaç derecelik açı düşüyor onu buluyoruz
        double kategoribitisAcisi=0.0;  
        for(Kategori k :kategoriler){
            
           
        kategori_aci.add(aci*k.getKitapToplami());
       
        
        }
        
       
        
        int c=0;
        
      for(Kategori k:kategoriler){
           
        if(c%5==0 ) g.setColor(Color.black);
        else if(c%5==1) g.setColor(Color.red);
        else if(c%5==2) g.setColor(Color.blue);
        else if(c%5==3) g.setColor(Color.GREEN);
        else if(c%5==4) g.setColor(Color.red);
           
         g.fillArc(25, 25, 300,300, (int)kategoribitisAcisi,(int)kategori_aci.get(c)+3);
         
         kategoribitisAcisi+=kategori_aci.get(c);
        
          g.setColor(Color.GREEN);
          c++;
        }
      
       g.setColor(Color.black);
        
      
         ArrayList<Tarih> tarihler=new ArrayList<>();
        tarihler=grafikIslemleri.tarihGetir();
        
        
        
        
         
        
        
        
        double kitapbitisAcisi=0.0;
        for(Tarih t :tarihler){
            
            kitap_aci.add(aci*t.getToplamKitap());
        }
                
        int s=0;
        
      for(Tarih t:tarihler){
           
       if(s%5==0 ) g.setColor(Color.black);
        else if(s%5==1) g.setColor(Color.red);
        else if(s%5==2) g.setColor(Color.blue);
        else if(s%5==3) g.setColor(Color.GREEN);
        else if(s%5==4) g.setColor(Color.red);
         g.fillArc(25, 400, 300,300, (int)kitapbitisAcisi,(int)kitap_aci.get(s)+3);
         
         kitapbitisAcisi+=kitap_aci.get(s);
        
          g.setColor(Color.GREEN);
          s++;
        }
    }
    
    
}
