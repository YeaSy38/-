class CourseRegistration:
    def check_eligibility(self, course_id):
        print("Checking eligibility for course:", course_id)
        # Check if the student meets the eligibility criteria for the course
        return True
    
    def register(self, course_id):
        print("Registering for course:", course_id)
        # Register the student for the course
    
    def pay_fees(self, course_id):
        print("Paying fees for course:", course_id)
        # Process the payment for the course fees

class CourseCompletion:
    def complete(self, course_id):
        print("Completing course:", course_id)
        # Track the completion of the course
    
    def generate_certificate(self, course_id):
        print("Generating certificate for course:", course_id)
        # Generate a certificate for the course completion

class CourseFacade:
    def __init__(self):
        self.registration = CourseRegistration()
        self.completion = CourseCompletion()
    
    def enroll_course(self, course_id):
        if self.registration.check_eligibility(course_id):
            self.registration.register(course_id)
            self.registration.pay_fees(course_id)
            self.completion.complete(course_id)
            self.completion.generate_certificate(course_id)
            print("Course enrollment complete.")
        else:
            print("Unable to enroll in course:", course_id)
