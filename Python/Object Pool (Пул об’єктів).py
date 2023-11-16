class Course:
    def __init__(self, course_name):
        self.course_name = course_name

    def get_course_name(self):
        return self.course_name


class CoursePool:
    def __init__(self):
        self.course_pool = []

    def get_course(self):
        if len(self.course_pool) > 0:
            return self.course_pool.pop()
        else:
            return None

    def add_course(self, course):
        self.course_pool.append(course)


class CourseRecordSystem:
    def __init__(self):
        self.course_pool = CoursePool()

    def record_course(self, course_name):
        course = self.course_pool.get_course()

        if course is not None:
            course.course_name = course_name
            print(f"Recording course '{course_name}'")
        else:
            print("No available courses in the pool. Please try again later.")

    def return_course(self, course):
        self.course_pool.add_course(course)
        print(f"Course '{course.get_course_name()}' returned to the pool.")


# Usage Example
record_system = CourseRecordSystem()

course1 = Course("Course 1")
course2 = Course("Course 2")
course3 = Course("Course 3")

record_system.record_course("Course A")
record_system.record_course("Course B")
record_system.record_course("Course C")

record_system.return_course(course1)
record_system.return_course(course2)

record_system.record_course("Course X")
record_system.record_course("Course Y")

