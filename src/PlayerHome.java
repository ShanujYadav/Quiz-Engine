import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.*;

public class PlayerHome extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_1;

	ArrayList<Question> questions = new ArrayList<Question>();
	private Connection cn;
	int index;
	int score;
	private JLabel lblNewLabel;
	private Question q;
	private JLabel lblNewLabel_1;
	int a;
	ArrayList<Integer> attempted = new ArrayList<>();
	private ButtonGroup gp;

	void change() {
		if (rdbtnNewRadioButton.isSelected() && q.getOp1().equals(q.getCa()))
			score++;
		else if (rdbtnNewRadioButton_1.isSelected() && q.getOp2().equals(q.getCa()))
			score++;
		else if (rdbtnNewRadioButton_2.isSelected() && q.getOp3().equals(q.getCa()))
			score++;
		else if (rdbtnNewRadioButton_3.isSelected() && q.getOp4().equals(q.getCa()))
			score++;
		index++;
		if (index < questions.size()) {
			q = questions.get(index);
			lblNewLabel.setText(q.getQuestion());
			rdbtnNewRadioButton.setText(q.getOp1());
			rdbtnNewRadioButton_1.setText(q.getOp2());
			rdbtnNewRadioButton_2.setText(q.getOp3());
			rdbtnNewRadioButton_3.setText(q.getOp4());
		} else {
			JOptionPane.showMessageDialog(null, "Your Score is.." + score);
			try {
				Connection cn = MyData.getConnection();
				String query = "update player set marks=? where SR_No=?";
				PreparedStatement st = cn.prepareStatement(query);
				st.setInt(1, score);
				st.setString(2, Login.sr_no);
				st.executeUpdate();
				cn.close();
			} catch (Exception ex) {
			}
			PlayerHome.this.dispose();
		}
	}

	void fillQuestions() {
		try {
			String query = "select * from questions";
			cn = MyData.getConnection();
			PreparedStatement st = cn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Question q = new Question(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				questions.add(q);
			}
			cn.close();
		} catch (Exception e) {
		}
	}

	public PlayerHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(169, 32, 849, 99);
		contentPane.add(lblNewLabel);

		rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(169, 179, 836, 41);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(169, 253, 836, 41);
		contentPane.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(169, 325, 836, 41);
		contentPane.add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(169, 399, 836, 41);
		contentPane.add(rdbtnNewRadioButton_3);

		gp = new ButtonGroup();
		gp.add(rdbtnNewRadioButton);
		gp.add(rdbtnNewRadioButton_1);
		gp.add(rdbtnNewRadioButton_2);
		gp.add(rdbtnNewRadioButton_3);

		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setBackground(Color.lightGray);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// rdbtnNewRadioButton.setSelected(false);
				// rdbtnNewRadioButton_1.setSelected(false);
				// rdbtnNewRadioButton_2.setSelected(false);
				// rdbtnNewRadioButton_3.setSelected(false);
				// gp.clearSelection();
				change();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(169, 517, 85, 30);
		contentPane.add(btnNewButton);
		fillQuestions();

		Collections.shuffle(questions); //

		q = questions.get(index);
		lblNewLabel.setText(q.getQuestion());
		rdbtnNewRadioButton.setText(q.getOp1());
		rdbtnNewRadioButton_1.setText(q.getOp2());
		rdbtnNewRadioButton_2.setText(q.getOp3());
		rdbtnNewRadioButton_3.setText(q.getOp4());

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\playerHome.png"));
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_1);

	}
}