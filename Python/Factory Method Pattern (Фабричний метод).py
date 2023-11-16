from abc import ABC, abstractmethod

class Course(ABC):
    @abstractmethod
    def get_course_details(self):
        pass

class PythonCourse(Course):
    def get_course_details(self):
        return "Python Course"

class JavaCourse(Course):
    def get_course_details(self):
        return "Java Course"

class CourseFactory(ABC):
    @abstractmethod
    def create_course(self):
        pass

class PythonCourseFactory(CourseFactory):
    def create_course(self):
        return PythonCourse()

class JavaCourseFactory(CourseFactory):
    def create_course(self):
        return JavaCourse()

def main():
    python_factory = PythonCourseFactory()
    python_course = python_factory.create_course()
    print(python_course.get_course_details())

    java_factory = JavaCourseFactory()
    java_course = java_factory.create_course()
    print(java_course.get_course_details())

if __name__ == '__main__':
    main()
