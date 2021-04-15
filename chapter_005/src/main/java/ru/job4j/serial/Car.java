package ru.job4j.serial;

import java.util.Arrays;

public class Car {
   private final boolean iSallWheelDrive;
   private final long serialNumb;
   private final String name;
   private final Engine engine;
   private final String[] colors;

    public Car(boolean iSallWheelDrive, long serialNumb, String name, Engine engine, String[] colors) {
        this.iSallWheelDrive = iSallWheelDrive;
        this.serialNumb = serialNumb;
        this.name = name;
        this.engine = engine;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Car{" +
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
