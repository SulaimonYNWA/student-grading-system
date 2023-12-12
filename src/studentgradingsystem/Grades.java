package studentgradingsystem;

import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;


public class Grades implements Serializable{
    private int grd_id;
    private int std_id;
    private int crs_id;
    private float grd_mt;
    private float grd_hw;
    private float grd_final;
    private String grd_lgrade;

    // Map to store grades with their IDs as keys
    private static Map<Integer, Grades> gradesMap = new HashMap<>();
    // Setter methods
    public void set_grd_id(int grd_id) {
        this.grd_id = grd_id;
    }

    public void set_std_id(int std_id) {
        this.std_id = std_id;
    }

    public void set_crs_id(int crs_id) {
        this.crs_id = crs_id;
    }

    public void set_grd_mt(float grd_mt) {
        this.grd_mt = grd_mt;
    }

    public void set_grd_hw(float grd_hw) {
        this.grd_hw = grd_hw;
    }

    public void set_grd_final(float grd_final) {
        this.grd_final = grd_final;
    }

    public void set_grd_lgrade(String grd_lgrade) {
        this.grd_lgrade = grd_lgrade;
    }

    // Getter methods
    public int get_grd_id() {
        return grd_id;
    }

    public int get_std_id() {
        return std_id;
    }

    public int get_crs_id() {
        return crs_id;
    }

    public float get_grd_mt() {
        return grd_mt;
    }

    public float get_grd_hw() {
        return grd_hw;
    }

    public float get_grd_final() {
        return grd_final;
    }

    public String get_grd_lgrade() {
        return grd_lgrade;
    }

    // Method to add a grade
    public void add_grade(int id, int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, String grd_lgrade) {
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

    // Method to edit a grade
    public void edit_grade(int id, int std_id, int crs_id, float grd_mt, float grd_hw, float grd_final, String grd_lgrade) {
        Grades grade = gradesMap.get(id);
        if (grade != null) {
            grade.set_std_id(std_id);
            grade.set_crs_id(crs_id);
            grade.set_grd_mt(grd_mt);
            grade.set_grd_hw(grd_hw);
            grade.set_grd_final(grd_final);
            grade.set_grd_lgrade(grd_lgrade);
        }
    }

    // Method to delete a grade
    public void delete_grade(int id) {
        gradesMap.remove(id);
    }

    // Method to list a specific grade
    public void list_grade(int id) {
        Grades grade = gradesMap.get(id);
        if (grade != null) {
            System.out.println("Grade ID: " + grade.get_grd_id());
            System.out.println("Student ID: " + grade.get_std_id());
            System.out.println("Course ID: " + grade.get_crs_id());
            System.out.println("Midterm Grade: " + grade.get_grd_mt());
            System.out.println("Homework Grade: " + grade.get_grd_hw());
            System.out.println("Final Grade: " + grade.get_grd_final());
            System.out.println("Letter Grade: " + grade.get_grd_lgrade());
        } else {
            System.out.println("Grade not found with ID: " + id);
        }
    }

    // Method to list all grades
    public void list_all_grades() {
        for (Grades grade : gradesMap.values()) {
            list_grade(grade.get_grd_id());
            System.out.println("-----------------------");
        }
    }

    // Method to delete all grades
    public void delete_all_grades() {
        gradesMap.clear();
    }

}
