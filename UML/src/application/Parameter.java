package application;

import java.io.Serializable;

public class Parameter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7542368083375120190L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	private String typ;
	
	
}
