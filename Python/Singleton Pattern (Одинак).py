class CourseRegistrationSystem:
    instance = None

    @staticmethod
    def get_instance():
        if CourseRegistrationSystem.instance is None:
            CourseRegistrationSystem()
        return CourseRegistrationSystem.instance

    def __init__(self):
        if CourseRegistrationSystem.instance is not None:
            raise Exception("Цей клас є одинаком! Використайте метод get_instance().")
        else:
            CourseRegistrationSystem.instance = self
            self.courses = {}  # Словник для зберігання курсів

    def add_course(self, course_name):
        self.courses[course_name] = []

    def enroll_student(self, course_name, student_name):
        if course_name in self.courses:
            self.courses[course_name].append(student_name)
            print("Студент {} успішно записаний на курс {}.".format(student_name, course_name))
        else:
            print("Курс {} не існує.".format(course_name))

    def display_courses(self):
        for course in self.courses:
            print("Курс {}: {}".format(course, ", ".join(self.courses[course])))


# Приклад використання

# Спроба створення багатьох екземплярів класу CourseRegistrationSystem
try:
    system1 = CourseRegistrationSystem()  # Викличе виняток Exception
except Exception as e:
    print(str(e))

# Отримання єдиного екземпляру класу CourseRegistrationSystem
system = CourseRegistrationSystem.get_instance()

# Додавання курсів
system.add_course("Python Programming")
system.add_course("Web Development")

# Запис студентів на курси
system.enroll_student("Python Programming", "John Doe")
system.enroll_student("Python Programming", "Jane Smith")
system.enroll_student("Web Development", "Alice Johnson")

# Відображення зареєстрованих курсів
system.display_courses()
