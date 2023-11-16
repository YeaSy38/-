class Course:
    def __init__(self, name):
        self.name = name
    
    def get_details(self):
        return f"Course: {self.name}"

class CourseDecorator:
    def __init__(self, course):
        self.course = course
    
    def get_details(self):
        return self.course.get_details()

class AccreditedCourse(CourseDecorator):
    def get_details(self):
        return f"{super().get_details()} (Accredited)"

class OnlineCourse(CourseDecorator):
    def get_details(self):
        return f"{super().get_details()} (Online)"

class CourseTracker:
    def __init__(self):
        self.courses = []
    
    def add_course(self, course):
        self.courses.append(course)
    
    def display_courses(self):
        for course in self.courses:
            print(course.get_details())

# Create some courses
course1 = Course("Course 1")
course2 = AccreditedCourse(Course("Course 2"))
course3 = OnlineCourse(AccreditedCourse(Course("Course 3")))

# Create a course tracker
tracker = CourseTracker()

# Add courses to the tracker
tracker.add_course(course1)
tracker.add_course(course2)
tracker.add_course(course3)

# Display all courses
tracker.display_courses()
