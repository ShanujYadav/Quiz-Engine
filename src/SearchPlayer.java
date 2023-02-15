import java.awt.EventQueue;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchPlayer extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private Connection cn;
	String n="";
	private Component scrollPane;
	private JLabel lblNewLabel_1;
	void fill() {
		try {
			String query="select * from player";
			cn=MyData.getConnection();
			PreparedStatement st=cn.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			DefaultTableModel dt=new DefaultTableModel();
			dt.addColumn("SR_No");
			dt.addColumn("name");
			dt.addColumn("Password");
			dt.addColumn("Marks");
			
			while(rs.next()) {
				String row[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),};
				dt.addRow(row);
			}
			table.setModel(dt);
			cn.close();
		}
		catch(Exception e){
		}
	}
	void fill(String n) {
		try {
			String query="select * from player where SR_No is like '"+n+"%' or name is like '"+n+"%'";
			cn=MyData.getConnection();
			PreparedStatement st=cn.prepareStatement(query);
			ResultSet rs=st.executeQuery();
			DefaultTableModel dt=new DefaultTableModel();
			dt.addColumn("SR_No");
			dt.addColumn("name");
			dt.addColumn("Password");
			dt.addColumn("Marks");
			
			while(rs.next()) {
				String row[]= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),};
				dt.addRow(row);
			}
			table.setModel(dt);
			cn.close();
		}
		catch(Exception e){
		}
	}
	public SearchPlayer() {
		setBounds(0, 0, 1101, 609);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			fill(textField.getText());
			}
		});
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\searchPlayer.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 1920,1080);
		getContentPane().add(lblNewLabel_1);

		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(textField,BorderLayout.NORTH);
		textField.setColumns(10);
		
		
		table = new JTable();
		JScrollPane scrollPane=new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		//lblNewLabel_1.add(scrollPane);
		fill();
	}
}
