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
     *
     * Сначала происходит вставка первого элемента,
     * если первый элемент имеет больший приоретет то в цикле пройтись по коллекции
     * и вставить элемент туда где его приоритет будет больше элемента коллекции или вставить элеммент в конец
     * если у элемента самый низкий приорет.
     *
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int i = 0;
        if (tasks.size() != 0) {
            if (tasks.getFirst().getPriority() > task.getPriority()) {
                tasks.addFirst(task);
            } else {
                while (tasks.get(i) != tasks.getLast() && tasks.get(i).getPriority() < task.getPriority()) {
                    i++;
                }
                if (tasks.get(i) == tasks.getLast()) {
                    tasks.addLast(task);
                } else {
                    tasks.add(i, task);
                }
            }
        } else {
            tasks.addFirst(task);
        }
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
