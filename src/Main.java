import java.util.ArrayList;
import java.util.List;

// Base Class
class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected boolean gender;

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        String genderStr = gender ? "Male" : "Female";
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + genderStr + ".";
    }
}

// Student Class
class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade. Must be between 0 and 100.");
        }
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return total / (double) grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}

// Teacher Class
class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private double salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, double salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(double percentage) {
        salary += salary * (percentage / 100);
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}

// School Class
class School {
    private List<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Create instances
        Student student1 = new Student("Alice", "Smith", 20, false);
        student1.addGrade(85);
        student1.addGrade(90);

        Teacher teacher1 = new Teacher("John", "Doe", 45, true, "Math", 15, 50000);
        teacher1.giveRaise(10);

        // Create School and add members
        School school = new School();
        school.addMember(student1);
        school.addMember(teacher1);

        // Print all members
        System.out.println(school);
    }
}