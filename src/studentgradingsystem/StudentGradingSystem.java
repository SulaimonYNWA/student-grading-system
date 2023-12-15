
package studentgradingsystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.Map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        students = new ArrayList();
        courses = new ArrayList();
        grades = new ArrayList();
        departments = new ArrayList();
        attendance = new ArrayList();

        test_students();
        test_courses();
        test_grades();
        test_departments();
        test_attendance();
        System.out.printf("\n");
    }
    
    public static void test_students() {
        try {
        System.out.printf("\n Tests for Class Student\n\n");
        System.out.printf("\n Add_student()\n\n");
        add_student(1, "189222", "Ayse", "Cengiz", "F", "Turkey", "28/03/2002");
        add_student(2, "193342", "Philip", "Udoye", "M", "Nigeria", "16/09/2003");
        add_student(3, "189931", "Kemal", "Salih", "M", "TRNC", "17/05/2002");
        add_student(4, "188883", "Fathima", "Mohammad", "F", "Syria", "22/11/2001");
        add_student(5, "189447", "Jasmin", "Faruq", "F", "Egypt", "19/02/2002");

        System.out.printf("\n List_student()\n\n");
        list_students();
        System.out.printf("\n Edit_student()\n\n");
        edit_student(2, "193342", "Stan", "Udoye", "M", "Nigeria", "16/09/2003");
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
            add_course(1, 1, "ITEC314", "Multi Platform Programming");
            add_course(2, 1, "ITEC413", "Information Systems Security");
            add_course(3, 2, "ECON101", "Introduction to Economics");
            add_course(4, 3, "BUSS103", "Fundamentals of Business Administration");


            System.out.printf("\n List_courses()\n\n");
            list_courses();
//
            System.out.printf("\n Edit_course()\n\n");
            edit_course(1, 1, "MATH134", "Linear algebra");

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
            add_department(1, "Information Technologies");
            add_department(2, "Economics");
            add_department(3, "Business");


    System.out.printf("\nList_department(2)\n\n");
    list_department(2);

    System.out.printf("\nEdit_department(3)\n\n");
    edit_department(2, "Architecture");

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
            edit_grade(2, 2, 1, 88.5f, 79.0f, 93.0f, "A-");
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

  
  
  public static void test_attendance() {
      String[] dateStrings = {"09/04/2021","09/04/2021","09/04/2021","09/04/2021","09/04/2021","12/04/2021","12/04/2021","12/04/2021"};
      Date[] dates = new Date[dateStrings.length];

        // Define the date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i< dateStrings.length; i++) {
            try {
                 dates[i] = dateFormat.parse(dateStrings[i]);
                 System.out.println("Date: " + dates[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
}  

        try {
            System.out.printf("\nTests for Class Attendance\n\n");

            System.out.printf("\nAdd_attendance()\n\n");
            add_attendance(1, 1, 1, dates[0]);
            add_attendance(2, 2, 1, dates[1]);
            add_attendance(3, 3, 2, dates[2]);
            add_attendance(4, 4, 2, dates[3]);
            add_attendance(5, 5, 1, dates[4]);
            add_attendance(6, 1, 1, dates[5]);
            add_attendance(7, 2, 1, dates[6]);
            add_attendance(8, 5, 1, dates[7]);

            System.out.printf("\nList_attendance(2)\n\n");
            list_attendance(2);

            System.out.printf("\nEdit_attendance(3)\n\n");
            edit_attendance(3, 3, 102, new Date());

            System.out.printf("\nList_attendance(3)\n\n");
            list_attendance(3);

            System.out.printf("\nList_all_attendances()\n\n");
            list_all_attendances();

            System.out.printf("\nBackup_attendances()\n\n");
            backup_attendances();

            System.out.printf("\nDelete_attendance(4)\n\n");
            delete_attendance(4);

            System.out.printf("\nList_all_attendances()\n\n");
            list_all_attendances();

            System.out.printf("\nRestore_attendances()\n\n");
            restore_attendances();

            System.out.printf("\nList_all_attendances()\n\n");
            list_all_attendances();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 

    public static void add_attendance(int id, int std_id, int crs_id, Date att_date) {
        Attendance.add_attendance(id, std_id, crs_id, att_date);
        System.out.println("Attendance added: ID=" + id + ", Student ID=" + std_id + ", Course ID=" + crs_id +
                ", Date=" + att_date);
    }

    public static void edit_attendance(int id, int std_id, int crs_id, Date att_date) {
        Attendance.edit_attendance(id, std_id, crs_id, att_date);
        System.out.println("Attendance edited: ID=" + id + ", New Student ID=" + std_id +
                ", New Course ID=" + crs_id + ", New Date=" + att_date);
    }

    public static void delete_attendance(int id) {
        Attendance.delete_attendance(id);
        System.out.println("Attendance deleted: ID=" + id);
    }

    public static void list_attendance(int id) {
        System.out.println("Listing Attendance by ID=" + id);
        Attendance.list_attendance(id);
    }

    public static void list_all_attendances() {
        System.out.println("Listing All Attendances");
        Attendance.list_all_attendances();
    }

   public static void backup_attendances() throws IOException {
        File outfile = new File("attendances.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
        outObjectStream.writeObject(attendance);
        outObjectStream.close();
    }

    // Restore attendances from a file
    public static void restore_attendances() throws IOException, ClassNotFoundException {
        File infile = new File("attendances.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        attendance = (ArrayList<Attendance>) inObjectStream.readObject();
        inObjectStream.close();
    }
    
    
}
