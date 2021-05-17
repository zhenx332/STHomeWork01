/**
 * 学生类
 */
public class Student {

	private int ID;
	private String name;
	private String birDate;
	private boolean gender;
	
	public int getID(){
		return ID;
	}
	public String getname(){
		return name;
	}
	public String getbirDate(){
		return birDate;
	}
	public boolean getgender(){
		return gender;
	}
	
	
	public void setID(int ID){
		this.ID = ID;
	}
	public void setname(String name){
		this.name = name;
	}
	public void setbirDate(String birDate){
		this.birDate = birDate;
	}
	public void setgender(boolean gender){
		this.gender = gender;
	}

    public String toString(){ //学生信息
    	String str = "\t\t" + this.ID + "\t\t" + this.name + "\t\t" + this.birDate + "\t\t" + this.gender + "\t\t";
    	return str;
    }
}
