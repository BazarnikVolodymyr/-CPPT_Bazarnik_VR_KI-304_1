package KI304.Bazarnik.lab5;

import java.io.*;

/**
 * Клас для обчислення виразу y = tan(x).
 * Використовується для демонстрації механізму виключень і запису результатів у файл.
 * Додано функціонал для роботи з текстовими та двійковими файлами.
 */
public class ExpressionCalculator {

    /**
     * Обчислює вираз y = tan(x).
     *
     * @param x значення змінної x у радіанах
     * @return результат обчислення виразу
     * @throws IllegalArgumentException якщо x = 0, оскільки вираз не визначений
     */
    public double calculate(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("Значення x не може бути 0, оскільки вираз не визначений.");
        }
        return Math.tan(x);
    }

    /**
     * Записує результат обчислення у текстовий файл.
     *
     * @param result результат обчислення типу double
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }

    /**
     * Записує результат обчислення у двійковий файл.
     *
     * @param result результат обчислення типу double
     * @param filePath шлях до двійкового файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToBinaryFile(double result, String filePath) throws IOException {
        // Використання DataOutputStream для запису примітивного типу double у двійковому форматі
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeDouble(result);
        }
    }

    /**
     * Читає результат з текстового файлу.
     *
     * <p>Метод зчитує перший рядок, очищає його від супровідного тексту та перетворює на число double.</p>
     * @param filePath шлях до файлу
     * @return результат обчислення, зчитаний з файлу
     * @throws IOException якщо виникає помилка при читанні файлу
     * @throws NumberFormatException якщо зчитаний рядок не може бути перетворений у число
     */
    public double readResultFromFile(String filePath) throws IOException {
        // Використання BufferedReader для ефективного читання текстових даних
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line == null) {
                // Додано перевірку на порожній файл для кращої обробки помилок
                throw new IOException("Файл порожній.");
            }
            // Регулярний вираз для вилучення лише числового значення
            return Double.parseDouble(line.replaceAll("[^\\d.-]", ""));
        }
    }

    /**
     * Читає результат з двійкового файлу.
     *
     * @param filePath шлях до двійкового файлу
     * @return результат обчислення, зчитаний з файлу
     * @throws IOException якщо виникає помилка при читанні файлу
     */
    public double readResultFromBinaryFile(String filePath) throws IOException {
        // Використання DataInputStream для читання примітивного типу double з двійкового формату
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            return dis.readDouble();
        }
    }
}