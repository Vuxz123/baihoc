public class Student implements Comparable<Student> {
  private String name = "";
  private String id = "";
  private String group = "";
  private String email = "";

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public String getName() {
    return name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInfor() {
    return name + " - " + id + " - " + group + " - " + email;
  }

  /** abc. */
  public Student() {
    name = "Student";
    id = "000";
    group = "K62CB";
    email = "uet@vnu.edu.vn";
  }

  /**
   * abc.
   *
   * @param name name.
   * @param id id.
   * @param email email.
   */
  public Student(String name, String id, String email) {
    this.name = name;
    this.id = id;
    this.email = email;
    group = "K62CB";
  }

  /**
   * abc.
   *
   * @param s a Student.
   */
  public Student(Student s) {
    this.name = s.name;
    this.id = s.id;
    this.email = s.email;
    this.group = s.group;
  }

  @Override
  public int compareTo(Student o) {
    return o.group.compareTo(group) == 0
            && o.name.compareTo(name) == 0
            && o.id.compareTo(id) == 0
            && o.email.compareTo(email) == 0
        ? 0
        : 1;
  }
}
