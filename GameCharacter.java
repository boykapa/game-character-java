package librando;

public abstract class GameCharacter {
	protected String name;
    protected String characterClass;

    public GameCharacter(String name, String characterClass) {
        this.name = name;
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    // Abstract methods to be implemented by subclasses
    public abstract String attack();
    public abstract String specialMove();

}
