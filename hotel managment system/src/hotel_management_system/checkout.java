package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
class checkout extends JFrame implements ActionListener{
	JButton b1,b2;
	Choice id;
	JLabel roomnumber,lblcheckintime,lblcheckouttime;
	public checkout() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setTitle("Check Out");
		
		JLabel txt = new JLabel("Checkout");
		txt.setBounds(100,20,100,30);
		txt.setForeground(Color.blue);
		txt.setFont(new Font("Tahoma", Font.PLAIN,20));
		add(txt);
		
		JLabel lblid  = new JLabel("Customer Id");
		lblid.setBounds(30,80,100,30);
		add(lblid);
		
		id =new Choice();
		id.setBounds(150,80,150,25);
		id.setBackground(Color.WHITE);
		add(id);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(320,80,20,20);
		add(image);
		
		
		
		JLabel lblroom  = new JLabel("Room number");
		lblroom.setBounds(30,130,100,30);
		add(lblroom);
		
		roomnumber  = new JLabel();
		roomnumber.setBounds(150,130,100,30);
		add(roomnumber);
		
	

		JLabel checkintime  = new JLabel("Check in Time");
		checkintime.setBounds(30,180,100,30);
		add(checkintime);
		
		lblcheckintime  = new JLabel();
		lblcheckintime.setBounds(150,180,100,30);
		add(lblcheckintime);
		
		JLabel checkouttime  = new JLabel("Check Out Time");
		checkouttime.setBounds(30,230,100,30);
		add(checkouttime);

		Date date = new Date();
		
		lblcheckouttime  = new JLabel(""+ date);
		lblcheckouttime.setBounds(150,230,150,30);
		add(lblcheckouttime);
		
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				id.add(rs.getString("number"));
				roomnumber.setText(rs.getString("room"));
				lblcheckintime.setText(rs.getString("checkintime"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		
		

		b1 = new JButton("Checkout");
		b1.setBounds(30,280,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);	
		


		b2 = new JButton("Back");
		b2.setBounds(170,280,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);	
		

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i5 = i4.getImage().getScaledInstance(400,250, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(360,50,400,250);
		add(image1);
		
		
		
		
		
		
		setBounds(300,200,800,400);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==b1){
			String q1 = "delete from customer where number = '"+id.getSelectedItem()+"'";
			String q2 = "update room set availability = 'Available' where roombumber = '"+roomnumber.getText()+"'";
			
			try {
				conn c = new conn();
				c.s.execute(q1);
				c.s.execute(q2);
				JOptionPane.showMessageDialog(null, "Checkout Done");

				setVisible(false);
				new Reception();
			}catch(Exception e){
				e.printStackTrace();
				
			}

		}else {
			setVisible(false);
			new Reception();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new checkout();
	}

}
