package az.orient.course.member;

import az.orient.course.main.MainClass;
import az.orient.course.util.FileUtility;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Dechan {

    public static void process() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Show all students");
        System.out.println("2. Show students who score between 91-100");
        System.out.println("3. Show students who score between 71-90");
        System.out.println("4. Show students who score between 51-70");
        System.out.println("5. Show students who score between 0-50");
        System.out.println("6. Login page");
        System.out.println("7. Exit");

        switch (sc.next()) {
            case "1":
                Dechan.showAllStudents();
                process();
                break;
            case "2":
                Dechan.showHighScoreStudents();
                process();
                break;
            case "3":
                Dechan.showMiddleScoreStudents();
                process();
            case "4":
                Dechan.showWeakScoreStudents();
                process();
                break;
            case "5":
                Dechan.showSoWeakScoreStudents();
                process();
                break;
            case "6":
                MainClass.main(null);
                break;
            case "7":
                System.exit(0);
                break;
            default:
                System.out.println("invalid");
        }
    }

    public static void showAllStudents() throws Exception {
        List<Student> list = FileUtility.readStudentFile(FileUtility.studentFilePath);

        if(list.isEmpty()){
            System.out.println("There is no student in file");
        }
        for (Student student1 : list) {
            System.out.println(student1);
        }
    }

    public static void showSoWeakScoreStudents() throws IOException {
        List<Student> list = FileUtility.readStudentFile(FileUtility.studentFilePath);

        int count=0;
        for (Student student1 : list) {
            if (student1.getPoint() >=0 && student1.getPoint() <= 50) {
                count++;
                System.out.println(student1);
            }
        }

        if(count==0){
            System.out.println("There is no student who score between 0-50");
        }
    }

    public static void showWeakScoreStudents() throws IOException {
        List<Student> list = FileUtility.readStudentFile(FileUtility.studentFilePath);

        int count=0;
        for (Student student1 : list) {
            if (student1.getPoint() > 50 && student1.getPoint() <= 70) {
                System.out.println(student1);
                count++;
            }
        }

        if(count==0){
            System.out.println("There is no student who score between 51-70");
        }
    }

    public static void showHighScoreStudents() throws IOException {
        List<Student> list = FileUtility.readStudentFile(FileUtility.studentFilePath);

        int count=0;
        for (Student student1 : list) {
            if (student1.getPoint() > 90 && student1.getPoint() <= 100) {
                System.out.println(student1);
                count++;
            }
        }

        if(count==0){
            System.out.println("There is no student who score between 91-100");
        }
    }

    public static void showMiddleScoreStudents() throws IOException {
        List<Student> list = FileUtility.readStudentFile(FileUtility.studentFilePath);

        int count=0;
        for (Student student1 : list) {
            if (student1.getPoint() > 70 && student1.getPoint() <= 90) {
                System.out.println(student1);
                count++;
            }
        }

        if(count==0){
            System.out.println("There is no student who score between 71-90");
        }
    }


    public static void createDechan() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username-i daxil edin: ");
        String username = sc.nextLine();

        System.out.println("Password-u daxil edin: ");
        String password = sc.nextLine();

        String txt = username + " " + password;
        FileUtility.writeIntoFile(FileUtility.dekanFilePath, txt);
    }
}
