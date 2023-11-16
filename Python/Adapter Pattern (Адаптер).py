# Клас, що представляє інтерфейс для запису на курс
class CourseRegistrationSystem:
    def register_course(self, course_id: int, student_id: int):
        pass

# Клас, який реалізує систему запису на курс і підрахунок кількості зареєстрованих студентів
class CourseRegistrationManager:
    def register(self, course_id: int, student_id: int):
        print(f"Студент {student_id} успішно зареєстрований на курс {course_id}.")

    def count_registered_students(self, course_id: int) -> int:
        return 10  # Повертаємо деяке фіктивне значення

# Адаптер, який забезпечує використання системи запису на курс через інтерфейс CourseRegistrationSystem
class CourseRegistrationAdapter(CourseRegistrationSystem):
    def __init__(self, manager: CourseRegistrationManager):
        self.manager = manager

    def register_course(self, course_id: int, student_id: int):
        self.manager.register(course_id, student_id)

# Головна частина програми
if __name__ == "__main__":
    # Створюємо об'єкт CourseRegistrationManager
    manager = CourseRegistrationManager()

    # Створюємо адаптер і передаємо йому об'єкт CourseRegistrationManager
    adapter = CourseRegistrationAdapter(manager)

    # Використовуємо адаптер для реєстрації студента на курс
    adapter.register_course(1, 42)

    # Використовуємо адаптер для отримання кількості зареєстрованих студентів на курсі
    count = adapter.count_registered_students(1)
    print(f"Кількість зареєстрованих студентів на курсі: {count}")
