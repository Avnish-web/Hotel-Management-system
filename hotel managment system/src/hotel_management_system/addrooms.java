/**
 * 
 */
package hotel_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class addrooms extends JFrame implements ActionListener {

	JButton add,cancle;
	JTextField tfroom,tfprice;
	JComboBox typecombo,availablecombo,cleancombo;
	
	/** 
	 * 
	 */
	public addrooms() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Add Rooms");
		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahona",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);

		JLabel lblroomno = new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahona",Font.PLAIN,16));
		lblroomno.setBounds(60,80,120,20);
		add(lblroomno);
		
		tfroom =new JTextField(); 
		tfroom.setBounds(180,80,120,30);
		add(tfroom);
		

		JLabel lblavailable = new JLabel("Available");
		lblavailable.setFont(new Font("Tahona",Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);
		
		String availableOption[] = {"Available","Occupied"};
		availablecombo = new JComboBox(availableOption);
		availablecombo.setBounds(180,130,120,30);
		availablecombo.setBackground(Color.WHITE);
		add(availablecombo);
		
		JLabel lblclean= new JLabel("Clean");
		lblclean.setFont(new Font("Tahona",Font.PLAIN,16));
		lblclean.setBounds(60,180,120,30);
		add(lblclean);
		
		String cleanOption[] = {"Cleaned","Dirty"};
		cleancombo = new JComboBox(cleanOption);
		cleancombo.setBounds(180,180,120,30);
		cleancombo.setBackground(Color.WHITE);
		add(cleancombo);
		
		

		JLabel lblprice= new JLabel("Price");
		lblprice.setFont(new Font("Tahona",Font.PLAIN,16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
		
		tfprice =new JTextField(); 
		tfprice.setBounds(180,230,120,30);
		add(tfprice);
		

		JLabel lbltype= new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahona",Font.PLAIN,16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		String typeOption[] = {"Singel","Double"};
		typecombo = new JComboBox(typeOption);
		typecombo.setBounds(180,280,120,30);
		typecombo.setBackground(Color.WHITE);
		add(typecombo);
		
		add = new JButton("Add Room");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(60,350,130,30);
		add.addActionListener(this);
		add(add);
		
		cancle = new JButton("Cancle");
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.setBounds(220,350,130,30);
		cancle.addActionListener(this);
		add(cancle);
		setBounds(330,200,940,470);
		setVisible(true);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(400,30,500,300);
		add(image);
		
		// TODO Auto-generated constructor stub
	}

public void actionPerformed(ActionEvent ae) {
	if (ae.getSource() == add) {
		String roomnumber = tfroom.getText();
		String availability= (String) availablecombo.getSelectedItem();
		String status = (String) cleancombo.getSelectedItem();
		String price= tfprice.getText();
		String type= (String) typecombo.getSelectedItem();
		
		try {
			conn conn = new conn();
			String str = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
			conn.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null,"New Room Added Successfully");
			setVisible(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}else{
		setVisible(false);
	}
}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new addrooms();
	}

}
