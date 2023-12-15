/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradingsystem;
import java.io.*;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author sulaimon
 */

public class Department implements Serializable {
    private int dept_id;
    private String dept_name;

    private static ArrayList<Department> departments = new ArrayList<>();

    // Setters
    public void set_dept_id(int id) {
        this.dept_id = id;
    }

    public void set_dept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    // Getters
    public int get_dept_id() {
        return dept_id;
    }

    public String get_dept_name() {
        return dept_name;
    }

    // Add a new department
    public static void add_department(int id, String dept_name) {
        Department department = new Department();
        department.set_dept_id(id);
        department.set_dept_name(dept_name);
        departments.add(department);
    }

    // Edit an existing department
    public static void edit_department(int id, String dept_name) {
        Department department = findDepartmentById(id);
        if (department != null) {
            department.set_dept_name(dept_name);
        }
    }

    // Delete a department by ID
    public static void delete_department(int id) {
        Department department = findDepartmentById(id);
        if (department != null) {
            departments.remove(department);
        }
    }

    // List a department by ID
    public static void list_department(int id) {
        Department department = findDepartmentById(id);
        if (department != null) {
            System.out.println("Department ID: " + department.get_dept_id());
            System.out.println("Department Name: " + department.get_dept_name());
        } else {
            System.out.println("Department not found with ID: " + id);
        }
    }

    // List all departments
    public static void list_all_departments() {
        for (Department department : departments) {
            System.out.println("Department ID: " + department.get_dept_id());
            System.out.println("Department Name: " + department.get_dept_name());
            System.out.println("-------------------------");
        }
    }

    // Delete all departments
    public static void delete_all_departments() {
        departments.clear();
    }

  

    // Helper method to find a department by ID
    private static Department findDepartmentById(int id) {
        for (Department department : departments) {
            if (department.get_dept_id() == id) {
                return department;
            }
        }
        return null;
    }
}
