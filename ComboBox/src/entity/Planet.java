package entity;

public class Planet {

	public String code;
	private String name;

	public Planet(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Planet() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
