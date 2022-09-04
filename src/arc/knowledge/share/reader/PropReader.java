package arc.knowledge.share.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropReader extends Properties{

	
	private static final long serialVersionUID = -3138653124623686628L;
	
	public PropReader(URI resourceUrl) throws IOException {
		readAbsolute(resourceUrl);
	}
	
	public PropReader(String resourceFile, boolean isPresentInClassPath) throws IOException, URISyntaxException {
		if(isPresentInClassPath) {
			InputStream inStream = this.getClass().getResourceAsStream(resourceFile);
			this.load(inStream);
		}else {
			String path = "file:///" + resourceFile;
			readAbsolute(new URI(path));
		}
		
	}
	
	private void readAbsolute(URI resourceUrl) throws IOException {
		Path filePath = Paths.get(resourceUrl);
		Reader fileReader = Files.newBufferedReader(filePath);
		this.load(fileReader);
	}
	
}
