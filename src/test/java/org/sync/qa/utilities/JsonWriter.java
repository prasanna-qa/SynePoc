package org.sync.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.marshall.Json;
import org.apache.juneau.serializer.SerializeException;
import org.sync.qa.pojo.Crdentials;
import org.sync.qa.pojo.It;
import org.sync.qa.pojo.Prod;
import org.sync.qa.pojo.Root;
import org.sync.qa.pojo.Uat;
import org.testng.reporters.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class JsonWriter {

	
	public static void main(String[] args) throws IOException, SerializeException {
		It it=new It("prasay@jj.com", "efd");
		Uat uat=new Uat("prasay@jj.com", "efd");
		Prod prod=new Prod("prasay@jj.com", "efd");
		
		Crdentials c=new Crdentials(it, uat, prod);
		Root creds=new Root(c);
		ObjectMapper as=new ObjectMapper();
		
		/*
		 * JsonSerializer jsonSerializer=JsonSerializer.DEFAULT_READABLE; String
		 * a=jsonSerializer.serialize(creds);
		 */
		//Files.writeFile(a, new File(
			//	System.getProperty("user.dir") + "\\src\\test\\java\\org\\sync\\qa\\resources\\credsWrite.json"));
Files.writeFile(as.writerWithDefaultPrettyPrinter().writeValueAsString(creds), new File(
		System.getProperty("user.dir") + "\\src\\test\\java\\org\\sync\\qa\\resources\\credsWrite.json"));
	//	System.out.println(a);

	}
}
