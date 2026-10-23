package librando;

public class Mage extends GameCharacter{
	
	public Mage(String name) {
        super(name, "Mage");
    }

    @Override
    public String attack() {
        return name + " casts a fireball!";
    }

    @Override
    public String specialMove() {
        return name + " uses Lightning Storm!";
    }
}
