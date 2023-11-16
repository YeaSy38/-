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
        print(f"���� '{self.name}' ����������!")
        self.notify_observers(f"���� '{self.name}' ����������!")


class Student(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, data):
        print(f"������� '{self.name}': �������� ����������� - {data}")


# ��������� �����
course = Course("Python ��������� �����������")

# ��������� ��������
student1 = Student("John")
student2 = Student("Alice")

# ��������� �������� �� ����
course.register_observer(student1)
course.register_observer(student2)

# ������ �����
course.start_course()

# ����� ��������2 �� �����
course.unregister_observer(student2)

# ����� ��������� ����
course.start_course()
