package KI304.Bazarnik.Lab2;

import java.io.IOException;

/**
 * Клас {@code HumanDriver} демонструє використання класу {@code Human}.
 */
public class HumanDriver {
    /**
     * Головний метод, що виконує демонстрацію функціоналу класу {@code Human}.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            // 1. Створюємо об'єкт з дефолтними даними (для чистоти тестування)
            Human person = new Human(); 
            
            // 2. Демонстрація методів зміни даних (Перезапис на Олега Пелеха)
            person.changeName(new Name("Олег", "Пелех"));
            person.changeAddress(new Address("Львів", "Садова", "6"));
            person.updatePassport(new Passport("AA156567", 2020, 1999));
            
            // 3. Демонстрація методів отримання даних та логіки (Без дублювання)
            person.getFullName();
        
            // isAdult() викличе getAge() і надрукує вік один раз
            person.isAdult(); 
            
            person.getFullAddress();
            person.needToUpdatePassport();
            
            // getInfo() виведе повну інформацію (і повторно викличе методи-гетери)
            person.getInfo();
            
            person.isPensioner();

        }catch (IOException e){
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}