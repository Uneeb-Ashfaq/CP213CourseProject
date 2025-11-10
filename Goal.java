import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Goal {

    private String goalType;           // Lose, Gain, Maintain
    private double targetWeight;       // Target weight in kg
    private int months;                // Number of months to reach goal
    private double dailyCalorieGoal;   // Daily calorie goal calculated
    private List<Double> dailyCalories; // Tracks planned daily calorie intake

    // Parameterized constructor
    public Goal(String goalType, double targetWeight, int months) {
        this.goalType = goalType;
        this.targetWeight = targetWeight;
        this.months = months;
        this.dailyCalories = new ArrayList<>();
    }

    // Default constructor
    public Goal() {
        this.dailyCalories = new ArrayList<>();
    }

    // Getters
    public String getGoalType() { return goalType; }
    public double getTargetWeight() { return targetWeight; }
    public int getMonths() { return months; }
    public double getDailyCalorieGoal() { return dailyCalorieGoal; }
    public List<Double> getDailyCalories() { return dailyCalories; }

    // Setters
    public void setGoalType(String goalType) { this.goalType = goalType; }
    public void setTargetWeight(double targetWeight) { this.targetWeight = targetWeight; }
    public void setMonths(int months) { this.months = months; }
    public void setDailyCalorieGoal(double dailyCalorieGoal) { this.dailyCalorieGoal = dailyCalorieGoal; }

    /**
     * Calculate daily calories using Profile's weight and activity level
     */
    private double calculateMaintenanceCalories(Profile profile) {
        double bmr;
        // BMR formula
        if (profile.gender.equalsIgnoreCase("M")) {
            bmr = 10 * profile.weight + 6.25 * profile.height - 5 * profile.age + 5;
        } else {
            bmr = 10 * profile.weight + 6.25 * profile.height - 5 * profile.age - 161;
        }

        // Activity multiplier
        double multiplier = 1.0;
        switch (profile.activityLevel.toLowerCase()) {
            case "light":
                multiplier = 1.375;
                break;
            case "moderate":
                multiplier = 1.55;
                break;
            case "active":
                multiplier = 1.725;
                break;
            case "very active":
                multiplier = 1.9;
                break;
        }

        return bmr * multiplier;
    }

    /**
     * Calculate daily calorie goal based on weight difference and time frame
     */
    public void calculateDailyCalories(Profile profile) {
        double currentWeight = profile.weight;
        double weightDiff = targetWeight - currentWeight; // +ve gain, -ve loss
        int totalDays = months * 30;

        double totalCaloriesChange = weightDiff * 7700; // 1 kg ~ 7700 kcal
        double dailyAdjustment = totalCaloriesChange / totalDays;

        double maintenanceCalories = calculateMaintenanceCalories(profile);
        dailyCalorieGoal = maintenanceCalories + dailyAdjustment;

        // Fill ArrayList with daily calorie plan
        dailyCalories.clear();
        for (int i = 0; i < totalDays; i++) {
            dailyCalories.add(dailyCalorieGoal);
        }
    }

    /**
     * Ask user for goal details
     */
    public void createGoalFromInput(Profile profile) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to Lose, Maintain, or Gain weight? ");
        goalType = scanner.nextLine().trim();

        System.out.print("Enter your target weight in kg: ");
        targetWeight = scanner.nextDouble();

        System.out.print("In how many months do you want to reach this goal? ");
        months = scanner.nextInt();

        calculateDailyCalories(profile);

        // Display guidance
        System.out.println("\n--- Goal Summary ---");
        System.out.println("Goal Type: " + goalType);
        System.out.printf("Target Weight: %.1f kg%n", targetWeight);
        System.out.println("Time Frame: " + months + " months");
        System.out.printf("Daily Calorie Target: %.0f kcal/day%n", dailyCalorieGoal);
        System.out.println("Note: A healthy weight change is about 0.5 kg per week. This plan is designed to be safe and sustainable.");
    }

    /**
     * Display first 7 days of daily calorie plan
     */
    public void displayDailyPlan() {
        System.out.println("\n--- Daily Calorie Plan (first 7 days) ---");
        for (int i = 0; i < Math.min(7, dailyCalories.size()); i++) {
            System.out.printf("Day %d: %.0f kcal%n", i + 1, dailyCalories.get(i));
        }
        if (dailyCalories.size() > 7) {
            System.out.println("... remaining days follow the same target.");
        }
    }
}
