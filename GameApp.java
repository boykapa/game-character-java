package librando;
import javax.swing.*;
import java.awt.*;
public class GameApp extends JFrame {
	
	private CharacterManager manager;
    private JTextField nameField;
    private JComboBox<String> classDropdown;
    private JTextArea displayArea;

    public GameApp() {
        manager = new CharacterManager();

        setTitle("Game Character Manager");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Colors & Design Theme
        Color bgColor = new Color(30, 30, 40);
        Color panelColor = new Color(45, 45, 60);
        Color textColor = new Color(220, 220, 220);
        Color buttonColor = new Color(70, 130, 180);

        getContentPane().setBackground(bgColor);

        // --- Top Input Panel ---
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 8, 8));
        inputPanel.setBackground(panelColor);
        inputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(textColor), "Create Character", 0, 0, null, textColor));

        JLabel nameLabel = new JLabel("  Character Name:");
        nameLabel.setForeground(textColor);
        nameField = new JTextField();

        JLabel classLabel = new JLabel("  Character Class:");
        classLabel.setForeground(textColor);
        String[] classes = {"Warrior", "Mage"};
        classDropdown = new JComboBox<>(classes);

        JButton addButton = new JButton("Add Character");
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(classLabel);
        inputPanel.add(classDropdown);
        inputPanel.add(new JLabel("")); // Spacer
        inputPanel.add(addButton);

        // --- Center Display Area ---
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(new Color(20, 20, 28));
        displayArea.setForeground(textColor);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // --- Bottom Action Panel ---
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        actionPanel.setBackground(panelColor);

        JButton performActionsBtn = new JButton("Execute Actions");
        JButton listCharsBtn = new JButton("List All");

        actionPanel.add(performActionsBtn);
        actionPanel.add(listCharsBtn);

        // --- Layout Assembly ---
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        // --- Event Listeners with Input Validation ---
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid character name!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String selectedClass = (String) classDropdown.getSelectedItem();
            GameCharacter character;

            if ("Warrior".equals(selectedClass)) {
                character = new Warrior(name);
            } else {
                character = new Mage(name);
            }

            manager.addCharacter(character);
            displayArea.append("Created " + selectedClass + ": " + name + "\n");
            nameField.setText("");
        });

        performActionsBtn.addActionListener(e -> {
            if (manager.isEmpty()) {
                displayArea.append("\n[System]: No characters available to perform actions.\n");
                return;
            }
            displayArea.append("\n--- Performing Actions ---\n");
            for (GameCharacter c : manager.getAllCharacters()) {
                displayArea.append(c.attack() + "\n");
                displayArea.append(c.specialMove() + "\n");
            }
        });

        listCharsBtn.addActionListener(e -> {
            if (manager.isEmpty()) {
                displayArea.append("\n[System]: Character list is empty.\n");
                return;
            }
            displayArea.append("\n--- Current Roster ---\n");
            for (GameCharacter c : manager.getAllCharacters()) {
                displayArea.append("- " + c.getName() + " (" + c.getCharacterClass() + ")\n");
            }
        });
    }

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GameApp().setVisible(true));
		

	}

}
