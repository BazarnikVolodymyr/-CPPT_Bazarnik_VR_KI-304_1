from Athlete import Athlete

if __name__ == "__main__":
    # Створюємо спортсмена
    athlete = Athlete("Олександр", 25, 75, "Біг", 10)

    # Виводимо початковий стан
    print("\n1. Початковий стан:")
    print(athlete.get_status())

    # Спробуємо тренуватися - має вийти
    print("\n2. Перше тренування:")
    athlete.train()
    print(athlete.get_status())

    # Відпочиваємо
    print("\n3. Відпочинок:")
    athlete.rest()
    print(athlete.get_status())

    # Беремо участь у змаганні
    print("\n4. Участь у змаганні:")
    athlete.compete()
    print(athlete.get_status())

    # Робимо ще два тренування, щоб викликати необхідність медогляду
    print("\n5. Ще два тренування підряд:")
    athlete.train()
    athlete.rest()
    athlete.train()
    athlete.rest()
    print(athlete.get_status())

    # Спробуємо тренуватися без медогляду
    print("\n6. Спроба тренування без медогляду:")
    athlete.train()

    # Проходимо медогляд
    print("\n7. Проходження медогляду:")
    athlete.medical_checkup()
    print(athlete.get_status())

    # Відновлюємо енергію
    print("\n8. Відновлення енергії:")
    athlete.restore_energy()
    print(athlete.get_status())

    # Беремо участь у ще двох змаганнях
    print("\n9. Ще два змагання:")
    athlete.compete()
    athlete.rest()
    athlete.compete()  # Третє змагання
    athlete.rest()
    print(athlete.get_status())

    # Спробуємо взяти участь у змаганні після досягнення ліміту
    print("\n10. Спроба участі в змаганні після досягнення річного ліміту:")
    athlete.compete()

    # Перевіряємо фінальний стан
    print("\n11. Фінальний стан спортсмена:")
    print(athlete.get_status())

    # Демонструємо всі атрибути об'єкта
    print("\n12. Всі атрибути спортсмена:")
    print(f"Ім'я: {athlete.name}")
    print(f"Вік: {athlete.age} років")
    print(f"Вага: {athlete.weight} кг")
    print(f"Вид спорту: {athlete.sport}")
    print(f"Рівень енергії: {athlete.current_energy}/{athlete.max_energy}")
    print(f"Максимум змагань на рік: {athlete.max_competitions}")
    print(f"Взято участь у змаганнях: {athlete.competitions_participated}")
    print(f"Потребує медогляду: {athlete.needs_medical_check}")
    print(f"Тренується/змагається: {athlete.is_active}")
