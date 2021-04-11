package ru.job4j.inoutput;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Scanner;


public class Start {

    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        // получаем консоль
//        Console console = System.console();
//        if(console!=null){
//            // считываем данные с консоли
//            String login = console.readLine("Введите логин:");
//            char[] password = console.readPassword("Введите пароль:");
//
//            console.printf("Введенный логин: %s \n", login);
//            console.printf("Введенный пароль: %s \n", new String(password));
//        }

//        System.out.println("sad");
//        File f1 = new File("D:/1.txt");
//        p("File name: " + f1.getName());
//        p("Path: " + f1.getPath());
//        p("AbsolutePath: " + f1.getAbsolutePath());
//        p("Parent dir: " + f1.getParent());
//        p("Last Modified: " + f1.lastModified());
//        p("Size: " + f1.length() + " byte");


//        FileInputStream fis = null;
//        InputStreamReader isr = null;
//        BufferedReader buf = null;
//        PrintWriter pr = null;
//        int in = 0;
//        String str;
//        try {
//            fis = new FileInputStream("D:/1.txt");
//            isr = new InputStreamReader(fis);
//            buf = new BufferedReader(new InputStreamReader(System.in));
//            pr = new PrintWriter(System.out, true);
////            while ((in = isr.read()) != -1) {
////                System.out.println((char) in);
////            }
////            do {
////                str = buf.readLine();
////                System.out.println(str);
////            } while (!str.equals("q"));
//
//            pr.println("This is string");
//            int i = 10;
//            pr.println(i);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Path path = Paths.get("temp.txt").toAbsolutePath();
//        Files.write(path, "bla\n new String".getBytes());
//        System.out.println(path.getFileName());
//        System.out.println(path.getParent());
//        System.out.println(path.getRoot());
//        System.out.println(path.isAbsolute());
//        Files.copy(Paths.get("temp.txt"), Paths.get("temp1.txt"), StandardCopyOption.REPLACE_EXISTING);
       Files.move(Paths.get("temp1.txt"), Paths.get("temp3.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.deleteIfExists(Paths.get("temp3.txt"));
//        byte[] bytes = Files.readAllBytes(path);
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//        }

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            System.out.println("Your: " + scanner.next());
//        }

      //  BasicFileAttributes attributes = Files.readAttributes(Paths.get("temp.txt"), DosFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

    }
}
