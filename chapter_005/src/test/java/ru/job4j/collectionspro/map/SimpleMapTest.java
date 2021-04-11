package ru.job4j.collectionspro.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {

    @Test
    public void whenInsertABThenGetA() {
        SimpleMap<String, String> str = new SimpleMap<>();
        str.insert("A", "B");
        assertThat(str.get("A"), is("B"));
    }

    @Test
    public void whenInsertABACThenRewrite() {
        SimpleMap<String, String> str = new SimpleMap<>();
        str.insert("A", "B");
        assertThat(str.get("A"), is("B"));
        str.insert("A", "C");
        assertThat(str.get("A"), is("C"));
    }

    @Test(expected = NullPointerException.class)
    public void whenDeleteKeyThenGetNull() {
        SimpleMap<String, String> str = new SimpleMap<>();
        str.insert("A", "B");
        assertThat(str.get("A"), is("B"));
        str.delete("A");
        assertThat(str.get("A"), null);
    }

    @Test
    public void whenInsert17CThenTableIncreseTo32() {
        SimpleMap<String, String> str = new SimpleMap<>();
        str.insert("1", "1");
        assertThat(str.getLength(), is(16));
        str.insert("2", "2");
        str.insert("3", "3");
        str.insert("4", "4");
        str.insert("5", "5");
        str.insert("6", "6");
        str.insert("7", "7");
        str.insert("8", "8");
        str.insert("9", "9");
        str.insert("10", "10");
        str.insert("11", "11");
        str.insert("12", "12");
        str.insert("13", "13");
        str.insert("14", "14");
        str.insert("15", "15");
        str.insert("16", "16");
        str.insert("17", "17");
        assertThat(str.getLength(), is(32));
    }

}
