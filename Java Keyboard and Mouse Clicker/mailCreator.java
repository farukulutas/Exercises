package mailCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Scanner;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mailCreator extends MouseAdapter implements MouseListener {
	public static String createRandomNames() throws IOException {
		// Name generator website url
		String generatorUrl = "https://www.name-generator.org.uk/quick/";
        
		// append everything inside url to buffer
        URL url = new URL(generatorUrl);
        Scanner sc = new Scanner(url.openStream());
        StringBuffer buffer = new StringBuffer();
        while(sc.hasNext()) {
        	buffer.append(sc.next() + " ");
        }
      
        // get url infos to result string
        String result = buffer.toString();
        
        // get only the random name, delete other texts
        int index = result.indexOf("Random Names</h2><div class=\"name_heading\">");
        int endindex = result.indexOf("</div><div class=\"name_heading\">");
        result = result.substring( index + 43, endindex);
        
        // replace unknown chars if any
        result = result
                .replaceAll("Ä°", "Ý")
                .replaceAll("ÅŸ", "þ");
        
        // print & return result
        System.out.println(result);
        return result;
	}

	public void mouseClicked(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
	    int x=e.getX();
	    int y=e.getY();
	    System.out.println(p.x+","+p.y);//these co-ords are relative to the component
	}
	
	public static void keyboardPress( char letter) {
		Robot robo;
		try {
			robo = new Robot();
			if ( letter == 'a')
				robo.keyPress(KeyEvent.VK_A);
			else if ( letter == 'b')
				robo.keyPress(KeyEvent.VK_B);
			else if ( letter == 'c')
				robo.keyPress(KeyEvent.VK_C);
			else if ( letter == 'd')
				robo.keyPress(KeyEvent.VK_D);
			else if ( letter == 'e')
				robo.keyPress(KeyEvent.VK_E);
			else if ( letter == 'f')
				robo.keyPress(KeyEvent.VK_F);
			else if ( letter == 'g')
				robo.keyPress(KeyEvent.VK_G);
			else if ( letter == 'h')
				robo.keyPress(KeyEvent.VK_H);
			else if ( letter == 'i')
				robo.keyPress(KeyEvent.VK_I);
			else if ( letter == 'j')
				robo.keyPress(KeyEvent.VK_J);
			else if ( letter == 'k')
				robo.keyPress(KeyEvent.VK_K);
			else if ( letter == 'l')
				robo.keyPress(KeyEvent.VK_L);
			else if ( letter == 'm')
				robo.keyPress(KeyEvent.VK_M);
			else if ( letter == 'n')
				robo.keyPress(KeyEvent.VK_N);
			else if ( letter == 'o')
				robo.keyPress(KeyEvent.VK_O);
			else if ( letter == 'p')
				robo.keyPress(KeyEvent.VK_P);
			else if ( letter == 'q')
				robo.keyPress(KeyEvent.VK_Q);
			else if ( letter == 'r')
				robo.keyPress(KeyEvent.VK_R);
			else if ( letter == 's')
				robo.keyPress(KeyEvent.VK_S);
			else if ( letter == 't')
				robo.keyPress(KeyEvent.VK_T);
			else if ( letter == 'u')
				robo.keyPress(KeyEvent.VK_U);
			else if ( letter == 'v')
				robo.keyPress(KeyEvent.VK_V);
			else if ( letter == 'x')
				robo.keyPress(KeyEvent.VK_X);
			else if ( letter == 'y')
				robo.keyPress(KeyEvent.VK_Y);
			else if ( letter == '0')
				robo.keyPress(KeyEvent.VK_0);
			else if ( letter == '1')
				robo.keyPress(KeyEvent.VK_1);
			else if ( letter == '2')
				robo.keyPress(KeyEvent.VK_2);
			else if ( letter == '3')
				robo.keyPress(KeyEvent.VK_3);
			else if ( letter == '4')
				robo.keyPress(KeyEvent.VK_4);
			else if ( letter == '5')
				robo.keyPress(KeyEvent.VK_5);
			else if ( letter == '6')
				robo.keyPress(KeyEvent.VK_6);
			else if ( letter == '7')
				robo.keyPress(KeyEvent.VK_7);
			else if ( letter == '8')
				robo.keyPress(KeyEvent.VK_8);
			else if ( letter == '9')
				robo.keyPress(KeyEvent.VK_9);
			else
				robo.keyPress(KeyEvent.VK_Z);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int x, y;
		String name, firstName, lastName, password, year, file;
		
		if ( a == 1 ) {
			for (int i = 0; i < 4; i++) {
				x = MouseInfo.getPointerInfo().getLocation().x;
				y = MouseInfo.getPointerInfo().getLocation().y;
				System.out.println(x + ", " + y);
				Thread.sleep(5000);
			}
		}
		else {
			// get 1 random name
			name = createRandomNames();
			name.toLowerCase();
			int index = name.lastIndexOf(' ');
			firstName = name.substring(0, index);
			lastName  = name.substring(index + 1);
			password = "password";
			year = "1990";
			file = "C:\\Users\\Faruk\\Desktop\\mails.txt";
			
			try {
				while (true) {
					Robot r = new Robot();
					int button = InputEvent.BUTTON1_MASK;
					
					r.mouseMove(660, 440);
					r.mousePress(button);
					r.mouseRelease(button);
					//enter name
					for ( int j = 0; j < name.length(); j++ ) {
						keyboardPress(name.charAt(j));
					}
					
					Thread.sleep(1000);
					r.mouseMove(867, 700);
					r.mousePress(button);
					r.mouseRelease(button);
					r.mouseMove(642, 527);
					r.mousePress(button);
					r.mouseRelease(button);
					//enter password
					for ( int k = 0; k < password.length(); k++ ) {
						keyboardPress(password.charAt(k));
					}
					
					r.mouseMove(878, 802);
					r.mousePress(button);
					r.mouseMove(612, 609);
					r.mousePress(button);
					//enter name
					for ( int l = 0; l < firstName.length(); l++ ) {
						keyboardPress(firstName.charAt(l));
					}
					
					r.mouseMove(622, 678);
					r.mousePress(button);
					//enter last name
					for ( int m = 0; m < lastName.length(); m++ ) {
						keyboardPress(lastName.charAt(m));
					}
					
					r.mouseMove(886, 750);
					r.mousePress(button);
					
					r.mouseMove(618, 710);
					r.mousePress(button);
					r.mouseMove(789, 626);
					r.mousePress(button);
					r.mouseMove(933, 715);
					r.mousePress(button);
					r.mouseMove(922, 627);
					r.mousePress(button);
					r.mouseMove(846, 714);
					r.mousePress(button);
					// enter year
					for ( int n = 0; n < year.length(); n++ ) {
						keyboardPress(year.charAt(n));
					}
					
					r.mouseMove(1098, 780);
					r.mousePress(button);
					r.mouseMove(1055, 713);
					r.mousePress(button);
					//recaptcha
					Thread.sleep(1000*60);
					r.mouseMove(769, 712);
					r.mousePress(button);
					r.mouseMove(671, 537);
					r.mousePress(button);
					
					Writer output;
					output = new BufferedWriter(new FileWriter(file, true));  //clears file every time
					output.append(name + "@outlook.com ");
					output.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}