package ru.job4j.inputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        values.clear();
        try {
            BufferedReader read = new BufferedReader(new FileReader(this.path));
            read.lines()
                    .filter(l -> !l.startsWith("#") && !l.isBlank())
                    .forEach(line -> {
                        String[] tokens = line.split("=");
                        values.put(tokens[0], tokens[1]);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }
}
