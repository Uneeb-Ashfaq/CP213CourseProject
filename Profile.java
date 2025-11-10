
import java.util.Scanner;

public class Profile {

    public static void main(String[] args) {
        Profile app = new Profile();
        app.getUserInfo();
        app.displayInfo();
    }

    String name;
    int age;
    String gender;
    double height;
    double weight;
    String activityLevel;

    Scanner input = new Scanner(System.in);

    // Method to get user info with validation
    public void getUserInfo() {
        // Name validation (non-empty, full name)
        while (true) {
            System.out.print("Enter your full name: ");
            name = input.nextLine().trim();
            if (!name.isEmpty() && name.contains(" ")) {
                // Capitalize each part of the name
                String[] parts = name.split(" ");
                StringBuilder capitalizedName = new StringBuilder();
                for (String part : parts) {
                    if (part.length() > 0) {
                        capitalizedName.append(part.substring(0,1).toUpperCase())
                                       .append(part.substring(1).toLowerCase())
                                       .append(" ");
                    }
                }
                name = capitalizedName.toString().trim();
                break;
            } else {
                System.out.println("Please enter your full name (first and last).");
            }
        }

        // Age validation (number > 0)
        while (true) {
            System.out.print("Enter your age: ");
            if (input.hasNextInt()) {
                age = input.nextInt();
                input.nextLine(); // consume newline
                if (age > 0) break;
                else System.out.println("Age must be greater than 0.");
            } else {
                System.out.println("Please enter a valid number for age.");
                input.nextLine(); // discard invalid input
            }
        }

        // Gender validation (M/F only)
        while (true) {
            System.out.print("Enter your gender (M/F): ");
            gender = input.nextLine().trim().toUpperCase();
            if (gender.equals("M") || gender.equals("F")) break;
            else System.out.println("Please enter only M or F.");
        }

        // Height validation (number > 0)
        while (true) {
            System.out.print("Enter your height (cm): ");
            if (input.hasNextDouble()) {
                height = input.nextDouble();
                input.nextLine();
                if (height > 0) break;
                else System.out.println("Height must be greater than 0.");
            } else {
                System.out.println("Please enter a valid number for height.");
                input.nextLine();
            }
        }

        // Weight validation (number > 0)
        while (true) {
            System.out.print("Enter your weight (kg): ");
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
                input.nextLine();
                if (weight > 0) break;
                else System.out.println("Weight must be greater than 0.");
            } else {
                System.out.println("Please enter a valid number for weight.");
                input.nextLine();
            }
        }

        // Activity level validation
        while (true) {
            System.out.print("Enter your activity level (Light, Moderate, Active, Very Active): ");
            activityLevel = input.nextLine().trim().toLowerCase();

            if (activityLevel.equals("light") ||
                activityLevel.equals("moderate") ||
                activityLevel.equals("active") ||
                activityLevel.equals("very active")) {

                // Capitalize for display
                if (activityLevel.equals("very active")) {
                    activityLevel = "Very Active";
                } else {
                    activityLevel = activityLevel.substring(0,1).toUpperCase() + activityLevel.substring(1);
                }
                break;
            } else {
                System.out.println("Invalid activity level. Choose from Light, Moderate, Active, Very Active.");
            }
        }
    }

    // Display user info
    public void displayInfo() {
        System.out.println("\n--- Profile ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Activity Level: " + activityLevel);
    }
}