
import java.time.LocalDate;


/**
 * LoggedMeal
 * Subclass of Meal that adds a date to show when the meal was logged.
 * Demonstrates inheritance + method overriding (polymorphism).
 */
public class LoggedMeal extends Meal {

    private LocalDate dateLogged;// date the meal was added

    /**
     * Creates a LoggedMeal using the Meal constructor + today's date.
     */
    public LoggedMeal(String mealType, String name, double servingAmount, double caloriesPerServing) {
        super(mealType, name, servingAmount, caloriesPerServing);
        this.dateLogged = LocalDate.now(); // when the meal was logged
    }

    public LocalDate getDateLogged() {
        return dateLogged;
    }

    /**
     * Polymorphism:
     * Overrides Meal's getDisplayText() to include total calories + date logged.
     */
    @Override
    public String getDisplayText() {
        double totalCalories = getCalories() * getServingAmount();
        return String.format("%s - %s (%.1f x %.0f kcal = %.0f kcal) on %s",
                getMealType(),
                getName(),
                getServingAmount(),
                getCalories(),
                totalCalories,
                dateLogged.toString());
    }
}
