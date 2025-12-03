package KI304.Bazarnik.Lab2;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Клас {@code Human} представляє людину з ім'ям, адресою та паспортом.
 * Містить методи для зміни особистих даних, перевірки віку та повноліття,
 * а також для ведення журналу дій.
 */
public class Human {
    private Name name;
    private Address address;
    private Passport passport;
    private Logger logger;

    /**
     * Конструктор без параметрів. Створює людину з дефолтними даними.
     * Ініціалізує логер для запису дій до файлу.
     *
     * @throws IOException якщо виникає помилка під час роботи з файлом.
     */
    public Human() throws IOException {
        this(new Name("Ім'я", "Прізвище"),
                new Address("Місто", "Вулиця", "Номер будинку"),
                new Passport("jrkw3r32", 99999, 99999)
        );
        this.logger = new Logger("human_log.txt");
        logger.log(String.format("Людина %s сторено.", this.toString()));
    }

    /**
     * Конструктор, який дозволяє задати всі дані про людину.
     * Ініціалізує логер для запису дій до файлу.
     *
     * @param name Ім'я та прізвище людини
     * @param address Адреса людини
     * @param passport Паспорт людини
     * @throws IOException якщо виникає помилка під час роботи з файлом.
     */
    public Human(Name name, Address address, Passport passport) throws IOException {
        this.name = name;
        this.address = address;
        this.passport = passport;
        this.logger = new Logger("human_log.txt");
        logger.log(String.format("%s сторено.", this.toString()));
    }

    /**
     * Метод для зміни імені.
     *
     * @param newName Нове ім'я
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public void changeName(Name newName) throws IOException {
        this.name = newName;

        logger.log("Змінено ім'я на " + newName);
        System.out.println("Змінено ім'я на " + newName);
    }

    /**
     * Метод для зміни адреси.
     *
     * @param newAddress Нова адреса
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public void changeAddress(Address newAddress) throws IOException{
        this.address = newAddress;

        logger.log("Змінено адресу на " + newAddress);
        System.out.println("Змінено адресу на " + newAddress);
    }

    /**
     * Метод для оновлення паспорта.
     *
     * @param newPassport Новий паспорт
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public void updatePassport(Passport newPassport) throws IOException{
        this.passport = newPassport;

        logger.log("Оновлено паспорт: " + newPassport);
        System.out.println("Оновлено паспорт: " + newPassport);
    }

    /**
     * Метод для отримання повного імені.
     *
     * @return Повне ім'я
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public String getFullName() throws IOException{
        String fullName = name.getFullName();

        logger.log("Получити ім'я та прізвище: " + fullName);
        System.out.println("Получити ім'я та прізвище: " + fullName);
        return fullName;
    }

    /**
     * Метод для отримання віку людини на основі року народження в паспорті.
     *
     * @return Вік людини
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public int getAge() throws IOException{
        int age = LocalDate.now().getYear() - passport.getBirthYear();

        logger.log("Получити вік: " + age);
        System.out.println("Получити вік: " + age);
        return age;
    }

    /**
     * Метод для перевірки повноліття.
     *
     * @return true, якщо людина повнолітня, інакше false
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public boolean isAdult() throws IOException{
        boolean isAdult = getAge() >= 18;

        logger.log("Чи людина доросла: " + isAdult);
        System.out.println("Чи людина доросла: " + isAdult);
        return isAdult;
    }

    /**
     * Метод для отримання повної адреси людини.
     *
     * @return Повна адреса
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public String getFullAddress() throws IOException{
        String fullAddress = address.getFullAddress();

        logger.log("Повна адреса: " + fullAddress);
        System.out.println("Повна адреса: " + fullAddress);
        return fullAddress;
    }

    /**
     * Метод для перевірки, чи потрібно оновити паспорт.
     *
     * @return true, якщо паспорт потрібно оновити, інакше false
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public boolean needToUpdatePassport() throws IOException{
        boolean shouldUpdate = LocalDate.now().getYear() - passport.getIssueYear() >= 10;

        logger.log("Чи потрібно оновити паспорт: " + shouldUpdate);
        System.out.println("Чи потрібно оновити паспорт: " + shouldUpdate);
        return shouldUpdate;
    }

    /**
     * Метод для отримання інформації про людину.
     *
     * @return Рядок з інформацією про людину
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public String getInfo() throws IOException {
        String info = String.format("Ім'я: %s, Вік: %s, Адреса: %s", getFullName(), getAge(), getFullAddress());

        logger.log("Інформація про людину: " + info);
        System.out.println("Інформація про людину: " + info);
        return info;
    }

    /**
     * Метод для перевірки, чи є людина пенсіонером.
     *
     * @return true, якщо людина досягла пенсійного віку, інакше false
     * @throws IOException якщо виникає помилка під час запису в лог-файл.
     */
    public boolean isPensioner() throws IOException {
        boolean isPensioner = getAge() >= 60;

        logger.log("Перевірка на пенсійний вік: " + isPensioner);
        System.out.println("Перевірка на пенсійний вік: " + isPensioner);
        return isPensioner;
    }

    /**
     * Метод для коректного закриття логера.
     *
     * @throws IOException якщо виникає помилка під час закриття лог-файлу.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }

    @Override
    public String toString() {
        return "Людина{" +
                "ініціали=" + name +
                ", адреса=" + address +
                ", паспорт=" + passport + '}';
    }
}
 