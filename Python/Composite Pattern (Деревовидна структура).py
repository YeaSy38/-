class Course:
    def __init__(self, name, duration):
        self.name = name
        self.duration = duration

    def display_info(self):
        print(f"Course: {self.name}, Duration: {self.duration} hours")

class CompositeCourse:
    def __init__(self, name):
        self.name = name
        self.sub_courses = []

    def add_course(self, course):
        self.sub_courses.append(course)

    def remove_course(self, course):
        self.sub_courses.remove(course)

    def display_info(self):
        print(f"Composite Course: {self.name}")
        for course in self.sub_courses:
            course.display_info()

# Create individual courses
course1 = Course("Python Basics", 20)
course2 = Course("Advanced Python", 30)
course3 = Course("Data Analysis", 25)
course4 = Course("Machine Learning", 35)

# Create composite courses
composite_course1 = CompositeCourse("Web Development")
composite_course1.add_course(course1)
composite_course1.add_course(course2)

composite_course2 = CompositeCourse("Data Science")
composite_course2.add_course(course3)
composite_course2.add_course(course4)

# Display information
course1.display_info()
print()

composite_course1.display_info()
print()

composite_course2.display_info()
