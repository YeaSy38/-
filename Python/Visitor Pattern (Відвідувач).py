from abc import ABC, abstractmethod


# Visitor interface
class CourseVisitor(ABC):
    @abstractmethod
    def visit(self, course):
        pass


# Concrete visitor - AttendanceRecorder
class AttendanceRecorder(CourseVisitor):
    def visit(self, course):
        print(f"Recording attendance for {course.name}")


# Course interface
class Course(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass


# Concrete course - TrainingCourse
class TrainingCourse(Course):
    def __init__(self, name):
        self.name = name

    def accept(self, visitor):
        visitor.visit(self)


# Concrete course - Workshop
class Workshop(Course):
    def __init__(self, name):
        self.name = name

    def accept(self, visitor):
        visitor.visit(self)


# Client code
if __name__ == "__main__":
    courses = [TrainingCourse("Python Programming"), Workshop("Data Visualization")]

    attendance_recorder = AttendanceRecorder()

    for course in courses:
        course.accept(attendance_recorder)
