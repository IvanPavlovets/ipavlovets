package ru.job4j.inoutput;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "C:\\ipavlovets\\ipavlovets\\app1.properties";
        Config config = new Config(path);
        config.load();
        String str = config.value("hibernate.connection.password");
        assertThat(str,
                is("password")
        );
    }
}
