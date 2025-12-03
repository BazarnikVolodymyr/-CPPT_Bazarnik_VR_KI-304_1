package Lab6.KI304.Bazarnik.lab6;

/**
 * Клас, що представляє книгу
 */
class Book implements Valuable {
    private String title;
    private String author;
    private int price;

    /**
     * Конструктор, що ініціалізує назву, автора та ціну книги
     * @param title назва книги
     * @param author автор книги
     * @param price ціна книги
     */
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Повертає ціну книги
     * @return ціна книги
     */
    @Override
    public int getValue() {
        return price;
    }

    /**
     * Повертає рядкове представлення книги
     * @return інформація про книгу у вигляді рядка
     */
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', price=" + price + "}";
    }
}
