
    

public class Meal {
    // ==========================
    // Private Attributes
    // ==========================
    private String mealType;       // breakfast, lunch, dinner, or snack
    private String name;           // name of the meal (e.g., "Oatmeal")
    private double servingAmount;  // number of servings
    private double caloriesPerServing;       // total calories per serving
 
    // ==========================
    // Constructors
    // ==========================

    /**
     * Default constructor
     */
    public Meal() {
	this.mealType = "Unknown";
	this.name = "Unnamed";
	this.servingAmount = 0.0;
	this.caloriesPerServing = 0.0;
    }

	

    /**
     * Parameterized constructor
     *
     * @param mealType
     * @param name
     * @param servingAmount
     * @param caloriesPerServing
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

    

}




