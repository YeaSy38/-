from abc import ABC, abstractmethod

# Abstract class representing the state
class CourseState(ABC):
    @abstractmethod
    def enroll(self):
        pass

    @abstractmethod
    def cancel(self):
        pass

    @abstractmethod
    def complete(self):
        pass

# Concrete state classes
class CourseOpenState(CourseState):
    def enroll(self):
        print("You have successfully enrolled in the course.")

    def cancel(self):
        print("Sorry, you cannot cancel the course after enrollment.")

    def complete(self):
        print("You cannot complete the course without enrolling first.")

class CourseInProgressState(CourseState):
    def enroll(self):
        print("You are already enrolled in the course.")

    def cancel(self):
        print("You have successfully canceled your enrollment in the course.")

    def complete(self):
        print("Congratulations! You have completed the course.")

class CourseCompletedState(CourseState):
    def enroll(self):
        print("You have already completed the course.")

    def cancel(self):
        print("You cannot cancel the course after completion.")

    def complete(self):
        print("You cannot complete the course again.")

# Context class representing the course
class Course:
    def __init__(self):
        self.state = CourseOpenState()

    def set_state(self, state):
        self.state = state

    def enroll(self):
        self.state.enroll()

    def cancel(self):
        self.state.cancel()

    def complete(self):
        self.state.complete()

# Usage example
course = Course()

# Try different actions on the course
course.enroll()
course.cancel()
course.enroll()
course.complete()
course.cancel()
course.complete()
