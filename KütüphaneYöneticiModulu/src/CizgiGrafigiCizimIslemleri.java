
import com.sun.org.apache.xpath.internal.operations.Gt;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CizgiGrafigiCizimIslemleri extends JPanel{
 
    
    GrafikIslemleri grafikIslemleri=new GrafikIslemleri();
    
    public CizgiGrafigiCizimIslemleri() {
        setBackground(Color.white);
    }
    
    @Override
    public void paint(Graphics g) {
        
        super.paint(g); 
         ArrayList<Integer> ktgx=new ArrayList<>();
         ArrayList<Integer> ktgy=new ArrayList<>();
        
         
         g.drawString("Ödünç verilen kitap sayısı-kategori grafiği", 50, 30);
         g.drawString("Kitap Sayısı", 60, 60);
        ArrayList<Kategori> kategoriler=new ArrayList<>();
        kategoriler=grafikIslemleri.kategoriGetir();
        
        
        
      
        int i=0;
        
        
        for(Kategori k: kategoriler){
            
           
            
            g.fillOval(95+i, 245-((int)k.getKitapToplami())*20 , 10, 10);
            
            g.drawString(k.getKategoriAdi(), 90+i, 260);
             
            g.drawString(k.getKitapToplami()+"", 40, 250-((int)k.getKitapToplami())*20);
            
          
            
           ktgx.add(100+i);
           
          ktgy.add( 250-((int)k.getKitapToplami())*20);
            
          i+=100;
        }
      
        g.drawLine(50, 50,50, 250);
        g.drawLine(50, 250, ktgx.get(ktgx.size()-1)+50, 250);
       g.drawString("Kategori", ktgx.get(ktgx.size()-1)+30 , 270);
        
         
        
        
        
        
         g.drawLine(50, 250, ktgx.get(0), ktgy.get(0));
         int j=0;
         for(j=0;j<(kategoriler.size()-1);j++){
            
           g.drawLine(ktgx.get(j), ktgy.get(j), ktgx.get(j+1), ktgy.get(j+1));
            
        }
        
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         ArrayList<Integer> xTrh=new ArrayList<>();
         ArrayList<Integer> yTrh=new ArrayList<>();
         
         
         g.drawString("Tarih-Kitap Sayısı Grafiği", 50, 300);
         g.drawString("Kitap Sayısı", 60, 330);
        ArrayList<Tarih> tarihler=new ArrayList<>();
        tarihler=grafikIslemleri.tarihGetir();
        
        
        
        
        
        
        
        
        
        
        
        int l=0;
        
        
        for(Tarih t: tarihler){
            
            g.fillOval(95+l, 545-((int)t.getToplamKitap())*20 , 10, 10);
            
            g.drawString(t.getEmanetTarihi(), 90+l, 560);
             
            g.drawString(t.getToplamKitap()+"", 40, 550-((int)t.getToplamKitap())*20);
            
          
            
            xTrh.add(100+l);
           
           yTrh.add( 550-((int)t.getToplamKitap()*20));
            
          l+=100;
        }
        
       
        
        g.drawLine(50, 350,50, 550);
        g.drawLine(50, 550, xTrh.get(xTrh.size()-1)+50, 550);
        g.drawString("Tarih", xTrh.get(xTrh.size()-1)+70, 560);
        
         
         g.drawLine(50, 550, xTrh.get(0), yTrh.get(0));
         
         int m=0;
         for( m=0;m<(tarihler.size()-1);m++){
            
            g.drawLine(xTrh.get(m), yTrh.get(m), xTrh.get(m+1), yTrh.get(m+1));
            
        }
         
                
        
        
      
    }
    
}



















