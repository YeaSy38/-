class Course:
    def __init__(self, name, duration, difficulty):
        self.name = name
        self.duration = duration
        self.difficulty = difficulty

    def __str__(self):
        return f'Course: {self.name}, Duration: {self.duration}, Difficulty: {self.difficulty}'


class CourseBuilder:
    def __init__(self):
        self.name = ''
        self.duration = None
        self.difficulty = ''

    def set_name(self, name):
        self.name = name

    def set_duration(self, duration):
        self.duration = duration

    def set_difficulty(self, difficulty):
        self.difficulty = difficulty

    def build(self):
        return Course(self.name, self.duration, self.difficulty)


class CourseDirector:
    def __init__(self, builder):
        self.builder = builder

    def construct_basic_course(self):
        self.builder.set_name('Basic Course')
        self.builder.set_duration(4)
        self.builder.set_difficulty('Beginner')

    def construct_advanced_course(self):
        self.builder.set_name('Advanced Course')
        self.builder.set_duration(8)
        self.builder.set_difficulty('Expert')


# Example usage
if __name__ == '__main__':
    builder = CourseBuilder()
    director = CourseDirector(builder)

    director.construct_basic_course()
    basic_course = builder.build()
    print(basic_course)

    director.construct_advanced_course()
    advanced_course = builder.build()
    print(advanced_course)
