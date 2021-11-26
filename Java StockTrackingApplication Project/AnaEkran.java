import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AnaEkran {
        
	private JFrame frame;
	private JTextField ürünTextField, capTextField, kalınlıkTextField, standartTextField;
	private JTable table;
	private JTextField textField_4;

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	DefaultTableModel model;
	private JTextField yogunlukTextField, donusumTextField, poliolTextField, izosiyanatTextField; 
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
            
            try ( Connection con = DBConnection.getConnection();
                  Statement stat = con.createStatement();
                  ResultSet rs = stat.executeQuery("SELECT * FROM ürünler");
                    )
            {
                
            Ürünler.getÜrünler(rs);
                
                System.out.println("Connected");
                System.out.println(rs.getRow());
            } catch (SQLException e) {
                System.err.print(e);
            }
            
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran window = new AnaEkran();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AnaEkran() {
		initialize();
		
		model = (DefaultTableModel) table.getModel();
		textField_4.setText(" " + dateFormat.format(date));
		
		JLabel lblYounluk = new JLabel("Yoğunluk");
		lblYounluk.setBounds(245, 13, 112, 32);
		frame.getContentPane().add(lblYounluk);
		
		yogunlukTextField = new JTextField();
		yogunlukTextField.setColumns(10);
		yogunlukTextField.setBounds(328, 18, 116, 22);
		frame.getContentPane().add(yogunlukTextField);
		
		JLabel lblGeriDnm = new JLabel("Geri Dönüşüm");
		lblGeriDnm.setBounds(245, 42, 112, 32);
		frame.getContentPane().add(lblGeriDnm);
		
		donusumTextField = new JTextField();
		donusumTextField.setColumns(10);
		donusumTextField.setBounds(328, 47, 116, 22);
		frame.getContentPane().add(donusumTextField);
		
		JLabel lblPoliol = new JLabel("Poliol");
		lblPoliol.setBounds(245, 71, 112, 32);
		frame.getContentPane().add(lblPoliol);
		
		JLabel lblIzosiyanat = new JLabel("İzosiyanat");
		lblIzosiyanat.setBounds(245, 100, 112, 32);
		frame.getContentPane().add(lblIzosiyanat);
		
		poliolTextField = new JTextField();
		poliolTextField.setColumns(10);
		poliolTextField.setBounds(328, 76, 116, 22);
		frame.getContentPane().add(poliolTextField);
		
		izosiyanatTextField = new JTextField();
		izosiyanatTextField.setColumns(10);
		izosiyanatTextField.setBounds(328, 105, 116, 22);
		frame.getContentPane().add(izosiyanatTextField);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 648, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		Button button = new Button("Ürün Ekle");
		button.addActionListener((ActionEvent arg0) -> {
                    ÜrünEkle ürün = new ÜrünEkle();
                    ürün.add( ürünTextField.getText(), capTextField.getText(), kalınlıkTextField.getText(), standartTextField.getText(), yogunlukTextField.getText(), donusumTextField.getText(), poliolTextField.getText(), izosiyanatTextField.getText());
                    System.out.print("Ürün eklendi.");
                });
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
			}
		});
		menuBar.add(button);
		
		Button button_2 = new Button("Ürünleri Güncelle");
                button_2.addActionListener((ActionEvent arg0) -> {

                    try ( Connection con = DBConnection.getConnection();
                          Statement stat = con.createStatement();
                          ResultSet rs = stat.executeQuery("SELECT * FROM ürünler");
                    )
                        
                    
            {
            
            model.setRowCount(0);
                
            while(rs.next())
            {
                model.addRow(new Object[]{ rs.getString("Ürün Adı"), rs.getString("Çap"), rs.getString("Üretim Standartı"), rs.getString("Yoğunluk"), rs.getString("Geri Dönüşüm"), rs.getString("Poliol"), rs.getString("İzosiyanat") });
            }    
            
                System.out.println("Connected");
                System.out.println(rs.getRow());
            } catch (SQLException e) {
                System.err.print(e);
            }
                    
                    System.out.print("Ürünler Güncellendi.");
                });
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
			}
		});
		menuBar.add(button_2);
		
		Button button_1 = new Button("İş Emri Ekle");
		menuBar.add(button_1);
		
		Button button_1_1 = new Button("Geçmiş İş Emirleri");
		menuBar.add(button_1_1);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ürün Adı");
		lblNewLabel.setBounds(12, 13, 112, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Çap");
		lblNewLabel_1.setBounds(12, 42, 112, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Et Kalınlığı");
		lblNewLabel_2.setBounds(12, 71, 112, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Üretim Standartı");
		lblNewLabel_2_1.setBounds(12, 100, 112, 32);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		ürünTextField = new JTextField();
		ürünTextField.setBounds(117, 18, 116, 22);
		frame.getContentPane().add(ürünTextField);
		ürünTextField.setColumns(10);
		
		capTextField = new JTextField();
		capTextField.setBounds(117, 47, 116, 22);
		frame.getContentPane().add(capTextField);
		capTextField.setColumns(10);
		
		kalınlıkTextField = new JTextField();
		kalınlıkTextField.setBounds(117, 76, 116, 22);
		frame.getContentPane().add(kalınlıkTextField);
		kalınlıkTextField.setColumns(10);
		
		standartTextField = new JTextField();
		standartTextField.setBounds(117, 105, 116, 22);
		frame.getContentPane().add(standartTextField);
		standartTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 145, 606, 178);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ürün Adı", "Çap", "Et Kalınlığı", "Üretim Standartı", "Yoğunluk", "Geri Dönüşüm", "Poliol", "İzosiyanat"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setBorder(null);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(456, 13, 112, 32);
		frame.getContentPane().add(lblTarih);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(502, 18, 116, 22);
		frame.getContentPane().add(textField_4);
	}
}