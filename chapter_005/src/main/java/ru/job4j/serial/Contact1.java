package ru.job4j.serial;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class Contact1 {
    @XmlAttribute
    private String phone;

    public Contact1() {
    }

    public Contact1(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact1{"
                +
                "phone='" + phone + '\'' + '}';
    }
}
