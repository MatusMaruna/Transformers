package symbolTable;

public enum OfpType {
    Int("int"), String("string"), IntArray("int[]"), Char("char"), Float("float"), Bool("bool"), FloatArray("float[]"),
    CharArray("char[]"), StringArray("string[]"), Undef("undef"), Void("void");

    private String value;

    OfpType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static OfpType getType(String type) {

        switch (type) {
            case "int":
                return OfpType.Int;
            case "int[]":
                return OfpType.IntArray;
            case "string":
                return OfpType.String;
            case "float":
                return OfpType.Float;
            case "float[]":
                return OfpType.FloatArray;
            case "char":
                return OfpType.Char;
            case "char[]":
                return OfpType.CharArray;
            case "string[]":
                return OfpType.StringArray;
            case "void":
                return OfpType.Void;
            case "bool":
                return OfpType.Bool;

            default:
                return null;
        }
    }

}
