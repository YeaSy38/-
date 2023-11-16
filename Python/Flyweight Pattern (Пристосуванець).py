from abc import ABC, abstractmethod

class Course(ABC):
    @abstractmethod
    def get_course_name(self):
        pass

    @abstractmethod
    def enroll_student(self, student):
        pass

    @abstractmethod
    def get_enrolled_students(self):
        pass

class CourseImplementation(Course):
    def __init__(self, course_name):
        self.course_name = course_name
        self.enrolled_students = set()

    def get_course_name(self):
        return self.course_name

    def enroll_student(self, student):
        self.enrolled_students.add(student)

    def get_enrolled_students(self):
        return self.enrolled_students

class CourseFactory:
    courses = {}

    @staticmethod
    def get_course(course_name):
        if course_name not in CourseFactory.courses:
            CourseFactory.courses[course_name] = CourseImplementation(course_name)
        return CourseFactory.courses[course_name]

class Student:
    def __init__(self, student_name):
        self.student_name = student_name

    def enroll_in_course(self, course_name):
        course = CourseFactory.get_course(course_name)
        course.enroll_student(self)

    def get_enrolled_courses(self):
        enrolled_courses = []

        for course_name, course in CourseFactory.courses.items():
            if self in course.get_enrolled_students():
                enrolled_courses.append(course_name)

        return enrolled_courses

# Usage
student1 = Student("John")
student1.enroll_in_course("Math")
student1.enroll_in_course("Physics")

student2 = Student("Alice")
student2.enroll_in_course("Math")

print("Courses enrolled by student1:", student1.get_enrolled_courses())
print("Courses enrolled by student2:", student2.get_enrolled_courses())
