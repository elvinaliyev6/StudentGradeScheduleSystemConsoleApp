package az.orient.course.main;


import az.orient.course.member.Dechan;
import az.orient.course.util.FileUtility;
import az.orient.course.member.Tutor;
import az.orient.course.util.MainUtil;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("dechan or tutor?");
            String line = sc.next();

            switch (line) {
                case "dechan":
                    System.out.println("Enter username: ");
                    String username = sc.next();
                    System.out.println("Enter password: ");
                    String password = sc.next();
                    if (MainUtil.login(username, password, FileUtility.dekanFilePath)) {
                        System.out.println("Successfully logined. Welcome Dechan!!!");
                        Dechan.process();
                    } else {
                        System.out.println("username or password is invalid");
                    }
                    break;
                case "tutor":
                    System.out.println("Enter username: ");
                     username = sc.next();
                    System.out.println("Enter password: ");
                     password = sc.next();
                    if (MainUtil.login(username, password, FileUtility.lobFilePath)) {
                        System.out.println("Successfully logined. Welcome Tutor!!!");
                        Tutor.process();
                    } else {
                        System.out.println("username or password is invalid");
                    }
                    break;
            }
        }
    }
}
