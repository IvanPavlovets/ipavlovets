package ru.job4j.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }

        String name = "Ivan Pavlovets";
        int age = 33;
        char sex = 'M';
        byte b = 0x55;
        short s = 0x55aa;
        double d = 4.12d;
        float f = 12.12f;
        long l = 100000000;
        LOG.debug("User info name: {}, age: {}, sex: {},"
                +
                " byte: {}, short: {}, double: {}, float: {}, long: {}",
                name, age, sex, b, s, d, f, l);
    }
}
