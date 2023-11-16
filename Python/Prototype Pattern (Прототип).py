import copy


class Course:
    def __init__(self, name, duration, topic):
        self.name = name
        self.duration = duration
        self.topic = topic

    def __str__(self):
        return f"Course: {self.name}, Duration: {self.duration} hours, Topic: {self.topic}"


class CourseRegistry:
    def __init__(self):
        self.course_prototypes = {}

    def register_course(self, name, duration, topic):
        course = Course(name, duration, topic)
        self.course_prototypes[name] = course

    def unregister_course(self, name):
        del self.course_prototypes[name]

    def clone_course(self, name, duration=None, topic=None):
        if name in self.course_prototypes:
            course = copy.deepcopy(self.course_prototypes[name])

            if duration:
                course.duration = duration
            if topic:
                course.topic = topic

            return course


if __name__ == '__main__':
    registry = CourseRegistry()

    # Registering courses
    registry.register_course("Python Fundamentals", 40, "Python Programming")
    registry.register_course("Advanced Python", 30, "Advanced Python Programming")

    # Cloning and modifying registered courses
    cloned_course1 = registry.clone_course("Python Fundamentals", duration=50)
    cloned_course2 = registry.clone_course("Advanced Python", topic="Data Science")

    # Printing cloned courses
    print(cloned_course1)
    print(cloned_course2)
