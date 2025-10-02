def lengthOfEachSubArray(size):
    arr = [None] * size

    for i in range(size):
        length = i + 1
        arr[i] = [""] * length

    return arr

def printMatrix(arr, symbol, size, file):
    print("Результат матриці")

    with open(file, "w", encoding="utf-8") as writer:
        for i in range(size):
            for j in range(i + 1):
                arr[i][j] = symbol

                writer.write(arr[i][j] + " ")
                print(arr[i][j], end=" ")
            print()
            writer.write("\n")
        writer.flush()

if __name__ == '__main__':
    size = int(input("Введіть розмір матриці: "))
    symbol = input("Введіть символ заповнювач: ")

    if len(symbol) != 1:
        print("Введіть коректний символ заповнювач")
    else:
        arr = lengthOfEachSubArray(size)
        file_name = "matrix_output.txt"
        printMatrix(arr, symbol, size, file_name)