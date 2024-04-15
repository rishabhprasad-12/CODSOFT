import java.util.Scanner;

public class Grade_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t\tGrade Calculator");
        System.out.println("How many subject do you hava?");
        int n = sc.nextInt();

        int marks, totMarks = 0;

        System.out.println("\nEnter your marks below");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks = sc.nextInt();
            // check marks is invalid or not
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid Marks. Please enter marks between 1-100");
                System.out.print("Subject " + (i + 1) + ": ");
                marks = sc.nextInt();
            }
            totMarks += marks;
        }

        int avgMarks = totMarks / n;
        System.out.println("\nResult: ");
        System.out.println("Total Marks: " + totMarks + " out of " + 100 * n + "\t\tAverage Marks: " + avgMarks);

        switch (avgMarks / 10) {        // /10 to give the range of 10 number each
            case 10:
            case 9:
                System.out.println("Grade: A+");
                System.out.println("\nOutstanding! Your hard work has truely paid off.");
                break;
            case 8:
                System.out.println("Grade: A");
                System.out.println("\nExcellent Work! Keep it up. You're on a roll!");
                break;
            case 7:
                System.out.println("Grade: B+");
                System.out.println("\nExcellent Work! Keep it up. You can do better.");
                break;
            case 6:
                System.out.println("Garde: B");
                System.out.println("\nGood Work! You can do better.");
                break;
            case 5:
                System.out.println("Grade: C+");
                System.out.println("\nNot Bad! You can do better. Try harder next time.");
                break;
            case 4:
                System.out.println("Grade: D");
                System.out.println("\nYou need to improve. Try hard next time.");
                break;
            case 3:
                System.out.println("Grade: E");
                System.out.println("\nPoor Result. You need to improve.");
                break;
            default:
                System.out.println("Fail");
                System.out.println("\nVery Poor Result. You should try again next year.");
        }
    }
}
