from Person import Person


class Athlete(Person):
    """
    Клас Athlete розширює функціональність базового класу Person,
    додаючи специфічні для спортсмена характеристики та можливості.
    """

    def __init__(self, name, age, weight, sport, max_competitions):
        """
        Ініціалізує об'єкт спортсмена.

        :param name: Ім'я спортсмена
        :param age: Вік спортсмена
        :param weight: Вага спортсмена в кілограмах
        :param sport: Вид спорту
        :param max_competitions: Максимальна кількість змагань на рік
        """
        super().__init__(name, age, weight)
        self.sport = sport
        self.max_competitions = max_competitions
        self.competitions_participated = 0
        self.needs_medical_check = False

    def train(self):
        """
        Починає тренування, враховуючи стан здоров'я та рівень енергії.

        :return: True, якщо тренування почалося, False - якщо тренування неможливе
        """
        if self.needs_medical_check:
            print(f"{self.name} потребує медичного огляду перед тренуванням")
            return False

        training_successful = super().do_activity()
        if training_successful:
            print(f"{self.name} тренується у {self.sport}")
            if self.competitions_participated % 3 == 0 and self.competitions_participated > 0:
                self.needs_medical_check = True
        return training_successful

    def compete(self):
        """
        Бере участь у змаганні, якщо дозволяє стан здоров'я та не перевищено річний ліміт.

        :return: True, якщо участь у змаганні можлива, False - якщо ні
        """
        if self.needs_medical_check:
            print(f"{self.name} потребує медичного огляду перед змаганням")
            return False
        if self.competitions_participated >= self.max_competitions:
            print(f"{self.name} досяг(ла) ліміту змагань на рік")
            return False

        competition_successful = super().do_activity()
        if competition_successful:
            self.competitions_participated += 1
            print(f"{self.name} бере участь у змаганні з {self.sport}")
            if self.competitions_participated % 3 == 0:
                self.needs_medical_check = True
        return competition_successful

    def medical_checkup(self):
        """
        Проходить медичний огляд.
        """
        self.needs_medical_check = False
        print(f"{self.name} пройшов(ла) медичний огляд")

    def get_status(self):
        """
        Отримує поточний статус спортсмена.

        :return: Рядок із загальним статусом, кількістю змагань та станом здоров'я
        """
        basic_status = super().get_status()
        medical_status = "потребує медогляду" if self.needs_medical_check else "здоровий(а)"
        return f"{basic_status}, змагань: {self.competitions_participated}/{self.max_competitions}, стан: {medical_status}"
