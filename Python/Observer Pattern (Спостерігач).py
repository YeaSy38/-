class Observer:
    def update(self, data):
        pass


class Course:
    def __init__(self, name):
        self.name = name
        self.observers = []

    def register_observer(self, observer):
        self.observers.append(observer)

    def unregister_observer(self, observer):
        self.observers.remove(observer)

    def notify_observers(self, data):
        for observer in self.observers:
            observer.update(data)

    def start_course(self):
        print(f"Курс '{self.name}' розпочався!")
        self.notify_observers(f"Курс '{self.name}' розпочався!")


class Student(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, data):
        print(f"Студент '{self.name}': Отримано повідомлення - {data}")


# Створення курсу
course = Course("Python підвищення кваліфікації")

# Створення студентів
student1 = Student("John")
student2 = Student("Alice")

# Реєстрація студентів на курс
course.register_observer(student1)
course.register_observer(student2)

# Запуск курсу
course.start_course()

# Вихід студента2 із курсу
course.unregister_observer(student2)

# Знову запускаємо курс
course.start_course()
