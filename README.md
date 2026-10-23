# game-character-java
This improved Java application enhances the baseline project by expanding its core Object-Oriented Architecture, integrating custom Abstract Data Types (ADTs), and introducing a dynamic Java Swing Graphical User Interface (GUI).

Key Features Added:
Expanded Character Classes: Implemented two distinct character types (Warrior and Mage) derived from an abstract base class, each with unique attack and special ability behaviors.

Triple ADT Implementation:

List (ArrayList): Main storage for managing the active roster of characters.

Queue (CharacterQueue): Implemented dynamic First-In, First-Out (FIFO) mechanics to handle character battle turns.

Stack (CharacterStack): Implemented dynamic Last-In, First-Out (LIFO) mechanics to record character action logs and allow action undo operations.

Modern GUI Theme: Built a custom-themed Swing interface using a dark color scheme (#1E1E28 and #2D2D3C) with structured panel layouts.

Robust Input Validation: Includes runtime checks to prevent empty names or invalid inputs, displaying helpful pop-up dialog messages via JOptionPane.

2. Core Concepts Applied
Abstraction
Abstract Base Class (GameCharacter): Serves as a generalized template for all game characters. It defines common member fields (name, characterClass) and enforces character contract requirements without providing specific implementation details.

Abstract Methods (attack(), specialMove()): Declared in GameCharacter without a body. Subclasses (Warrior and Mage) override these methods to provide concrete attack descriptions (e.g., swinging a sword vs. casting a fireball).

Abstract Data Type (ADT)
List: Managed through CharacterManager to store created characters sequentially.

Queue: Wrapped using java.util.ArrayDeque to provide enqueue() and dequeue() operations. Characters are added to the queue upon creation and popped sequentially during turn cycles.

Stack: Wrapped using java.util.ArrayDeque to provide push() and pop() operations. Executed combat moves push character actions onto the stack, enabling real-time action rollbacks when clicking "Undo Action".

Graphical User Interface (GUI)
Developed using Java Swing (JFrame, JPanel, JButton, JTextField, JComboBox, JTextArea, JScrollPane).

Uses a BorderLayout structure:

NORTH: Form input panel for creating characters.

CENTER: Monospaced text display area wrapped in a scroll pane for viewing action logs.

SOUTH: Action control panel for firing battle execution, queue shifts, stack undos, and roster listings.

User Input & Validation
Collects input interactively through JTextField and JComboBox.

Before instantiating objects, nameField.getText().trim().isEmpty() validates that the user provided a name.

Displays a JOptionPane.showMessageDialog error prompt if validation fails, preventing invalid objects from corrupting the ADT stores.

3. How to Run the Program
Prerequisites
Java Development Kit (JDK 11 or later installed).

Compilation & Execution via Terminal
Clone the repository (or open your terminal in the source directory):

Bash
git clone <your-github-repository-url>
cd <your-repository-folder>
Compile all Java files:

Bash
javac *.java
Run the main application:

Bash
java GameApp
4. Demonstrating the Application (Step-by-Step Script)
When presenting or demonstrating your program, follow these steps to showcase all required criteria:

Demonstrate User Input & Validation:

Leave the Character Name field blank and click Add Character. Show the error pop-up dialog verifying input validation.

Type "Brader", select Warrior from the dropdown, and click Add Character.

Type "GabMids", select Mage from the dropdown, and click Add Character.

Demonstrate Abstraction & Polimorphism:

Click Execute Actions. Point out how calling the exact same .attack() and .specialMove() methods on both characters yields class-specific results (Warrior swings sword / Mage casts fireball).

Demonstrate Abstract Data Types (ADT):

List: Click List All to display the entire managed roster.

Queue (FIFO): Click Next Turn (Queue) multiple times. Point out how the application dequeues the next character in line sequentially and rotates them back to the end of the line.

Stack (LIFO): Click Undo Action (Stack). Demonstrate how the program pops the most recently logged character action off the stack in reverse order.
