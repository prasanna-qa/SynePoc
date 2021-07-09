package org.sync.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.juneau.json.JsonParser;
import org.sync.qa.pojo.Root;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CredentialJsonReader {
	private static Root root;

	public static Root getRoot() {
		return root;
	}

	public static void setRoot() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		root = objMapper.readValue(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\org\\sync\\qa\\resources\\creds.json"),
				Root.class);
		
		JsonParser parser=JsonParser.DEFAULT;
		//parser.pars
	}

}
