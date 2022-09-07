package Utilspack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification res;
	public RequestSpecification utilsdata() throws IOException
	{
		if(res==null)
		{
		PrintStream p= new PrintStream(new FileOutputStream("Logging.txt"));
		res = new RequestSpecBuilder().setBaseUri(getProperties("baseuri"))
				.addQueryParam("key", "qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(p)).
				addFilter(ResponseLoggingFilter.logResponseTo(p)).setContentType(ContentType.JSON).build();
		return res;
		}
		else
		{
			return res;
		}
	}
	public static String getProperties(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("D:\\RestApiE2EFramework\\src\\test\\java\\Utilspack\\parameters.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String getPlaceapi(Response response, String key)
	{
		String rou1=response.asString();
		JsonPath js= new JsonPath(rou1);
		String value= js.get(key);
		return value;
	}

}
