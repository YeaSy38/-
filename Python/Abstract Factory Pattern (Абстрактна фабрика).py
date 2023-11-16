from abc import ABC, abstractmethod


# Abstract Product A
class Course(ABC):
    @abstractmethod
    def get_course_name(self):
        pass


# Concrete Product A1
class JavaCourse(Course):
    def get_course_name(self):
        return "Java Course"


# Concrete Product A2
class PythonCourse(Course):
    def get_course_name(self):
        return "Python Course"


# Abstract Product B
class Certificate(ABC):
    @abstractmethod
    def get_certificate_type(self):
        pass


# Concrete Product B1
class JavaCertificate(Certificate):
    def get_certificate_type(self):
        return "Java Certificate"


# Concrete Product B2
class PythonCertificate(Certificate):
    def get_certificate_type(self):
        return "Python Certificate"


# Abstract Factory
class CourseFactory(ABC):
    @abstractmethod
    def create_course(self) -> Course:
        pass

    @abstractmethod
    def create_certificate(self) -> Certificate:
        pass


# Concrete Factory 1
class JavaCourseFactory(CourseFactory):
    def create_course(self) -> Course:
        return JavaCourse()

    def create_certificate(self) -> Certificate:
        return JavaCertificate()


# Concrete Factory 2
class PythonCourseFactory(CourseFactory):
    def create_course(self) -> Course:
        return PythonCourse()

    def create_certificate(self) -> Certificate:
        return PythonCertificate()


# Client
class CourseRegistration:
    def __init__(self, factory: CourseFactory):
        self.course = factory.create_course()
        self.certificate = factory.create_certificate()

    def display_course_details(self):
        print(f"Course: {self.course.get_course_name()}")
        print(f"Certificate: {self.certificate.get_certificate_type()}")


# Usage
if __name__ == '__main__':
    java_factory = JavaCourseFactory()
    java_registration = CourseRegistration(java_factory)
    java_registration.display_course_details()

    python_factory = PythonCourseFactory()
    python_registration = CourseRegistration(python_factory)
    python_registration.display_course_details()
