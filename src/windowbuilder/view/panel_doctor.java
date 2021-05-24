package windowbuilder.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class panel_doctor extends JPanel {
	private JTextField textFielddoctorid;
	private JTextField txtTime;
	private JButton btnSubmit;
	public static int iddoctor=1;
	public static String date;
	public static String Btime="12331212121212";
	public static String Etime="12331212121213";
	//Time:20201212121212
	//Time:20201212121213
	/**
	 * Create the panel.
	 */
	public panel_doctor() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		init();
		createEvents();

	}

	private void init() {
	
		setBackground(new java.awt.Color(255, 255, 255));
        
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.controlHighlight);
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(panel_doctor.class.getResource("/windowbuilder/resource/doctor64px.png")));
        label.setForeground(new Color(45, 118, 232));
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel label_1 = new JLabel();
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(46)
        			.addComponent(label_1)
        			.addGap(59))
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(34)
        			.addComponent(label, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        			.addGap(42))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGap(22)
        			.addComponent(label_1)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(label, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        			.addGap(25))
        );
        panel.setLayout(gl_panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.controlHighlight);
        
        JLabel label_2 = new JLabel();
        label_2.setIcon(new ImageIcon(panel_doctor.class.getResource("/windowbuilder/resource/doctor64px.png")));
        label_2.setForeground(new Color(45, 118, 232));
        label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel label_3 = new JLabel();
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(46)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.CENTER)
        				.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(label_3))
        			.addGap(59))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(22)
        			.addComponent(label_3)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(label_2)
        			.addContainerGap(71, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.controlHighlight);
        
        JLabel label_4 = new JLabel();
        label_4.setIcon(new ImageIcon(panel_doctor.class.getResource("/windowbuilder/resource/doctor64px.png")));
        label_4.setForeground(new Color(45, 118, 232));
        label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel label_5 = new JLabel();
        label_5.setFont(new Font("宋体", Font.PLAIN, 26));
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGap(46)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.CENTER)
        				.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(label_5))
        			.addGap(59))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGap(22)
        			.addComponent(label_5)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        			.addGap(22))
        );
        panel_2.setLayout(gl_panel_2);
        
        JLabel lblNewLabel = new JLabel("Dr.A\uFF08cough\uFF09");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 27));
        
        JLabel lblNewLabel_1 = new JLabel("Dr.B(headache)");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 27));
        
        JLabel lblNewLabel_2 = new JLabel("Dr.C toothache");
        
        JLabel lblNewLabel_3 = new JLabel("Dr. D fever");
        
        JLabel lblNewLabel_4 = new JLabel("choose_doctor");
        lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 30));
        
        textFielddoctorid = new JTextField();
        textFielddoctorid.setFont(new Font("宋体", Font.PLAIN, 30));
        textFielddoctorid.setColumns(10);
        
        JLabel lblChoosetime = new JLabel("choose_Time");
        lblChoosetime.setFont(new Font("宋体", Font.PLAIN, 30));
        
        txtTime = new JTextField();
        txtTime.setText("Notes:Time_Begin and Time End");
        txtTime.setFont(new Font("宋体", Font.PLAIN, 30));
        txtTime.setColumns(10);
        
        btnSubmit = new JButton("Submit");
       
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.controlHighlight);
        
        JLabel label_6 = new JLabel();
        label_6.setIcon(new ImageIcon(panel_doctor.class.getResource("/windowbuilder/resource/doctor64px.png")));
        label_6.setForeground(new Color(45, 118, 232));
        label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel label_7 = new JLabel();
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addGap(46)
        			.addGroup(gl_panel_3.createParallelGroup(Alignment.CENTER)
        				.addComponent(label_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(label_7))
        			.addGap(59))
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addGap(22)
        			.addComponent(label_7)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        			.addGap(22))
        );
        panel_3.setLayout(gl_panel_3);
        
        JLabel lblYourPrivateDoctor = new JLabel("your private doctors");
        lblYourPrivateDoctor.setForeground(new Color(30, 144, 255));
        lblYourPrivateDoctor.setFont(new Font("宋体", Font.PLAIN, 40));
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(panel_doctor.class.getResource("/swing/images/heart.png")));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(this);
        jPanel6Layout.setHorizontalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(21)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addGap(9)
        							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblNewLabel))
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblNewLabel_2))))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(29)
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(12)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addComponent(textFielddoctorid)
        							.addGap(30))
        						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 156, Short.MAX_VALUE)))
        				.addGroup(Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(txtTime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addGap(6)
        							.addComponent(lblChoosetime, GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE))
        						.addComponent(btnSubmit, Alignment.LEADING))
        					.addGap(18)))
        			.addGap(18)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(lblNewLabel_1))
        				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(2)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNewLabel_3))))
        			.addGap(0))
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_5)
        				.addComponent(lblYourPrivateDoctor))
        			.addGap(132))
        );
        jPanel6Layout.setVerticalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(lblYourPrivateDoctor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textFielddoctorid, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
        			.addGap(2)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel)
        						.addComponent(lblNewLabel_1))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel_2)
        						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addGroup(Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
        					.addComponent(lblChoosetime)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnSubmit)
        					.addGap(29)))
        			.addGap(0))
        );
        setLayout(jPanel6Layout);
	}
	private void createEvents() {
		 btnSubmit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		iddoctor=Integer.parseInt(textFielddoctorid.getText());
	        		date=txtTime.getText();
	        		 Btime=date.split(" ")[0];
	        		 Etime=date.split(" ")[1];
	        		try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
								"root", "");
						PreparedStatement st = (PreparedStatement) con.prepareStatement(
								"insert into making_appointment(username,iddoctor,TimeBegin,TimeEnd) values(?,?,?,?)");
						st.setString(1, Log_in.ustr);
						st.setInt(2, iddoctor);
						st.setString(3, Btime);
						st.setString(4, Etime);
						int row = st.executeUpdate();
					
					} catch (Exception w1) {
						System.out.println(w1);
					}
					JOptionPane.showMessageDialog(btnSubmit, "You have successfully had an appointment");
	        	}
	        });
		
	}
}
