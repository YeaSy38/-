# Abstract class for the Course
class Course:

    def __init__(self, course_name):
        self.course_name = course_name

    def enroll_course(self):
        pass

    def complete_course(self):
        pass


class OnlineCourse(Course):

    def enroll_course(self):
        print(f"Enrolling for online course: {self.course_name}")

    def complete_course(self):
        print(f"Completing online course: {self.course_name}")


class OfflineCourse(Course):

    def enroll_course(self):
        print(f"Enrolling for offline course: {self.course_name}")

    def complete_course(self):
        print(f"Completing offline course: {self.course_name}")


class User:

    def __init__(self, name, course):
        self.name = name
        self.course = course

    def enroll_course(self):
        self.course.enroll_course()

    def complete_course(self):
        self.course.complete_course()


if __name__ == '__main__':
    online_course = OnlineCourse("Python Programming")
    offline_course = OfflineCourse("Data Analysis")

    user1 = User("John", online_course)
    user2 = User("Alice", offline_course)

    user1.enroll_course()
    user1.complete_course()

    user2.enroll_course()
    user2.complete_course()
