package ru.job4j.inputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    public final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try {
            BufferedReader read = new BufferedReader(new FileReader(this.path));
            List<String> lines = read.lines().filter(task -> task.contains("=")).collect(Collectors.toList());
            for (String line : lines) {
                addValue(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addValue(String string) {
        String[] tokens = string.split("=");
        values.put(tokens[0], tokens[1]);
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try {
            BufferedReader read = new BufferedReader(new FileReader(this.path));
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("app.properties");
        config.load();
        System.out.println(config.value("hibernate.connection.password"));
    }
}
