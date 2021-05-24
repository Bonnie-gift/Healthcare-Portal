package windowbuilder.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Panel_medicine extends JPanel {
	private JButton btnNewButton;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public Panel_medicine() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnNewButton = new JButton("");
		
		btnNewButton.setIcon(new ImageIcon(Panel_medicine.class.getResource("/swing/images/heart.png")));
		
		JLabel lblNewLabel = new JLabel("Tips for taking medcine");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 50));
		scrollPane.setViewportView(textArea);
		setLayout(groupLayout);
		
		initComponents();
		createEvents();
	}
	private void initComponents() {
		
	setBackground(new java.awt.Color(255, 255, 255));
	}
	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			//there is some place to be improved for several records
			//get instructions of which kind of medicine to take from the doctor
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
							"root", "");
					PreparedStatement st = (PreparedStatement) con.prepareStatement(
							"Select Description from response where iddoctor=? and Timebegin=? and TimeEnd=?");
					st.setInt(1, panel_doctor.iddoctor);
					st.setString(2,panel_doctor.Btime);
					st.setString(3,panel_doctor.Etime);
					ResultSet rs = st.executeQuery();
					
					if(rs.next()) {
					textArea.setText(rs.getString("Description"));
					}
				} catch (Exception w1) {
					System.out.println(w1);
				}
				JOptionPane.showMessageDialog(btnNewButton, "Success");
				
			}
		});
	}
}
