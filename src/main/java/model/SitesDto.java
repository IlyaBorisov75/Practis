package model;

import java.util.List;

public class SitesDto {
	public List<SiteDto> getItems() {
		return items;
	}

	public void setItems(List<SiteDto> items) {
		this.items = items;
	}

	private List<SiteDto> items;
}
