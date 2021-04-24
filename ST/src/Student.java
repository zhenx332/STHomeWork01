
public class Student {

	private int ID;
	private String name;
	private String birDate;
	private boolean gender;
	
	
	public void Point(int ID,String name,String birDate,boolean gender){
		this.ID = ID;
		this.name = name;
		this.birDate = birDate;
		this.gender = gender;
	}
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


}
