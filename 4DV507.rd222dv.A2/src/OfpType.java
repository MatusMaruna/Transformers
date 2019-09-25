
public class OfpType {
	
	public static final OfpType intType = new OfpType("int");
	public static final OfpType intArrType = new OfpType("int[]");
	
	public static final OfpType argsType = new OfpType("String[]");
	
	public static OfpType getTypeFor(String typeName) {
		return null;
		
	}
	
	private final String name;
	
	private OfpType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
