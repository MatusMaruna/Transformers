
public enum OfpType {
	Int("int"), String("string"), IntArray("int[]"), Char("char"), Float("float"), Bool("bool"), FloatArray("float[]"),
	CharArray("char[]"), StringArray("string[]");

	private String value;

	OfpType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
