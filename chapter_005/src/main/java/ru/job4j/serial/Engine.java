package ru.job4j.serial;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "engine")
public class Engine {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int number;

    public Engine() {
    }

    public Engine(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Engine{"
                +
                "name='" + name + '\''
                +
                ", number=" + number + '}';
    }
}
