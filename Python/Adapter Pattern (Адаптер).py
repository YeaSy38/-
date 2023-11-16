# ����, �� ����������� ��������� ��� ������ �� ����
class CourseRegistrationSystem:
    def register_course(self, course_id: int, student_id: int):
        pass

# ����, ���� ������ ������� ������ �� ���� � ��������� ������� ������������� ��������
class CourseRegistrationManager:
    def register(self, course_id: int, student_id: int):
        print(f"������� {student_id} ������ ������������� �� ���� {course_id}.")

    def count_registered_students(self, course_id: int) -> int:
        return 10  # ��������� ����� �������� ��������

# �������, ���� ��������� ������������ ������� ������ �� ���� ����� ��������� CourseRegistrationSystem
class CourseRegistrationAdapter(CourseRegistrationSystem):
    def __init__(self, manager: CourseRegistrationManager):
        self.manager = manager

    def register_course(self, course_id: int, student_id: int):
        self.manager.register(course_id, student_id)

# ������� ������� ��������
if __name__ == "__main__":
    # ��������� ��'��� CourseRegistrationManager
    manager = CourseRegistrationManager()

    # ��������� ������� � �������� ���� ��'��� CourseRegistrationManager
    adapter = CourseRegistrationAdapter(manager)

    # ������������� ������� ��� ��������� �������� �� ����
    adapter.register_course(1, 42)

    # ������������� ������� ��� ��������� ������� ������������� �������� �� ����
    count = adapter.count_registered_students(1)
    print(f"ʳ������ ������������� �������� �� ����: {count}")
