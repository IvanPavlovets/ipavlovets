package ru.job4j.gc;

public class GCDemo {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    /**
     * freeMemory - количество свободной памяти в байтах,
     * totalMemory - общее количество памяти которое может быть использовано,
     * maxMemory - максимальное количество памяти которое может быть использовано
     */
    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }
    public static void main(String[] args) {
        info();
        for (int i = 0; i < 30; i++) {
            new Person(i, "N" + i);
        }
        System.gc(); // вызов сборки мусора
        info();
    }
}
