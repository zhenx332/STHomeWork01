import java.util.*;

public class StudentManager {
	
	public static void main(String[] args) {
		java.util.Date utilDate=new java.util.Date();
		 
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
	}

	static String msg = "\t学号\t姓名\t出生日期\t性别\t";
	public static int index(Student[] arr){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == null){
                return i;
            }
        }
        return 20; 
    }
	
	public void menu(){
		System.out.println("请选择操作：");
		System.out.println("1 插入");
		System.out.println("2 查找");
		System.out.println("3 删除");
		System.out.println("4 修改");
		System.out.println("5 输出");
		System.out.println("6 退出");
	}
	
	public void Insert(String name,String birDate,Student[] arr){
		int index = index(arr);
		if(index != 20){
		    Student stu = new Student();
		    //stu.setID(index);
		    stu.setname(name);
		    stu.setbirDate(birDate);
		    //stu.setgender(gender);
		    arr[index] = stu;
		}
		for(int i = 0;i < arr.length-1;i++){
			for(int j = i + 1;j < arr.length;j++){
				if(arr[i] != null && arr[j] != null){
					if(arr[i].getID() > arr[j].getID()){
						Student temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		return;
	}
	
	public void Search(String name,Student[] arr){
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
				if(arr[i].getname() == name){
					System.out.println(msg);
					System.out.println(arr[i]);
					return;
				}
			}
		}
		System.out.println("未找到该学生信息");
	}
	
	public void Delete(String name,Student[] arr){
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
				if(arr[i].getname() == name){
					arr[i] = null;
					System.out.println("删除成功");
					return;
				}
			}
		}
		System.out.println("未找到该学生信息");
	}
	
	public void Revise(String name,String birDate,Student[] arr){
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
			    if(arr[i].getname() == name){
				    arr[i].setname(name);
				    arr[i].setbirDate(birDate);
				    System.out.println("修改学生信息成功");
				    return;
			    }
			}
		}
		System.out.println("未找到该学生信息");
	}
	
	public void Output(Student[] arr){
		System.out.println(msg);
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
				System.out.println(arr[i]);
			}
		}
	}
	
	public void Exit(){
		System.exit(0);
	}
	
    public void Applet(String[] args){
    	Scanner s = new Scanner(System.in);
    	Student[] stuArr = new Student[20];
    	StudentManager manager = new StudentManager();
    	manager.menu();
    	int num = s.nextInt();
    	if(num == 1){
    		//System.out.println("请输入学生ID：");
    		//String ID = s.next();
    		System.out.println("请输入学生name：");
    		String name = s.next();
    		System.out.println("请输入学生birDate：");
    		String birDate = s.next();
    		//System.out.println("请输入学生gender：");
    		//String gender = s.next();
    		manager.Insert(name,birDate,stuArr);
    	}
        if(num == 2){
    		System.out.println("请输入学生name：");
    		String name = s.next();
        	manager.Search(name,stuArr);
    	}
        if(num == 3){
    		System.out.println("请输入学生name：");
    		String name = s.next();
        	manager.Delete(name,stuArr);
    	}
        if(num == 4){
    		System.out.println("请输入学生name：");
    		String name = s.next();
    		System.out.println("请输入学生birDate：");
    		String birDate = s.next();
        	manager.Revise(name,birDate,stuArr);
    	}
        if(num == 5){
        	manager.Output(stuArr);
    	}
        if(num == 6){
        	manager.Exit();
    	}
    }
}
