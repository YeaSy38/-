class Course:
    def __init__(self, name, duration):
        self.name = name
        self.duration = duration

    def __str__(self):
        return f"Course: {self.name}, Duration: {self.duration} hours"


class CourseHistory:
    def __init__(self):
        self.history = []

    def add_course(self, course):
        self.history.append(course)

    def get_course(self, index):
        return self.history[index]


class CourseTracker:
    def __init__(self, course):
        self.course = course
        self.history = CourseHistory()

    def record_course(self):
        self.history.add_course(self.course)

    def undo_record(self):
        if len(self.history.history) > 0:
            self.course = self.history.get_course(-1)
            self.history.history.pop()


# Creating initial course objects
course1 = Course("Python Basics", 6)
course2 = Course("Advanced Python", 8)
course3 = Course("Data Structures", 10)

# Creating a tracker for course1
tracker = CourseTracker(course1)

# Recording and displaying courses
tracker.record_course()
print(tracker.course)

# Updating course and recording changes
tracker.course = course2
tracker.record_course()
print(tracker.course)

# Updating course and recording changes
tracker.course = course3
tracker.record_course()
print(tracker.course)

# Undoing the last recorded course
tracker.undo_record()
print(tracker.course)
