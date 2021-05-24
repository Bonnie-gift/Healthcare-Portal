package windowbuilder.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class Panel_adminmeal extends JPanel {
	private Vector data;
	private Vector names;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Panel_adminmeal() {
		data = new Vector();
		names = new Vector();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
					"");
			PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from ordering order by Time desc");
			ResultSet rs = st.executeQuery();

			Vector<Object> v = new Vector();

			while (rs.next()) {
				v.clear();
				v.add(rs.getObject(3));
				v.add(rs.getObject(5));
				v.add(rs.getObject(2));
				v.add(rs.getObject(4));
				data.add(v.clone()); 

			}
		} catch (Exception w1) {
			System.out.println(w1);
		}
		names.add("Time");
		names.add("username");
		names.add("mealname");
		names.add("location");
		initComponents();
		createEvents();
	}

	private void initComponents() {
		JLabel lblNewLabel = new JLabel("Meal");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		/*
		 * table = new JTable(new DefaultTableModel(data,names));
		 *
		 */
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
		);
		
		table =new JTable(new DefaultTableModel(data,names));
		//row height
		table.setRowHeight(60);

		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}

	private void createEvents() {

	}
}
