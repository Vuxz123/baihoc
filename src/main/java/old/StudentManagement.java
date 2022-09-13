package old;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManagement {
  private static final int max = 100;
  public Student[] array = new Student[100];
  public final Set<String> groups = new LinkedHashSet<>();

  /**
   * abc.
   *
   * @param args args.
   */
  public static void main(String[] args) {
    /*StudentManagement studentManagement = new StudentManagement();
    Student a = new Student();
    Student b = new Student("Student", "123", "vnv@vnu.edu.vn");
    System.out.println(studentManagement.sameGroup(a, b));
    studentManagement.addStudent(a);
    studentManagement.addStudent(b);
    studentManagement.addStudent(a);
    System.out.println(studentManagement.studentsByGroup());
    studentManagement.removeStudent("123");
    System.out.println(studentManagement.studentsByGroup());*/

    //System.out.println(Solution.isPrime(234521));
  }

  /**
   * abc.
   *
   * @param s1 s1.
   * @param s2 s2.
   * @return abc.
   */
  public boolean sameGroup(Student s1, Student s2) {
    return s1.compareTo(s2) == 0;
  }

  /**
   * abc.
   *
   * @param newStudent newstudent.
   */
  public void addStudent(Student newStudent) {
    List<Student> list =
        Arrays.stream(array).filter((Objects::nonNull)).collect(Collectors.toList());
    list.add(newStudent);
    array = Arrays.copyOf(list.toArray(new Student[0]), 100);
    groups.add(newStudent.getGroup());
  }

  /**
   * abc.
   *
   * @return abs.
   */
  public String studentsByGroup() {
    StringBuilder res = new StringBuilder();
    for (String group : groups) {
      res.append(group).append("\n");
      for (Student s : array) {
        if (s == null) {
          continue;
        }
        if (s.getGroup().equals(group)) {
          res.append(s.getInfor()).append("\n");
        }
      }
    }
    return res.toString();
  }

  /**
   * abc.
   *
   * @param id id.
   */
  public void removeStudent(String id) {
    Student[] a =
        Arrays.stream(array)
            .filter(
                student -> {
                  if (student == null) {
                    return true;
                  }
                  if (student.getId().equals(id)) {
                    String group = student.getGroup();
                    func2(group);
                    return false;
                  }
                  return true;
                })
            .toArray(Student[]::new);
    array = Arrays.copyOf(a, 100);
  }

  private boolean func1(String group) {
    return Arrays.stream(array)
            .filter(
                (student -> {
                  if (student == null) {
                    return false;
                  }
                  return student.getGroup().equals(group);
                }))
            .count()
        > 1;
  }

  private void func2(String group) {
    if (!func1(group)) {
      groups.remove(group);
    }
  }
}
