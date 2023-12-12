
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
        departments = new ArrayList();
//        attendance = new ArrayList();

        test_students();
        test_courses();
        test_grades();
        test_departments();
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
            JOptionPane.showMessageDialog(null, "Error");
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
    
    public static void test_departments() {
       try {
    System.out.printf("\nTests for Class Department\n\n");

    System.out.printf("\nAdd_department()\n\n");
    add_department(1, "Computer Science");
    add_department(2, "Electrical Engineering");
    add_department(3, "Mechanical Engineering");
    add_department(4, "Mathematics");
    add_department(5, "Physics");

    System.out.printf("\nList_department(2)\n\n");
    list_department(2);

    System.out.printf("\nEdit_department(3)\n\n");
    edit_department(2, "Mechanical and Aerospace Engineering");

    System.out.printf("\nList_department(3)\n\n");
    list_department(2);

    System.out.printf("\nList_all_departments()\n\n");
    list_all_departments();

    System.out.printf("\nBackup_departments()\n\n");
    backup_departments();

    System.out.printf("\nDelete_department(4)\n\n");
    delete_department(3);

    System.out.printf("\nList_all_departments()\n\n");
    list_all_departments();

    System.out.printf("\nRestore_departments()\n\n");
    restore_departments();

    System.out.printf("\nList_all_departments()\n\n");
    list_all_departments();
    } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public static void add_department(int id, String dept_name) {
        Department.add_department(id, dept_name);
        System.out.println("Department added: ID=" + id + ", Name=" + dept_name);
    }

    public static void edit_department(int id, String dept_name) {
        Department.edit_department(id, dept_name);
        System.out.println("Department edited: ID=" + id + ", New Name=" + dept_name);
    }

    public static void delete_department(int id) {
        Department.delete_department(id);
        System.out.println("Department deleted: ID=" + id);
    }

    public static void list_department(int id) {
        System.out.println("Listing Department by ID=" + id);
        Department.list_department(id);
    }

    public static void list_all_departments() {
        System.out.println("Listing All Departments");
        Department.list_all_departments();
    }

     // Backup departments to a file
    public static void backup_departments() throws IOException {
        File outfile = new File("departments.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
        outObjectStream.writeObject(departments);
        outObjectStream.close();
    }

     // Restore departments from a file
    public static void restore_departments() throws IOException, ClassNotFoundException {
        File infile = new File("departments.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        departments = (ArrayList<Department>) inObjectStream.readObject();
        inObjectStream.close();
    }

    public static void test_grades() {
        try {
            System.out.printf("\n Tests for Class Grades\n\n");
            System.out.printf("\n Add_grade()\n\n");
            add_grade(1, 1, 1, 90f, 88f, 96f, "A");
            add_grade(2, 2, 1, 80f, 85f, 82f, "B+");
            add_grade(3, 3, 2, 75f, 80f, 77f, "B-");
            add_grade(4, 4, 2, 69f, 75f, 66f, "C+");
            add_grade(5, 5, 1, 88f, 80f, 82f, "A-");

            System.out.printf("\n List_grades()\n\n");
            list_grades();
            System.out.printf("\n Edit_grade()\n\n");
            edit_grade(2, 2, 102, 88.5f, 79.0f, 93.0f, "A-");
            System.out.printf("\n List_grades()\n\n");
            list_grades();
            backup_grades();

            System.out.printf("\n Delete_grade(4)\n\n");
            delete_grade(3);

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

}
