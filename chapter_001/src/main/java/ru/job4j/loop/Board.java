package ru.job4j.loop;

/**
 * Класс строит шахаматную доску.
 *
 * @author Ivan Pavlovets (ivan150287@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * Метод рисует шахмотную доску из символов X и пробелов.
     * Содержит условие проверки, что писать пробел или X.
     *
     * @param width - ширина доски.
     * @param height - высота доски.
     * @return строку изображающую шахматную доску в псевдографике.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }

}
