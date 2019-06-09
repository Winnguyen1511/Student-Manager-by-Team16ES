package studentManager1;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class EditInterface extends JFrame implements ActionListener, MouseListener
{
	
	class editInfo{
		static final boolean DELETE = false;
		static final boolean INSERT = true;
		int index;
		boolean type;
		public editInfo()
		{
			this.index = 0;
			this.type = true;
		}
		public editInfo(int index,boolean type)
		{
			this.index = index;
			this.type = type;
		}
	}
	StudentManagement master;
	Vector<editInfo> EditedData = new Vector<editInfo>();
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	JScrollPane tableResult;
	DefaultTableModel model;
	JTable tb = new JTable();
	JButton delete, edit, save;
	int selectedRow = 0;
	String []colums = {"Name", "ID", "Math", "Physics", "Chemistry", "Average"}; 
	
	public EditInterface(StudentManagement slave) {
		super("Edit List");
		master = slave;
		Container con = this.getContentPane();
		JPanel butPan = new JPanel();
		edit = new JButton("Edit");
		delete = new JButton("Delete");
		save = new JButton("Save");
		butPan.add(edit);
		butPan.add(delete);
		butPan.add(save);
		edit.addActionListener(this);
		delete.addActionListener(this);
		save.addActionListener(this);
		con.add(butPan, "South");
		load();
		model = new DefaultTableModel(vData, vTitle);
		tb = new JTable(model);
		tb.addMouseListener(this);
		tableResult = new JScrollPane(tb);
		tableResult.setLayout(new ScrollPaneLayout());
		tableResult.setPreferredSize(new Dimension(645,480));
		tableResult.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tableResult.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		con.add(tableResult, "North");
		this.pack();
//		this.setSize(645,515);
//		this.setVisible(true);
//		this.show();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//super.windowClosing(e);
				dispose();
			}
		});
	
		
		
	}
	public void load() {
		vTitle.clear();
		vData.clear();
		int num_colums = colums.length;
		for(int i = 0 ; i < num_colums; i++)
		{
			vTitle.add(colums[i]);
		}
//		int count = 0;
		for(Student stu : master.list)
		{
			Vector<String> row = new Vector<String>();
			row.add(stu.getName());
			row.add(Integer.toString(stu.getID()));
			row.add(Float.toString(stu.getMath()));
			row.add(Float.toString(stu.getPhysic()));
			row.add(Float.toString(stu.getChem()));
			row.add(Float.toString(stu.getAver()));
			vData.add(row);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		selectedRow = tb.getSelectedRow();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equalsIgnoreCase("Edit"))
		{
			Vector temp = (Vector)this.vData.elementAt(selectedRow);
			EditedData.add(new editInfo(selectedRow, editInfo.INSERT));
			new UpdateForm(this, (String)temp.elementAt(0),(String)temp.elementAt(1),(String) temp.elementAt(2)
							,(String) temp.elementAt(3),(String) temp.elementAt(4));
		}
		else if(e.getActionCommand().equalsIgnoreCase("Delete"))
		{
			vData.remove(selectedRow);
			EditedData.add(new editInfo(selectedRow, editInfo.DELETE));
			model.fireTableDataChanged();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Save"))
		{
			int count = 0;
			if(EditedData.size()>0) {
			editInfo [] edit = new editInfo[EditedData.size()];
			for(editInfo data : EditedData)
			{
				edit[count++] = data;
			}
			for(int i = 0; i < EditedData.size() ;i++)
			{
				if(edit[i].type == editInfo.INSERT) {
				Vector temp = (Vector)this.vData.elementAt(edit[i].index);
				master.list.remove(edit[i].index);
				String name = (String)temp.elementAt(0);
				int ID = Integer.valueOf((String)temp.elementAt(1));
				float math = Float.valueOf((String)temp.elementAt(2));
				float phys = Float.valueOf((String)temp.elementAt(3));
				float chem = Float.valueOf((String)temp.elementAt(4));
				Student stu = new Student(ID, name, math, phys, chem);
				master.list.add(edit[i].index, stu);
				}
				else
				{
					master.list.remove(edit[i].index);
				}
			}
			}
			ApplicationWin.saveStatus = true;
		}
		else
		{
			
		}
	}
	
}
class AsktoSave extends JFrame implements ActionListener
{
	EditInterface master;
	private JButton yesBut,noBut, cancelBut; 
	public AsktoSave(String message, EditInterface slave) {
		// TODO Auto-generated constructor stub
		super(message);
		master = slave;
		Container con = this.getContentPane();
		this.setLayout(new GridLayout(2, 1));
		this.setSize(250, 100);
		yesBut = new JButton("Yes");
		yesBut.addActionListener(this);
		noBut = new JButton("No");
		noBut.addActionListener(this);
		cancelBut = new JButton("Cancel");
		cancelBut.addActionListener(this);
		JPanel 	pn1, pn2;
		pn1 = new JPanel();
		pn1.setLayout(new FlowLayout());
		pn2 = new JPanel();
		pn2.setLayout(new FlowLayout());
		JTextField errorTxt = new JTextField(message);
		errorTxt.setEditable(false);
		
		pn1.add(errorTxt);
		
		pn2.add(yesBut);pn2.add(noBut); pn2.add(cancelBut);
		con.add(pn1);
		con.add(pn2,"South");
		this.pack();
		this.setLocationRelativeTo(null);;
		this.setVisible(true);
		
//		this.show();
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
		if(e.getSource() == yesBut )
		{
			ApplicationWin.saveStatus = true;
//			master.actionPerformed(new Ac);
//			master.action(new ActionEvent(master.save, 1, "Save"), master);
			master.save.doClick();
			dispose();
		}
		else if(e.getSource() == noBut)
		{
			ApplicationWin.saveStatus = true;
			dispose();
		}
		else if(e.getSource() == cancelBut)
		{
			dispose();
		}
		else {
			
		}
	}
	
}
class UpdateForm extends JFrame implements ActionListener
{
	JLabel nameLb, idLb, mathLb, physLb, chemLb;
	JTextField nameTxt, idTxt, mathTxt, physTxt, chemTxt;
	JButton okBut, cancelBut;
	EditInterface master;
	public UpdateForm(EditInterface slave, String name, String id, String math, String phys, String chem) {
		super("Edit Form");
		master = slave;
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(7,2));
		nameLb = new JLabel("Name:");
		nameTxt = new JTextField(name);
		idLb = new JLabel("ID:");
		idTxt = new JTextField(id);
		mathLb = new JLabel("Math:");
		mathTxt = new JTextField(math);
		physLb = new JLabel("Physics:");
		physTxt = new JTextField(phys);
		chemLb = new JLabel("Chemistry:");
		chemTxt = new JTextField(chem);
		okBut = new JButton("OK");
		okBut.addActionListener(this);
		cancelBut = new JButton("Cancel");
		cancelBut.addActionListener(this);
		con.add(nameLb);con.add(nameTxt);
		con.add(idLb);con.add(idTxt);
		con.add(mathLb); con.add(mathTxt);
		con.add(physLb); con.add(physTxt);
		con.add(chemLb); con.add(chemTxt);
		con.add(okBut);
		con.add(cancelBut);
		this.pack();
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
			//	super.windowClosing(e);
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBut)
		{
			Vector <String> row = new Vector<String>();
			row.add(nameTxt.getText());
			row.add(idTxt.getText());
			row.add(mathTxt.getText());
			row.add(physTxt.getText());
			row.add(chemTxt.getText());
			float aver = (Float.valueOf(mathTxt.getText()) +Float.valueOf(physTxt.getText())
						+Float.valueOf(chemTxt.getText()))/3;
			row.add(Float.toString(aver));
//			master.vData.elementAt(master.selectedRow) = row;
			//master.vData.elementAt(0) = row;
			master.vData.remove(master.selectedRow);
			master.vData.add(master.selectedRow, row);
			master.model.fireTableDataChanged();
			dispose();
		}
		else if(e.getSource() == cancelBut)
		{
			dispose();
		}
		else {
			
		}
	}
	
}