import java.util.*;

public class StudentManager {
	
	public static void main(String[] args) {
		java.util.Date utilDate=new java.util.Date();
		 
		java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
	}

	static String msg = "\tѧ��\t����\t��������\t�Ա�\t";
	public static int index(Student[] arr){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == null){
                return i;
            }
        }
        return 20; 
    }
	
	public void menu(){
		System.out.println("��ѡ�������");
		System.out.println("1 ����");
		System.out.println("2 ����");
		System.out.println("3 ɾ��");
		System.out.println("4 �޸�");
		System.out.println("5 ���");
		System.out.println("6 �˳�");
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
		System.out.println("δ�ҵ���ѧ����Ϣ");
	}
	
	public void Delete(String name,Student[] arr){
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
				if(arr[i].getname() == name){
					arr[i] = null;
					System.out.println("ɾ���ɹ�");
					return;
				}
			}
		}
		System.out.println("δ�ҵ���ѧ����Ϣ");
	}
	
	public void Revise(String name,String birDate,Student[] arr){
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
			    if(arr[i].getname() == name){
				    arr[i].setname(name);
				    arr[i].setbirDate(birDate);
				    System.out.println("�޸�ѧ����Ϣ�ɹ�");
				    return;
			    }
			}
		}
		System.out.println("δ�ҵ���ѧ����Ϣ");
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
    		//System.out.println("������ѧ��ID��");
    		//String ID = s.next();
    		System.out.println("������ѧ��name��");
    		String name = s.next();
    		System.out.println("������ѧ��birDate��");
    		String birDate = s.next();
    		//System.out.println("������ѧ��gender��");
    		//String gender = s.next();
    		manager.Insert(name,birDate,stuArr);
    	}
        if(num == 2){
    		System.out.println("������ѧ��name��");
    		String name = s.next();
        	manager.Search(name,stuArr);
    	}
        if(num == 3){
    		System.out.println("������ѧ��name��");
    		String name = s.next();
        	manager.Delete(name,stuArr);
    	}
        if(num == 4){
    		System.out.println("������ѧ��name��");
    		String name = s.next();
    		System.out.println("������ѧ��birDate��");
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
