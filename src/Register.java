import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPassword;
	private JLabel lblNewLabel_1;

	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920 ,1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(1080, 98, 248, 27);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(1080, 165, 248, 27);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterName.setBounds(1080, 216, 248, 27);
		contentPane.add(lblEnterName);
		
		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreatePassword.setBounds(1080, 321, 248, 27);
		contentPane.add(lblCreatePassword);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(1080, 270, 248, 27);
		contentPane.add(txtName);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(1080, 374, 248, 27);
		contentPane.add(txtPassword);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(Color.lightGray);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection cn=MyData.getConnection();
					String query="insert into player(SR_No,Name,password) values(?,?,?)";
					PreparedStatement st=cn.prepareStatement(query);
					st.setString(1, txtId.getText());
				    st.setString(2, txtName.getText());
					st.setString(3, txtPassword.getText());
					st.executeUpdate();
					
					cn.close();
					 JOptionPane.showMessageDialog(null,"Data Saved: ");
				}
				catch(Exception ex){
					
					 JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(1080, 456, 103, 32);
		contentPane.add(btnNewButton);
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\register.png"));
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_1);
	}
}
