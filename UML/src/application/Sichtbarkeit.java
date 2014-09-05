package application;

public enum Sichtbarkeit {
	PUBLIC("public"), PRIVATE("private"), PROTECTED("protected");
	
	private String sichtbar;

	private Sichtbarkeit(String sichtbar) {
		this.sichtbar = sichtbar;
	}
	
}
