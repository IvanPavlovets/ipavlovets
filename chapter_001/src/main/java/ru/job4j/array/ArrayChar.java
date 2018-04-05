package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    // массив символов инициализируемый в конструкторе.
    private char[] data;

    // инициализация data в конструкторе.
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // сравнивает символы в массивах (введеном и инициализируемом в констркуторе).
        for (int i = 0; i < value.length; i++) {
            // если неравенство верно то флаг меняеться на false.
            if (value[i] != data[i]) {
                return false;
            }
        }
        return result;
    }

}
