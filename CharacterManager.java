package librando;
import java.util.ArrayList;
import java.util.List;
public class CharacterManager {
	
	private List<GameCharacter> characters;

    public CharacterManager() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {
        characters.add(character);
    }

    public boolean removeCharacter(String name) {
        return characters.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    public List<GameCharacter> getAllCharacters() {
        return characters;
    }

    public boolean isEmpty() {
        return characters.isEmpty();
    }

}
