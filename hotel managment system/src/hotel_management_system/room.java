package hotel_management_system;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
public class room extends JFrame implements ActionListener  {
	JTable table;
	JButton b1,b2;
	public room() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,1050,600);
		setLayout(null);
		setTitle("Room");
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(10,10,100,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("Availibility");
		l2.setBounds(111,10,100,20);
		add(l2);
		
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(210,10,100,20);
		add(l3);
		
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(310,10,100,20);
		add(l4);
		
//		
//		JLabel l5 = new JLabel("Deposit");
//		l5.setBounds(410,10,100,20);
//		add(l5);
//		
		
		JLabel l6 = new JLabel("Bed Type");
		l6.setBounds(410,10,100,20);
		add(l6);
		
		table = new JTable();
		table.setBounds(10,40,500,400);
		add(table);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		


		b1 = new JButton("Back");
		b1.setBounds(200,500,150,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);	
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(380,60,450,370);
		image.setBounds(500,0,650,600);
		add(image);
		
		
		
		
		
		
		
		
		
		
		
		setVisible(true);
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}
	
	public static void main(String[] args) {
		new room();
		// TODO Auto-generated method stub

	}

}
