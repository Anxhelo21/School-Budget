import model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SchoolTest {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        List<Subject> subjects = new ArrayList<>();

        Teacher mathTeacher = new Teacher(1, "Jane Smith", 1500);
        List<Student> mathStudents = new ArrayList<>();
        mathStudents.add(new Student(1, "Mary", 2000));
        mathStudents.add(new Student(2, "Jack", 1000));
        mathStudents.add(new Student(3, "Jackson", 5000));
        subjects.add(new Subject(1, "Math", mathTeacher, mathStudents));

        Teacher scienceTeacher = new Teacher(2, "John Doe", 2000);
        List<Student> scienceStudents = new ArrayList<>();
        scienceStudents.add(new Student(4, "David", 4500));
        scienceStudents.add(new Student(5, "Emily", 1300));
        scienceStudents.add(new Student(6, "Frank", 2400));
        subjects.add(new Subject(2, "Science", scienceTeacher, scienceStudents));

        Teacher historyTeacher = new Teacher(3, "Robert Johnson", 3500);
        List<Student> historyStudents = new ArrayList<>();
        historyStudents.add(new Student(7, "Grace", 5000));
        historyStudents.add(new Student(8, "Henry", 3000));
        historyStudents.add(new Student(9, "Isabella", 1500));
        subjects.add(new Subject(3, "History", historyTeacher, historyStudents));

        Teacher englishTeacher = new Teacher(4, "Sarah Lee", 5000);
        List<Student> englishStudents = new ArrayList<>();
        englishStudents.add(new Student(10, "Jack", 500));
        englishStudents.add(new Student(11, "Kate", 1000));
        englishStudents.add(new Student(12, "Liam", 4500));
        subjects.add(new Subject(4, "English", englishTeacher, englishStudents));

        double earnings = earningsFromStudentFees(subjects);
        double expenditure = expenditureFromTeacherSalary(subjects);

        System.out.println("\nEarnings from student fees: $" + earnings + ".");
        System.out.println("Spending from teachers salary: $" + expenditure + ".");
        System.out.println("Net Earnings/Losses: $" + netProfit(earnings, expenditure) + ".");

        FileWriter writer = new FileWriter("students.txt");
        List<String> studentNames = new ArrayList<>();
        for (Subject subject : subjects) {
            for (Student student : subject.getStudentList()) {
                studentNames.add(student.getName() + " - " + student.getFeesPaid());
            }
        }
        Collections.sort(studentNames);
        for (String nameAndFee : studentNames) {
            writer.write(nameAndFee + "\n");
        }
        writer.close();

        //Enable the 3 lines below to test the payFees method in Student class.
//        System.out.println("\nEnter the ID of the student who want to pay the tuition: ");
//        int id = input.nextInt();
//        payTuitionFee(id, subjects);


    }

    public static double netProfit(double earnings, double expenditure) {
        return earnings - expenditure;
    }

    public static double expenditureFromTeacherSalary(List<Subject> subjects) {
        double totalExpenditure = 0;
        for (Subject subject : subjects) {
            totalExpenditure += subject.getTeacher().getSalary();
        }
        return totalExpenditure;
    }

    public static double earningsFromStudentFees(List<Subject> subjects) {
        double totalEarnings = 0;
        for (Subject subject : subjects) {
            for (Student student : subject.getStudentList()) {
                totalEarnings += student.getFeesPaid();
            }
        }
        return totalEarnings;
    }

    public static void payTuitionFee(int id, List<Subject> subjects) {
        Scanner input = new Scanner(System.in);
        for (Subject subject : subjects) {
            for (Student student : subject.getStudentList()) {
                if (student.getId() == id) {
                    System.out.println("Enter the fee amount(): ");
                    double amount = input.nextDouble();
                    student.payFees(amount);
                }
            }
        }
    }
}