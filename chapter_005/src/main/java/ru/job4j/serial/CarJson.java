package ru.job4j.serial;

import java.util.Arrays;

public class CarJson {
    private final boolean iSallWheelDrive;
    private final String name;
    private final EngineJson engine;
    private final String[] colors;

    public CarJson(boolean iSallWheelDrive, String name, EngineJson engine, String... colors) {
        this.iSallWheelDrive = iSallWheelDrive;
        this.name = name;
        this.engine = engine;
        this.colors = colors;
    }

    public boolean isiSallWheelDrive() {
        return iSallWheelDrive;
    }

    public String getName() {
        return name;
    }

    public EngineJson getEngine() {
        return engine;
    }

    public String[] getColors() {
        return colors;
    }

    @Override
    public String toString() {
        return "CarJson{"
                + "iSallWheelDrive=" + iSallWheelDrive
                + ", name='" + name + '\''
                + ", engine=" + engine
                + ", colors=" + Arrays.toString(colors) + '}';
    }
}
