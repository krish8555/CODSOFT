import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        String[] subjectNames = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];

        // Input validation for subject names (optional)
        // You can add a loop here to ensure non-empty subject names:
        for (int i = 0; i < numberOfSubjects; i++) {
            do {
                System.out.printf("Enter subject name for subject %d: ", i + 1);
                subjectNames[i] = scanner.nextLine().trim(); // Trim leading/trailing whitespace
            } while (subjectNames[i].isEmpty());
        }

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("Enter marks for %s (out of 100): ", subjectNames[i]);
            marks[i] = scanner.nextInt();

            // Input validation for marks (optional)
            // You can add an if-else block here to check if marks are within 0-100 range:
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered. Please enter a value between 0 and 100.");
                i--; // Decrement i to repeat mark entry for the same subject
            }
        }

        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("Subject: " + subjectNames[i] + ", Marks: " + marks[i]);
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) 10*(totalMarks /( numberOfSubjects * 100));  // Use 100.0 for double precision
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
