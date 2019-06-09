package studentManager1;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
public class InputInterface extends JFrame implements ActionListener
{
	private TextField	nameTxt, idTxt, mathTxt, physTxt, chemTxt;
	private JLabel		nameLb,	 idLb ,	mathLb , physLb , chemLb;
	private JButton		enterBut;
	StudentManagement   master;
	
	public InputInterface(StudentManagement data)
	{
		super("Input");
		master = data;
		Container con = this.getContentPane();
		JPanel p1= new JPanel();
		p1.setLayout(new GridLayout(5,2));
		nameLb = new JLabel("Name");
		nameTxt = new TextField();
		
		nameTxt.getText();	
		idLb = new JLabel("Identification (ID)");
		idTxt = new TextField();
		
		mathLb = new JLabel("Math grade");
		mathTxt = new TextField();
		
		physLb = new JLabel("Physic grade");
		physTxt = new TextField();
		
		chemLb = new JLabel("Chemistry grade");
		chemTxt = new TextField();
		
		enterBut = new JButton("Enter");
		enterBut.addActionListener(this);
		
		
		p1.add(nameLb);
		p1.add(nameTxt);
		p1.add(idLb);
		p1.add(idTxt);
		p1.add(mathLb);
		p1.add(mathTxt);
		p1.add(physLb);
		p1.add(physTxt);
		p1.add(chemLb);
		p1.add(chemTxt);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(enterBut);
		con.add(p1);
		con.add(p2, "South");
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		this.pack();
		this.setVisible(true);
		this.show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == enterBut)
		{
			Student stu = new Student();
			stu.setName(nameTxt.getText());  
			stu.setID( Integer.valueOf(idTxt.getText()));
			stu.setMath(Float.valueOf(mathTxt.getText()));
			stu.setPhysic(Float.valueOf(physTxt.getText()));
			stu.setChem(Float.valueOf(chemTxt.getText()));
			stu.setAver();
			master.insertList(stu);
			//Student stu = new Student(ID,name, math, phys, chem);
			dispose();
		}
	}
}
