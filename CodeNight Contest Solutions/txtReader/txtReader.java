package txtReader;

import java.io.*; 

public class txtReader {

	public static int ka�Kelime( String s ) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if ( i > 2 ) {
				if ( ( s.charAt(i) == ' ') && ( s.charAt(i - 2) != ' ' ) ) {
            		count++;
            	}
			}
        }
		
		return count;
	}
	
	public static int ka�Karakter( String s ) {
		int count = 0;
		
		s = s.replaceAll("\\s+", "");
		count = s.length();
		
		return count;
	}
	
	public static int ka�C�mle( String s ) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
				if ( s.charAt( i) == '!' || s.charAt( i) == '.' ) {
            		count++;
            	}
        }
		
		return count;
	}
	
    public static void main(String []args) {
        String path = "C:\\Users\\Faruk\\Downloads\\Genclige_Hitabe.txt";
        String st = bufferReaderMethod( path );
        System.out.println( st);
        System.out.println( "Kelime say�s�: " + ka�Kelime( st) + "\nKarakter say�s�: " + ka�Karakter( st) + "\nC�mle Say�s�: " + ka�C�mle( st) );
	}
    
    public static String bufferReaderMethod(String filePath) 
    {
        StringBuilder builder;
        
        builder = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        	String line;
            
            while (( line = br.readLine()) != null) {
            	builder.append( line).append( "\n");
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}