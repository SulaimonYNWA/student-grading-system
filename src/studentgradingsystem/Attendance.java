package studentgradingsystem;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Attendance {
    private int att_id;
    private int std_id;
    private int crs_id;
    private Date att_date;

    private static ArrayList<Attendance> attendances = new ArrayList<>();

    // Setters
    public void set_att_id(int id) {
        this.att_id = id;
    }

    public void set_std_id(int std_id) {
        this.std_id = std_id;
    }

    public void set_crs_id(int crs_id) {
        this.crs_id = crs_id;
    }

    public void set_att_date(Date att_date) {
        this.att_date = att_date;
    }

    // Getters
    public int get_att_id() {
        return att_id;
    }

    public int get_std_id() {
        return std_id;
    }

    public int get_crs_id() {
        return crs_id;
    }

    public Date get_att_date() {
        return att_date;
    }

    // Add new attendance
    public static void add_attendance(int id, int std_id, int crs_id, Date att_date) {
        Attendance attendance = new Attendance();
        attendance.set_att_id(id);
        attendance.set_std_id(std_id);
        attendance.set_crs_id(crs_id);
        attendance.set_att_date(att_date);
        attendances.add(attendance);
    }

    // Edit existing attendance
    public static void edit_attendance(int id, int std_id, int crs_id, Date att_date) {
        Attendance attendance = findAttendanceById(id);
        if (attendance != null) {
            attendance.set_std_id(std_id);
            attendance.set_crs_id(crs_id);
            attendance.set_att_date(att_date);
        }
    }

    // Delete attendance by ID
    public static void delete_attendance(int id) {
        Attendance attendance = findAttendanceById(id);
        if (attendance != null) {
            attendances.remove(attendance);
        }
    }

    // List attendance by ID
    public static void list_attendance(int id) {
        Attendance attendance = findAttendanceById(id);
        if (attendance != null) {
            System.out.println("Attendance ID: " + attendance.get_att_id());
            System.out.println("Student ID: " + attendance.get_std_id());
            System.out.println("Course ID: " + attendance.get_crs_id());
            System.out.println("Date: " + attendance.get_att_date());
        } else {
            System.out.println("Attendance not found with ID: " + id);
        }
    }

    // List all attendances
    public static void list_all_attendances() {
        for (Attendance attendance : attendances) {
            System.out.println("Attendance ID: " + attendance.get_att_id());
            System.out.println("Student ID: " + attendance.get_std_id());
            System.out.println("Course ID: " + attendance.get_crs_id());
            System.out.println("Date: " + attendance.get_att_date());
            System.out.println("-------------------------");
        }
    }

    // Delete all attendances
    public static void delete_all_attendances() {
        attendances.clear();
    }

    // Backup attendances to a file
    public static void backup_attendances() throws IOException {
        File outfile = new File("attendances.dat");
        FileOutputStream outfilestream = new FileOutputStream(outfile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outfilestream);
        outObjectStream.writeObject(attendances);
        outObjectStream.close();
    }

    // Restore attendances from a file
    public static void restore_attendances() throws IOException, ClassNotFoundException {
        File infile = new File("attendances.dat");
        FileInputStream infilestream = new FileInputStream(infile);
        ObjectInputStream inObjectStream = new ObjectInputStream(infilestream);
        attendances = (ArrayList<Attendance>) inObjectStream.readObject();
        inObjectStream.close();
    }

    // Helper method to find attendance by ID
    private static Attendance findAttendanceById(int id) {
        for (Attendance attendance : attendances) {
            if (attendance.get_att_id() == id) {
                return attendance;
            }
        }
        return null;
    }
}
