package ru.job4j.inoutput;

import java.io.Console;


public class Main1 {

    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        // получаем консоль
        Console console = System.console();
        if (console != null) {
            // считываем данные с консоли
            String login = console.readLine("Введите логин:");
            char[] password = console.readPassword("Введите пароль:");

            console.printf("Введенный логин: %s \n", login);
            console.printf("Введенный пароль: %s \n", new String(password));
        }

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
    }
}
