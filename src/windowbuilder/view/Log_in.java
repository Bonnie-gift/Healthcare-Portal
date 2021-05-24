package windowbuilder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Log_in extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton buttonLog;
	private JPasswordField textField_Key;
	private String Ikey = "123456";
	private JButton btnNewButton;
	public static String ustr;
	private JComboBox comboBox;
	public static String role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// UIManager.put("RootPane.setupButtonVisible", false);
			// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// UImanager.set
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					break;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in frame = new Log_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_in() {

		initComponents();
		createEvents();

	}

	private void initComponents() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Care for the elderly");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		lblNewLabel.setIcon(new ImageIcon(Log_in.class.getResource("/windowbuilder/resource/economy 32.png")));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 28));
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 28));

		JLabel lblNewLabel_2 = new JLabel("");

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 28));

		textField_Key = new JPasswordField();
		textField_Key.setFont(new Font("宋体", Font.PLAIN, 28));
		textField_Key.setColumns(10);

		buttonLog = new JButton("Login");
		buttonLog.setFont(new Font("宋体", Font.PLAIN, 28));

		btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 28));

		JLabel lblNewLabel_4 = new JLabel("Role");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 28));

		comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 28));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Elderly" }));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(55)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, Alignment.LEADING))
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGap(29)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(buttonLog, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton,
										GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField, 301, 301, 301)
														.addComponent(textField_Key, 301, 301, 301))
												.addPreferredGap(ComponentPlacement.RELATED, 267, Short.MAX_VALUE))
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 244,
												GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(133).addComponent(lblNewLabel_2)
								.addGap(48))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(16)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4).addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(textField_Key, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(9)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonLog, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
				.addGap(75)));
		contentPane.setLayout(gl_contentPane);
	}

	private void createEvents() {
		buttonLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				role = comboBox.getSelectedItem().toString();
				// System.out.println(role);
				ustr = textField.getText();
				String pstr = textField_Key.getText();
				//elderly
				if (role.equals("Elderly")) {
					int i = 0, j = 0;
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
								"root", "");
						PreparedStatement st = (PreparedStatement) con.prepareStatement(
								"Select username,password from customer_table where username=? and password=?");
						st.setString(1, ustr);
						st.setString(2, pstr);
						ResultSet rs = st.executeQuery();
						if (rs.next()) {
							i = 1;
						} else {
							i = 0;
						}
					} catch (Exception w1) {
						System.out.println(w1);
					}

					if (i == 1) {
						dispose();
						Home frame4 = new Home();
						frame4.setVisible(true);
						JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
					}
				} else {
					// admin
					if (ustr.equals("Admin")&&pstr.equals("123456")) {
						dispose();
						virtual2 frame4 = new virtual2();
						frame4.setVisible(true);
						JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
					} else {
						JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
					}
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register frame3 = new Register();
				frame3.setVisible(true);
				dispose();
			}
		});

	}
}
