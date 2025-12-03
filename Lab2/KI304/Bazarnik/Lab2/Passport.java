package KI304.Bazarnik.Lab2;

/**
 * Клас {@code Passport} представляє паспорт з інформацією про його номер, рік видачі та рік народження власника.
 */
public class Passport {
    private String number;
    private int issueYear;
    private int birthYear;

    /**
     * Конструктор для створення екземпляра класу {@code Passport}.
     *
     * @param number Номер паспорта.
     * @param issueYear Рік видачі паспорта.
     * @param birthYear Рік народження власника.
     */
    public Passport(String number, int issueYear, int birthYear) {
        this.number = number;
        this.issueYear = issueYear;
        this.birthYear = birthYear;
    }

    /**
     * Повертає рік видачі паспорта.
     *
     * @return Рік видачі паспорта.
     */
    public int getIssueYear() {
        return issueYear;
    }

    /**
     * Повертає рік народження власника паспорта.
     *
     * @return Рік народження.
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Повертає рядкове представлення паспорта, що містить номер, рік видачі та рік народження.
     *
     * @return Рядок з інформацією про паспорт.
     */
    @Override
    public String toString() {
        return "Номер: " + number + ", Рік видачі: " + issueYear + ", Рік народження: " + birthYear;
    }
}

