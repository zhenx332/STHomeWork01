import java.util.*;
/**
 * 管理学生的类
 */

public class StudentManager {
	
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	static String msg = "\t\t学号\t\t姓名\t\t出生日期\t\t性别\t\t";
	
	//功能菜单：
	public void menu(){
		System.out.println("请选择操作：");
		System.out.println("1 插入");
		System.out.println("2 查找");
		System.out.println("3 删除");
		System.out.println("4 修改");
		System.out.println("5 输出");
		System.out.println("6 退出");
	}	
	
	//返回数组中元素为空的下标
	public static int index(Student[] arr){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == null){
                return i;//新学生的编号
            }
        }
        return 20; //学生已满员
    }
	
	//1、插入添加学生信息
	public void Insert(int ID,String name,String birDate,boolean gender,Student[] arr){
		int index = index(arr);//获取新学生的位置
		if(index != 20){//如果还有空位置，可以添加新学生
		    Student stu = new Student();
		    stu.setID(ID);
		    stu.setname(name);
		    stu.setbirDate(birDate);
		    stu.setgender(gender);
		    arr[index] = stu;
		    System.out.println("添加学生成功");
		    System.out.println(msg);
		    System.out.println(arr[index]);
		}
		for(int i = 0;i < arr.length-1;i++){//根据学生ID进行递增排序
			for(int j = i + 1;j < arr.length;j++){
				if(arr[i] != null && arr[j] != null){
					if(arr[i].getID() > arr[j].getID()){
						Student temp = arr[i];//比较ID，交换学生
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		return;
	}
	
	//2、根据姓名查找学生信息
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
	
	//3、根据姓名删除学生信息
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
	
	//4、根据姓名修改学生信息
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
	
	//5、输出学生信息
	public void Output(Student[] arr){
		System.out.println(msg);
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
				System.out.println(arr[i]);
			}
		}
	}
	
	//6、退出系统
	public void Exit(){
		System.exit(0);
	}
	
	//菜单管理方法
    public void Applet(){
    	Scanner s = new Scanner(System.in);
    	Student[] stuArr = new Student[20];//定义一个学生数组
    	StudentManager manager = new StudentManager();//定义一个管理对象，用来调用管理学生的方法
    	manager.menu();//功能菜单
    	int num = s.nextInt();//选择的菜单选项
    	if(num == 1){//1、插入添加学生信息
    		System.out.println("请输入学生ID：");
    		int ID = s.nextInt();
    		System.out.println("请输入学生name：");
    		String name = s.next();
    		System.out.println("请输入学生birDate：");
    		String birDate = s.next();
    		System.out.println("请输入学生gender：");
    		boolean gender = s.nextBoolean();
    		manager.Insert(ID,name,birDate,gender,stuArr);
    	}
        if(num == 2){//2、根据姓名查找学生信息
    		System.out.println("请输入学生name：");
    		String name = s.next();
        	manager.Search(name,stuArr);
    	}
        if(num == 3){//3、根据姓名删除学生信息
    		System.out.println("请输入学生name：");
    		String name = s.next();
        	manager.Delete(name,stuArr);
    	}
        if(num == 4){//4、根据姓名修改学生信息
    		System.out.println("请输入学生name：");
    		String name = s.next();
    		System.out.println("请输入学生birDate：");
    		String birDate = s.next();
        	manager.Revise(name,birDate,stuArr);
    	}
        if(num == 5){//5、输出学生信息
        	manager.Output(stuArr);
    	}
        if(num == 6){//6、退出系统
        	manager.Exit();
    	}
    }//菜单管理方法结束
}//学生管理类结束
