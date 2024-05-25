import java.util.ArrayList;
import java.util.Scanner;

public class StudentResultManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Subject and Marks");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addSubjectAndMarks();
                    break;
                case 3:
                    displayResults();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    private static void addSubjectAndMarks() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Subject Name: ");
        String subjectName = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        student.addSubject(subjectName, marks);
        System.out.println("Subject and marks added successfully!");
    }

    private static void displayResults() {
        for (Student student : students) {
            student.displayResults();
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}