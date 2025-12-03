package Lab6.KI304.Bazarnik.lab6;

/**
 * Клас для демонстрації роботи з контейнером об'єктів
 */
public class ArrayDriver {
    /**
     * Головний метод для запуску програми
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створюємо один контейнер для всіх об'єктів
        Array<Valuable> container = new Array<>();

        // Додаємо студентів
        container.add(new Student("John", 20));
        container.add(new Student("Alice", 22));
        container.add(new Student("Bob", 19));

        // Додаємо книги
        container.add(new Book("Java Programming", "James Gosling", 30));
        container.add(new Book("Clean Code", "Robert Martin", 40));
        container.add(new Book("Design Patterns", "Gang of Four", 35));

        // Виводимо розмір контейнера
        System.out.println("Розмір контейнера: " + container.size());

        // Виводимо всі елементи
        System.out.println("\nВсі об'єкти в контейнері:");
        for (int i = 0; i < container.size(); i++) {
            System.out.println(container.get(i));
        }

        // Знаходимо об'єкт з максимальним значенням
        System.out.println("\nОб'єкт з максимальним значенням: " + container.findMax());

        // Видаляємо елемент
        container.remove(1);
        System.out.println("\nРозмір контейнера після видалення: " + container.size());

        // Виводимо всі елементи після видалення
        System.out.println("\nВсі об'єкти після видалення:");
        for (int i = 0; i < container.size(); i++) {
            System.out.println(container.get(i));
        }
    }
}
