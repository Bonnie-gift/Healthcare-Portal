package windowbuilder.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import windowbuilder.common.health;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_Adminhealth extends JPanel {
	private Vector data;
	private Vector names;
	private JTable table;
    private health vP;
    private ArrayList<health> dataP=new ArrayList();
    private JButton btnBmi;
    private JButton btnH;
    private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public Panel_Adminhealth() {
		data = new Vector();
		names = new Vector();
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//format
        String date=df.format(new Date());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
					"");
			
			//PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from health_report,taking where (health_report.id=taking.reportid) ");
			//sql variable
			PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from health_report,taking where (health_report.id=taking.reportid) AND (taking.Time='" + date + "')");
			ResultSet rs = st.executeQuery();

			Vector<Object> v = new Vector();
			/*
			while (rs.next()) {
				v.clear();
				v.add(rs.getObject(1));
				v.add(rs.getObject(2));
				v.add(rs.getObject(3));
				v.add(rs.getObject(4));
				v.add(rs.getObject(5));
				v.add(rs.getObject(6));
				v.add(rs.getObject(7));
				data.add(v.clone());

			}*/
			while (rs.next()) {
			
				int height=(int) rs.getObject(1);
				int weight=(int)rs.getObject(2);
				String bp=(String) rs.getObject(3);
				int Hb=(int)rs.getObject(4);
				int reportid=(int)rs.getObject(5);
				String username=(String) rs.getObject(6);
				Date Time=(Date) rs.getObject(7);
				v.clear();
				v.add(rs.getObject(1));
				v.add(rs.getObject(2));
				v.add(rs.getObject(3));
				v.add(rs.getObject(4));
				v.add(rs.getObject(5));
				v.add(rs.getObject(6));
				v.add(rs.getObject(7));
				data.add(v.clone()); 
				vP=new health(height,weight,bp,Hb,reportid,username,Time);
				dataP.add(vP);
				

			}
		} catch (Exception w1) {
			w1.printStackTrace();
		}
		names.add("height");
		names.add("weight");
		names.add("BP");
		names.add("HB");
		names.add("reportid");
		names.add("username");
		names.add("Time");
		initComponents();
		createEvents();
	}

	private void initComponents() {
		JLabel lblNewLabel = new JLabel("health");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		
		scrollPane = new JScrollPane();
		
		btnBmi = new JButton("BMI");
		
		
		btnH = new JButton("HB");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(140)
					.addComponent(btnBmi, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnH, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addGap(70))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBmi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
		);
		
		table =new JTable(new DefaultTableModel(data,names));
		//设置行高
		table.setRowHeight(60);

		scrollPane.setViewportView(table);
		setLayout(groupLayout);
	}
	//sort in the ascending order of BMI
	public static class myCompare implements Comparator<Vector>{

		@Override
		public int compare(Vector x, Vector y) {
			// TODO 自动生成的方法存根
			int heightx=(int) x.get(0);
			int weightx=(int) x.get(1);
			double bmix=weightx*1.0/((heightx*1.0/100)*(heightx*1.0/100));
			int heighty=(int) y.get(0);
			int weighty=(int) y.get(1);
			double bmiy=weighty*1.0/((heighty*1.0/100)*(heighty*1.0/100));
			return (int) (bmix-bmiy);
		}
		
	}
	//sort in the ascending order of heartbeats
	public static class myCompare2 implements Comparator<Vector>{

		@Override
		public int compare(Vector x, Vector y) {
			// TODO 自动生成的方法存根
			int hbx=(int) x.get(3);
			int hby=(int) y.get(3);
			return hbx-hby;
		}
		
	}
	private void createEvents() {
		btnBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myCompare cmp=new myCompare();
				data.sort(cmp);
				initComponents();
			}
		});
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCompare2 cmp=new myCompare2();
				data.sort(cmp);
				initComponents();
			}
		});
	}
}
