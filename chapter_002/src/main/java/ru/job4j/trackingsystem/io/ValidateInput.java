package ru.job4j.trackingsystem.io;

/**
 * Класс выполняет проверку ввода данных пользователем.
 */
public class ValidateInput extends ConsoleInput {
    // метод перекрывает поведение такого же метода из класса ConsoleInput
    // один из способов реализации полиморфизма с помощью наследования, более
    // приемлемый способ реализации полиморфизма в Java это за счет интерфейсов.
    // лучше использовать композицию
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        // нужно постоянно спрашивать у пользователя ввести данные
        // до того пока они не будут корректными
        do {
            try {
                // блок кода который может вызвать ошибку
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Пожайлуста введите значения из диапозона меню.");
            }  catch (NumberFormatException nfe) {
                System.out.println("Пожайлуста введите корректные даные еще раз.");
            }
        } while (invalid);
        return value;
    }
}

