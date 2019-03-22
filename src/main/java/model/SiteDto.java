package model;

public class SiteDto {
	
	
	public void setAudience(String audience) {
		this.audience = audience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private String audience;
	private String name;
	private String site_url;
	
	public String getSite_url() {
		return site_url;
	}
	public void setSite_url(String site_url) {
		this.site_url = site_url;
	}
	public String getAudience() {
		return audience;
	}
}
