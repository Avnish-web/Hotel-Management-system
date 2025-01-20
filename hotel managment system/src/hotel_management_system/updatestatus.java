package hotel_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class updatestatus extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField lfroom,lfname,lfpaid,lfcheckin,lfpending;
	    JButton check,update,back;
	public updatestatus() {
		setLayout(null);
		setTitle("Update Status");
		setBackground(Color.WHITE);
		
		setBounds(300,200,980,500);
		
		JLabel txt = new JLabel("Update Status");
		txt.setBounds(90,20,200,30);
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
		lblroom.setBounds(30,120,150,25);
		add(lblroom);
		
		
		lfroom = new JTextField();
		lfroom.setBounds(200,120,150,25);
		add(lfroom);
		
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(30,160,150,25);
		add(lblname);
		
		lfname= new JTextField();
		lfname.setBounds(200,160,150,25);
		add(lfname);
		
		
		JLabel lblpaid= new JLabel("Amount Paid");
		lblpaid.setBounds(30,200,150,25);
		add(lblpaid);
		
		lfpaid= new JTextField();
		lfpaid.setBounds(200,200,150,25);
		add(lfpaid);
		
		JLabel lblcheckin= new JLabel("Check in Time");
		lblcheckin.setBounds(30,240,150,25);
		add(lblcheckin);
		
		lfcheckin= new JTextField();
		lfcheckin.setBounds(200,240,150,25);
		add(lfcheckin);
		
		
		JLabel lblpending = new JLabel("Pending Amount");
		lblpending.setBounds(30,280,100,25);
		add(lblpending);
		
		lfpending= new JTextField();
		lfpending.setBounds(200,280,150,25);
		add(lfpending);
		
		

		back= new JButton("Back") ;
		back.setBounds(270,420,100,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		

		update= new JButton("Update") ;
		update.setBounds(150,420,100,30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.white);

		update.addActionListener(this);
		add(update);
		
		

		check= new JButton("Check") ;
		check.setBounds(30,420,100,30);
		check.setBackground(Color.BLACK);
		check.setForeground(Color.white);
		check.addActionListener(this);
		add(check);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		//Image i2 = i1.getImage().getScaledInstance(1,1, Image.SCALE_DEFAULT);
		//ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i1);
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
					lfname.setText(rs.getString("name"));
					lfcheckin.setText(rs.getString("checkintime"));
					lfpaid.setText(rs.getString("deposit"));
				}
				
				ResultSet rs2= c.s.executeQuery("select * from room  where roombumber ='"+lfroom.getText()+"'");
				while(rs2.next()) {
					String price = rs2.getString("price");
					int amountpaid = Integer.parseInt(price)-Integer.parseInt(lfpaid.getText());
					lfpending.setText(""+ amountpaid);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==update) {
			String number = ccustomer.getSelectedItem();
			String room = lfroom.getText();
			String name = lfname.getText();
			String checkin = lfcheckin.getText();
			String deposit = lfpaid.getText();
			try {
				conn c = new conn();
				c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime =  '"+checkin+"',deposit = '"+deposit+"' where number = '"+number+"'");
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
		new updatestatus();
	}

}
