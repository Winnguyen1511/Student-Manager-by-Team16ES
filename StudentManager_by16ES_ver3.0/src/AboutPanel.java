package studentManager1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AboutPanel extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Close");
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AboutPanel() {
		setResizable(false);
		setTitle("About Student Manager-by Team16ES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.SOUTH);
		btnNewButton.setToolTipText("");
		btnNewButton.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(581, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\tai_lieu\\PROGRAMMING_C++\\OOP\\JAVA\\cheatingES.png"));
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.window);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JTextPane txtpnStudentManagerVersion = new JTextPane();
		txtpnStudentManagerVersion.setText("Student Manager \r\n\r\nVersion 3.0 (2019)\r\nBuild by Team16ES\r\nSenior Contributor: Nguyen Huynh Dang Khoa (Win Nguyen)\r\n\r\n(c)Copyright Team3_16ES contributors. All rights reserved. All infomation about the 16ES logo and Student Manager can be found at https://www.facebook.com/win.nguyen.5680.\r\n\r\nNote that this product is open source.");
		txtpnStudentManagerVersion.setBounds(0, 0, 574, 171);
		panel_2.add(txtpnStudentManagerVersion);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\tai_lieu\\PROGRAMMING_C++\\OOP\\JAVA\\win.png"));
		lblNewLabel_1.setBounds(0, 170, 77, 72);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\tai_lieu\\PROGRAMMING_C++\\OOP\\JAVA\\hien.png"));
		lblNewLabel_2.setBounds(74, 170, 76, 72);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\tai_lieu\\PROGRAMMING_C++\\OOP\\JAVA\\linh.png"));
		lblNewLabel_3.setBounds(149, 170, 77, 72);
		panel_2.add(lblNewLabel_3);
		
		btnNewButton.addActionListener(this);
		this.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton)
			dispose();
	}
}
