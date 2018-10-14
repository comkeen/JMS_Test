package main;

public enum LocationType {
	GU("구"),
	DONG("동");
	
	public String postfix;
	
	LocationType(String postfix) {
		this.postfix = postfix;
	}
}
