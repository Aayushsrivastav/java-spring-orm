package com.spring.springorm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.springorm.dao.StudentDao;
import com.spring.springorm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(251, "john", "mumbai");
//        int result = studentDao.insert(student);
//        System.out.println("done "+ result);
        
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedInputStream br = new BufferedInputStream(System.in);
        System.out.println("Welcome");
       
        boolean go = true;
        
        while(go)
        {
        	 System.out.println("Press 1 for add new student");
             System.out.println("Press 2 for display all students");
             System.out.println("Press 3 for get detail of single student");
             System.out.println("Press 4 for for delete student");
             System.out.println("Press 5 for update student");
             System.out.println("Press 6 for exit");
             
             try {
            	 int input = Integer.parseInt(br.readLine());
            	 
            	 switch(input) {
            	 case 1:
            		 //Add new student
            		 
            		 //Taking input from user
            		 System.out.println("Enter user id : ");
            		 int uId = Integer.parseInt(br.readLine());
            		 
            		 System.out.println("Enter user name : ");
            		 String userName = br.readLine();
            		 
            		 System.out.println("Enter user city : ");
            		 String userCity = br.readLine();
            		 
            		 //Creating student object
            		 Student student = new Student(uId, userName, userCity);
            		 
            		 //Crud operation
            		 int result = studentDao.insert(student);
            		 System.out.println("Student added : " + result);
            		 
            		 System.out.println("_________________________________________________");
            		 break;
            		 
            	 case 2:
            		 //display all student
            		 
            		 //Crud operation
            		 List<Student> allStudents = studentDao.getAllStudents();
            		 
//            		 Displaying in table format
            		 System.out.println(" ID \t Name \t City");
            		 System.out.println("_____________________________________________________________");
            		 for(Student s: allStudents)
            		 {
            			 System.out.println(" "+s.getStudentId()+" \t "+s.getStudentName()+" \t "+s.getStudentCity());
                		 System.out.println("_____________________________________________________________");
            		 }
            		 System.out.println("_________________________________________________");
            		 break;
            		 
            	 case 3:
            		 //get single student
            		 //Taking user input
            		 System.out.println("Enter user Id : ");
            		 int userId = Integer.parseInt(br.readLine());
            		 
            		 //Crud operation
            		 Student singleStudent = studentDao.getStudent(userId);
            		 
//            		 Displaying in table format
            		 System.out.println(" ID \t Name \t City");
            		 System.out.println("_____________________________________________________________");
            		 
            		 System.out.println(" "+singleStudent.getStudentId()+" \t "+singleStudent.getStudentName()+" \t "+singleStudent.getStudentCity());
            		 
            		 System.out.println("_________________________________________________");
            		 break;
            		 
            	 case 4:
            		 //delete student
            		 
            		 //Taking user input
            		 System.out.println("Enter user Id : ");
            		 int stId = Integer.parseInt(br.readLine());
            		 
            		 //Crud operation
            		 studentDao.deleteStudent(stId);
            		 
            		 System.out.println("Student deleted");
            		 
            		 System.out.println("_________________________________________________");
            		 break;
            		 
            	 case 5:
            		 //update student
            		 
            		//Taking input from user
            		 System.out.println("Enter user id : ");
            		 int studentId = Integer.parseInt(br.readLine());
            		 
            		 System.out.println("Enter user name : ");
            		 String studentName = br.readLine();
            		 
            		 System.out.println("Enter user city : ");
            		 String studentCity = br.readLine();
            		 
            		 //Creating student object
            		 Student st = new Student(studentId, studentName, studentCity);
            		 
            		 //Crud operation
            		 studentDao.updateStudent(st);
            		 
            		 System.out.println("Student updated");
            		 
            		 System.out.println("_________________________________________________");
            		 break;
            		 
            	 case 6:
            		 //exit
            		 
            		 System.out.println("_________________________________________________");
            		 go = false;
            		 break;
            	 }
            	 
             }catch (Exception e) {
				System.out.println("Invalid input try again");
				System.out.println("_________________________________________________");
			}
        }
        
        System.out.println("Thank you");
    }
}
