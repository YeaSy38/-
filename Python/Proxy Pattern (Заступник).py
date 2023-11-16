class Course:
    def __init__(self, name):
        self.name = name
    
    def complete_course(self):
        print(f"Completing course: {self.name}")

class CourseProxy:
    def __init__(self, course):
        self.course = course
        self.completed = False
    
    def complete_course(self):
        if not self.completed:
            self.course.complete_course()
            self.completed = True
        else:
            print(f"Course '{self.course.name}' is already completed.")

if __name__ == '__main__':
    # Create a course object
    course = Course("Advanced Python Programming")
    
    # Create a course proxy object
    course_proxy = CourseProxy(course)
    
    # Complete the course through the proxy
    course_proxy.complete_course()
    
    # Attempt to complete the course again
    course_proxy.complete_course()
