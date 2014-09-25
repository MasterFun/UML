package application;

public class Package extends Typ {

	private static final long serialVersionUID = 2813571070057337926L;

	public Package(String name, String stereotyp, String parentName) {

		super.setName(name);
		super.setStereotyp(stereotyp);
		super.setType("Package");
		super.setParentName(parentName);
	}

}
