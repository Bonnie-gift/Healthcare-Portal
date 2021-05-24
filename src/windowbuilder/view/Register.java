package windowbuilder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.put("RootPane.setupButtonVisible", false);
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					Register frame = new Register();
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
	public Register() {
		initComponents();
		createEvents();
		
	}
	private void initComponents() {
		setTitle("register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 873);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// picture auto-adjust
      JLabel lblNewLabel = new JLabel("R"){
		protected void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("C:\\Users\\hm\\eclipse-workspace2\\Software_designed_for_the_elderly\\src\\windowbuilder\\resource\\register.jpg");
			g.drawImage(icon.getImage(), 0, 0, getWidth(),getHeight(),
			icon.getImageObserver());
			}
	};
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("username");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 30));
		
		passwordField = new JPasswordField();
		
		btnNewButton = new JButton("submit");
		//JLabel lblNewLabel = new JLabel("");		
		//ImageIcon icon = new ImageIcon("/windowbuilder/resource/register.jpg");	    
		//icon.setImage(icon.getImage().getScaledInstance(1000,0.1,Image.SCALE_DEFAULT));//80和100为大小 可以自由设置		
		//lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("C:\\Users\\hm\\eclipse-workspace2\\Software_designed_for_the_elderly\\src\\windowbuilder\\resource\\register.jpg")));
		//setIcon("/windowbuilder/resource/register.jpg",lblNewLabel);
		//lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/windowbuilder/resource/register.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(178)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(234, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, 178, 178, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
								.addComponent(passwordField))
							.addGap(234))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnNewButton)
					.addContainerGap(312, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id_card=textField.getText();
				String uname=textField_1.getText();
				String pword=passwordField.getText();
				
				//add a record to database
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
							"root", "");
					PreparedStatement st = (PreparedStatement) con.prepareStatement(
							"insert into customer_table(username,password,id_card) values(?,?,?)");
					st.setString(1, uname);
					st.setString(2, pword);
					st.setString(3, id_card);
					int row = st.executeUpdate();
				
				} catch (Exception w1) {
					System.out.println(w1);
				}
				JOptionPane.showMessageDialog(btnNewButton, "You have successfully registered");
				Log_in frame2=new Log_in();
				frame2.setVisible(true);
				dispose();
			}
		});
		
	}

	public void setIcon(String file,JLabel com){
		ImageIcon ico=new ImageIcon(file);
		Image temp=ico.getImage().getScaledInstance(com.getWidth(),com.getHeight(),ico.getImage().SCALE_DEFAULT);
		ico=new ImageIcon(temp);
		com.setIcon(ico);
  }
}
