package studentManager1;

public class Student //implements Comparable<Student>
{

public final static int  NUMBER_OF_FIELD = 6;
private String name;
private int ID;
private float math, physic, chem;
private float aver;

public Student() 
{
	super();
	ID = 0;
	name = "";
	math = physic = chem = 0;
	this.aver = 0;
}
public Student(int iD, String name, float math, float physic, float chem) {
	super();
	ID = iD;
	this.name = name;
	this.math = math;
	this.physic = physic;
	this.chem = chem;
	this.aver = (math + physic + chem)/3;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getMath() {
	return math;
}
public void setMath(float math) {
	this.math = math;
}
public float getPhysic() {
	return physic;
}
public void setPhysic(float physic) {
	this.physic = physic;
}
public float getChem() {
	return chem;
}
public void setChem(float chem) {
	this.chem = chem;
}
public float getAver() {
	return aver;
}
public void setAver() {
	this.aver = (math + chem + physic)/3;
}

}
