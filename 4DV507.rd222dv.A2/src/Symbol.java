
public class Symbol {
	private String id;
	private String type;
	
    /*private final OfpType type;

	public Symbol(String name, OfpType type) {
		this.name = name;
		this.type = type;
	}
	
	public OfpType getType() {
		return type;
	} */
	
	public Symbol() {
		super();
	}
	
	public Symbol(String id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Record id: " + id + " Record type: " + type;
	}
}
