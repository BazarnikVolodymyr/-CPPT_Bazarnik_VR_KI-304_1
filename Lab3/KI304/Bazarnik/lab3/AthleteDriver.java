package KI304.Bazarnik.lab3;

import java.io.IOException;

/**
 * Клас {@code HumanDriver} демонструє використання класу {@code Human}.
 */
public class AthleteDriver {
    /**
     * Головний метод, що виконує демонстрацію функціоналу класу {@code Human}.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            Athlete athlete = new Athlete(
                    new Name("Олександр", "Усик"),
                    new Address("Київ", "Залізнична", "5"),
                    new Passport("BB864675", 2022, 1987),
                    "Бокс",
                    "Team Usyk"
            );

            athlete.train();
            athlete.compete();
            athlete.addMedal();
            System.out.println("Тип спорту: " + athlete.getSportType());
            System.out.println("Професія: " + athlete.getOccupation());
            System.out.println(athlete.getInfo());
            System.out.println("Спеціалізація: " + athlete.getSpecialization());
            System.out.println("Кількість медалей: " + athlete.getMedalsCount());
        }catch (IOException e){
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
