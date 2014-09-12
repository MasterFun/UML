package application;

public enum Datentyp {
	BOOLEAN("boolean"), BYTE("byte"), CHAR("char"), DOUBLE("double"), FLOAT("float"), INT("int"), LONG("long"), SHORT("short"), STRING("String");
	
	private String datentyp;
	
	private Datentyp(String datentyp) {
		this.datentyp = datentyp;
	}	
	
}
