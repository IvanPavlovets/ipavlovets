package ru.job4j.serial;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean iSallWheelDrive;
    @XmlAttribute
    private long serialNumb;
    @XmlAttribute
    private String name;
    private Engine engine;
    @XmlElementWrapper(name = "colors")
    @XmlElement(name = "color")
    private String[] colors;

    public Car() {
    }

    public Car(boolean iSallWheelDrive, long serialNumb, String name, Engine engine, String[] colors) {
        this.iSallWheelDrive = iSallWheelDrive;
        this.serialNumb = serialNumb;
        this.name = name;
        this.engine = engine;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Car{"
                +
                "iSallWheelDrive=" + iSallWheelDrive
                +
                ", serialNumb=" + serialNumb
                +
                ", name='" + name + '\''
                +
                ", engine=" + engine
                +
                ", colors=" + Arrays.toString(colors) + '}';
    }
}
