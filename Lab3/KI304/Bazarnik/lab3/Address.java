package KI304.Bazarnik.lab3;

/**
 * Клас {@code Address} представляє адресу, яка складається з міста, вулиці та номера будинку.
 *
 * Містить методи для отримання повної адреси та її форматування.
 */
public class Address {
    private String city;
    private String street;
    private String houseNumber;

    /**
     * Конструктор для створення екземпляра класу {@code Address}.
     *
     * @param city Місто.
     * @param street Вулиця.
     * @param houseNumber Номер будинку.
     */
    public Address(String city, String street, String houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    /**
     * Метод для отримання повної адреси у форматі "Місто, Вулиця, Номер будинку".
     *
     * @return Повна адреса у вигляді рядка.
     */
    public String getFullAddress(){
        return String.format("%s, %s, %s", city, street, houseNumber);
    }

    /**
     * Метод для перетворення об'єкта {@code Address} у рядок, що представляє адресу.
     *
     * @return Рядок, що представляє адресу людини.
     */
    @Override
    public String toString() {
        return "Адреса{" +
                "місто='" + city + '\'' +
                ", вулиця='" + street + '\'' +
                ", номер будинку='" + houseNumber + '\'' +
                '}';
    }
}
