package hotel_management_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;



class customerinfo extends JFrame implements ActionListener {
	JTable table;
	JButton b1,b2;
	public customerinfo() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,940,600);
		setLayout(null);
		setTitle("Customer Info");
		
		JLabel l1 = new JLabel("Document");
		l1.setBounds(10,10,100,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(122,10,100,20);
		add(l2);
		
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(236,10,100,20);
		add(l3);
		

		JLabel l8 = new JLabel("Gender");
		l8.setBounds(346,10,100,20);
		add(l8);
		
		JLabel l4 = new JLabel("Country");
		l4.setBounds(455,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Room");
		l5.setBounds(570,10,100,20);
		add(l5);

		
		JLabel l6 = new JLabel("Check in Time");
		l6.setBounds(684,10,100,20);
		add(l6);

		
		JLabel l7 = new JLabel("Deposit");
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
			ResultSet rs = c.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		


		b1 = new JButton("Back");
		b1.setBounds(360,500,150,30);
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
		new customerinfo();
	}

}
