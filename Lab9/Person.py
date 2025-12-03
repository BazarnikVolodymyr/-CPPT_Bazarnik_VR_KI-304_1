class Person:
    """
    Клас Person представляє людину з базовими характеристиками та функціями.
    """

    def __init__(self, name, age, weight):
        """
        Ініціалізує об'єкт людини.

        :param name: Ім'я людини
        :param age: Вік людини
        :param weight: Вага людини в кілограмах
        """
        self.name = name
        self.age = age
        self.weight = weight
        self.max_energy = 100  # максимальний рівень енергії
        self.current_energy = self.max_energy  # поточний рівень енергії
        self.is_active = False  # статус активності

    def do_activity(self):
        """
        Починає фізичну активність, якщо є достатньо енергії.

        :return: True, якщо активність можлива, False - якщо недостатньо енергії
        """
        if self.current_energy > self.max_energy * 0.2:  # потрібно мінімум 20% енергії
            print(f"{self.name} починає активність!")
            self.is_active = True
            self.current_energy -= self.max_energy * 0.2  # витрачається 20% енергії
            return True
        else:
            print(f"{self.name} не має достатньо енергії для активності")
            return False

    def rest(self):
        """
        Відпочиває, якщо була активність.

        :return: True, якщо відпочинок почався, False - якщо людина вже відпочиває
        """
        if self.is_active:
            print(f"{self.name} відпочиває")
            self.is_active = False
            return True
        return False

    def restore_energy(self):
        """
        Відновлює енергію до максимального рівня.
        """
        self.current_energy = self.max_energy
        print(f"{self.name} відновив(ла) енергію")

    def get_status(self):
        """
        Отримує поточний статус людини.

        :return: Рядок із статусом активності та рівнем енергії
        """
        status = "активний(а)" if self.is_active else "відпочиває"
        return f"{self.name}: {status}, енергія: {self.current_energy}/{self.max_energy}"
