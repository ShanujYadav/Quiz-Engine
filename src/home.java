import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class home extends JFrame {
	private Container desktopPane;
	private JPanel contentPane;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel lblNewLabel_1;
	
	public home() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Player");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("AddPlayer");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("SearchPlayer");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchPlayer sp=new SearchPlayer();
				sp.setVisible(true);
				contentPane.add(sp);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		mnNewMenu_1 = new JMenu("Questions");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("AddQuestion");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddQuestion ad=new AddQuestion();
				ad.setVisible(true);
				contentPane.add(ad);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
	
	desktopPane=new JDesktopPane();
		contentPane.add(desktopPane,BorderLayout.CENTER);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quiz\\bin\\home.png"));
		lblNewLabel_1.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
