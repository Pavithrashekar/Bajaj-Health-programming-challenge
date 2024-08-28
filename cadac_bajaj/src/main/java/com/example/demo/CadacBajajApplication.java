package com.example.demo;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class CadacBajajApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(CadacBajajApplication.class, args);
//	}
//
//}

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@SpringBootApplication
public class CadacBajajApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadacBajajApplication.class, args);
    }
}
/*
 * @Component class CommandLineAppStartupRunner implements CommandLineRunner {
 * 
 * @Override public void run(String... args) throws Exception { if (args.length
 * < 2) { System.err.
 * println("Usage: java -jar cadac_bajaj-0.0.1-SNAPSHOT.jar <PRN Number> <path to JSON file>"
 * ); System.exit(1); }
 * 
 * String prnNumber = args[0]; String jsonFilePath = args[1];
 * 
 * // Read and parse the JSON file JSONObject jsonObject = new JSONObject(new
 * JSONTokener(new FileInputStream(jsonFilePath)));
 * 
 * // Traverse JSON to find the "destination" key String destinationValue =
 * findDestinationValue(jsonObject);
 * 
 * // Generate a random 8-character alphanumeric string String randomString =
 * generateRandomString(8);
 * 
 * // Concatenate PRN Number, destination value, and random string String
 * concatenatedString = prnNumber + destinationValue + randomString;
 * 
 * // Generate MD5 hash of the concatenated string String md5Hash =
 * generateMD5Hash(concatenatedString);
 * 
 * // Print the result in the required format System.out.println(md5Hash + ";" +
 * randomString); }
 * 
 * private String findDestinationValue(JSONObject jsonObject) { // Traverse JSON
 * to find the "destination" key if (jsonObject.has("destination")) { return
 * jsonObject.getString("destination"); } for (String key : jsonObject.keySet())
 * { Object value = jsonObject.get(key); if (value instanceof JSONObject) {
 * String result = findDestinationValue((JSONObject) value); if (result != null)
 * { return result; } } else if (value instanceof JSONArray) { for (Object item
 * : (JSONArray) value) { if (item instanceof JSONObject) { String result =
 * findDestinationValue((JSONObject) item); if (result != null) { return result;
 * } } } } } return ""; }
 * 
 * private String generateRandomString(int length) { String characters =
 * "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; Random
 * random = new Random(); StringBuilder sb = new StringBuilder(length); for (int
 * i = 0; i < length; i++) { int index = random.nextInt(characters.length());
 * sb.append(characters.charAt(index)); } return sb.toString(); }
 * 
 * private String generateMD5Hash(String input) throws NoSuchAlgorithmException
 * { MessageDigest md = MessageDigest.getInstance("MD5"); byte[] digest =
 * md.digest(input.getBytes()); StringBuilder sb = new StringBuilder(); for
 * (byte b : digest) { sb.append(String.format("%02x", b)); } return
 * sb.toString(); } }
 */