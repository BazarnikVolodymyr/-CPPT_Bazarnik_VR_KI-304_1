import math
import struct

# Функція для обчислення y = tan(x)
def calculate_tan(x):
    """Обчислює тангенс заданого значення x."""
    try:
        # Використовуємо функцію тангенса з модуля math
        return math.tan(x)
    except ValueError as e:
        # Обробка можливих помилок, наприклад, якщо x занадто велике
        raise ValueError(f"Помилка обчислення тангенса: {e}")

# Функція для запису результатів у текстовий файл
def write_to_text_file(filename, data):
    """Записує дані у текстовий файл."""
    # Відкриваємо файл для запису ('w') з кодуванням UTF-8
    with open(filename, "w", encoding="utf-8") as file:
        # data – це список кортежів (x, y)
        for x, y in data:
            # Записуємо кожну пару x, y у форматі рядка з переходом на новий рядок (\n)
            file.write(f"x: {x}, y: {y}\n")

# Функція для читання даних із текстового файлу
def read_from_text_file(filename):
    """Зчитує дані з текстового файлу."""
    # Відкриваємо файл для читання ('r')
    with open(filename, "r", encoding="utf-8") as file:
        # Зчитуємо всі рядки у список
        return file.readlines()

# Функція для запису результатів у двійковий файл
def write_to_binary_file(filename, data):
    """Записує дані у двійковий файл."""
    # Відкриваємо файл для запису у двійковому режимі ('wb')
    with open(filename, "wb") as file:
        for x, y in data:
            # Записуємо як два числа з плаваючою крапкою
            # 'ff' означає два 4-байтових числа float
            file.write(struct.pack("ff", x, y))

# Функція для читання даних із двійкового файлу
def read_from_binary_file(filename):
    """Зчитує дані з двійкового файлу."""
    results = []
    # Відкриваємо файл для читання у двійковому режимі ('rb')
    with open(filename, "rb") as file:
        # Зчитуємо по 8 байт (розмір двох float: 4 байти + 4 байти)
        # Оператор := (морж) використовується для присвоєння та перевірки в одному рядку
        while chunk := file.read(8):
            # 'ff' - розпаковуємо 8 байт назад у два числа float
            x, y = struct.unpack("ff", chunk)
            results.append((x, y))
    return results
