
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotPanel extends JPanel{
    

    private GUI app;

    public ChatBotPanel(GUI app) {
        this.app = app;

        setLayout(null);
        setBackground(new Color(245, 245, 245));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Input for chatbot



        JTextField userInputText = new JTextField("Enter Input here:");
        userInputText.setBounds(200, 740, 1000, 40);   // x, y, width, height
        userInputText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(userInputText);


 

   
}
}



