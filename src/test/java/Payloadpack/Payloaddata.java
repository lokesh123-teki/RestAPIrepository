package Payloadpack;

import java.util.ArrayList;
import java.util.List;

import pojoclasses.LocationSubClass;
import pojoclasses.MainPayLoad;

public class Payloaddata {
	
	public MainPayLoad addplacepay(String name, int accuracy, String phonenumber)
	{
		MainPayLoad mpl= new MainPayLoad();
		mpl.setAccuracy(accuracy);
		mpl.setName(name);
		mpl.setAddress("29, side layout, cohen 09");
		mpl.setPhone_number(phonenumber);
		mpl.setWebsite("http://google.com");
		mpl.setLanguage("French-IN");
		
		LocationSubClass lsc= new LocationSubClass();
		lsc.setLat(-38.383494);
		lsc.setLng(33.427362);
		mpl.setLocation(lsc);
		
		List<String> typeslist= new ArrayList<String>();
		typeslist.add("shoe park");
		typeslist.add("shop");
		mpl.setTypes(typeslist);
		return mpl;

	}
	public String deleteapipayload(String Placeid)
	{
		return "{\\r\\n    \\\"place_id\\\":\\\""+Placeid+"\\\"\\r\\n}\\r\\n";
	}

}
