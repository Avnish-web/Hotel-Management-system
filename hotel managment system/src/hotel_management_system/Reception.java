package hotel_management_system;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
public class Reception extends JFrame implements ActionListener {
	JButton newcustomerform,room,department,allemployees,customerinfo,managerinfo,searchroom,updatestatus,updateroomstatus,pickupservice,checkout,logout;
	
		Reception() {
		setBounds(300,200,800,540);
		setTitle("Reception");

		setLayout(null);
		newcustomerform = new JButton("New Customer Form") ;
		newcustomerform.setBounds(20,30,150,30);
		newcustomerform.setBackground(Color.BLACK);
		newcustomerform.setForeground(Color.white);
		newcustomerform.addActionListener(this);
		add(newcustomerform);
		

		room = new JButton("Rooms") ;
		room.setBounds(20,70,150,30);
		room.setBackground(Color.BLACK);
		room.setForeground(Color.white);
		room.addActionListener(this);
		add(room);
		

		department = new JButton("Department") ;
		department.setBounds(20,110,150,30);
		department.setBackground(Color.BLACK);
		department.setForeground(Color.white);

		department.addActionListener(this);
		add(department);
		

		allemployees= new JButton("All Employees") ;
		allemployees.setBounds(20,150,150,30);
		allemployees.setBackground(Color.BLACK);
		allemployees.setForeground(Color.white);
		allemployees.addActionListener(this);
		add(allemployees);
		

		customerinfo = new JButton("Customer Info") ;
		customerinfo.setBounds(20,190,150,30);
		customerinfo.setBackground(Color.BLACK);
		customerinfo.setForeground(Color.white);
		customerinfo.addActionListener(this);
		add(customerinfo);
		

		managerinfo= new JButton("Manager Info") ;
		managerinfo.setBounds(20,230,150,30);
		managerinfo.setBackground(Color.BLACK);
		managerinfo.setForeground(Color.white);
		managerinfo.addActionListener(this);
		add(managerinfo);
		

		checkout = new JButton("Checkout") ;
		checkout.setBounds(20,270,150,30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		

		updatestatus = new JButton("Update Status") ;
		updatestatus.setBounds(20,310,150,30);
		updatestatus.setBackground(Color.BLACK);
		updatestatus.setForeground(Color.white);
		updatestatus.addActionListener(this);
		add(updatestatus);
		

		updateroomstatus = new JButton("Update Room Status") ;
		updateroomstatus.setBounds(20,350,150,30);
		updateroomstatus.setBackground(Color.BLACK);
		updateroomstatus.setForeground(Color.white);
		updateroomstatus.addActionListener(this);
		add(updateroomstatus);
		

		pickupservice= new JButton("Pickup Service") ;
		pickupservice.setBounds(20,390,150,30);
		pickupservice.setBackground(Color.BLACK);
		pickupservice.setForeground(Color.white);
		pickupservice.addActionListener(this);
		add(pickupservice);
		

		searchroom = new JButton("Search Room") ;
		searchroom.setBounds(20,430,150,30);
		searchroom.setBackground(Color.BLACK);
		searchroom.setForeground(Color.white);
		searchroom.addActionListener(this);
		add(searchroom);

		
		
		logout= new JButton("Logout") ;
		logout.setBounds(20,470,150,30);
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(380,60,450,370);setBounds(300,200,800,540)tBounds(20,40,150,30);


		image.setBounds(190,33,600,440);
		add(image);

		

		
		setVisible(true);
				
		// TODO Auto-generated constructor stub
	}

		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==newcustomerform){
				setVisible(false);
				new NewCustomerForm();
			}else if(ae.getSource()==room) {
				setVisible(false);
				new room();
			}else if(ae.getSource()==department) {
				setVisible(false);
				new Department();
			}else if (ae.getSource()==allemployees) {
				setVisible(false);
				new allemployees();
			}else if (ae.getSource()==customerinfo) {
				setVisible(false);
				new customerinfo();
			}else if (ae.getSource()==searchroom) {
				setVisible(false);
				new searchroom();
			}else if(ae.getSource()==updatestatus) {
				setVisible(false);
				new updatestatus();
			}else if(ae.getSource()==updatestatus) {
				setVisible(false);
				new updatestatus();
			}else if(ae.getSource()==managerinfo) {
				setVisible(false);
				new	managerinfo();
			}else if(ae.getSource()==updateroomstatus) {
				setVisible(false);
				new	updateroomstatus();
			}else if(ae.getSource()==pickupservice) {
					setVisible(false);
					new pickupservice();
			}else if(ae.getSource()==checkout) {
				setVisible(false);
				new checkout();
			}else if(ae.getSource()==logout) {
				setVisible(false);
				System.exit(0);
			}
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Reception();
	}

}
