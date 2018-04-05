package ru.job4j.calculator;

/**
 * Программа расчета идеального веса.
 */
public class Fit {

    public static final int MAN_CORRECTOR = 100;
    public static final int WOMAN_CORRECTOR = 110;
    public static final double MULTIPLIER = 1.15;

    /**
     * Идеальный вес для мужчины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - MAN_CORRECTOR) * MULTIPLIER;
    }

    /**
     * Идеальный вес для женьщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - WOMAN_CORRECTOR) * MULTIPLIER;
    }

}
