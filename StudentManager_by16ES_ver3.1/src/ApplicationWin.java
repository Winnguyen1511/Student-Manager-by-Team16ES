package studentManager1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class ApplicationWin implements ActionListener
{	
	public static boolean saveStatus = true;

	private class waitClass extends Thread
	{
		public void run() {
			saveStatus = false;
			workspaceFrame.getContentPane().removeAll();
//			workspaceFrame.getContentPane()
			temp = new EditInterface(master);
			workspaceFrame.getContentPane().add(temp.getContentPane());
			workspaceFrame.repaint();
		}
	}
	waitClass waitblock;
	private class loginInterface extends Thread implements ActionListener
	{
		private JFrame frame;
		private String username = "khoanguyen1507dn@gmail.com";
		private String password = "khoanguyen1511dn..";
		JLabel userLb, passLb;
		JTextField userTxt;
		JPasswordField passTxt;
		JButton logBut, cancelBut;
		public boolean check()
		{
			if(userTxt.getText().equals(username) 
					&& passTxt.getText().equals(password) )
			{
				return true;
			}
			else return false;

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == logBut)
			{
				if(check())
				{
					frame.dispose();
					waitblock.start();
					this.stop();
				}
				else
				{
					new ErrorMessage("[ERROR] Invalid username or password!");
				}
			}
			else if(e.getSource() == cancelBut)
			{
				frame.dispose();
				waitblock.stop();
				this.stop();
			}
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			frame = new JFrame("Login");
			frame.setSize(300, 140);
			userLb = new JLabel("Username:");
			userTxt = new JTextField();
			passLb = new JLabel("Password:");
			passTxt = new JPasswordField();
			logBut = new JButton("Login");
			logBut.addActionListener(this);
			cancelBut = new JButton("Cancel");
			cancelBut.addActionListener(this);
			JPanel p1, p2;
			p1 = new JPanel();
			p1.setLayout(new GridLayout(2,2));
			p1.add(userLb);p1.add(userTxt);
			p1.add(passLb); p1.add(passTxt);
			p2= new JPanel();
			p2.setLayout(new FlowLayout());
			p2.add(logBut);p2.add(cancelBut);
			Container con = frame.getContentPane();
		    
			con.add(p1);
			
			con.add(p2, "South");
//			frame.pack();
//			this.setSize(450, 225);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
//			this.show();
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					//super.windowClosing(e);
					cancelBut.doClick();
				}
			});
		}
		
	}
	loginInterface loginBlock;
	StudentManagement master;

	EditInterface temp;
	JInternalFrame workspaceFrame;
	JInternalFrame toolFrame;
	private JFrame frmStudentManagerbyTeames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ApplicationWin window = new ApplicationWin(new StudentManagement());
					window.frmStudentManagerbyTeames.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWin(StudentManagement slave) {
		master = slave;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentManagerbyTeames = new JFrame();
		frmStudentManagerbyTeames.setResizable(false);
		frmStudentManagerbyTeames.setTitle("Student Manager-by Team16ES");
		frmStudentManagerbyTeames.setBounds(100, 100, 800, 600);
		frmStudentManagerbyTeames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmStudentManagerbyTeames.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New..");
		mnFile.add(mntmNew);
		mntmNew.addActionListener(this);
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File..");
		mnFile.add(mntmOpenFile);
		mntmOpenFile.addActionListener(this);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		mntmSave.addActionListener(this);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As..");
		mnFile.add(mntmSaveAs);
		mntmSaveAs.addActionListener(this);
		
		JMenuItem mntmExit = new JMenuItem("Exit.");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(this);
		
		JMenu mnNavigate = new JMenu("Navigate");
		menuBar.add(mnNavigate);
		
		JMenuItem mntmToolsPanel = new JMenuItem("Tools Panel");
		mnNavigate.add(mntmToolsPanel);
		mntmToolsPanel.addActionListener(this);
		
		JMenuItem mntmWorkspace = new JMenuItem("Workspace");
		mnNavigate.add(mntmWorkspace);
		mntmWorkspace.addActionListener(this);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmInsertStudent = new JMenuItem("Insert student");
		mnTools.add(mntmInsertStudent);
		mntmInsertStudent.addActionListener(this);
		
		JMenuItem mntmViewListOf = new JMenuItem("View List of student");
		mnTools.add(mntmViewListOf);
		mntmViewListOf.addActionListener(this);
		
		JMenu mnSortList = new JMenu("Sort List");
		mnTools.add(mnSortList);
		
		
		JMenuItem mntmbyAverage = new JMenuItem("..by Average");
		mnSortList.add(mntmbyAverage);
		mntmbyAverage.addActionListener(this);
		
		JMenuItem mntmbyAlphabet = new JMenuItem("..by Alphabet");
		mnSortList.add(mntmbyAlphabet);
		mntmbyAlphabet.addActionListener(this);
		
		JMenuItem mntmSearchStudent = new JMenuItem("Search Student");
		mnTools.add(mntmSearchStudent);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mnTools.add(mntmEdit);
		mntmEdit.addActionListener(this);
		mntmSearchStudent.addActionListener(this);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpStudentmanager = new JMenuItem("Help StudentManager");
		mnHelp.add(mntmHelpStudentmanager);
		mntmHelpStudentmanager.addActionListener(this);
		
		JMenuItem mntmAboutStudentmanager = new JMenuItem("About StudentManager");
		mnHelp.add(mntmAboutStudentmanager);
		mntmAboutStudentmanager.addActionListener(this);
		
		toolFrame = new JInternalFrame("Tools");
		toolFrame.setResizable(true);
		toolFrame.setClosable(true);
		toolFrame.setVisible(true);
		frmStudentManagerbyTeames.getContentPane().add(toolFrame, BorderLayout.WEST);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		
		JButton btnViewList = new JButton("View List");
		btnViewList.addActionListener(this);
		
		JButton btnSort = new JButton("Sort Average");
		btnSort.addActionListener(this);
		
		JButton btnSortAlphabet = new JButton("Sort Alphabet");
		btnSortAlphabet.addActionListener(this);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(this);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(toolFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSort, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnViewList, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSortAlphabet, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnExitProgram, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInsert)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnViewList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSort)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSortAlphabet)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExitProgram)
					.addContainerGap(314, Short.MAX_VALUE))
		);
		toolFrame.getContentPane().setLayout(groupLayout);
		
		workspaceFrame = new JInternalFrame("Workspace");
		workspaceFrame.setResizable(true);
		workspaceFrame.setBorder(UIManager.getBorder("InternalFrame.border"));
		workspaceFrame.setClosable(true);
		workspaceFrame.setVisible(true);
		frmStudentManagerbyTeames.getContentPane().add(workspaceFrame, BorderLayout.CENTER);
		workspaceFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equalsIgnoreCase("Tools Panel"))
		{
			if(!toolFrame.isShowing())
				toolFrame.show();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Workspace"))
		{
			if(!workspaceFrame.isShowing())
				workspaceFrame.show();
		}
		else
		{
			
		}
		
		
		if(saveStatus == true)
		{	
		if(e.getActionCommand().equalsIgnoreCase("New.."))
		{
			master.list = new Vector<Student>();
			workspaceFrame.getContentPane().removeAll();
			workspaceFrame.repaint();
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Open File.."))
		{
			try {
				new OpenFileInterface(master);
			} catch ( IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Save"))
		{
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Exit."))
		{
			System.exit(0);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Save As.."))
		{
			try {
				new SaveAsInterface(master);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("About StudentManager"))
		{
			new AboutPanel();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Help StudentManager"))
		{
			
		}
		else
		{
			
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Search Student")
				||e.getActionCommand().equalsIgnoreCase("Search") )
		{
			new SearchInterface(master.list);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Insert student")
				||e.getActionCommand().equalsIgnoreCase("Insert"))	
		{
			new inputClass(master);
		}
		else if(e.getActionCommand().equalsIgnoreCase("View List of student")
				||e.getActionCommand().equalsIgnoreCase("View List"))
		{
			workspaceFrame.getContentPane().removeAll();
			workspaceFrame.getContentPane().add(new ViewInterface(master.list).getContentPane());
			workspaceFrame.repaint();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Sort Average")
				||e.getActionCommand().equalsIgnoreCase("..by Average"))
		{
			Collections.sort(master.list, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					if(o1.getAver() > o2.getAver())
						return 1;
					else if(o1.getAver() < o2.getAver())
						return -1;
					else
						return 0;
				}
				
			});

			workspaceFrame.getContentPane().removeAll();
			workspaceFrame.getContentPane().add(new ViewInterface(master.list).getContentPane());
			workspaceFrame.repaint();
		}
		else if(e.getActionCommand().equalsIgnoreCase("..by Alphabet")
				||e.getActionCommand().equalsIgnoreCase("Sort Alphabet"))
		{
			Collections.sort(master.list, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					if(o1.getName().charAt(0) > o2.getName().charAt(0))
						return 1;
					else if(o1.getName().charAt(0) < o2.getName().charAt(0))
						return -1;
					else
						return 0;
				}
			});	
			workspaceFrame.getContentPane().removeAll();
			workspaceFrame.getContentPane().add(new ViewInterface(master.list).getContentPane());
			workspaceFrame.repaint();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Edit"))
		{
			
			loginBlock = new loginInterface();
			loginBlock.start();
			waitblock = new waitClass();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Exit")
				||e.getActionCommand().equalsIgnoreCase("Exit Program"))
		{
			System.exit(0);
		}
		else
		{
			
		}
		}
		else
		{
			new AsktoSave("Do you want to save changes in Edit ?", temp);
		}
	}
}
