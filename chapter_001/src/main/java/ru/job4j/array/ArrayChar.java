package ru.job4j.array;

/**
 * Обертка над строкой.
 * Массив символов инициализируемый в конструкторе.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    public ArrayChar() {
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * Сравнивает символы в value и data.
     * Если неравенство верно то флаг меняеться на false.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] != data[i]) {
                return false;
            }
        }
        return result;
    }

    /**
     * Проверяет что слово String находится в другом слове String.
     * Принимаемые строки origin и sub формируют массивы символов data и value соответсвено.
     * В циклах поочереди каждую букву data[] сравниваем сначало с первой буквой value[],
     * потом со второй, третей... Если при проходе по всему data[] буква не равна
     * текущей букве value[] то начинаем цикл сначала, до тех пор пока не найдем
     * совпавшие буквы в data[] и value[], тоесть массив data будет перебераться
     * и сравниваться с 1 буквой массива value пока не получиться равенство,
     * затем счетчик j увеличиваеться на 1. Когда указатель массива value дойдет
     * до конца возвращаем true, тоесть когда счетчик j сравняеться с длинной слова sub
     * то цикл возвратить true.
     *
     * @param origin - целое слово.
     * @param sub - часть слова котороя может находиться в слове origin.
     * @return - true если часть слова действительно находиться в целом слове.
     */
    public boolean contains(String origin, String sub) {
        this.data = origin.toCharArray();
        char[] value = sub.toCharArray();
        for (int i = 0; i <= (data.length - value.length); i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i + j] != value[j]) {
                    break;
                }
                if (j == value.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
