import java.util.Scanner;

public class ReportCardSystem {
    private String name;
    private int age;
    private String rollNo;
    private int[] marks;
    private int totalSubjects;

    
    public ReportCardSystem(String name, int age, String rollNo, int totalSubjects) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.totalSubjects = totalSubjects;
        this.marks = new int[totalSubjects];
    }

    
    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    
    public int getTotalMarks() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }

    
    public double getPercentage() {
        return (double) getTotalMarks() / totalSubjects;
    }

   
    public String getGrade() {
        double per = getPercentage();
        if (per >= 90) return "A+";
        else if (per >= 75) return "A";
        else if (per >= 60) return "B";
        else if (per >= 40) return "C";
        else return "F";
    }

   
    public void displayReport() {
        System.out.println("\n========== STUDENT REPORT CARD ==========");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Roll No    : " + rollNo);
        System.out.println("-----------------------------------------");
        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("Subject " + (i + 1) + " Marks: " + marks[i]);
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Percentage : " + String.format("%.2f", getPercentage()) + "%");
        System.out.println("Grade      : " + getGrade());
        System.out.println("=========================================");
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Roll No: ");
        String rollNo = sc.next();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        ReportCardSystem student = new ReportCardSystem(name, age, rollNo, n);

       
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        student.setMarks(marks);
        student.displayReport();

        sc.close();
    }
}
