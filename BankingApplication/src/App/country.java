package App;

public class country {
	
	private String countryName;
	private String flagPath;
	
	public country(String countryName, String flagPath) {
		super();
		this.countryName = countryName;
		this.flagPath = flagPath;
	}
	
	
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getFlagPath() {
		return flagPath;
	}

	public void setFlagPath(String flagPath) {
		this.flagPath = flagPath;
	}

}
