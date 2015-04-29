package demo;

enum Country {
	CANADA("CA"),
	USA("US"),
	OTHER("");
	final String isoName;
	private Country(String isoName) {
		this.isoName = isoName;
	}
}