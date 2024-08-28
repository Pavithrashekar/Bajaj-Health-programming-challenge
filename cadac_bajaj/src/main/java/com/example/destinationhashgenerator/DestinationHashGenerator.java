package com.example.destinationhashgenerator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class DestinationHashGenerator {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar DestinationHashGenerator.jar <PRN Number> <path to JSON file>");
            System.exit(1);
        }

        String prnNumber = args[0];
        String jsonFilePath = args[1];

        try {
           
            JSONObject jsonObject = new JSONObject(new JSONTokener(new FileInputStream(jsonFilePath)));

            
            String destinationValue = findDestinationValue(jsonObject);

            
            String randomString = generateRandomString(8);

            
            String concatenatedString = prnNumber + destinationValue + randomString;

            
            String md5Hash = generateMD5Hash(concatenatedString);

            
            System.out.println(md5Hash + ";" + randomString);

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            System.exit(1);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm not found: " + e.getMessage());
            System.exit(1);
        }
    }

    private static String findDestinationValue(JSONObject jsonObject) {
        // Traverse JSON to find the "destination" key
        if (jsonObject.has("destination")) {
            return jsonObject.getString("destination");
        }
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                String result = findDestinationValue((JSONObject) value);
                if (result != null) {
                    return result;
                }
            } else if (value instanceof JSONArray) {
                for (Object item : (JSONArray) value) {
                    if (item instanceof JSONObject) {
                        String result = findDestinationValue((JSONObject) item);
                        if (result != null) {
                            return result;
                        }
                    }
                }
            }
        }
        return "";
    }

    private static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    private static String generateMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
