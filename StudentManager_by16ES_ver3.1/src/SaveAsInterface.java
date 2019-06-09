package studentManager1;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
class SaveExcelFile
{
	StudentManagement master;
	public SaveExcelFile(String path, StudentManagement slave) throws IOException
	{
		master = slave;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet0");
		Map<String, Object> data = new  TreeMap<String, Object>();
		data.put("1", new Object[] {"Name", "ID", "Math", "Physics", "Chemistry"});
		int i = 2;
		for(Student stu : master.list)
		{	
			data.put(Integer.toString(i++), new Object[] {stu.getName(), stu.getID(),
														stu.getMath(), stu.getPhysic(), stu.getChem()});
		}
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for(String key: keyset)
		{
			Row row = sheet.createRow(rownum++);
			Object[] objArr = (Object[]) data.get(key);
			int cellnum = 0;
			for(Object o : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(o instanceof String)
					cell.setCellValue((String) o);
				else if(o instanceof Integer)
					cell.setCellValue((Integer) o);
				else if(o instanceof Float)
					cell.setCellValue((Float) o);
				else {
					
				}
				
			}
			
		}
		FileOutputStream outfile = new FileOutputStream(new File(path));
		workbook.write(outfile);
		outfile.close();
	}
}

public class SaveAsInterface extends JFrame  
{
	Vector<Student> vec;
	JFileChooser chooser;
	FileWriter   writer;
	String currentFile;
	StudentManagement master;
	public SaveAsInterface(StudentManagement slave) throws IOException
	{
		master = slave;
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Save As");
		if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			//String filename = chooser.getSelectedFile().getAbsolutePath();
			currentFile = chooser.getSelectedFile().getAbsolutePath();
			int dot = currentFile.lastIndexOf(".");
			//char []buf = currentFile.toCharArray();
			String thistype = currentFile.substring(dot);
			if(thistype.equals(".txt"))
				saveFile(currentFile);
			else if(thistype.equals(".xls") || thistype.equals(".xlsx") )
			{
				new SaveExcelFile(currentFile, master);
			}
			else
			{
				new ErrorMessage("[ERROR] Can not save file !!!");
			}
			
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
