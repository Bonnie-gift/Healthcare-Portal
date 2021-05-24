package windowbuilder.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order_Meal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldid;
	private JTextField textField_1;
	private JTextField textField_2;
	private Vector data;
	private Vector names;
	private String date;
	private JButton btnSubmit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_Meal frame = new Order_Meal();
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
	public Order_Meal() {
		 
		data = new Vector();
		names = new Vector();
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式  
         date=df.format(new Date());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
					"");
			
			//PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from health_report,taking where (health_report.id=taking.reportid) ");
			//sql语句中使用变量
			PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from meal");
			ResultSet rs = st.executeQuery();

			Vector<Object> v = new Vector();
			while (rs.next()) {
				v.clear();
				v.add(rs.getObject(1));
				v.add(rs.getObject(2));
				//v.add(rs.getObject(3));
				v.add(rs.getObject(4));
				
				//v.add(new Boolean(false));
				//v.add(new JButton());
				data.add(v.clone()); // 注意此处不能用 data.add(v);

			}
		} catch (Exception w1) {
			System.out.println(w1);
		}
		names.add("meal id");
		names.add("meal name");
		names.add("prize");
		
		init();
		createEvents();
		
	}
	private void init() {
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 879);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Order_Meal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Meal id");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		
		textFieldid = new JTextField();
		textFieldid.setFont(new Font("Verdana", Font.PLAIN, 30));
		textFieldid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Meal name");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 35));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("location");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 35));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		textField_2.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		
		btnSubmit.setFont(new Font("Verdana", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(83)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSubmit)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(406, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(85)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addComponent(btnSubmit)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table =new JTable(new DefaultTableModel(data,names));
		table.setFont(new Font("Verdana", Font.PLAIN, 30));
		table.setRowHeight(60);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	private void createEvents() {
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mealid=textFieldid.getText();
				String mealname = "";
				String balance=Students.balance;
				
				int prize=0;
				String location=textField_2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
							"");
					
					//PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from health_report,taking where (health_report.id=taking.reportid) ");
					//use variable in sql statements
					PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from meal where meal.mealid='" + mealid + "'");
					ResultSet rs = st.executeQuery();
					if(rs.next()) {
						mealname=rs.getString("mealname");
						 prize=rs.getInt("prize");
					}
					PreparedStatement st2 = (PreparedStatement) con.prepareStatement(
							"insert into ordering(mealid,mealname,Time,location,username) values(?,?,?,?,?)");
					st2.setString(1, mealid);
					st2.setString(2, mealname);
					st2.setString(3, date);
					st2.setString(4, location);
					st2.setString(5, Log_in.ustr);
					System.out.print(prize);
					int row = st2.executeUpdate();
			
					
				} catch (Exception w1) {
					System.out.println(w1);
				}
				JOptionPane.showMessageDialog(btnSubmit, "You have successfully paid ");
			}
		});
	}
}
