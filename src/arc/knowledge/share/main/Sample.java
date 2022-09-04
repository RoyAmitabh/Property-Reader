package arc.knowledge.share.main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import arc.knowledge.share.reader.PropReader;

public class Sample {

	public static void main(String[] args) throws IOException, URISyntaxException {
		PropReader propReader = new PropReader("/app.properties",true);
		System.out.println(propReader.get("key"));
		System.out.println(propReader.get("code"));

		PropReader propReader3 = new PropReader("D:/MyCode/Property-Reader/src/app.properties",false);
		System.out.println(propReader.get("key"));
		System.out.println(propReader.get("code"));
		
		PropReader propReader2 = new PropReader(new URI("file:///D:/MyCode/Property-Reader/src/app.properties"));
		System.out.println(propReader.get("key"));
		System.out.println(propReader.get("code"));

	}
}
