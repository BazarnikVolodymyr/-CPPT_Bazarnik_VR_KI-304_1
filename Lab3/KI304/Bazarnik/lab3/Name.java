package KI304.Bazarnik.lab3;

/**
 * Клас {@code Name} представляє ім'я та прізвище людини.
 *
 * Містить методи для отримання повного імені та форматування ініціалів.
 */
public class Name {
    private String firstName;
    private String lastName;

    /**
     * Конструктор для створення екземпляра класу {@code Name}.
     *
     * @param firstName Ім'я людини.
     * @param lastName Прізвище людини.
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Метод для отримання повного імені у форматі "Ім'я Прізвище".
     *
     * @return Повне ім'я у вигляді рядка.
     */
    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }

    /**
     * Метод для перетворення об'єкта {@code Name} у рядок, що містить ініціали.
     *
     * @return Рядок, що представляє ініціали людини.
     */
    @Override
    public String toString() {
        return "Ініціали{" +
                "Ім'я='" + firstName + '\'' +
                ", Прізвище='" + lastName + '\'' +
                '}';
    }
}


