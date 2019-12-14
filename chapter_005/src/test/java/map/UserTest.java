package map;

import org.junit.Test;
import ru.job4j.collectionsPro.map.User;

import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void whenCreateTwoDublicatsWithoutOverrideHashcode() {
        User user1 = new User("Ivan", 0, 15, 02, 1987);
        User user2 = new User("Ivan", 0, 15, 02, 1987);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        /**
         * В коллекции map оьбекты храняться в соответсвии со своим вычисленым значением в hashCode()
         * Когда метод hashCode() не переопределен, обьектам просто присваеться адресс из памяти (В куче).
         * Соответсвенно две разные области памяти два разных обьекта.
         */
        System.out.println(map);
    }
}
