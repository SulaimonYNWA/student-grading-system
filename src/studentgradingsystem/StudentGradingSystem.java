
package studentgradingsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cem Yagli
 */
public class StudentGradingSystem {
  public static List students, grades, departments, courses, attendance;
    private static Map<Integer, Grades> gradesMap = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        students = new ArrayList();
        courses = new ArrayList();
        grades = new ArrayList();
//        departments = new ArrayList();
//        attendance = new ArrayList();

        test_students();
        test_courses();
        test_grades();
        System.out.printf("\n");
    }
    
    public static void test_students() {
        try {
        System.out.printf("\n Tests for Class Student\n\n");
        System.out.printf("\n Add_student()\n\n");
        add_student(1, "116229", "Ali Huseyin", "Faisal", "Male", "Turkey", "19/06/1993");
        add_student(2, "186731", "Ayse", "Kemaller", "Female", "Cyprus", "28/09/1998");
        add_student(3, "168337", "Muhammad", "Fahrad", "Male", "Iran", "30/05/1996");
        add_student(4, "189222", "Fatima", "Reshad", "Female", "Syria", "22/07/1998");
        add_student(5, "199221", "Bahar", "Tunc", "Female", "Cyprus", "27/08/2019");
        System.out.printf("\n List_student()\n\n");
        list_students();
        System.out.printf("\n Edit_student()\n\n");
        edit_student(2, "186731", "Ayse", "Kemaller", "Female", "Turkey", "28/09/1998");
        System.out.printf("\n List_student()\n\n");
        list_students();
        backup_student();
        
        System.out.printf("\n Delete_student(4)\n\n");
        delete_student(4);
        
        System.out.printf("\n List_student()\n\n");
        list_students();
        
        retrieve_student();
        System.out.printf("\n List_student()\n\n");
        list_students();
        }
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
                }
    }
    
    public static void retrieve_student() throws IOException, ClassNotFoundException
    {
     File infile  = new File("students.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     students = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
     
    }
    public static void backup_student() throws IOException
    {
     File outfile  = new File("students.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(students);
     outObjectStream.close();
     
    }
    
    public static void add_student(int std_id, String std_no, String std_name, String std_surname,
            String gender, String nationality, String birthday) {
            Student st =new Student(std_id, std_no, std_name, std_surname,
                                    gender, nationality, birthday);
            students.add(st);
    }
    
      public static void edit_student(int std_id, String std_no, String std_name, 
                               String std_surname, String gender, 
                               String nationality, String birthday) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(std_id==st.getStd_id()) {
              found=true;
              break;
          }
      }
      if (found) {
          st.setStd_no(std_no);
          st.setStd_name(std_name);
          st.setStd_surname(std_surname);
          st.setNationality(nationality);
          st.setGender(gender);
          st.setBirthday(birthday);
      }
      }

public static void delete_student(int std_id) {
      Student st=null;
      Boolean found=false;
      Iterator <Student> itr = students.iterator();
      while (itr.hasNext()) {
          st = itr.next(); 
          if(std_id==(st.getStd_id())) {
              found=true;
              break;
          }
      }
      if (found) students.remove(st);
      }
    
    public static void draw_line(int num) {
        String ln="";
        for (int i=0; i<num; i++) ln+="=";
        System.out.printf("\n"+ln);
    }
    
    public static void list_students() {
      Student st;
      Iterator <Student> itr = students.iterator();
      System.out.printf("\n%2s %10s %15s %15s %10s %12s %12s",
              "Id", "Student No","Std. Name", "Std. Surname", 
              "Gender","Nationality", "Birthday");
        draw_line(79);
        
      while (itr.hasNext()) {
          st = itr.next(); 
          System.out.printf("\n%2d %10s %15s %15s %10s %12s %12s", 
              st.getStd_id(), st.getStd_no(), 
              st.getStd_name(), st.getStd_surname(),
              st.getGender(), st.getNationality(), st.getBirthday());
      }
      draw_line(79);
        
    }

    public static void test_courses() {
        try {
            System.out.printf("\n Tests for Class Course\n\n");

            System.out.printf("\n Add_course()\n\n");
            add_course(1, 101, "CS101", "Intro to Computer Science");
            add_course(2, 102, "MATH101", "Calculus I");
            add_course(3, 103, "PHYS101", "Physics I");

            System.out.printf("\n List_courses()\n\n");
            list_courses();
//
            System.out.printf("\n Edit_course()\n\n");
            edit_course(1, 101, "MATH134", "Linear algebra");

            System.out.printf("\n List_courses()\n\n");
            list_courses();

            backup_courses();

            System.out.printf("\n Delete_course(1)\n\n");
            delete_course(1);

            System.out.printf("\n List_courses()\n\n");
            list_courses();

            retrieve_courses();
            System.out.printf("\n List_courses()\n\n");
            list_courses();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "damn, Error");
        }
    }

    
    public static void retrieve_courses() throws IOException, ClassNotFoundException
    {
     File infile  = new File("courses.dat");
     FileInputStream infilestream = new FileInputStream(infile);
     ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
     courses = (ArrayList)inObjectStream.readObject();
     
     inObjectStream.close();
    }
    
      public static void backup_courses() throws IOException
    {
     File outfile  = new File("courses.dat");
     FileOutputStream outfilestream = new FileOutputStream(outfile);
     ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
     
     outObjectStream.writeObject(courses);
     outObjectStream.close();
     
    }

    public static void add_course(int crsId, int deptId, String crsCode, String crsName) {
        Course course = new Course(crsId, deptId, crsCode, crsName);
        courses.add(course);
    }

    public static void edit_course(int crsId, int deptId, String crsCode, String crsName) {
        Course course = null;
        boolean found = false;
        Iterator<Course> itr = courses.iterator();
        while (itr.hasNext()) {
            course = itr.next();
            if (crsId == course.get_crs_id()) {
                found = true;
                break;
            }
        }
        if (found) {
            
            course.set_dept_id(deptId);
            course.set_crs_code(crsCode);
            course.set_crs_name(crsName);
        }
    }

    
