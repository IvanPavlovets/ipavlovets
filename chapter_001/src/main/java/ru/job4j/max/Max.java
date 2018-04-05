package ru.job4j.max;

/**
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {

    /**
     * Возвращает максимальное значение из двух целых аргументов.
     * @param first, second - первый и второй аргументы.
     * @return большее значение.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Возвращает максимальное значение из трех целых аргументов.
     * @param first, second, third - первый, второй и третий аргументы.
     * @return большее значение.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }

}
