class Course:
    def __init__(self, name):
        self.name = name

class CourseIterator:
    def __init__(self, courses):
        self.courses = courses
        self.index = 0

    def __next__(self):
        if self.index < len(self.courses):
            course = self.courses[self.index]
            self.index += 1
            return course
        else:
            raise StopIteration

class CourseList:
    def __init__(self):
        self.courses = []

    def add_course(self, course):
        self.courses.append(course)

    def __iter__(self):
        return CourseIterator(self.courses)

# Example usage
course_list = CourseList()
course_list.add_course(Course("Course 1"))
course_list.add_course(Course("Course 2"))
course_list.add_course(Course("Course 3"))

for course in course_list:
    print(course.name)
