import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Клас Lab1Bazarnik304 реалізує лабораторну роботу №1
 * */
public class Lab1Bazarnik304 {
    
   /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args аргументи
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Ввід розміру матриці
        System.out.println("Введіть розмір матриці: ");
        int row = sc.nextInt();

        // Ввід основного символа 
        System.out.println("Введіть основний символ заповнювач: ");
        String symbol = sc.next();
        
        
        System.out.println("Введіть інший символ символ заповнювач: ");
        String anotherSymbol = sc.next();


        // Перевірка на валідність символів заповнювачів
        if(symbol.length() != 1 || anotherSymbol.length() != 1){
            System.out.println("Введіть коректний символ заповнювач (один символ)");
            sc.close();
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";
        sc.close();

        // Запуск бізнес логіки
        try {
            printMatrix(arr, symbol, anotherSymbol, row, fileName);
        }catch (IOException e){
            // Обробка помилки під час запису в файл
            throw new RuntimeException("Сталася помилка під час запису в файл: " + e.getMessage());
        }
    }

    /**
     * Метод який генерує зубчастий масив з чергуванням символів
     *
     * @param arr масив для заповнення
     * @param mainSymbol символ для непарних рядків (1-й, 3-й, ...)
     * @param altSymbol символ для парних рядків (2-й, 4-й, ...)
     * @param row розмір масиву
     * @param file назва файлу
     * @throws IOException якщо столась якась помилка при запису в файл
     * */
    public static void printMatrix(String[][] arr, String mainSymbol, String altSymbol, int row, String file) throws IOException {
        System.out.println("Результат матриці: ");

        try(FileWriter writer = new FileWriter(file)) {
            
            for (int i = 0; i < row; i++) {
                
                // Визначення символа: i + 1 – це номер рядка (1, 2, 3...)
                // Перевіряємо парність номера рядка: (i + 1) % 2 == 0
                String currentSymbol;
                
                // Якщо i+1 (номер рядка) парний, використовуємо altSymbol
                if ((i + 1) % 2 == 0) {
                    currentSymbol = altSymbol; 
                } else {
                    // Якщо i+1 (номер рядка) непарний, використовуємо mainSymbol
                    currentSymbol = mainSymbol;
                }
                
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = currentSymbol;

                    // Вивід в консоль і запис в файл
                    writer.write(arr[i][j] + " ");
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
                writer.write("\n");
            }

            writer.flush();
        }
    }

    /**
     * Метод який знаходить для кожного під масива довжину (як у "зубчастому" масиві трикутної форми)
     *
     * @param row розмір масива
     * @return String[][]
     * */
    public static String[][] createLengthOfEachSubArr(int row){
        String[][] arr = new String[row][];

        for (int i = 0; i < row; i++) {
            // Довжина i-го підмасиву дорівнює i + 1
            arr[i] = new String[i + 1];
        }

        return arr;
        
    }
    
}