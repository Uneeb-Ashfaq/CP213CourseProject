import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class DashboardPanel extends JPanel {
    private GUI app;
    private double todayCalories = 0;

    public DashboardPanel(GUI app) {
        this.app = app;
        setLayout(null);
        setBackground(new Color(245, 245, 245));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Header
        JLabel welcomeLabel = new JLabel("Welcome back, " + app.getUserProfile().getFirstName() + "! 👋");
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        welcomeLabel.setForeground(new Color(40, 40, 40));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBounds(0, 40, screenSize.width, 50);
        add(welcomeLabel);

        JLabel dateLabel = new JLabel(LocalDate.now().toString());
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        dateLabel.setForeground(new Color(120, 120, 120));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setBounds(0, 90, screenSize.width, 25);
        add(dateLabel);

        todayCalories = 0;
        for (Meal meal : app.getMeals()) {
            todayCalories += meal.getCalories() * meal.getServingAmount();
        }
        int cardsStartX = (screenSize.width - 1080) / 2;

        // ==================================
        // Card 1: Today's Calories
        // ==================================

        String caloriesValue = String.format("%.0f / %.0f kcal", todayCalories,
                app.getUserGoal().getDailyCalorieGoal());
        String caloriesRemaining = String.format("%.0f remaining",
                Math.max(0, app.getUserGoal().getDailyCalorieGoal() - todayCalories));

        // Create card panel
        JPanel calorieCard = new JPanel();
        calorieCard.setLayout(null);
        calorieCard.setBackground(new Color(255, 243, 224));
        calorieCard.setBounds(cardsStartX, 140, 340, 160);
        calorieCard.setBorder(BorderFactory.createLineBorder(new Color(255, 183, 77), 3));
        add(calorieCard);

        // Title label
        JLabel title1 = new JLabel("Today's Calories");
        title1.setFont(new Font("SansSerif", Font.BOLD, 16));
        title1.setForeground(new Color(80, 80, 80));
        title1.setBounds(15, 15, 310, 25);
        calorieCard.add(title1);

        JLabel value1 = new JLabel(caloriesValue);
        value1.setFont(new Font("SansSerif", Font.BOLD, 26));
        value1.setForeground(new Color(40, 40, 40));
        value1.setBounds(15, 50, 310, 40);
        calorieCard.add(value1);

        JLabel desc1 = new JLabel(caloriesRemaining);
        desc1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        desc1.setForeground(new Color(100, 100, 100));
        desc1.setBounds(15, 100, 310, 25);
        calorieCard.add(desc1);
        // ==================================
        // Card 2: Goal Progress
        // ==================================

        double remaining = Math.abs(app.getUserGoal().getTargetWeight() - app.getUserProfile().getWeight());
        String goalText = app.getUserGoal().getGoalType().equals("Lose") ? "to lose"
                : app.getUserGoal().getGoalType().equals("Gain") ? "to gain" : "to maintain";
        String valueText = String.format("%.1f kg %s", remaining, goalText);
        String descText = app.getUserGoal().getMonths() + " months remaining";
        JPanel goalCard = new JPanel();
        goalCard.setLayout(null);
        goalCard.setBackground(new Color(232, 245, 253));
        goalCard.setBounds(cardsStartX + 370, 140, 340, 160);
        goalCard.setBorder(BorderFactory.createLineBorder(new Color(66, 165, 245), 3));
        add(goalCard);

        // Title
        JLabel title2 = new JLabel("Goal Progress");
        title2.setFont(new Font("SansSerif", Font.BOLD, 16));
        title2.setForeground(new Color(80, 80, 80));
        title2.setBounds(15, 15, 310, 25);
        goalCard.add(title2);

        JLabel value2 = new JLabel(valueText);
        value2.setFont(new Font("SansSerif", Font.BOLD, 26));
        value2.setForeground(new Color(40, 40, 40));
        value2.setBounds(15, 50, 310, 40);
        goalCard.add(value2);

        // Sub Value
        JLabel desc2 = new JLabel(descText);
        desc2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        desc2.setForeground(new Color(100, 100, 100));
        desc2.setBounds(15, 100, 310, 25);
        goalCard.add(desc2);
        // ==================================
        // Card 3: Activity Level
        // ==================================

        String activityValue = app.getUserProfile().getActivityLevel();
        String activityDesc = "Current level";

        JPanel activityCard = new JPanel();
        activityCard.setLayout(null);
        activityCard.setBackground(new Color(232, 245, 233));
        activityCard.setBounds(cardsStartX + 740, 140, 340, 160);
        activityCard.setBorder(BorderFactory.createLineBorder(new Color(102, 187, 106), 3));
        add(activityCard);

        // Title
        JLabel title3 = new JLabel("Activity Level");
        title3.setFont(new Font("SansSerif", Font.BOLD, 16));
        title3.setForeground(new Color(80, 80, 80));
        title3.setBounds(15, 15, 310, 25);
        activityCard.add(title3);

        // Main Value
        JLabel value3 = new JLabel(activityValue);
        value3.setFont(new Font("SansSerif", Font.BOLD, 26));
        value3.setForeground(new Color(40, 40, 40));
        value3.setBounds(15, 50, 310, 40);
        activityCard.add(value3);

        // Sub Value
        JLabel desc3 = new JLabel(activityDesc);
        desc3.setFont(new Font("SansSerif", Font.PLAIN, 14));
        desc3.setForeground(new Color(100, 100, 100));
        desc3.setBounds(15, 100, 310, 25);
        activityCard.add(desc3);

        // =======================
        // Profile and Meals columns
        // =======================
        int contentStartX = (screenSize.width - 1040) / 2;

        // Profile header
        JLabel profileHeader = new JLabel("Your Profile");
        profileHeader.setFont(new Font("SansSerif", Font.BOLD, 22));
        profileHeader.setForeground(new Color(50, 50, 50));
        profileHeader.setBounds(contentStartX, 330, 300, 30);
        add(profileHeader);

        JPanel profileBox = new JPanel();
        profileBox.setLayout(null);
        profileBox.setBackground(Color.WHITE);
        profileBox.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));
        profileBox.setBounds(contentStartX, 370, 520, 280);

        JTextArea profileText = new JTextArea();
        profileText.setBounds(20, 20, 480, 240);
        profileText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        profileText.setBackground(Color.WHITE);
        profileText.setEditable(false);
        profileText.setBorder(null);
        profileText.setText(String.format(
                "Name: %s %s\n" +
                        "Age: %d years\n" +
                        "Gender: %s\n" +
                        "Height: %.1f cm\n" +
                        "Current Weight: %.1f kg\n" +
                        "Activity: %s\n" +
                        "BMI: %.1f\n\n" +
                        "Goal: %s weight to %.1f kg\n" +
                        "Timeframe: %d months\n" +
                        "Daily Target: %.0f kcal",
                app.getUserProfile().getFirstName(),
                app.getUserProfile().getLastName(),
                app.getUserProfile().getAge(),
                app.getUserProfile().getGender(),
                app.getUserProfile().getHeight(),
                app.getUserProfile().getWeight(),
                app.getUserProfile().getActivityLevel(),
                app.getUserProfile().getBMI(),
                app.getUserGoal().getGoalType(),
                app.getUserGoal().getTargetWeight(),
                app.getUserGoal().getMonths(),
                app.getUserGoal().getDailyCalorieGoal()));
        profileBox.add(profileText);
        add(profileBox);

        // Meals header + box
        int mealsX = contentStartX + 560;

        JLabel mealsHeader = new JLabel("Today's Meals");
        mealsHeader.setFont(new Font("SansSerif", Font.BOLD, 22));
        mealsHeader.setForeground(new Color(50, 50, 50));
        mealsHeader.setBounds(mealsX, 330, 300, 30);
        add(mealsHeader);

        JPanel mealsBox = new JPanel();
        mealsBox.setLayout(null);
        mealsBox.setBackground(Color.WHITE);
        mealsBox.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2));
        mealsBox.setBounds(mealsX, 370, 480, 280);

        if (app.getMeals().isEmpty()) {
            JLabel noMeals = new JLabel(
                    "<html><center>No meals logged yet.<br><br>Click 'Log Meal' to get started!</center></html>");
            noMeals.setFont(new Font("SansSerif", Font.PLAIN, 16));
            noMeals.setForeground(new Color(150, 150, 150));
            noMeals.setHorizontalAlignment(SwingConstants.CENTER);
            noMeals.setBounds(0, 80, 480, 100);
            mealsBox.add(noMeals);
        } else {
            JTextArea mealsText = new JTextArea();
            mealsText.setBounds(20, 20, 440, 240);
            mealsText.setFont(new Font("SansSerif", Font.PLAIN, 15));
            mealsText.setBackground(Color.WHITE);
            mealsText.setEditable(false);
            mealsText.setBorder(null);

            StringBuilder mealsList = new StringBuilder();
            int count = 1;
            for (Meal meal : app.getMeals()) {
                mealsList.append(String.format("%d. %s (%s)\n   %.0f kcal\n\n",
                        count++,
                        meal.getName(),
                        meal.getMealType(),
                        meal.getCalories() * meal.getServingAmount()));
            }
            mealsText.setText(mealsList.toString());
            JScrollPane scrollPane = new JScrollPane(mealsText);
            scrollPane.setBounds(20, 20, 440, 240);
            scrollPane.setBorder(null);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            mealsBox.add(scrollPane);
        }
        add(mealsBox);

        // =======================
        // Bottom buttons
        // =======================
        int btnStartX = (screenSize.width - 1100) / 2;

        JButton viewProgressBtn = createActionButton("📈 View Progress", new Color(52, 152, 219));
        viewProgressBtn.setBounds(btnStartX, 700, 240, 50);
        viewProgressBtn.addActionListener(e -> showProgressDialog());
        add(viewProgressBtn);

        JButton editProfileBtn = createActionButton("⚙️ Edit Profile", new Color(150, 150, 150));
        editProfileBtn.setBounds(btnStartX + 600, 700, 240, 50);
        editProfileBtn.addActionListener(e -> app.showEditProfilePanel());
        add(editProfileBtn);

        JButton logMealBtn = createActionButton("📝 Log Meal", new Color(46, 204, 113));
        logMealBtn.setBounds(btnStartX + 300, 700, 240, 50);
        logMealBtn.addActionListener(e -> app.showAddMealPage());
        add(logMealBtn);

        JButton logout = createActionButton("Log Out!", new Color(231, 76, 60));
        logout.setBounds(btnStartX + 900, 700, 240, 50);
        logout.addActionListener(e -> app.showIntroPanel());
        add(logout);

    }

    // ===== helper: button style =====
    private JButton createActionButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 18));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        Color hoverColor = bgColor.darker();
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        return button;
    }

    // ===== progress popup =====
    private void showProgressDialog() {
        double weightDiff = app.getUserGoal().getTargetWeight() - app.getUserProfile().getWeight();
        double weeklyRate = Math.abs(weightDiff) / (app.getUserGoal().getMonths() * 4.0);

        JOptionPane.showMessageDialog(this,
                String.format(
                        "📊 PROGRESS OVERVIEW\n\n" +
                                "Current Weight: %.1f kg\n" +
                                "Target Weight: %.1f kg\n" +
                                "Weight to %s: %.1f kg\n\n" +
                                "⏱️ TIMELINE\n" +
                                "Time Frame: %d months\n" +
                                "Weekly Rate: %.2f kg/week\n\n" +
                                "🔥 CALORIES\n" +
                                "Daily Goal: %.0f kcal\n" +
                                "Today's Intake: %.0f kcal\n" +
                                "Remaining: %.0f kcal\n\n" +
                                "💪 Keep pushing forward!",
                        app.getUserProfile().getWeight(),
                        app.getUserGoal().getTargetWeight(),
                        weightDiff > 0 ? "gain" : "lose",
                        Math.abs(weightDiff),
                        app.getUserGoal().getMonths(),
                        weeklyRate,
                        app.getUserGoal().getDailyCalorieGoal(),
                        todayCalories,
                        Math.max(0, app.getUserGoal().getDailyCalorieGoal() - todayCalories)),
                "Your Progress", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Load the background image
        Image bgImage = new ImageIcon("dashboard.png").getImage();

        // Draw it to fill the entire panel
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }

}