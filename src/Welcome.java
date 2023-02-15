import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private String name;
	private Connection cn;
	

	String getName(String srno)
	{
		String name="";
		try {
			 cn=MyData.getConnection();
			String query="select name from player where SR_No=?";
			PreparedStatement st=cn.prepareStatement(query);
			st.setString(1, srno);
			
			ResultSet rs=st.executeQuery();
			rs.next();
			name=rs.getString(1);
			
		}
		catch(Exception ex){
			
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return name;
		
	}
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome! "+getName(Login.sr_no));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblNewLabel.setBounds(642, 24, 459, 137);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setBackground(Color.lightGray);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerHome ph=new PlayerHome();
				ph.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1214, 490, 118, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome, You will be Given a Quiz.\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(642, 223, 849, 64);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Good Luck.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(642, 284, 181, 50);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\welcome.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_1);
	}

}
