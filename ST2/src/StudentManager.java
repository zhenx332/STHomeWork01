import java.util.*;
/**
 * ����ѧ������
 */

public class StudentManager {
	
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	static String msg = "\t\tѧ��\t\t����\t\t��������\t\t�Ա�\t\t";
	
	//���ܲ˵���
	public void menu(){
		System.out.println("��ѡ�������");
		System.out.println("1 ����");
		System.out.println("2 ����");
		System.out.println("3 ɾ��");
		System.out.println("4 �޸�");
		System.out.println("5 ���");
		System.out.println("6 �˳�");
	}	
	
	//����������Ԫ��Ϊ�յ��±�
	public static int index(Student[] arr){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == null){
                return i;//��ѧ���ı��
            }
        }
        return 20; //ѧ������Ա
    }
	
	//1���������ѧ����Ϣ
	public void Insert(int ID,String name,String birDate,boolean gender,Student[] arr){
		int index = index(arr);//��ȡ��ѧ����λ��
		if(index != 20){//������п�λ�ã����������ѧ��
		    Student stu = new Student();
		    stu.setID(ID);
		    stu.setname(name);
		    stu.setbirDate(birDate);
		    stu.setgender(gender);
		    arr[index] = stu;
		    System.out.println("���ѧ���ɹ�");
		    System.out.println(msg);
		    System.out.println(arr[index]);
		}
		for(int i = 0;i < arr.length-1;i++){//����ѧ��ID���е�������
			for(int j = i + 1;j < arr.length;j++){
				if(arr[i] != null && arr[j] != null){
					if(arr[i].getID() > arr[j].getID()){
						Student temp = arr[i];//�Ƚ�ID������ѧ��
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		return;
	}
	
	//2��������������ѧ����Ϣ
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
	
	//3����������ɾ��ѧ����Ϣ
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
	
	//4�����������޸�ѧ����Ϣ
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
	
	//5�����ѧ����Ϣ
	public void Output(Student[] arr){
		System.out.println(msg);
		for(int i = 0;i < arr.length;i++){
			if(arr[i] != null){
				System.out.println(arr[i]);
			}
		}
	}
	
	//6���˳�ϵͳ
	public void Exit(){
		System.exit(0);
	}
	
	//�˵�������
    public void Applet(){
    	Scanner s = new Scanner(System.in);
    	Student[] stuArr = new Student[20];//����һ��ѧ������
    	StudentManager manager = new StudentManager();//����һ����������������ù���ѧ���ķ���
    	manager.menu();//���ܲ˵�
    	int num = s.nextInt();//ѡ��Ĳ˵�ѡ��
    	if(num == 1){//1���������ѧ����Ϣ
    		System.out.println("������ѧ��ID��");
    		int ID = s.nextInt();
    		System.out.println("������ѧ��name��");
    		String name = s.next();
    		System.out.println("������ѧ��birDate��");
    		String birDate = s.next();
    		System.out.println("������ѧ��gender��");
    		boolean gender = s.nextBoolean();
    		manager.Insert(ID,name,birDate,gender,stuArr);
    	}
        if(num == 2){//2��������������ѧ����Ϣ
    		System.out.println("������ѧ��name��");
    		String name = s.next();
        	manager.Search(name,stuArr);
    	}
        if(num == 3){//3����������ɾ��ѧ����Ϣ
    		System.out.println("������ѧ��name��");
    		String name = s.next();
        	manager.Delete(name,stuArr);
    	}
        if(num == 4){//4�����������޸�ѧ����Ϣ
    		System.out.println("������ѧ��name��");
    		String name = s.next();
    		System.out.println("������ѧ��birDate��");
    		String birDate = s.next();
        	manager.Revise(name,birDate,stuArr);
    	}
        if(num == 5){//5�����ѧ����Ϣ
        	manager.Output(stuArr);
    	}
        if(num == 6){//6���˳�ϵͳ
        	manager.Exit();
    	}
    }//�˵�����������
}//ѧ�����������
