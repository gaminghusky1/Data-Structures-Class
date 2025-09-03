/*
 * Practice handling exceptions
 */

import javax.swing.JOptionPane;

public class ExceptionHandling {
    public static void main(String[] args) {
        // Enter quiz grades until a -1 is returned & display the average (mean)
        int sum = 0;
        int numGrades = 0;
        int grade = 0;
        while (grade != -1) {
            grade = getGrade(0, 110);
            if (grade != -1) {
                numGrades++;
                sum += grade;
            }
        }
        double average = 0;
        if (numGrades > 0)
            average = (double) sum / numGrades;
        JOptionPane.showMessageDialog(null,
                String.format("Average:  %.5f", average));
        System.exit(0);
    }

    /**
     * Prompts user for integer quiz grade in range [min, max].
     * Entered grade is returned. If user is finished entering grades
     * and chooses to cancel input, -1 is returned.
     *
     * @param min the minimum acceptable value
     * @param max the maximum acceptable value
     *            Precondition: min < max
     * @return grade entered; -1 when finished
     * Postcondition: grade returned is in range [min, max]
     */
    public static int getGrade(int min, int max) {
        // Throw IllegalArgumentException if min >= max
        if (min >= max)
            // Throw IllegalArgumentException to inform user of illegal bounds
            throw new IllegalArgumentException("min < max violation; min: "
                    + min + " max: " + max);

        boolean badGrade = true;
        int grade = 0;
        while (badGrade) {
            String inputStr = JOptionPane.showInputDialog(null,
                    "Enter a quiz grade (choose cancel to quit)");
            if (inputStr == null)
                return -1;

            try {
                grade = Integer.parseInt(inputStr.trim());

                badGrade = grade < min || grade > max;
                // ! (grade >= min && grade <= max)
                if (badGrade) {
                    JOptionPane.showMessageDialog(null,
                            "Grade must be in range [" + min + ", " + max
                                    + "]. Try again.");
                }
            } catch (NumberFormatException fmt) {
                JOptionPane.showMessageDialog(null,
                        "Grade must be an integer value. Try again.");
            }
        }
        return grade;
    }
}