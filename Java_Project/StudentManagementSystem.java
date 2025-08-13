import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a student
class Student {
    int rollNumber;
    String name;
    int age;

    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }
}

// Main class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Add a new student
    public static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(roll, name, age));
        System.out.println("Student added successfully!");
    }

    // View all students
    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- List of Students ---");
            for (Student s : students) {
                System.out.println("Roll: " + s.rollNumber + ", Name: " + s.name + ", Age: " + s.age);
            }
        }
    }

    // Search student by roll number
    public static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
            if (s.rollNumber == roll) {
                System.out.println("Found: Roll: " + s.rollNumber + ", Name: " + s.name + ", Age: " + s.age);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Delete a student
    public static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();
        boolean removed = students.removeIf(s -> s.rollNumber == roll);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}