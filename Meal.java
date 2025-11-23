/**
 * Meal
 * Stores basic information about a meal the user logs.
 */
public class Meal {

    // ==========================
    // Meal Fields
    // ==========================
    private String mealType;          // breakfast, lunch, dinner, snack
    private String name;              // meal name
    private double servingAmount;     // number of servings
    private double caloriesPerServing; // calories in one serving


    // ==========================
    // Constructors
    // ==========================

    /**
     * Default constructor sets empty/zero values.
     */

    public Meal() {
        this.mealType = "Unknown";
        this.name = "Unnamed";
        this.servingAmount = 0.0;
        this.caloriesPerServing = 0.0;
    }

    /**
     * Full constructor for creating a meal with all fields filled.
     */
    public Meal(String mealType, String name, double servingAmount, double caloriesPerServing) {
        this.mealType = mealType;
        this.name = name;
        this.servingAmount = servingAmount;
        this.caloriesPerServing = caloriesPerServing;
    }


    // ==========================
    // Getters and Setters
    // ==========================

    public String getMealType() {
        return this.mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getServingAmount() {
        return this.servingAmount;
    }

    public void setServingAmount(double servingAmount) {
        this.servingAmount = servingAmount;
    }

    public double getCalories() {
        return this.caloriesPerServing;
    }

    public void setCalories(double calories) {
        this.caloriesPerServing = calories;
    }

    /**
     * Returns a formatted string showing meal info.
     * Used in panels when listing logged meals.
     */
    public String getDisplayText() {
        return String.format(
                "%s - %s (%.1f x %.0f kcal)",
                mealType, name, servingAmount, caloriesPerServing
        );
    }
}
