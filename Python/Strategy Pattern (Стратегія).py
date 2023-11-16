# Abstract base class for course strategies
class CourseStrategy:
    def record_course_completion(self, course):
        pass

# Strategy for recording course completion in a database
class DatabaseStrategy(CourseStrategy):
    def record_course_completion(self, course):
        print(f"Recording course completion in the database: {course}")

# Strategy for recording course completion in a log file
class LogFileStrategy(CourseStrategy):
    def record_course_completion(self, course):
        print(f"Recording course completion in the log file: {course}")

# Context class that uses the selected strategy to record course completion
class CourseRecorder:
    def __init__(self, strategy):
        self.strategy = strategy

    def record_course_completion(self, course):
        self.strategy.record_course_completion(course)

# Example usage
if __name__ == '__main__':
    # Initialize strategies
    database_strategy = DatabaseStrategy()
    log_file_strategy = LogFileStrategy()

    # Create a course recorder with the database strategy
    recorder = CourseRecorder(database_strategy)
    recorder.record_course_completion("Python Programming Course")

    # Switch to the log file strategy and record another course completion
    recorder.strategy = log_file_strategy
    recorder.record_course_completion("Data Analysis Course")
