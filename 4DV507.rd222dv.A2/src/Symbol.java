
public class Symbol {

	private final String name;
	private final OfpType type;

	public Symbol(String name, OfpType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public OfpType getType() {
		return type;
	}

}
