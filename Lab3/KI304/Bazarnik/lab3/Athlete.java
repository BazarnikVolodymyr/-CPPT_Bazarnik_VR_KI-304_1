package KI304.Bazarnik.lab3;

import java.io.IOException;

/**
 * Клас {@code Athlete} представляє спортсмена, що розширює клас {@code Human}
 * та реалізує інтерфейс {@code Athletic}.
 * Він зберігає інформацію про тип спорту, команду, кількість медалей та статус активності спортсмена.
 */
public class Athlete extends Human implements Athletic {
    private String sportType;
    private int medalsCount;
    private String team;
    private boolean isActive;

    /**
     * Конструктор для створення об'єкта {@code Athlete}.
     *
     * @param name      Ім'я та прізвище спортсмена.
     * @param address   Адреса спортсмена.
     * @param passport  Паспортні дані спортсмена.
     * @param sportType Вид спорту, яким займається спортсмен.
     * @param team      Команда, до якої належить спортсмен.
     * @throws IOException якщо виникає помилка під час роботи з файлами.
     */
    public Athlete(Name name, Address address, Passport passport,
                   String sportType, String team) throws IOException {
        super(name, address, passport);
        this.sportType = sportType;
        this.team = team;
        this.medalsCount = 0;
        this.isActive = true;
        logger.log(String.format("Створено спортсмена: %s, вид спорту: %s",
                name.getFullName(), sportType));
    }

    /**
     * Тренує спортсмена.
     */
    @Override
    public void train() {
        try {
            logger.log(String.format("Спортсмен %s тренується", name.getFullName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Спортсмен бере участь у змаганнях.
     */
    @Override
    public void compete() {
        try {
            logger.log(String.format("Спортсмен %s бере участь у змаганнях",
                    name.getFullName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Повертає тип спорту, яким займається спортсмен.
     *
     * @return тип спорту спортсмена.
     */
    @Override
    public String getSportType() {
        return sportType;
    }

    /**
     * Повертає кількість медалей спортсмена.
     *
     * @return кількість медалей спортсмена.
     */
    @Override
    public int getMedalsCount() {
        return medalsCount;
    }

    /**
     * Повертає професію спортсмена.
     *
     * @return професія спортсмена.
     */
    @Override
    public String getOccupation() {
        return "Спортсмен";
    }

    /**
     * Повертає спеціалізацію спортсмена.
     *
     * @return спеціалізація спортсмена (тип спорту).
     */
    @Override
    public String getSpecialization() {
        return sportType;
    }

    /**
     * Додає медаль до загальної кількості медалей спортсмена.
     *
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void addMedal() throws IOException {
        this.medalsCount++;
        logger.log(String.format("Спортсмен %s отримав нову медаль. " +
                "Загальна кількість: %d", name.getFullName(), medalsCount));
    }

    /**
     * Змінює статус активності спортсмена.
     *
     * @param active новий статус активності.
     * @throws IOException якщо виникає помилка під час запису в лог.
     */
    public void setActive(boolean active) throws IOException {
        this.isActive = active;
        logger.log(String.format("Статус активності спортсмена %s змінено на: %s",
                name.getFullName(), active ? "активний" : "неактивний"));
    }

    /**
     * Повертає строкове представлення об'єкта {@code Athlete}.
     *
     * @return строка, що представляє спортсмена.
     */
    @Override
    public String toString() {
        return String.format("Спортсмен{ім'я=%s, вид спорту=%s, медалей=%d, команда=%s, активний=%s}",
                name.getFullName(), sportType, medalsCount, team, isActive);
    }
}

