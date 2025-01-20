package hotel_management_system;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;


class allemployees extends JFrame implements ActionListener {
	JTable table;
	JButton b1,b2;
	public allemployees() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,910,600);
		setTitle("All Employees");
		setLayout(null);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(10,10,100,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(122,10,100,20);
		add(l2);
		
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(236,10,100,20);
		add(l3);
		

		JLabel l8 = new JLabel("Job");
		l8.setBounds(346,10,100,20);
		add(l8);
		
		JLabel l4 = new JLabel("Salary");
		l4.setBounds(455,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Phone");
		l5.setBounds(570,10,100,20);
		add(l5);

		
		JLabel l6 = new JLabel("Email");
		l6.setBounds(684,10,100,20);
		add(l6);

		
		JLabel l7 = new JLabel("Adhaar");
		l7.setBounds(800,10,100,20);
		add(l7);

		
		

//		
//		8JLabel l5 = new JLabel("Deposit");
//		l5.setBounds(410,10,100,20);
//		add(l5);
//		
				
		table = new JTable();
		table.setBounds(10,40,900,400);
		add(table);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		


		b1 = new JButton("Back");
		b1.setBounds(350,500,150,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);	
				
		setVisible(true);
		
		
		
	}		
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new allemployees();
	}

}