public static void delete_course(int crs_id) {
      Course course = null;
      Boolean found=false;
      Iterator <Course> itr = courses.iterator();
      while (itr.hasNext()) {
          course = itr.next(); 
          if(crs_id==(course.get_crs_id())) {
              found=true;
              break;
          }
      }
      if (found) courses.remove(course);
      }

    public static void list_courses() {
        Course course;
        Iterator<Course> itr = courses.iterator();
        System.out.printf("\n%2s %5s %15s %30s", "Id", "Dept Id", "Course Code", "Course Name");
        draw_line(70);
        

        while (itr.hasNext()) {
            course = itr.next();
            System.out.printf("\n%2d %5d %15s %30s",
                    course.get_crs_id(), course.get_dept_id(),
                    course.get_crs_code(), course.get_crs_name());
        }
        draw_line(70);
    }
    

    public static void test_grades() {
        try {
            System.out.printf("\n Tests for Class Grades\n\n");
            System.out.printf("\n Add_grade()\n\n");
            add_grade(1, 1, 101, 90.5f, 85.5f, 95.0f, "A");
            add_grade(2, 2, 102, 85.0f, 78.0f, 92.5f, "B");
            add_grade(3, 3, 103, 78.5f, 88.0f, 89.0f, "B+");
            add_grade(4, 1, 104, 92.0f, 75.5f, 94.0f, "A");
            add_grade(5, 2, 105, 88.0f, 82.5f, 91.0f, "A-");
            System.out.printf("\n List_grades()\n\n");
            list_grades();
            System.out.printf("\n Edit_grade()\n\n");
            edit_grade(2, 2, 102, 88.5f, 79.0f, 93.0f, "A-");
            System.out.printf("\n List_grades()\n\n");
            list_grades();
            backup_grades();

            System.out.printf("\n Delete_grade(4)\n\n");
            delete_grade(4);

            System.out.printf("\n List_grades()\n\n");
            list_grades();

            restore_grades();
            System.out.printf("\n List_grades()\n\n");
            list_grades();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void restore_grades() throws IOException, ClassNotFoundException {
        File infile = new File("grades.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        gradesMap = (Map<Integer, Grades>) inObjectStream.readObject();
        inObjectStream.close();
    }

    public static void backup_grades() throws IOException {
        File outfile = new File("grades.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
        outObjectStream.writeObject(gradesMap);
        outObjectStream.close();
    }

    public static void add_grade(int id, int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, String grd_lgrade) {
        Grades grade = new Grades();
        grade.set_grd_id(id);
        grade.set_std_id(std_id);
        grade.set_crs_id(crs_id);
        grade.set_grd_mt(grd_mt);
        grade.set_grd_hw(grd_hw);
        grade.set_grd_final(grd_final);
        grade.set_grd_lgrade(grd_lgrade);
        gradesMap.put(id, grade);
    }

    public static void edit_grade(int id, int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, String grd_lgrade) {
        Grades grade = findGradeById(id);
        if (grade != null) {
            grade.set_std_id(std_id);
            grade.set_crs_id(crs_id);
            grade.set_grd_mt(grd_mt);
            grade.set_grd_hw(grd_hw);
            grade.set_grd_final(grd_final);
            grade.set_grd_lgrade(grd_lgrade);
        }
    }

    public static void delete_grade(int id) {
        gradesMap.remove(id);
    }

    public static void list_grades() {
        System.out.printf("\n%2s %10s %10s %10s %10s %10s %15s",
                "Id", "Student ID", "Course ID", "Midterm", "Homework",
                "Final", "Letter Grade");
        draw_line(79);

        for (Grades grade : gradesMap.values()) {
            System.out.printf("\n%2d %10d %10d %10.2f %10.2f %10.2f %10s %s",
                    grade.get_grd_id(), grade.get_std_id(),
                    grade.get_crs_id(), grade.get_grd_mt(),
                    grade.get_grd_hw(), grade.get_grd_final(),
                    "",
                    grade.get_grd_lgrade());
        }
        draw_line(79);
    }



  private static Grades findGradeById(int id) {
    return gradesMap.get(id);
}
  
  // testing.

}
