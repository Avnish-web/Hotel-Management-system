package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.*;
public class adddriver extends JFrame implements ActionListener{

	JTextField tfname,tfage,tfmodel,tfcompany,tflocation;
	JComboBox typecombo,agecombo,availablecombo,gendercombo,cleancombo;
	JButton add,cancle;
	adddriver() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);	
		setTitle("Add Driver");

		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahona",Font.BOLD,18));
		heading.setBounds(150,10,200,20);
		add(heading);

		JLabel lblroomno = new JLabel("Name");
		lblroomno.setFont(new Font("Tahona",Font.PLAIN,16));
		lblroomno.setBounds(60,70,100,30);
		add(lblroomno);
		
		tfname=new JTextField(); 
		tfname.setBounds(200,70,150,30);
		add(tfname);
		

		JLabel lblage= new JLabel("Age");
		lblage.setFont(new Font("Tahona",Font.PLAIN,16));
		lblage.setBounds(60,110,150,30);
		add(lblage);
		

		tfage=new JTextField(); 
		tfage.setBounds(200,110,150,30);
		add(tfage); 
		
		JLabel lblclean= new JLabel("Gender");
		lblclean.setFont(new Font("Tahona",Font.PLAIN,16));
		lblclean.setBounds(60,150,120,30);
		add(lblclean);
		
		String cleanOption[] = {"Male","Female"};
		gendercombo= new JComboBox(cleanOption);
		gendercombo.setBounds(200,150,150,30);
		gendercombo.setBackground(Color.WHITE);
		add(gendercombo);
		
		

		JLabel lblprice= new JLabel("Car Company");
		lblprice.setFont(new Font("Tahona",Font.PLAIN,16));
		lblprice.setBounds(60,190,120,30);
		add(lblprice);
		
		tfcompany =new JTextField(); 
		tfcompany.setBounds(200,190,150,30);
		add(tfcompany);
		

		JLabel lbltype= new JLabel("Car Model");
		lbltype.setFont(new Font("Tahona",Font.PLAIN,16));
		lbltype.setBounds(60,230,120,30);
		add(lbltype);
		
		
		tfmodel= new JTextField();
		tfmodel.setBounds(200,230,150,30);
		tfmodel.setBackground(Color.WHITE);
		add(tfmodel);
		

		JLabel lblavailabale= new JLabel("Available");
		lblavailabale.setFont(new Font("Tahona",Font.PLAIN,16));
		lblavailabale.setBounds(60,270,120,30);
		add(lblavailabale);
		
		
		String driverOptions[] = {"Available","Busy"};
		availablecombo = new JComboBox(driverOptions);
		availablecombo.setBounds(200,270,150,30);
		availablecombo.setBackground(Color.WHITE);
		add(availablecombo);
		
		JLabel lbllocation= new JLabel("Location");
		lbllocation.setFont(new Font("Tahona",Font.PLAIN,16));
		lbllocation.setBounds(60,310,120,30);
		add(lbllocation);
		
		
		tflocation= new JTextField();
		tflocation.setBounds(200,310,150,30);
		tflocation.setBackground(Color.WHITE);
		add(tflocation);
		
		
		
		
		add = new JButton("Add Drivers");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(60,370,130,30);
		add.addActionListener(this);
		add(add);
		
		cancle = new JButton("Cancle");
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.setBounds(220,370,130,30);
		cancle.addActionListener(this);
		add(cancle);
		setBounds(330,200,940,470);
		setVisible(true);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(380,60,450,370);
		image.setBounds(400,30,500,300);
		add(image);

		
		
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == add) {
			String name = tfname.getText();
			String age= tfage.getText();
			String gender= (String) gendercombo.getSelectedItem();
			String company= tfcompany.getText();
			String brand= tfmodel.getText();
			String available = (String) availablecombo.getSelectedItem(); 
			String location =tflocation.getText();
			try { 
				conn conn = new conn();
				String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
				conn.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else{
			setVisible(false);
		}
	}

		
		
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new adddriver();
	}

}
