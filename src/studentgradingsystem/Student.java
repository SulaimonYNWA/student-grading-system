package studentgradingsystem;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Cem Yağlı
 * The information of each student will be kept in this class
 */

public class Student implements Serializable{
  private  int std_id;  
  private  String std_no;
  private  String std_name;
  private  String std_surname;
  private  String gender;
  private  String nationality;
  private  String birthday;

  private static  List<Student> students = new ArrayList<>();

    public Student(int std_id, String std_no, String std_name, String std_surname, String gender, String nationality, String birthday) {
        this.std_id = std_id;
        this.std_no = std_no;
        this.std_name = std_name;
        this.std_surname = std_surname;
        this.gender = gender;
        this.nationality = nationality;
        this.birthday = birthday;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }
 
    public String getStd_no() {
        return std_no;
    }

    public void setStd_no(String std_no) {
        this.std_no = std_no;
    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getStd_surname() {
        return std_surname;
    }

    public void setStd_surname(String std_surname) {
        this.std_surname = std_surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static void add_student(Student student){
        students.add(student);
    }
 
    
    public static void edit_student(Student student){
        for (int i =0; i<students.size(); i++){
            if (students.get(i).getStd_id() == student.getStd_id()){
                students.set(i, student);
                break;
            }
        }
    }
    
    // list_students prints all data about students.
    public static void list_students(){
        for (Student student : students){
            System.out.println("Student ID: " + student.getStd_id());
            System.out.println("Student Number: "+ student.getStd_no());
            System.out.println("Student Name & Surname: "+ student.getStd_name() +" "+ student.getStd_surname());
            System.out.println("Student Gender: "+ student.getGender());
            System.out.println("Student Nationality: "+ student.getNationality());
            System.out.println("Student Birthday: "+ student.getBirthday());
            System.out.println("-----------------------------");
        }
    }
    
    // delete_student deletes a student with the given ID.
    public static void delete_student(int std_id){
        students.removeIf(student -> student.getStd_id() == std_id);
    }
    
    public static List<Student> backup_students(List<Student> backup){
        students = new ArrayList <>(backup);
        System.out.println("Students restored successfully.");
        return students;
    }

}
