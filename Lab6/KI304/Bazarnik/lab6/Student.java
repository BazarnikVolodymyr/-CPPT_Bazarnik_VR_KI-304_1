package Lab6.KI304.Bazarnik.lab6;

/**
 * Клас, що представляє студента
 */
class Student implements Valuable {
    private String name;
    private int age;

    /**
     * Конструктор, що ініціалізує ім'я та вік студента
     * @param name ім'я студента
     * @param age вік студента
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Повертає вік студента
     * @return вік студента
     */
    @Override
    public int getValue() {
        return age;
    }

    /**
     * Повертає рядкове представлення студента
     * @return інформація про студента у вигляді рядка
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

