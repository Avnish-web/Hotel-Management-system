package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class updateroomstatus extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField lfroom,lfavailabale,lfpaid,lfstatus,lfpending;
	    JButton check,update,back;
	public updateroomstatus() {
		setLayout(null);
		setTitle("Update Room Status");
		setBackground(Color.WHITE);
		
		setBounds(300,200,980,400);
		
		JLabel txt = new JLabel("Update Room Status");
		txt.setBounds(30,20,250,30);
		txt.setFont(new Font("Tahoma",Font.PLAIN,20));
		txt.setForeground(Color.blue);
		add(txt);
		
		JLabel lblid = new JLabel("Customer Id");
		lblid.setBounds(30,80,100,25);
		add(lblid);
		
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);
		
		try {
			conn c = new conn();
			ResultSet rs =  c.s.executeQuery("select * from customer");
			while(rs.next()){
				ccustomer.add(rs.getString("number"));
				}
			}catch(Exception e){
			e.printStackTrace();
			}
		
		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(30,130,150,25);
		add(lblroom);
		
		
		lfroom = new JTextField();
		lfroom.setBounds(200,130,150,25);
		add(lfroom);
		
		
		JLabel lblname = new JLabel("Availability");
		lblname.setBounds(30,180,150,25);
		add(lblname);
		
		lfavailabale= new JTextField();
		lfavailabale.setBounds(200,180,150,25);
		add(lfavailabale);
		
		JLabel lblcheckin= new JLabel("Cleaning Status");
		lblcheckin.setBounds(30,230,150,25);
		add(lblcheckin);
		
		lfstatus= new JTextField();
		lfstatus.setBounds(200,230,150,25);
		add(lfstatus);

		back= new JButton("Back") ;
		back.setBounds(270,305+10,100,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		

		update= new JButton("Update") ;
		update.setBounds(150,305+10,100,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.white);

		update.addActionListener(this);
		add(update);
		
		

		check= new JButton("Check") ;
		check.setBounds(30,305+10,100,30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(380,60,450,370);setBounds(300,200,800,540)tBounds(20,40,150,30);


		image.setBounds(400,50,500,300);
		add(image);


		
		
		
		
		
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource()==check) {
			String id = ccustomer.getSelectedItem();
			String query = "select * from customer where number = '"+id+"'";
			try {
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					lfroom.setText(rs.getString("room"));
				}
				ResultSet rs2= c.s.executeQuery("select * from room  where roombumber ='"+lfroom.getText()+"'");
				
				while(rs2.next()) {
					lfroom.setText(rs2.getString("roombumber"));
					lfavailabale.setText(rs2.getString("availability"));
					lfstatus.setText(rs2.getString("cleaning_status"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==update) {
			String number = ccustomer.getSelectedItem();
			String room = lfroom.getText();
			String status = lfstatus.getText();
			String available= lfavailabale.getText();
			
			try {
				conn c = new conn();
				c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status = '"+status+"'where roombumber = '"+room+"' ");
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				setVisible(false);
				new Reception();
				
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
			
			
			
		}else {
			setVisible(false);
			new Reception();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new updateroomstatus();
	}

}
