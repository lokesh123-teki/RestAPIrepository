package Utilspack;

public enum Enumclass {
	
	AddplaceAPI("/maps/api/place/add/json"),
	DeleteplaceAPI("maps/api/place/delete/json"),
	GetplaceAPI("/maps/api/place/get/json");
	
	private String resource;

	Enumclass(String resource){
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
