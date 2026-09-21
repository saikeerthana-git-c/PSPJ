import java.util.Scanner;

public class MonthlyExpensesAnalyzer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Data types and variables
        double budget, total = 0, remaining, percentage;
        int n;

        // 1D Array - expense categories
        String[] categories = {
            "Food", "Travel", "Education",
            "Shopping", "Bills"
        };

        // 2D Array - stores expense for each category
        // Row = category, Column = expense entries
        double[][] expenses = new double[5][10];

        System.out.println("======================================");
        System.out.println("   MONTHLY EXPENSES & BUDGET ANALYZER");
        System.out.println("======================================");

        // Input monthly budget
        System.out.print("Enter Monthly Budget: Rs. ");
        budget = sc.nextDouble();

        // Input number of expenses for each category
        System.out.print("Enter number of expense entries per category (max 10): ");
        n = sc.nextInt();

        if (n < 1 || n > 10) {
            System.out.println("Invalid number of entries!");
            return;
        }

        // Input expenses
        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter expenses for " + categories[i]);

            for (int j = 0; j < n; j++) {
                System.out.print("Expense " + (j + 1) + ": Rs. ");
                expenses[i][j] = sc.nextDouble();

                // Prevent negative expenses
                if (expenses[i][j] < 0) {
                    expenses[i][j] = 0;
                    System.out.println("Negative value changed to 0.");
                }

                total = total + expenses[i][j];
            }
        }

        // Calculate remaining budget
        remaining = budget - total;

        // Calculate percentage used
        percentage = (total / budget) * 100;

        // Display expenses
        System.out.println("\n======================================");
        System.out.println("          EXPENSE DETAILS");
        System.out.println("======================================");

        for (int i = 0; i < 5; i++) {

            double categoryTotal = 0;

            System.out.print(categories[i] + " : ");

            for (int j = 0; j < n; j++) {
                System.out.print("Rs." + expenses[i][j] + " ");
                categoryTotal = categoryTotal + expenses[i][j];
            }

            System.out.println();
            System.out.println("Category Total = Rs." + categoryTotal);
        }

        // Find highest spending category
        double highest = 0;
        int highestIndex = 0;

        for (int i = 0; i < 5; i++) {

            double categoryTotal = 0;

            for (int j = 0; j < n; j++) {
                categoryTotal = categoryTotal + expenses[i][j];
            }

            if (categoryTotal > highest) {
                highest = categoryTotal;
                highestIndex = i;
            }
        }

        // Display final analysis
        System.out.println("\n======================================");
        System.out.println("          BUDGET ANALYSIS");
        System.out.println("======================================");

        System.out.println("Monthly Budget   : Rs." + budget);
        System.out.println("Total Expenses   : Rs." + total);
        System.out.println("Remaining Budget : Rs." + remaining);
        System.out.println("Budget Used      : " + percentage + "%");

        System.out.println("Highest Expense   : " +
                           categories[highestIndex]);
        System.out.println("Highest Amount    : Rs." + highest);

        // Conditions
        if (total > budget) {
            System.out.println("Status            : BUDGET EXCEEDED");
        }
        else if (percentage >= 80) {
            System.out.println("Status            : CLOSE TO BUDGET LIMIT");
        }
        else {
            System.out.println("Status            : WITHIN BUDGET");
        }

        System.out.println("======================================");

        sc.close();
    }
}