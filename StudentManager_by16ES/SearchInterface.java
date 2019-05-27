package studentManager1;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;


class ErrorMessage extends JFrame implements ActionListener{
	private JButton okeBut; 
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
		super("Error");
		Container con = this.getContentPane();
		this.setLayout(new GridLayout(2, 1));
		this.setSize(250, 100);
		okeBut = new JButton("Ok");
		okeBut.addActionListener(this);
		JPanel 	pn1, pn2;
		pn1 = new JPanel();
		pn1.setLayout(new FlowLayout());
		pn2 = new JPanel();
		pn2.setLayout(new FlowLayout());
		JTextField errorTxt = new JTextField("[ERROR] Can not find the Student !!!");
		errorTxt.setEditable(false);
		
		pn1.add(errorTxt);
		
		pn2.add(okeBut);
		con.add(pn1);
		con.add(pn2,"South");
//		this.pack();
		this.setVisible(true);
		this.show();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okeBut )
		{
			dispose();
		}
	}
	
}
public class SearchInterface extends JFrame implements ActionListener
{
	private JLabel 		inputLb, gradeLb;
	private JButton		enterBut;
	private JTextField	inputTxt, gradeTxt;
	private float 		searchGrade;
	private String		searchName;
	private Vector <Student> tmpList;
	public SearchInterface(Vector <Student> list) 
	{
		// TODO Auto-generated constructor stub
		super("Search Student");
		Container con = this.getContentPane();
		this.setLayout(new GridLayout(3,1));
		this.setSize(200, 150);
		tmpList = new Vector<Student>(list);
				
		JPanel namePanel = new JPanel();
		inputLb = new JLabel("Name: ");
		inputTxt = new JTextField();
		namePanel.setLayout(new GridLayout(1,2));
		namePanel.add(inputLb);
		namePanel.add(inputTxt);
		JPanel gradePanel = new JPanel();
		gradePanel.setLayout(new GridLayout(1,2));
		gradeLb = new JLabel("Grade: ");
		gradeTxt = new JTextField();
		gradeTxt.setText("0");
		gradeTxt.setEditable(true);
		gradePanel.add(gradeLb);
		gradePanel.add(gradeTxt);
		
		
		enterBut = new JButton("Search");
		enterBut.addActionListener(this);
		JPanel submitPanel = new JPanel();
		submitPanel.setLayout(new FlowLayout());
		submitPanel.add(enterBut);
		con.add(namePanel);
		con.add(gradePanel);
		con.add(submitPanel, "South");
//		this.pack();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == enterBut)
		{
			int count = 0;
			Student tmp[] = new Student[tmpList.size()];
			searchName = inputTxt.getText();
			searchGrade = Float.valueOf(gradeTxt.getText());
			for(Student stu : tmpList)
			{
//				if(stu.getName().equalsIgnoreCase(searchName))
//				{
//					//tmp[count++] = stu;
//						tmp[count++] = stu;
//				}
				if (!searchName.equals("") && searchGrade == 0)
				{
					if(stu.getName().equalsIgnoreCase(searchName))
					{
						//tmp[count++] = stu;
							tmp[count++] = stu;
					}
				}
				if (searchName.equals("") && searchGrade != 0)
				{
					if(stu.getAver() == searchGrade)
					{
						tmp[count++] = stu;
					}
				}
				if(!searchName.equals("")  && searchGrade != 0)
				{
					if(stu.getName().equalsIgnoreCase(searchName)
							&& stu.getAver() == searchGrade)
					{
						tmp[count++] = stu;
					}
				}
			}
			if(count > 0)
				new ViewInterface(tmp,count);
			else
			{
				new ErrorMessage();
			}
		}
		
	}
	
}
