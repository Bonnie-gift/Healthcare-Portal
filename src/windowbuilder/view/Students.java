package windowbuilder.view;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import java.awt.Graphics;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Bonnie
 */
public class Students extends javax.swing.JFrame {
	public static String balance="0";
	public static String recharge="0";
    /**
     * Creates new form Home_Data
     */
    public Students() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
 
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(45, 118, 232));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/group_52px_1.png"))); // NOI18N
        jLabel15.setText("Recharge");
        
        label = new JLabel();
        label.setText("Welcome "+Log_in.ustr+"!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Verdana", Font.BOLD, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(69)
        			.addComponent(jLabel15)
        			.addGap(59)
        			.addComponent(label, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(328, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(40)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel15)
        				.addComponent(label, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);
        //JLabel lblNewLabel = new JLabel("R");
        //lblNewLabel.setIcon(new ImageIcon(Students.class.getResource("/windowbuilder/resource/credit-card 512.png")));
        JLabel lblNewLabel = new JLabel("R"){
    		protected void paintComponent(Graphics g) {
    			ImageIcon icon = new ImageIcon("C:\\Users\\hm\\eclipse-workspace2\\Project4_care_for_the_elderly\\src\\windowbuilder\\resource\\credit-card 512.png");
    			g.drawImage(icon.getImage(), 0, 0, getWidth(),getHeight(),
    			icon.getImageObserver());
    			}
    	};
        
        lblBalance = new JLabel();
        lblBalance.setText("Balance:");
        lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
        lblBalance.setForeground(Color.BLACK);
        lblBalance.setFont(new Font("Verdana", Font.BOLD, 24));
        
        
        //get balance of the account.
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
					"root", "");
			PreparedStatement st = (PreparedStatement) con.prepareStatement(
					"Select username,password, Balance from customer_table where username=?");
			st.setString(1, Log_in.ustr);
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			balance=rs.getString("Balance");
			}
			
		} catch (Exception w1) {
			System.out.println(w1);
		}
        label_1 = new JLabel();
        label_1.setText(balance+" dollars");
        //
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setForeground(Color.BLACK);
        label_1.setFont(new Font("Verdana", Font.BOLD, 24));
        
        lblRecharge = new JLabel();
        lblRecharge.setText("Recharge:");
        lblRecharge.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecharge.setForeground(Color.BLACK);
        lblRecharge.setFont(new Font("Verdana", Font.BOLD, 24));
        
        textField = new JTextField();
        textField.setFont(new Font("Verdana", Font.BOLD, 24));
        textField.setColumns(10);
    	
        
        
        btnUpdate = new JButton("UPDATE");
        btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 24));
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//update the mysql balance
        		//get the recharge
                recharge=textField.getText();
                int input_m=Integer.parseInt(recharge);
                int init=Integer.parseInt(balance);
        		try {
        			Class.forName("com.mysql.jdbc.Driver");
        			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/elderly",
        					"root", "");
        			PreparedStatement st = (PreparedStatement) con.prepareStatement(
        					"update customer_table set Balance=? where username=?");
        			String cM=(input_m+init)+"";
        			
        			st.setString(1, cM);
        			st.setString(2, Log_in.ustr);
        			int row = st.executeUpdate();;
        			
        		} catch (Exception w1) {
        			System.out.println(w1);
        		}
        		//balance=(input_m+init)+"";
        		label_1.setText((input_m+init)+" "+"dollars");
        	}
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(62)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
        					.addGap(4)
        					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblRecharge, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
        					.addGap(36)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnUpdate)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(65)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(91)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblRecharge, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnUpdate)))
        			.addContainerGap(103, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Students().setVisible(true);
            }
        });
    }

  
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private JLabel label;
    private JLabel lblBalance;
    private JLabel label_1;
    private JLabel lblRecharge;
    private JTextField textField;
    private JButton btnUpdate;
}
