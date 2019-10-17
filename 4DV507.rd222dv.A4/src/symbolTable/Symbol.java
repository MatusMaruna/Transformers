package symbolTable;

public class Symbol {
	private String id;
	private OfpType type;
	private String stringType;

	public Symbol() {
		super();
	}

	public Symbol(String id, OfpType type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Symbol(String id, String stringType) {
		super();
		this.id = id;
		this.stringType = stringType;
		this.type = OfpType.getType(stringType);
	}

	public String getId() {
		return id;
	}

	public OfpType getType() {
		return type;
	}

	public String getStringType() {
		return stringType;
	}

	@Override
	public String toString() {
		return "Record id: " + id + " Record type: " + type;
	}
}
