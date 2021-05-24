package windowbuilder.view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView.TableRow;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class Panel_Admindoctor extends JPanel {
	private Vector data;
	private Vector names;
	private JTable table;
	private JPopupMenu m_popupMenu;
	int focusedRowIndex;
	static String text2;
	static String username="";
 	  static int iddoctor=0;
 	  static String TimeBegin="";
 	  static String TimeEnd="";
	/**
	 * Create the panel.
	 */
	public Panel_Admindoctor() {
		data = new Vector();
		names = new Vector();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(new Date());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
					"");
			
			//PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from health_report,taking where (health_report.id=taking.reportid) ");
			//sql:variable used in sql statements
			PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from making_appointment");
			ResultSet rs = st.executeQuery();

			Vector<Object> v = new Vector();
			Object input5="description";
			while (rs.next()) {
				v.clear();
				v.add(rs.getObject(1));
				v.add(rs.getObject(2));
				v.add(rs.getObject(3));
				v.add(rs.getObject(4));
				data.add(v.clone());

			}
		} catch (Exception w1) {
			System.out.println(w1);
		}
		names.add("user");
		names.add("iddoctor");
		names.add("TimeBegin");
		names.add("TimeEnd");
		names.add("checkbox_app");
		names.add("description");
		
		initComponents();
		createPopupMenu();
		createEvents();
		
	}

	private void initComponents() {
		JLabel lblNewLabel = new JLabel("doctor");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btnBmi = new JButton("BMI");
		
		JButton btnH = new JButton("HB");
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
		TableColumn column = table.getColumnModel().getColumn(4);
		column.setCellEditor(table.getDefaultEditor(Boolean.class));
		column.setCellRenderer(table.getDefaultRenderer(Boolean.class));
	
		
		/*
		TableColumn sportColumn = table.getColumnModel().getColumn(5);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Snowboarding");
		comboBox.addItem("Rowing");
		comboBox.addItem("Chasing toddlers");
		comboBox.addItem("Speed reading");
		comboBox.addItem("Teaching high school");
		comboBox.addItem("None");
		sportColumn.setCellEditor(table.getDefaultEditor(comboBox.getClass()));
		sportColumn.setCellRenderer(table.getDefaultRenderer(comboBox.getClass()));
		*/
		//TableColumnModel tcm =table.getColumnModel();
		//tcm.getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()));

		//设置行高
		
		table.setRowHeight(60);
		 //FitTableColumns(table);
		 table.getColumnModel().getColumn(5).setWidth(1250);
		scrollPane.setViewportView(table);
		
		setLayout(groupLayout);
		
	}

	 public void FitTableColumns(JTable myTable) {
	        JTableHeader header = myTable.getTableHeader();
	        int rowCount = myTable.getRowCount();

	        Enumeration columns = myTable.getColumnModel().getColumns();
	        while (columns.hasMoreElements()) {
	            TableColumn column = (TableColumn) columns.nextElement();
	            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
	            int width = (int) myTable.getTableHeader().getDefaultRenderer()
	                    .getTableCellRendererComponent(myTable, column.getIdentifier(), false, false,
	                            -1, col).getPreferredSize().getWidth();
	            for (int row = 0; row < rowCount; row++) {
	                int preferedWidth = (int) myTable.getCellRenderer(row, col)
	                        .getTableCellRendererComponent(myTable, myTable.getValueAt(row, col),
	                                false, false, row, col).getPreferredSize().getWidth();
	                width = Math.max(width, preferedWidth);
	            }
	            header.setResizingColumn(column); // 此行很重要
	            column.setWidth(width + myTable.getIntercellSpacing().width);
	        }
	    }

	 private void createPopupMenu() {
        m_popupMenu = new JPopupMenu();
        
        JMenuItem delMenItem = new JMenuItem();
        delMenItem.setText(" add description  ");
        delMenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int Srow=focusedRowIndex;
            	 try {
              
         			Class.forName("com.mysql.jdbc.Driver");
         			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly", "root",
         					"");
         			
         			//PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from health_report,taking where (health_report.id=taking.reportid) ");
         			//sql语句中使用变量
         			PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from making_appointment");
         			ResultSet rs = st.executeQuery();
         			while (rs.next()) {
       				if(rs.getRow()==Srow+1) {
       					username=rs.getString("username");
       					iddoctor=rs.getInt("iddoctor");
       					TimeBegin=rs.getString("TimeBegin");
       					TimeEnd=rs.getString("TimeEnd");
       				}
       				
       			}
         			/*
         			System.out.println(Srow);
         			System.out.println(username);
         			System.out.println(TimeBegin);
         			System.out.println(TimeEnd);
         			System.out.println(text2);
         			*/
         			
         		} catch (Exception w1) {
         			System.out.println(w1);
         		}
               InDescription des=new InDescription();
               des.setVisible(true);
              
             
            }
        });
        m_popupMenu.add(delMenItem);
    }

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
 
       mouseRightButtonClick(evt);
}
//event for right clicking mouse
private void mouseRightButtonClick(java.awt.event.MouseEvent evt) {
   
    if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
        //find the row of table by clicking mouse
         focusedRowIndex = table.rowAtPoint(evt.getPoint());
        if (focusedRowIndex == -1) {
            return;
        }
        //right moused clicked on the table 
        table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
        //pop up menu
        m_popupMenu.show(table, evt.getX(), evt.getY());
    }

}
	 //clicked
	private void createEvents() {

table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
});
}
}

