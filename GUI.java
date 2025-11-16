import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    // Variables to store user data
    private JFrame frame;
    private Profile userProfile;
    
    public GUI() {
        userProfile = new Profile(); // Create empty profile
        frame = new JFrame();
        
        frame.setSize(550, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CalorieAppTracker");
        frame.setLocationRelativeTo(null); // Center the window
        
        showProfileScreen();
        frame.setVisible(true);
    }
    
    private void showProfileScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245)); // Light gray background
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // HEADER
        JLabel headerText = new JLabel("Create Your Profile");
        headerText.setFont(new Font("SansSerif", Font.BOLD, 28));
        headerText.setForeground(new Color(50, 50, 50));
        headerText.setHorizontalAlignment(SwingConstants.CENTER);
        headerText.setBounds(50, 20, 400, 40);
        panel.add(headerText);
        
        // First Name
        JLabel firstName = new JLabel("First Name:");
        firstName.setFont(new Font("SansSerif", Font.BOLD, 13));
        firstName.setBounds(50, 110, 120, 25);
        panel.add(firstName);
        
        JTextField firstNameText = new JTextField();
        firstNameText.setBounds(180, 110, 280, 30);
        firstNameText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(firstNameText);
        
        // Last Name
        JLabel lastName = new JLabel("Last Name:");
        lastName.setFont(new Font("SansSerif", Font.BOLD, 13));
        lastName.setBounds(50, 155, 120, 25);
        panel.add(lastName);
        
        JTextField lastNameText = new JTextField();
        lastNameText.setBounds(180, 155, 280, 30);
        lastNameText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(lastNameText);
        
        // Age
        JLabel age = new JLabel("Age:");
        age.setFont(new Font("SansSerif", Font.BOLD, 13));
        age.setBounds(50, 200, 120, 25);
        panel.add(age);
        
        JTextField ageText = new JTextField();
        ageText.setBounds(180, 200, 280, 30);
        ageText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(ageText);
        
        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("SansSerif", Font.BOLD, 13));
        gender.setBounds(50, 245, 120, 25);
        panel.add(gender);
        
        String[] genderOptions = {"Select", "Male", "Female"};
        JComboBox<String> genderCombo = new JComboBox<>(genderOptions);
        genderCombo.setBounds(180, 245, 280, 30);
        genderCombo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(genderCombo);
        
        // Height
        JLabel height = new JLabel("Height (cm):");
        height.setFont(new Font("SansSerif", Font.BOLD, 13));
        height.setBounds(50, 290, 120, 25);
        panel.add(height);
        
        JTextField heightText = new JTextField();
        heightText.setBounds(180, 290, 280, 30);
        heightText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(heightText);
        
        // Weight
        JLabel weight = new JLabel("Weight (kg):");
        weight.setFont(new Font("SansSerif", Font.BOLD, 13));
        weight.setBounds(50, 335, 120, 25);
        panel.add(weight);
        
        JTextField weightText = new JTextField();
        weightText.setBounds(180, 335, 280, 30);
        weightText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(weightText);
        
        // Activity Level
        JLabel activityLevel = new JLabel("Activity Level:");
        activityLevel.setFont(new Font("SansSerif", Font.BOLD, 13));
        activityLevel.setBounds(50, 380, 120, 25);
        panel.add(activityLevel);
        
        String[] activityLevelOptions = {"Select", "Light", "Moderate", "Active", "Very Active"};
        JComboBox<String> activityLevelCombo = new JComboBox<>(activityLevelOptions);
        activityLevelCombo.setBounds(180, 380, 280, 30);
        activityLevelCombo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(activityLevelCombo);
        
        // Continue Button
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(180, 450, 150, 45);
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        continueButton.setBackground(new Color(100, 200, 150));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusPainted(false);
        continueButton.setOpaque(true);
        continueButton.setContentAreaFilled(true);
        continueButton.setBorder(BorderFactory.createEmptyBorder());
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        continueButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                continueButton.setBackground(new Color(80, 180, 130));
            }
            public void mouseExited(MouseEvent e) {
                continueButton.setBackground(new Color(100, 200, 150));
            }
        });
        
        // Button Click 
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get inputs
                String firstNameInput = firstNameText.getText().trim();
                String lastNameInput = lastNameText.getText().trim();
                String ageInput = ageText.getText().trim();
                String genderInput = (String) genderCombo.getSelectedItem();
                String heightInput = heightText.getText().trim();
                String weightInput = weightText.getText().trim();
                String activityInput = (String) activityLevelCombo.getSelectedItem();
                
                // Check if empty
                if (firstNameInput.isEmpty() || lastNameInput.isEmpty() || ageInput.isEmpty() || 
                    heightInput.isEmpty() || weightInput.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Check dropdowns
                if (genderInput.equals("Select") || activityInput.equals("Select")) {
                    JOptionPane.showMessageDialog(frame, "Please select gender and activity level!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Convert to proper types
                int ageValue = Integer.parseInt(ageInput);
                double heightValue = Double.parseDouble(heightInput);
                double weightValue = Double.parseDouble(weightInput);
                
                String fullName = firstNameInput + " " + lastNameInput;
                
                // Your Profile class uses public variables, so set them directly:
                userProfile.name = firstNameInput + " " + lastNameInput;
                userProfile.age = ageValue;
                userProfile.gender = genderInput.equals("Male") ? "M" : "F";
                userProfile.height = heightValue;
                userProfile.weight = weightValue;
                userProfile.activityLevel = activityInput;
                
                JOptionPane.showMessageDialog(frame, 
                    "Profile saved successfully!\n\n" +
                    "Name: " + userProfile.name + "\n" +
                    "Age: " + userProfile.age + "\n" +
                    "Gender: " + userProfile.gender + "\n" +
                    "Height: " + userProfile.height + " cm\n" +
                    "Weight: " + userProfile.weight + " kg\n" +
                    "Activity Level: " + userProfile.activityLevel,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Go to next screen
                showGoalScreen();
            }
        });
        
        panel.add(continueButton);
        
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }
        
    private void showGoalScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
        
        // HEADER
        JLabel headerText = new JLabel("Set Your Goal");
        headerText.setFont(new Font("SansSerif", Font.BOLD, 28));
        headerText.setForeground(new Color(50, 50, 50));
        headerText.setHorizontalAlignment(SwingConstants.CENTER);
        headerText.setBounds(50, 20, 450, 40);
        panel.add(headerText);
        
        // Goal Type
    
        JLabel goalType = new JLabel("Goal Type:");
        goalType.setFont(new Font("SansSerif", Font.BOLD, 13));
        goalType.setBounds(50, 110, 120, 25);
        panel.add(goalType);
        
        String[] goalOptions = {"Select", "Lose", "Maintain", "Gain"};
        JComboBox<String> goalCombo = new JComboBox<>(goalOptions);
        goalCombo.setBounds(200, 110, 280, 30);
        goalCombo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        
        panel.add(goalCombo);
        
        // Target Weight
        JLabel targetWeight = new JLabel("Target Weight (kg):");
        targetWeight.setFont(new Font("SansSerif", Font.BOLD, 13));
        targetWeight.setBounds(50, 170, 140, 25);
        panel.add(targetWeight);
        
        JTextField targetWeightText = new JTextField();
        targetWeightText.setBounds(200, 170, 280, 30);
        targetWeightText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(targetWeightText);
        
        // Time Frame
        JLabel timeFrame = new JLabel("Time Frame (months):");
        timeFrame.setFont(new Font("SansSerif", Font.BOLD, 13));
        timeFrame.setBounds(50, 230, 140, 25);
        panel.add(timeFrame);
        
        JTextField timeFrameText = new JTextField();
        timeFrameText.setBounds(200, 230, 280, 30);
        timeFrameText.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(timeFrameText);
        
        // Continue Button
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(180, 320, 200, 45);
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        continueButton.setBackground(new Color(46, 204, 113));
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusPainted(false);
        continueButton.setOpaque(true);
        continueButton.setContentAreaFilled(true);
        continueButton.setBorder(BorderFactory.createEmptyBorder());
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        continueButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                continueButton.setBackground(new Color(80, 180, 130));
            }
            public void mouseExited(MouseEvent e) {
                continueButton.setBackground(new Color(100, 200, 150));
            }
        });
        
        panel.add(continueButton);
    }




    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}