package studentManager1;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Vector;
import java.lang.*;
import javax.swing.*;

public class ViewInterface extends JFrame
{
	private JTextField	numTxt[],nameTxt[], idTxt[], mathTxt[], phyTxt[], chemTxt[], averTxt[];
	private Label 	  	numLb, nameLb, idLb, mathLb, physLb, chemLb, averLb;
	public ViewInterface(Student []sts, int num)
	{
		super("View List");
		this.setLayout(new GridLayout(num+1,7));
		numLb = new Label("Num");
		nameLb = new Label("Name");
		idLb = new Label("ID");
		mathLb = new Label("Math");
		physLb = new Label("Physics");
		chemLb = new Label("Chemistry");
		averLb = new Label("Average");
		this.add(numLb);
		this.add(nameLb);
		this.add(idLb);
		this.add(mathLb);
		this.add(physLb);
		this.add(chemLb);
		this.add(averLb);
		numTxt = new JTextField[num];
		for(int i = 0; i < num ; i++)
		{
//			numTxt[i] = new JTextField();
			JTextField tmp = new JTextField(Integer.toString(i+1));
			numTxt[i] = tmp;
			numTxt[i].setEditable(false);
		}
		nameTxt = new JTextField[num];
		for(int i = 0; i< num; i++)
		{
			JTextField tmp = new JTextField(sts[i].getName());
			nameTxt[i]= tmp;
			nameTxt[i].setEditable(false);
			//System.out.println("");
		}
		idTxt = new JTextField[num];
		for(int i = 0 ; i < num; i++)
		{
			JTextField tmp = new JTextField(Integer.toString(sts[i].getID()));
			idTxt[i] = tmp;
			idTxt[i].setEditable(false);
		}
		mathTxt = new JTextField[num];
		for(int i = 0 ; i < num; i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getMath()));
			mathTxt[i] = tmp;
			mathTxt[i].setEditable(false);
		}
		phyTxt = new JTextField[num];
		for(int i = 0 ; i < num; i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getPhysic()));
			phyTxt[i] = tmp;
			phyTxt[i].setEditable(false);
		}
		chemTxt = new JTextField[num];
		for(int i = 0 ; i < num; i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getChem()));
			chemTxt[i] = tmp;
			chemTxt[i].setEditable(false);
		}
		averTxt = new JTextField[num];
		for(int i = 0 ; i < num; i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getAver()));
			averTxt[i] = tmp;
			averTxt[i].setEditable(false);
		}
		for(int i = 0 ; i < num; i ++)
		{
			this.add(numTxt[i]);
			this.add(nameTxt[i]);
			this.add(idTxt[i]);
			this.add(mathTxt[i]);
			this.add(phyTxt[i]);
			this.add(chemTxt[i]);
			this.add(averTxt[i]);
		}
		this.pack();
		this.setResizable(false);
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
	public ViewInterface(Vector<Student> list) {
		// TODO Auto-generated constructor stub
		super("View List");
		
		JPanel sp = new JPanel();
		JScrollPane scroll;
		Container con = this.getContentPane();
		sp.setLayout(new GridLayout(list.size()+1,7));
		Student sts[] = new Student[list.size()];
		Enumeration vEnum = list.elements();
		int index = 0;
		while(vEnum.hasMoreElements()) 
		{
		 sts[index] = (Student)vEnum.nextElement();
		 index++;
		}
		//------------Chổ này chú ý cmm vào :D----------------//
		//------------Nhớ + 1 vào ahihi-----------------------//
//		this.setLayout(new GridLayout(list.size()+1,7));
		numLb = new Label("Num");
		nameLb = new Label("Name");
		idLb = new Label("ID");
		mathLb = new Label("Math");
		physLb = new Label("Physics");
		chemLb = new Label("Chemistry");
		averLb = new Label("Average");
		sp.add(numLb);
		sp.add(nameLb);
		sp.add(idLb);
		sp.add(mathLb);
		sp.add(physLb);
		sp.add(chemLb);
		sp.add(averLb);
		numTxt = new JTextField[list.size()];
		for(int i = 0; i < list.size() ; i++)
		{
//			numTxt[i] = new JTextField();
			JTextField tmp = new JTextField(Integer.toString(i+1));
			numTxt[i] = tmp;
			numTxt[i].setEditable(false);
		}
		nameTxt = new JTextField[list.size()];
		for(int i = 0; i< list.size(); i++)
		{
			JTextField tmp = new JTextField(sts[i].getName());
			nameTxt[i]= tmp;
			nameTxt[i].setEditable(false);
			//System.out.println("");
		}
		idTxt = new JTextField[list.size()];
		for(int i = 0 ; i < list.size(); i++)
		{
			JTextField tmp = new JTextField(Integer.toString(sts[i].getID()));
			idTxt[i] = tmp;
			idTxt[i].setEditable(false);
		}
		mathTxt = new JTextField[list.size()];
		for(int i = 0 ; i < list.size(); i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getMath()));
			mathTxt[i] = tmp;
			mathTxt[i].setEditable(false);
		}
		phyTxt = new JTextField[list.size()];
		for(int i = 0 ; i < list.size(); i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getPhysic()));
			phyTxt[i] = tmp;
			phyTxt[i].setEditable(false);
		}
		chemTxt = new JTextField[list.size()];
		for(int i = 0 ; i < list.size(); i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getChem()));
			chemTxt[i] = tmp;
			chemTxt[i].setEditable(false);
		}
		averTxt = new JTextField[list.size()];
		for(int i = 0 ; i < list.size(); i++)
		{
			JTextField tmp = new JTextField(Float.toString(sts[i].getAver()));
			averTxt[i] = tmp;
			averTxt[i].setEditable(false);
		}
		for(int i = 0 ; i < list.size(); i ++)
		{

			sp.add(numTxt[i]);
			sp.add(nameTxt[i]);
			sp.add(idTxt[i]);
			sp.add(mathTxt[i]);
			sp.add(phyTxt[i]);
			sp.add(chemTxt[i]);
			sp.add(averTxt[i]);
		}

		scroll = new JScrollPane(sp);
		scroll.setLayout(new ScrollPaneLayout());
		scroll.setPreferredSize(new Dimension(645,515));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.add(sp);
		con.add(scroll);
		this.pack();

		this.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//super.windowClosing(arg0);
				dispose();
			}
		});
	}
	
}
