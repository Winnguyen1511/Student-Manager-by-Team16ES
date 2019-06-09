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
public class StudentManagement
{
	Vector<Student> list;
	public void insertList(Student stu)
	{
		this.list.add(stu);
	}
	public StudentManagement()
	{		
//		  super("Student Manager - Team16ES");
		list = new Vector<Student>();
	}
}
