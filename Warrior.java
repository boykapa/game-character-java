package librando;

public class Warrior extends GameCharacter{
	public Warrior(String name) {
        super(name, "Warrior");
    }

    @Override
    public String attack() {
        return name + " swings a mighty sword!";
    }

    @Override
    public String specialMove() {
        return name + " uses Shield Bash!";
    }
}
