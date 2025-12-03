package Lab6.KI304.Bazarnik.lab6;

/**
 * Параметризований клас для роботи з масивом об'єктів
 * @param <T> тип елементів масиву
 */
public class Array<T> {
    private T[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор за замовчуванням
     */
    @SuppressWarnings("unchecked")
    public Array() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Додає елемент в масив
     * @param element елемент для додавання
     */
    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    /**
     * Видаляє елемент за індексом
     * @param index індекс для видалення
     * @return видалений елемент
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    /**
     * Знаходить максимальний елемент
     * @return максимальний елемент
     */
    public T findMax() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        T max = elements[0];
        for (int i = 1; i < size; i++) {
            if (((Valuable)elements[i]).getValue() > ((Valuable)max).getValue()) {
                max = elements[i];
            }
        }
        return max;
    }

    /**
     * Повертає елемент за індексом
     * @param index індекс елемента
     * @return елемент за вказаним індексом
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    /**
     * Повертає розмір масиву
     * @return кількість елементів
     */
    public int size() {
        return size;
    }

    /**
     * Збільшує розмір масиву
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}


