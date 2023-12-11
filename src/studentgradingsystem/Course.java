
package studentgradingsystem;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;
import java.io.Serializable;

public class Course implements Serializable {
    private int crsId;
    private int deptId;
    private String crsCode;
    private String crsName;

    // Constructors
    public Course() {}

  private static  List<Course> courses = new ArrayList<>();

    public Course(int crsId, int deptId, String crsCode, String crsName) {
        this.crsId = crsId;
        this.deptId = deptId;
        this.crsCode = crsCode;
        this.crsName = crsName;
    }

    // Setters
    public void set_crs_id(int id) {
        this.crsId = id;
    }

    public void set_dept_id(int deptId) {
        this.deptId = deptId;
    }

    public void set_crs_code(String crsCode) {
        this.crsCode = crsCode;
    }

    public void set_crs_name(String crsName) {
        this.crsName = crsName;
    }

    // Getters
    public int get_crs_id() {
        return this.crsId;
    }

    public int get_dept_id() {
        return this.deptId;
    }

    public String get_crs_code() {
        return this.crsCode;
    }

    public String get_crs_name() {
        return this.crsName;
    }


    // Methods
    public void add_course(int id, int deptId, String crsCode, String crsName) {
        Course course = new Course(id, deptId, crsCode, crsName);
        courses.add(course);
    }

    public void edit_course(int id, int deptId, String crsCode, String crsName) {
        for (Course course : courses) {
            if (course.get_crs_id() == id) {
                course.set_dept_id(deptId);
                course.set_crs_code(crsCode);
                course.set_crs_name(crsName);
                break;
            }
        }
    }

    public void delete_course(int id) {
        courses.removeIf(course -> course.get_crs_id() == id);
    }

    public void list_course(int id) {
        for (Course course : courses) {
            if (course.get_crs_id() == id) {
                System.out.println("Course ID: " + course.get_crs_id());
                System.out.println("Department ID: " + course.get_dept_id());
                System.out.println("Course Name: " + course.get_crs_name());
                System.out.println("Course Code: " + course.get_crs_code());
                break;
            }
        }
    }


    public void delete_all_courses() {
        courses.clear();
    }

}


