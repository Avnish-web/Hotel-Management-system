/*package hotel_management_system;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class login extends JFrame implements ActionListener {
	JTextField username;
	JPasswordField password;
	JButton login, cancel;

	login() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel user = new JLabel("Username");
		user.setBounds(40, 30, 100, 30);
		add(user);
		username = new JTextField();
		username.setBounds(150, 30, 150, 30);
		add(username);
		password = new JPasswordField();
		password.setBounds(150, 90, 150, 30);
		add(password);

		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 90, 100, 30);
		add(pass);

		login = new JButton("LOGIN");
		login.setBounds(40, 150, 120, 30);

		// Set background color
		login.setBackground(new Color(0, 102, 204));

		// Set foreground color
		login.setForeground(Color.WHITE);

		// Set font style, size and family
		login.setFont(new Font("Arial", Font.BOLD, 18));

		// Add a border around the button
		login.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 0));

		// Set a custom icon for the button
		login.setIcon(new ImageIcon("path/to/your/icon.png"));
		login.setIconTextGap(-5);

		// Set hover effect (background color change on mouse over)
		login.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				login.setBackground(Color.decode("#03A9F4")); // On mouse enter, change to lighter blue
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				login.setBackground(Color.decode("#0006CC")); // On mouse exit, change back to original blue
			}
		});

		login.addActionListener(this);
		add(login);
//			
		cancel = new JButton("CANCEL");
		cancel.setBounds(180, 150, 120, 30);

		// Set background color
		cancel.setBackground(new Color(255, 51, 51)); // Red color for Cancel

		// Set foreground color
		cancel.setForeground(Color.WHITE);

		// Set font style, size and family
		cancel.setFont(new Font("Arial", Font.BOLD, 18));

		// Add a border around the button
		cancel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 0));

		// Set a custom icon for the button (optional)
		cancel.setIcon(new ImageIcon("path/to/your/icon.png")); // Set the path for an icon
		cancel.setIconTextGap(-5);

		// Set hover effect (background color change on mouse over)
		cancel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				cancel.setBackground(Color.decode("#FF9999")); // Lighter red color on mouse enter
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				cancel.setBackground(Color.decode("#FF3333")); // Original red color on mouse exit
			}
		});

		// Add Action Listener (you can replace 'this' with your actual listener)
		cancel.addActionListener(this); // Make sure you implement ActionListener

		// Add the button to the frame or panel
		add(cancel);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 10, 200, 200);
		add(image);

		setBounds(500, 200, 600, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			String user = username.getText();
			String pass = password.getText();
			try {
				conn c = new conn();
				String query = "select * from login where username = '" + user + "' and password = '" + pass + "' ";
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Dashboard();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (ae.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}
}
/*




*/




package hotel_management_system;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    login() {
        // Set the title and default close operation
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create title bar panel
        JPanel titleBar = new JPanel();
        titleBar.setLayout(new BorderLayout());
        titleBar.setBackground(new Color(0, 102, 204)); // Customize the title bar color

        // Add title text
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleBar.add(titleLabel, BorderLayout.CENTER);
        add(titleBar, BorderLayout.NORTH);

        // Set the main content color
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        // Username Label and TextField
        JLabel user = new JLabel("Username");
        user.setBounds(40, 30, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 30, 150, 30);
        add(username);
        
        // Password Label and TextField
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 90, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 90, 150, 30);
        add(password);

        // Login Button
        login = new JButton("LOGIN");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(new Color(0, 102, 204));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 18));
        login.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 0));
        login.setIcon(new ImageIcon("path/to/your/icon.png"));
        login.setIconTextGap(-5);
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login.setBackground(Color.decode("#03A9F4"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                login.setBackground(Color.decode("#0006CC"));
            }
        });
        login.addActionListener(this);
        add(login);

        // Cancel Button
        cancel = new JButton("CANCEL");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(new Color(255, 51, 51));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 18));
        cancel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 0));
        cancel.setIcon(new ImageIcon("path/to/your/icon.png"));
        cancel.setIconTextGap(-5);
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancel.setBackground(Color.decode("#FF9999"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancel.setBackground(Color.decode("#FF3333"));
            }
        });
        cancel.addActionListener(this);
        add(cancel);

        // Optional Image (for branding or decoration)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        // Set frame properties
        setBounds(500, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText().trim(); // Get username and trim whitespace
            String pass = new String(password.getPassword()).trim(); // Get password and trim whitespace
            
            // Validation: Check if fields are empty
            if (user.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your username.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method
            }
            if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your password.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method
            }

            // Proceed with authentication after validation
            try {
                conn c = new conn();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "' ";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard(); // Navigate to the Dashboard
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false); // Close the login window
        }
    }

    public static void main(String[] args) {
        new login(); // Create an instance of the login class to run the application
    }
}