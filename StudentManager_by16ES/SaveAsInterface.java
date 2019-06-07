package studentManager1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

import javax.swing.*;
public class SaveAsInterface extends JFrame  
{
	Vector<Student> vec;
	JFileChooser chooser;
	FileWriter   writer;
	StudentManagement master;
	public SaveAsInterface(StudentManagement slave) throws IOException
	{
		master = slave;
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Save As");
		if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			String filename = chooser.getSelectedFile().getAbsolutePath();
			saveFile(filename);
		}
	}
	public void saveFile(String filename) throws IOException
	{
		writer = new FileWriter(filename);
		vec = new Vector<Student>(master.list);
		for(Student stu : vec)
		{
			String name, id, math, phys, chem, avr;
			name = stu.getName();
			id = Integer.toString(stu.getID());
			math = Float.toString(stu.getMath());
			phys = Float.toString(stu.getPhysic());
			chem =Float.toString(stu.getChem());
			avr = Float.toString(stu.getAver());
			writer.write(name);
			writer.write(System.lineSeparator());
			writer.write(id);
			writer.write(System.lineSeparator());
			writer.write(math);
			writer.write(System.lineSeparator());
			writer.write(phys);
			writer.write(System.lineSeparator());
			writer.write(chem);
			writer.write(System.lineSeparator());
			writer.write(avr);
			writer.write(System.lineSeparator());
			writer.write(System.lineSeparator());
		}
		writer.flush();
		writer.close();
	}
}
