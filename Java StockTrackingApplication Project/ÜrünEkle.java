
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ÜrünEkle {
    
    public ÜrünEkle() {
        
    }
    
    public void add( String ürünAdı, String çap, String kalınlık, String standart, String yoğunluk, String dönüşüm, String poliol, String izosiyanat) {
        
        String sql = "INSERT INTO `ürünler`(`Ürün Adı`,	`Çap`, `Et Kalınlığı`, `Üretim Standartı`, `Yoğunluk`, `Geri Dönüşüm`, `Poliol`, `İzosiyanat`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 	
    
        try ( Connection conn = DBConnection.getConnection();
              PreparedStatement stat = conn.prepareStatement(sql);) {
            stat.setString(1, ürünAdı);
            stat.setString(2, çap);
            stat.setString(3, kalınlık);
            stat.setString(4, standart);
            stat.setString(5, yoğunluk);
            stat.setString(6, dönüşüm);
            stat.setString(7, poliol);
            stat.setString(8, izosiyanat);
            
            stat.execute();
            
        } catch (Exception e) {
            
        }
    }
}
