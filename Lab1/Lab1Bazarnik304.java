import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab1Bazarnik304 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter the matrix size: ");
        int row = sc.nextInt();

        
        System.out.println("Enter the fill symbol: ");
        String symbol = sc.next();

        
        if(symbol.length() != 1){
            System.out.println("Please enter a correct fill symbol (one character)");
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";

        
        try {
            printMatrix(arr, symbol, row, fileName);
        }catch (IOException e){
            
            throw new RuntimeException("An error occurred while writing to the file: " + e.getMessage());
        }
    }

        public static void printMatrix(String[][] arr, String symbol, int row, String file) throws IOException {
        System.out.println("Matrix result: ");

        try(FileWriter writer = new FileWriter(file)) {
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = symbol;
                    
                    writer.write(arr[i][j] + " ");
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
                writer.write("\n");
            }

            writer.flush();
        }
    }

    
    public static String[][] createLengthOfEachSubArr(int row){
        String[][] arr = new String[row][];

        for (int i = 0; i < row; i++) {
            int length = 0;

            for (int j = 0; j <= i; j++) {
                length++;
            }

            arr[i] = new String[length];
        }

        return arr;
    }
}
