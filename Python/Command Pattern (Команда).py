from abc import ABC, abstractmethod


# Receiver Classes
class CourseRegistrationSystem:
    def register_course(self, course_name):
        print(f"Registered for the course: {course_name}")

    def cancel_registration(self, course_name):
        print(f"Cancelled registration for the course: {course_name}")


class CourseProgressSystem:
    def start_course(self, course_name):
        print(f"Started the course: {course_name}")

    def complete_course(self, course_name):
        print(f"Completed the course: {course_name}")


# Commands
class Command(ABC):
    @abstractmethod
    def execute(self):
        pass


class RegisterCourseCommand(Command):
    def __init__(self, receiver, course_name):
        self.receiver = receiver
        self.course_name = course_name

    def execute(self):
        self.receiver.register_course(self.course_name)


class CancelRegistrationCommand(Command):
    def __init__(self, receiver, course_name):
        self.receiver = receiver
        self.course_name = course_name

    def execute(self):
        self.receiver.cancel_registration(self.course_name)


class StartCourseCommand(Command):
    def __init__(self, receiver, course_name):
        self.receiver = receiver
        self.course_name = course_name

    def execute(self):
        self.receiver.start_course(self.course_name)


class CompleteCourseCommand(Command):
    def __init__(self, receiver, course_name):
        self.receiver = receiver
        self.course_name = course_name

    def execute(self):
        self.receiver.complete_course(self.course_name)


# Invoker
class CourseCommandInvoker:
    def __init__(self):
        self.commands = []

    def add_command(self, command):
        self.commands.append(command)

    def execute_commands(self):
        for command in self.commands:
            command.execute()
        self.commands = []


# Client
if __name__ == '__main__':
    registration_system = CourseRegistrationSystem()
    progress_system = CourseProgressSystem()

    invoker = CourseCommandInvoker()

    # Registering for courses
    invoker.add_command(RegisterCourseCommand(registration_system, "Course 1"))
    invoker.add_command(RegisterCourseCommand(registration_system, "Course 2"))

    # Cancelling registration for a course
    invoker.add_command(CancelRegistrationCommand(registration_system, "Course 2"))

    # Starting and completing courses
    invoker.add_command(StartCourseCommand(progress_system, "Course 1"))
    invoker.add_command(CompleteCourseCommand(progress_system, "Course 1"))

    # Executing all the commands
    invoker.execute_commands()
