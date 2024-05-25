import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private ArrayList<Subject> subjects;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addSubject(String name, int marks) {
        subjects.add(new Subject(name, marks));
    }

    public void displayResults() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Subjects and Marks:");
        for (Subject subject : subjects) {
            System.out.println(subject.getName() + ": " + subject.getMarks());
        }
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Average Marks: " + getAverageMarks());
        System.out.println("--------------------------");
    }

    private int getTotalMarks() {
        int total = 0;
        for (Subject subject : subjects) {
            total += subject.getMarks();
        }
        return total;
    }

    private double getAverageMarks() {
        if (subjects.size() == 0) return 0;
        return getTotalMarks() / (double) subjects.size();
    }
}
