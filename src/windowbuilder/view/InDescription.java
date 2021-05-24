package windowbuilder.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class InDescription extends JFrame {

	private JPanel contentPane;
	public JTextArea textArea;
	public static String text="";
	private JButton btnSubmit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InDescription frame = new InDescription();
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
	public InDescription() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Panel_Admindoctor.text2=textArea.getText();
				try {
	         			Class.forName("com.mysql.jdbc.Driver");
	         			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
	         					"");
	         			
	         			PreparedStatement st2 = (PreparedStatement) con.prepareStatement(
	   						"insert into response(username,iddoctor,Timebegin,TimeEnd,Description) values(?,?,?,?,?)");
	   				st2.setString(1, Panel_Admindoctor.username);
	   				st2.setInt(2, Panel_Admindoctor.iddoctor);
	   				st2.setString(3, Panel_Admindoctor.TimeBegin);
	   				st2.setString(4, Panel_Admindoctor.TimeEnd);
	   				st2.setString(5, Panel_Admindoctor.text2);
	   				int row = st2.executeUpdate();
	         			
	         		} catch (Exception w1) {
	         			System.out.println(w1);
	         		}
				   dispose();
	              
	             
	            }
	        });
				
			
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnSubmit))
		);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.BOLD, 30));
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
}
