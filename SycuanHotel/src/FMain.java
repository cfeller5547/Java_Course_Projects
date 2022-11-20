import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Dimension;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.BorderLayout;


public class FMain {

	private JFrame frame;
	
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMain window = new FMain();
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
	public FMain() {
		frameContent();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void frameContent() {
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.getContentPane().setLayout(null);
		
		
		//label1
		JLabel label1 = new JLabel("test1");
		
		Dimension size = label1.getPreferredSize();
	    label1.setBounds(10, 50, size.width, size.height);
		frame.getContentPane().add(label1);
		
		//label2
		JLabel label2 = new JLabel("test2");
		
		Dimension size2 = label2.getPreferredSize();
	    label2.setBounds(10, 90, size2.width, size2.height);
		frame.getContentPane().add(label2);
		
		//label3
		JLabel label3 = new JLabel("test3");
				
		Dimension size3 = label3.getPreferredSize();
		label3.setBounds(10, 130, size3.width, size3.height);
		frame.getContentPane().add(label3);
		
		//label4
		JLabel label4 = new JLabel("test4");
						
		Dimension size4 = label4.getPreferredSize();
		label4.setBounds(10, 170, size4.width, size4.height);
		frame.getContentPane().add(label4);
		
		//label5
		JLabel label5 = new JLabel("test5");
								
		Dimension size5 = label5.getPreferredSize();
		label5.setBounds(10, 210, size5.width, size5.height);
		frame.getContentPane().add(label5);
		
		
		
		//textfield1
		txt1 = new JTextField();
		
		Dimension txtsize1 = txt1.getPreferredSize();
		txt1.setBounds(50, 50, 200, txtsize1.height);
		frame.getContentPane().add(txt1);
		txt1.setColumns(10);
		
		
		//textfield2
		txt2 = new JTextField();
		
		Dimension txtsize2 = txt2.getPreferredSize();
		txt2.setBounds(50, 90, 200, txtsize2.height);
		frame.getContentPane().add(txt2);
		txt2.setColumns(10);
		
		//textfield3
	    txt3 = new JTextField();
	
		Dimension txtsize3 = txt3.getPreferredSize();
		txt3.setBounds(50, 130, 200, txtsize3.height);
		frame.getContentPane().add(txt3);
		txt3.setColumns(10);
		
		//textfield4
		txt4 = new JTextField();
		
		Dimension txtsize4 = txt4.getPreferredSize();
		txt4.setBounds(50, 170, 200, txtsize4.height);
		frame.getContentPane().add(txt4);
		txt4.setColumns(10);
		
		//textfield5
		txt5 = new JTextField();
		Dimension txtsize5 = txt5.getPreferredSize();
		txt5.setBounds(50, 210, 200, txtsize5.height);
		frame.getContentPane().add(txt5);
		txt5.setColumns(10);
		
		
		//jbutton
		
		JButton btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDatabase();
			}
		});
		btnSave.setBounds(150,250,100,txtsize5.height);
		frame.getContentPane().add(btnSave);
		
	
		
		
		
		}
		
		
//	static class Action implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//			FMain fMain = new FMain();
//			fMain.SaveToDatabase();
//		}
//	}
	
	
	static Connection con(){
		try{
		
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/myhotel";
			Class.forName(driver);
			return DriverManager.getConnection(url, "pma", "Bosser654!");

		  }	catch(Exception e){
				
				System.out.println("Connection failed!" + e);
	
		 }
		 return null;
	}
	
	public void SaveToDatabase(Person p) throws SQLException{
		
		
		Connection con = con();
		
		try {
//			String query = "insert into db_hotel values(?,?,?,?,?)";
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1,txt1.getText());
//			ps.setString(2,txt2.getText());
//			ps.setString(3,txt3.getText());
//			ps.setString(4,txt4.getText());
//			ps.setString(5,txt5.getText());
//			ps.executeUpdate();
			
			String query = "insert into db_hotel values('"+p.getFirstName()+"', '"+p.getLastName()+"', '"+p.getStatus()+"', '"+p.getCheckInDate()+"', '"+p.getEmail()+"');";
			Statement stmt = null;
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			con.close();
			
			
			
			JOptionPane.showMessageDialog(null, "SAVED");
			
		}catch(Exception e) {
			System.out.print("Error: " + e);
			
		}
		
	}
}