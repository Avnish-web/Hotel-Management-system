package hotel_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Dashboard extends JFrame implements ActionListener  {

	Dashboard() {
	setBounds(-10,0,1455,900);
	setTitle("Dashboard");
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
	Image i2 = i1.getImage().getScaledInstance(1450, 900,Image.SCALE_DEFAULT);
	ImageIcon i3= new ImageIcon(i2);
	JLabel image = new JLabel(i3);
	image.setBounds(0,0,1450,900);
	add(image);
	
	JLabel text = new JLabel("THE TAJ GROUP WECOMES YOU");
	text.setBounds(400,80,1000,50);
	text.setFont(new Font("Tahona",Font.PLAIN,46));
	text.setForeground(Color.WHITE);
	image.add(text);
	
	JMenuBar mb=new JMenuBar();
	mb.setBounds(0,0,1450,30);
	image.add(mb);
	JMenu hotel = new JMenu("HOTEL MANAGEMENT");
	hotel.setForeground(Color.BLUE);
	mb.add(hotel);
	
	
	JMenuItem receptions = new JMenuItem("RECEPTION");
	receptions.addActionListener(this);
	hotel.add(receptions);
	
	JMenu admin = new JMenu("ADMIN");
	admin.setForeground(Color.RED);
	mb.add(admin);
	
	JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
	addemployee.addActionListener(this);
	admin.add(addemployee);
	
	JMenuItem addrooms = new JMenuItem("ADD ROOMS");
	addrooms.addActionListener(this);
	admin.add(addrooms);
	
	JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
	adddrivers.addActionListener(this);
	admin.add(adddrivers);
	setVisible(true);
		
		
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new addemployee();
		}else if (ae.getActionCommand().equals("ADD ROOMS")) {
			new addrooms(); 
		}else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new adddriver();
		}else if (ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard();
	}

}
