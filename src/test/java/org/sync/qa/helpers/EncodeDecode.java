package org.sync.qa.helpers;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.sync.qa.base.TestBase;


public class EncodeDecode extends TestBase{

	private static byte[] encodedBytes;
	private static byte[] decodedBytes;
	private static String passwrd = "";
	
	public EncodeDecode() throws IOException {
		super();
		}

	public static String decodePasswrod(String Encrypted) {
		decodedBytes = Base64.decodeBase64(Encrypted);
		return new String(decodedBytes);
	}

	public static void main(String[] args) throws IOException {
		encodedBytes = Base64.encodeBase64(passwrd.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
	}
}
