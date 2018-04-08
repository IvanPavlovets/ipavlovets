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

    // конструктор без параметров.
    public ArrayChar() {
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

    /**
     * Проверяет что слово String находится в другом слове String.
     * @param origin - целое слово.
     * @param sub - часть слова котороя может находиться в слове origin.
     * @return - true если часть слова действительно находиться в целом слове.
     */
    public boolean contains(String origin, String sub) {
        // формирование массивов символов
        this.data = origin.toCharArray();
        char[] value = sub.toCharArray();
        // в циклах поочереди каждую букву data[] сравниваем сначало с первой буквой value[], потом со второй, третей...
        for (int i = 0; i <= (data.length - value.length); i++) {
            for (int j = 0; j < data.length; j++) {
                // если при проходе по всему data[] буква не равна текущей букве value[] то начинаем цикл сначала,
                // до тех пор пока не найдем совпавшие буквы в data[] и value[],
                // тоесть массив data будет перебераться и сравниваться с 1 буквой массива value пока не получиться равенство,
                // затем счетчик j увеличиваеться на 1.
                if (data[i + j] != value[j]) {
                    break;
                }
                // когда указатель массива value дойдет до конца возвращаем true,
                // тоесть когда счетчик j сравняеться с длинной слова sub то цикл возвратить true.
                if (j == value.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
