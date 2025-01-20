package hotel_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
public class NewCustomerForm extends JFrame implements ActionListener{

	
	JTextField tfname,tfdeposit,tfage,tfnumber,tfcountry,tflocation,tfroomnu;
	JComboBox typecombo,agecombo,availablecombo,idcombo,gendercombo;
	JButton add,cancle;
	JRadioButton rmale, rfemale;
	JLabel checkintime;
	Choice croom;
	public NewCustomerForm() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(330,200,940,470);
		setLayout(null);
		setTitle("New Customer Form");
		JLabel newcustomerform= new JLabel("NEW CUSTOMER FORM");
		newcustomerform.setFont(new Font("Tahona",Font.BOLD,18));
		newcustomerform.setBounds(100,20,300,30);
		add(newcustomerform);

		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Tahona",Font.PLAIN,16));
		lblid.setBounds(60,70,100,30);
		add(lblid);

		String idOption[] = {"Adhaar","Pan","Voter","Driving Licence","Passport","Ration card"};
		idcombo= new JComboBox(idOption);
		idcombo.setBounds(200,70,150,30);
		idcombo.setBackground(Color.WHITE);
		add(idcombo);

		JLabel lblnumber= new JLabel("Number");
		lblnumber.setFont(new Font("Tahona",Font.PLAIN,16));
		lblnumber.setBounds(60,110,100,30);
		add(lblnumber);
		
		tfnumber=new JTextField(); 
		tfnumber.setBounds(200,110,150,30);
		add(tfnumber);
		

		JLabel lblname= new JLabel("Name");
		lblname.setFont(new Font("Tahona",Font.PLAIN,16));
		lblname.setBounds(60,150,100,30);
		add(lblname);
		
		if (lblname.equals("")) {
			 JOptionPane.showMessageDialog(null,"Name should not be empty");
			 return;
		 }
		 
		
		tfname=new JTextField(); 
		tfname.setBounds(200,150,150,30);
		add(tfname);

//		tfage=new JTextField(); 
//		tfage.setBounds(200,110,150,30);
//		add(tfage); 
		
		JLabel lblclean= new JLabel("Gender");
		lblclean.setFont(new Font("Tahona",Font.PLAIN,16));
		lblclean.setBounds(60,190,150,30);
		add(lblclean);
		
		
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(200,190,55,30);
		rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rmale.setBackground(Color.WHITE);
		add(rmale);
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(260,190,150,30);
		rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		rfemale.setBackground(Color.WHITE);
		add(rfemale);
		
		

		JLabel lblcountry= new JLabel("Country");
		lblcountry.setFont(new Font("Tahona",Font.PLAIN,16));
		lblcountry.setBounds(60,230,120,30);
		add(lblcountry);
		
		tfcountry =new JTextField(); 
		tfcountry.setBounds(200,230,150,30);
		add(tfcountry);
		

		JLabel lblroomnu= new JLabel("Room Number");
		lblroomnu.setFont(new Font("Tahona",Font.PLAIN,16));
		lblroomnu.setBounds(60,270,120,30);
		add(lblroomnu);
		
		croom = new Choice();
		try {
			conn conn = new conn();
			String query = "select * from room where availability ='Available'";
			ResultSet rs = conn.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("roombumber"));
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		croom.setBounds(200,270,150,30);
		add(croom);
		

		JLabel lblchechin= new JLabel("Checkin Time");
		lblchechin.setFont(new Font("Tahona",Font.PLAIN,16));
		lblchechin.setBounds(60,310,120,30);
		add(lblchechin);
		
		Date date = new Date();
		checkintime =new  JLabel(""+date);
		checkintime.setBounds(200,310,160,30);
		checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
		add(checkintime);
		
		JLabel lblDeposit= new JLabel("Deposit");
		lblDeposit.setFont(new Font("Tahona",Font.PLAIN,16));
		lblDeposit.setBounds(60,340,120,30);
		add(lblDeposit);
		
		
		tfdeposit= new JTextField();
		tfdeposit.setBounds(200,340,150,30);
		tfdeposit.setBackground(Color.WHITE);
		add(tfdeposit);
		
		
		
		
		add = new JButton("Add");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(60,390,130,30);
		add.addActionListener(this);
		add(add);
		
		cancle = new JButton("Back");
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.setBounds(210,390,130,30);
		cancle.addActionListener(this);
		add(cancle);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifith.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300,400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(380,60,450,370);
		image.setBounds(400,10,400,500);
		add(image);


		
		setVisible(true);
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == add) {
			String id = (String) idcombo.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;
			if(rmale.isSelected()) {
				gender = "Male";
			}else {
				gender="Female";
			}
			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposit.getText();
			
			try {
				String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
				String query2 = "update room set availability = 'Occupied' where roombumber = '"+room+"'";

				conn conn = new conn();
				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null,"New Customr Added Successfully");
				setVisible(false);
				new Reception();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(ae.getSource() == cancle) {
	
			setVisible(false);
			new Reception();
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NewCustomerForm();
	}

}