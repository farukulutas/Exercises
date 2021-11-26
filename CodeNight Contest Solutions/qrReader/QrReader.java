package qrReader;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class QrReader
{
	public static void main(String[] args) throws IOException {
		String qrurl = "https://lh3.googleusercontent.com/ZCs07d0uFct1qMOfnVtsU8PebvM7kLw4Pl6mb0BEXHRrC_UTJAAW9JUnZMpXRgA5jtmPiXEsgz0h5f9wswXqSUmG3PEQ0lscuTZnW53Ga6Tvll3b7ki1r5MHoPu4einQ4g=w320";
        String qrdecodedurl = "https://zxing.org/w/decode?u=" + qrurl;
        
        URL url = new URL(qrdecodedurl);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer buffer = new StringBuffer();
        while(sc.hasNext()) {
        	buffer.append(sc.next() + " ");
        }
      
        String result = buffer.toString();
        
        int index = result.indexOf("<pre>");
        int endindex = result.indexOf("</pre>");
        result = result.substring( index + 5, endindex);
        
        result = result
                .replaceAll("Ä°", "Ý")
                .replaceAll("ÅŸ", "þ");
        
        System.out.println(result);
        
	}
}