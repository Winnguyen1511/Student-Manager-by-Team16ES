package studentManager1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

class OpenExcelFile
{
	Vector<Student> vec = new Vector<Student>();
	StudentManagement master;
	public OpenExcelFile(String path, StudentManagement slave) throws EncryptedDocumentException, IOException
	{
		master = slave;
		FileInputStream inputStream = new FileInputStream(new File(path));
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row>rowIterator = sheet.iterator();
		
		int row_counter = 0;
		int col_counter = 0;//Student.NUMBER_OF_FIELD;
		while(rowIterator.hasNext())
		{
			Row r = rowIterator.next();
			Iterator<Cell> cellIterator = r.cellIterator();
			Student stu = new Student();
			while(cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();
				CellType cellType = cell.getCellType();
					 //id_buffer;
					String string_buffer = "";
					double numeric_buffer = 0;
	               switch (cellType) {
	               case _NONE:

	                   break;
	               case BOOLEAN:

	                   break;
	               case BLANK:

	                   break;
	               case FORMULA:

	                   break;
	               case NUMERIC:
	            	   numeric_buffer = cell.getNumericCellValue();
	                   break;
	               case STRING:
	            	   string_buffer = cell.getStringCellValue();
	                   break;
	               case ERROR:

	                   break;
	               }
	               if(row_counter >0)
	               {
	            	   if(col_counter < Student.NUMBER_OF_FIELD-1) {
	            		   if(col_counter == 0)
	            		   {
	            			   stu.setName(string_buffer);
	            		   }
	            		   else if(col_counter == 1)
	            		   {
	            			   stu.setID((int)numeric_buffer);
	            		   }
	            		   else if(col_counter == 2)
	            		   {
	            			   stu.setMath((float)numeric_buffer);
	            		   }
		            	   else if(col_counter  == 3)
		            	   {
		            		   stu.setPhysic((float)numeric_buffer);
		            	   }
		            	   else if(col_counter == 4)
		            	   {
		            		   stu.setChem((float)numeric_buffer);
		            	   }
		            	   else
		            	   {
		            		   
		            	   }
	            		   col_counter++;
		               }
		               else
		               {
		            	   
		               }
	               }
	               else {
	            	   
	               }
			}
			if(row_counter > 0) {
     	   stu.setAver();
     	   vec.add(stu);
     	   col_counter = 0;}
			row_counter++;
		}
		master.list = vec;
		inputStream.close();
	}
}
public class OpenFileInterface extends JFrame 
{	
	String currentFile;
	Vector <Student> vec = new Vector<Student>();
	JFileChooser chooser;
	FileReader   reader;
	BufferedReader buffer;
	StudentManagement master;
	public OpenFileInterface(StudentManagement slave) throws IOException
	{
		master = slave;
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Open file");
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			currentFile = chooser.getSelectedFile().getAbsolutePath();
			int dot = currentFile.lastIndexOf(".");
			//char []buf = currentFile.toCharArray();
			String thistype = currentFile.substring(dot);
			if(thistype.equals(".txt"))
				readFile(currentFile);
			else if(thistype.equals(".xls") || thistype.equals(".xlsx") )
			{
				new OpenExcelFile(currentFile, master);
			}
			else
			{
				new ErrorMessage("[ERROR] Can not open file !!!");
			}
		}
		
	}
	public void readFile(String filename) throws IOException
	{
		reader = new FileReader(filename);
		buffer = new BufferedReader(reader);
		String s;
		int buffer_count = 0;
		String buffer_array[] = new String[Student.NUMBER_OF_FIELD-1];
		while((s = buffer.readLine()) != null)
		{
			if(buffer_count == Student.NUMBER_OF_FIELD-1)
			{
				buffer_count = 0;
				String name = buffer_array[0];
				int ID = Integer.valueOf(buffer_array[1]);
				float math = Float.valueOf(buffer_array[2]);
				float phys = Float.valueOf(buffer_array[3]);
				float chem = Float.valueOf(buffer_array[4]);
//				float avr = Float.valueOf(buffer_array[5]);
				Student stu = new Student(ID, name, math, phys, chem);
				vec.add(stu);
			}
			else
			{
				buffer_array[buffer_count++] = s;
			}
		}
		String name = buffer_array[0];
		int ID = Integer.valueOf(buffer_array[1]);
		float math = Float.valueOf(buffer_array[2]);
		float phys = Float.valueOf(buffer_array[3]);
		float chem = Float.valueOf(buffer_array[4]);
//		float avr = Float.valueOf(buffer_array[5]);
		Student stu = new Student(ID, name, math, phys, chem);
		vec.add(stu);
		
		reader.close();
		master.list = vec;
	}
}
