
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ürünler {
    public static void getÜrünler( ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();
            
            buffer.append(rs.getString("Ürün Adı"));
            buffer.append(" " + rs.getString("Çap"));
            buffer.append(" " + rs.getString("Et Kalınlığı"));
            buffer.append(" " + rs.getString("Üretim Standartı"));
            buffer.append(" " + rs.getString("Yoğunluk"));
            buffer.append(" " + rs.getString("Geri Dönüşüm"));
            buffer.append(" " + rs.getString("Poliol"));
            buffer.append(" " + rs.getString("İzosiyanat"));
        
            System.out.println(buffer.toString());
        }
    }
}
