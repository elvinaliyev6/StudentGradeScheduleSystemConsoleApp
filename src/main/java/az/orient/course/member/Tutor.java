package az.orient.course.member;

import az.orient.course.main.MainClass;
import az.orient.course.util.FileUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tutor {

    public static void process() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Student\n" +
                "2. Back to login\n" +
                "3. Delete student\n" +
                "4. Exit");


        switch (sc.next()) {
            case "1":
                addStudents();
                process();
                break;
            case "2":
                MainClass.main(null);
                break;
            case "3":
                System.out.println("Enter id of student who you want to delete: ");
                deleteStudent(sc.nextLong());
                System.out.println("Success");
                process();
                break;
            case "4":
                System.exit(0);
            default:
                System.out.println("Invalid!!!");
                process();
        }
    }

    public static void deleteStudent(Long id) throws IOException {
        List<Student> students = FileUtility.readStudentFile(FileUtility.studentFilePath);

        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(students.get(i));
                break;
            }
            index++;
        }

        FileUtility.deleteFile(FileUtility.studentFilePath);
        FileUtility.writeStudentToFile(FileUtility.studentFilePath, students);
    }

    public static void addStudents() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write the number of students you want to add: ");
        int say = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < say; i++) {
            Student student = new Student();
            System.out.println("Information of " + (i + 1) + "-th student");
            System.out.println("Enter student id: ");
            student.setId(sc.nextLong());
            System.out.println("Enter student name: ");
            student.setName(sc.next());
            System.out.println("Enter student surname");
            student.setSurname(sc.next());
            sc.nextLine();
            System.out.println("Enter point of student: ");
            student.setPoint(sc.nextInt());
            students.add(student);
        }
        FileUtility.writeStudentToFile(FileUtility.studentFilePath, students);
        System.out.println("Success!");
    }

    public static void createLaborant() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Username-i daxil edin: ");
        String username = sc.nextLine();

        System.out.println("Password-u daxil edin: ");
        String password = sc.nextLine();

        String txt = username + " " + password;
        FileUtility.writeIntoFile(FileUtility.lobFilePath, txt);
        System.out.println("Success");
    }

}
