from abc import ABC, abstractmethod

class Course(ABC):
    def open_course(self):
        print("Курс відкрито.")

    @abstractmethod
    def close_course(self):
        pass

class CourseA(Course):
    def close_course(self):
        print("Курс A закрито.")

class CourseB(Course):
    def close_course(self):
        print("Курс B закрито.")

class RegistrationSystem:
    def create_course(self, course):
        course.open_course()

    def finalize_course(self, course):
        course.close_course()

# Головна програма
registration_system = RegistrationSystem()

course_a = CourseA()
course_b = CourseB()

registration_system.create_course(course_a)
registration_system.finalize_course(course_a)

registration_system.create_course(course_b)
registration_system.finalize_course(course_b)
