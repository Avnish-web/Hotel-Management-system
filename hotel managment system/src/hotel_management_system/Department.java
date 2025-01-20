package hotel_management_system;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Department extends JFrame implements ActionListener  {
	JTable table;
	JButton b1;
	public Department() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(400,200,535,480);
		setLayout(null);
		setTitle("Department");
		
		JLabel l1 = new JLabel("Department");
		l1.setBounds(10,15,100,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("Budget");
		l2.setBounds(260,15,100,20);
		add(l2);
		
				
		table = new JTable();
		table.setBounds(10,40,500,320);
		add(table);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		


		b1 = new JButton("Back");
		b1.setBounds(200,360,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);	
//		
//		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//		Image i2 = i1.getImage().getScaledInstance(600,600, Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel image = new JLabel(i3);
//		//image.setBounds(380,60,450,370);
//		image.setBounds(500,0,650,600);
//		add(image);
//		
		
		setVisible(true);
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}
	
	public static void main(String[] args) {
		new Department();
		// TODO Auto-generated method stub

	}

}
