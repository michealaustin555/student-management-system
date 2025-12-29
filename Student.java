import java.util.*;
class Student{
    private int id;
    private String name;
    private int age;
    private String dept;

    public  Student(int id,String name,int age,String dept){
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setDept(String dept){
        this.dept=dept;
    }

    public String toString(){
        return "ID:"+id+",Name:"+name+",Age:"+age+",Dept:"+dept;    }
    

}
public class Studentdata{
    private static Map<Integer,Student>stu=new HashMap<>();
        private static Scanner scan=new Scanner(System.in);
        
    public static void main(String []args){
        int choice;
        do{ 
            System.out.println();
            System.out.println("\n======Student Managemennt System======");
            System.out.println("1.Add student");
            System.out.println("2.view students list");
            System.out.println("3.update student list");
            System.out.println("4.Delete student");
            System.out.println("5.Exit from student list");
            System.out.println();
            System.out.print("Enter your choice: ");

            choice =scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1:
                    addstudent();
                    break;
                case 2:
                    veiwstudent();
                    break;
                case 3:
                    updatestudent();
                    break;
                case 4:
                    deletestudent();
                    break;
                case 5:
                    System.out.println("Exited from student list");
                    break;
                default:
                    System.out.println("Invalied choice");
                    
            }
         
        } 
        while (choice!=5);
    }
    
         
    

    private static void addstudent(){
        System.out.print("Enter ID: ");
        int id;
        id=scan.nextInt();
        scan.nextLine();

        if(stu.containsKey(id)){
            System.out.println("This id is already exist");
            return;
        }
        System.out.print("Enter Name: ");
        String name=scan.nextLine();

        System.out.print("Enter Age: ");
        int age=scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Dept: ");
        String dept=scan.nextLine();

        Student st=new Student(id,name,age,dept);
        stu.put(id,st);
        System.out.println();
        System.out.println("Student added successfully!...");
    }

    private static void veiwstudent(){
        if(stu.isEmpty()){
            System.out.println("Empty list");
            return;
        }
        System.out.println("*=====The list of students=====*");
        for(Student s:stu.values()){
        System.out.println(s);
        }
    }

    private static void updatestudent(){
        System.out.print("Enter ID want to update: "); 
        int id=scan.nextInt();
        scan.nextLine();

        Student st=stu.get(id);
        if(stu == null){
           
             System.out.println("The id is not found");
             return;
        }
            System.out.print("Enter Name: ");
            String name=scan.nextLine();
            System.out.print("Enter Age: ");
            int age=scan.nextInt();
            scan.nextLine();
            System.out.print("Enter Dept: ");
            String dept=scan.nextLine();

            st.setName(name);
            st.setAge(age);
            st.setDept(dept);
            System.out.println("Student is added!....");
            
        }
      private static void deletestudent(){
        System.out.print("Enter the ID to remove: ");
        int id=scan.nextInt();
        scan.nextLine();

        if(stu.containsKey(id)){
            stu.remove(id);
            System.out.println("ID removed succeesfully!!");
        }
        else{
        System.out.println("The entered id is already removed");}
      }
       
    }