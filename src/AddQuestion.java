import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddQuestion extends JInternalFrame {
	private JTextField txtQuestion;
	private JTextField txtOp1;
	private JTextField txtOp2;
	private JTextField txtOp3;
	private JTextField txtOp4;
	private JTextField txtCA;
	private JLabel lblNewLabel_1;
	public AddQuestion() {

		setBounds(100, 100, 1300, 707);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		txtQuestion = new JTextField();
		txtQuestion.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtQuestion.setBounds(228, 24, 796, 87);
		getContentPane().add(txtQuestion);
		txtQuestion.setColumns(10);
		
		txtOp1 = new JTextField();
		txtOp1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOp1.setBounds(228, 174, 796, 46);
		getContentPane().add(txtOp1);
		txtOp1.setColumns(10);
		
		txtOp2 = new JTextField();
		txtOp2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOp2.setColumns(10);
		txtOp2.setBounds(228, 245, 796, 46);
		getContentPane().add(txtOp2);
		
		txtOp3 = new JTextField();
		txtOp3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOp3.setColumns(10);
		txtOp3.setBounds(228, 320, 796, 46);
		getContentPane().add(txtOp3);
		
		txtOp4 = new JTextField();
		txtOp4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOp4.setColumns(10);
		txtOp4.setBounds(228, 390, 796, 46);
		getContentPane().add(txtOp4);
		
		txtCA = new JTextField();
		txtCA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCA.setColumns(10);
		txtCA.setBounds(228, 480, 796, 46);
		getContentPane().add(txtCA);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.lightGray);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Connection cn=MyData.getConnection();
				String query="insert into questions(question, op1,op2,op3,op4,ca) values(?,?,?,?,?,?)";
				PreparedStatement st=cn.prepareStatement(query);
				st.setString(1, txtQuestion.getText());
				st.setString(2, txtOp1.getText());
				st.setString(3, txtOp2.getText());
				st.setString(4, txtOp3.getText());
				st.setString(5, txtOp4.getText());
				st.setString(6, txtCA.getText());
				st.executeUpdate();
				cn.close();
				 JOptionPane.showMessageDialog(null,"Data Saved: ");
			}
			catch(Exception ex){
				 JOptionPane.showMessageDialog(null,ex.getMessage());
			}
		}
	});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(228, 574, 85, 33);
		getContentPane().add(btnNewButton);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\addQuestion.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		getContentPane().add(lblNewLabel_1);
		
	}

}
