package az.orient.course.util;
import az.orient.course.member.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public static final String folderPath = "C://file";
    public static final String lobFilePath = "C://file/tutor.txt";
    public static final String dekanFilePath = "C://file/dechan.txt";
    public static final String studentFilePath = "C://file/student.txt";

    private static void writeIntoFile(String fileName, String text, boolean append) throws Exception {
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdir();
        }

        FileWriter fw = new FileWriter(fileName, false);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(text);
            bw.newLine();
        }
    }

    public static void writeIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    public static String readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);

        BufferedReader br = new BufferedReader(fr);

        return br.readLine();
    }

    public static void writeStudentToFile(String fileName, List<Student> students) throws IOException {
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdir();
        }

        FileWriter fileWriter = new FileWriter(fileName, true);
        try (BufferedWriter bw = new BufferedWriter(fileWriter);) {

            for(Student student: students){
                bw.write(student.getId()+" "+student.getName() + " " + student.getSurname() + " " + student.getPoint());
                bw.newLine();
            }
        }
    }

    public static List<Student> readStudentFile(String fileName) throws IOException {

        List<Student> list = new ArrayList<>();

        try(FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);){
            while (br.ready()) {
                Student student = new Student();
                String[] arr = br.readLine().split(" ");
                student.setId(Long.parseLong(arr[0]));
                student.setName((arr[1]));
                student.setSurname(arr[2]);
                student.setPoint(Integer.valueOf(arr[3]));
                list.add(student);

            }

            return list;
        }


    }

    public static boolean deleteFile(String filePath){
        File file=new File(filePath);
        return file.delete();
    }
}
