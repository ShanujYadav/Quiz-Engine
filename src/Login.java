import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEnterPassword;
	private Container lblNewLabel;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;
	static String sr_no;
	static String name;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1980, 1020);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.gray);
		 contentPane.setBackground(new Color(230,230,230));
		  
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(983, 82, 257, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(983, 135, 257, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterPassword.setBounds(983, 196, 257, 35);
		contentPane.add(lblEnterPassword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(983, 241, 257, 35);
		contentPane.add(textField_1);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(983, 324, 257, 35);
		DefaultComboBoxModel dcm=new DefaultComboBoxModel();
		dcm.addElement("Adminstrator");
		dcm.addElement("Player");
		comboBox.setModel(dcm);
		contentPane.add(comboBox);
		
		 btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.lightGray);
		btnNewButton.addActionListener(new ActionListener() {
			private Connection cn;

			public void actionPerformed(ActionEvent e) {
			String category=comboBox.getSelectedItem().toString();
			String userid=textField.getText();
			String password=textField_1.getText();
			
			if(category.equals("Adminstrator")&&userid.equals("admin")&& password.equals("admin")) {
				home h=new home();
				h.setVisible(true);
			}
			else {
				try {
					 cn=MyData.getConnection();
					String query="select * from player where SR_No=? and Password=?";
					PreparedStatement st=cn.prepareStatement(query);
					st.setString(1, userid);
					st.setString(2, password);
					
					ResultSet rs=st.executeQuery();
					
				if(rs.next()) {
					sr_no=userid;
					Login.this.dispose();
					Welcome p=new Welcome();
					p.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid");
				}
				}
				catch(Exception ex){
					
				}
				finally
				{
					try {
						cn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			}
		});	
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(983, 416, 85, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New ");
		btnNewButton_1.setBackground(Color.lightGray);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register r=new Register();
				r.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(1155, 416, 85, 27);
		contentPane.add(btnNewButton_1);
		

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\login.png"));
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_1);
	}
}
