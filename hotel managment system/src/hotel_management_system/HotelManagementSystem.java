package hotel_management_system;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class HotelManagementSystem extends JFrame implements ActionListener {
	public HotelManagementSystem() {
		setSize(1366,565);
		setLocation(100,100);
		setTitle("Hotel Management System");

		setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
		JLabel image = new JLabel(i1);
		add(image);
		setVisible(true);
		setLayout(null);
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20,430,1000,90);
		text.setForeground(Color.white);
		text.setFont(new Font("serif", Font.BOLD,50));
		image.add(text);
		JButton nextButton = new JButton("NEXT");
        nextButton.setBounds(1150, 450, 150, 50);
        nextButton.setBackground(new Color(255, 255, 255));
        nextButton.setForeground(new Color(0, 51, 102));
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBorder(BorderFactory.createEmptyBorder());
        nextButton.addActionListener(this);
        add(nextButton);
		nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButton.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButton.setBackground(Color.WHITE);
            }
        });		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new login();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HotelManagementSystem();
	}

}