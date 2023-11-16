class Course:
    def __init__(self, name, prerequisite=None):
        self.name = name
        self.prerequisite = prerequisite
        self.next_course = None

    def set_next(self, course):
        self.next_course = course

    def enroll(self, course_name):
        if self.name == course_name:
            print(f"Enrolling in {self.name} course.")
        elif self.next_course:
            self.next_course.enroll(course_name)
        else:
            print(f"Course {course_name} not found.")

# Creating courses
course1 = Course("Course 1")
course2 = Course("Course 2")
course3 = Course("Course 3")
course4 = Course("Course 4")

# Setting up the chain of responsibility
course1.set_next(course2)
course2.set_next(course3)
course3.set_next(course4)

# Enrollment requests
course1.enroll("Course 3")
course1.enroll("Course 5")
