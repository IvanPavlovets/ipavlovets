package ru.job4j.inputOutput;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Analizy {
    /**
     * Метод читает файл сервера и переписывает в другой файл
     * промежуток времени, когда сервер не работал.
     * Формат файла - начала периода;конец периода;
     *
     * @param source - имя файла лога.
     * @param target - имя файла после анализа.
     */
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            List<String> lines = read.lines().filter(task -> task.contains(" ")).collect(Collectors.toList());
            Iterator it = lines.iterator();
            String line1;
            String line2;
            String[] buffer = new String[2];
            while (it.hasNext()) {
                line1 = (String) it.next();
                if (line1.contains("400") || line1.contains("500")) {
                    buffer[0] = addValue(line1);
                    while (it.hasNext()) {
                        line2 = (String) it.next();
                        if (line2.contains("200") || line2.contains("300")) {
                            buffer[1] = addValue(line2);
                            out.println(buffer[0] + ";" + buffer[1]);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Перегруженый метод для целей тестирования, бизнес логика аналогична - unavailable(String source, String target).
     *
     * @param source - коллекция на входе, имитирует файл лога.
     * @param target - коллекция на выходе, имитирует файл после анализа.
     */
    public List<String> unavailable(List<String> source) {
        List<String> target = new ArrayList<>();
        List<String> lines = source.stream().filter(task -> task.contains(" ")).collect(Collectors.toList());
        Iterator it = lines.iterator();
        String line1;
        String line2;
        String[] buffer = new String[2];
        while (it.hasNext()) {
            line1 = (String) it.next();
            if (line1.contains("400") || line1.contains("500")) {
                buffer[0] = addValue(line1);
                while (it.hasNext()) {
                    line2 = (String) it.next();
                    if (line2.contains("200") || line2.contains("300")) {
                        buffer[1] = addValue(line2);
                        target.add(buffer[0] + ";" + buffer[1]);
                        break;
                    }
                }
            }
        }
        return target;
    }

    private String addValue(String string) {
        String[] tokens = string.split(" ");
        System.out.println(tokens[0] + " " + tokens[1]);
        return tokens[1];
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./dataServer/server1.log", "./dataServer/unavailable.csv");
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
