package ru.job4j.collections.queue;

import java.util.LinkedList;

public class PriorityQueue {
    /**
     * Список задач.
     */
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * <p>
     * Сначала происходит вставка первого элемента,
     * если первый элемент имеет больший приоретет то в цикле пройтись по коллекции
     * и вставить элемент туда где его приоритет будет больше элемента коллекции или вставить элеммент в конец
     * если у элемента самый низкий приорет.
     * <p>
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        var i = 0;
        while (!tasks.isEmpty() && tasks.get(i) != tasks.getLast() && tasks.get(i).getPriority() < task.getPriority()) {
            i++;
        }
        if (!tasks.isEmpty() && tasks.get(i).getPriority() < task.getPriority()) {
            i++;
        }
        tasks.add(i, task);
    }

    /**
     * Возвращает элемент из головы списка tasks и удаляет его.
     *
     * @return - элемент из головы очереди.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
