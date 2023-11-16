class Course:
    def __init__(self, name):
        self.name = name
        self.students = []

    def add_student(self, student):
        self.students.append(student)

    def notify_students(self, message):
        print(f"Course '{self.name}': {message}")
        for student in self.students:
            student.receive_message(message)


class Student:
    def __init__(self, name, course):
        self.name = name
        self.course = course

    def enroll(self):
        self.course.add_student(self)
        self.course.notify_students(f"Student '{self.name}' has enrolled in the course.")

    def receive_message(self, message):
        print(f"Student '{self.name}' received message: {message}")


if __name__ == "__main__":
    course = Course("Python Programming")
    
    student1 = Student("John", course)
    student2 = Student("Alice", course)
    
    student1.enroll()
    student2.enroll()
