package studentManager1;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;



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
		gradeLb = new JLabel("Average: ");
		gradeTxt = new JTextField();
		gradeTxt.setText("0");
		gradeTxt.setEditable(true);
		gradePanel.add(gradeLb);
		gradePanel.add(gradeTxt);
		
		
		enterBut = new JButton("Enter");
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
				float searchGradeRound = Math.round((searchGrade*10)/10);
				float averGradeRound = Math.round((stu.getAver()*10)/10);
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
					if(searchGradeRound == averGradeRound)
					{
						tmp[count++] = stu;
					}
				}
				if(!searchName.equals("")  && searchGrade != 0)
				{
					if(stu.getName().equalsIgnoreCase(searchName)
							&& searchGradeRound == averGradeRound)
					{
						tmp[count++] = stu;
					}
				}
			}
			if(count > 0)
				new ViewInterface(tmp,count);
			else
			{
				new ErrorMessage("[ERROR] Can not find the Student !!!");
			}
		}	
	}
}
