package stepDefinitionfiles;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlaceAPI")
	public void hooksmethods() throws Throwable
	{
		
		addPlaceapistepdef a= new addPlaceapistepdef();
		if(addPlaceapistepdef.place_id_value==null)
		{
		a.add_place_payload_("sai", 70, "Indianaya");
		a.user_calls_something_with_something_http_request("AddplaceAPI", "POST");
		a.verify_something_using_something("sai", "GetplaceAPI");
		}
	}

}
