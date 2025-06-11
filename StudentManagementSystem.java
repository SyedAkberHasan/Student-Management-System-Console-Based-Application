import java.util.*;

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Record Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        students.add(new Student(roll, name, marks));
        System.out.println("✅ Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("❌ No student records found.");
            return;
        }
        System.out.println("📋 Student Records:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.println("✅ Student Found: " + s);
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();
        for (Student s : students) {
            if (s.getRollNo() == roll) {
                sc.nextLine(); // clear buffer
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();
                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("✅ Student updated successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNo() == roll) {
                it.remove();
                System.out.println("🗑️ Student deleted successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }
}
