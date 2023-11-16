class CourseRegistrationSystem:
    instance = None

    @staticmethod
    def get_instance():
        if CourseRegistrationSystem.instance is None:
            CourseRegistrationSystem()
        return CourseRegistrationSystem.instance

    def __init__(self):
        if CourseRegistrationSystem.instance is not None:
            raise Exception("��� ���� � ��������! ������������ ����� get_instance().")
        else:
            CourseRegistrationSystem.instance = self
            self.courses = {}  # ������� ��� ��������� �����

    def add_course(self, course_name):
        self.courses[course_name] = []

    def enroll_student(self, course_name, student_name):
        if course_name in self.courses:
            self.courses[course_name].append(student_name)
            print("������� {} ������ ��������� �� ���� {}.".format(student_name, course_name))
        else:
            print("���� {} �� ����.".format(course_name))

    def display_courses(self):
        for course in self.courses:
            print("���� {}: {}".format(course, ", ".join(self.courses[course])))


# ������� ������������

# ������ ��������� �������� ���������� ����� CourseRegistrationSystem
try:
    system1 = CourseRegistrationSystem()  # ������� ������� Exception
except Exception as e:
    print(str(e))

# ��������� ������� ���������� ����� CourseRegistrationSystem
system = CourseRegistrationSystem.get_instance()

# ��������� �����
system.add_course("Python Programming")
system.add_course("Web Development")

# ����� �������� �� �����
system.enroll_student("Python Programming", "John Doe")
system.enroll_student("Python Programming", "Jane Smith")
system.enroll_student("Web Development", "Alice Johnson")

# ³���������� ������������� �����
system.display_courses()
