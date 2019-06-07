package studentManager1;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import java.util.Collections;
import java.util.Comparator;
class inputClass extends JFrame implements ActionListener
{
	JButton enterBut;
	JLabel  inputLabel;
	JTextField inputTxt;
	StudentManagement master;
	public inputClass(StudentManagement slave) {
		// TODO Auto-generated constructor stub
		super("Input");
		master = slave;
//		Container con = 
		Container con = this.getContentPane();
		JPanel p1, p2;
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setLayout(new GridLayout(1,2));
		p2.setLayout(new FlowLayout());
		
		inputLabel = new JLabel("Number of student: ");
		inputTxt = new JTextField();
		p1.add(inputLabel);
		p1.add(inputTxt);
		
		enterBut = new JButton("Enter");
		enterBut.addActionListener(this);
		p2.add(enterBut);
		
		con.add(p1);
		con.add(p2, "South");
		this.setLocation(200, 100);
		this.pack();
		this.show();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//super.windowClosing(e);
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == enterBut)
		{
			int num = Integer.valueOf(inputTxt.getText());
			for (int i = 0; i < num; i++)
			{
				new InputInterface(master);
			}
			dispose();
		}
	}
	
}
public class StudentManagement extends Frame implements ActionListener
{
	Vector<Student> list = new Vector<Student>();
	private Button b1,b2,b3,b4,b5,b6;
	private MenuItem menuExit,menuNewFile, menuOpenFile, menuSaveAs, menuSave;
	private MenuItem menuHelp, menuAbout;
	public void insertList(Student stu)
	{
		this.list.add(stu);
	}
	public StudentManagement()
	{		
		  super("Student Manager - Team16ES");
		  Panel mainPn = new Panel(new GridLayout(6,1));
		  b1= new Button("Input");
		  b1.addActionListener(this);
		  mainPn.add(b1);
		  b2= new Button("View List");
		  b2.addActionListener(this);
		  mainPn.add(b2);
		  b3 = new Button("Sort average");
		  b3.addActionListener(this);
		  mainPn.add(b3);
		  b4 = new Button("Sort Alphabet");
		  b4.addActionListener(this);
		  mainPn.add(b4);
		  b5 = new Button("Search Student");
		  b5.addActionListener(this);
		  mainPn.add(b5);
		  b6 = new Button("Exit");
		  b6.addActionListener(this);
		  mainPn.add(b6);
		  
		  this.setLayout(new GridLayout());
		  MenuBar mb = new MenuBar();
		  Menu MenuFile,MenuHelp;
		  setMenuBar(mb);
		  ///////////////////////////////          //////////////////////
		  ///////////////////////////////*MENU BAR*////////////////////// 
		  MenuFile = new Menu("File");
		  menuNewFile = new MenuItem("New File");
		  MenuFile.add(menuNewFile);
		  menuNewFile.addActionListener(this);
		  
		  menuOpenFile = new MenuItem("Open File..");
		  MenuFile.add(menuOpenFile);
		  menuOpenFile.addActionListener(this);
		  
		  menuSave = new MenuItem("Save");
		  MenuFile.add(menuSave);
		  menuSave.addActionListener(this);
		  
		  menuSaveAs = new MenuItem("Save As..");
		  MenuFile.add(menuSaveAs);
		  menuSaveAs.addActionListener(this);
		  
		  menuExit = new MenuItem("Exit");
		  MenuFile.add(menuExit);
		  menuExit.addActionListener(this);		  
		  
		  MenuHelp = new Menu("Help");
		  
		  menuHelp = new MenuItem("Help StudentManager");
		  MenuHelp.add(menuHelp);
		  menuHelp.addActionListener(this);
		  
		  menuAbout = new MenuItem("About StudentManager");
		  MenuHelp.add(menuAbout);
		  menuAbout.addActionListener(this);
		  mb.add(MenuFile);
		  mb.add(MenuHelp);
		  //---------------------------ADD GUI----------------------------//
		  
		  //---------------------------ADD PANEL--------------------------//
		  this.add(mainPn);
		  this.addWindowListener(new WindowAdapter() {
			  @Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				  dispose();
			}
		});
		  this.setSize(300,400);
		  this.setResizable(false);
		  this.setVisible(true);
		  this.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManagement();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method st
		if(e.getSource() == b1)
		{
			//new InputInterface(this);
			new inputClass(this);
		}
		else if(e.getSource() == b2)
		{
			new ViewInterface(this.list);
			//this.view();
		}
		else if(e.getSource() == b3)
		{
			//this.sortAver();
			
			Collections.sort(this.list, new Comparator<Student>() {

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
			new ViewInterface(this.list);
			//this.list.sort();
			
		}
		else if(e.getSource() == b4)
		{
			//this.sortAlphabet();
			Collections.sort(this.list, new Comparator<Student>() {

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
			new ViewInterface(this.list);
		}
		else if(e.getSource() == b5)
		{
			new SearchInterface(this.list);
		}
		else if (e.getSource() == b6)
		{
			System.exit(0);
		}
		else
		{
	
		}
		
		
		//-------------ActionListener for File menu-------------//
		if(e.getSource() == menuExit)
		{
			System.exit(0);
		}
		else if(e.getSource() == menuNewFile)
		{
			
		}
		else if(e.getSource() == menuOpenFile)
		{
			try {
				new OpenFileInterface(this);
			} catch ( IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == menuSave)
		{
			
		}
		else if(e.getSource() == menuSaveAs)
		{
			try {
				new SaveAsInterface(this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			
		}
		
		//-------------ActionListener for Help menu-----------//
		if(e.getSource() == menuHelp)
		{
			
		}
		else if(e.getSource() == menuAbout)
		{
			
		}
		else
		{
			
		}
	}

}
