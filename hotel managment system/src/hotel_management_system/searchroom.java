package hotel_management_system;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
public class searchroom extends JFrame implements ActionListener  {
	JTable table;
	JCheckBox available;
	JComboBox bedtype;
	JButton b1,b2;
	public searchroom() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(300,200,1050,600);
		setLayout(null);
		setTitle("Search Room");
		
		JLabel hed = new JLabel("Search for Room");
		hed.setFont(new Font("Tahoma",Font.PLAIN,20));
		hed.setBounds(400,30,200,30);
		add(hed);
		
		JLabel l12 = new JLabel("Bed Type");
		l12.setBounds(50,100,100,20);
		add(l12);
		
		bedtype=new JComboBox(new String[] {"Single Bed","Double Bed"});
		bedtype.setBounds(150,100,150,25);
		bedtype.setBackground(Color.WHITE);
		add(bedtype);
		
		available = new JCheckBox("Only Display Available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.white);
		add(available);
		
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(10,160,100,20);
		add(l1);
		
		
		JLabel l2 = new JLabel("Availibility");
		l2.setBounds(210,160,100,20);
		add(l2);
		
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(410,160,100,20);
		add(l3);
		
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(610,160,100,20);
		add(l4);
		
//		
//		JLabel l5 = new JLabel("Deposit");
//		l5.setBounds(410,10,100,20);
//		add(l5);
//		
		
		JLabel l6 = new JLabel("Bed Type");
		l6.setBounds(810,160,100,20);
		add(l6);
		
		table = new JTable();
		table.setBounds(10,200,1000,300);
		add(table);
		
		
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		


		b1 = new JButton("Back");
		b1.setBounds(600,520,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);	
		


		b2 = new JButton("Submit");
		b2.setBounds(300,520,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);	
		
		
		
		
		
		
		
		
		
		setVisible(true);
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		
		
		if (ae.getSource()==b2) {
			try {
				String q1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
				String q2 = "select * from room where availability = 'available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
				conn conn = new conn();
				ResultSet rs;
				if (available.isSelected()) {
					rs = conn.s.executeQuery(q2);
				}else {
					rs = conn.s.executeQuery(q1);
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
		
			
		
	}else {
		setVisible(false);
		new Reception();
	}}
	public static void main(String[] args) {
		new searchroom();
		// TODO Auto-generated method stub

	}

}
