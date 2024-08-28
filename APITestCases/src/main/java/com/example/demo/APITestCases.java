package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class APITestCases {

    private static final String API_URL = "https://bfhldevapigw.healthrx.co.in/automation-campus/create/user";

    public static void main(String[] args) {
        APITestCases apiTestCases = new APITestCases();

        apiTestCases.testValidUserCreation();

        apiTestCases.testUserCreationWithoutRollNumber();

        apiTestCases.testUserCreationWithDuplicatePhoneNumber();

        apiTestCases.testUserCreationWithInvalidEmail();
    }

    public void testValidUserCreation() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("roll-number", "1");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstName", "John");
        requestBody.put("lastName", "Doe");
        requestBody.put("phoneNumber", 9876543210L);
        requestBody.put("emailld", "john.doe@example.com");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
            System.out.println("Valid User Creation Test: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Error in Valid User Creation Test: " + e.getMessage());
        }
    }

    public void testUserCreationWithoutRollNumber() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstName", "Jane");
        requestBody.put("lastName", "Doe");
        requestBody.put("phoneNumber", 9876543211L);
        requestBody.put("emailld", "jane.doe@example.com");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
            System.out.println("User Creation Without Roll Number Test: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Error in User Creation Without Roll Number Test: " + e.getMessage());
        }
    }

    public void testUserCreationWithDuplicatePhoneNumber() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("roll-number", "1");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstName", "Alice");
        requestBody.put("lastName", "Smith");
        requestBody.put("phoneNumber", 9876543210L); // Duplicate phone number
        requestBody.put("emailld", "alice.smith@example.com");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
            System.out.println("User Creation with Duplicate Phone Number Test: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Error in User Creation with Duplicate Phone Number Test: " + e.getMessage());
        }
    }

    public void testUserCreationWithInvalidEmail() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("roll-number", "1");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstName", "Chris");
        requestBody.put("lastName", "Johnson");
        requestBody.put("phoneNumber", 9876543212L);
        requestBody.put("emailld", "invalid-email"); 

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
            System.out.println("User Creation with Invalid Email Test: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Error in User Creation with Invalid Email Test: " + e.getMessage());
        }
    }
}