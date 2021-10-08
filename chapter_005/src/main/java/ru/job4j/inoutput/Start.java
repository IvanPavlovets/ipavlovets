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

       Files.move(Paths.get("temp1.txt"), Paths.get("temp3.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
