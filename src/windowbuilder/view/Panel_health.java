package windowbuilder.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Panel_health extends JPanel {
	private javax.swing.JPanel jPanel6;
	private JTextField textField_H;
	private JTextField textField_W;
	private JTextField textField_B;
	private JButton btnNewButton;
	public int height=-1;
	public int weight=-1;
	public int Bloodp=-1;
	public int Heartb=-1;
	public static String date="";
	private JTextField textField_HB;
	/**
	 * Create the panel.
	 */
	public Panel_health() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		init();
		createEvents();
	}
	private void init() {
	
		setBackground(Color.WHITE);
        
        JLabel lblHealth = new JLabel("Please input the info");
        lblHealth.setFont(new Font("Verdana", Font.BOLD, 30));
        lblHealth.setForeground(new Color(100, 149, 237));
        
        JLabel lblNewLabel = new JLabel("Height/cm  ");
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 26));
        
        textField_H = new JTextField();
        textField_H.setFont(new Font("宋体", Font.BOLD, 26));
        textField_H.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Weight/Kg  ");
        lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 26));
        
        textField_W = new JTextField();
        textField_W.setFont(new Font("宋体", Font.BOLD, 26));
        textField_W.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("BP/mmHg   ");
        lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 26));
        
        textField_B = new JTextField();
        textField_B.setFont(new Font("宋体", Font.BOLD, 26));
        textField_B.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("HeartB/bmp");
        lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 26));
        
        textField_HB = new JTextField();
        textField_HB.setFont(new Font("宋体", Font.BOLD, 26));
        textField_HB.setColumns(10);
        
        btnNewButton = new JButton("Submit");
        
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 26));
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(Panel_health.class.getResource("/windowbuilder/resource/heart 256.png")));
      
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(this);
        jPanel6Layout.setHorizontalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(lblHealth))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addComponent(lblNewLabel)
        							.addGap(18)
        							.addComponent(textField_H, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_1)
        							.addGap(18)
        							.addComponent(textField_W, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_2)
        							.addGap(18)
        							.addComponent(textField_B, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addComponent(lblNewLabel_3)
        							.addGap(18)
        							.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(btnNewButton)
        								.addComponent(textField_HB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblHealth)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel)
        						.addComponent(textField_H, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_1)
        						.addComponent(textField_W, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_2)
        						.addComponent(textField_B, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_HB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_3))
        					.addGap(1)
        					.addComponent(btnNewButton))
        				.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
        );
        setLayout(jPanel6Layout);
	}
	private void createEvents() {
		 btnNewButton.addActionListener(new ActionListener() {
			 //insert health info
	        	public void actionPerformed(ActionEvent arg0) {
	        		height=Integer.parseInt(textField_H.getText());
	        		weight=Integer.parseInt(textField_W.getText());
	        		Bloodp=Integer.parseInt(textField_B.getText());
	        		Heartb=Integer.parseInt(textField_HB.getText());
	        		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//date format
	                date=df.format(new Date());
	        		try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
								"root", "");
						PreparedStatement st = (PreparedStatement) con.prepareStatement(
								"insert into health_report(height,weight,blood_pressure,heart_beats) values(?,?,?,?)");
						st.setInt(1, height);
						st.setInt(2, weight);
						st.setInt(3, Bloodp);
						st.setInt(4, Heartb);
						int row = st.executeUpdate();
						PreparedStatement st2 = (PreparedStatement) con.prepareStatement(
								"insert into taking(username,Time) values(?,?)");
						st2.setString(1, Log_in.ustr);
						st2.setString(2, date);
						int row2 = st2.executeUpdate();
					
					} catch (Exception w1) {
						System.out.println(w1);
					}
					JOptionPane.showMessageDialog(btnNewButton, "You have successfully submitted your health information");
	        	}
	        });
		
		
	}
}
